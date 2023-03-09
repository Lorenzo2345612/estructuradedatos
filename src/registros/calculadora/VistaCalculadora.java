package registros.calculadora;

import entradasalida.EntradaPorDefecto;
import entradasalida.SalidaPorDefecto;

/**
 * Clase que contiene los metodos para interactuar con el usuario.
 * @author Lorenzo Trujillo Rojas.
 * @version 1.0
 */
public class VistaCalculadora {
    /**
     * Metodo que pregunta la operacion a resolver.
     */
    public static void mensajeIngresaLaExpresionAResolver(){
        SalidaPorDefecto.terminal("Ingresa la operacion a resolver (ingresa 0 para terminar el programa):\n");
    }

    /**
     * Metodo que imprime el mensaje del resultado.
     */
    public static void imprimirMensajeRespuesta(Double resultado){
        SalidaPorDefecto.terminal("El resultado de la operacion es: "+resultado+"\n");
    }

    /**
     * Metodo que obtiene el valor de una variable.
     * @param nombreVariable Representa el nombre de
     *                       la variable a obtener.
     */
    public static void obtenerValorVariable(String nombreVariable){
        SalidaPorDefecto.terminal("Ingresa el valor de la variable "+nombreVariable+":\n");
    }

}
