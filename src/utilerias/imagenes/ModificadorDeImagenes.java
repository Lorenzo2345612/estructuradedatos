package utilerias.imagenes;


import estructurasLineales.ListaEstaticaNumerica;
import estructurasnolineales.Matriz2;
import imagen.ManipuladorImagenes;
import utilerias.comunes.TipoGiro;
import utilerias.comunes.TipoModificacionTamanio;

import java.awt.image.BufferedImage;

/**
 * Clase que representa un modificador de imagenes
 * que se apoya de la clase ManipuladorImagenes
 * para realizarle modificaciones en sus colores.
 * @author Lorenzo Trujillo Rojas
 * @version 1.0
 */
public class ModificadorDeImagenes {
    BufferedImage imagenOriginal;

    /**
     * Constructor de la clase.
     * @param ruta Representa la ruta donde esta la imagen.
     */
    public ModificadorDeImagenes(String ruta) {
        this.imagenOriginal = ManipuladorImagenes.abrirImagen(ruta);
    }

    /**
     * Metodo que convierte la imagen a tonos grises.
     * @param rutaSalida Representa la ruta donde se escribira la imagen.
     * @param formato Representa el formato en el que se escribira la imagen.
     * @return Regresa true si se pudo realizar o no.
     */
    public boolean convertirAEscalaDeGrises(String rutaSalida, String formato){
        if(imagenOriginal==null)return false;
        Matriz2 matriz = ManipuladorImagenes.convertirImagenAMatriz2(imagenOriginal);
        for (int renglon = 0; renglon < matriz.obtenerRenglones(); renglon++) {
            for (int columna = 0; columna < matriz.obtenerColumnas(); columna++) {
                ListaEstaticaNumerica listaTemporal =(ListaEstaticaNumerica) matriz.obtener(renglon,columna);
                int promedio = (int) (listaTemporal.suma()/4);
                listaTemporal.rellenar(promedio);
            }
        }
        if (!ManipuladorImagenes.escribirImagen(ManipuladorImagenes.crearBufferedImageConUnaMatriz(matriz),rutaSalida,formato))return false;
        return true;
    }

    /**
     * Metodo que cambia el brillo de la imagen.
     * @param rutaSalida Representa la ruta donde se escribira la imagen.
     * @param formato Representa el formato en el que se escribira la imagen.
     * @param brillo Representa el brillo que se aumentara a la imagen.
     * @return Regresa true si se pudo realizar o no.
     */
    public boolean cambiarBrilloImagen(String rutaSalida, String formato, int brillo){
        if(imagenOriginal==null)return false;
        Matriz2 matriz = ManipuladorImagenes.convertirImagenAMatriz2(imagenOriginal);
        for (int renglon = 0; renglon < matriz.obtenerRenglones(); renglon++) {
            for (int columna = 0; columna < matriz.obtenerColumnas(); columna++) {
                ListaEstaticaNumerica listaTemporal =(ListaEstaticaNumerica) matriz.obtener(renglon,columna);
                listaTemporal.sumarEscalar(brillo);
            }
        }
        if (!ManipuladorImagenes.escribirImagen(ManipuladorImagenes.crearBufferedImageConUnaMatriz(matriz),rutaSalida,formato))return false;
        return true;
    }

    /**
     * Metodo que voltea verticalmente una imagen.
     * @param formato Representa el formato en el que se escribira la imagen.
     * @param rutaSalida Representa la ruta donde se escribira la imagen.
     * @return Regresa true si se pudo realizar o no.
     */
    public boolean voltearVerticalmente(String rutaSalida, String formato){
        if(imagenOriginal==null)return false;
        Matriz2 matriz = ManipuladorImagenes.convertirImagenAMatriz2(imagenOriginal);
        matriz.espejoVertical();
        if (!ManipuladorImagenes.escribirImagen(ManipuladorImagenes.crearBufferedImageConUnaMatriz(matriz),rutaSalida,formato))return false;
        return true;
    }

    /**
     * Metodo que voltea horizontalmente una imagen.
     * @param rutaSalida Representa la ruta donde se escribira la imagen.
     * @param formato Representa el formato en el que se escribira la imagen.
     * @return Regresa true si se pudo realizar o no.
     */
    public boolean voltearHorizontalmente(String rutaSalida, String formato){
        if(imagenOriginal==null)return false;
        Matriz2 matriz = ManipuladorImagenes.convertirImagenAMatriz2(imagenOriginal);
        matriz.espejoHorizontal();
        if (!ManipuladorImagenes.escribirImagen(ManipuladorImagenes.crearBufferedImageConUnaMatriz(matriz),rutaSalida,formato))return false;
        return true;
    }

    /**
     * Metodo que gira la imagen.
     * @param rutaSalida Representa la ruta donde se escribira la imagen.
     * @param formato Representa el formato en el que se escribira la imagen.
     * @param tipoGiro Representa la cantidad de grados que se girara.
     * @return Regresa true si se pudo realizar o no.
     */
    public boolean girarImagen(String rutaSalida, String formato, TipoGiro tipoGiro){
        if(imagenOriginal==null)return false;
        Matriz2 matriz = ManipuladorImagenes.convertirImagenAMatriz2(imagenOriginal);
        switch (tipoGiro){
            case GIRO_270: matriz.girar90gradosHorario();
            case GIRO_180: matriz.girar90gradosHorario();
            case GIRO_90 : matriz.girar90gradosHorario();
            case GIRO_360:break;
        }
        if (!ManipuladorImagenes.escribirImagen(ManipuladorImagenes.crearBufferedImageConUnaMatriz(matriz),rutaSalida,formato))return false;
        return true;
    }

    /**
     * Metodo que usa la transpuesta de una matriz para convertirla.
     * @param rutaSalida Representa la ruta donde se escribira la imagen.
     * @param formato Representa el formato en el que se escribira la imagen.
     * @return Regresa true si se pudo realizar o no.
     */
    public boolean imagenTranspuesta(String rutaSalida, String formato){
        if(imagenOriginal==null)return false;
        Matriz2 matriz = ManipuladorImagenes.convertirImagenAMatriz2(imagenOriginal);
        matriz.transpuesta();
        if (!ManipuladorImagenes.escribirImagen(ManipuladorImagenes.crearBufferedImageConUnaMatriz(matriz),rutaSalida,formato))return false;
        return true;
    }

    /**
     * Metodo que cambia el tamanio de una imagen.
     * @param tipo Representa el tipo de modificacion por default que se utilizara.
     * @param rutaSalida Representa la ruta donde se escribira la imagen.
     * @param formato Representa el formato en el que se escribira la imagen.
     * @return Regresa true si se pudo realizar o no.
     */
    public boolean cambiarTamanio(TipoModificacionTamanio tipo, String rutaSalida, String formato) {
        return switch (tipo){
            case AUMENTO_AL_DOBLE -> cambiarTamanio(imagenOriginal.getHeight()*2,imagenOriginal.getWidth()*2,rutaSalida,formato);
            case AUMENTO_AL_TRIPLE -> cambiarTamanio(imagenOriginal.getHeight()*3,imagenOriginal.getWidth()*3,rutaSalida,formato);
            case AUMENTO_AL_CUADRUPLE -> cambiarTamanio(imagenOriginal.getHeight()*4,imagenOriginal.getWidth()*4,rutaSalida,formato);
            case DISMINUIR_A_LA_MITAD -> cambiarTamanio(imagenOriginal.getHeight()/2,imagenOriginal.getWidth()/2,rutaSalida,formato);
            case DISMINUIR_A_LA_TERCERA_PARTE -> cambiarTamanio(imagenOriginal.getHeight()/3,imagenOriginal.getWidth()/3,rutaSalida,formato);
            case DISMINUIR_A_LA_CUARTA_PARTE -> cambiarTamanio(imagenOriginal.getHeight()/4,imagenOriginal.getWidth()/4,rutaSalida,formato);
        };
    }

    /**
     * Metodo que cambia el tamanio de una imagen.
     * @param height Representa el nuevo alto de la imagen.
     * @param width Representa el nuevo ancho de la imagen.
     * @param rutaSalida Representa la ruta donde se escribira la imagen.
     * @param formato Representa el formato en el que se escribira la imagen.
     * @return Regresa true si se pudo realizar o no.
     */
    public boolean cambiarTamanio(int height, int width, String rutaSalida, String formato) {
        if (imagenOriginal == null) return false;

        Matriz2 matriz = ManipuladorImagenes.convertirImagenAMatriz2(imagenOriginal);
        Matriz2 matriz2;
        double factorX = (double) width / matriz.obtenerColumnas();
        double factorY = (double) height / matriz.obtenerRenglones();

        if (factorX >= 1 && factorY >= 1) {
            matriz2 = ampliarTamanioImagen(factorX, factorY, matriz);
        } else if(factorX <= 1 && factorY <= 1){
            matriz2 = reducirTamanioImagen(matriz.obtenerColumnas() / width, matriz.obtenerRenglones() / height, matriz);
        }else {
            return false;
        }

        if (!ManipuladorImagenes.escribirImagen(ManipuladorImagenes.crearBufferedImageConUnaMatriz(matriz2), rutaSalida, formato)) {
            return false;
        }

        return true;
    }

    /**
     * Metodo auxiliar para reducir el tamanio de una imagen.
     * @param factorX Representa la relacion del ancho actual con el anterior
     * @param factorY Representa la relacion del alto actual con el anterior
     * @param matriz Representa la matriz a escalar.
     * @return Regresa la matriz escalada.
     */
    private Matriz2 reducirTamanioImagen(int factorX, int factorY, Matriz2 matriz){
        Matriz2 matrizTemporal = new Matriz2(matriz.obtenerRenglones()/factorY, matriz.obtenerColumnas()/factorX);
        for (int renglon = 0; renglon < matriz.obtenerRenglones(); renglon++) {
            for (int columna = 0; columna < matriz.obtenerColumnas(); columna++) {
                if(renglon%factorY==0 && columna%factorX==0){
                    matrizTemporal.cambiar(renglon/factorY,columna/factorX,matriz.obtener(renglon,columna));
                }
            }
        }
        return matrizTemporal;
    }

    /**
     * Metodo auxiliar para aumentar el tamanio de una imagen.
     * @param factorX Representa la relacion del ancho actual con el anterior
     * @param factorY Representa la relacion del alto actual con el anterior
     * @param matriz Representa la matriz a escalar.
     * @return Regresa la matriz escalada.
     */
    private Matriz2 ampliarTamanioImagen(double factorX, double factorY, Matriz2 matriz) {
        Matriz2 matrizTemporal = new Matriz2((int) (matriz.obtenerRenglones() * factorY), (int) (matriz.obtenerColumnas() * factorX));
        int renglonActual = 0;
        int columnaActual = 0;
        for (int renglon = 0; renglon < matriz.obtenerRenglones(); renglon++) {
            for (int columna = 0; columna < matriz.obtenerColumnas(); columna++) {
                ListaEstaticaNumerica pixel =(ListaEstaticaNumerica) matriz.obtener(renglon, columna);
                for (int iteradorRenMT = 0; iteradorRenMT < factorY; iteradorRenMT++) {
                    for (int iteradorColMT = 0; iteradorColMT < factorX; iteradorColMT++) {
                        matrizTemporal.cambiar(renglonActual + iteradorRenMT, columnaActual + iteradorColMT, pixel);
                    }
                }
                columnaActual += (int) Math.ceil(factorX);
            }
            columnaActual = 0;
            renglonActual += (int) Math.ceil(factorY);
        }
        return matrizTemporal;
    }

    /**
     * Metodo que invierte los colores de una imagen
     * @param rutaSalida Representa la ruta donde se escribira la imagen.
     * @param formato Representa el formato en el que se escribira la imagen.
     * @return Regresa true si se pudo realizar o no.
     */
    public boolean invertirColores(String rutaSalida, String formato){
        if (imagenOriginal == null) return false;

        Matriz2 matriz = ManipuladorImagenes.convertirImagenAMatriz2(imagenOriginal);
        for (int renglon = 0; renglon < matriz.obtenerRenglones(); renglon++) {
            for (int columna = 0; columna < matriz.obtenerColumnas(); columna++) {
                ListaEstaticaNumerica pixel =(ListaEstaticaNumerica) matriz.obtener(renglon, columna);
                for (int iteradorLista = 0; iteradorLista < 3; iteradorLista++) {
                    pixel.cambiar(iteradorLista,255-(int)pixel.obtener(iteradorLista)+1);
                }
            }
        }
        if (!ManipuladorImagenes.escribirImagen(ManipuladorImagenes.crearBufferedImageConUnaMatriz(matriz),rutaSalida,formato))return false;
        return true;
    }

    /**
     * Metodo que agrega un marco de color a la imagen.
     * @param rojo Representa el red en el RGBA.
     * @param verde Representa el verde en el RGBA.
     * @param azul Representa el azul en el RGBA.
     * @param alpha Representa el alpha en el RGBA.
     * @param tamanio Representa el tamanio que tendra el marco.
     * @param rutaSalida Representa la ruta donde se escribira la imagen.
     * @param formato Representa el formato en el que se escribira la imagen.
     * @return Regresa true si se pudo realizar o no.
     */
    public boolean agregarMarco(int rojo, int verde, int azul, int alpha, int tamanio, String rutaSalida, String formato){
        if (imagenOriginal == null) return false;

        Matriz2 matriz = ManipuladorImagenes.convertirImagenAMatriz2(imagenOriginal);
        ListaEstaticaNumerica marco = new ListaEstaticaNumerica(4);
        marco.agregar(azul);
        marco.agregar(verde);
        marco.agregar(rojo);
        marco.agregar(alpha);
        Matriz2 matriz2 = new Matriz2(matriz.obtenerRenglones()+(tamanio*2),matriz.obtenerColumnas()+(tamanio*2),marco);
        for (int renglon = tamanio; renglon < matriz.obtenerRenglones()+tamanio; renglon++) {
            for (int columna = tamanio; columna < matriz.obtenerColumnas()+tamanio; columna++) {
                matriz2.cambiar(renglon,columna,matriz.obtener(renglon-tamanio, columna-tamanio));
            }
        }

        if (!ManipuladorImagenes.escribirImagen(ManipuladorImagenes.crearBufferedImageConUnaMatriz(matriz2),rutaSalida,formato))return false;
        return true;
    }

    /**
     * Metodo que verifica si la imagen es nula.
     * @return Regresa true si es nula o false si no.
     */
    public boolean laImagenEsNula(){
        return imagenOriginal==null;
    }

}
