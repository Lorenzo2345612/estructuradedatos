package estructurasLineales;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.auxiliares.Nodo;

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
        Nodo nodoBuscado = primero;
        while (nodoBuscado!=null && !info.toString().equalsIgnoreCase(nodoBuscado.getInfo().toString())){
            nodoBuscado=nodoBuscado.getLigaDer();
        }
        return nodoBuscado==null ? null : nodoBuscado.getInfo();
    }

    @Override
    public Object eliminar(Object info) {
        /*
        if(vacia())return null;
        Nodo anterior = primero;
        if(anterior.toString().equalsIgnoreCase(info.toString())) return eliminarInicio();
        while(anterior.getLigaDer()!=null && !anterior.getLigaDer().toString().equalsIgnoreCase(info.toString())){
            anterior = anterior.getLigaDer();
        }
        if(anterior.getLigaDer()==null)return null;
        if(anterior.getLigaDer().toString().equalsIgnoreCase(ultimo.toString()))return eliminar();
        Nodo respaldo = anterior.getLigaDer();
        anterior.setLigaDer(anterior.getLigaDer().getLigaDer());
        return respaldo.getInfo();
         */
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
        return nodoActual==null;
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