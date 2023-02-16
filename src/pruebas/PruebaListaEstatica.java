package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import estructurasLineales.ListaEstaticaOrdenada;

public class PruebaListaEstatica {
    public static void main(String [] args){
        ListaEstatica lista = new ListaEstatica(10);
        lista.agregar("A");
        lista.agregar("B");
        lista.agregar("C");
        lista.agregar("D");
        lista.agregar("E");
        lista.agregar("A");
        lista.agregar("B");
        lista.agregar("F");
        lista.agregar("D");
        lista.agregar("E");
        lista.imprimirOI();

        probarCopiaYEsIgual(lista);
        probarMetodosObtenerYBuscar(lista);
        probarSublista(lista);

        ListaEstatica lista2 = new ListaEstatica(5);
        lista2.agregar("Juan");
        lista2.agregar("Jose");
        lista2.agregar("Carlos");
        lista2.agregar("Hector");
        lista2.agregar("Marcos");

        probarMetodosCambiar(lista,lista2);
        agregarLista(lista,lista2);
        probarMetodoContar(lista);
        probarRedimensionar(lista);

        probarInvertir(lista);

        probarRellenar(lista);

        probarMetodosEliminar(lista2);

        probarMetodoInsertar(lista);

    }

    private static void probarMetodosCambiar(ListaEstatica lista1,ListaEstatica lista2){
        SalidaPorDefecto.terminal("Se espera un true y una lista donde el indice 1 tiene la String Jose: "+lista1.cambiar(1,"Jose")+"\n");
        lista1.imprimirOI();
        SalidaPorDefecto.terminal("Se espera una lista donde el indice 1 tiene la string B: "+lista1.cambiar("Jose","B",2)+"\n");

        ListaEstatica listaDeIndices =new ListaEstatica(5);
        listaDeIndices.agregar(0);
        listaDeIndices.agregar(2);
        listaDeIndices.agregar(4);
        listaDeIndices.agregar(9);
        listaDeIndices.agregar(1);

        SalidaPorDefecto.terminal("Se espera una lista como la siguiente [Juan,Marcos,Jose,D,Carlos,A,B,F,D,Hector] \n");
        lista1.cambiarListaEstatica(listaDeIndices,lista2);
        lista1.imprimirOI();

    }

    private static void agregarLista(ListaEstatica lista1,ListaEstatica lista2){
        SalidaPorDefecto.terminal("Se espera una lista como esta [Juan,Marcos,Jose,D,Carlos,A,B,F,D,Hector,Juan,Jose,Carlos,Hector,Marcos]\n");
        lista1.agregarLista(lista2);
        lista1.imprimirOI();
    }

    private static void probarMetodosObtenerYBuscar(ListaEstatica lista1){
        SalidaPorDefecto.terminal("Se espera una cantidad de 1 al buscar el elemento C en la lista:\n ");
        lista1.imprimirOI();
        SalidaPorDefecto.terminal("Respuesta: "+lista1.buscarValores("C").cantidad()+"\n");
        SalidaPorDefecto.terminal("Se espera una B al buscar en la siguiente lista el indice 1: \n");
        lista1.imprimirOI();
        SalidaPorDefecto.terminal("Respuesta"+lista1.obtener(1)+"\n");
    }

    private static void probarMetodoContar(ListaEstatica lista1){
        SalidaPorDefecto.terminal("Se espera un numero 2: "+lista1.contar("Hector")+"\n");
    }

    private static void probarSublista(ListaEstatica lista1){
        SalidaPorDefecto.terminal("Se espera una lista con los siguientes valores [F,D,E] al obtener una sublista desde el indice 7 al 9 de la siguiente lista: \n");
        lista1.imprimirOI();
        ListaEstatica lista2 =(ListaEstatica) lista1.subLista(7,9);
        SalidaPorDefecto.terminal("Respuesta: \n");
        lista2.imprimirOI();
    }

    private static void probarCopiaYEsIgual(ListaEstatica listaUno){
        ListaEstatica lista2 = (ListaEstatica) listaUno.clonar();
        SalidaPorDefecto.terminal("Se espera un true ya que se clono la lista original y luego se comparara con la misma: "+listaUno.esIgual(lista2)+"\n");
    }

    private static void probarRedimensionar(ListaEstatica lista1){
        SalidaPorDefecto.terminal("El tamaño actual de la lista es: "+lista1.maximo()+"\n");
        lista1.redimensionar(20);
        SalidaPorDefecto.terminal("Se espera el numero 20 al redimensionar y ver la capacidad "+lista1.maximo()+"\n");
    }

    private static void probarInvertir(ListaEstatica lista1){
        SalidaPorDefecto.terminal("Se espera un true al invertir dos veces la lista y compararla con un clon: ");
        ListaEstatica lista2=(ListaEstatica) lista1.clonar();

        lista1.invertir();

        lista1.invertir();

        SalidaPorDefecto.terminal(lista1.esIgual(lista2)+"\n");

    }

    private static void probarRellenar(ListaEstatica lista){
        lista.rellenar("Hector",lista.maximo()-1);

        SalidaPorDefecto.terminal("Se espera una lista llena de elementos con la palabra Hector:\n");

        lista.imprimirOI();

    }

    private static void probarMetodosEliminar(ListaEstatica lista){
        SalidaPorDefecto.terminal("Lista actual \n");
        lista.imprimirOI();

        SalidaPorDefecto.terminal("Lista al eliminar el indice 1:\n");
        lista.eliminar(1);
        lista.imprimirOI();

        SalidaPorDefecto.terminal("Lista al eliminar el ultimo objeto con el metodo eliminar()\n");
        lista.eliminar();
        lista.imprimirOI();

        ListaEstatica listaAEliminar = new ListaEstatica(2);
        listaAEliminar.agregar("Juan");
        listaAEliminar.agregar("Carlos");

        SalidaPorDefecto.terminal("Lista al usar el metodo eliminarLista() con la siguiente lista[Juan,Carlos]\n");
        lista.eliminarLista(listaAEliminar);
        lista.imprimirOI();
    }

    private static void probarMetodoInsertar(ListaEstatica lista){
        lista.imprimir();
        lista.insertar(2,"juan");
        lista.imprimirOI();
    }
}
