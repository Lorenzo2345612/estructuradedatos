package estructurasLineales;

/**
 * Estructura que simula el funcionamiento de una pila.
 * @author Lorenzo Trujillo Rojas.
 * @version 1.0
 */
public class PilaDinamica implements Lote{
    protected ListaDinamica informacion;

    public PilaDinamica() {
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
        return informacion.agregar(info)==1 ? true : false;
    }

    @Override
    public Object quitar() {
        return informacion.eliminar();
    }

    @Override
    public void imprimir() {
        PilaEstatica pila = new PilaEstatica(informacion.cantidad());
        informacion.inicializarIterador();
        while(informacion.hayNodo()){
            pila.poner(informacion.obtenerNodo());
        }
        pila.imprimir();
    }

    @Override
    public Object verTope() {
        return informacion.verUltimo();
    }
}
