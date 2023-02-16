package controlProduccionCampesinos;

import entradasalida.EntradaPorDefecto;
import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;


/**
 * Clase encargada de manejar los eventos de administracion y vista del sistema
 * @author Lorenzo Trujillo Rojas
 * @version 1.0
 */
public class Controlador{
    private ListaEstatica campesinos;
    private final String PRIMAVERA = "Primavera";
    private final String INVIERNO = "Invierno";
    private final String VERANO = "Verano";
    private final String OTONIO = "Otonio";

    private ListaEstatica meses = new ListaEstatica(12);

    /**
     * Constructor que recibe una lista de campesinos.
     * @param campesinos Lista de campesinos que sera procesada.
     */
    public Controlador(ListaEstatica campesinos) {
        this.campesinos = campesinos;
        llenaListaDeLosMeses();
    }

    /**
     * Constructor que no recibe parametros, se basa en obtener los datos mediante teclado.
     */
    public Controlador() {
        llenaListaDeLosMeses();
        menuIngresarDatos();

        menu();
    }

    /**
     * Metodo de apoyo que crea una ListaEstatica con los meses del anio.
     */
    private void llenaListaDeLosMeses(){
        meses.agregar("Enero");
        meses.agregar("Febrero");
        meses.agregar("Marzo");
        meses.agregar("Abril");
        meses.agregar("Mayo");
        meses.agregar("Junio");
        meses.agregar("Julio");
        meses.agregar("Agosto");
        meses.agregar("Septiembre");
        meses.agregar("Octubre");
        meses.agregar("Noviembre");
        meses.agregar("Diciembre");
    }

    /**
     * Metodo que gestiona la peticion de los datos de campesinos,
     * por lo pronto solo dos.
     */
    public void menuIngresarDatos(){
        ListaEstatica campesinosAProbar = new ListaEstatica(2);

        campesinosAProbar.agregar(pedirDatosCampesino());
        campesinosAProbar.agregar(pedirDatosCampesino());

        campesinos=campesinosAProbar;
    }

    /**
     * Imprime el menu con las opciones del sistema.
     */
    private void imprimirMenuOpciones(){
        SalidaPorDefecto.terminal("Ingresa la opcion:");
        SalidaPorDefecto.terminal("1.- Ver Promedio anual\n");
        SalidaPorDefecto.terminal("2.- Ver meses que superaron el promedio anual\n");
        SalidaPorDefecto.terminal("3.- Ver mes con menos toneladas\n");
        SalidaPorDefecto.terminal("4.- Ver toneladas del ultimo mes\n");
        SalidaPorDefecto.terminal("5.- Ver produccion del trimestre 2.\n");
        SalidaPorDefecto.terminal("6.- Ver campesino con peor desempanio\n");
        SalidaPorDefecto.terminal("7.- Ver mes que produce mayores ganancias.\n");
        SalidaPorDefecto.terminal("8.- Ver epoca del anio mas productiva.\n");
        SalidaPorDefecto.terminal("9.- Salir");

    }

    /**
     * Pide los datos de un Campesino al usuario.
     * @return Regresa la informacion de un Campesino.
     */
    private Campesino pedirDatosCampesino(){
        ListaEstatica aniosCampesino= new ListaEstatica(4);
        SalidaPorDefecto.terminal("Ingresa el nombre del campesino: \n");

        int numeroAnio = 2019;

        String nombreCampesino=EntradaPorDefecto.consolaCadenas();
        for (int numAnio = 0; numAnio < 4; numAnio++) {
            aniosCampesino.agregar(pedirDatosAnio(numeroAnio+numAnio));

        }
        return new Campesino(aniosCampesino,nombreCampesino);
    }

    /**
     * Metodo que recopila los datos de un anio de produccion.
     * @param numeroAnio El numero del anio (p. ej. 2022).
     * @return Regresa la informacion de un anio de produccion.
     */
    private AnioProduccion pedirDatosAnio(int numeroAnio){
        ListaEstatica mesesAnio = new ListaEstatica(12);

        for (int numMes = 0; numMes < 12; numMes++) {
            String nombreMesTemporal = (String) meses.obtener(numMes);
            String estacionMesTemporal="";
            if(numMes<2 || numMes==11){
                estacionMesTemporal=INVIERNO;
            } else if (numMes<5) {
                estacionMesTemporal=PRIMAVERA;
            } else if (numMes<8) {
                estacionMesTemporal=VERANO;
            }else {
                estacionMesTemporal=OTONIO;
            }
            mesesAnio.agregar(new MesProduccion(nombreMesTemporal,obtenerToneladasDelMesPorTeclado(nombreMesTemporal,numeroAnio),estacionMesTemporal));
        }

        return new AnioProduccion(numeroAnio,mesesAnio);
    }

    /**
     * Obtiene por parte del usuario la cantidad de toneladas producidas en un
     * mes.
     * @param nombreMes Nombre del mes del que se solicita la cantidad de toneladas.
     * @param numeroAnio El numero del anio (p. ej. 2022).
     * @return Regresa la cantidad de toneladas producidas en ese mes.
     */
    private double obtenerToneladasDelMesPorTeclado(String nombreMes, int numeroAnio){
        SalidaPorDefecto.terminal("Ingresa la cantidad de toneladas para "+nombreMes+" del "+numeroAnio+": \n");
        return EntradaPorDefecto.consolaDouble();
    }


    /**
     * Funcion que controla el menu.
     */
    private void menu(){
        boolean bandera=true;
        while (bandera){
            imprimirMenuOpciones();
            int opcion = Integer.parseInt(EntradaPorDefecto.consolaCadenas());
            int indiceTemporal=0;
            switch (opcion){
                case 1: opcionObtenerPromedioAnualPorCampesino();
                    break;
                case 2:
                     indiceTemporal= pedirNumeroCampesino();
                    if(validarIndice(indiceTemporal,2,0)){
                        opcionCantidadDeMesesSuperioresAlPromedio(indiceTemporal);
                    }
                    break;
                case 3: indiceTemporal = pedirNumeroCampesino();
                    if(validarIndice(indiceTemporal,2,0)){
                        opcionObtenerMesConMenorProduccionPorCampesino(indiceTemporal);
                    }
                    break;
                case 4: indiceTemporal = pedirNumeroCampesino();
                    if(validarIndice(indiceTemporal,2,0)){
                        opcionObtenerProduccionUltimoMesPorCampesino(indiceTemporal);
                    }
                    break;
                case 5: indiceTemporal = pedirNumeroCampesino();
                    if(validarIndice(indiceTemporal,2,0)){
                        opcionObtenerProduccionPorTrimestre(2,indiceTemporal);
                    }
                    break;
                case 6: opcionCampesinoQuePeorRealizoSuTrabajo();
                    break;
                case 7: opcionMesDeMayorProduccion();
                    break;
                case 8: opcionEstacionConMayorProduccion();
                    break;
                case 9: bandera=false;
                    break;
            }
        }
    }

    /**
     * Pide al usuario el numero del campesino que requiere.
     * @return Regresa el numero ingresado por el usuario.
     */
    private int pedirNumeroCampesino(){
        SalidaPorDefecto.terminal("Ingresa el numero del campesino.");
        return Integer.parseInt(EntradaPorDefecto.consolaCadenas())-1;
    }

    /**
     * Funcion que imprime el promedio de toneladas que produjeron los campesinos.
     */
    public void opcionObtenerPromedioAnualPorCampesino(){
        SalidaPorDefecto.terminal("Promedio anual de toneladas por Campesino: \n");
        for (int numeroCampesino = 0; numeroCampesino < campesinos.cantidad(); numeroCampesino++) {
            Campesino campesinoTemporal = (Campesino) campesinos.obtener(numeroCampesino);
            campesinoTemporal.imprimirPromedioAnualDeToneladas();
        }
    }

    /**
     * Funcion que indica la cantidad de meses que superaron el promedio anual
     * de produccion.
     * @param indice Indica el indice del campesino a tratar.
     */
    public void opcionCantidadDeMesesSuperioresAlPromedio(int indice){
        if(validarIndice(indice,campesinos.cantidad(),0)){
            ((Campesino) campesinos.obtener(indice)).imprimirCantidadMesesMayoresAlPromedio();
        }else{
            SalidaPorDefecto.terminal("El indice indicado no es correcto");
        }

    }

    /**
     * Funcion que indica el mes que tuvo la menor produccion en el anio.
     * @param indice Indica el indice del campesino a tratar.
     */
    public void opcionObtenerMesConMenorProduccionPorCampesino(int indice){
        if (validarIndice(indice,campesinos.cantidad(),0)){
            ((Campesino) campesinos.obtener(indice)).imprimirMesConMenosProduccionPorAnio();
        }else {
            SalidaPorDefecto.terminal("El indice indicado no es correcto");
        }
    }

    /**
     * Funcion que obtiene la cantidad de toneladas que produjo
     * un campesino en el ultimo mes.
     * @param indice Indica el indice del campesino a tratar.
     */
    public void opcionObtenerProduccionUltimoMesPorCampesino(int indice){
        if (validarIndice(indice,campesinos.cantidad(),0)){
            ((Campesino) campesinos.obtener(indice)).imprimirProduccionDelUltimoMesPorAnio();
        }else {
            SalidaPorDefecto.terminal("El indice indicado no es correcto");
        }
    }

    /**
     * Funcion que indica la produccion de un trimestre.
     * @param indiceTrimestre Indica el indice del trimestre a tratar.
     * @param indiceCampesino Indica el indice del campesino a tratar.
     */
    public void opcionObtenerProduccionPorTrimestre(int indiceTrimestre, int indiceCampesino){
        if (validarIndice(indiceTrimestre,5,1) && validarIndice(indiceCampesino,2,0)){
            SalidaPorDefecto.terminal("La produccion del campesino "+((Campesino) campesinos.obtener(indiceCampesino)).getNombre()+" en el trimestre "+indiceTrimestre+"\nfue de:\n");
            ((Campesino) campesinos.obtener(indiceCampesino)).imprimirToneladasPorTrimestre(indiceTrimestre);
        }else {
            SalidaPorDefecto.terminal("El indice indicado no es correcto");
        }
    }


    /**
     * Funcion que indica el campesino que peor realizo su
     * trabajo por anio.
     */
    public void opcionCampesinoQuePeorRealizoSuTrabajo(){
        SalidaPorDefecto.terminal("Campesino que peor realizo su trabajo:\n");
        for (int anio = 0; anio < 4; anio++) {
            SalidaPorDefecto.terminal("Año: "+((Campesino) campesinos.obtener(0)).obtenerAnioProduccion(anio).getNumeroAnio());
            double produccionCampesinoUno = ((Campesino) campesinos.obtener(0)).obtenerAnioProduccion(anio).obtenerToneladasTotales();
            double produccionCampesinoDos = ((Campesino) campesinos.obtener(1)).obtenerAnioProduccion(anio).obtenerToneladasTotales();

            if(produccionCampesinoDos>produccionCampesinoUno){
                SalidaPorDefecto.terminal(" El campesino "+((Campesino) campesinos.obtener(0)).getNombre()+" tuvo menor desempeño.\n");
            } else if (produccionCampesinoDos<produccionCampesinoUno) {
                SalidaPorDefecto.terminal(" El campesino "+((Campesino) campesinos.obtener(1)).getNombre()+" tuvo menor desempeño.\n");
            }else{
                SalidaPorDefecto.terminal(" Ambos campesinos tuvieron el mismo desempeño.\n");
            }
        }
    }

    /**
     * Esta funcion calcula el promedio entre todos los anios de ambos campesinos
     * en un mes en especifico e indica cual fue el mes mas productivo.
     */
    public void opcionMesDeMayorProduccion(){
        SalidaPorDefecto.terminal("Mes de mayor produccion: ");
        String mesRespuesta="";
        double maximoToneladas=0;

        Campesino campesinoUno = (Campesino) campesinos.obtener(0);
        Campesino campesinoDos = (Campesino) campesinos.obtener(1);

        for (int numMes = 0; numMes < 12; numMes++) {
            double produccionTemporal =0;
            for (int numAnio = 0; numAnio < 4; numAnio++) {
                produccionTemporal+=campesinoUno.obtenerAnioProduccion(numAnio).obtenerMesPorIndice(numMes).getToneladasProducidas();
                produccionTemporal+=campesinoDos.obtenerAnioProduccion(numAnio).obtenerMesPorIndice(numMes).getToneladasProducidas();
            }
            if(produccionTemporal>maximoToneladas){
                maximoToneladas=produccionTemporal;
                mesRespuesta=campesinoUno.obtenerAnioProduccion(0).obtenerMesPorIndice(numMes).getNombre();
            }
        }
        SalidaPorDefecto.terminal(mesRespuesta+"\n");
    }

    /**
     * Funcion que indica que estacion fue la mas productiva del anio.
     */
    public void opcionEstacionConMayorProduccion(){
        double toneladasAcumuladasPrimavera = 0;
        double toneladasAcumuladasInvierno =0;
        double toneladasAcumuladasVerano =0;
        double toneladasAcumuladasOtonio =0;

        Campesino campesinoUno = (Campesino) campesinos.obtener(0);
        Campesino campesinoDos = (Campesino) campesinos.obtener(1);

        for (int numMes = 0; numMes < 12; numMes++) {
            for (int numAnio = 0; numAnio < 4; numAnio++) {
                String estacionTemporal=campesinoUno.obtenerAnioProduccion(0).obtenerMesPorIndice(numMes).getEstacionAnio();
                switch (estacionTemporal){
                    case PRIMAVERA:     toneladasAcumuladasPrimavera+=campesinoUno.obtenerAnioProduccion(numAnio).obtenerMesPorIndice(numMes).getToneladasProducidas();
                                        toneladasAcumuladasPrimavera+=campesinoDos.obtenerAnioProduccion(numAnio).obtenerMesPorIndice(numMes).getToneladasProducidas();
                                        break;
                    case INVIERNO:      toneladasAcumuladasInvierno+=campesinoUno.obtenerAnioProduccion(numAnio).obtenerMesPorIndice(numMes).getToneladasProducidas();
                                        toneladasAcumuladasInvierno+=campesinoDos.obtenerAnioProduccion(numAnio).obtenerMesPorIndice(numMes).getToneladasProducidas();
                                        break;
                    case VERANO:        toneladasAcumuladasVerano+=campesinoUno.obtenerAnioProduccion(numAnio).obtenerMesPorIndice(numMes).getToneladasProducidas();
                                        toneladasAcumuladasVerano+=campesinoDos.obtenerAnioProduccion(numAnio).obtenerMesPorIndice(numMes).getToneladasProducidas();
                                        break;
                    case OTONIO:        toneladasAcumuladasOtonio+=campesinoUno.obtenerAnioProduccion(numAnio).obtenerMesPorIndice(numMes).getToneladasProducidas();
                                        toneladasAcumuladasOtonio+=campesinoDos.obtenerAnioProduccion(numAnio).obtenerMesPorIndice(numMes).getToneladasProducidas();
                                        break;
                }
            }
        }

        SalidaPorDefecto.terminal("La estacion con mayor produccion es: "+ obtenerEstacionConMayorCantidadDeToneladas(toneladasAcumuladasPrimavera,toneladasAcumuladasOtonio,toneladasAcumuladasInvierno,toneladasAcumuladasVerano));

    }

    /**
     * Funcion auxiliar que obtiene el nombre de la estacion con
     * mayor cantidad de toneladas producidas.
     * @param tonPrimavera Cantidad de toneladas producidas en primavera.
     * @param tonOtonio Cantidad de toneladas producidas en otonio.
     * @param tonInvierno Cantidad de toneladas producidas en invierno.
     * @param tonVerano Cantidad de toneladas producidas en verano.
     * @return Regresa el nombre de la estacion que produjo una mayor cantidad de toneladas.
     */
    private String obtenerEstacionConMayorCantidadDeToneladas(double tonPrimavera, double tonOtonio, double tonInvierno, double tonVerano) {
        double maximoActual=0;
        String respuesta="";

        if (maximoActual<tonPrimavera){
            maximoActual=tonPrimavera;
            respuesta=PRIMAVERA;
        }

        if (maximoActual<tonOtonio){
            maximoActual=tonOtonio;
            respuesta=OTONIO;
        }

        if (maximoActual<tonVerano){
            maximoActual=tonVerano;
            respuesta=VERANO;
        }

        if (maximoActual<tonInvierno){
            respuesta=INVIERNO;
        }

        return respuesta;
    }

    /**
     * Funcion auxiliar que valida si un indice es valido.
     * @param indice Representa el indice a tratar.
     * @param maximo Indica el maximo numero que puede tener el indice.
     * @param minimo Indica el minimo numero que puede tener el indice.
     * @return Regresa true si el indice es valido o false en caso contrario.
     */
    private boolean validarIndice(int indice,int maximo, int minimo){
        if(indice<minimo || indice>=maximo)return false;
        return true;
    }
}
