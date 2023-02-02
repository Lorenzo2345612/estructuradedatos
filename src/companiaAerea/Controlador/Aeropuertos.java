package companiaAerea.Controlador;

import companiaAerea.Modelo.Aeropuerto;

import java.util.ArrayList;

public class Aeropuertos {
    private ArrayList<Aeropuerto> aeropuertos = new ArrayList<>();

    public boolean agregarAeropuerto(Aeropuerto aeropuerto){
        return aeropuertos.add(aeropuerto);
    }

    public ArrayList<Aeropuerto> consultarPorCiudad(String ciudad){
        ArrayList<Aeropuerto> resultado = new ArrayList<>();

        aeropuertos.forEach( aeropuerto -> {
            if(ciudad.equals(aeropuerto.getCiudad())){
                resultado.add(aeropuerto);
            }
        });

        return resultado;
    }

    public ArrayList<Aeropuerto> obtenerAeropuertos(){
        return aeropuertos;
    }

    public ArrayList<Aeropuerto> obtenerAeropuertosPorCiudad(String ciudad){
        ArrayList<Aeropuerto> resultado = new ArrayList<>();

        aeropuertos.forEach(aeropuerto -> {
            if(aeropuerto.getCiudad().equals(ciudad)){
                resultado.add(aeropuerto);
            }
        });
        return resultado;
    }

    public ArrayList<String> obtenerCiudadesDeAeropuertos(){
        ArrayList<String> resultado = new ArrayList<>();
        aeropuertos.forEach(aeropuerto -> {
            if (!resultado.contains(aeropuerto.getCiudad())){
                resultado.add(aeropuerto.getCiudad());
            }
        });
        return resultado;

    }
}
