package companiaAerea.Controlador;

import companiaAerea.Modelo.Avion;

import java.util.ArrayList;

public class Aviones {
    private ArrayList<Avion> aviones= new ArrayList<>();

    public Aviones() {
    }

    public ArrayList<Avion> obtenerAviones(){
        return aviones;
    }

    public boolean agregarAvion(Avion avion){
        return aviones.add(avion);
    }

    public ArrayList<Avion> obtenerAvionesPorTipo(String tipo){
        ArrayList<Avion> result = new ArrayList<>();

        aviones.forEach(avion -> {
            if (tipo.equals(avion.getTipo())){
                result.add(avion);
            }
        });

        return result;
    }
}
