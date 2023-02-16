package utilerias.comunes;

import java.util.Random;

public class SeleccionRandom {

    public static int enteroRandom(int maximo, int minimo){
        Random rn = new Random();
        return rn.nextInt(maximo - minimo + 1) + minimo;
    }
}
