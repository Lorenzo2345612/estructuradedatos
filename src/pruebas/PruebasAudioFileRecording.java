package pruebas;

import audio.AudioFileRecord;
import entradasalida.SalidaPorDefecto;

public class PruebasAudioFileRecording {
    public static void main(String[] args) {

        AudioFileRecord audio = new AudioFileRecord("C:/Users/loren/Music/audio.wav");

        SalidaPorDefecto.escrituraArchivo("C:/Users/loren/Music/frst.txt",audio.getBuffer());

        audio.preEnfasis();
        SalidaPorDefecto.escrituraArchivo("C:/Users/loren/Music/preE.txt",audio.getBuffer());

        audio.subirVolumen(150);
        SalidaPorDefecto.escrituraArchivo("C:/Users/loren/Music/subV.txt",audio.getBuffer());

        audio.bajarVolumen(75);
        SalidaPorDefecto.escrituraArchivo("C:/Users/loren/Music/bajV.txt",audio.getBuffer());


        audio.acelerarAudio(2);
        SalidaPorDefecto.escrituraArchivo("C:/Users/loren/Music/acel.txt",audio.getBuffer());
        audio.decelerarAudio(2);
        SalidaPorDefecto.escrituraArchivo("C:/Users/loren/Music/decel.txt",audio.getBuffer());

        audio.eliminarSilencios();
        SalidaPorDefecto.escrituraArchivo("C:/Users/loren/Music/elA.txt",audio.getBuffer());

        audio.voltearEjeX();
        SalidaPorDefecto.escrituraArchivo("C:/Users/loren/Music/voltX.txt",audio.getBuffer());

        audio.voltearEjeY();
        SalidaPorDefecto.escrituraArchivo("C:/Users/loren/Music/voltY.txt",audio.getBuffer());



        for (int iterador = 1; iterador < 6; iterador++) {
            audio = new AudioFileRecord("C:/Users/loren/Music/vocales/a_toma_"+iterador+".wav");
            SalidaPorDefecto.terminal("Energia de la muestra: "+audio.obtenerEnergia()+"\n\n\n\n\n");
        }

        for (int iterador = 1; iterador < 6; iterador++) {
            audio = new AudioFileRecord("C:/Users/loren/Music/vocales/e_toma_"+iterador+".wav");
            SalidaPorDefecto.terminal("Energia de la muestra: "+audio.obtenerEnergia()+"\n\n\n\n\n");
        }

        for (int iterador = 1; iterador < 6; iterador++) {
            audio = new AudioFileRecord("C:/Users/loren/Music/vocales/i_toma_"+iterador+".wav");
            SalidaPorDefecto.terminal("Energia de la muestra: "+audio.obtenerEnergia()+"\n\n\n\n\n");
        }

        for (int iterador = 1; iterador < 6; iterador++) {
            audio = new AudioFileRecord("C:/Users/loren/Music/vocales/o_toma_"+iterador+".wav");
            SalidaPorDefecto.terminal("Energia de la muestra: "+audio.obtenerEnergia()+"\n\n\n\n\n");
        }

        for (int iterador = 1; iterador < 6; iterador++) {
            audio = new AudioFileRecord("C:/Users/loren/Music/vocales/u_toma_"+iterador+".wav");
            SalidaPorDefecto.terminal("Energia de la muestra: "+audio.obtenerEnergia()+"\n\n\n\n\n");
        }

    }
}
