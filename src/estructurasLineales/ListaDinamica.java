package estructurasLineales;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.auxiliares.Nodo;
import estructurasnolineales.Matriz2;
import utilerias.comunes.TipoTabla;

/**
 * Clase que representa una lista dinamica.
 * @author Lorenzo Trujillo Rojas.
 * @version 1.0.
 */
public class ListaDinamica implements Lista{
    protected Nodo primero;
    protected Nodo ultimo;
    protected Nodo nodoActual;

    public ListaDinamica() {
        primero=null;
        ultimo=null;
        nodoActual=null;
    }

    @Override
    public boolean vacia() {
        if(primero==null)return true;
        return false;
    }

    @Override
    public int agregar(Object info) {
        Nodo nuevoNodo = new Nodo(info);
        if(nuevoNodo==null)return -1;

        if(vacia()) {
            primero = nuevoNodo;
            ultimo = nuevoNodo;
            return 1;
        }
        ultimo.setLigaDer(nuevoNodo);
        ultimo=nuevoNodo;
        return 1;
    }

    /**
     * Metodo que agrega un nodo al inicio.
     * @param info Representa la informacion que tendra el nodo.
     * @return Regresa true si fue posible agregar y false si no.
     */
    public int agregarInicio(Object info){
        Nodo nuevoNodo = new Nodo(info);
        if(nuevoNodo==null)return -1;

        if(vacia()) {
            primero = nuevoNodo;
            ultimo = nuevoNodo;
            return 1;
        }
        nuevoNodo.setLigaDer(primero);
        primero=nuevoNodo;
        return 1;
    }

    @Override
    public void imprimir() {
        Nodo temporal = primero;
        while (temporal!=null){
            SalidaPorDefecto.terminal(temporal.getInfo()+" -> ");
            temporal=temporal.getLigaDer();
        }
        SalidaPorDefecto.terminal("null\n");
    }

    @Override
    public void imprimirOI() {
        PilaDinamica pilaTemporal = new PilaDinamica();
        Nodo current = primero;
        while(current!=null){
            pilaTemporal.poner(current.getInfo());
            current = current.getLigaDer();
        }
        SalidaPorDefecto.terminal("null");
        while (!pilaTemporal.vacio()){
            SalidaPorDefecto.terminal(" <- "+pilaTemporal.quitar());
        }
        SalidaPorDefecto.terminal("\n");
    }

    @Override
    public Object buscar(Object info) {
        Nodo nodoBuscado = primero;
        while (nodoBuscado!=null && !info.toString().equalsIgnoreCase(nodoBuscado.getInfo().toString())){
            nodoBuscado=nodoBuscado.getLigaDer();
        }
        return nodoBuscado==null ? null : nodoBuscado.getInfo();
    }

    @Override
    public Object eliminar(Object info) {
        if(vacia())return null;

        ListaEstatica listaRetorno = buscarAnterior(info);
        Nodo anterior = (Nodo) listaRetorno.obtener(0);
        Nodo nodoBuscado = (Nodo) listaRetorno.obtener(1);
        if (nodoBuscado==null)return null;
        Object respaldo = nodoBuscado.getInfo();
        if(primero==ultimo){
            primero=null;
            ultimo=null;
        }
        else if (nodoBuscado==primero){
            primero=primero.getLigaDer();
        }
        else if (nodoBuscado==ultimo){
            anterior.setLigaDer(null);
            ultimo=anterior;
        }
        else{
            Nodo siguiente = nodoBuscado.getLigaDer();
            anterior.setLigaDer(siguiente);
        }
        return respaldo;

    }

    /**
     * Metodo que busca el anterior de un nodo buscado.
     * @param info Representa el objeto a buscar.
     * @return Regresa una lista con el objeto buscado y el anterior.
     */
    private ListaEstatica buscarAnterior(Object info){
        ListaEstatica respuesta = new ListaEstatica(2);
        Nodo anterior = primero;
        Nodo nodoBuscado = primero;

        while (nodoBuscado!=null && !info.toString().equalsIgnoreCase(nodoBuscado.getInfo().toString())){
            anterior=nodoBuscado;
            nodoBuscado=nodoBuscado.getLigaDer();
        }

        if (nodoBuscado!=null){
            respuesta.agregar(anterior);
            respuesta.agregar(nodoBuscado);
        }else{
            respuesta.rellenar(null);
        }
        return respuesta;
    }

    @Override
    public Object verUltimo() {
        return ultimo==null? null: ultimo.getInfo();
    }

    @Override
    public boolean esIgual(Object lista) {
        if(!(lista instanceof Lista lista2))return false;
        inicializarIterador();
        int contador =0;
        while (hayNodo()){
            if(!obtenerNodo().equals(lista2.obtener(contador))) return false;
            contador++;
        }
        return true;
    }

    @Override
    public boolean cambiar(Object infoViejo, Object infoNuevo, int numVeces) {
        if(vacia())return false;
        Nodo curr = primero;
        int contador = 0;
        while (curr!=null && contador<numVeces){
            if(curr.getInfo().equals(infoViejo)){
                curr.setInfo(infoNuevo);
                contador++;
            }
            curr=curr.getLigaDer();
        }
        return true;
    }

    @Override
    public ListaEstatica buscarValores(Object info) {
        ListaEstatica listaIndices = new ListaEstatica(cantidad());
        inicializarIterador();
        int contador = 0;
        while (hayNodo()){
            Object temporal = obtenerNodo();
            if(temporal.toString().equalsIgnoreCase(info.toString())){
                listaIndices.agregar(contador);
            }
            contador++;
        }
        return listaIndices;
    }

    @Override
    public Object eliminar() {
        if(vacia())return null;
        Nodo respaldo;
        if(primero.equals(ultimo)){
            respaldo=primero;
            vaciar();
            return respaldo.getInfo();
        }
        Nodo penultimo = primero;
        while(!penultimo.getLigaDer().equals(ultimo)){
            penultimo = penultimo.getLigaDer();
        }
        respaldo=ultimo;
        penultimo.setLigaDer(null);
        ultimo=penultimo;
        return respaldo.getInfo();
    }

    @Override
    public Object eliminarInicio(){
        if(vacia())return null;
        Nodo respaldo=primero;
        if(primero.equals(ultimo)){
            vaciar();
            return respaldo.getInfo();
        }
        respaldo = primero;
        primero = primero.getLigaDer();
        return respaldo.getInfo();
    }

    @Override
    public void vaciar() {
        primero=null;
        ultimo=null;
    }

    public void inicializarIterador(){
        nodoActual=primero;
    }

    public Object obtenerNodo(){
        if(!hayNodo())return null;
        Object respaldo = nodoActual.getInfo();
        nodoActual=nodoActual.getLigaDer();
        return respaldo;
    }
    public boolean hayNodo(){
        return nodoActual!=null;
    }

    @Override
    public boolean agregarLista(Object lista2) {
        if(!(lista2 instanceof Lista lista))return false;
        return agregarLista(lista);
    }

    @Override
    public void invertir() {
        if(vacia())return;
        PilaDinamica pilaTemporal = new PilaDinamica();
        while(primero!=null){
            pilaTemporal.poner(primero.getInfo());
            primero = primero.getLigaDer();
        }
        vaciar();
        while (!pilaTemporal.vacio()){
            agregar(pilaTemporal.quitar());
        }
    }

    @Override
    public int contar(Object info) {
        int contador=0;
        inicializarIterador();
        while(hayNodo()){
            if(info.equals(obtenerNodo())){
                contador++;
            }
        }
        return contador;
    }

    @Override
    public boolean eliminarLista(Object lista2) {
        if(!(lista2 instanceof Lista lista))return false;
        if(vacia())return false;
        for (int iteradorListaEstatica = 0; iteradorListaEstatica < lista.cantidad(); iteradorListaEstatica++) {
            Object objetoTemporal = lista.obtener(iteradorListaEstatica);
            while(eliminar(objetoTemporal)!=null){}
        }
        return true;
    }

    @Override
    public void rellenar(Object info, int cantidad) {
        vaciar();
        for (int iterador = 0; iterador < cantidad; iterador++) {
            agregar(info);
        }
    }

    @Deprecated
    @Override
    public void rellenar(Object info) {
    }

    @Override
    public Lista clonar() {
        inicializarIterador();
        ListaDinamica listaClonada = new ListaDinamica();
        while (hayNodo()){
            Object temp= obtenerNodo();
            if(((Integer)listaClonada.agregar(temp))==-1){
                return null;
            }
        }
        return listaClonada;
    }

    @Override
    public Lista subLista(int indiceInicial, int indiceFinal) {
        if(!validarRango(indiceInicial, indiceFinal))return null;
        ListaDinamica subLista = new ListaDinamica();
        inicializarIterador();
        for (int iterador = indiceInicial; iterador <= indiceFinal; iterador++) {
            subLista.agregar(obtener(iterador));
        }
        return subLista;
    }

    @Override
    public boolean insertar(int indice, Object info) {
        if(!validarindice(indice))return false;
        if(indice==0)return agregarInicio(info)==1;
        Nodo curr = primero;
        while (indice>1){
            indice--;
            curr = curr.getLigaDer();
        }
        Nodo nuevoNodo = new Nodo(info);
        nuevoNodo.setLigaDer(curr.getLigaDer());
        curr.setLigaDer(nuevoNodo);
        return true;
    }

    @Override
    public boolean copiarLista(Lista lista2) {
        if(!(lista2 instanceof ListaDinamica lista))return false;
        vaciar();
        lista.inicializarIterador();
        while(lista.hayNodo()){
            agregar(lista.obtenerNodo());
        }
        return true;
    }

    /**
     * Metodo que transforma la lista dinamina en una listaEstatica
     * @return Regresa una lista estatica si hay elementos o null si no.
     */
    public ListaEstatica aListaEstatica(){
        if(vacia())return null;
        ListaEstatica listaTemporal = new ListaEstatica(cantidad());
        inicializarIterador();
        while (hayNodo()){
            listaTemporal.agregar(obtenerNodo());
        }
        return listaTemporal;
    }

    /**
     * Metodo que convierte la lista en listaEstatica excepto los elementos que
     * tiene la lista de elementos a descartar.
     * @param elementosADescartar Representa la lista de elementos a descartar.
     * @return Regresa la listaEstatica con lo elementos de la listaDinamica.
     */
    public ListaEstatica aListaEstatica(ListaEstatica elementosADescartar){
        if(vacia()) return null;
        ListaEstatica listaTemporal = new ListaEstatica(cantidad());
        inicializarIterador();
        while (hayNodo()){
            Object objetoTemporal = obtenerNodo();
            if(((Integer)elementosADescartar.buscar(objetoTemporal))<0){
                listaTemporal.agregar(objetoTemporal);
            }
        }
        return listaTemporal;
    }

    /**
     * Metodo que transforma la lista dinamica en una matriz2.
     * @param filas Representa el numero de filas que tendra la matriz.
     * @param columnas Representa el numero de columnas que tendra la matriz.
     * @return Regresa una matriz rellena con los elementos de la lista dinamica.
     */
    public Matriz2 aMatriz2(int filas, int columnas){
        Matriz2 matrizTemporal = new Matriz2(filas, columnas);
        inicializarIterador();
        for (int renglon = 0; renglon < filas; renglon++) {
            for (int columna = 0; columna < columnas; columna++) {
                matrizTemporal.cambiar(renglon,columna,obtenerNodo());
            }
        }
        return matrizTemporal;
    }

    /**
     * Metodo que agrega los elementos de una lista a la lista dinamica.
     * @param listaDatos2 Representa la lista a agregar.
     * @return Regresa true si se pudo agregar o false si no.
     */
    public boolean agregarLista(Lista listaDatos2){
        if(listaDatos2.vacia())return false;

        while (!listaDatos2.vacia()){
            if(agregar(listaDatos2.eliminarInicio())==-1)return false;
        }
        return true;
    }

    /**
     * Metodo que agrega una matriz a la lista.
     * @param tabla Representa la matriz a agregar.
     * @param enumTipoTabla Representa la forma en que se recorrera la matriz.
     * @return Regresa true si fue posible o false si no.
     */
    public boolean agregarMatriz2D(Matriz2 tabla, TipoTabla enumTipoTabla){
        if(enumTipoTabla==TipoTabla.RENGLON){
            for (int renglon = 0; renglon < tabla.obtenerRenglones(); renglon++) {
                for (int columna = 0; columna < tabla.obtenerColumnas(); columna++) {
                    if(agregar(tabla.obtener(renglon,columna))==-1)return false;
                }
            }
            return true;
        }else{
            for (int columna = 0; columna < tabla.obtenerColumnas(); columna++) {
                for (int renglon = 0; renglon < tabla.obtenerRenglones(); renglon++) {
                    if(agregar(tabla.obtener(renglon,columna))==-1)return false;
                }
            }
            return true;
        }
    }



    @Override
    public int cantidad(){
        inicializarIterador();
        int cantidad = 0;
        while (obtenerNodo()!=null){
            cantidad++;
        }
        return cantidad;
    }

    /**
     * Metodo que indica si una lista dinamica esta llena.
     * @return Regresa true si esta llena y false si no.
     */
    public boolean llena() {
        Nodo nodo = new Nodo();
        return nodo==null;
    }

    @Override
    public Object obtener(int indice) {
        if(vacia())return null;
        inicializarIterador();
        int contador = 0;
        while(contador<indice && obtenerNodo()!=null){
            contador++;
        }

        return obtenerNodo();
    }

    /**
     * Metodo que permite cambiar un objeto por otro en un indice especifica.
     * @param indice Representa el indice del objeto a cambiar.
     * @param info Representa el valor del nuevo objeto.
     * @return Regresa true si se pudo cambiar y false si no.
     */
    public boolean cambiar(int indice, Object info) {
        if(vacia())return false;
        Nodo current = primero;
        int contador = 0;
        while(current!=null && contador<indice){
            contador++;
            current= current.getLigaDer();
        }
        if(current==null)return false;
        current.setInfo(info);
        return true;
    }


    /**
     * Metodo que permite eliminar un objeto por indice.
     * @param indice Representa el indice del objeto a eliminar.
     * @return Regresa el objeto eliminado o null si no se pudo eliminar.
     */
    public Object eliminar(int indice) {
        if(vacia())return null;
        if(indice==0)return eliminarInicio();
        Nodo current = primero;
        while(current.getLigaDer()!=null){
            if(indice==1){
                Nodo respaldo=current.getLigaDer();
                current.setLigaDer(current.getLigaDer().getLigaDer());
                if(respaldo.getLigaDer()==null){
                    ultimo=current;
                }
                return respaldo;
            }
            current=current.getLigaDer();
            indice--;
        }
        return null;
    }

    /**
     * Metodo que redimensiona la lista dinamica.
     * @param maximo Representa la cantidad de elementos que debera tener la lista.
     * @return Retorna true si fue posible redimensionar o false si no.
     */
    public boolean redimensionar(int maximo) {
        Nodo current = primero;
        while(current!=null && maximo-1>0){
            current = current.getLigaDer();
            maximo--;
        }
        if(current!=null){
            ultimo=current;
            ultimo.setLigaDer(null);
            return true;
        }
        if(maximo>0){
            for (int iterador = 0; iterador < maximo; iterador++) {
                agregar(null);
            }
            return true;
        }
        return false;
    }


    /**
     * Metodo que vlida que dos indices esten en el rango de una lista dinamica.
     * @param indiceInicial Representa el indice inicial del rango.
     * @param indiceFinal Representa el indice final del rango.
     * @return Regresa true si es valido y false si no.
     */
    private boolean validarRango(int indiceInicial, int indiceFinal){
        if(indiceFinal<indiceInicial)return false;
        if(indiceInicial<0 || indiceFinal>= cantidad())return false;
        return true;
    }

    public void imprimirRecursivo(){
        Nodo nuevoNodo = primero;
        imprimirRecursivo(nuevoNodo);
    }

    private void imprimirRecursivo(Nodo nodo){
        if(nodo==null){
            SalidaPorDefecto.terminal("null");
            return;
        }
        SalidaPorDefecto.terminal(nodo.getInfo()+" -> ");
        imprimirRecursivo(nodo.getLigaDer());
    }

    /**
     * Metodo que valida un indice en el rango de la lista dinamica.
     * @param indice Representa el indice que se deseea evaluar.
     * @return Regresa true si es valido o false si no.
     */
    private boolean validarindice(int indice){
        if(indice<0 || indice>= cantidad())return false;
        return true;
    }
}