package companiaAerea.Controlador;

import companiaAerea.Modelo.Piloto;

import java.util.ArrayList;

public class Pilotos {

    private ArrayList<Piloto> pilotos = new ArrayList<>();

    public boolean agregarPiloto(Piloto piloto){
        return pilotos.add(piloto);
    }
    public ArrayList<Piloto> obtenerPilotosPorTipo(String tipo){
        ArrayList<Piloto> resultado = new ArrayList<>();
        pilotos.forEach(piloto -> {
            if(piloto.getTipoLicencia().equals(tipo)){
                resultado.add(piloto);
            }
        });

        return resultado;
    }
}
