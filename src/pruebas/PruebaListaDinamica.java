package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaDinamica;

public class PruebaListaDinamica {
    public static void main(String[] args) {
        ListaDinamica lista = new ListaDinamica();
        lista.agregar(1);
        lista.agregar(2);
        lista.agregar(3);
        lista.agregar(4);
        lista.agregar(5);

        lista.imprimir();

        SalidaPorDefecto.terminal("Eliminando: "+lista.eliminar()+".\n");

        lista.imprimir();

        SalidaPorDefecto.terminal("Eliminando: "+lista.eliminarInicio()+".\n");

        lista.imprimir();
        lista.eliminar(6);
        lista.imprimir();
    }
}
