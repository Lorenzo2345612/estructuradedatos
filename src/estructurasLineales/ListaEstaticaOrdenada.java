package estructurasLineales;

import entradasalida.SalidaPorDefecto;
import utilerias.comunes.SeleccionRandom;
import utilerias.comunes.TipoOrden;
import utilerias.comunes.Comparador;

/**
 * Clase que Modela una lista ordenada.
 * @author Lorenzo Trujillo Rojas.
 * @version 1.0
 */
public class ListaEstaticaOrdenada extends ListaEstatica{
    TipoOrden orden;

    /**
     * Constructor de la clase estatica ordenada.
     * @param tamanio Es el tamaño de la lista.
     * @param orden Es la direccion del ordenamiento.
     */
    public ListaEstaticaOrdenada(int tamanio, TipoOrden orden) {
        super(tamanio);
        this.orden = orden;
    }

    /**
     * Metodo que obtiene la direccion del orden.
     * @return Regresa la direccion del orden.
     */
    public TipoOrden getOrden() {
        return orden;
    }

    /**
     * Metodo que agrega un objeto.
     * @param info Es el nuevo valor a añadir.
     * @return Regresa la posicion en la que se agrego.
     */
    @Override
    public int agregar(Object info){
        if(llena())return -1;
        Integer indiceObjetoBuscadoMapeado=(Integer) buscar(info);
        if(indiceObjetoBuscadoMapeado==null)return -1;
        if(indiceObjetoBuscadoMapeado>0)return -1;
        if(indiceObjetoBuscadoMapeado/-1==cantidad()+1){
            tope++;
            informacion[tope]=info;
            return tope;
        }
        int indiceObjeto = (indiceObjetoBuscadoMapeado/-1)-1;
        for (int indiceActual = tope; indiceActual >= indiceObjeto; indiceActual--) {
            informacion[indiceActual+1]=informacion[indiceActual];
        }
        informacion[indiceObjeto]=info;
        tope++;
        return indiceObjeto;
    }

    /**
     *
     * @param lista2 Es la lista que debemos agregar.
     * @return
     */
    @Override
    public boolean agregarLista(Object lista2) {
        if (!(lista2 instanceof ListaEstaticaOrdenada))return false;
        if (!((ListaEstaticaOrdenada) lista2).getOrden().equals(this.getOrden()))return false;

        ListaEstaticaOrdenada listaAAgregar=(ListaEstaticaOrdenada) lista2;

        for (int indiceLista2 = 0; indiceLista2 < listaAAgregar.cantidad(); indiceLista2++) {
            agregar(listaAAgregar.obtener(indiceLista2));
        }
        return true;
    }

    @Override
    public Object buscar(Object info){
        if(vacia())return -1;
        if(Comparador.comparador(info,obtener(0))==null)return null;
        Integer posicion = 0;
        if (esIncremental()){
            while (posicion<cantidad() && Comparador.comparador(info,obtener(posicion))==+1){
                posicion++;
            }
            if (posicion<cantidad()){
                return Comparador.comparador(info,obtener(posicion))==0? posicion+1 : (posicion+1)*-1;
            }
            return (cantidad()+1)*-1;
        }else{
            while (posicion<cantidad() && Comparador.comparador(info,obtener(posicion))==-1){
                posicion++;
            }
            if (posicion<cantidad()){
                return Comparador.comparador(info,obtener(posicion))==0? posicion+1 : (posicion+1)*-1;
            }
            return (cantidad()+1)*-1;
        }


    }

    @Override
    public boolean cambiar(int indice, Object info){
        if ((Integer) buscar(info)>0)return false;
        Object eliminado = eliminar(indice);
        if (eliminado==null)return false;
        if (agregar(info)==-1){
            agregar(eliminado);
            return false;
        }
        return true;
    }

    @Override
    public boolean cambiar(Object infoViejo, Object infoNuevo, int numVeces) {
        numVeces=1;
        Object elementoBuscado = buscar(infoViejo);
        if(elementoBuscado==null || (int) elementoBuscado<0)return false;
        return cambiar(((int) elementoBuscado)-1,infoNuevo);
    }

    @Override
    public Object eliminar(Object info) {
        int posicion=(int) super.buscar(info);
        if(posicion!=-1){
            return eliminar(posicion);
        }
        return null;
    }

    @Override
    public void invertir() {
        super.invertir();
        if(esIncremental()){
            orden=TipoOrden.DEC;
        }else{
            orden=TipoOrden.INC;
        }
    }

    @Override
    public void rellenar(Object info) {
        vaciar();
        if(info instanceof Character){
            int codigoAscii=(int) ((char)info);
            for (int iteracion = 0; iteracion < maximo(); iteracion++) {
                agregar((char) codigoAscii);
                codigoAscii-=1;
            }
            return;
        }
        if (info instanceof Number) {
            int dato = (int) info;
            if (dato<0){
                for (int iteracion = 0; iteracion < maximo(); iteracion++) {
                    agregar(dato+iteracion);
                }
                return;
            }
            for (int iteracion = 0; iteracion < maximo(); iteracion++) {
                agregar(dato-iteracion);
            }
            return;

        }
        agregar(info);

    }

    /**
     * Metodo que indica si lista2 es una sublista.
     * @param lista2 Lista para comparar.
     * @return Regresa true si es sublista y false si no.
     */
    public boolean esSublista(Lista lista2){
        if(!(lista2 instanceof ListaEstaticaOrdenada))return false;
        if(((ListaEstaticaOrdenada) lista2).cantidad()>this.cantidad())return false;
        ListaEstaticaOrdenada listaSubconjunto = (ListaEstaticaOrdenada) lista2;
        for (int indiceListaActual = 0; indiceListaActual < cantidad(); indiceListaActual++) {
            int posicionListaSubconjunto =0;
            while( (indiceListaActual+posicionListaSubconjunto)<cantidad() &&
                    posicionListaSubconjunto<listaSubconjunto.cantidad() &&
                    obtener(indiceListaActual+posicionListaSubconjunto).toString().equals(listaSubconjunto.obtener(posicionListaSubconjunto).toString())){
                posicionListaSubconjunto++;
            }
            if (posicionListaSubconjunto==listaSubconjunto.cantidad()){
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que cambia los elementos de una lista2 por los de lista2Nuevos
     * @param lista2 Es la lista de elementos a buscar.
     * @param lista2Nuevos Es la lista de los valores nuevos.
     * @return Regresa true si fue posible o false si no.
     */
    public boolean cambiarLista(Lista lista2, Lista lista2Nuevos){
        if (!(lista2 instanceof ListaEstaticaOrdenada) || !(lista2Nuevos instanceof ListaEstaticaOrdenada))return false;
        if (((ListaEstaticaOrdenada) lista2).cantidad() != ((ListaEstaticaOrdenada) lista2Nuevos).cantidad())return false;
        ListaEstatica listaValoresViejos=(ListaEstaticaOrdenada) lista2;
        ListaEstatica listaValoresNuevos=(ListaEstaticaOrdenada) lista2Nuevos;
        for (int indiceLista2 = 0; indiceLista2 < listaValoresViejos.cantidad(); indiceLista2++) {
            cambiar(listaValoresViejos.obtener(indiceLista2),listaValoresNuevos.obtener(indiceLista2),1);
        }
        return true;
    }

    /**
     * Metodo que solo deja los elementos que estan en la lista2
     * @param lista2 Son los elementos que vamos a retener.
     * @return Regresa true si se pudo realizar el proceso y false si no.
     */
    public boolean retenerLista(Lista lista2){
        if(!(lista2 instanceof ListaEstaticaOrdenada))return false;
        ListaEstaticaOrdenada listaARetener = (ListaEstaticaOrdenada) lista2;
        int posicion=0;
        while(posicion<cantidad()){
            if((Integer)listaARetener.buscar(obtener(posicion))<0){
                eliminar(posicion);
            }else{
                posicion++;
            }
        }
        return true;
    }

    @Override
    public boolean insertar(int indice, Object info){
        if(llena())return false;
        if(!validarRango(indice))return false;
        if(agregar(info)==-1)return false;
        return true;
    }

    @Override
    public boolean copiarLista(Lista lista2) {
        if (!(lista2 instanceof ListaEstaticaOrdenada))return false;
        if (((ListaEstaticaOrdenada) lista2).cantidad()!=cantidad())return false;
        if (!((ListaEstaticaOrdenada) lista2).getOrden().equals(getOrden()))return false;
        vaciar();
        for (int indiceActual = 0; indiceActual < cantidad(); indiceActual++) {
            agregar(((ListaEstatica) lista2).informacion[indiceActual]);
        }
        return true;
    }

    /**
     * Metodo que regresa una lista estatica desordenada.
     * @return Regresa una lista desordenada.
     */
    public ListaEstatica arregloDesordenado(){
        ListaEstatica arregloDesordenado = new ListaEstatica(cantidad());
        ListaEstaticaOrdenada elementosARegresar = new ListaEstaticaOrdenada(this.maximo(), getOrden());
        while(cantidad()>0){
            Object eliminado = this.eliminar(SeleccionRandom.enteroRandom(cantidad(),0));
            arregloDesordenado.agregar(eliminado);
            elementosARegresar.agregar(eliminado);
        }
        agregarLista(elementosARegresar);
        return arregloDesordenado;
    }

    /**
     * Metodo que indica la direccion del ordenamiento.
     * @return Regresa true si es incremental y false si no.
     */
    private boolean esIncremental(){
        return switch (orden){
            case INC -> true;
            case DEC -> false;
        };
    }


}
