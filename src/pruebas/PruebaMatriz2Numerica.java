package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import estructurasLineales.ListaEstaticaNumerica;
import estructurasnolineales.Matriz2Numerica;
import utilerias.comunes.TipoLogaritmo;

public class PruebaMatriz2Numerica {
    public static void main(String[] args) {
        SalidaPorDefecto.terminal("Prueba constructor matriz rellena de 0\n");
        Matriz2Numerica matrizUno = new Matriz2Numerica(3,4);
        SalidaPorDefecto.terminal("Matriz resultante\n");
        matrizUno.imprimirXColumnas();
        SalidaPorDefecto.terminal("\n");

        SalidaPorDefecto.terminal("Prueba constructor matriz rellena de 9\n");
        Matriz2Numerica matrizDos = new Matriz2Numerica(5,4,9);
        SalidaPorDefecto.terminal("Matriz resultante\n");
        matrizDos.imprimirXColumnas();
        SalidaPorDefecto.terminal("\n");

        SalidaPorDefecto.terminal("Prueba multiplicacion de matriz por 2\n");
        SalidaPorDefecto.terminal("Matriz actual\n");
        matrizDos.imprimirXColumnas();
        matrizDos.porEscalar(2);
        SalidaPorDefecto.terminal("Matriz resultante\n");
        matrizDos.imprimirXColumnas();
        SalidaPorDefecto.terminal("\n");

        SalidaPorDefecto.terminal("Prueba multiplicacion de matriz por lista de escalares\n");
        ListaEstaticaNumerica escalares = new ListaEstaticaNumerica(20);
        escalares.rellenar(2);
        SalidaPorDefecto.terminal("Matriz actual\n");
        matrizDos.imprimirXColumnas();
        SalidaPorDefecto.terminal("Lista a usar para rellenar\n");
        escalares.imprimir();
        matrizDos.porEscalares(escalares);
        SalidaPorDefecto.terminal("Matriz resultante\n");
        matrizDos.imprimirXColumnas();
        SalidaPorDefecto.terminal("\n");

        matrizDos.porEscalar(0.25);

        SalidaPorDefecto.terminal("Prueba suma de matriz mas 2\n");
        SalidaPorDefecto.terminal("Matriz actual\n");
        matrizDos.imprimirXColumnas();
        matrizDos.sumarEscalar(2);
        SalidaPorDefecto.terminal("Matriz resultante\n");
        matrizDos.imprimirXColumnas();
        SalidaPorDefecto.terminal("\n");

        SalidaPorDefecto.terminal("Prueba sumar escalares a una matriz\n");
        SalidaPorDefecto.terminal("Matriz actual\n");
        matrizDos.imprimirXColumnas();
        SalidaPorDefecto.terminal("Lista a usar para rellenar\n");
        escalares.imprimir();
        matrizDos.sumarEscalares(escalares);
        SalidaPorDefecto.terminal("Matriz resultante\n");
        matrizDos.imprimirXColumnas();
        SalidaPorDefecto.terminal("\n");

        SalidaPorDefecto.terminal("Prueba multiplicar por matriz\n");
        SalidaPorDefecto.terminal("Matriz actual\n");
        matrizDos.imprimirXColumnas();
        Matriz2Numerica matrizTres = new Matriz2Numerica(4,5,3);
        SalidaPorDefecto.terminal("Matriz con la que se multiplicara\n");
        matrizTres.imprimirXColumnas();
        matrizDos.multiplicar(matrizTres);
        SalidaPorDefecto.terminal("Matriz resultante\n");
        matrizDos.imprimirXColumnas();
        SalidaPorDefecto.terminal("\n");


        SalidaPorDefecto.terminal("Prueba sumar matriz\n");
        SalidaPorDefecto.terminal("Matriz actual\n");
        matrizDos.imprimirXColumnas();
        Matriz2Numerica matrizCuatro = new Matriz2Numerica(5,5,1);
        SalidaPorDefecto.terminal("Matriz con la que se sumara\n");
        matrizCuatro.imprimirXColumnas();
        matrizDos.sumar(matrizCuatro);
        SalidaPorDefecto.terminal("Matriz resultante\n");
        matrizDos.imprimirXColumnas();
        SalidaPorDefecto.terminal("\n");

        matrizDos.rellenar(2);

        SalidaPorDefecto.terminal("Prueba elevar a potencia 2\n");
        SalidaPorDefecto.terminal("Matriz actual\n");
        matrizDos.imprimirXColumnas();
        matrizDos.aplicarPotencia(2);
        SalidaPorDefecto.terminal("Matriz resultante\n");
        matrizDos.imprimirXColumnas();
        SalidaPorDefecto.terminal("\n");

        SalidaPorDefecto.terminal("Prueba aplicar logaritmo base 10\n");
        SalidaPorDefecto.terminal("Matriz actual\n");
        matrizDos.imprimirXColumnas();
        matrizDos.aplicarLogaritmo(TipoLogaritmo.BASE10);
        SalidaPorDefecto.terminal("Matriz resultante\n");
        matrizDos.imprimirXColumnas();
        SalidaPorDefecto.terminal("\n");

        matrizDos.rellenar(2);

        SalidaPorDefecto.terminal("Prueba aplicar generar matriz diagonal con 2\n");
        SalidaPorDefecto.terminal("Matriz actual\n");
        matrizDos.imprimirXColumnas();
        matrizDos.matrizDiagonal(2);
        SalidaPorDefecto.terminal("Matriz resultante\n");
        matrizDos.imprimirXColumnas();
        SalidaPorDefecto.terminal("\n");

        SalidaPorDefecto.terminal("Prueba es matriz diagonal superior\n");
        SalidaPorDefecto.terminal("Matriz actual\n");
        matrizDos.imprimirXColumnas();
        SalidaPorDefecto.terminal("Es matriz diagonal superior\n");
        SalidaPorDefecto.terminal(matrizDos.esDiagonalSuperior()+"\n");
        SalidaPorDefecto.terminal("\n");

        SalidaPorDefecto.terminal("Prueba es matriz diagonal inferior\n");
        SalidaPorDefecto.terminal("Matriz actual\n");
        matrizDos.imprimirXColumnas();
        SalidaPorDefecto.terminal("Es matriz diagonal superior\n");
        SalidaPorDefecto.terminal(matrizDos.esDiagonalInferior()+"\n");
        SalidaPorDefecto.terminal("\n");

        matrizDos=new Matriz2Numerica(2,2,2);
        matrizDos.rellenar(2);

        SalidaPorDefecto.terminal("Prueba elevar la matriz a la potencia 3\n");
        SalidaPorDefecto.terminal("Matriz actual\n");
        matrizDos.imprimirXColumnas();
        matrizDos.potencia(3);
        SalidaPorDefecto.terminal("Matriz resultante\n");
        matrizDos.imprimirXColumnas();
        SalidaPorDefecto.terminal("\n");

        SalidaPorDefecto.terminal("Prueba doblar Renglones\n");
        SalidaPorDefecto.terminal("Matriz actual\n");
        matrizDos.imprimirXColumnas();
        matrizDos.doblarRenglones();
        SalidaPorDefecto.terminal("Matriz resultante\n");
        matrizDos.imprimirXColumnas();
        SalidaPorDefecto.terminal("\n");

        SalidaPorDefecto.terminal("Prueba doblar Columnas\n");
        SalidaPorDefecto.terminal("Matriz actual\n");
        matrizDos.imprimirXColumnas();
        matrizDos.doblarColumnas();
        SalidaPorDefecto.terminal("Matriz resultante\n");
        matrizDos.imprimirXColumnas();
        SalidaPorDefecto.terminal("\n");
    }
}
