package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import estructurasLineales.ListaEstaticaOrdenada;
import utilerias.comunes.TipoOrden;

public class PruebasListaEstaticaOrdenada {
    public static void main(String[] args) {
        // Prueba Incremental
        ListaEstaticaOrdenada lista = new ListaEstaticaOrdenada(6, TipoOrden.INC);
        SalidaPorDefecto.terminal("Probar metodo agregar:\n");
        SalidaPorDefecto.terminal("Agregando numero 10\n");
        lista.agregar(10);
        SalidaPorDefecto.terminal("Agregar nuemero 9\n");
        lista.agregar(9);
        SalidaPorDefecto.terminal("Agregar numero 11\n");
        lista.agregar(11);
        SalidaPorDefecto.terminal("Agregar numero -1\n");
        lista.agregar(-1);
        SalidaPorDefecto.terminal("Agregar numero 9 (Repetido)\n");
        lista.agregar(9);
        SalidaPorDefecto.terminal("Agregar numero 23\n");
        lista.agregar(23);

        SalidaPorDefecto.terminal("Lista de objetos ordenados\n");
        lista.imprimir();

        SalidaPorDefecto.terminal("Probando metodo cambiar\n");
        lista.cambiar(1,20);
        SalidaPorDefecto.terminal("Probando metodo cambiar2\n");
        lista.cambiar(11,12,34);

        SalidaPorDefecto.terminal("Resultado metodos cambiar\n");
        lista.imprimir();

        SalidaPorDefecto.terminal("Eliminando el objeto 12\n");
        lista.eliminar((Object) 12);

        SalidaPorDefecto.terminal("Resultado\n");
        lista.imprimir();

        SalidaPorDefecto.terminal("Probando metodo invertir\n");
        lista.invertir();

        lista.agregar(1000);
        SalidaPorDefecto.terminal("Se agrego el numero 1000 y este es el resultado de invertir\n");
        lista.imprimir();

        // Prueba Decremental
        SalidaPorDefecto.terminal("\n");


        ListaEstaticaOrdenada lista2 = new ListaEstaticaOrdenada(6, TipoOrden.DEC);

        SalidaPorDefecto.terminal("Creando lista2\n");
        lista2.agregar(10);
        lista2.agregar(9);
        lista2.agregar(11);
        lista2.agregar(-1);
        lista2.agregar(9);
        lista2.agregar(23);

        SalidaPorDefecto.terminal("Lista2 creada\n");
        lista2.imprimir();

        lista2.cambiar(2,20);
        lista2.cambiar(11,12,34);

        lista2.imprimir();

        lista2.eliminar((Object) 23);

        lista2.imprimir();

        lista2.invertir();

        lista2.agregar(1000);

        SalidaPorDefecto.terminal("Realizando procesos con la lista2\n");
        SalidaPorDefecto.terminal("Resultado\n");
        lista2.imprimir();

        SalidaPorDefecto.terminal("\n");

        // Rellenar

        SalidaPorDefecto.terminal("Probando metodo rellenar\n");
        lista.rellenar(1);
        SalidaPorDefecto.terminal("Resultado de rellenar con 1\n");
        lista.imprimir();

        SalidaPorDefecto.terminal("\n");

        lista2.rellenar(1);
        lista2.imprimir();


        //Sublista

        lista.vaciar();
        lista2.vaciar();

        SalidaPorDefecto.terminal("Probando metodo invertir\n");
        lista2.invertir();

        lista.agregar(1);
        lista.agregar(2);
        lista.agregar(3);
        lista.agregar(4);
        lista.agregar(5);

        lista2.agregar(2);
        lista2.agregar(3);
        lista2.agregar(5);

        lista.imprimir();
        lista2.imprimir();

        SalidaPorDefecto.terminal("\n\n\n");

        SalidaPorDefecto.terminal("Probando metodo retener lista\n");
        SalidaPorDefecto.terminal("Lista principal\n");
        lista.imprimir();

        SalidaPorDefecto.terminal("Lista a retener\n");
        lista.retenerLista(lista2);

        SalidaPorDefecto.terminal("Resultado\n");
        lista.imprimir();

        SalidaPorDefecto.terminal("Probar esSublista\n");
        SalidaPorDefecto.terminal("Lista principal\n");
        lista.imprimir();

        SalidaPorDefecto.terminal("Lista a verificar\n");
        lista2.imprimir();

        SalidaPorDefecto.terminal("Resultado esperado true"+ lista.esSublista(lista2)+"\n");

        SalidaPorDefecto.terminal("vaciar lista 1\n");
        lista.vaciar();

        SalidaPorDefecto.terminal("Agregando numero 10\n");
        lista.agregar(10);
        SalidaPorDefecto.terminal("Agregar nuemero 9\n");
        lista.agregar(9);
        SalidaPorDefecto.terminal("Agregar numero 11\n");
        lista.agregar(11);
        SalidaPorDefecto.terminal("Agregar numero -1\n");
        lista.agregar(-1);
        SalidaPorDefecto.terminal("Agregar numero 9 (Repetido)\n");
        lista.agregar(9);
        SalidaPorDefecto.terminal("Agregar numero 23\n");
        lista.agregar(23);

        SalidaPorDefecto.terminal("Probando metodo buscar elemento \n");
        lista.imprimir();
        SalidaPorDefecto.terminal("Se espera un true"+lista.buscar(10));

        SalidaPorDefecto.terminal("Probando metodo arregloDesordenado()\n");
        SalidaPorDefecto.terminal("lista1 actual\n");
        lista.imprimir();

        SalidaPorDefecto.terminal("Lista desordenada\n");
        lista.arregloDesordenado().imprimir();
    }
}
