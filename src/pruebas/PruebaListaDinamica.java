package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.*;
import estructurasnolineales.Matriz2;
import utilerias.comunes.TipoTabla;

public class PruebaListaDinamica {
    public static void main(String[] args) {
        // Pruebas para la pila dinamica
        SalidaPorDefecto.terminal("Pruebas para la pila Dinamica \n\n\n");
        PilaDinamica pila = new PilaDinamica();

        pila.poner(1);
        pila.poner(2);
        pila.poner(3);
        pila.poner(4);
        pila.poner(5);

        SalidaPorDefecto.terminal("Prueba metodo llena() \n");
        SalidaPorDefecto.terminal("pila actual\n");
        pila.imprimir();
        SalidaPorDefecto.terminal("La pila esta llena: " + pila.lleno() + "\n");

        SalidaPorDefecto.terminal("Prueba metodo vacio() \n");
        SalidaPorDefecto.terminal("pila actual\n");
        pila.imprimir();
        SalidaPorDefecto.terminal("La pila esta vacia: " + pila.vacio() + "\n");

        SalidaPorDefecto.terminal("Prueba metodo poner() \n");
        SalidaPorDefecto.terminal("pila actual\n");
        pila.imprimir();
        SalidaPorDefecto.terminal("Poner elemento 6 a la pila: " + pila.poner(6) + "\n");
        SalidaPorDefecto.terminal("Pila resultante\n");
        pila.imprimir();

        SalidaPorDefecto.terminal("Prueba metodo quitar() \n");
        SalidaPorDefecto.terminal("pila actual\n");
        pila.imprimir();
        SalidaPorDefecto.terminal("Quitar elemento a la pila: " + pila.quitar() + "\n");
        SalidaPorDefecto.terminal("Pila resultante\n");
        pila.imprimir();

        SalidaPorDefecto.terminal("Prueba metodo verTope() \n");
        SalidaPorDefecto.terminal("pila actual\n");
        pila.imprimir();
        SalidaPorDefecto.terminal("El tope de la pila es: " + pila.verTope() + "\n");

        SalidaPorDefecto.terminal("\n\n\n");
        // Pruebas para la cola dinamica

        SalidaPorDefecto.terminal("Pruebas de la ColaDinamica\n\n\n");

        ColaDinamica cola = new ColaDinamica();

        cola.poner(1);
        cola.poner(2);
        cola.poner(3);
        cola.poner(4);
        cola.poner(5);

        SalidaPorDefecto.terminal("Prueba metodo llena() \n");
        SalidaPorDefecto.terminal("cola actual\n");
        cola.imprimir();
        SalidaPorDefecto.terminal("La cola esta llena: " + cola.lleno() + "\n");

        SalidaPorDefecto.terminal("Prueba metodo vacio() \n");
        SalidaPorDefecto.terminal("cola actual\n");
        cola.imprimir();
        SalidaPorDefecto.terminal("La cola esta llena: " + cola.vacio() + "\n");

        SalidaPorDefecto.terminal("Prueba metodo poner() \n");
        SalidaPorDefecto.terminal("cola actual\n");
        cola.imprimir();
        SalidaPorDefecto.terminal("Poner elemento 6 a la cola: " + cola.poner(6) + "\n");
        SalidaPorDefecto.terminal("Cola resultante\n");
        cola.imprimir();

        SalidaPorDefecto.terminal("Prueba metodo quitar() \n");
        SalidaPorDefecto.terminal("cola actual\n");
        cola.imprimir();
        SalidaPorDefecto.terminal("Quitar elemento a la cola: " + cola.quitar() + "\n");
        SalidaPorDefecto.terminal("Cola resultante\n");
        cola.imprimir();

        SalidaPorDefecto.terminal("Prueba metodo verTope() \n");
        SalidaPorDefecto.terminal("cola actual\n");
        cola.imprimir();
        SalidaPorDefecto.terminal("El tope de la cola es: " + cola.verTope() + "\n");

        SalidaPorDefecto.terminal("Prueba metodo verInicio() \n");
        SalidaPorDefecto.terminal("cola actual\n");
        cola.imprimir();
        SalidaPorDefecto.terminal("El inicio de la cola es: " + cola.verInicio() + "\n");

        SalidaPorDefecto.terminal("\n\n\n");

        // Pruebas de los metodos de la ListaDinamica

        SalidaPorDefecto.terminal("Pruebas de la ColaDinamica\n\n\n");

        ListaDinamica lista = new ListaDinamica();

        lista.agregar(1);
        lista.agregar(2);
        lista.agregar(3);
        lista.agregar(4);
        lista.agregar(5);

        SalidaPorDefecto.terminal("Prueba metodo vacia() \n");
        SalidaPorDefecto.terminal("lista actual\n");
        lista.imprimir();
        SalidaPorDefecto.terminal("La lista esta vacia: " + lista.vacia() + "\n");

        SalidaPorDefecto.terminal("Prueba metodo agregarInicio() \n");
        SalidaPorDefecto.terminal("lista actual\n");
        lista.imprimir();
        SalidaPorDefecto.terminal("Agregar elemento al inicio: 6 \n");
        lista.agregarInicio(6);
        SalidaPorDefecto.terminal("Lista resultante\n");
        lista.imprimir();

        SalidaPorDefecto.terminal("Prueba metodo ImprimirOI() \n");
        SalidaPorDefecto.terminal("lista actual\n");
        lista.imprimir();
        SalidaPorDefecto.terminal("lista en orden inverso\n");
        lista.imprimirOI();

        SalidaPorDefecto.terminal("Prueba metodo buscar() \n");
        SalidaPorDefecto.terminal("lista actual\n");
        lista.imprimir();
        SalidaPorDefecto.terminal("El elemento 6 esta: " + (lista.buscar(6) != null) + "\n");

        SalidaPorDefecto.terminal("Prueba metodo eliminar(Object) \n");
        SalidaPorDefecto.terminal("lista actual\n");
        lista.imprimir();
        SalidaPorDefecto.terminal("Eliminar elemento: 6 \n");
        lista.eliminar(new Integer(6));
        SalidaPorDefecto.terminal("Lista resultante\n");
        lista.imprimir();

        SalidaPorDefecto.terminal("Prueba metodo verUltimo() \n");
        SalidaPorDefecto.terminal("lista actual\n");
        lista.imprimir();
        SalidaPorDefecto.terminal("El ultimo elemento es: " + lista.verUltimo() + " \n");

        SalidaPorDefecto.terminal("Prueba metodos clonar() y esIgual() \n");
        SalidaPorDefecto.terminal("lista actual\n");
        lista.imprimir();
        ListaDinamica lista2 = (ListaDinamica) lista.clonar();
        SalidaPorDefecto.terminal("Lista clon\n");
        lista2.imprimir();
        SalidaPorDefecto.terminal("Las listas son iguales: " + lista.esIgual(lista2) + " \n");

        SalidaPorDefecto.terminal("Prueba metodo cambiar(Object, Object, int) \n");
        lista.agregar(1);
        lista.agregar(1);
        lista.agregar(1);
        SalidaPorDefecto.terminal("lista actual\n");
        lista.imprimir();
        SalidaPorDefecto.terminal("Cambiar el 1 por un 4 dos veces\n");
        lista.cambiar(1, 4, 2);
        SalidaPorDefecto.terminal("Lista resultante\n");
        lista.imprimir();

        SalidaPorDefecto.terminal("Prueba metodo buscarValores(Object) \n");
        SalidaPorDefecto.terminal("lista actual\n");
        lista.imprimir();
        SalidaPorDefecto.terminal("Buscar el 4 en la lista\n");
        SalidaPorDefecto.terminal("Los indices son\n");
        lista.buscarValores(4).imprimir();

        SalidaPorDefecto.terminal("Prueba metodo eliminar() \n");
        SalidaPorDefecto.terminal("lista actual\n");
        lista.imprimir();
        lista.eliminar();
        SalidaPorDefecto.terminal("La lista resultante es:\n");
        lista.imprimir();

        SalidaPorDefecto.terminal("Prueba metodo eliminarInicio() \n");
        SalidaPorDefecto.terminal("lista actual\n");
        lista.imprimir();
        lista.eliminarInicio();
        SalidaPorDefecto.terminal("La lista resultante es:\n");
        lista.imprimir();

        SalidaPorDefecto.terminal("Prueba metodo agregarLista() \n");
        SalidaPorDefecto.terminal("lista actual\n");
        lista.imprimir();
        SalidaPorDefecto.terminal("Lista a agregar\n");
        ListaEstatica lista3 = new ListaEstatica(4);
        lista3.agregar(6);
        lista3.agregar(7);
        lista3.agregar(8);
        lista3.imprimir();
        lista.agregarLista(lista3);
        SalidaPorDefecto.terminal("La lista resultante es:\n");
        lista.imprimir();

        SalidaPorDefecto.terminal("Prueba metodo invertir() \n");
        SalidaPorDefecto.terminal("lista actual\n");
        lista.imprimir();
        lista.invertir();
        SalidaPorDefecto.terminal("La lista resultante es:\n");
        lista.imprimir();

        SalidaPorDefecto.terminal("Prueba metodo contar() \n");
        SalidaPorDefecto.terminal("lista actual\n");
        lista.imprimir();
        SalidaPorDefecto.terminal("La cantidad de 4 en la lista es : " + lista.contar(4) + "\n");

        SalidaPorDefecto.terminal("Prueba metodo eliminarLista() \n");
        SalidaPorDefecto.terminal("lista actual\n");
        lista.imprimir();
        SalidaPorDefecto.terminal("Lista a eliminar\n");
        lista3 = new ListaEstatica(4);
        lista3.agregar(6);
        lista3.agregar(7);
        lista3.agregar(8);
        lista3.imprimir();
        lista.eliminarLista(lista3);
        SalidaPorDefecto.terminal("La lista resultante es:\n");
        lista.imprimir();

        SalidaPorDefecto.terminal("Prueba metodo rellenar(Object, int) \n");
        SalidaPorDefecto.terminal("lista actual\n");
        lista.imprimir();
        SalidaPorDefecto.terminal("lista resultante rellena de 4 : \n");
        lista.rellenar(4, 10);
        lista.imprimir();

        SalidaPorDefecto.terminal("Prueba metodo copiarLista() \n");
        SalidaPorDefecto.terminal("lista actual\n");
        lista.imprimir();
        SalidaPorDefecto.terminal("lista a copiar\n");
        lista2.imprimir();
        lista.copiarLista(lista2);
        SalidaPorDefecto.terminal("lista resultante: \n");
        lista.imprimir();

        SalidaPorDefecto.terminal("Prueba metodo subLista() \n");
        SalidaPorDefecto.terminal("lista actual\n");
        lista.imprimir();
        SalidaPorDefecto.terminal("lista resultante del 1ndice 1 al 3: \n");
        lista.subLista(1, 3).imprimir();

        SalidaPorDefecto.terminal("Prueba metodo insertar() \n");
        SalidaPorDefecto.terminal("lista actual\n");
        lista.imprimir();
        SalidaPorDefecto.terminal("lista resultante al insertar un 5 en la posicion 1: \n");
        lista.insertar(1, 5);
        lista.imprimir();

        SalidaPorDefecto.terminal("Prueba metodo aListaEstatica() \n");
        SalidaPorDefecto.terminal("lista actual\n");
        lista.imprimir();
        SalidaPorDefecto.terminal("lista resultante: \n");
        lista.aListaEstatica().imprimir();

        SalidaPorDefecto.terminal("Prueba metodo aListaEstatica(ListaEstatica) \n");
        SalidaPorDefecto.terminal("lista actual\n");
        lista.imprimir();
        SalidaPorDefecto.terminal("Lista a descartar\n");
        lista3.vaciar();
        lista3.agregar(2);
        lista3.agregar(3);
        lista3.agregar(1);
        lista3.imprimir();
        SalidaPorDefecto.terminal("lista resultante: \n");
        lista.aListaEstatica(lista3).imprimir();

        SalidaPorDefecto.terminal("Prueba metodo aMatriz2() \n");
        SalidaPorDefecto.terminal("lista actual\n");
        lista.imprimir();
        SalidaPorDefecto.terminal("Matriz resultante: \n");
        Matriz2 matriz = lista.aMatriz2(3, 3);
        matriz.imprimirXColumnas();

        SalidaPorDefecto.terminal("Prueba metodo agregarMatriz2D(Matriz2) \n");
        SalidaPorDefecto.terminal("lista actual\n");
        lista.imprimir();
        SalidaPorDefecto.terminal("matriz a agregar por columnas\n");
        matriz.imprimirXColumnas();
        SalidaPorDefecto.terminal("Lista resultante: \n");
        lista.agregarMatriz2D(matriz, TipoTabla.COLUMNA);
        lista.imprimir();

        SalidaPorDefecto.terminal("Prueba metodo obtener(int) \n");
        SalidaPorDefecto.terminal("lista actual\n");
        lista.imprimir();
        SalidaPorDefecto.terminal("Obtener elemento de la posicion 4 :" + lista.obtener(4) + " \n");

        SalidaPorDefecto.terminal("Prueba metodo cambiar(int, Object) \n");
        SalidaPorDefecto.terminal("lista actual\n");
        lista.imprimir();
        SalidaPorDefecto.terminal("Lista resultante al cambiar el indice 4 por un 7\n");
        lista.cambiar(4, 7);
        lista.imprimir();

        SalidaPorDefecto.terminal("Prueba metodo eliminar(int) \n");
        SalidaPorDefecto.terminal("lista actual\n");
        lista.imprimir();
        SalidaPorDefecto.terminal("Lista resultante al eliminar el indice 4\n");
        lista.eliminar(4);
        lista.imprimir();

        SalidaPorDefecto.terminal("Prueba metodo redimensionar(int) \n");
        SalidaPorDefecto.terminal("lista actual\n");
        lista.imprimir();
        SalidaPorDefecto.terminal("Lista resultante al redimensionar a 2\n");
        lista.redimensionar(2);
        lista.imprimir();

        SalidaPorDefecto.terminal("Prueba metodo vaciar() \n");
        SalidaPorDefecto.terminal("lista actual\n");
        lista.imprimir();
        SalidaPorDefecto.terminal("Lista resultante al vaciarla\n");
        lista.vaciar();
        lista.imprimir();

    }
}
