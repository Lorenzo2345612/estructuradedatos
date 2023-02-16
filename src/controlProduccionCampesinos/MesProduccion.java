package controlProduccionCampesinos;

/**
 * Clase que representa un mes en un AnioProduccion.
 * @author Lorenzo Trujillo Rojas.
 * @version 1.0
 */
public class MesProduccion {
    private String nombre;
    private double toneladasProducidas;
    private String estacionAnio;

    /**
     * Constructor de la clase.
     * @param nombre Indica el nombre del mes.
     * @param toneladasProducidas Indica las toneladas que se produjeron ese mes.
     * @param estacionAnio Indica la estacion del anio a la que pertenece el mes.
     */
    public MesProduccion(String nombre, double toneladasProducidas, String estacionAnio) {
        this.nombre = nombre;
        this.toneladasProducidas = toneladasProducidas;
        this.estacionAnio = estacionAnio;
    }

    /**
     * Getter del atributo nombre.
     * @return Regresa el nombre del mes.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter del atributo nombre.
     * @param nombre Nuevo nombre a aplicar.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter del atributo toneladasProducidas.
     * @return Regresa la cantidad de toneladas producidas.
     */
    public double getToneladasProducidas() {
        return toneladasProducidas;
    }

    /**
     * Getter del atributo estacionAnio.
     * @return Regresa la estacion del mes.
     */
    public String getEstacionAnio() {
        return estacionAnio;
    }
}
