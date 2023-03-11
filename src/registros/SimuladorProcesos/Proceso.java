package registros.SimuladorProcesos;

/**
 * Clase que simula un proceso, con su tiempo de descarga,
 * ejecucion e impresion.
 * @author Lorenzo Trujillo Rojas.
 * @version 1.0
 */
public class Proceso {
    private String nombreProceso;
    private int idProceso;
    private int prioridad;
    private int tiempoDescarga;
    private int tiempoEjecucion;
    private int tiempoImpresion;
    private String estado;

    public Proceso(String nombreProceso,
                   int idProceso,
                   int tiempoDescarga,
                   int tiempoEjecucion,
                   int tiempoImpresion,
                   String estado,
                   int prioridad) {
        this.nombreProceso = nombreProceso;
        this.idProceso = idProceso;
        this.tiempoDescarga = tiempoDescarga;
        this.tiempoEjecucion = tiempoEjecucion;
        this.tiempoImpresion = tiempoImpresion;
        this.estado = estado;
        this.prioridad = prioridad;
    }

    public String getNombreProceso() {
        return nombreProceso;
    }

    public int getIdProceso() {
        return idProceso;
    }

    public int getTiempoDescarga() {
        return tiempoDescarga;
    }

    public int getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    public int getTiempoImpresion() {
        return tiempoImpresion;
    }

    public int getPrioridad() {
        return prioridad;
    }

    /**
     * Metodo que decrementa el tiempo de descarga uno por uno.
     */
    public void decrementarTiempoDescarga(){
        if (tiempoDescarga>0){
            tiempoDescarga--;
        }
    }

    /**
     * Metodo que decrementa el tiempo de ejecucion uno por uno.
     */
    public void decrementarTiempoEjecucion(){
        if (tiempoEjecucion>0){
            tiempoEjecucion--;
        }
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Metodo que decrementa el tiempo de impresion uno por uno.
     */
    public void decrementarTiempoImpresion(){
        if (tiempoImpresion>0){
            tiempoImpresion--;
        }
    }

    @Override
    public String toString() {
        return "Proceso{" +
                "nombreProceso='" + nombreProceso + '\'' +
                ", idProceso=" + idProceso +
                ", estado='" + estado + '\'' +
                '}';
    }
}
