package pruebas;

import estructurasLineales.ListaEstatica;
import registros.SimuladorProcesos.ManejadorDeProcesos;
import registros.SimuladorProcesos.Proceso;

public class PruebaManejadorDeProcesos {
    public static void main(String[] args) {
        ListaEstatica listaProcesos = new ListaEstatica(4);
        listaProcesos.agregar(new Proceso("ventana 1",1,1,1,1,"inicial",10));
        listaProcesos.agregar(new Proceso("ventana 2",2,2,2,1,"inicial",2));
        listaProcesos.agregar(new Proceso("ventana 3",3,1,1,1,"inicial",1));
        listaProcesos.agregar(new Proceso("ventana 4",4,3,3,2,"inicial",15));
        ManejadorDeProcesos manejador = new ManejadorDeProcesos(listaProcesos);
        manejador.iniciarDescargaDeProcesos();
    }
}
