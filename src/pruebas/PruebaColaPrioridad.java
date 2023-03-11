package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ColaPrioridadEstatica;
import estructurasLineales.ListaEstatica;
import utilerias.comunes.TipoOrden;

public class PruebaColaPrioridad {
    public static void main(String[] args) {
        ColaPrioridadEstatica cola = new ColaPrioridadEstatica(10, TipoOrden.INC);
        ListaEstatica listaObjeto = new ListaEstatica(2);
        listaObjeto.agregar(1);
        listaObjeto.agregar("A");
        cola.poner(listaObjeto);
        listaObjeto.cambiar(1,"B");
        cola.poner(listaObjeto);
        listaObjeto= new ListaEstatica(2);
        listaObjeto.agregar(2);
        listaObjeto.agregar("C");
        cola.poner(listaObjeto);
        listaObjeto.cambiar(1,"B");
        cola.poner(listaObjeto);
        cola.imprimir();

        SalidaPorDefecto.terminal(cola.quitar()+"\n");
        cola.imprimir();

        SalidaPorDefecto.terminal(cola.quitar()+"\n");
        cola.imprimir();

        SalidaPorDefecto.terminal(cola.verTope()+"\n");
    }
}
