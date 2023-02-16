package controlProduccionCampesinos;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;

/**
 * Clase que almacena los metodos para procesar e imprimir la informacion
 * de la produccion de un campesino.
 * @author Lorenzo Trujillo Rojas
 * @version 1.0
 */
public class Campesino {
    private String nombre;
    private ListaEstatica aniosProduccion;

    /**
     * Constructor de la clase.
     * @param aniosProduccion Representa una lista de los anios trabajados
     *                        por el campesino.
     * @param nombre Representa el nombre del campesino.
     */
    public Campesino(ListaEstatica aniosProduccion, String nombre) {
        this.aniosProduccion = aniosProduccion;
        this.nombre = nombre;
    }

    /**
     * Funcion que imprime el promedio de toneladas producidas por anio.
     */
    public void imprimirPromedioAnualDeToneladas(){
        SalidaPorDefecto.terminal("El promedio anual del campesino "+nombre+" es:\n");
        for (int numAnio = 0; numAnio < aniosProduccion.cantidad(); numAnio++) {
            AnioProduccion anioTemporal = (AnioProduccion) aniosProduccion.obtener(numAnio);
            SalidaPorDefecto.terminal("Año: "+anioTemporal.getNumeroAnio()+" Promedio: "+anioTemporal.obtenerPromedio()+"\n");
        }
    }

    /**
     * Funcion que imprime la cantidad de meses que superaron al promedio anual.
     */
    public void imprimirCantidadMesesMayoresAlPromedio(){
        SalidaPorDefecto.terminal("Cantidad de meses superiores al promedio por anio del campesino:"+ nombre +"\n");
        for (int numAnio = 0; numAnio < aniosProduccion.cantidad(); numAnio++) {
            AnioProduccion anioTemporal = (AnioProduccion) aniosProduccion.obtener(numAnio);
            SalidaPorDefecto.terminal("Año: "+anioTemporal.getNumeroAnio()+" Cantidad de meses superiores al promedio: "+anioTemporal.obtenerCantidadMesesSuperioresAlPromedio()+"\n");
        }
    }

    /**
     * Funcion que imprime la cantidad de toneladas producidas el ultimo mes.
     */
    public void imprimirProduccionDelUltimoMesPorAnio(){
        SalidaPorDefecto.terminal("Produccion del ultimo mes por anio del campesino:"+ nombre +"\n");
        for (int numAnio = 0; numAnio < aniosProduccion.cantidad(); numAnio++) {
            AnioProduccion anioTemporal = (AnioProduccion) aniosProduccion.obtener(numAnio);
            SalidaPorDefecto.terminal("Año: "+anioTemporal.getNumeroAnio()+" Produccion (En toneladas): "+anioTemporal.obtenerToneladasDelUltimoMes()+"\n");
        }
    }

    /**
     * Funcion que imprime la cantidad de toneladas producidas en un trimestre.
     * @param trimestre Indica el trimestre a tratar.
     */
    public void imprimirToneladasPorTrimestre(int trimestre){
        SalidaPorDefecto.terminal("Produccion del trimestre"+trimestre+": \n");
        for (int numAnio = 0; numAnio < aniosProduccion.cantidad(); numAnio++) {
            AnioProduccion anioTemporal = (AnioProduccion) aniosProduccion.obtener(numAnio);
            SalidaPorDefecto.terminal("Año: "+anioTemporal.getNumeroAnio()+" Produccion (En toneladas): "+anioTemporal.obtenerToneladasPorTrimestre(trimestre)+"\n");
        }
    }

    /**
     * Funcion que imprime el mes que tuvo menor produccion al anio.
     */
    public void imprimirMesConMenosProduccionPorAnio(){
        SalidaPorDefecto.terminal("Mes con menos produccion por anio campesino:"+nombre+"\n");
        for (int numAnio = 0; numAnio < aniosProduccion.cantidad(); numAnio++) {
            AnioProduccion anioTemporal = (AnioProduccion) aniosProduccion.obtener(numAnio);
            SalidaPorDefecto.terminal("Año: "+anioTemporal.getNumeroAnio()+" Mes con menor produccion: "+anioTemporal.obtenerMesConMenosProduccion().getNombre()+"\n");
        }
    }

    /**
     * Funcion que obtiene el anio de produccion.
     * @param index Representa el indice del anio a tratar.
     * @return Regresa un objeto AnioProduccion con toda la informacion de la produccion de ese anio.
     */
    public AnioProduccion obtenerAnioProduccion(int index){
        if (index>=aniosProduccion.cantidad() || index<0) return null;

        return (AnioProduccion) aniosProduccion.obtener(index);
    }

    /**
     * Getter del atributo nombre.
     * @return Regresa el nombre del campesino.
     */
    public String getNombre() {
        return nombre;
    }
}
