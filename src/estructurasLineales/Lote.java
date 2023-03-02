package estructurasLineales;

public interface Lote {

    /**
     * Metodo que nos indica si esta lleno.
     * @return Regresa true si esta llena o false si no.
     */
    public boolean lleno();

    public boolean vacio();

    public boolean poner(Object info);

    public Object quitar();

    public void imprimir();

    public Object verTope();

}
