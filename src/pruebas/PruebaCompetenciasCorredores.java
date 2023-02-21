package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import estructurasLineales.ListaEstaticaNumerica;
import registros.competenciasatleticas.ControlCompetenciasCorredores;
import registros.competenciasatleticas.Corredor;
import registros.competenciasatleticas.EventoCompetencia;

public class PruebaCompetenciasCorredores {
    public static void main(String[] args) {
        ControlCompetenciasCorredores competencias = new ControlCompetenciasCorredores(4,3,5);

        competencias.agregarAnio(1980);
        competencias.agregarAnio(2000);
        competencias.agregarAnio(2005);
        competencias.agregarAnio(2019);

        Corredor corredor1 = new Corredor(101,"Pepe",20,"Mexicano");
        Corredor corredor2 = new Corredor(201,"Lencho",29,"Mexicano");
        Corredor corredor3 = new Corredor(301,"Jelipe",39,"Salvadoreño");

        competencias.agregarCorredor(corredor1);
        competencias.agregarCorredor(corredor2);
        competencias.agregarCorredor(corredor3);

        EventoCompetencia evento1= new EventoCompetencia("Viva la vida","Chinchisbravas");
        EventoCompetencia evento2= new EventoCompetencia("Vamos mal","Tangamandapio");

        competencias.agregarEvento(evento1);
        competencias.agregarEvento(evento2);

        competencias.agregarKilimetrosRecorridos(1980,301,"Vamos mal",201.2);
        competencias.agregarKilimetrosRecorridos(2000,201,"Viva la vida",102.1);
        competencias.agregarKilimetrosRecorridos(2005,101,"Vamos mal",500.4);
        competencias.agregarKilimetrosRecorridos(2019,201,"Viva la vida",45.0);

        competencias.imprimirDatosCompetencias();


        //Invocar Preguntas comunes
        ListaEstatica aniosPedidos = new ListaEstatica(3);
        aniosPedidos.agregar(2000);
        aniosPedidos.agregar(2019);
        aniosPedidos.agregar(2020);
        double kmPedidos=competencias.kmXCorredorXEvento(201,"Viva la vida",aniosPedidos);

        SalidaPorDefecto.terminal("La salida acumulada es de :"+kmPedidos);

    }
}
