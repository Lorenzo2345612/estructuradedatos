package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaDinamica;
import estructurasLineales.ListaEstatica;
import registros.empresas.Empleado;
import registros.empresas.Empleado2;
import registros.empresas.Empresa;
import registros.empresas.Empresa2;

/**
 *
 **/
public class PruebaEmpresa2 {
    public static void main(String[] args) {
        Empresa2 empresa= new Empresa2("Patito");
        ListaDinamica comisiones1= new ListaDinamica();
        comisiones1.agregar(300.00);
        comisiones1.agregar(400.00);
        comisiones1.agregar(100.00);
        comisiones1.agregar(1.00);
        Empleado2 empleado1 = new Empleado2(101,"Pedro",30, comisiones1);

        ListaDinamica comisiones2= new ListaDinamica();
        comisiones2.agregar(300.00);
        comisiones2.agregar(150.00);
        comisiones2.agregar(1.00);
        Empleado2 empleado2 = new Empleado2(201,"Rosa",31,comisiones2);

        empresa.agregarEmpleado(empleado1);
        empresa.agregarEmpleado(empleado2);

        empresa.imprimirDatosEmpresa();
        SalidaPorDefecto.terminal("\n");
        empresa.imprimirDatosADetalleEmpresa();


        SalidaPorDefecto.terminal("El promedio de comisiones de Pedro es: "+
                empresa.obtenerPromedioEmpleado(empleado1));

        SalidaPorDefecto.terminal("El promedio de comisiones de Rosa es: "+
                empresa.obtenerPromedioEmpleado(empleado2));
    }
}
