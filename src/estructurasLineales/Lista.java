package estructurasLineales;


/**
 * Esta clase contiene los metodos de un TDA Lista.
 * @version 1.0
 * @author Clase ED
 */
public interface Lista {
    /**
     * Este metodo regresa un indicador de si la lista esta vacia.
     * @return Regresa <b>true</b> si esta vacia o <b>false</b> si
     * tiene elementos.
     */
    public boolean vacia();

    /**
     * Este metodo añade un elemento a la lista.
     * @param info Es el nuevo valor a añadir.
     * @return Regresa la posicion donde fue agregado o -1 en caso contrario.
     */
    public int agregar(Object info);
    public void imprimir();
    public void imprimirOI();
    public Object buscar(Object info);
    public Object eliminar(Object info);
    public Object verUltimo();


    /**
     * Indica si la lista actual es igual a la lista pasada por paramentro.
     * @param lista Es la lista que compararemos con la actual.
     * @return Regresa true si es igual o false si es diferente.
     */

    public boolean esIgual(Object lista);

    /**
     * Modifica un cambia un elemento por otro un determinado numero de veces.
     * @param infoViejo Es el elemento que queremos remplazar.
     * @param infoNuevo Es el elemnto que queremos usar.
     * @param numVeces Es la cantidad de veces que queremos repetir la operacion.
     * @return Retorna true si fue posible y false en caso contrario.
     */
    public boolean cambiar(Object infoViejo, Object infoNuevo, int numVeces);

    /**
     * Busca todas las coincidencias de un objeto y devuelve las posiciones
     * de los mismos
     * @param info Es el objeto que buscaremos en la lista
     * @return Retorna una ListaEstatica con todos los indices donde se encuentra
     * el elemento.
     */
    public ListaEstatica buscarValores(Object info);

    /**
     * Elimina el ultimo valor de la lista.
     * @return Retorna el elemento eliminado.
     */
    public Object eliminar();

    /**
     * Vacia la lista.
     */
    public void vaciar();

    /**
     * Agrega los elementos de una lista a otra.
     * @param lista2 Es la lista que debemos agregar.
     * @return Retorna true si se pudo agregar o false si no.
     */
    public boolean agregarLista(Object lista2);

    /**
     * Invierte el orden de los elementos de la lista.
     */
    public void invertir();

    /**
     * Cuenta las ocurrencias de un objeto en una lista.
     * @param info Es el objeto que queremos comparar.
     * @return Regresa un entero con la cantidad de veces
     * que se repite el elemento.
     */
    public int contar(Object info);

    /**
     * Elimina cada elemento de la lista2 en la lista actual.
     * @param lista2 Es la lista que nos dara la informacion que eliminaremos.
     * @return Regresa true si se pudo realizar o false si no.
     */
    public boolean eliminarLista(Object lista2);

    /**
     * Rellena la cantidad de espacios indicados con un objeto especifico.
     * @param info Es el objeto que se usara para rrellenar la lista.
     * @param cantidad Es la cantidad de veces que se realizara el proceso,
     *                 en caso de ser mayor que el tamaño de la lista solo
     *                 se hace la cantidad maxima posible de veces.
     */
    public void rellenar(Object info, int cantidad);

    /**

     */
    public void rellenar(Object info);
    /**
     * Crea una copia de la lista actual.
     * @return Regresa una copia de la lista.
     */
    public Lista clonar();

    /**
     * Regresa una sublista con los elementos entre los indices.
     * @param indiceInicial Es donde iniciara la sublista.
     * @param indiceFinal Es donde terminara la sublista.
     * @return Regresa una sublista con los elementos indicados.
     */
    public Lista subLista(int indiceInicial, int indiceFinal);

    /**
     * Metodo que ingresa un elemento en el indice indicado.
     * @param indice Indica el indice en el que se ingresara.
     * @param info Indica el objeto a ingresar.
     * @return Regresa true si fue posible o false si no.
     */
    public boolean insertar(int indice, Object info);

    /**
     *Metodo que copia el contenido de una lista en la original.
     * @param lista2 Lista de la que se tomaran los valores.
     * @return Regresa true si fue posible copiarla o false si no.
     */
    public boolean copiarLista(Lista lista2);

    /**
     * Metodo que elimina el primer elemento de la lista.
     * @return Regresa el elemento eliminado.
     */
    public Object eliminarInicio();
}
