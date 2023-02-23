package entradasalida;

import java.io.FileWriter;
import java.io.IOException;

public class SalidaPorDefecto {
    public static void terminal(String cadena){
        System.out.print(cadena);
    }

    public static void escrituraArchivo(String ruta,double[] datos){
        try {
            FileWriter writer = new FileWriter(ruta);
            for (int iterador = 0; iterador < datos.length; iterador++) {
                writer.write(datos[iterador]+";");
            }
            writer.close();
            System.out.println("Se escribió en el archivo.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el archivo.");
            e.printStackTrace();
        }
    }
}
