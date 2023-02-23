package estructurasLineales;

import entradasalida.SalidaPorDefecto;

import static utilerias.comunes.ConversorDeDatos.objectToInteger;


/**
 * Esta clase contiene la implementacion de un TDA VectorLista para generar listas estaticas.
 * @version 1.0
 * @author Clase ED
 */
public class ListaEstatica implements VectorLista{
    protected int tope;
    protected int MAXIMO;
    private final int VACIO=-1;
    protected Object[] informacion;

    public ListaEstatica(int tamanio){
        this.MAXIMO=tamanio;
        this.informacion=new Object[tamanio];
        this.tope=-1;
    }

    @Override
    public boolean vacia() {
        return this.tope == this.VACIO;
    }

    @Override
    public boolean llena() {
        return this.tope == this.MAXIMO-1;
    }

    @Override
    public Object obtener(int indice) {
        if(this.vacia())return null;
        if(!validarRango(indice)) return null;
        return this.informacion[indice];
    }

    @Override
    public boolean cambiar(int indice, Object info) {
        if(!validarRango(indice))return false;
        this.informacion[indice]=info;
        return true;
    }

    @Override
    public boolean cambiarListaEstatica(ListaEstatica indicesBusqueda, ListaEstatica infosNuevos) {
        if (indicesBusqueda.cantidad()!= infosNuevos.cantidad())return false;
        for (Object objetoActual:indicesBusqueda.informacion) {
            int indiceDeBusquedaActual = (Integer) objetoActual;
            if (indiceDeBusquedaActual>this.tope || indiceDeBusquedaActual<0){
                return false;
            }
        }
        for (int iterador = 0; iterador < indicesBusqueda.cantidad(); iterador++) {
            int indiceDeBusquedaActual = (Integer) indicesBusqueda.obtener(iterador);
            this.cambiar(indiceDeBusquedaActual,infosNuevos.obtener(iterador));

        }
        return true;
    }

    @Override
    public Object eliminar(int indice) {
        if (validarRango(indice)){
            Object eliminado = informacion[indice];
            tope--;
            for (int movs = indice; movs <= tope; movs++) {
                informacion[movs]=informacion[movs+1];
            }
            return eliminado;

        }
        return null;
    }

    @Override
    public boolean redimensionar(int maximo) {
        ListaEstatica nuevoArreglo = new ListaEstatica(maximo);
        if (maximo>this.MAXIMO){
            for (int iterador = 0; iterador < this.MAXIMO; iterador++) {
                nuevoArreglo.agregar(informacion[iterador]);
            }
        }else{
            for (int iterador = 0; iterador < maximo; iterador++) {
                nuevoArreglo.agregar(informacion[iterador]);
            }
            tope=maximo-1;
        }
        this.informacion=nuevoArreglo.informacion;
        this.MAXIMO= nuevoArreglo.maximo();
        return true;
    }

    @Override
    public int maximo() {
        return this.MAXIMO;
    }

    @Override
    public int cantidad() {
        return this.tope+1;
    }

    @Override
    public int agregar(Object info){
        if(llena()) return -1;
        this.tope+=1;
        this.informacion[tope]=info;
        return this.tope;

    }

    @Override
    public void imprimir() {
        for (int celda = tope; 0 <= celda; celda--) {
            SalidaPorDefecto.terminal(informacion[celda]+"\n");
        }
    }

    @Override
    public void imprimirOI() {
        for (int celda= 0; celda<=tope; celda++) {
            SalidaPorDefecto.terminal(informacion[celda]+"\n");
        }
    }

    @Override
    public Object buscar(Object info) {
        int posicion=0;
        while (posicion<=tope && !info.toString().equalsIgnoreCase(informacion[posicion].toString())){
            posicion++;
        }
        if (posicion>tope){
            return -1;
        }
        else{
            return posicion;
        }
    }

    @Override
    public Object eliminar(Object info) {
        int posicion=(int) buscar(info);
        if(posicion!=-1){
            return eliminar(posicion);
        }
        return null;
    }

    @Override
    public Object verUltimo() {
        return obtener(cantidad()-1);
    }


    @Override
    public boolean esIgual(Object lista) {
        if (!(lista instanceof ListaEstatica)) return false;
        ListaEstatica listaAComparar=(ListaEstatica) lista;
        if (listaAComparar.tope != this.tope)return false;

        for (int iterador = 0; iterador < tope+1; iterador++) {
            if (!listaAComparar.obtener(iterador).toString().equalsIgnoreCase(obtener(iterador).toString())){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean cambiar(Object infoViejo, Object infoNuevo, int numVeces) {
        int numeroDeOcurrenciasObjetoViejo =this.contar(infoViejo);
        if (numeroDeOcurrenciasObjetoViejo==0)return false;
        if(numVeces>numeroDeOcurrenciasObjetoViejo)numVeces=numeroDeOcurrenciasObjetoViejo;

        for (int iterador = 0; iterador < numVeces; iterador++) {
            int indiceObjetoViejo = (Integer) buscar(infoViejo);
            this.cambiar(indiceObjetoViejo,infoNuevo);
        }

        return true;
    }

    @Override
    public ListaEstatica buscarValores(Object info) {
        ListaEstatica listaARegresar = new ListaEstatica(cantidad());
        for (int iterador = 0; iterador < cantidad(); iterador++) {
            if(obtener(iterador).toString().equalsIgnoreCase(info.toString())){
                listaARegresar.agregar(iterador);
            }
        }
        listaARegresar.redimensionar(listaARegresar.cantidad());
        return listaARegresar;
    }

    @Override
    public Object eliminar() {
        if(vacia())return null;
        Object objetoARegresar = informacion[tope];
        tope--;
        return objetoARegresar;
    }

    @Override
    public void vaciar() {
        if(!vacia()){
            tope=-1;
        }
    }

    @Override
    public boolean agregarLista(Object lista2) {
        if(!(lista2 instanceof ListaEstatica))return false;

        ListaEstatica listaAAgregar=(ListaEstatica) lista2;

        if(listaAAgregar.vacia())return true;

        if ((listaAAgregar.cantidad()+this.cantidad())>this.maximo())this.redimensionar(this.cantidad()+listaAAgregar.cantidad());

        for (int iterador = 0; iterador < listaAAgregar.cantidad(); iterador++) {
            agregar(listaAAgregar.obtener(iterador));
        }
        return true;
    }

    @Override
    public void invertir() {
        if(!vacia() && tope>0){
            int punteroIzquierdo = 0;
            int punteroDerecho = tope;
            Object objetoDeAlmacenTemporal;
            while(punteroIzquierdo<punteroDerecho){
                objetoDeAlmacenTemporal=informacion[punteroDerecho];
                informacion[punteroDerecho]=informacion[punteroIzquierdo];
                informacion[punteroIzquierdo]=objetoDeAlmacenTemporal;

                punteroIzquierdo++;
                punteroDerecho--;
            }
        }
    }

    @Override
    public int contar(Object info) {
        int contador = 0;
        for (int iterador = 0; iterador < cantidad(); iterador++) {
            if (info.toString().equalsIgnoreCase(obtener(iterador).toString())){
                contador++;
            }
        }
        return contador;
    }

    @Override
    public boolean eliminarLista(Object lista2) {
        if (!(lista2 instanceof ListaEstatica))return false;
        for (Object objetoActual: ((ListaEstatica) lista2).informacion) {
            while ((Integer)this.buscar(objetoActual)!=-1){
                eliminar((int) this.buscar(objetoActual));
            }
        }
        return true;
    }

    @Override
    public void rellenar(Object info, int cantidad) {
        if (cantidad>MAXIMO) cantidad=MAXIMO;

        for (int iterador = 0; iterador < cantidad; iterador++) {
            informacion[iterador]=info;
        }
    }

    @Override
    public void rellenar(Object info) {
        rellenar(info,MAXIMO);
    }

    @Override
    public Lista clonar() {
        ListaEstatica listaClonada = new ListaEstatica(this.MAXIMO);
        for (int iterador = 0; iterador < cantidad(); iterador++) {
            listaClonada.agregar(obtener(iterador));
        }
        return listaClonada;
    }

    @Override
    public Lista subLista(int indiceInicial, int indiceFinal) {
        if (indiceInicial>indiceFinal)return null;
        if (indiceFinal>tope || indiceInicial<0)return null;
        int tamanio = (indiceFinal-indiceInicial)+1;
        ListaEstatica sublista =new ListaEstatica(tamanio);

        for (int iterador = 0; iterador < tamanio; iterador++) {
            sublista.agregar(informacion[indiceInicial+iterador]);
        }
        return sublista;
    }

    public ListaEstatica subLista(ListaEstatica listaIndices){
        ListaEstatica listaRespuesta = new ListaEstatica(listaIndices.cantidad());
        for (int indice = 0; indice < listaIndices.cantidad(); indice++) {
            Object objetoTemporal = obtener(objectToInteger(listaIndices.obtener(indice)));
            if(objetoTemporal!=null){
                listaRespuesta.agregar(objetoTemporal);
            }
        }
        return listaRespuesta;
    }

    @Override
    public boolean insertar(int indice, Object info) {
        if(!validarRango(indice))return false;
        if (llena())return false;
        for (int indiceActual = cantidad()-1; indiceActual <= indice; indiceActual++) {
            informacion[indiceActual+1]=informacion[indiceActual];
        }
        tope++;
        informacion[indice]=info;
        return true;
    }

    @Override
    public boolean copiarLista(Lista lista2) {
        if (!(lista2 instanceof ListaEstatica))return false;
        if (((ListaEstatica) lista2).cantidad()!=cantidad())return false;
        for (int indiceActual = 0; indiceActual < cantidad(); indiceActual++) {
            informacion[indiceActual]=((ListaEstatica) lista2).informacion[indiceActual];
        }
        return true;
    }

    /**
     * Metodo que agrega un buffer de datos sobreescribiendo el arreglo actual de la clase.
     * @param buffer Es el nuevo buffer de datos.
     */
    public void agregarBuffer(Object[] buffer){
        informacion = new Object[buffer.length];
        for (int iterador = 0; iterador < buffer.length; iterador++) {
            informacion[iterador]=buffer[iterador];
        }
        tope=buffer.length-1;
        MAXIMO=buffer.length;

    }

    /**
     * Metodo que obtiene una copia del arreglo de la lista actual.
     * @return Regresa una copia del arreglo interno de la clase.
     */
    public Object[] leerArreglo(){
        ListaEstatica clon = (ListaEstatica) clonar();
        clon.redimensionar(clon.cantidad());
        return clon.informacion;
    }

    protected boolean validarRango(int indice){
        if(indice>tope || indice<0)return false;
        return true;
    }
}
