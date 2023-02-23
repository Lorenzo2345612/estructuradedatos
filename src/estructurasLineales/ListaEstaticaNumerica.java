package estructurasLineales;


import static utilerias.comunes.ConversorDeDatos.objectToDouble;
import static utilerias.comunes.ConversorDeDatos.objectToInteger;

/**
 * Lista estatica que guarda solo valores numericos.
 * @author Lorenzo Trujillo Rojas.
 * @version 1.0
 */
public class ListaEstaticaNumerica extends ListaEstatica{
    public ListaEstaticaNumerica(int tamanio) {
        super(tamanio);
    }

    @Override
    public int agregar(Object info) {
        if(!(info instanceof Number))return -1;
        return super.agregar(info);
    }

    @Override
    public boolean cambiar(int indice, Object info) {
        if(!(info instanceof Number))return false;
        return super.cambiar(indice, info);
    }

    @Override
    public boolean cambiarListaEstatica(ListaEstatica indicesBusqueda, ListaEstatica infosNuevos) {
        if(!(infosNuevos instanceof ListaEstaticaNumerica))return false;
        return super.cambiarListaEstatica(indicesBusqueda, infosNuevos);
    }

    @Override
    public Object buscar(Object info) {
        if(!(info instanceof Number))return -1;
        return super.buscar(info);
    }

    @Override
    public Object eliminar(Object info) {
        if(!(info instanceof Number))return -1;
        return super.eliminar(info);
    }

    @Override
    public boolean esIgual(Object lista) {
        if(!(lista instanceof ListaEstaticaNumerica))return false;
        return super.esIgual(lista);
    }

    @Override
    public boolean cambiar(Object infoViejo, Object infoNuevo, int numVeces) {
        if(!(infoNuevo instanceof Number) || !(infoViejo instanceof Number))return false;
        return super.cambiar(infoViejo, infoNuevo, numVeces);
    }

    @Override
    public ListaEstatica buscarValores(Object info) {
        if(!(info instanceof Number))return null;
        return super.buscarValores(info);
    }

    @Override
    public boolean agregarLista(Object lista2) {
        if(!(lista2 instanceof ListaEstaticaNumerica))return false;
        return super.agregarLista(lista2);
    }

    @Override
    public int contar(Object info) {
        if(!(info instanceof Number))return 0;
        return super.contar(info);
    }

    @Override
    public boolean eliminarLista(Object lista2) {
        if(!(lista2 instanceof ListaEstaticaNumerica))return false;
        return super.eliminarLista(lista2);
    }

    @Override
    public void rellenar(Object info) {
        if(!(info instanceof Number))return;
        super.rellenar(info);
    }

    @Override
    public void rellenar(Object info, int cantidad) {
        if(!(info instanceof Number))return;
        super.rellenar(info, cantidad);
    }

    @Override
    public boolean insertar(int indice, Object info) {
        if(!(info instanceof Number))return false;
        return super.insertar(indice, info);
    }

    @Override
    public boolean copiarLista(Lista lista2) {
        if(!(lista2 instanceof ListaEstaticaNumerica))return false;
        return super.copiarLista(lista2);
    }

    /**
     * Metodo que multiplica cada elemento de la lista por un escalar.
     * @param escalar El numero por el que se multiplicara.
     * @return Regresa true si se pudo multiplicar o false si no.
     */
    public boolean porEscalar(Number escalar){
        if(vacia())return false;

        for (int indiceNumero = 0; indiceNumero < cantidad(); indiceNumero++) {
            double temporal=((Number)informacion[indiceNumero]).doubleValue();
            informacion[indiceNumero]=temporal*escalar.doubleValue();
        }
        return true;
    }

    /**
     * Metodo que suma cada elemento de la lista con un escalar.
     * @param escalar El numero con el que se sumara.
     * @return Regresa true si se pudo sumar o false si no.
     */
    public boolean sumarEscalar(Number escalar){
        if(vacia())return false;

        for (int indiceNumero = 0; indiceNumero < cantidad(); indiceNumero++) {
            double temporal=((Number)informacion[indiceNumero]).doubleValue();
            informacion[indiceNumero]=temporal+escalar.doubleValue();
        }
        return true;
    }

    /**
     * Metodo que suma el valor de una lista a otra
     * indice por indice.
     * @param lista2 Es la lista que se sumara.
     * @return Regresa true si se pudo sumar o false si no.
     */
    public boolean sumar(ListaEstaticaNumerica lista2){
        if(lista2.cantidad()!=cantidad())return false;
        for (int indiceNumero = 0; indiceNumero < cantidad(); indiceNumero++) {
            informacion[indiceNumero]=objectToDouble(lista2.obtener(indiceNumero))+objectToDouble(obtener(indiceNumero));
        }
        return true;
    }

    /**
     * Metodo que multiplica el valor de una lista en otra
     * indice por indice.
     * @param lista2 Es la lista que se multiplicara.
     * @return Regresa true si se pudo multiplicar o false si no.
     */
    public boolean multiplicar(ListaEstaticaNumerica lista2){
        if(lista2.cantidad()!=cantidad())return false;
        for (int indiceNumero = 0; indiceNumero < cantidad(); indiceNumero++) {
            informacion[indiceNumero]=objectToDouble(lista2.obtener(indiceNumero))*objectToDouble(obtener(indiceNumero));
        }
        return true;
    }

    /**
     * Metodo que eleva cada elemento de la lista a una potencia.
     * @param escalar Es la potencia a utilizar.
     * @return Regresa true si se pudo elevar o false si no.
     */
    public boolean aplicarPotencia(Number escalar){
        if(vacia())return false;

        for (int indiceNumero = 0; indiceNumero < cantidad(); indiceNumero++) {
            double temporal=((Number)informacion[indiceNumero]).doubleValue();
            informacion[indiceNumero]=Math.pow(temporal,escalar.doubleValue());
        }
        return true;
    }

    /**
     * Metodo que eleva cada elemento de la lista a una potencia dada por otra lista.
     * @param lista2 Es la lista a la que se elevara.
     * @return Regresa true si se pudo elevar o false si no.
     */
    public boolean aplicarPotencia(ListaEstaticaNumerica lista2){
        if(lista2.cantidad()!=cantidad())return false;
        for (int indiceNumero = 0; indiceNumero < cantidad(); indiceNumero++) {
            informacion[indiceNumero]=Math.pow(objectToDouble(lista2.obtener(indiceNumero)),objectToDouble(obtener(indiceNumero)));
        }
        return true;
    }

    /**
     * Metodo que calcula el producto escalar de dos listas.
     * @param lista2 Es la lista que se usara como segundo vector.
     * @return Regresa el producto escalar o null en caso de error.
     */
    public Double productoEscalar(ListaEstaticaNumerica lista2){
        if(lista2.cantidad()!=cantidad())return null;
        double resultado=0;
        for (int indiceNumero = 0; indiceNumero < cantidad(); indiceNumero++) {
            resultado+=objectToDouble(lista2.obtener(indiceNumero))*objectToDouble(obtener(indiceNumero));
        }
        return resultado;
    }

    /**
     * Metodo que calcula la norma de la lista.
     * @return Regresa la norma.
     */
    public double norma(){
        if(vacia())return 0;
        double suma=0;
        for (int indice = 0; indice < cantidad(); indice++) {
            suma+=Math.pow(objectToDouble(obtener(indice)),2);
        }
        return Math.sqrt(suma);

    }

    /**
     * Metodo que calcula la norma euclidiana.
     * @param lista2 Es la lista que se usara como segundo vector.
     * @return Regresa la norma euclidiana o null en caso de error.
     */
    public Double normaEuclidiana(ListaEstaticaNumerica lista2){
        if(lista2.cantidad()!=cantidad())return null;
        double suma=0;
        for (int indiceNumero = 0; indiceNumero < cantidad(); indiceNumero++) {
            suma+=Math.pow(objectToDouble(lista2.obtener(indiceNumero))-objectToDouble(obtener(indiceNumero)),2);
        }
        return Math.sqrt(suma);
    }

    /**
     * Metodo que suma un conjunto de listas de numeros.
     * @param listas Lista de arreglos de tipo ListaEstaticaNumerica.
     * @return Regresa la suma de todos los arreglos mas el arreglo actual.
     */
    public double sumarListaEstatica(ListaEstatica listas){
        double resultado = 0;
        for (int indiceListas = 0; indiceListas < listas.cantidad(); indiceListas++) {
            resultado+=((ListaEstaticaNumerica)listas.obtener(indiceListas)).suma();
        }
        resultado+=suma();
        return resultado;
    }

    /**
     * Metodo que obtiene la suma de un conjunto de escalares
     * mas el valor del arreglo actual.
     * @param escalares Conjunto de escalares.
     * @return Regresa la suma.
     */
    public double sumarEscalares(ListaEstaticaNumerica escalares){
        return escalares.suma()+suma();
    }

    /**
     * Metodo que suma los indices de la lista actual
     * contenidos en la listaIndices.
     * @param listaIndices Lista de indices a obtener.
     * @return Resultado de la suma.
     */
    public double sumarIndices(ListaEstaticaNumerica listaIndices){
        double resultado=0;
        for (int indice = 0; indice < listaIndices.cantidad(); indice++) {
            Object objetoTemporal = obtener(objectToInteger(listaIndices.obtener(indice)));
            if(objetoTemporal!=null){
                resultado+=objectToDouble(objetoTemporal);
            }
        }
        return resultado;
    }

    /**
     * Metodo que obtiene una sublista con los indices proporcionados.
     * @param listaIndices Es la lista de indices a obtener.
     * @return Regresa una sublista con los indices proporcionados.
     */
    @Override
    public ListaEstatica subLista(ListaEstatica listaIndices) {
        if(!(listaIndices instanceof ListaEstaticaNumerica))return null;

        return super.subLista(listaIndices);
    }

    /**
     * Metodo que verifica si un conjunto de vectores es linealmente
     * dependientes.
     * @param listaVectores Es el conjunto de vectores que se probaran.
     * @return Regresa true si son dependientes y false si no.
     */
    public boolean sonLinealmenteDependientes(ListaEstatica listaVectores){
        if(suma()==0)return false;
        if(listaVectores.vacia())return false;
        if(listaVectores.cantidad()!=cantidad())return false;
        return probarDependencia(listaVectores);
    }

    /**
     * Metodo que verifica si un conjunto de vectores es linealmente
     * independientes.
     * @param listaVectores Es el conjunto de vectores que se probaran.
     * @return Regresa true si son independientes y false si no.
     */
    public boolean sonLinealmenteIndependientes(ListaEstatica listaVectores){
        if(suma()!=0)return false;
        if(listaVectores.vacia())return false;
        if(listaVectores.cantidad()!=cantidad())return false;
        return probarDependencia(listaVectores);
    }


    /**
     * Metodo auxiliar para verificar dependencia
     * lineal.
     * @param listaVectores Es el conjunto de vectores que se probaran.
     * @return Regresa true si son dependientes y false si no.
     */
    private boolean probarDependencia(ListaEstatica listaVectores){
        for (int numVector = 0; numVector < listaVectores.cantidad(); numVector++) {
            ((ListaEstaticaNumerica)listaVectores.obtener(numVector)).porEscalar(objectToDouble(obtener(numVector)));
        }

        ListaEstaticaNumerica objetoPrueba =(ListaEstaticaNumerica) listaVectores.eliminar();
        objetoPrueba.sumarListaEstatica(listaVectores);

        if(objetoPrueba.suma()==0)return true;
        return false;
    }

    /**
     * Metodo que verifica si el vector actual
     * es ortogonal a lista2.
     * @param lista2 Es el vector con el que compararemos el actual.
     * @return Regresa true si es ortogonal y false si no.
     */
    public boolean esOrtogonal(ListaEstaticaNumerica lista2){
        Object objetoTemporal=productoEscalar(lista2);
        if (objetoTemporal==null)return false;
        if (objectToDouble(objetoTemporal)==0)return true;
        return false;
    }

    /**
     * Metodo que verifica si dos vectores son paralelos.
     * @param lista2 Es el vector con el que se comparara.
     * @return Regresa true si es paralelo y false si no.
     */
    public boolean esParalelo(ListaEstaticaNumerica lista2){
        if(cantidad()!=lista2.cantidad())return false;
        return productoEscalar(lista2)==(norma()*lista2.norma())? true:false;
    }

    /**
     * Metodo auxiliar para obtener la suma de los elementos de
     * la listaEstaticaNumerica
     * @return Regresa la suma del arreglo que lo contiene.
     */
    public double suma() {
        double resultado=0;
        for (int indice = 0; indice < cantidad(); indice++) {
            resultado+=objectToDouble(obtener(indice));
        }
        return resultado;
    }

    @Override
    public void agregarBuffer(Object[] buffer) {

        super.agregarBuffer(buffer);
    }

    /**
     * Metodo auxiliar para obtener la multiplicacion de los elementos de
     * la listaEstaticaNumerica
     * @return Regresa la multiplicacion del arreglo que lo contiene.
     */
    private double multiplicar() {
        double resultado=0;
        for (int indice = 0; indice < cantidad(); indice++) {
            resultado*=objectToDouble(obtener(indice));
        }
        return resultado;
    }


}
