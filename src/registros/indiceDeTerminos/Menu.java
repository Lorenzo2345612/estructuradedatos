package registros.indiceDeTerminos;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstaticaOrdenada;

/**
 * Clase que imprime los mensajes de la clase Controlador
 * @author Lorenzo Trujillo Rojas
 * @version 1.0
 */
public class Menu {
    /**
     * Constructor de la clase Menu
     */
    public Menu() {}

    /**
     * Imprime el menu principal.
     */
    public void menu(){
        SalidaPorDefecto.terminal("1.- Agregar Termino\n");
        SalidaPorDefecto.terminal("2.- Consultar Termino\n");
        SalidaPorDefecto.terminal("3.- Consultar Subtermino\n");
        SalidaPorDefecto.terminal("4.- Listar Todos los terminos y subterminos\n");
        SalidaPorDefecto.terminal("5.- Listar Terminos por rango\n");
        SalidaPorDefecto.terminal("0.- Salir\n");
    }

    /**
     * Metodo que imprime el mensaje de imprimir el nombre
     * del termino.
     */
    public void mensajeIngresaNombre(){
        SalidaPorDefecto.terminal("Ingresa el nombre:\n");
    }

    /**
     * Metodo que imprime el mensaje de ingresar la cantidad de subterminos.
     * @param nombre Es el nombre del termino.
     */
    public void ingresaLaCantidadDeSubterminos(String nombre){
        SalidaPorDefecto.terminal("Ingresa la cantidad de subterminos de "+nombre+":\n");
    }

    /**
     * Metodo que imprime el mensaje de ingresar la cantidad de paginas.
     */
    public void ingresaLacantidadDePaginas(){
        SalidaPorDefecto.terminal("Ingresa la cantidad de paginas o rangos que tiene:\n");
    }

    /**
     * Metodo que imprime el mensaje de ingresar las paginas.
     */
    public void ingresaPagina(){
        SalidaPorDefecto.terminal("Ingresa la pagina o rango de paginas\n");
    }

    /**
     * Metodo que imprime el mensaje para saber
     * si se necesitan subterminos.
     * @param nombre Es el nombre del termino.
     */
    public void preguntaTieneSubterminos(String nombre){
        SalidaPorDefecto.terminal("Se necesitan subterminos para "+nombre+"\n");
        SalidaPorDefecto.terminal("1.- Si\n");
        SalidaPorDefecto.terminal("2.- No\n");
    }

    /**
     * Imprime el mensaje de ingresar el numero de terminos y el nombre de cada termino.
     * @param terminos Es la lista de terminos.
     */
    public void imprimirTerminos(ListaEstaticaOrdenada terminos){
        SalidaPorDefecto.terminal("Ingresa el numero del termino:\n");
        for (int indiceTermino = 0; indiceTermino < terminos.cantidad(); indiceTermino++) {
            SalidaPorDefecto.terminal((indiceTermino+1)+".- "+terminos.obtener(indiceTermino).toString()+"\n");
        }
    }

    /**
     * Metodo que imprime el mensaje de ingresar el caracter de limite inferior.
     */
    public void pedirLetraInferior(){
        SalidaPorDefecto.terminal("Ingresa la letra del limite Inferior\n");
    }

    /**
     * Metodo que imprime el mensaje de ingresar el caracter de limite superior.
     */
    public void pedirLetraSuperior(){
        SalidaPorDefecto.terminal("Ingresa la letra del limite Superior\n");
    }

    /**
     * Metodo que imprime el error de no poder agregar.
     */
    public void errorNoSeAgrego(){
        SalidaPorDefecto.terminal("No se pudo agregar el termino.\n");
    }

    /**
     * Metodo que imprime el mensaje de agregar.
     */
    public void seAgrego(){
        SalidaPorDefecto.terminal("Se agrego el termino.\n");
    }

    /**
     * Metodo que imprime el error de no tiene subterminos.
     */
    public void errorNoTieneSub(){
        SalidaPorDefecto.terminal("No tiene subterminos.");
    }
}
