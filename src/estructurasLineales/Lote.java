package estructurasLineales;

/**
 * Interfaz que indica los metodos para crear un lote de objetos.
 * @author Clase 4°B
 * @version 1.0
 */
public interface Lote {

    /**
     * Metodo que nos indica si esta lleno.
     * @return Regresa true si esta llena o false si no.
     */
    public boolean lleno();

    /**
     * Metodo que verifica si el lote esta vacio.
     * @return Regresa true si esta vacio o false si no.
     */
    public boolean vacio();

    /**
     * Metodo que pone un nuevo elemento.
     * @param info Representa el objeto a poner.
     * @return Regresa true si fue posible ponerlo o false si no.
     */
    public boolean poner(Object info);

    /**
     * Metodo que quita un elemento.
     * @return Regresa el elemento quitado o null si estaba vacio.
     */
    public Object quitar();

    /**
     * Metodo que imprime los elementos guardados.
     */
    public void imprimir();

    /**
     * Metodo que muestra el ultimo elemento que saldra.
     * @return Regresa el objeto que saldra al final.
     */
    public Object verTope();

}
