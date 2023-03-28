package estructurasLineales;

/**
 * Esta clase contiene los metodos de un TDA VectorLista.
 * @version 1.0
 * @author Clase ED
 */
public interface VectorLista extends Lista{
    public boolean llena();

    /**
     * Cambia un objeto por otro en un indice especificado.
     * @param indice Es el indice del elemento que debemos cambiar.
     * @param info Es el elemento nuevo que queremos ingresar.
     * @return Regresa true si se pudo cambiuar o false en caso contrario.
     */
    public boolean cambiar(int indice, Object info);

    /**
     * Cambia los elementos indicados en la listaEstatica por los elementos de infoNuevos
     * @param indicesBusqueda
     * @param infosNuevos
     * @return
     */
    public boolean cambiarListaEstatica(ListaEstatica indicesBusqueda, ListaEstatica infosNuevos);

    /**
     * Elimina un numero del arreglo en una posicion especifica.
     * @param indice Es el indice donde se encuentra el objeto a eliminar.
     * @return Regresa el objeto que se elimina.
     */
    public Object eliminar(int indice);

    /**
     * Redimensiona el tamaño del arreglo al nuevo tamaño indicado.
     * @param maximo Es el nuevo tamaño de la lista.
     * @return Regresa true si se logro hacer la redimension o falso en caso contrario.
     */
    public boolean redimensionar(int maximo);

    /**
     * Metodo para obtener el tamaño maximo de la lista.
     * @return Regresa el tamaño maximo de la lista.
     */
    public int maximo();
}
