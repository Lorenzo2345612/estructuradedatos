package registros.SimuladorProcesos;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ColaPrioridadEstatica;
import estructurasLineales.ListaEstatica;
import utilerias.comunes.TipoOrden;

/**
 * Clase que se encarga de simular una descarga de procesos
 * en un sistema operativo.
 * @author Lorenzo Trujillo Rojas.
 * @version 1.0
 */
public class ManejadorDeProcesos {
    protected ListaEstatica procesos;
    protected ColaPrioridadEstatica colaDescarga;
    protected ColaPrioridadEstatica colaEjecucion;
    protected ColaPrioridadEstatica colaImpresion;
    protected ListaEstatica procesosTerminados;

    public ManejadorDeProcesos(ListaEstatica procesos) {
        this.procesos = procesos;
        colaDescarga = new ColaPrioridadEstatica(procesos.cantidad(), TipoOrden.DEC);
        colaEjecucion = new ColaPrioridadEstatica(procesos.cantidad(), TipoOrden.DEC);
        colaImpresion = new ColaPrioridadEstatica(procesos.cantidad(), TipoOrden.DEC);
        procesosTerminados = new ListaEstatica(procesos.cantidad());
    }

    /**
     * Metodo que simula la descarga de procesos en un sistema operativo.
     */
    public void iniciarDescargaDeProcesos(){
        pasarProcesosADescarga();
        int segundo =0;
        while(!colaDescarga.vacio() || !colaImpresion.vacio() || !colaEjecucion.vacio()){
            segundo++;
            if(!colaDescarga.vacio()){
                Proceso elementoEnProcesoDescarga = (Proceso) colaDescarga.verInicio();
                if(elementoEnProcesoDescarga.getTiempoDescarga()>0) {
                    elementoEnProcesoDescarga.decrementarTiempoDescarga();
                }else{
                    elementoEnProcesoDescarga.setEstado("ejecucion");
                    Proceso procesoTemporal= (Proceso) colaDescarga.quitar();
                    ListaEstatica listaTemporal = new ListaEstatica(2);
                    listaTemporal.agregar(procesoTemporal.getPrioridad());
                    listaTemporal.agregar(procesoTemporal);
                    colaEjecucion.poner(listaTemporal);
                }
            }

            if(!colaEjecucion.vacio()){
                Proceso elementoEnProcesoEjecucion = (Proceso) colaEjecucion.verInicio();
                if(elementoEnProcesoEjecucion.getTiempoEjecucion()>0) {
                    elementoEnProcesoEjecucion.decrementarTiempoEjecucion();
                }
                else{
                    elementoEnProcesoEjecucion.setEstado("impresion");
                    Proceso procesoTemporal= (Proceso) colaEjecucion.quitar();
                    ListaEstatica listaTemporal = new ListaEstatica(2);
                    listaTemporal.agregar(procesoTemporal.getPrioridad());
                    listaTemporal.agregar(procesoTemporal);
                    colaImpresion.poner(listaTemporal);
                }
            }

            if(!colaImpresion.vacio()){
                Proceso elementoEnProcesoImpresion = (Proceso) colaImpresion.verInicio();
                if(elementoEnProcesoImpresion.getTiempoImpresion()>0) {
                    elementoEnProcesoImpresion.decrementarTiempoImpresion();
                }else{
                    elementoEnProcesoImpresion.setEstado("finalizado");
                    procesosTerminados.agregar(colaImpresion.quitar());
                }
            }
            imprimirProcesos(segundo);
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){

            }
        }
    }

    /**
     * Metodo que se encarga de pasar los nuevos procesos a descarga.
     */
    private void pasarProcesosADescarga() {
        for (int iteradorListaProcesos = 0; iteradorListaProcesos < procesos.cantidad(); iteradorListaProcesos++) {
            ListaEstatica listaTemporal = new ListaEstatica(2);
            Proceso procesoTemporal =(Proceso) procesos.obtener(iteradorListaProcesos);
            procesoTemporal.setEstado("descarga");
            listaTemporal.agregar(procesoTemporal.getPrioridad());
            listaTemporal.agregar(procesoTemporal);
            colaDescarga.poner(listaTemporal);
        }
    }

    /**
     * Metodo que se encarga de imprimir el estado de los procesos en las
     * diferentes colas de prioridad.
     * @param segundo Representa el segundo en el que se encuentra el proceso.
     */
    private void imprimirProcesos(int segundo){
        SalidaPorDefecto.terminal("Segundo: "+segundo+"\n");
        SalidaPorDefecto.terminal("Procesos en descarga:\n");
        colaDescarga.imprimir();
        SalidaPorDefecto.terminal("Procesos en ejecucion:\n");
        colaEjecucion.imprimir();
        SalidaPorDefecto.terminal("Procesos en impresion:\n");
        colaImpresion.imprimir();
        SalidaPorDefecto.terminal("Procesos finalizados:\n");
        procesosTerminados.imprimir();
        SalidaPorDefecto.terminal("\n\n");
    }
}
