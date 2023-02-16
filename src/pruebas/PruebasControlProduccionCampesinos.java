package pruebas;

import controlProduccionCampesinos.AnioProduccion;
import controlProduccionCampesinos.Campesino;
import controlProduccionCampesinos.Controlador;
import controlProduccionCampesinos.MesProduccion;
import estructurasLineales.ListaEstatica;

public class PruebasControlProduccionCampesinos {
    public PruebasControlProduccionCampesinos(){
        Campesino campesino1 = new Campesino(crearAnios(),"Juan");
        Campesino campesino2 = new Campesino(crearAnios(),"Juana");

        ListaEstatica campesinos= new ListaEstatica(2);
        campesinos.agregar(campesino1);
        campesinos.agregar(campesino2);

        Controlador controlador = new Controlador(campesinos);

        controlador.opcionObtenerPromedioAnualPorCampesino();

        controlador.opcionCantidadDeMesesSuperioresAlPromedio(0);
        controlador.opcionCantidadDeMesesSuperioresAlPromedio(1);

        controlador.opcionObtenerMesConMenorProduccionPorCampesino(0);
        controlador.opcionObtenerMesConMenorProduccionPorCampesino(1);

        controlador.opcionObtenerProduccionUltimoMesPorCampesino(0);
        controlador.opcionObtenerProduccionUltimoMesPorCampesino(1);

        controlador.opcionObtenerProduccionPorTrimestre(2,0);
        controlador.opcionObtenerProduccionPorTrimestre(2,1);

        controlador.opcionCampesinoQuePeorRealizoSuTrabajo();

        controlador.opcionMesDeMayorProduccion();

        controlador.opcionEstacionConMayorProduccion();
    }

    private ListaEstatica crearMeses(){
        ListaEstatica meses = new ListaEstatica(12);
        meses.agregar(new MesProduccion("Enero",Math.random()*10,"Invierno"));
        meses.agregar(new MesProduccion("Febrero",Math.random()*10,"Invierno"));
        meses.agregar(new MesProduccion("Marzo",Math.random()*10,"Primavera"));
        meses.agregar(new MesProduccion("Abril",Math.random()*10,"Primavera"));
        meses.agregar(new MesProduccion("Mayo",Math.random()*10,"Primavera"));
        meses.agregar(new MesProduccion("Junio",Math.random()*10,"Verano"));
        meses.agregar(new MesProduccion("Julio",Math.random()*10,"Verano"));
        meses.agregar(new MesProduccion("Agosto",Math.random()*10,"Verano"));
        meses.agregar(new MesProduccion("Septiembre",Math.random()*10,"Otonio"));
        meses.agregar(new MesProduccion("Octubre",Math.random()*10,"Otonio"));
        meses.agregar(new MesProduccion("Noviembre",Math.random()*10,"Otonio"));
        meses.agregar(new MesProduccion("Diciembre",Math.random()*10,"Invierno"));
        return meses;
    }

    private ListaEstatica crearAnios(){
        ListaEstatica anios = new ListaEstatica(4);
        anios.agregar(new AnioProduccion(2019,crearMeses()));
        anios.agregar(new AnioProduccion(2020,crearMeses()));
        anios.agregar(new AnioProduccion(2021,crearMeses()));
        anios.agregar(new AnioProduccion(2022,crearMeses()));

        return anios;
    }
}
