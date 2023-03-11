package estructurasLineales.auxiliares;

public class NodoDoble {
    protected NodoDoble ligaIzquierda;
    protected NodoDoble ligaDerecha;
    protected Object info;

    public NodoDoble(Object info) {
        this.info = info;
        this.ligaDerecha=null;
        this.ligaIzquierda=null;
    }

    public NodoDoble getLigaIzquierda() {
        return ligaIzquierda;
    }

    public void setLigaIzquierda(NodoDoble ligaIzquierda) {
        this.ligaIzquierda = ligaIzquierda;
    }

    public NodoDoble getLigaDerecha() {
        return ligaDerecha;
    }

    public void setLigaDerecha(NodoDoble ligaDerecha) {
        this.ligaDerecha = ligaDerecha;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return info.toString();
    }
}
