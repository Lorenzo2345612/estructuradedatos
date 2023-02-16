package companiaAerea.Controlador;

import companiaAerea.Modelo.Aeropuerto;
import companiaAerea.Modelo.Avion;
import companiaAerea.Modelo.Vuelo;

import java.util.ArrayList;

public class Vuelos {
    private ArrayList<Vuelo> vuelos=new ArrayList<>();

    public boolean registrarVuelo(Vuelo vuelo){
        return vuelos.add(vuelo);
    }

    public ArrayList<Vuelo> consultarVuelosOrigen(Aeropuerto aeropuertoOrigen){
        ArrayList<Vuelo> resultado = new ArrayList<>();
        vuelos.forEach(vuelo -> {
            if (aeropuertoOrigen.equals(vuelo.getAeropuertoOrigen())){
                resultado.add(vuelo);
            }
        });
        return resultado;
    }

    public ArrayList<Vuelo> consultarVuelosDestino(Aeropuerto aeropuertoDestino){
        ArrayList<Vuelo> resultado = new ArrayList<>();
        vuelos.forEach(vuelo -> {
            if (aeropuertoDestino.equals(vuelo.getAeropuertoDestino())){
                resultado.add(vuelo);
            }
        });
        return resultado;
    }

    public ArrayList<Vuelo> obtenerVuelosPorAvion(Avion avion){
        ArrayList<Vuelo> resultado = new ArrayList<>();

        vuelos.forEach(vuelo -> {
            if (vuelo.getAvion().equals(avion)){
                resultado.add(vuelo);
            }
        });

        return resultado;
    }
}
