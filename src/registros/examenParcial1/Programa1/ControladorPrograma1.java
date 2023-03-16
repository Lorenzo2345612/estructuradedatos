package registros.examenParcial1.Programa1;

import entradasalida.EntradaPorDefecto;
import entradasalida.archivos.ArchivoTexto;
import estructurasLineales.ColaEstatica;
import estructurasLineales.ListaEstatica;
import utilerias.comunes.ValidadorExpresiones;

/**
 * Clase que controla las funciones del Programa 1
 * @author Lorenzo Trujillo Rojas
 * @version 1.0
 */
public class ControladorPrograma1 {
    /**
     * Representa la vista a usar.
     */
    private VistaPrograma1 vista;
    public ControladorPrograma1(){
        vista = new VistaPrograma1();
    }

    /**
     * Metodo que inicia el programa.
     */
    public void iniciarPrograma(){
        boolean flag=true;
        do{
            vista.imprimirMenuPrincipal();
            int opcion = Integer.parseInt(EntradaPorDefecto.consolaCadenas());
            switch (opcion){
                case 1: opcionLeerArchivo();
                        break;
                case 2: opcionLeerExpresion();
                    break;
                case 0: flag=false;
                        break;
                default: vista.ingresaOpcionValida();
            }
        }while (flag);
    }

    /**
     * Metodo que controla la opcion de leer un archivo.
     */
    private void opcionLeerArchivo() {
        vista.imprimirMensajeIngresaRutaArchivo();
        String ruta = EntradaPorDefecto.consolaCadenas();

        try {
            ListaEstatica listaLineas = ArchivoTexto.leer(ruta);
            ColaEstatica colaErrores=ValidadorExpresiones.validadorExpresiones(listaLineas, cantidad(listaLineas), false);
            vista.imprimirErroresEnLineasCodigo(listaLineas, colaErrores);
        }catch (Exception e){
            vista.imprimirMensajeIngresaRutaValida();
        }

    }

    /**
     * Metodo que controla la opcion de validar una expresion matematica.
     */
    private void opcionLeerExpresion() {
        vista.imprimirMensajeIngresaExpresionMatematica();
        String expresion = EntradaPorDefecto.consolaCadenas();
        ListaEstatica lista = new ListaEstatica(1);
        lista.agregar(expresion);
        ColaEstatica colaErrores=ValidadorExpresiones.validadorExpresiones(lista, cantidad(lista),true);
        vista.imprimirErroresExpresionMatematica(colaErrores, lista);
    }

    /**
     * Metodo que indica la cantidad de caracteres de una expresion.
     * @param lista Representa la lista de lineas.
     * @return Regresa la cantidad de caracteres.
     */
    private int cantidad(ListaEstatica lista){
        int resultado =0;
        for (int iterador = 0; iterador < lista.cantidad(); iterador++) {
            String listaPrevia = (String) lista.obtener(iterador);
            resultado +=listaPrevia.length();
        }
        return resultado;
    }
}
