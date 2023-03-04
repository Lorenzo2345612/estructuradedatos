package registros.cambiosEnImagen;

import entradasalida.EntradaPorDefecto;
import utilerias.comunes.TipoGiro;
import utilerias.comunes.TipoModificacionTamanio;
import utilerias.imagenes.ModificadorDeImagenes;
import static registros.cambiosEnImagen.VistaCambioImagen.*;

/**
 * Clase que controla las funciones de el modificador de imagenes.
 * @author Lorenzo Trujillo Rojas.
 * @version 1.0
 */
public class ControladorCambioImagen {
    private ModificadorDeImagenes manipuladorImagenes;

    /**
     * Constructor de la clase.
     */
    public ControladorCambioImagen(){
        VistaCambioImagen.imprimirMensajeIngresaRutaImagen();
        String ruta = EntradaPorDefecto.consolaCadenas();
        manipuladorImagenes = new ModificadorDeImagenes(ruta);
        if(manipuladorImagenes.laImagenEsNula()){
            VistaCambioImagen.imprimirMensajeRutaInvalida();
            System.exit(1);
        }
        iniciarMenu();

    }

    /**
     * Metodo que inicia el menu principal.
     */
    private void iniciarMenu(){
        int opcion = 0;
        do{
            imprimirMenuPrincipal();
            opcion = Integer.parseInt(EntradaPorDefecto.consolaCadenas());
            switch (opcion){
                case 1:opcionPasarAescalaDeGrises();
                break;
                case 2:opcionModificarBrillo();
                break;
                case 3:opcionInvertirImagenVerticalmente();
                break;
                case 4:opcionInvertirImagenHorizontalmente();
                break;
                case 5:opcionGirarImagen();
                break;
                case 6: opcionImagenTranspuesta();
                break;
                case 7:opcionRedimensionarImagen();
                break;
                case 8:opcionAgregarMarco();
                break;
                case 9:opcionInvertirColores();
                break;
                case 0:break;
                default:imprimirMensajeOpcionInvalida();
            }
        }while (opcion!=0);
    }

    /**
     * Metodo que obtiene informacion para invertir los colores de una imagen.
     */
    private void opcionInvertirColores() {
        imprimirMensajeIngresarRutaSalida();
        String rutaSalida = EntradaPorDefecto.consolaCadenas();
        imprimirMensajeIngresaFormatoImagen();
        String formatoImagen = EntradaPorDefecto.consolaCadenas();
        if(!manipuladorImagenes.invertirColores(rutaSalida,formatoImagen)){
            imprimirMensajeRutaNoSeRealizoLaAccion();
            return;
        }
        imprimirImagenCreada(rutaSalida);
    }

    /**
     * Metodo que obtiene informacion para agregar un marco a una imagen.
     */
    private void opcionAgregarMarco() {
        imprimirMensajeIngresarRutaSalida();
        String rutaSalida = EntradaPorDefecto.consolaCadenas();
        imprimirMensajeIngresaFormatoImagen();
        String formatoImagen = EntradaPorDefecto.consolaCadenas();

        imprimirMensajeRojo();
        int rojo = Integer.parseInt(EntradaPorDefecto.consolaCadenas());
        imprimirMensajeVerde();
        int verde = Integer.parseInt(EntradaPorDefecto.consolaCadenas());
        imprimirMensajeAzul();
        int azul = Integer.parseInt(EntradaPorDefecto.consolaCadenas());
        imprimirMensajeAlpha();
        int alpha = Integer.parseInt(EntradaPorDefecto.consolaCadenas());
        imprimirMensajeTamanio();
        int tamanio = Integer.parseInt(EntradaPorDefecto.consolaCadenas());
        if(!manipuladorImagenes.agregarMarco(rojo,verde,azul,alpha,tamanio,rutaSalida,formatoImagen)){
            imprimirMensajeRutaNoSeRealizoLaAccion();
            return;
        }
        imprimirImagenCreada(rutaSalida);
    }

    /**
     * Metodo que obtiene informacion para redimensionar una imagen.
     */
    private void opcionRedimensionarImagen() {
        imprimirOpcionesRedimensionarImagen();
        boolean resultado=true;
        String rutaSalida="";
        int opcionRedimension=Integer.parseInt(EntradaPorDefecto.consolaCadenas());
        switch (opcionRedimension){
            case 1: imprimirOpcionesPorDefecto();
                    int opcionRedimensionDefault=Integer.parseInt(EntradaPorDefecto.consolaCadenas());
                    imprimirMensajeIngresarRutaSalida();
                    rutaSalida = EntradaPorDefecto.consolaCadenas();
                    imprimirMensajeIngresaFormatoImagen();
                    String formatoImagen = EntradaPorDefecto.consolaCadenas();
                    switch (opcionRedimensionDefault){
                        case 1: resultado=manipuladorImagenes.cambiarTamanio(TipoModificacionTamanio.AUMENTO_AL_DOBLE,rutaSalida,formatoImagen);
                        break;
                        case 2: resultado=manipuladorImagenes.cambiarTamanio(TipoModificacionTamanio.AUMENTO_AL_TRIPLE,rutaSalida,formatoImagen);
                        break;
                        case 3: resultado=manipuladorImagenes.cambiarTamanio(TipoModificacionTamanio.AUMENTO_AL_CUADRUPLE,rutaSalida,formatoImagen);
                        break;
                        case 4: resultado=manipuladorImagenes.cambiarTamanio(TipoModificacionTamanio.DISMINUIR_A_LA_MITAD,rutaSalida,formatoImagen);
                        break;
                        case 5: resultado=manipuladorImagenes.cambiarTamanio(TipoModificacionTamanio.DISMINUIR_A_LA_TERCERA_PARTE,rutaSalida,formatoImagen);
                        break;
                        case 6: resultado=manipuladorImagenes.cambiarTamanio(TipoModificacionTamanio.DISMINUIR_A_LA_CUARTA_PARTE,rutaSalida,formatoImagen);
                        break;
                        default:imprimirMensajeOpcionInvalida();
                    }
                    break;
            case 2: imprimirMensajeAncho();
                    int ancho = Integer.parseInt(EntradaPorDefecto.consolaCadenas());
                    imprimirMensajeAlto();
                    int alto = Integer.parseInt(EntradaPorDefecto.consolaCadenas());
                    imprimirMensajeIngresarRutaSalida();
                    rutaSalida = EntradaPorDefecto.consolaCadenas();
                    imprimirMensajeIngresaFormatoImagen();
                    formatoImagen = EntradaPorDefecto.consolaCadenas();
                    resultado = manipuladorImagenes.cambiarTamanio(alto,ancho,rutaSalida,formatoImagen);
                    break;
            default:imprimirMensajeOpcionInvalida();
        }
        if (!resultado){
            imprimirMensajeRutaNoSeRealizoLaAccion();
            return;
        }
        imprimirImagenCreada(rutaSalida);
    }

    /**
     * Metodo que obtiene informacion para transponer una imagen.
     */
    private void opcionImagenTranspuesta() {
        imprimirMensajeIngresarRutaSalida();
        String rutaSalida = EntradaPorDefecto.consolaCadenas();
        imprimirMensajeIngresaFormatoImagen();
        String formatoImagen = EntradaPorDefecto.consolaCadenas();
        if(!manipuladorImagenes.imagenTranspuesta(rutaSalida,formatoImagen)){
            imprimirMensajeRutaNoSeRealizoLaAccion();
            return;
        }
        imprimirImagenCreada(rutaSalida);
    }

    /**
     * Metodo que obtiene informacion para girar una imagen.
     */
    private void opcionGirarImagen() {
        imprimirMensajeEligeGiroImagen();
        int opcionGiro = Integer.parseInt(EntradaPorDefecto.consolaCadenas());
        imprimirMensajeIngresarRutaSalida();
        String rutaSalida = EntradaPorDefecto.consolaCadenas();
        imprimirMensajeIngresaFormatoImagen();
        String formatoImagen = EntradaPorDefecto.consolaCadenas();
        boolean realizado=false;
        switch (opcionGiro){
            case 1: realizado=manipuladorImagenes.girarImagen(rutaSalida,formatoImagen, TipoGiro.GIRO_90);
            break;
            case 2: realizado=manipuladorImagenes.girarImagen(rutaSalida,formatoImagen, TipoGiro.GIRO_180);
            break;
            case 3: realizado=manipuladorImagenes.girarImagen(rutaSalida,formatoImagen, TipoGiro.GIRO_270);
            break;
        }
        if(!realizado){
            imprimirMensajeRutaNoSeRealizoLaAccion();
            return;
        }
        imprimirImagenCreada(rutaSalida);
    }

    /**
     * Metodo que obtiene informacion para invertir una imagen horizontalmente.
     */
    private void opcionInvertirImagenHorizontalmente() {
        imprimirMensajeIngresarRutaSalida();
        String rutaSalida = EntradaPorDefecto.consolaCadenas();
        imprimirMensajeIngresaFormatoImagen();
        String formatoImagen = EntradaPorDefecto.consolaCadenas();
        if(!manipuladorImagenes.voltearHorizontalmente(rutaSalida,formatoImagen)){
            imprimirMensajeRutaNoSeRealizoLaAccion();
            return;
        }
        imprimirImagenCreada(rutaSalida);
    }

    /**
     * Metodo que obtiene informacion para invertir una imagen verticalmente.
     */
    private void opcionInvertirImagenVerticalmente() {
        imprimirMensajeIngresarRutaSalida();
        String rutaSalida = EntradaPorDefecto.consolaCadenas();
        imprimirMensajeIngresaFormatoImagen();
        String formatoImagen = EntradaPorDefecto.consolaCadenas();
        if(!manipuladorImagenes.voltearVerticalmente(rutaSalida,formatoImagen)){
            imprimirMensajeRutaNoSeRealizoLaAccion();
            return;
        }
        imprimirImagenCreada(rutaSalida);
    }

    /**
     * Metodo que obtiene informacion para modificar el brillo de una imagen.
     */
    private void opcionModificarBrillo() {
        imprimirMensajeIngresarRutaSalida();
        String rutaSalida = EntradaPorDefecto.consolaCadenas();
        imprimirMensajeIngresaFormatoImagen();
        String formatoImagen = EntradaPorDefecto.consolaCadenas();
        imprimirMensajeBrillo();
        int brillo = Integer.parseInt(EntradaPorDefecto.consolaCadenas());

        if(!manipuladorImagenes.cambiarBrilloImagen(rutaSalida,formatoImagen,brillo)){
            imprimirMensajeRutaNoSeRealizoLaAccion();
            return;
        }
        imprimirImagenCreada(rutaSalida);
    }

    /**
     * Metodo que obtiene informacion para pasar a escala de grises una imagen.
     */
    private void opcionPasarAescalaDeGrises(){
        imprimirMensajeIngresarRutaSalida();
        String rutaSalida = EntradaPorDefecto.consolaCadenas();
        imprimirMensajeIngresaFormatoImagen();
        String formatoImagen = EntradaPorDefecto.consolaCadenas();
        if(!manipuladorImagenes.convertirAEscalaDeGrises(rutaSalida,formatoImagen)){
            imprimirMensajeRutaNoSeRealizoLaAccion();
            return;
        }
        imprimirImagenCreada(rutaSalida);
    }
}
