package pruebas;

import estructurasLineales.ListaDinamica;
import estructurasLineales.ListaDinamicaDoble;

public class PruebaListaDinamicaDoble {
    public static void main(String[] args) {
        ListaDinamicaDoble lista = new ListaDinamicaDoble();
        lista.agregar(1);
        lista.agregar(2);
        lista.agregar(3);
        lista.agregar(4);
        lista.agregar(5);
        lista.imprimir();
    }
}
