package registros.indiceDeTerminos;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstaticaOrdenada;
import utilerias.comunes.TipoOrden;

/**
 * Clase que almacena un termino con sus subterminos.
 * @author Lorenzo Trujillo Rojas.
 * @version 1.0
 */
public class Termino {
    private String nombre;
    private ListaEstaticaOrdenada listaSubterminos;
    private ListaEstaticaOrdenada paginas;

    /**
     * Constructor de la clase Termino.
     * @param nombre Es el nombre del termino.
     * @param listaSubterminos Es la lista de subterminos.
     * @param paginas Es la lista de paginas que abarca.
     */
    public Termino(String nombre, ListaEstaticaOrdenada listaSubterminos, ListaEstaticaOrdenada paginas) {
        this.nombre = nombre;
        this.listaSubterminos = listaSubterminos;
        this.paginas = paginas;
    }

    /**
     * Constructor de la clase Termino.
     * @param nombre Es el nombre del termino.
     * @param paginas Es la lista de paginas que abarca.
     * @param tamanio Es la cantidad de subterminos que puede tener.
     */
    public Termino(String nombre, ListaEstaticaOrdenada paginas, int tamanio) {
        this.nombre = nombre;
        this.paginas = paginas;
        this.listaSubterminos=new ListaEstaticaOrdenada(tamanio, TipoOrden.INC);
    }

    /**
     * Metodo para agregar un subtermino.
     * @param subtermino Subtermino a agregar.
     * @return regresa true si se pudo agregar y false si no.
     */
    public boolean agregarSubTermino(Termino subtermino){
        if (listaSubterminos.agregar(subtermino)==-1)return false;
        return true;
    }

    /**
     * Imprime el termino con sus subterminos recursivamente.
     */
    public void imprimirTermino(){
        SalidaPorDefecto.terminal(nombre);
        for (int numeroPagina = 0; numeroPagina < paginas.cantidad(); numeroPagina++) {
            SalidaPorDefecto.terminal(", "+paginas.obtener(numeroPagina));
        }
        SalidaPorDefecto.terminal("\n");
        if(listaSubterminos.vacia())return;
        for (int indiceSubtermino = 0; indiceSubtermino < listaSubterminos.cantidad(); indiceSubtermino++) {
            SalidaPorDefecto.terminal("     ");
            ((Termino) listaSubterminos.obtener(indiceSubtermino)).imprimirTermino();
            SalidaPorDefecto.terminal("\n");
        }

    }

    /**
     * Obtiene la lista de subterminos.
     * @return Regresa la lista de subterminos.
     */
    public ListaEstaticaOrdenada getListaSubterminos() {
        return listaSubterminos;
    }

    /**
     * Obtiene un subtermino por indice.
     * @param indice Es el indice del subtermino.
     * @return Regresa el subtermino.
     */
    public Termino obtenerSubterminoPorIndice(int indice){
        return (Termino) listaSubterminos.obtener(indice);
    }

    /**
     * Obtiene el nombre del termino.
     * @return Regresa el nombre del termino.
     */
    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString(){
        return nombre;
    }
}
