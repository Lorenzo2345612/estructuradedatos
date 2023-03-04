package imagen;
import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import estructurasLineales.ListaEstaticaNumerica;
import estructurasnolineales.Matriz2;
import utilerias.comunes.ConversorDeDatos;
import static utilerias.comunes.ConversorDeDatos.objectToInteger;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Clase que maneja una imagen sin modificarla.
 * @author Lorenzo Trujillo Rojas
 * @version 1.0
 */
public class ManipuladorImagenes {
    /**
     * Metodo que abre una imagen.
     * @param ruta Representa la ruta de la imagen a abrir.
     * @return Regresa un BufferedImage con la imagen abierta.
     */
    public static BufferedImage abrirImagen(String ruta){
        try {
            BufferedImage imagen = ImageIO.read(new File(ruta));
            return imagen;
        }catch (IOException e){
            return null;
        }
    }

    /**
     * Metodo que crea una imagen vacia.
     * @param ancho Representa el ancho que tendra una imagen.
     * @param alto Representa el alto que tendra una imagen.
     * @return Regresa un BufferedImage con la imagen vacia.
     */
    public static BufferedImage crearImagenVacia(int ancho, int alto){
        BufferedImage imagen = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
        return imagen;

    }

    /**
     * Metodo que convierte una imagen a matriz2.
     * @param imagen Representa el bufferImage a convertir en matriz.
     * @return Regresa la matriz que contien la informacion de la imagen.
     */
    public static Matriz2 convertirImagenAMatriz2(BufferedImage imagen){
        Matriz2 matriz = new Matriz2(imagen.getHeight(),imagen.getWidth());
        for (int renglon = 0; renglon < imagen.getHeight(); renglon++) {
            for (int columna = 0; columna < imagen.getWidth(); columna++) {
                int pixelEntero = imagen.getRGB(columna, renglon);
                ListaEstaticaNumerica listaTemporal = new ListaEstaticaNumerica(4);
                for (int i = 0; i < 4; i++) {
                    int byteTemporal = (pixelEntero >> (i * 8)) & 0xFF;
                    listaTemporal.agregar(byteTemporal);
                }
                matriz.cambiar(renglon, columna, listaTemporal.clonar());
            }
        }
        return matriz;
    }

    /**
     * Metodo que crea un BufferedImage a partir de la matriz.
     * @param matriz Representa la matriz a escribir en la nueva imagen.
     * @return Regresa el BufferedImage con la informacion de la matriz.
     */
    public static BufferedImage crearBufferedImageConUnaMatriz(Matriz2 matriz){
        BufferedImage imagen = crearImagenVacia(matriz.obtenerColumnas(),matriz.obtenerRenglones());
        Color colorTemporal;
        for (int renglon = 0; renglon < imagen.getHeight(); renglon++) {
            for (int columna = 0; columna < imagen.getWidth(); columna++) {
                ListaEstatica listaTemporal =(ListaEstatica) matriz.obtener(renglon,columna);
                int red = ((Number)listaTemporal.obtener(2)).intValue();
                int green = ((Number)listaTemporal.obtener(1)).intValue();
                int blue = ((Number)listaTemporal.obtener(0)).intValue();
                int alpha = ((Number)listaTemporal.obtener(3)).intValue();
                red = validarRango(red);
                green =validarRango(green);
                blue = validarRango(blue);
                alpha = validarRango(alpha);
                colorTemporal=new Color(red,green,blue,alpha);
                imagen.setRGB(columna,renglon,colorTemporal.getRGB());
            }
        }

        return imagen;
    }

    /**
     * Metodo que valida el rango en el color.
     * @param color Representa el entero a validar
     * @return Regresa el valor validado.
     */
    private static int validarRango(int color) {
        if(color>255)return 255;
        if(color<0)return 0;
        return color;
    }


    /**
     * Metodo que escribe una imagen en una ruta.
     * @param imagen Representa la imagen a escribir.
     * @param ruta Representa la ruta en la que se escribira la imagen.
     * @param format Representa el formato en el que se escribira la imagen.
     * @return Regresa true si se pudo escribir y false si no.
     */
    public static boolean escribirImagen(BufferedImage imagen, String ruta, String format) {
        try{
            File output =new File(ruta);
            ImageIO.write(imagen, format, output);
            return true;
        }catch (IOException e){
            return false;
        }
    }


}