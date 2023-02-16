package companiaAerea.Controlador;


import companiaAerea.Modelo.Aeropuerto;
import companiaAerea.Modelo.Avion;
import companiaAerea.Modelo.Piloto;
import companiaAerea.Modelo.Vuelo;
import companiaAerea.Vista.Vista;

import java.util.ArrayList;

public class Controlador {
    private Aviones manejadorAviones = new Aviones();
    private Pilotos manejadorPilotos = new Pilotos();
    private Vuelos manejadorVuelos = new Vuelos();
    private Aeropuertos manejadorAeropuertos = new Aeropuertos();
    private Vista vista= new Vista();


    public void iniciar(){
        boolean flag=true;
        while(flag){
            int respuesta = vista.imprimirMenuPrincipal();
            if(respuesta!=0){
                procesarOpcionesMenuPrincipal(respuesta);
            }else {
                break;
            }
        }
    }

    private void procesarOpcionesMenuPrincipal(int opcion){
        switch (opcion){
            case 1 :    darDeAltaAvion();
                        break;
            case 2 :    consultarAvionesPorTipo();
                        break;
            case 3 :    darDeAltaUnPiloto();
                        break;
            case 4 :    darDeAltaAeropuerto();
                        break;
            case 5 :    darDeAltaVuelo();
                        break;
            case 6 :    consultarVueloOrigen();
                        break;
            case 7 :    consultarVueloDestino();
                        break;
            case 8 :    consultarAeropuertosPorCiudad();
                        break;
            case 9 :    consultarRegistroDeVueloAvion();
                        break;

                        default: break;
        }

    }

    private void darDeAltaAvion(){
        manejadorAviones.agregarAvion(vista.obtenerAvionNuevo());
    }

    private void consultarAvionesPorTipo(){
        String tipo=vista.consultarAvionesPorTipo();
        ArrayList<Avion> aviones=manejadorAviones.obtenerAvionesPorTipo(tipo);
        if (aviones.size()==0) {
            System.out.println(aviones.size());
            vista.imprimirErrorListaVacia();
        }else{
            vista.imprimirListaAviones(aviones);
        }
    }

    private void darDeAltaUnPiloto(){
        manejadorPilotos.agregarPiloto(vista.obtenerPilotoNuevo());
    }

    private void darDeAltaAeropuerto(){
        manejadorAeropuertos.agregarAeropuerto(vista.obtenerAeropuertoNuevo());
    }

    private void darDeAltaVuelo(){
        Vuelo vuelo = new Vuelo();

        ArrayList<Avion> aviones= manejadorAviones.obtenerAviones();

        if (aviones.isEmpty()){
            vista.imprimirMensajeErrorNoHayAviones();
            return;
        }

        int index=vista.pedirAvion(aviones);

        if (verificarExistenciaDeIndice(aviones.size(),index)){
            vista.imprimirMensajeErrorNoHayAviones();
            return;
        }else{
            vuelo.setAvion(aviones.get(index));
        }

        ArrayList<Piloto> pilotosDisponibles=manejadorPilotos.obtenerPilotosPorTipo(aviones.get(index).getTipo());

        if(pilotosDisponibles.isEmpty()){
            vista.imprimirMensajeErrorNoHayPilotos();
            return;
        }

        index=vista.pedirPiloto(pilotosDisponibles);

        if (verificarExistenciaDeIndice(pilotosDisponibles.size(),index)){
            vista.imprimirMensajeErrorNoHayAviones();
            return;
        }else{
            vuelo.setPiloto(pilotosDisponibles.get(index));
        }

        ArrayList<Aeropuerto> aeropuertos = manejadorAeropuertos.obtenerAeropuertos();

        if (aeropuertos.isEmpty()){
            vista.imprimirMensajeErrorNoHayAeropuertosDisponibles();
            return;
        }

        index=vista.obtenerAeropuertoOrigen(aeropuertos);

        if(verificarExistenciaDeIndice(aeropuertos.size(),index)){
            vista.errorNoExisteElAeropuerto();
            return;
        }else{
            vuelo.setAeropuertoOrigen(aeropuertos.get(index));
        }

        Aeropuerto aeropuertoGuardado = aeropuertos.get(index);

        aeropuertos.remove(index);

        if (aeropuertos.isEmpty()){
            vista.imprimirMensajeErrorNoHayAeropuertosDisponibles();
            return;
        }

        index=vista.obtenerAeropuertoDestino(aeropuertos);

        if(verificarExistenciaDeIndice(aeropuertos.size(),index)){
            vista.errorNoExisteElAeropuerto();
            return;
        }else{
            vuelo.setAeropuertoDestino(aeropuertos.get(index));
        }

        vuelo.setFecha(vista.obtenerFechaVuelo());

        aeropuertos.add(aeropuertoGuardado);

        manejadorVuelos.registrarVuelo(vuelo);
    }

    private void consultarVueloOrigen(){
        ArrayList<Vuelo> vuelos=manejadorVuelos.consultarVuelosOrigen(vista.preguntarAeropuerto(manejadorAeropuertos.obtenerAeropuertos()));
        vista.imprimirListaVuelos(vuelos);
    }

    private void consultarVueloDestino(){
        ArrayList<Vuelo> vuelos=manejadorVuelos.consultarVuelosDestino(vista.preguntarAeropuerto(manejadorAeropuertos.obtenerAeropuertos()));
        vista.imprimirListaVuelos(vuelos);
    }

    private void consultarAeropuertosPorCiudad(){
        ArrayList<String> ciudades = manejadorAeropuertos.obtenerCiudadesDeAeropuertos();
        String ciudad = vista.preguntarCiudad(ciudades);
        vista.imprimirListaAeropuertos(manejadorAeropuertos.consultarPorCiudad(ciudad));
    }

    private void consultarRegistroDeVueloAvion(){
        Avion avion=vista.obtenerRegistroDeAvion(manejadorAviones.obtenerAviones());
        vista.imprimirRegistroDeVuelo(manejadorVuelos.obtenerVuelosPorAvion(avion),avion);
    }

    private boolean verificarExistenciaDeIndice(int maximo, int index){
        if (index>=maximo || index<0){
            return true;
        }
        return false;
    }



}
