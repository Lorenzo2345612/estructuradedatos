package estructurasLineales;

public class PilaEstatica implements Lote{
    protected ListaEstatica pila;

    public PilaEstatica(int tamanio) {
        this.pila = new ListaEstatica(tamanio);
    }

    @Override
    public boolean lleno() {
        return pila.llena();
    }

    @Override
    public boolean vacio() {
        return pila.vacia();
    }

    @Override
    public boolean poner(Object info) {
        if (pila.agregar(info)==-1)return false;
        return true;
    }

    @Override
    public Object quitar() {
        return pila.eliminar();
    }

    @Override
    public void imprimir() {
        pila.imprimir();
    }

    @Override
    public Object verTope() {
        return pila.verUltimo();
    }
}
