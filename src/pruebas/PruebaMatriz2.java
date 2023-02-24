package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import estructurasnolineales.Matriz2;
import estructurasnolineales.Matriz3;
import utilerias.comunes.TipoColumna;
import utilerias.comunes.TipoRenglon;

public class PruebaMatriz2 {
    public static void main(String[] args) {
        Matriz2 matriz = new Matriz2(1,2,0);

        matriz.cambiar(0,0,2);
        matriz.cambiar(0,1,3);

        SalidaPorDefecto.terminal("Prueba metodo obtener matriz2\n");
        SalidaPorDefecto.terminal("Matriz original\n");
        matriz.imprimirXColumnas();
        SalidaPorDefecto.terminal("Elemento en la posicion 0,0\n");
        SalidaPorDefecto.terminal(matriz.obtener(0,0)+"\n");
        SalidaPorDefecto.terminal("\n\n\n");

        SalidaPorDefecto.terminal("Prueba metodo cambiar matriz2\n");
        SalidaPorDefecto.terminal("Matriz original\n");
        matriz.imprimirXColumnas();
        SalidaPorDefecto.terminal("cambiar el 2 de la posicion 0,0 por un 9\n");
        matriz.cambiar(0,0,9);
        SalidaPorDefecto.terminal("Matriz resultante\n");
        matriz.imprimirXColumnas();
        SalidaPorDefecto.terminal("\n\n\n");

        SalidaPorDefecto.terminal("Prueba metodo obtenerRenglones matriz2\n");
        SalidaPorDefecto.terminal("Matriz original\n");
        matriz.imprimirXColumnas();
        SalidaPorDefecto.terminal("Cantidad de renglones\n");
        SalidaPorDefecto.terminal(matriz.obtenerRenglones()+"\n");
        SalidaPorDefecto.terminal("\n\n\n");

        SalidaPorDefecto.terminal("Prueba metodo obtenerColumnas matriz2\n");
        SalidaPorDefecto.terminal("Matriz original\n");
        matriz.imprimirXColumnas();
        SalidaPorDefecto.terminal("Cantidad de columnas\n");
        SalidaPorDefecto.terminal(matriz.obtenerColumnas()+"\n");
        SalidaPorDefecto.terminal("\n\n\n");


        SalidaPorDefecto.terminal("Prueba metodo imprimirPorColumnas matriz2\n");
        matriz.imprimirXColumnas();
        SalidaPorDefecto.terminal("\n\n\n");

        SalidaPorDefecto.terminal("Prueba metodo imprimirPorRenglones matriz2\n");
        matriz.imprimirXRenglones();
        SalidaPorDefecto.terminal("\n\n\n");


        SalidaPorDefecto.terminal("Prueba metodo obtenerTranspuesta matriz2\n");
        SalidaPorDefecto.terminal("Matriz original\n");
        matriz.imprimirXColumnas();
        SalidaPorDefecto.terminal("Matriz transpuesta\n");
        matriz.transpuesta();
        matriz.imprimirXColumnas();
        SalidaPorDefecto.terminal("\n\n\n");


        SalidaPorDefecto.terminal("Prueba metodo rellenar matriz2\n");
        SalidaPorDefecto.terminal("Matriz original\n");
        matriz.imprimirXColumnas();
        SalidaPorDefecto.terminal("Matriz rellena con 0\n");
        matriz.rellenar(0);
        matriz.imprimirXColumnas();
        SalidaPorDefecto.terminal("\n\n\n");

        SalidaPorDefecto.terminal("Prueba metodo clonar matriz2\n");
        SalidaPorDefecto.terminal("Matriz original\n");
        matriz.imprimirXColumnas();
        SalidaPorDefecto.terminal("Matriz copia\n");
        matriz.clonar().imprimirXColumnas();
        SalidaPorDefecto.terminal("\n\n\n");

        matriz=new Matriz2(1,1);

        SalidaPorDefecto.terminal("Prueba metodo crearvectorColumna\n");
        SalidaPorDefecto.terminal("Matriz resultante con 3 renglones y rellenada con 1\n");
        matriz.vectorColumna(3,1);
        matriz.imprimirXColumnas();
        SalidaPorDefecto.terminal("\n\n\n");

        matriz=new Matriz2(1,1);

        SalidaPorDefecto.terminal("Prueba metodo crearvectorRenglon\n");
        SalidaPorDefecto.terminal("Matriz resultante con 3 columnas y rellenada con 1\n");
        matriz.vectorRenglon(3,1);
        matriz.imprimirXColumnas();
        SalidaPorDefecto.terminal("\n\n\n");

        SalidaPorDefecto.terminal("Prueba metodo agregar renglon\n");
        SalidaPorDefecto.terminal("Matriz original\n");
        matriz.imprimirXColumnas();
        ListaEstatica lista = new ListaEstatica(3);
        lista.agregar(1);
        lista.agregar(2);
        lista.agregar(3);
        SalidaPorDefecto.terminal("Renglon a agregar\n");
        lista.imprimir();
        SalidaPorDefecto.terminal("Matriz con nuevo renglon\n");
        matriz.agregarRenglon(lista);
        matriz.imprimirXColumnas();
        SalidaPorDefecto.terminal("\n\n\n");


        SalidaPorDefecto.terminal("Prueba metodo agregar columna\n");
        SalidaPorDefecto.terminal("Matriz original\n");
        matriz.imprimirXColumnas();
        lista = new ListaEstatica(2);
        lista.agregar(1);
        lista.agregar(2);
        SalidaPorDefecto.terminal("Columna a agregar\n");
        lista.imprimir();
        SalidaPorDefecto.terminal("Matriz con nueva columna\n");
        matriz.agregarColumna(lista);
        matriz.imprimirXColumnas();
        SalidaPorDefecto.terminal("\n\n\n");

        Matriz2 matriz2 = new Matriz2(2,2,9);
        SalidaPorDefecto.terminal("Prueba metodo agregar matriz\n");
        SalidaPorDefecto.terminal("Matriz original\n");
        matriz.imprimirXColumnas();
        SalidaPorDefecto.terminal("Matriz a agregar a la derecha\n");
        matriz2.imprimirXColumnas();
        SalidaPorDefecto.terminal("Matriz nueva\n");
        matriz.agregarMatrizXColumna(matriz2);
        matriz.imprimirXColumnas();
        SalidaPorDefecto.terminal("\n\n\n");

        matriz2 = matriz.clonar();
        SalidaPorDefecto.terminal("Prueba metodo agregar matriz\n");
        SalidaPorDefecto.terminal("Matriz original\n");
        matriz.imprimirXColumnas();
        SalidaPorDefecto.terminal("Matriz a agregar debajo\n");
        matriz2.imprimirXColumnas();
        SalidaPorDefecto.terminal("Matriz nueva\n");
        matriz.agregarMatrizXRenglon(matriz2);
        matriz.imprimirXColumnas();
        SalidaPorDefecto.terminal("\n\n\n");

        SalidaPorDefecto.terminal("Prueba metodo aVectorColumna\n");
        SalidaPorDefecto.terminal("Matriz original\n");
        matriz2.imprimirXColumnas();
        SalidaPorDefecto.terminal("Matriz nueva\n");
        matriz2.aVectorColumna().imprimirXColumnas();
        SalidaPorDefecto.terminal("\n\n\n");

        matriz2=matriz.clonar();
        SalidaPorDefecto.terminal("Prueba metodo aVectorRenglon\n");
        SalidaPorDefecto.terminal("Matriz original\n");
        matriz2.imprimirXColumnas();
        SalidaPorDefecto.terminal("Matriz nueva\n");
        matriz2.aVectorRenglon().imprimirXColumnas();
        SalidaPorDefecto.terminal("\n\n\n");

        matriz2=matriz.clonar();
        SalidaPorDefecto.terminal("Prueba metodo eliminar renglon por indice\n");
        SalidaPorDefecto.terminal("Matriz original\n");
        matriz2.imprimirXColumnas();
        SalidaPorDefecto.terminal("Matriz nueva\n");
        matriz2.eliminarRenglon(2);
        matriz2.imprimirXColumnas();
        SalidaPorDefecto.terminal("\n\n\n");

        matriz2=matriz.clonar();
        SalidaPorDefecto.terminal("Prueba metodo eliminar renglon final\n");
        SalidaPorDefecto.terminal("Matriz original\n");
        matriz2.imprimirXColumnas();
        SalidaPorDefecto.terminal("Matriz nueva\n");
        matriz2.quitarRenglon(TipoRenglon.INF);
        matriz2.imprimirXColumnas();
        SalidaPorDefecto.terminal("\n\n\n");

        matriz2=matriz.clonar();
        SalidaPorDefecto.terminal("Prueba metodo eliminar renglon superior\n");
        SalidaPorDefecto.terminal("Matriz original\n");
        matriz2.imprimirXColumnas();
        SalidaPorDefecto.terminal("Matriz nueva\n");
        matriz2.quitarRenglon(TipoRenglon.SUP);
        matriz2.imprimirXColumnas();
        SalidaPorDefecto.terminal("\n\n\n");

        matriz2=matriz.clonar();
        SalidaPorDefecto.terminal("Prueba metodo eliminar columna por indice\n");
        SalidaPorDefecto.terminal("Matriz original\n");
        matriz2.imprimirXColumnas();
        SalidaPorDefecto.terminal("Matriz nueva\n");
        matriz2.eliminarColumna(2);
        matriz2.imprimirXColumnas();
        SalidaPorDefecto.terminal("\n\n\n");

        matriz2=matriz.clonar();
        SalidaPorDefecto.terminal("Prueba metodo eliminar columna inicial\n");
        SalidaPorDefecto.terminal("Matriz original\n");
        matriz2.imprimirXColumnas();
        SalidaPorDefecto.terminal("Matriz nueva\n");
        matriz2.quitarColumna(TipoColumna.IZQ);
        matriz2.imprimirXColumnas();
        SalidaPorDefecto.terminal("\n\n\n");

        matriz2=matriz.clonar();
        SalidaPorDefecto.terminal("Prueba metodo eliminar columna final\n");
        SalidaPorDefecto.terminal("Matriz original\n");
        matriz2.imprimirXColumnas();
        SalidaPorDefecto.terminal("Matriz nueva\n");
        matriz2.quitarColumna(TipoColumna.DER);
        matriz2.imprimirXColumnas();
        SalidaPorDefecto.terminal("\n\n\n");

        matriz2=matriz.clonar();
        SalidaPorDefecto.terminal("Prueba metodo crear matriz3\n");
        SalidaPorDefecto.terminal("Matriz original\n");
        matriz2.imprimirXColumnas();
        SalidaPorDefecto.terminal("Creando la matriz tres con 4 matrices igual que la original\n");
        ListaEstatica matrices = new ListaEstatica(3);
        for (int iterador = 0; iterador < 3; iterador++) {
            matrices.agregar(matriz2.clonar());
        }
        Matriz3 matrizNueva=matriz2.aMatriz3(matrices);
        SalidaPorDefecto.terminal("Matriz creada\n");
        matrizNueva.imprimirXColumnas();
        SalidaPorDefecto.terminal("\n\n\n");
    }
}
