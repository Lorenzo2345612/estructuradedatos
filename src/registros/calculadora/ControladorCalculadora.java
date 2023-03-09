package registros.calculadora;

import entradasalida.EntradaPorDefecto;
import estructurasLineales.ColaEstatica;
import utilerias.matematicas.ExpresionesMatematicas;

/**
 * Clase que reune las funciones para controlar la calculadora.
 * @author Lorenzo Trujillo Rojas.
 * @version 1.0
 */
public class ControladorCalculadora {
    public ControladorCalculadora() {
        iniciarAplicacion();
    }

    /**
     * Metodo que controla la calculadora.
     */
    private void iniciarAplicacion() {
        do {
            VistaCalculadora.mensajeIngresaLaExpresionAResolver();
            String expresionInfija = EntradaPorDefecto.consolaCadenas();
            if (expresionInfija.equals("0"))break;
            ColaEstatica expresionPostfija = ExpresionesMatematicas.infijaAPostFija(expresionInfija);
            Double resultado = ExpresionesMatematicas.evaluarPostFija(expresionPostfija,expresionInfija.length());
            VistaCalculadora.imprimirMensajeRespuesta(resultado);
        }while (true);
    }


}
