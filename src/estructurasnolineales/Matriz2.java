package estructurasnolineales;

import entradasalida.SalidaPorDefecto;

public class Matriz2 {
    protected int renglones;
    protected int columnas;

    protected Object[][] informacion;

    public Matriz2(int renglones, int columnas) {
        this.renglones = renglones;
        this.columnas = columnas;
        informacion= new Object[renglones][columnas];
    }

    public Matriz2(int renglones, int columnas, Object info) {
        this.renglones = renglones;
        this.columnas = columnas;
        informacion= new Object[renglones][columnas];
        rellenar(info);
    }

    public void rellenar(Object info){
        for (int renglon = 0; renglon < renglones; renglon++) {
            for (int columna = 0; columna < columnas; columna++) {
                informacion[renglon][columna]=info;

            }
        }
    }

    public boolean cambiar(int renglon, int columna, Object info){
        if (validarRango(renglon, renglones) &&
                validarRango(columna, columnas)){
            informacion[renglon][columna]=info;
            return true;
        }
        return false;
    }

    public Object obtener(int renglon, int columna, int prof){
        if (validarRango(renglon, renglones) &&
                validarRango(columna, columnas)){

            return informacion[renglon][columna];
        }
        return null;
    }

    public void imprimirXColumnas(){
        for (int renglon = 0; renglon < renglones; renglon++) {
            for (int columna = 0; columna < columnas; columna++) {
                SalidaPorDefecto.terminal(informacion[renglon][columna]+" ");
            }
            SalidaPorDefecto.terminal("\n");
        }
    }

    private boolean validarRango(int indice, int maximo){
        if (indice<0 || indice>=maximo)return false;
        return true;
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

    @Override
    public String toString() {
        return "Matriz2{}";
    }
}

