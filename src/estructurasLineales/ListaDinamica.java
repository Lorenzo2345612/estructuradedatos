package estructurasLineales;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.auxiliares.Nodo;

public class ListaDinamica implements Lista{
    protected Nodo primero;
    protected Nodo ultimo;

    public ListaDinamica() {
        primero=null;
        ultimo=null;
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
        return null;
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
        return null;
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
}