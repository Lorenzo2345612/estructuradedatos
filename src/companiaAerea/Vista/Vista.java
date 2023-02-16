package companiaAerea.Vista;

import companiaAerea.Modelo.Aeropuerto;
import companiaAerea.Modelo.Avion;
import companiaAerea.Modelo.Piloto;
import companiaAerea.Modelo.Vuelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Vista {

    private final String[] TIPOS = {"Carga","Pasajeros","Militar","Recreacion","Excursion"};
    private Scanner teclado = new Scanner(System.in);
    public int imprimirMenuPrincipal(){
        System.out.println("Menu Principal");
        System.out.println("Elija una opcion:");
        System.out.println("1.- Dar de alta un avion");
        System.out.println("2.- Consultar aviones por tipo");
        System.out.println("3.- Dar de alta un piloto");
        System.out.println("4.- Dar de alta un aeropuerto");
        System.out.println("5.- Registrar vuelo");
        System.out.println("6.- Consultar vuelo por Origen");
        System.out.println("7.- Consultar vuelo por Destino");
        System.out.println("8.- Consultar aeropuertos por ciudad");
        System.out.println("9.- Consultar registro de vuelo de un avion");
        System.out.println("0.- Salir");

        return Integer.parseInt(teclado.nextLine());
    }

    public Avion obtenerAvionNuevo(){
        Avion avion=new Avion();

        System.out.println("Ingresa el tipo de avion.");
        imprimirTipos();
        avion.setTipo(this.TIPOS[Integer.parseInt(teclado.nextLine())-1]);

        System.out.println("Ingresa la matricula");
        avion.setMatricula(teclado.nextLine());

        System.out.println("Ingresa el fabricante");
        avion.setFabricante(teclado.nextLine());

        System.out.println("Ingresa el modelo");
        avion.setModelo(teclado.nextLine());

        System.out.println("Ingresa la capacidad de pasajeros");
        avion.setCapacidad(Integer.parseInt(teclado.nextLine()));

        System.out.println("Ingresa la autonomia en kilometros");
        avion.setAutonomia(Integer.parseInt(teclado.nextLine()));

        return avion;

    }

    public Piloto obtenerPilotoNuevo(){
        Piloto piloto = new Piloto();

        System.out.println("Ingresa el nombre del piloto.");
        piloto.setNombre(teclado.nextLine());

        System.out.println("Ingresa el tipo de licencia");
        imprimirTipos();
        piloto.setTipoLicencia(this.TIPOS[Integer.parseInt(teclado.nextLine())-1]);


        return piloto;

    }

    public Aeropuerto obtenerAeropuertoNuevo(){
        Aeropuerto aeropuerto = new Aeropuerto();

        System.out.println("Ingresa el nombre del aeropuerto.");
        aeropuerto.setNombre(teclado.nextLine());

        System.out.println("Ingresa la ciudad del aeropuerto.");
        aeropuerto.setCiudad(teclado.nextLine());

        System.out.println("Ingresa el pais del aeropuerto.");
        aeropuerto.setPais(teclado.nextLine());


        return aeropuerto;
    }

    public String consultarAvionesPorTipo(){
        System.out.println("Ingresa el tipo de avion");
        imprimirTipos();
        return this.TIPOS[Integer.parseInt(teclado.nextLine())-1];
    }

    public void imprimirTipos(){
        for (int iterador = 0; iterador < this.TIPOS.length; iterador++) {
            System.out.println((iterador+1)+" "+this.TIPOS[iterador]);
        }
    }

    public void imprimirErrorListaVacia(){
        System.out.println("No hay resultados.");
    }

    public void imprimirListaAviones(ArrayList<Avion> aviones){
        for (int iterador = 0; iterador < aviones.size(); iterador++) {
            System.out.println((iterador+1)+" "+aviones.get(iterador).toString());
        }
    }

    public void imprimirListaPilotos(ArrayList<Piloto> pilotos){
        for (int iterador = 0; iterador < pilotos.size(); iterador++) {
            System.out.println((iterador+1)+" "+pilotos.get(iterador).toString());
        }

    }

    public void imprimirListaAeropuertos(ArrayList<Aeropuerto> aeropuertos){
        for (int iterador = 0; iterador < aeropuertos.size(); iterador++) {
            System.out.println((iterador+1)+" "+aeropuertos.get(iterador).toString());
        }
    }

    public void imprimirListaVuelos(ArrayList<Vuelo> vuelos){
        for (int iterador = 0; iterador < vuelos.size(); iterador++) {
            System.out.println((iterador+1)+" "+vuelos.get(iterador).toString());
        }
    }


    public int pedirAvion(ArrayList<Avion> aviones){
        System.out.println("Ingresa el avion a utilizar en el vuelo");
        imprimirListaAviones(aviones);
        return Integer.parseInt(teclado.nextLine())-1;
    }

    public int pedirPiloto(ArrayList<Piloto> pilotos){
        System.out.println("Ingresa el piloto que realizara el vuelo");
        imprimirListaPilotos(pilotos);
        return Integer.parseInt(teclado.nextLine())-1;
    }

    public int obtenerAeropuertoOrigen(ArrayList<Aeropuerto> aeropuertos){
        System.out.println("Ingresa el aeropuerto de origen");
        imprimirListaAeropuertos(aeropuertos);
        return Integer.parseInt(teclado.nextLine())-1;
    }

    public int obtenerAeropuertoDestino(ArrayList<Aeropuerto> aeropuertos){
        System.out.println("Ingresa el aeropuerto de destino");
        imprimirListaAeropuertos(aeropuertos);
        return Integer.parseInt(teclado.nextLine())-1;
    }

    public String obtenerFechaVuelo(){
        System.out.println("Ingresa la fecha del vuelo en formato dd-mm-yy");
        return teclado.nextLine();
    }

    public Aeropuerto preguntarAeropuerto(ArrayList<Aeropuerto> aeropuertos){
        System.out.println("Elige el aeropuerto");
        imprimirListaAeropuertos(aeropuertos);
        return aeropuertos.get(Integer.parseInt(teclado.nextLine())-1);
    }

    public String preguntarCiudad(ArrayList<String> ciudades){
        System.out.println("Ingresa el numero de la ciudad que deseas consultar");
        imprimirCiudades(ciudades);
        return ciudades.get(Integer.parseInt(teclado.nextLine())-1);
    }

    private void imprimirCiudades(ArrayList<String> ciudades){
        for (int iterador = 0; iterador < ciudades.size(); iterador++) {
            System.out.println((iterador+1)+" "+ciudades.get(iterador));
        }
    }

    public Avion obtenerRegistroDeAvion(ArrayList<Avion> avions){
        System.out.println("Ingrese el avion que quiere consultar");
        imprimirListaAviones(avions);
        return avions.get(Integer.parseInt(teclado.nextLine())-1);
    }

    public void imprimirRegistroDeVuelo(ArrayList<Vuelo> vuelos,Avion avion){
        System.out.println("Registro de vuelo del avion con matricula"+avion.getMatricula());
        imprimirListaVuelos(vuelos);
    }


    public void imprimirMensajeErrorNoHayAviones(){
        System.out.println("No hay aviones disponibles o el avion no existe");
    }

    public void imprimirMensajeErrorNoHayPilotos(){
        System.out.println("No hay pilotos disponibles o el piloto no existe");
    }

    public void imprimirMensajeErrorNoHayAeropuertosDisponibles(){
        System.out.println("No hay Aeropuertos disponibles");
    }

    public void errorNoExisteElAeropuerto(){
        System.out.println("No existe el aeropuerto seleccionado");
    }
}
