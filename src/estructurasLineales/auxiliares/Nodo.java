package estructurasLineales.auxiliares;

public class Nodo {
    protected Object info;
    protected Nodo ligaDer;

    public Nodo(Object info){
        this.info=info;
        this.ligaDer=null;
    }

    public Nodo(){
        this.info=null;
        this.ligaDer=null;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public Nodo getLigaDer() {
        return ligaDer;
    }

    public void setLigaDer(Nodo ligaDer) {
        this.ligaDer = ligaDer;
    }

    @Override
    public String toString() {
        return info.toString();
    }
}