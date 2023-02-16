package registros.indiceDeTerminos;

import entradasalida.EntradaPorDefecto;
import estructurasLineales.ListaEstaticaOrdenada;
import utilerias.comunes.Comparador;
import utilerias.comunes.TipoOrden;

/**
 * Clase que controla los terminos que se han agregado al indice.
 * @author Lorenzo Trujillo Rojas.
 * @version 1.0
 */
public class Controlador {
    ListaEstaticaOrdenada terminos;
    Menu menu = new Menu();

    /**
     * Constructor de la clase Controlador
     * @param terminos Son los terminos que contenera el indice.
     */
    public Controlador(ListaEstaticaOrdenada terminos) {
        this.terminos = terminos;
        iniciarSistema();
    }

    /**
     * Constructor de la clase Controlador
     * @param tamanio Es la cantidad predefinida de terminos que tendremos.
     */
    public Controlador(int tamanio) {
        this.terminos = new ListaEstaticaOrdenada(tamanio,TipoOrden.INC);
        iniciarSistema();
    }

    /**
     * Funcion que controla las opciones del menu.
     */
    private void iniciarSistema(){
        boolean flag = true;
        int entrada=0;
        while (flag){
            menu.menu();
            entrada=Integer.parseInt(EntradaPorDefecto.consolaCadenas());

            switch (entrada){
                case 0: flag=false;
                        break;
                case 1: if(terminos.agregar(agregarTermino())==-1){
                    menu.errorNoSeAgrego();
                }else {
                    menu.seAgrego();
                }
                        break;
                case 2: consultarTermino();
                        break;

                case 3: consultarSubtermino();
                        break;

                case 4: consultarTerminosYSubterminos();
                        break;

                case 5: consultarTerminosPorRango();
                        break;
            }
        }
    }

    /**
     * Funcion que agrega un termino al indice.
     * @return Regresa el termino que se va a agregar.
     */
    private Termino agregarTermino(){
        menu.mensajeIngresaNombre();
        String nombre = EntradaPorDefecto.consolaCadenas();

        menu.ingresaLacantidadDePaginas();
        int catidadPaginas= Integer.parseInt(EntradaPorDefecto.consolaCadenas());
        ListaEstaticaOrdenada listaPaginas = obtenerListaPaginas(catidadPaginas);

        int respuesta=0;
        while(respuesta!=1 && respuesta!=2){
            menu.preguntaTieneSubterminos(nombre);
            respuesta=Integer.parseInt(EntradaPorDefecto.consolaCadenas());
        }
        ListaEstaticaOrdenada subterminosTermino;
        if (respuesta==1){
            menu.ingresaLaCantidadDeSubterminos(nombre);
            int numSubterminos = Integer.parseInt(EntradaPorDefecto.consolaCadenas());
            subterminosTermino = new ListaEstaticaOrdenada(numSubterminos,TipoOrden.INC);
            for (int numSubtermino = 0; numSubtermino < numSubterminos; numSubtermino++) {
                subterminosTermino.agregar(agregarTermino());
            }
        }else{
            subterminosTermino = new ListaEstaticaOrdenada(0,TipoOrden.INC);
        }

        return new Termino(nombre,subterminosTermino,listaPaginas);
    }

    /**
     * Obtiene las paginas que abarcara un termino en especifico.
     * @param cantidadPaginas Cantidad de paginas a solicitar.
     * @return Regresa una listaOrdenada con las paginas o rangos que tiene el termino.
     */
    private ListaEstaticaOrdenada obtenerListaPaginas(int cantidadPaginas){
        ListaEstaticaOrdenada listaPaginas = new ListaEstaticaOrdenada(cantidadPaginas,TipoOrden.INC);

        for (int indice = 0; indice < cantidadPaginas; indice++) {
            menu.ingresaPagina();
            listaPaginas.agregar(EntradaPorDefecto.consolaCadenas());
        }

        return listaPaginas;
    }

    /**
     * Imprime la informacion de un termino.
     */
    private void consultarTermino(){
        menu.imprimirTerminos(terminos);
        int numeroTermino = Integer.parseInt(EntradaPorDefecto.consolaCadenas())-1;
        ((Termino)terminos.obtener(numeroTermino)).imprimirTermino();
    }

    /**
     * Imprime la informacion de un subtermino.
     */
    private void consultarSubtermino(){
        menu.imprimirTerminos(terminos);
        int numeroTermino = Integer.parseInt(EntradaPorDefecto.consolaCadenas())-1;
        ListaEstaticaOrdenada subterminos = ((Termino)terminos.obtener(numeroTermino)).getListaSubterminos();
        if(subterminos.vacia()){
            menu.errorNoTieneSub();
            return;
        }
        menu.imprimirTerminos(subterminos);
        int numeroSubtermino = Integer.parseInt(EntradaPorDefecto.consolaCadenas())-1;
        ((Termino)terminos.obtener(numeroTermino)).obtenerSubterminoPorIndice(numeroSubtermino).imprimirTermino();
    }

    /**
     * Imprime todos los terminos y subterminos.
     */
    private void consultarTerminosYSubterminos(){
        for (int indiceTermino = 0; indiceTermino < terminos.cantidad(); indiceTermino++) {
            ((Termino) terminos.obtener(indiceTermino)).imprimirTermino();
        }
    }

    /**
     * Consulta los terminos por rango.
     */
    private void consultarTerminosPorRango(){
        menu.pedirLetraSuperior();
        String limiteSuperior = EntradaPorDefecto.consolaCadenas();
        menu.pedirLetraInferior();
        String limiteInferior = EntradaPorDefecto.consolaCadenas();
        if (Comparador.comparador(limiteInferior,limiteSuperior)<=0){
            String procesando;
            for (int indiceActual = 0; indiceActual < terminos.cantidad(); indiceActual++) {
                procesando = String.valueOf(((Termino) terminos.obtener(indiceActual)).getNombre().charAt(0));
                if (Comparador.comparador(procesando,limiteSuperior)>0){
                    break;
                }
                if (Comparador.comparador(procesando,limiteInferior)>=0){
                    ((Termino) terminos.obtener(indiceActual)).imprimirTermino();
                }
            }
        }
    }


}
