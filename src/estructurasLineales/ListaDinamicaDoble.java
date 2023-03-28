package estructurasLineales;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.auxiliares.NodoDoble;

public class ListaDinamicaDoble implements Lista{
    protected NodoDoble primero;
    protected NodoDoble ultimo;

    public ListaDinamicaDoble() {
        this.primero = null;
        this.ultimo = null;
    }

    @Override
    public boolean vacia() {
        if(primero==null)return true;
        return false;
    }

    @Override
    public int agregar(Object info) {
        NodoDoble nuevoNodo = new NodoDoble(info);
        if(nuevoNodo==null)return -1;
        if(vacia()){
            primero = nuevoNodo;
        } else{
            ultimo.setLigaDerecha(nuevoNodo);
            nuevoNodo.setLigaIzquierda(ultimo);
        }
        ultimo = nuevoNodo;
        return 1;
    }

    @Override
    public void imprimir() {
        if (vacia()){
            SalidaPorDefecto.terminal("null\n");
            return;
        }
        SalidaPorDefecto.terminal("null <- ");
        NodoDoble nodoActual = primero;
        while(nodoActual!=ultimo){
            SalidaPorDefecto.terminal(nodoActual.getInfo()+" <-> ");
            nodoActual=nodoActual.getLigaDerecha();
        }
        SalidaPorDefecto.terminal(ultimo.getInfo()+" -> null\n");
    }

    @Override
    public void imprimirOI() {

    }

    @Override
    public Object buscar(Object info) {
        return null;
    }

    @Override
    public Object eliminar(Object info) {
        return null;
    }

    @Override
    public Object verUltimo() {
        return ultimo==null? null : ultimo.getInfo();
    }

    @Override
    public boolean esIgual(Object lista) {
        return false;
    }

    @Override
    public boolean cambiar(Object infoViejo, Object infoNuevo, int numVeces) {
        return false;
    }

    @Override
    public ListaEstatica buscarValores(Object info) {
        return null;
    }

    @Override
    public Object eliminar() {
        if(vacia())return null;
        Object respaldo=ultimo.getInfo();
        if(ultimo==primero){
            ultimo=null;
            primero=null;
        } else{
            ultimo=ultimo.getLigaIzquierda();
            ultimo.setLigaDerecha(null);
        }
        return respaldo;
    }

    @Override
    public void vaciar() {

    }

    @Override
    public boolean agregarLista(Object lista2) {
        return false;
    }

    @Override
    public void invertir() {

    }

    @Override
    public int contar(Object info) {
        return 0;
    }

    @Override
    public boolean eliminarLista(Object lista2) {
        return false;
    }

    @Override
    public void rellenar(Object info, int cantidad) {

    }

    @Override
    public void rellenar(Object info) {

    }

    @Override
    public Lista clonar() {
        return null;
    }

    @Override
    public Lista subLista(int indiceInicial, int indiceFinal) {
        return null;
    }

    @Override
    public boolean insertar(int indice, Object info) {
        return false;
    }

    @Override
    public boolean copiarLista(Lista lista2) {
        return false;
    }

    @Override
    public Object eliminarInicio() {
        return null;
    }

    @Override
    public Object obtener(int indice) {
        return null;
    }

    @Override
    public int cantidad() {
        return 0;
    }
}
