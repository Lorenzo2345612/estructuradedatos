package estructurasnolineales;

import estructurasLineales.ListaEstatica;
import estructurasLineales.ListaEstaticaNumerica;
import utilerias.comunes.ConversorDeDatos;
import utilerias.comunes.TipoLogaritmo;

/**
 * Clase que representa una matriz compuesta
 * por numeros.
 * @author Lorenzo Trujillo Rojas.
 * @version 1.0
 */
public class Matriz2Numerica extends Matriz2{

    /**
     * Constructor que inicializa la matriz con 0.
     * @param renglones Cantidad de renglones que tendra la matriz.
     * @param columnas Cantidad de columnas que tendra la matriz.
     */
    public Matriz2Numerica(int renglones, int columnas) {
        super(renglones, columnas);
        rellenar(0);
    }

    /**
     * Constructor que inicializa la matriz con un objeto pasado por
     * parametro.
     * @param renglones Cantidad de renglones que tendra la matriz.
     * @param columnas Cantidad de colunas que tendra la matriz.
     * @param info Objeto con el que de rellenara la matriz.
     */
    public Matriz2Numerica(int renglones, int columnas, Object info) {
        super(renglones, columnas);
        rellenar(info instanceof Number ? info : 0);
    }

    @Override
    public void rellenar(Object info) {
        super.rellenar(info instanceof Number ? info : 0);
    }

    @Override
    public boolean cambiar(int renglon, int columna, Object info) {
        if(!(info instanceof Number))return false;
        return super.cambiar(renglon, columna, info);
    }

    @Override
    public boolean vectorColumna(int filas, Object info) {
        if(!(info instanceof Number))return false;
        return super.vectorColumna(filas, info);
    }

    @Override
    public boolean vectorRenglon(int columnas, Object info) {
        if(!(info instanceof Number))return false;
        return super.vectorRenglon(columnas, info);
    }

    @Override
    public boolean substituir(Matriz2 matriz2) {
        if(!(matriz2 instanceof Matriz2Numerica))return false;
        return super.substituir(matriz2);
    }

    @Override
    public boolean agregarRenglon(ListaEstatica arreglo) {
        if(!(arreglo instanceof ListaEstaticaNumerica))return false;
        return super.agregarRenglon(arreglo);
    }

    @Override
    public boolean agregarColumna(ListaEstatica arreglo) {
        if(!(arreglo instanceof ListaEstaticaNumerica))return false;
        return super.agregarColumna(arreglo);
    }

    @Override
    public boolean agregarMatrizXColumna(Matriz2 matriz2) {
        if(!(matriz2 instanceof Matriz2Numerica))return false;
        return super.agregarMatrizXColumna(matriz2);
    }

    @Override
    public boolean agregarMatrizXRenglon(Matriz2 matriz2) {
        if(!(matriz2 instanceof Matriz2Numerica))return false;
        return super.agregarMatrizXRenglon(matriz2);
    }

    /**
     * Metodo que multiplica la matriz por un escalar.
     * @param escalar Escalar por el que se multiplicara la matriz.
     * @return Regresa true si fue posible o false si no.
     */
    public boolean porEscalar(Number escalar){
        for (int columna = 0; columna < columnas; columna++) {
            for (int renglon = 0; renglon < renglones; renglon++) {
                if(!cambiar(renglon,columna,escalar.doubleValue()*ConversorDeDatos.objectToDouble(obtener(renglon,columna))))return false;
            }
        }
        return true;
    }

    /**
     * Metodo que multiplica un escalar de la lista
     * por un elemento de la matriz.
     * @param escalares Representa la lista de escalares a multiplicar.
     * @return Regresa true si se pudo multiplicar y false si no.
     */
    public boolean porEscalares(ListaEstaticaNumerica escalares){
        if(escalares.cantidad()!=columnas*renglones)return false;
        int counter=0;
        for (int columna = 0; columna < columnas; columna++) {
            for (int renglon = 0; renglon < renglones; renglon++) {
                informacion[renglon][columna]=ConversorDeDatos.objectToDouble(informacion[renglon][columna])*ConversorDeDatos.objectToDouble(escalares.obtener(counter));
                counter++;
            }
        }
        return true;
    }

    /**
     * Metodo que suma un escalar a cada posicion de la matriz.
     * @param escalar Representa el escalar a sumar.
     * @return Regresa true si se pudo sumar y false si no.
     */
    public boolean sumarEscalar(Number escalar){
        for (int columna = 0; columna < columnas; columna++) {
            for (int renglon = 0; renglon < renglones; renglon++) {
                if(!cambiar(renglon,columna,escalar.doubleValue()+(Double) obtener(renglon,columna)))return false;
            }
        }
        return true;
    }

    /**
     * Metodo que suma un escalar de la lista
     * a un elemento de la matriz.
     * @param escalares Representa la lista de escalares a sumar.
     * @return Regresa true si se pudo sumar y false si no.
     */
    public boolean sumarEscalares(ListaEstaticaNumerica escalares){
        if(escalares.cantidad()!=columnas*renglones)return false;
        int counter=0;
        for (int columna = 0; columna < columnas; columna++) {
            for (int renglon = 0; renglon < renglones; renglon++) {
                informacion[renglon][columna]= ConversorDeDatos.objectToDouble(informacion[renglon][columna]) +ConversorDeDatos.objectToDouble(escalares.obtener(counter));
                counter++;
            }
        }
        return true;
    }

    /**
     * Metodo que multiplica una matriz por otra.
     * @param matriz2 Representa la matriz a multiplicar.
     * @return Regresa true si se pudo multiplicar y false si no.
     */
    public boolean multiplicar(Matriz2Numerica matriz2){
        if(columnas!=matriz2.renglones)return false;
        Matriz2Numerica matrizTemporal = new Matriz2Numerica(renglones, matriz2.columnas);
        for (int filas = 0; filas < renglones; filas++) {
            for (int comun = 0; comun < columnas; comun++) {
                for (int columna = 0; columna < matriz2.columnas; columna++) {
                    matrizTemporal.cambiar(filas,columna,ConversorDeDatos.objectToDouble(matrizTemporal.obtener(filas,columna))+ConversorDeDatos.objectToDouble(obtener(filas,comun))*
                                                    ConversorDeDatos.objectToDouble(matriz2.obtener(comun,columna)));
                }
            }
        }
        informacion=matrizTemporal.informacion;
        renglones= matrizTemporal.renglones;
        columnas= matrizTemporal.columnas;
        return true;
    }

    /**
     * Metodo que suma una matriz a otra.
     * @param matriz2 Representa la matriz a sumar.
     * @return Regresa true si se pudo sumar y false si no.
     */
    public boolean sumar(Matriz2Numerica matriz2){
        if(matriz2.columnas!=columnas || matriz2.renglones!=renglones)return false;

        for (int renglon = 0; renglon < renglones; renglon++) {
            for (int columna = 0; columna < columnas; columna++) {
                informacion[renglon][columna]=ConversorDeDatos.objectToDouble(informacion[renglon][columna])+ConversorDeDatos.objectToDouble(matriz2.informacion[renglon][columna]);
            }
        }
        return true;
    }

    /**
     * Metodo que aplica una potencia a una matriz.
     * @param escalar Representa la potencia a aplicar.
     * @return Regresa true si se pudo aplicar la potencia o false si no.
     */
    public boolean aplicarPotencia(Number escalar){
        for (int renglon = 0; renglon < renglones; renglon++) {
            for (int columna = 0; columna < columnas; columna++) {
                informacion[renglon][columna]=Math.pow(ConversorDeDatos.objectToDouble(informacion[renglon][columna]),escalar.doubleValue());
            }
        }
        return true;
    }

    /**
     * Metodo que aplica el logaritmo dado a la matriz.
     * @param tipo Representa el tipo de logaritmo.
     * @return Regresa true si se pudo aplicar y false si no.
     */
    public boolean aplicarLogaritmo(TipoLogaritmo tipo){
        for (int renglon = 0; renglon < renglones; renglon++) {
            for (int columna = 0; columna < columnas; columna++) {
                if (tipo==TipoLogaritmo.NATURAL){
                    informacion[renglon][columna]=Math.log(ConversorDeDatos.objectToDouble(informacion[renglon][columna]));
                }else if(tipo==TipoLogaritmo.BASE2){
                    informacion[renglon][columna]=Math.log(ConversorDeDatos.objectToDouble(informacion[renglon][columna]))/Math.log(2);
                }else{
                    informacion[renglon][columna]=Math.log10(ConversorDeDatos.objectToDouble(informacion[renglon][columna]));
                }
            }
        }
        return true;
    }

    /**
     * Metodo que genera una matriz diagonal.
     * @param contenido Representa el contenido de la matriz
     *                  en la diagonal.
     * @return Regresa true si fue posible o false si no.
     */
    public boolean matrizDiagonal(Number contenido){
        if(!esCuadrada())return false;
        for (int renglon = 0; renglon < renglones; renglon++) {
            for (int columna = 0; columna < columnas; columna++) {
                if(renglon==columna){
                    informacion[renglon][columna]=contenido;
                }
                else{
                    informacion[renglon][columna]=0;
                }
            }
        }
        return true;
    }

    /**
     * Metodo que verifica si la matriz es diagonal
     * superior o no.
     * @return Regresa true si es diagonal superior y false si no.
     */
    public boolean esDiagonalSuperior(){
        if (!esCuadrada())return false;
        for (int renglon = 0; renglon < renglones; renglon++) {
            for (int columna = 0; columna < renglon; columna++) {
                if(ConversorDeDatos.objectToDouble(informacion[renglon][columna])!=0)return false;
            }
        }
        return true;
    }

    /**
     * Metodo que verifica si la matriz es diagonal
     * inferior o no.
     * @return Regresa true si es diagonal inferior o false si no.
     */
    public boolean esDiagonalInferior(){
        if (!esCuadrada())return false;
        for (int renglon = 0; renglon < renglones; renglon++) {
            for (int columna = renglon+1; columna < columnas; columna++) {
                if(ConversorDeDatos.objectToDouble(informacion[renglon][columna])!=0)return false;
            }
        }
        return true;
    }

    /**
     * Metodo que eleva una matriz a una potencia.
     * @param exponente Representa el exponente.
     * @return Regresa true si fue posible hacer la potencia o false si no.
     */
    public boolean potencia(int exponente){
        Matriz2 matrizTemporal = clonar();
        Matriz2Numerica matrizPotencia =new Matriz2Numerica(matrizTemporal.renglones,matrizTemporal.columnas);
        matrizPotencia.informacion=matrizTemporal.informacion;
        for (int potencia = 1; potencia < exponente; potencia++) {
            if(!multiplicar(matrizPotencia))return false;
        }
        return true;
    }

    /**
     * Metodo que reduce a la mitad las columnas de la
     * matriz.
     * @return Regresa true si fue posible doblarla o false si no.
     */
    public boolean doblarRenglones(){
        Matriz2Numerica nuevaMatriz = new Matriz2Numerica(renglones,columnas%2==0?columnas/2:(columnas/2)+1);
        int valorModulo=1;
        boolean esImpar=columnas%2==0?false:true;
        int columnaCentral=(columnas/2);
        for (int renglon = 0; renglon < renglones; renglon++) {
            Double valorTemporal=0.0;
            for (int columna = 0; columna < columnas; columna++) {
                if(esImpar && columna==columnaCentral){
                    valorModulo--;
                    nuevaMatriz.cambiar(renglon,columna/2,informacion[renglon][columna]);
                }else{
                    if(columna%2==valorModulo){
                        nuevaMatriz.cambiar(renglon,columna/2,ConversorDeDatos.objectToDouble(informacion[renglon][columna])+valorTemporal);
                    }else{
                        valorTemporal=ConversorDeDatos.objectToDouble(informacion[renglon][columna]);
                    }
                }
            }
            if(esImpar){
                valorModulo++;
            }
        }
        renglones= nuevaMatriz.renglones;
        columnas= nuevaMatriz.columnas;
        informacion=nuevaMatriz.informacion;
        return true;
    }

    /**
     * Metodo que reduce a la mitad los renglones.
     * @return Regresa true si fue posible o false si no.
     */
    public boolean doblarColumnas(){
        Matriz2Numerica nuevaMatriz = new Matriz2Numerica(renglones%2==0?renglones/2:(renglones/2)+1,columnas);
        int valorModulo=1;
        boolean esImpar=renglones%2==0?false:true;
        int renglonCentral=(renglones/2);
        for (int columna = 0; columna < columnas; columna++) {
            Double valorTemporal=0.0;
            for (int renglon = 0; renglon < renglones; renglon++) {
                if(esImpar && renglon==renglonCentral){
                    valorModulo--;
                    nuevaMatriz.cambiar(renglon/2,columna,informacion[renglon][columna]);
                }else{
                    if(renglon%2==valorModulo){
                        nuevaMatriz.cambiar(renglon/2,columna,ConversorDeDatos.objectToDouble(informacion[renglon][columna])+valorTemporal);
                    }else{
                        valorTemporal=ConversorDeDatos.objectToDouble(informacion[renglon][columna]);
                    }
                }
            }
            if(esImpar){
                valorModulo++;
            }
        }
        renglones= nuevaMatriz.renglones;
        columnas= nuevaMatriz.columnas;
        informacion=nuevaMatriz.informacion;
        return true;
    }

    /**
     * Metodo auxiliar que verifica si la matriz es cuadrada.
     * @return Regresa true si es cuadrada o false si no.
     */
    public boolean esCuadrada(){
        return columnas==renglones;
    }





}
