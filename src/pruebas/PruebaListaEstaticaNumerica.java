package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import estructurasLineales.ListaEstaticaNumerica;

public class PruebaListaEstaticaNumerica {
    public static void main(String[] args) {
        ListaEstaticaNumerica lista1 = crearListaEstaticaNumerica();
        SalidaPorDefecto.terminal("Prueba por escalar\n");
        SalidaPorDefecto.terminal("Lista actual\n");
        lista1.imprimir();
        lista1.porEscalar(10);
        SalidaPorDefecto.terminal("Lista escalada 10\n");
        lista1.imprimir();

        lista1 = crearListaEstaticaNumerica();
        SalidaPorDefecto.terminal("Prueba suma escalar\n");
        SalidaPorDefecto.terminal("Lista actual\n");
        lista1.imprimir();
        lista1.sumarEscalar(10);
        SalidaPorDefecto.terminal("Lista con suma 10\n");
        lista1.imprimir();

        lista1 = crearListaEstaticaNumerica();
        SalidaPorDefecto.terminal("Prueba suma lista\n");
        SalidaPorDefecto.terminal("Lista actual\n");
        lista1.imprimir();
        ListaEstaticaNumerica lista2 = crearListaEstaticaNumerica();
        SalidaPorDefecto.terminal("Lista a sumar\n");
        lista2.imprimir();
        lista1.sumar(lista2);
        SalidaPorDefecto.terminal("Lista resultante\n");
        lista1.imprimir();

        lista1 = crearListaEstaticaNumerica();
        SalidaPorDefecto.terminal("Prueba multiplica lista\n");
        SalidaPorDefecto.terminal("Lista actual\n");
        lista1.imprimir();
        lista2 = crearListaEstaticaNumerica();
        SalidaPorDefecto.terminal("Lista a multiplicar\n");
        lista2.imprimir();
        lista1.multiplicar(lista2);
        SalidaPorDefecto.terminal("Lista resultante\n");
        lista1.imprimir();

        lista1 = crearListaEstaticaNumerica();
        SalidaPorDefecto.terminal("Prueba eleva lista a una potencia\n");
        SalidaPorDefecto.terminal("Lista actual\n");
        lista1.imprimir();
        lista1.aplicarPotencia(2);
        SalidaPorDefecto.terminal("Lista resultante a la potencia 2\n");
        lista1.imprimir();

        lista1 = crearListaEstaticaNumerica();
        SalidaPorDefecto.terminal("Prueba eleva lista a una potencia dada por una lista\n");
        SalidaPorDefecto.terminal("Lista actual\n");
        lista1.imprimir();
        lista2 = crearListaEstaticaNumerica();
        SalidaPorDefecto.terminal("Lista a multiplicar\n");
        lista2.imprimir();
        lista1.aplicarPotencia(lista2);
        SalidaPorDefecto.terminal("Lista resultante\n");
        lista1.imprimir();


        lista1 = crearListaEstaticaNumerica();
        SalidaPorDefecto.terminal("Prueba producto escalar\n");
        SalidaPorDefecto.terminal("Lista actual\n");
        lista1.imprimir();
        lista2 = crearListaEstaticaNumerica();
        SalidaPorDefecto.terminal("Lista a usar como segundo vector\n");
        lista2.imprimir();
        SalidaPorDefecto.terminal("Resultado\n");
        SalidaPorDefecto.terminal(lista1.productoEscalar(lista2)+"\n");


        lista1 = crearListaEstaticaNumerica();
        SalidaPorDefecto.terminal("Prueba calcula norma\n");
        SalidaPorDefecto.terminal("Lista actual\n");
        lista1.imprimir();
        SalidaPorDefecto.terminal("La norma es"+lista1.norma()+"\n");

        lista1 = crearListaEstaticaNumerica();
        SalidaPorDefecto.terminal("Prueba calcula norma euclidiana\n");
        SalidaPorDefecto.terminal("Lista actual\n");
        lista1.imprimir();
        lista2 = crearListaEstaticaNumerica();
        SalidaPorDefecto.terminal("Lista a usar como segundo vector\n");
        lista2.imprimir();
        SalidaPorDefecto.terminal("La norma es "+lista1.normaEuclidiana(lista2)+"\n");


        ListaEstatica arregloListas = crearListaDeListasNumericas(5);
        lista1 = crearListaEstaticaNumerica();
        SalidaPorDefecto.terminal("Prueba calcula sumaListaEstatica\n");
        SalidaPorDefecto.terminal("Lista actual\n");
        lista1.imprimir();
        SalidaPorDefecto.terminal("Se usara un alista estatica con 5 listas similares a la lista actual\n");
        SalidaPorDefecto.terminal("La suma es "+lista1.sumarListaEstatica(arregloListas)+"\n");

        lista1 = crearListaEstaticaNumerica();
        SalidaPorDefecto.terminal("Prueba calcula sumar escalares\n");
        SalidaPorDefecto.terminal("Lista actual\n");
        lista1.imprimir();
        lista2.vaciar();
        lista2.agregar(2);
        lista2.agregar(2);
        lista2.agregar(4);
        SalidaPorDefecto.terminal("Lista de escalares a usar\n");
        lista2.imprimir();
        SalidaPorDefecto.terminal("La suma es "+lista1.sumarEscalares(lista2)+"\n");

        lista1 = crearListaEstaticaNumerica();
        SalidaPorDefecto.terminal("Prueba calcula suma por indices\n");
        SalidaPorDefecto.terminal("Lista actual\n");
        lista1.imprimir();
        lista2.vaciar();
        lista2.agregar(0);
        lista2.agregar(2);
        lista2.agregar(4);
        SalidaPorDefecto.terminal("Lista a usar como lista de indices\n");
        lista2.imprimir();
        SalidaPorDefecto.terminal("La suma es "+lista1.sumarIndices(lista2)+"\n");

        lista1 = crearListaEstaticaNumerica();
        SalidaPorDefecto.terminal("Prueba obtener sublista\n");
        SalidaPorDefecto.terminal("Lista actual\n");
        lista1.imprimir();
        lista2.vaciar();
        lista2.agregar(0);
        lista2.agregar(2);
        lista2.agregar(4);
        SalidaPorDefecto.terminal("Lista a usar como lista de indices\n");
        lista2.imprimir();
        SalidaPorDefecto.terminal("La sublista es \n");
        lista1.subLista(lista2).imprimir();


        SalidaPorDefecto.terminal("Prueba verificar si son linealmente dependientes\n");
        arregloListas.vaciar();
        lista2.vaciar();
        lista2.agregar(1);
        lista2.agregar(0);
        lista2.agregar(1);
        lista2.agregar(0);
        lista2.agregar(1);
        arregloListas.agregar(lista2);
        lista2.vaciar();
        lista2.agregar(2);
        lista2.agregar(1);
        lista2.agregar(2);
        lista2.agregar(1);
        lista2.agregar(2);
        arregloListas.agregar(lista2);
        lista2.vaciar();
        lista2.agregar(-1);
        lista2.agregar(2);
        lista2.agregar(-1);
        lista2.agregar(2);
        lista2.agregar(-1);
        arregloListas.agregar(lista2);
        lista2.vaciar();
        lista2.agregar(1);
        lista2.agregar(1);
        lista2.agregar(1);
        lista2.agregar(1);
        lista2.agregar(1);
        arregloListas.agregar(lista2);
        lista2.vaciar();
        lista2.agregar(0);
        lista2.agregar(-1);
        lista2.agregar(0);
        lista2.agregar(-1);
        lista2.agregar(0);
        arregloListas.agregar(lista2);
        SalidaPorDefecto.terminal("Lista de escalares\n");
        lista1.vaciar();
        lista1.agregar(2);
        lista1.agregar(-3);
        lista1.agregar(-2);
        lista1.agregar(1);
        lista1.agregar(0);
        lista1.imprimir();
        SalidaPorDefecto.terminal("Los vectores son linealmente dependientes: "+lista1.sonLinealmenteDependientes(arregloListas)+"\n");


        SalidaPorDefecto.terminal("Prueba verificar si son linealmente independientes\n");
        arregloListas.vaciar();
        lista2.vaciar();
        lista2.agregar(1);
        lista2.agregar(0);
        lista2.agregar(0);
        lista2.agregar(0);
        lista2.agregar(0);
        arregloListas.agregar(lista2);
        lista2.vaciar();
        lista2.agregar(0);
        lista2.agregar(1);
        lista2.agregar(0);
        lista2.agregar(0);
        lista2.agregar(0);
        arregloListas.agregar(lista2);
        lista2.vaciar();
        lista2.agregar(0);
        lista2.agregar(0);
        lista2.agregar(1);
        lista2.agregar(0);
        lista2.agregar(0);
        arregloListas.agregar(lista2);
        lista2.vaciar();
        lista2.agregar(0);
        lista2.agregar(0);
        lista2.agregar(0);
        lista2.agregar(1);
        lista2.agregar(0);
        arregloListas.agregar(lista2);
        lista2.vaciar();
        lista2.agregar(0);
        lista2.agregar(0);
        lista2.agregar(0);
        lista2.agregar(0);
        lista2.agregar(1);
        arregloListas.agregar(lista2);
        SalidaPorDefecto.terminal("Lista de escalares\n");
        lista1.vaciar();
        lista1.agregar(0);
        lista1.agregar(0);
        lista1.agregar(0);
        lista1.agregar(0);
        lista1.agregar(0);
        lista1.imprimir();
        SalidaPorDefecto.terminal("Los vectores son linealmente independientes: "+lista1.sonLinealmenteIndependientes(arregloListas)+"\n");



        lista1.vaciar();
        lista1.agregar(1);
        lista1.agregar(2);
        lista1.agregar(-1);
        lista1.agregar(0);
        lista1.agregar(0);
        SalidaPorDefecto.terminal("Prueba ver si dos vectores son ortogonales\n");
        SalidaPorDefecto.terminal("Lista actual\n");
        lista1.imprimir();
        lista2.vaciar();
        lista2.agregar(-1);
        lista2.agregar(0);
        lista2.agregar(0);
        lista2.agregar(3);
        lista2.agregar(-1);
        SalidaPorDefecto.terminal("Lista a usar como prueba\n");
        lista2.imprimir();
        SalidaPorDefecto.terminal("Los vectores son ortogonales: "+lista1.esOrtogonal(lista2)+" \n");


        lista1.vaciar();
        lista1.agregar(1);
        lista1.agregar(2);
        lista1.agregar(3);
        lista1.agregar(4);
        lista1.agregar(5);
        SalidaPorDefecto.terminal("Prueba ver si dos vectores son paralelos\n");
        SalidaPorDefecto.terminal("Lista actual\n");
        lista1.imprimir();
        lista2.vaciar();
        lista2.agregar(2);
        lista2.agregar(4);
        lista2.agregar(6);
        lista2.agregar(8);
        lista2.agregar(10);
        SalidaPorDefecto.terminal("Lista a usar como prueba\n");
        lista2.imprimir();
        lista1.esParalelo(lista2);
        SalidaPorDefecto.terminal("Los vectores son paralelos: "+lista1.esParalelo(lista2)+" \n");
    }

    private static ListaEstaticaNumerica crearListaEstaticaNumerica() {
        ListaEstaticaNumerica lista = new ListaEstaticaNumerica(5);
        lista.agregar(23);
        lista.agregar(20);
        lista.agregar(1);
        lista.agregar(4);
        lista.agregar(50);
        return lista;
    }

    private static ListaEstatica crearListaDeListasNumericas(int tamanio){
        ListaEstatica lista = new ListaEstatica(tamanio);
        for (int indice = 0; indice < tamanio; indice++) {
            lista.agregar(crearListaEstaticaNumerica());
        }
        return lista;
    }

}
