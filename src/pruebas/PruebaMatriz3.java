package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import estructurasnolineales.Matriz2;
import estructurasnolineales.Matriz3;

public class PruebaMatriz3 {
    public static void main(String[] args) {
        Matriz3 matriz = new Matriz3(4,3,5,0);
        matriz.imprimirXColumnas();


        matriz.cambiar(2,1,3,9);
        matriz.cambiar(1,2,0,8);
        matriz.cambiar(0,0,0,7);
        matriz.cambiar(3,1,4,4);

        matriz.imprimirXColumnas();

        SalidaPorDefecto.terminal("Listas...\n\n");

        imprimirMatrices(matriz.aMatrices2());

    }
    public static void imprimirMatrices(ListaEstatica matrices){
        for (int matriz = 0; matriz < matrices.cantidad(); matriz++) {
            Matriz2 matrizTemporal = (Matriz2) matrices.obtener(matriz);
            matrizTemporal.imprimirXColumnas();
            SalidaPorDefecto.terminal("\n");
        }
    }
}
