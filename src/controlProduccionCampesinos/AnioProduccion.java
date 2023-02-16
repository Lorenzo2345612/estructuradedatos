package controlProduccionCampesinos;

import estructurasLineales.ListaEstatica;


/**
 * Esta clase se encarga de manejar los meses de produccion en un anio.
 * @author Lorenzo Trujillo Rojas.
 * @version 1.0
 */
public class AnioProduccion {
    private int numeroAnio;
    private ListaEstatica mesesProduccion;

    public AnioProduccion(int numeroAnio, ListaEstatica mesesProduccion) {
        this.numeroAnio = numeroAnio;
        this.mesesProduccion = mesesProduccion;
    }

    /**
     * Obtiene el promedio de la produccion
     * de todos los meses.
     * @return Regresa el promedio de produccion.
     */
    public double obtenerPromedio(){
        double promedio=0.0;
        if (mesesProduccion.vacia())return promedio;
        for (int mes = 0; mes < mesesProduccion.cantidad(); mes++) {
            promedio+=((MesProduccion)mesesProduccion.obtener(mes)).getToneladasProducidas();
        }
        return promedio/mesesProduccion.maximo();
    }

    /**
     * Obtiene la cantidad de meses que estuvieron
     * por encima del promedio anual.
     * @return Regresa la cantidad de meses encima del promedio.
     */
    public int obtenerCantidadMesesSuperioresAlPromedio(){
        int cantidadMeses=0;
        double promedio = obtenerPromedio();
        for (int mes = 0; mes < mesesProduccion.cantidad(); mes++) {
            if (((MesProduccion) mesesProduccion.obtener(mes)).getToneladasProducidas()>promedio){
                cantidadMeses++;
            }
        }
        return cantidadMeses;
    }

    /**
     * Sirve para obtener el mes que menos produccion tuvo.
     * @return regresa un objeto MesProduccion con la informacion del mes.
     */
    public MesProduccion obtenerMesConMenosProduccion(){
        if (mesesProduccion.vacia())return null;
        MesProduccion mesActual=(MesProduccion) mesesProduccion.obtener(0);
        for (int numMes = 1; numMes < mesesProduccion.cantidad(); numMes++) {
            if(mesActual.getToneladasProducidas()>((MesProduccion)mesesProduccion.obtener(numMes)).getToneladasProducidas()){
                mesActual=(MesProduccion)mesesProduccion.obtener(numMes);
            }
        }
        return mesActual;
    }

    /**
     * Obtiene las toneladas que se produjeron en el ultimo mes.
     * @return Regresa la cantidad de toneladas que se produjeron en el ultimo mes.
     */
    public double obtenerToneladasDelUltimoMes(){
        if(mesesProduccion.vacia())return 0;
        return ((MesProduccion) mesesProduccion.obtener(mesesProduccion.cantidad()-1)).getToneladasProducidas();
    }

    /**
     * Obtiene las toneladas que se produjeron en un trimestre dado.
     * @param numeroTrimestre Representa el numero de trimestre
     *                        que se requiere.
     * @return Regresa la cantidad de toneladas en ese trimestre.
     */
    public double obtenerToneladasPorTrimestre(int numeroTrimestre){
        if(numeroTrimestre>4 || numeroTrimestre<=0)return -1;
        int finSublista= (numeroTrimestre*3)-1;
        int inicioSublista= finSublista-2;
        ListaEstatica listaTrimestre=(ListaEstatica) mesesProduccion.subLista(inicioSublista,finSublista);

        double toneladas =0.0;
        for (int numeroMes = 0; numeroMes < listaTrimestre.cantidad(); numeroMes++) {
            toneladas+=((MesProduccion)listaTrimestre.obtener(numeroMes)).getToneladasProducidas();
        }

        return toneladas;
    }

    /**
     * Obtiene las toneladas totales producidas en el año.
     * @return Regresa la cantidad de toneladas producidas.
     */
    public double obtenerToneladasTotales(){
        double toneladasTotales=0;
        for (int numeroMes = 0; numeroMes < mesesProduccion.cantidad(); numeroMes++) {
            toneladasTotales+=((MesProduccion) mesesProduccion.obtener(numeroMes)).getToneladasProducidas();
        }
        return toneladasTotales;
    }

    /**
     * Obtiene un MesProduccion por indice.
     * @param index Representa el indice del mes.
     * @return Regresa el mes que fue solicitado o null si no existe.
     */
    public MesProduccion obtenerMesPorIndice(int index){
        if (index>=mesesProduccion.cantidad() || index<0) return null;

        return ((MesProduccion) mesesProduccion.obtener(index));
    }

    /**
     * Getter del atributo numeroAnio.
     * @return Regresa el numero de anio.
     */
    public int getNumeroAnio() {
        return numeroAnio;
    }
}
