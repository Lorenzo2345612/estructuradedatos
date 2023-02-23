package audio;

import java.io.*;

import audio.wavfile.*;
import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstaticaNumerica;
import utilerias.comunes.ConversorDeDatos;

public class AudioFileRecord {
    private long numFrames;  //numero de tramas, número de muestras totales del archivo por canal
    private long sampleRate; //numero de muestras por segundo a la que se discretiza la señal
    private int numChannels; //número de canales
    private double[] buffer; //audio original
    private double[] buffer2; //audio modificado
    private String archivo;   //nombre de archivo dado por el usuario
    private WavFile wavFileR; //apuntador de archivo leido
    private WavFile wavFileW;  //apuntador de archivo a escribir
    private String nomArchivo; //nombre archivo (uno.wav)
    private String nomRuta;    //ruta donde esta guardado el archivo (/home)
    private int validBits;     //bits usados para la discretización
    
    private ListaEstaticaNumerica bufferTemporal;

    public AudioFileRecord(String archivo) {
        this.archivo = archivo;
        // Abre el archivo wav y asigna parámetros a las variables
        try {
            File file = new File(archivo);
            wavFileR = WavFile.openWavFile(file);
            nomArchivo = file.getName();
            nomRuta = file.getParent();
        } catch (Exception e) {

        }
        numChannels = wavFileR.getNumChannels();
        numFrames = wavFileR.getNumFrames();
        sampleRate = wavFileR.getSampleRate();
        validBits=wavFileR.getValidBits();

        leerAudio();
        bufferTemporal=new ListaEstaticaNumerica(buffer.length);
    }

    public void leerAudio() {
        try {

            // Muestra datos del archivo
            wavFileR.display();

            // Crea buffer de origen y de temporal
            buffer = new double[(int) numFrames * numChannels];
            buffer2 = new double[buffer.length];

            //tramas leidas
            int framesRead;

            // Lee tramas totales
            framesRead = wavFileR.readFrames(buffer, (int) numFrames);

            // Recorrer todas las tramas del archivo y guardarlas en el arreglo.
            for (int s = 0; s < framesRead * numChannels; s++) {
                buffer2[s] = buffer[s];
            }

            // Cierra archivo
            wavFileR.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void EscribirAudio() {
        try {

            //Crear el apuntador al archivo para guardar datos del temporal
            File file = new File(nomRuta + "/2_" + nomArchivo);

            // Creamos un nuevo archivo de audio con los mismos datos que el original
            wavFileW = WavFile.newWavFile(file, numChannels, numFrames, validBits, sampleRate);

            // Escribimos los frames o muestras totales del temporal
            wavFileW.writeFrames(buffer2, (int) numFrames);

            // Cerramos el archivo
            wavFileW.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**
     * Metodo que aplica un filtro de frecuencias bajas al audio.
     */
    public void preEnfasis(){
        bufferTemporal.agregarBuffer(ConversorDeDatos.doubleArrayToObjectArray(buffer));

        for (int iterador = 1; iterador < bufferTemporal.cantidad(); iterador++) {
            bufferTemporal.cambiar(iterador,aplicarFormulaFIR((double)bufferTemporal.obtener(iterador),(double)bufferTemporal.obtener(iterador-1)));
        }

        buffer2=ConversorDeDatos.objectArrayToDoubleArray(bufferTemporal.leerArreglo());
        buffer=ConversorDeDatos.objectArrayToDoubleArray(bufferTemporal.leerArreglo());
        EscribirAudio();
    }

    /**
     * Metodo que sube El volumen al audio.
     * @param intensidad Es el porcentaje de audio a subir.
     */
    public void subirVolumen(int intensidad){
        if (!validarRangoVolumen(1000,100,intensidad))return;
        double porcentaje = ((double)intensidad)/100;
        cambiarVolumen(porcentaje);

    }

    /**
     * Metodo que baja el volumen al audio.
     * @param intensidad Es el porcentaje de audio a bajar.
     */
    public void bajarVolumen(int intensidad){
        if (!validarRangoVolumen(100,0,intensidad))return;
        double porcentaje = ((double)intensidad)/100;
        cambiarVolumen(porcentaje);
    }

    private boolean validarRangoVolumen(int maximo, int minimo, int valorActual){
        if (valorActual>=minimo && valorActual<=maximo)return true;
        return false;
    }

    /**
     * Metodo que aumenta la velocidad de reproduccion de un audio.
     * @param velocidad Es el numero al que se subira la velocidad de reproduccion.
     */
    public void acelerarAudio(int velocidad){
        bufferTemporal=new ListaEstaticaNumerica(buffer.length/velocidad);

        for (int iteradorListaEstatica = 0; iteradorListaEstatica < buffer.length; iteradorListaEstatica+=velocidad) {
            double temporal=0;
            int cntr=iteradorListaEstatica;
            while (cntr<iteradorListaEstatica+velocidad && cntr<buffer.length){
                temporal+=buffer[cntr];
                cntr++;
            }
            bufferTemporal.agregar(temporal/velocidad);
        }

        buffer2=ConversorDeDatos.objectArrayToDoubleArray(bufferTemporal.leerArreglo());
        buffer=ConversorDeDatos.objectArrayToDoubleArray(bufferTemporal.leerArreglo());
        numFrames=numFrames/velocidad;
        EscribirAudio();
    }

    /**
     * Metodo que disminuye la velocidad de reproduccion de un audio.
     * @param velocidad Es el numero al que se bajara la velocidad de reproduccion.
     */
    public void decelerarAudio(int velocidad){

        bufferTemporal=new ListaEstaticaNumerica(((buffer.length-1)*velocidad)+1);

        for (int iteradorListaEstatica = 0; iteradorListaEstatica < buffer.length-1; iteradorListaEstatica++) {

            bufferTemporal.agregar(buffer[iteradorListaEstatica]);

            double pieza = (buffer[iteradorListaEstatica]+buffer[(iteradorListaEstatica)+1])/velocidad;

            for (int indiceMedio = 1; indiceMedio < velocidad; indiceMedio++) {
                bufferTemporal.agregar(buffer[iteradorListaEstatica]+(pieza*indiceMedio));
            }
        }
        bufferTemporal.agregar(buffer[buffer.length-1]);
        buffer2=ConversorDeDatos.objectArrayToDoubleArray(bufferTemporal.leerArreglo());
        buffer=ConversorDeDatos.objectArrayToDoubleArray(bufferTemporal.leerArreglo());
        numFrames=(numFrames*velocidad)-velocidad+1;
        EscribirAudio();

    }

    /**
     * Metodo que elimina los silencios de un audio.
     */
    public void eliminarSilencios(){
        double umbral =.00008;
        for (int iteradorBuffer = 0; iteradorBuffer < buffer.length; iteradorBuffer++) {
            if(!(buffer[iteradorBuffer]>=(umbral*-1) && buffer[iteradorBuffer]<=0) && !(buffer[iteradorBuffer]>=0 && buffer[iteradorBuffer]<=umbral)){
                bufferTemporal.agregar(buffer2[iteradorBuffer]);
            }
        }
        numFrames=bufferTemporal.cantidad()/2;
        buffer2=ConversorDeDatos.objectArrayToDoubleArray(bufferTemporal.leerArreglo());
        buffer=ConversorDeDatos.objectArrayToDoubleArray(bufferTemporal.leerArreglo());
        EscribirAudio();
    }

    /**
     * Metodo que invierte la reproduccion del audio.
     */
    public void voltearEjeX(){
        bufferTemporal.agregarBuffer(ConversorDeDatos.doubleArrayToObjectArray(buffer));
        bufferTemporal.invertir();
        buffer2=ConversorDeDatos.objectArrayToDoubleArray(bufferTemporal.leerArreglo());
        buffer=ConversorDeDatos.objectArrayToDoubleArray(bufferTemporal.leerArreglo());
        EscribirAudio();
    }

    /**
     * Metodo que invierte la fase del audio.
     */
    public void voltearEjeY(){
        bufferTemporal.agregarBuffer(ConversorDeDatos.doubleArrayToObjectArray(buffer));
        bufferTemporal.porEscalar(-1);
        buffer2=ConversorDeDatos.objectArrayToDoubleArray(bufferTemporal.leerArreglo());
        buffer=ConversorDeDatos.objectArrayToDoubleArray(bufferTemporal.leerArreglo());
        EscribirAudio();
    }


    /**
     * Metodo que obtiene la energia generada por el audio.
     * @return Regresa la suma de la energia generada por el audio.
     */
    public double obtenerEnergia(){
        bufferTemporal.agregarBuffer(ConversorDeDatos.doubleArrayToObjectArray(buffer));
        //SalidaPorDefecto.escrituraArchivo("C:/Users/loren/Music/vocales/a.txt",ConversorDeDatos.objectArrayToDoubleArray(bufferTemporal.leerArreglo()));
        bufferTemporal.aplicarPotencia(2);
        return bufferTemporal.suma();
    }

    /**
     * Metodo auxiliar para cambiar el volumen.
     * @param intensidad Es el escalar al que se sometera.
     */
    private void cambiarVolumen(double intensidad){
        bufferTemporal.agregarBuffer(ConversorDeDatos.doubleArrayToObjectArray(buffer));
        bufferTemporal.porEscalar(intensidad);
        buffer2=ConversorDeDatos.objectArrayToDoubleArray(bufferTemporal.leerArreglo());
        buffer=ConversorDeDatos.objectArrayToDoubleArray(bufferTemporal.leerArreglo());
        EscribirAudio();
    }

    /**
     * Metodo que calcula la intensidad del
     * @param valActual
     * @param valAnterior
     * @return
     */
    private double aplicarFormulaFIR(double valActual,double valAnterior){
        double alpha = 0.98;
        return valActual - (valAnterior*alpha);
    }

    /**
     * Metodo que retorna el buffer, solo para efectos de creacion de archivos para analisis.
     * @return Regresa el buffer.
     */
    public double[] getBuffer(){
        return buffer;
    }
}
