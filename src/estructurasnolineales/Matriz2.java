package estructurasnolineales;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import estructurasLineales.ListaEstaticaNumerica;
import utilerias.comunes.TipoColumna;
import utilerias.comunes.TipoRenglon;


/**
 * Clase que representa una matriz de dos dimensiones.
 * @author Lorenzo Trujillo Rojas.
 * @version 1.0
 */
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

    /**
     * Metodo que valida si la matriz esta vacia.
     * @return Regresa true si esta vacia y false si no.
     */
    public boolean vacia(){
        for (int renglon = 0; renglon < renglones; renglon++) {
            for (int columna = 0; columna < columnas; columna++) {
                if(informacion[renglon][columna]!=null)return false;
            }
        }
        return true;
    }

    /**
     * Metodo que rellena la matriz con un objeto.
     * @param info Objeto con el que se rellenara.
     */
    public void rellenar(Object info){
        for (int renglon = 0; renglon < renglones; renglon++) {
            for (int columna = 0; columna < columnas; columna++) {
                informacion[renglon][columna]=info;
            }
        }
    }

    /**
     * Metodo con el que se cambia un objeto por otro
     * en una matriz2.
     * @param renglon Renglon en la posicion en la que se cambiara.
     * @param columna Columna en la que se cambiara el valor.
     * @param info Objeto con el que se cambiara.
     * @return Regresa true si se pudo cambiar y false si no.
     */
    public boolean cambiar(int renglon, int columna, Object info){
        if (validarRango(renglon, renglones) &&
                validarRango(columna, columnas)){
            informacion[renglon][columna]=info;
            return true;
        }
        return false;
    }

    /**
     * Metodo que obtiene un objeto de una posicion de la matriz.
     * @param renglon Representa el renglon donde se encuentra.
     * @param columna Representa la columna donde se encuentra.
     * @return Regresa el objeto que se encuentra en esa posicion.
     */
    public Object obtener(int renglon, int columna){
        if (validarRango(renglon, renglones) &&
                validarRango(columna, columnas)){

            return informacion[renglon][columna];
        }
        return null;
    }

    /**
     * Metodo que imprime por columnas
     */
    public void imprimirXColumnas(){
        for (int renglon = 0; renglon < renglones; renglon++) {
            for (int columna = 0; columna < columnas; columna++) {
                SalidaPorDefecto.terminal(informacion[renglon][columna]+" ");
            }
            SalidaPorDefecto.terminal("\n");
        }
    }

    /**
     * Metodo que imprime por renglones.
     */
    public void imprimirXRenglones(){
        for (int columna = 0; columna < columnas; columna++) {
            for (int renglon = 0; renglon < renglones; renglon++) {
                SalidaPorDefecto.terminal(informacion[renglon][columna]+" ");
            }
            SalidaPorDefecto.terminal("\n");
        }
    }

    /**
     * Transforma la matriz en su transpuesta.
     */
    public void transpuesta(){
        Object[][] matrizTemporal = new Object[this.columnas][this.renglones];
        for (int renglon = 0; renglon < renglones; renglon++) {
            for (int columna = 0; columna < columnas; columna++) {
                matrizTemporal[columna][renglon]=informacion[renglon][columna];
            }
        }
        informacion=matrizTemporal;
        int temporal=this.columnas;
        this.columnas=this.renglones;
        this.renglones=temporal;
    }

    /**
     * Metodo que obtiene una copia de la matriz original.
     * @return Regresa una copia de la matriz.
     */
    public Matriz2 clonar(){
        Matriz2 copia = new Matriz2(renglones,columnas);

        for (int renglon = 0; renglon < renglones; renglon++) {
            for (int columna = 0; columna < columnas; columna++) {
                copia.cambiar(renglon,columna,obtener(renglon,columna));
            }
        }

        return copia;
    }

    /**
     * Metodo que verifica si dos matrices son iguales.
     * @param matriz2 Matriz con la que se comparara.
     * @return Regresa true si son iguales o false si no.
     */
    public boolean esIgual(Matriz2 matriz2){
        for (int renglon = 0; renglon < renglones; renglon++) {
            for (int columna = 0; columna < columnas; columna++) {
                if (!(obtener(renglon,columna).toString().equalsIgnoreCase(matriz2.obtener(renglon,columna).toString())))return false;
            }
        }
        return true;
    }

    /**
     * Metodo que genera un vector en forma de columna
     * en una matriz vacia.
     * @param filas Representa las filas que tendra
     *              el vector.
     * @param info Representa el valor con el que se relleanra
     *             el vector.
     * @return Regresa true si se pudo realizar y false si no.
     */
    public boolean vectorColumna(int filas, Object info){
        if(!vacia())return false;
        renglones=filas;
        columnas=1;
        informacion=new Object[renglones][columnas];
        rellenar(info);
        return true;
    }

    /**
     * Metodo que genera un vector en forma de fila
     * en una matriz vacia.
     * @param columnas Representa las filas que tendra
     *                 el vector.
     * @param info Representa el valor con el que se rellenara
     *             el vector.
     * @return Regresa true si se pudo realizar y false si no.
     */
    public boolean vectorRenglon(int columnas, Object info){
        if(!vacia())return false;
        renglones=1;
        this.columnas=columnas;
        informacion=new Object[renglones][this.columnas];
        rellenar(info);
        return true;
    }

    /**
     * Metodo que sustituye los valores de una matriz por los valores de otra,
     * redimensionando la matriz a la que se pasa como argumento.
     * @param matriz2 Representa la matriz que se usara para la sustitucion.
     * @return Regresa true si se pudo sustituir y false si no.
     */
    public boolean substituir(Matriz2 matriz2){
        try {
            columnas= matriz2.columnas;
            renglones= matriz2.renglones;
            for (int renglon = 0; renglon < renglones; renglon++) {
                for (int columna = 0; columna < columnas; columna++) {
                    informacion[renglon][columna]=matriz2.informacion[renglon][columna];
                }
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * Metodo que agrega un renglon a la matriz.
     * @param arreglo Representa el vector que se agregara.
     * @return Regresa true si se pudo agregar y false si no.
     */
    public boolean agregarRenglon(ListaEstatica arreglo){
        if(arreglo.cantidad()!=columnas)return false;
        Matriz2 matriz2 = clonar();
        renglones++;
        informacion=new Object[renglones][columnas];
        if(!rellenarMatrizConOtra(matriz2))return false;
        for (int iteradorLista = 0; iteradorLista < arreglo.cantidad(); iteradorLista++) {
            informacion[renglones-1][iteradorLista]=arreglo.obtener(iteradorLista);
        }
        return true;
    }

    /**
     * Metodo que agrega una columna a la matriz.
     * @param arreglo Representa el vector que se agregara.
     * @return Regresa true si se pudo agregar y false si no.
     */
    public boolean agregarColumna(ListaEstatica arreglo){
        if(arreglo.cantidad()!=renglones)return false;
        Matriz2 matriz2 = clonar();
        columnas++;
        informacion=new Object[renglones][columnas];
        if(!rellenarMatrizConOtra(matriz2))return false;
        for (int iteradorLista = 0; iteradorLista < arreglo.cantidad(); iteradorLista++) {
            informacion[iteradorLista][columnas-1]=arreglo.obtener(iteradorLista);
        }
        return true;
    }


    /**
     * Metodo interno para rellenar con una matriz a la original
     * siempre y cuando esta sea mayor o igual a la nueva.
     * Los valores se sobreescriben.
     * @param matriz2 Representa la matriz a agregar.
     * @return Regresa true si se pudo agregar y false si no.
     */
    private boolean rellenarMatrizConOtra(Matriz2 matriz2){
        if(matriz2.columnas>columnas || matriz2.renglones>renglones)return false;
        for (int renglon = 0; renglon < matriz2.renglones; renglon++) {
            for (int columna = 0; columna < matriz2.columnas; columna++) {
                informacion[renglon][columna]=matriz2.informacion[renglon][columna];
            }
        }
        return true;
    }

    /**
     * Metodo que agrega una matriz a la derecha de la actual.
     * @param matriz2 Representa la matriz a agregar.
     * @return Regresa true si se pudo agregar y false si no.
     */
    public boolean agregarMatrizXColumna(Matriz2 matriz2){
        if(renglones!=matriz2.renglones)return false;
        Object[][] nuevoArreglo = new Object[renglones][columnas+ matriz2.columnas];
        for (int renglon = 0; renglon < renglones; renglon++) {
            for (int columna = 0; columna < columnas; columna++) {
                nuevoArreglo[renglon][columna]=informacion[renglon][columna];
            }
        }
        for (int renglon = 0; renglon < matriz2.renglones; renglon++) {
            for (int columna = columnas; columna < matriz2.columnas+columnas; columna++) {
                nuevoArreglo[renglon][columna]=matriz2.informacion[renglon][columna- columnas];
            }
        }
        informacion=nuevoArreglo;
        columnas+= matriz2.columnas;
        return true;
    }

    /**
     * Metodo que agrega una matriz a la debajo de la actual.
     * @param matriz2 Representa la matriz a agregar.
     * @return Regresa true si se pudo agregar y false si no.
     */
    public boolean agregarMatrizXRenglon(Matriz2 matriz2){
        if(columnas!=matriz2.columnas)return false;
        Object[][] nuevoArreglo = new Object[renglones+matriz2.renglones][columnas];
        for (int renglon = 0; renglon < renglones; renglon++) {
            for (int columna = 0; columna < columnas; columna++) {
                nuevoArreglo[renglon][columna]=informacion[renglon][columna];
            }
        }
        for (int renglon = renglones; renglon < matriz2.renglones+renglones; renglon++) {
            for (int columna = 0; columna < matriz2.columnas; columna++) {
                nuevoArreglo[renglon][columna]=matriz2.informacion[renglon-renglones][columna];
            }
        }
        informacion=nuevoArreglo;
        renglones+= matriz2.renglones;
        return true;
    }

    /**
     * Metodo que convierte la matriz actual en un vector
     * apilando las columnas una sobre otra.
     * @return Regresa el vector creado.
     */
    public Matriz2 aVectorColumna(){
        Matriz2 resultado = new Matriz2(renglones*columnas,1);
        int posicionVector=0;
        for (int columna = 0; columna < columnas; columna++) {
            for (int renglon = 0; renglon < renglones; renglon++) {
                resultado.cambiar(posicionVector, 0, informacion[renglon][columna]);
                posicionVector++;
            }
        }

        return resultado;
    }

    /**
     * Metodo que convierte la matriz actual en un vector
     * agregando los renglones uno despues de otro.
     * @return Regresa el vector creado.
     */
    public Matriz2 aVectorRenglon(){
        Matriz2 resultado = new Matriz2(1,renglones*columnas);
        int posicionVector=0;
        for (int renglon = 0; renglon < renglones; renglon++) {
            for (int columna = 0; columna < columnas; columna++) {
                resultado.cambiar(0, posicionVector, informacion[renglon][columna]);
                posicionVector++;
            }
        }
        return resultado;
    }

    /**
     * Metodo para quitar un renglon de la matriz.
     * @param tipoRen Representa el renglon que se quiere eliminar
     *                (SUP superior, INF inferior).
     * @return Regresa true si se pudo quitar y false si no.
     */
    public boolean quitarRenglon(TipoRenglon tipoRen){
        if(TipoRenglon.INF==tipoRen){
            return eliminarRenglon(renglones-1);
        }
        else{
            return eliminarRenglon(0);
        }
    }

    /**
     * Metodo para quitar un renglon de la matriz.
     * @param tipoCol Representa la columna que se quiere eliminar
     *                (IZQ izquierda, DER derecha).
     * @return Regresa true si se pudo quitar y false si no.
     */
    public boolean quitarColumna(TipoColumna tipoCol){
        if(TipoColumna.IZQ==tipoCol){
            return eliminarColumna(columnas-1);
        }
        else{
            return eliminarColumna(0);
        }
    }

    /**
     * Metodo que elimina un renglon de la matriz.
     * @param renglon Representa el indice a eliminar.
     * @return Regresa true si fue posible eliminarlo y false si no.
     */
    public boolean eliminarRenglon(int renglon){
        if (!validarRango(renglon,renglones))return false;
        Object[][] nuevaMatriz = new Object[--renglones][columnas];
        boolean flag = true;
        for (int fila = 0; fila < renglones; fila++) {
            if(fila!=renglon && flag){
                for (int columna = 0; columna < columnas; columna++) {
                    nuevaMatriz[fila][columna]=informacion[fila][columna];
                }
            }else{
                flag=false;
                for (int columna = 0; columna < columnas; columna++) {
                    nuevaMatriz[fila][columna]=informacion[fila+1][columna];
                }
            }
        }
        informacion=nuevaMatriz;
        return true;
    }


    /**
     * Metodo que sirve para eliminar una columna por indice.
     * @param columna Representa el indice de la columna a eliminar.
     * @return Regresa true si se pudo agregar y false si no.
     */
    public boolean eliminarColumna(int columna){
        if (!validarRango(columna,columnas))return false;
        Object[][] nuevaMatriz = new Object[renglones][--columnas];
        boolean flag = true;
        for (int col = 0; col < columnas; col++) {
            if(col!=columna && flag){
                for (int renglon = 0; renglon < renglones; renglon++) {
                    nuevaMatriz[renglon][col]=informacion[renglon][col];
                }
            }else{
                flag=false;
                for (int renglon = 0; renglon < renglones; renglon++) {
                    nuevaMatriz[renglon][col]=informacion[renglon][col+1];
                }
            }
        }
        informacion=nuevaMatriz;
        return true;
    }

    /**
     * Metodo que convierte un grupo de matrices en una matriz3.
     * @param matrices Lista de matrices, ademas de la actual,
     *                 que conformaran la matriz3.
     * @return Regresa la matriz3 creada o null si no se pudo crear.
     */
    public Matriz3 aMatriz3(ListaEstatica matrices){
        Matriz3 respuesta = new Matriz3(renglones,columnas,matrices.cantidad()+1);
        for (int iteradorMatrices = 0; iteradorMatrices < matrices.cantidad(); iteradorMatrices++) {
            if(!(matrices.obtener(iteradorMatrices) instanceof Matriz2 matrizTemporal))return null;
            if(matrizTemporal.columnas!=columnas || matrizTemporal.renglones!=renglones)return null;
            for (int renglon = 0; renglon < renglones; renglon++) {
                for (int columna = 0; columna < columnas; columna++) {
                    respuesta.cambiar(renglon,columna,iteradorMatrices,matrizTemporal.obtener(renglon,columna));
                }
            }
        }
        for (int renglon = 0; renglon < renglones; renglon++) {
            for (int columna = 0; columna < columnas; columna++) {
                respuesta.cambiar(renglon,columna,matrices.cantidad(),informacion[renglon][columna]);
            }
        }
        return respuesta;
    }

    public boolean espejoVertical(){
        for (int columna = 0; columna < columnas/2; columna++) {
            for (int renglon = 0; renglon < renglones; renglon++) {
                Object listaTemporal = obtener(renglon,columna);
                cambiar(renglon,columna,obtener(renglon,(columnas-1)-columna));
                cambiar(renglon,((columnas-1)-columna),listaTemporal);
            }
        }
        return true;
    }

    public boolean espejoHorizontal(){
        for (int columna = 0; columna < columnas; columna++) {
            for (int renglon = 0; renglon < renglones/2; renglon++) {
                Object listaTemporal = obtener(renglon,columna);
                cambiar(renglon,columna,obtener((renglones-1)-renglon,columna));
                cambiar((renglones-1)-renglon,columna,listaTemporal);
            }
        }
        return true;
    }

    public boolean girar90gradosHorario(){
        Matriz2 matrizTemporal = new Matriz2(columnas,renglones);
        for (int renglon = 0; renglon < renglones; renglon++) {
            for (int columna = 0; columna < columnas; columna++) {
                matrizTemporal.cambiar(columna,renglones-1-renglon,obtener(renglon,columna));
            }
        }
        columnas= matrizTemporal.columnas;
        renglones= matrizTemporal.renglones;

        informacion=matrizTemporal.informacion;
        return true;
    }


    /**
     * Valida un rango en los indices.
     * @param indice Indice a validar.
     * @param maximo Maximo indice que fallara.
     * @return
     */
    private boolean validarRango(int indice, int maximo){
        if (indice<0 || indice>=maximo)return false;
        return true;
    }

    /**
     * Metodo que obtiene la cantidad de renglones.
     * @return Regresa la cantidad de renglones.
     */
    public int obtenerRenglones() {
        return renglones;
    }

    /**
     * Metodo que obtiene la cantidad de columnas de la matriz
     * @return Regresa la cantidad de columnas.
     */
    public int obtenerColumnas() {
        return columnas;
    }

    @Override
    public String toString() {
        return "Matriz2{}";
    }
}

