package registros.cambiosEnImagen;

import entradasalida.SalidaPorDefecto;

public class VistaCambioImagen {
    /**
     * Metodo que imprime el menu principal.
     */
    public static void imprimirMenuPrincipal(){
        SalidaPorDefecto.terminal("Ingresa la accion a realizar con la imagen\n");
        SalidaPorDefecto.terminal("1.-  Pasar a escala de grises\n");
        SalidaPorDefecto.terminal("2.-  Modificar brillo\n");
        SalidaPorDefecto.terminal("3.-  Invertir imagen verticalmente\n");
        SalidaPorDefecto.terminal("4.-  Invertir imagen horizontalmente\n");
        SalidaPorDefecto.terminal("5.-  Girar la imagen\n");
        SalidaPorDefecto.terminal("6.-  Imagen transpuesta\n");
        SalidaPorDefecto.terminal("7.-  Redimensionar Imagen\n");
        SalidaPorDefecto.terminal("8.-  Agregar marco\n");
        SalidaPorDefecto.terminal("9.-  Invertir colores\n");
        SalidaPorDefecto.terminal("0.-  Salir\n");
    }

    public static void imprimirMensajeIngresaRutaImagen(){
        SalidaPorDefecto.terminal("Ingresa la ruta de la imagen a usar\n");
    }

    public static void imprimirMensajeIngresarRutaSalida(){
        SalidaPorDefecto.terminal("Ingresa la ruta de salida de la imagen: \n");
    }

    public static void imprimirMensajeIngresaFormatoImagen(){
        SalidaPorDefecto.terminal("Ingresa el formato de la imagen: \n");
    }

    public static void imprimirMensajeEligeGiroImagen(){
        SalidaPorDefecto.terminal("Ingresa la opcion del giro: \n");
        SalidaPorDefecto.terminal("1.- 90°\n");
        SalidaPorDefecto.terminal("2.- 180°\n");
        SalidaPorDefecto.terminal("3.- 270°\n");
    }

    public static void imprimirOpcionesRedimensionarImagen(){
        SalidaPorDefecto.terminal("Ingresar opcion de redimension\n");
        SalidaPorDefecto.terminal("1.- Opciones por defecto\n");
        SalidaPorDefecto.terminal("2.- Opciones Avanzadas\n");
    }

    public static void imprimirOpcionesPorDefecto(){
        SalidaPorDefecto.terminal("Ingresa la opcion para la redimension\n");
        SalidaPorDefecto.terminal("1.- Aumentar 2 veces\n");
        SalidaPorDefecto.terminal("2.- Aumentar 3 veces\n");
        SalidaPorDefecto.terminal("3.- Aumentar 4 veces\n");
        SalidaPorDefecto.terminal("4.- Disminuir 2 veces\n");
        SalidaPorDefecto.terminal("5.- Disminuir 3 veces\n");
        SalidaPorDefecto.terminal("6.- Disminuir 4 veces\n");
    }

    public static void imprimirMensajeDimensionesActuales(int ancho, int alto){
        SalidaPorDefecto.terminal("Medidas actuales\n");
        SalidaPorDefecto.terminal(ancho+" pixeles de ancho\n");
        SalidaPorDefecto.terminal(alto+" pixeles de alto\n");
    }

    public static void imprimirMensajeAncho(){
        SalidaPorDefecto.terminal("Ingresa la nueva medida de ancho\n");
    }

    public static void imprimirMensajeAlto(){
        SalidaPorDefecto.terminal("Ingresa la nueva medida de alto\n");
    }

    public static void imprimirMensajeRojo(){
        SalidaPorDefecto.terminal("Ingresa el numero para el color rojo (0 a 255)\n");
    }

    public static void imprimirMensajeAzul(){
        SalidaPorDefecto.terminal("Ingresa el numero para el color azul (0 a 255)\n");
    }

    public static void imprimirMensajeVerde(){
        SalidaPorDefecto.terminal("Ingresa el numero para el color verde (0 a 255)\n");
    }

    public static void imprimirMensajeAlpha(){
        SalidaPorDefecto.terminal("Ingresa el numero para la opacidad (0 a 255)\n");
    }

    public static void imprimirMensajeTamanio(){
        SalidaPorDefecto.terminal("Ingresa el tamanio del margen\n");
    }

    public static void imprimirMensajeBrillo(){
        SalidaPorDefecto.terminal("Imgresa la cantidad de brillo a aumentar (si es positivo) o a disminuir (si es negativo)\n");
    }

    public static void imprimirMensajeRutaInvalida(){
        SalidaPorDefecto.terminal("Ruta de imagen invalida\n");
    }

    public static void imprimirMensajeRutaNoSeRealizoLaAccion(){
        SalidaPorDefecto.terminal("No se pudo realizar la accion\n");
    }

    public static void imprimirMensajeOpcionInvalida(){
        SalidaPorDefecto.terminal("Opcion invalida\n");
    }

    public static void imprimirImagenCreada(String ruta){
        SalidaPorDefecto.terminal("Imagen creada en "+ruta+"\n");
    }

}
