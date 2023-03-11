package estructurasLineales;

import entradasalida.SalidaPorDefecto;
import utilerias.comunes.TipoOrden;

/**
 * Clase que simula una cola de prioridad.
 * @author Lorenzo Trujillo Rojas.
 * @version 1.0
 */
public class ColaPrioridadEstatica implements Lote{
    protected ListaEstatica informacionCola;
    protected ListaEstaticaOrdenada informacionPrioridad;
    protected TipoOrden tipoOrden;

    public ColaPrioridadEstatica(int tamanio, TipoOrden tipoOrden){
        informacionCola = new ListaEstatica(tamanio);
        informacionPrioridad = new ListaEstaticaOrdenada(tamanio, tipoOrden);
        this.tipoOrden = tipoOrden;
    }
    @Override
    public boolean lleno() {
        return informacionCola.llena();
    }
    @Override
    public boolean vacio() {
        return informacionCola.vacia();
    }
    @Override
    public boolean poner(Object info) {
        if(!(info instanceof ListaEstatica lista))return false;
        if(lista.cantidad()!=2 || !(lista.obtener(0) instanceof Integer temporal) || temporal<0)return false;
        Integer indiceAgregacion =(Integer) informacionPrioridad.buscar(lista.obtener(0));
        if(indiceAgregacion==null)return false;
        if(indiceAgregacion<0){
            Integer indiceAgregado= informacionPrioridad.agregar(lista.obtener(0));
            if(indiceAgregado<0){
                return false;
            }
            if(indiceAgregado>=informacionCola.cantidad()){
                ColaEstatica colaTemporal = new ColaEstatica(informacionCola.maximo());
                colaTemporal.poner(lista.obtener(1));
                informacionCola.agregar(colaTemporal);
            }else{
                ColaEstatica colaTemporal = new ColaEstatica(informacionCola.maximo());
                colaTemporal.poner(lista.obtener(1));
                informacionCola.insertar(indiceAgregado,colaTemporal);
            }
            return true;

        }else{
            ColaEstatica colaTemporal = (ColaEstatica) informacionCola.obtener(indiceAgregacion-1);
            return colaTemporal.poner(lista.obtener(1));
        }

    }
    @Override
    public Object quitar() {
        if(informacionPrioridad.vacia())return null;
        ColaEstatica colaTemporal = (ColaEstatica) informacionCola.obtener(0);
        Object respaldo = colaTemporal.quitar();
        if(!colaTemporal.vacio())return respaldo;
        informacionPrioridad.eliminar(0);
        informacionCola.eliminar(0);
        return respaldo;
    }
    @Override
    public void imprimir() {
        for (int iteradorCola = 0; iteradorCola < informacionCola.cantidad(); iteradorCola++) {
            SalidaPorDefecto.terminal("Prioridad: "+informacionPrioridad.obtener(iteradorCola)+" -> ");
            ColaEstatica colaTemporal =(ColaEstatica) informacionCola.obtener(iteradorCola);
            colaTemporal.imprimir();
        }

    }
    @Override
    public Object verTope() {
        if(informacionPrioridad.vacia())return null;
        ColaEstatica colaTemporal=(ColaEstatica) informacionCola.obtener(informacionCola.cantidad()-1);
        return colaTemporal.verTope();
    }

    /**
     * Metodo que muestra el elemento que saldra primero.
     * @return Regresa el objeto que esta a punto de salir.
     */
    public Object verInicio(){
        if(vacio())return null;
        ColaEstatica colaTemporal = (ColaEstatica) informacionCola.obtener(0);
        return colaTemporal.verInicio();
    }
}
