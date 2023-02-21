package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.PilaEstatica;

public class PruebaPila {
    public static void main(String[] args) {
        PilaEstatica pila = new PilaEstatica(4);

        pila.poner("A");
        pila.poner("S");
        pila.poner("B");
        pila.poner("R");

        pila.imprimir();

        SalidaPorDefecto.terminal("Eliminando: "+pila.quitar()+"\n");

        pila.imprimir();

        SalidaPorDefecto.terminal("Viendo el tope: "+pila.verTope()+"\n");
    }
}
