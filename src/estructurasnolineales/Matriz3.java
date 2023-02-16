package estructurasnolineales;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;

import java.security.KeyStore;

public class Matriz3 {

    protected int renglones;
    protected int columnas;
    protected int profundidad;

    protected Object[][][] informacion;

    public Matriz3(int renglones, int columnas, int profundidad) {
        this.renglones = renglones;
        this.columnas = columnas;
        this.profundidad = profundidad;
        informacion= new Object[renglones][columnas][profundidad];
    }

    public Matriz3(int renglones, int columnas, int profundidad, Object info) {
        this.renglones = renglones;
        this.columnas = columnas;
        this.profundidad = profundidad;
        informacion= new Object[renglones][columnas][profundidad];
        rellenar(info);
    }

    public void rellenar(Object info){
        for (int renglon = 0; renglon < renglones; renglon++) {
            for (int columna = 0; columna < columnas; columna++) {
                for (int cadaProfundidad = 0; cadaProfundidad < profundidad; cadaProfundidad++) {
                    informacion[renglon][columna][cadaProfundidad]=info;
                }
            }
        }
    }

    public boolean cambiar(int renglon, int columna, int prof, Object info){
        if (validarRango(renglon, renglones) &&
            validarRango(columna, columnas) &&
            validarRango(prof, profundidad)){
            informacion[renglon][columna][prof]=info;
            return true;
        }
        return false;
    }

    public Object obtener(int renglon, int columna, int prof){
        if (validarRango(renglon, renglones) &&
                validarRango(columna, columnas) &&
                validarRango(profundidad, prof)){

            return informacion[renglon][columna][prof];
        }
        return null;
    }

    public void imprimirXColumnas(){
        for (int columna = 0; columna < columnas; columna++) {
            for (int renglon = 0; renglon < renglones; renglon++) {
                for (int prof = 0; prof < profundidad; prof++) {
                    SalidaPorDefecto.terminal(informacion[renglon][columna][prof]+" ");
                }
                SalidaPorDefecto.terminal("\n");
            }
            SalidaPorDefecto.terminal("\n\n");
        }
    }

    private boolean validarRango(int indice, int maximo){
        if (indice<0 || indice>=maximo)return false;
        return true;
    }

    public ListaEstatica aMatrices2(){
        ListaEstatica matrices2 = new ListaEstatica(columnas);
        for (int columna = 0; columna < columnas; columna++) {
            Matriz2 matriz2Temporal = new Matriz2(renglones,profundidad);
            for (int renglon = 0; renglon < renglones; renglon++) {
                for (int prof = 0; prof < profundidad; prof++) {
                    matriz2Temporal.cambiar(renglon,prof,informacion[renglon][columna][prof]);
                }
            }
            matrices2.agregar(matriz2Temporal);
        }
        return matrices2;
    }

    public int getRenglones() {
        return renglones;
    }

    public void setRenglones(int renglones) {
        this.renglones = renglones;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public int getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }
}
