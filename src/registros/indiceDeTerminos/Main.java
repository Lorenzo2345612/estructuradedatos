package registros.indiceDeTerminos;

import entradasalida.EntradaPorDefecto;
import entradasalida.SalidaPorDefecto;

/**
 * Clase main donde se ejecuta el controlador.
 * @author Lorenzo Trujillo Rojas
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        SalidaPorDefecto.terminal("Ingresa la cantidad de terminos que tendra el indice\n");
        int cantidadTerminos= Integer.parseInt(EntradaPorDefecto.consolaCadenas());
        new Controlador(cantidadTerminos);
    }
}
