package estructurasLineales;

public class ListaEstatica implements VectorLista{
    protected int tope;
    protected int MAXIMO;
    private final int VACIO=-1;
    protected Object[] informacion;

    public ListaEstatica(int tamanio){
        this.MAXIMO=tamanio;
        this.informacion=new Object[tamanio];
        this.tope=-1;
    }

    @Override
    public boolean vacia() {
        return this.tope == this.VACIO;
    }

    @Override
    public boolean llena() {
        return this.tope == this.MAXIMO-1;
    }

    @Override
    public int agregar(Object info){
        if(llena()) return -1;
        this.tope+=1;
        this.informacion[tope]=info;
        return this.tope;

    }
}
