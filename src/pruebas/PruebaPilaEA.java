package pruebas;

import entradasalida.SalidaPorDefecto;
import utilerias.matematicas.ExpresionesMatematicas;

public class PruebaPilaEA {
    public static void main(String[] args) {
        SalidaPorDefecto.terminal("Ejecutando la operacion:");
        SalidaPorDefecto.terminal("a 8 + 3 x * 4 z ^ / -, donde a=1, x=2, z=2 \n"+
                ExpresionesMatematicas.evaluarPostFija("18+32*42^/-"));
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal("Ejecutando la operacion:");
        SalidaPorDefecto.terminal("a 8 + 3 x * 4 z ^ / -, donde a=1, x=2, z=2 \n"+
                ExpresionesMatematicas.evaluarPreFija("-+18/*32^42"));

    }
}
