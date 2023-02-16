package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import registros.empresas.Empleado;
import registros.empresas.Empresa;

public class PruebaEmpresa {
    public static void main(String[] args) {
        Empresa empresa= new Empresa("Patito", 5);
        ListaEstatica comisiones1= new ListaEstatica(4);
        comisiones1.agregar(300.00);
        comisiones1.agregar(400.00);
        comisiones1.agregar(100.00);
        comisiones1.agregar(1.00);
        Empleado empleado1 = new Empleado(101,"Pedro",30,comisiones1);

        ListaEstatica comisiones2= new ListaEstatica(3);
        comisiones2.agregar(300.00);
        comisiones2.agregar(150.00);
        comisiones2.agregar(1.00);
        Empleado empleado2 = new Empleado(201,"Rosa",31,comisiones2);

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
