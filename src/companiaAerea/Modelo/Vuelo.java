package companiaAerea.Modelo;

import companiaAerea.Modelo.Aeropuerto;
import companiaAerea.Modelo.Avion;
import companiaAerea.Modelo.Piloto;

public class Vuelo {
    private Avion avion;
    private Aeropuerto aeropuertoOrigen;
    private Aeropuerto aeropuertoDestino;
    private String fecha;
    private Piloto piloto;

    public Vuelo(Avion avion,
                 Aeropuerto aeropuertoOrigen,
                 Aeropuerto aeropuertoDestino,
                 String fecha,
                 Piloto piloto) {
        this.avion = avion;
        this.aeropuertoOrigen = aeropuertoOrigen;
        this.aeropuertoDestino = aeropuertoDestino;
        this.fecha = fecha;
        this.piloto = piloto;
    }

    public Vuelo(){}

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Aeropuerto getAeropuertoOrigen() {
        return aeropuertoOrigen;
    }

    public void setAeropuertoOrigen(Aeropuerto aeropuertoOrigen) {
        this.aeropuertoOrigen = aeropuertoOrigen;
    }

    public Aeropuerto getAeropuertoDestino() {
        return aeropuertoDestino;
    }

    public void setAeropuertoDestino(Aeropuerto aeropuertoDestino) {
        this.aeropuertoDestino = aeropuertoDestino;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    @Override
    public String toString() {
        return "Vuelo originario de :"+aeropuertoOrigen.getCiudad()+" con destino a "+aeropuertoDestino.getCiudad()+". Tipo de vuelo "+avion.getTipo()+" Fecha de vuelo: "+fecha;
    }
}
