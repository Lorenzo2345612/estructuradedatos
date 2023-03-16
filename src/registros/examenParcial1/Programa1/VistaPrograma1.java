package registros.examenParcial1.Programa1;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ColaEstatica;
import estructurasLineales.ListaEstatica;
import utilerias.comunes.TipoError;

/**
 * Clase que se encarga de renderizar la vista del Programa1
 * @author Lorenzo Trujillo Rojas
 * @version 1.0
 */
public class VistaPrograma1 {
    public VistaPrograma1(){

    }

    /**
     * Metodo que imprime el menu principal
     */
    public void imprimirMenuPrincipal(){
        SalidaPorDefecto.terminal("Seleccione la opcion que desea realizar:\n");
        SalidaPorDefecto.terminal("1 Ingresar ruta de archivo\n");
        SalidaPorDefecto.terminal("2 Ingresar expresion matematica\n");
        SalidaPorDefecto.terminal("0 Salir \n");
    }

    /**
     * Metodo que imprime un mensaje de error para una opcion invalida.
     */
    public void ingresaOpcionValida() {
        SalidaPorDefecto.terminal("Ingrese una opcion valida.\n");
    }

    /**
     * Metodo que imprime un mensaje de error para una ruta invalida.
     */
    public void imprimirMensajeIngresaRutaValida() {
        SalidaPorDefecto.terminal("Ingresa una ruta valida.\n");
    }

    /**
     * Metodo que imprime el mensaje para ingresar una ruta.
     */
    public void imprimirMensajeIngresaRutaArchivo() {
        SalidaPorDefecto.terminal("Ingresa la ruta del archivo:\n");
    }

    /**
     * Metodo que imprime los errores en las lineas de codigo.
     * @param listaLineas Representa las lineas del codigo.
     * @param colaErrores Representa la cola de errores que tiene el codigo.
     */
    public void imprimirErroresEnLineasCodigo(ListaEstatica listaLineas, ColaEstatica colaErrores) {
        if(colaErrores.vacio()){
            SalidaPorDefecto.terminal("Codigo sin errores\n");
            return;
        }

        while(!colaErrores.vacio()){
            ListaEstatica listaTemporal=(ListaEstatica) colaErrores.quitar();
            int lineaCodigo = ((Integer)listaTemporal.obtener(1))-1;
            int caracterLinea = ((Integer)listaTemporal.obtener(0))-1;
            TipoError tipo = (TipoError) listaTemporal.obtener(2);

            SalidaPorDefecto.terminal("Linea "+(lineaCodigo+1)+" "+(String) listaLineas.obtener(lineaCodigo)+"\n");
            for (int iterador = 0; iterador < caracterLinea+(lineaCodigo+"").length()+7; iterador++) {
                SalidaPorDefecto.terminal(" ");
            }
            SalidaPorDefecto.terminal("^ ");
            imprimirError(tipo);
        }
    }

    /**
     * Metodo que imprime los errores en una expresion matematica.
     * @param cola Representa la cola de errores.
     * @param listaLineas Representa la lista de lineas de la expresion.
     */
    public void imprimirErroresExpresionMatematica(ColaEstatica cola, ListaEstatica listaLineas){
        if(cola.vacio()){
            SalidaPorDefecto.terminal("Expresion sin errores\n");
            return;
        }

        while(!cola.vacio()){
            ListaEstatica listaTemporal=(ListaEstatica) cola.quitar();
            int lineaCodigo = ((Integer)listaTemporal.obtener(1))-1;
            int caracterLinea = ((Integer)listaTemporal.obtener(0))-1;
            TipoError tipo = (TipoError) listaTemporal.obtener(2);

            SalidaPorDefecto.terminal("Linea "+(lineaCodigo+1)+" "+(String) listaLineas.obtener(lineaCodigo)+"\n");
            for (int iterador = 0; iterador < caracterLinea+(lineaCodigo+"").length()+7; iterador++) {
                SalidaPorDefecto.terminal(" ");
            }
            SalidaPorDefecto.terminal("^ ");
            imprimirError(tipo);
        }
    }

    /**
     * Metodo que imprime errores especificos.
     * @param tipo Tipo de error.
     */
    private void imprimirError(TipoError tipo){
        switch (tipo){
            case ERROR_COMENTARIO_A -> SalidaPorDefecto.terminal("Falta cerrar el comentario **/\n");
            case ERROR_COMENTARIO_C -> SalidaPorDefecto.terminal("Falta abrir el comentario **/\n");
            case ERROR_PARENTESIS_A -> SalidaPorDefecto.terminal("Falta cerrar el parentesis\n");
            case ERROR_PARENTESIS_C -> SalidaPorDefecto.terminal("Falta abrir el parentesis\n");
            case ERROR_VARIABLE_MAL_DECLARADA -> SalidaPorDefecto.terminal("Variable mal declarada o no declarada\n");
            default -> SalidaPorDefecto.terminal("\n");
        }
    }

    /**
     * Metodo que imprime el mensaje para ingresar una expresion matematica.
     */
    public void imprimirMensajeIngresaExpresionMatematica() {
        SalidaPorDefecto.terminal("Ingresa la expresion matematica a validar:\n");
    }
}
