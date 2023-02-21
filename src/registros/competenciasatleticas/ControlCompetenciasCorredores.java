package registros.competenciasatleticas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import estructurasnolineales.Matriz3;

public class ControlCompetenciasCorredores {
    protected Matriz3 kmRecorridos;
    protected ListaEstatica anios;
    protected ListaEstatica corredores;
    protected ListaEstatica eventosCompetencias;

    public ControlCompetenciasCorredores(int numAnios, int numCorredores, int numEventosCompetencias){
        kmRecorridos= new Matriz3(numAnios,numCorredores,numEventosCompetencias);

        anios=new ListaEstatica(numAnios);
        corredores=new ListaEstatica(numCorredores);
        eventosCompetencias= new ListaEstatica(numEventosCompetencias);

        kmRecorridos.rellenar(0.0);
    }
    public boolean agregarAnio(int anio){
        int indiceAnio=(int) anios.buscar(anio);
        if (indiceAnio!=-1)return false;

        return anios.agregar(anio)==-1 ? false : true;
    }

    public boolean agregarCorredor(Corredor corredor){
        int indiceCorredor=(int) corredores.buscar(corredor);
        if (indiceCorredor!=-1)return false;

        return corredores.agregar(corredor)==-1 ? false : true;
    }

    public boolean agregarEvento(EventoCompetencia evento){
        int indiceEvento=(int) eventosCompetencias.buscar(evento);
        if (indiceEvento!=-1)return false;

        return eventosCompetencias.agregar(evento)==-1 ? false : true;
    }

    public boolean agregarKilimetrosRecorridos(int anio, int numCorredor, String nombreEvento, double cantidadKms){
        ListaEstatica listaIndices= buscarIndicesCuboKms(anio,numCorredor,nombreEvento);
        if(listaIndices==null)return false;

        return kmRecorridos.cambiar((int) listaIndices.obtener(0),
                                    (int) listaIndices.obtener(1),
                                    (int) listaIndices.obtener(2),
                                    cantidadKms);

    }

    private ListaEstatica buscarIndicesCuboKms(int anio, int corredor, String nombreEvento){
        int indiceAnio=(int) anios.buscar(anio);
        int indiceCorredor=(int) corredores.buscar(corredor);
        int indiceEvento=(int) eventosCompetencias.buscar(nombreEvento);

        if(indiceAnio<0 || indiceEvento<0 || indiceCorredor<0)return null;

        ListaEstatica listaIndices = new ListaEstatica(3);
        listaIndices.agregar(indiceAnio);
        listaIndices.agregar(indiceCorredor);
        listaIndices.agregar(indiceEvento);

        return listaIndices;
    }

    public void imprimirAnios(){
        SalidaPorDefecto.terminal("Anios: \n");
        anios.imprimir();
    }

    public void imprimirCorredor(){
        SalidaPorDefecto.terminal("Corredores: \n");
        corredores.imprimir();
    }

    public void imprimirEventos(){
        SalidaPorDefecto.terminal("Eventos: \n");
        eventosCompetencias.imprimir();
    }

    public void imprimirKilometrosRecorridos(){
        SalidaPorDefecto.terminal("Kilometros: \n");
        kmRecorridos.imprimirXColumnas();
    }

    public void imprimirDatosCompetencias(){
        imprimirAnios();
        imprimirCorredor();
        imprimirEventos();
        imprimirKilometrosRecorridos();
    }

    //Preguntas comunes:
    //Indicar los kilometros recorridos de Lencho en "Viva la vida"
    //en los años 2000, 2005, 2019, 2020
    //Indicar los kilometros recorridos por lencho en 2005
    //...

    public double kmXCorredorXEvento(int numCorredor, String evento, ListaEstatica aniosPedidos){
        double total=0;
        for (int numAnio = 0; numAnio < aniosPedidos.cantidad(); numAnio++) {
            int anioPedido =(int) aniosPedidos.obtener(numAnio);
            double kmsIndividuales = kmXCorredorXEventoXAnio(numCorredor,evento,anioPedido);

            if(kmsIndividuales>=0){
                total+=kmsIndividuales;
            }
        }
        return total;
    }

    public double kmXCorredorXEventoXAnio(int numCorredor, String evento, int anio){
        ListaEstatica listaIndices=buscarIndicesCuboKms(anio,numCorredor,evento);

        if(listaIndices==null)return -1;

        return (double) kmRecorridos.obtener((int) listaIndices.obtener(0),(int) listaIndices.obtener(1),(int) listaIndices.obtener(2));
    }
}
