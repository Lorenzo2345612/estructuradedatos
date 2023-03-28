package estructurasLineales;

import entradasalida.SalidaPorDefecto;

/**
 * Clase que simula el funcionamiento de una cola.
 * @author Lorenzo Trujillo Rojas.
 * @version 1.0
 */
public class ColaDinamica implements Lote{
    private ListaDinamica informacion;
    public ColaDinamica() {
        informacion = new ListaDinamica();
    }

    @Override
    public boolean lleno() {
        return informacion.llena();
    }

    @Override
    public boolean vacio() {
        return informacion.vacia();
    }

    @Override
    public boolean poner(Object info) {
        return informacion.agregar(info)==1? true : false;
    }

    @Override
    public Object quitar() {
        return informacion.eliminarInicio();
    }

    @Override
    public void imprimir() {
        informacion.inicializarIterador();
        while (informacion.hayNodo()){
            SalidaPorDefecto.terminal(""+informacion.obtenerNodo()+"\n");
        }
    }

    @Override
    public Object verTope() {
        return informacion.verUltimo();
    }

    public Object verInicio(){
        return informacion.primero==null? null : informacion.primero.getInfo();
    }
}
