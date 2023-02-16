package registros.empresas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;

public class Empresa {
    protected ListaEstatica empleados;
    protected String nombre;

    public Empresa(String nombre, int cantidadEmpelados) {
        this.nombre = nombre;
        this.empleados = new ListaEstatica(cantidadEmpelados);
    }

    public boolean agregarEmpleado(Empleado empleado){
        int retornoEmpleado=(Integer) empleados.buscar(empleado);

        if (retornoEmpleado==-1){
            int retornoPosicionE=empleados.agregar(empleado);
            if (retornoPosicionE>=0){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public void imprimirDatosEmpresa(){
        SalidaPorDefecto.terminal("Los datos de la empresa "+nombre+" son:\n");
        empleados.imprimirOI();
    }

    public void imprimirDatosADetalleEmpresa(){
        SalidaPorDefecto.terminal("Los datos de la empresa "+nombre+" son:\n");
        for (int indiceEmpleado = 0; indiceEmpleado < empleados.cantidad(); indiceEmpleado++) {
            Empleado empleadoTemporal=(Empleado) empleados.obtener(indiceEmpleado);
            SalidaPorDefecto.terminal(empleadoTemporal.getNombre()+"("+empleadoTemporal.getNumeroEmpleado()+")");
            SalidaPorDefecto.terminal("Sus comisiones son: \n");
            empleadoTemporal.getComisionesAnio().imprimir();
            SalidaPorDefecto.terminal("\n");
        }
    }

    public Double obtenerPromedioEmpleado(Empleado empleado){
        int posicionEmpleado =(int) empleados.buscar(empleado);
        if (posicionEmpleado==-1){
            return null;
        }else{
            Empleado empleadoTemporal=(Empleado) empleados.obtener(posicionEmpleado);
            return empleadoTemporal.obtenerPromedio();
        }
    }

}
