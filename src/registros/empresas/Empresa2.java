package registros.empresas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaDinamica;
import estructurasLineales.ListaEstatica;

public class Empresa2 {
    protected ListaDinamica empleados;
    protected String nombre;

    public Empresa2(String nombre) {
        this.nombre = nombre;
        this.empleados = new ListaDinamica();
    }

    public boolean agregarEmpleado(Empleado2 empleado){
        Object retornoEmpleado=empleados.buscar(empleado);

        if (retornoEmpleado==null){
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
        empleados.imprimir();
    }

    public void imprimirDatosADetalleEmpresa(){
        SalidaPorDefecto.terminal("Los datos de la empresa "+nombre+" son:\n");
        empleados.inicializarIterador();
        while(empleados.hayNodo()){
            Empleado2 empleadoTemporal=(Empleado2) empleados.obtenerNodo();
            SalidaPorDefecto.terminal(empleadoTemporal.getNombre()+"("+empleadoTemporal.getNumeroEmpleado()+")");
            SalidaPorDefecto.terminal("Sus comisiones son: \n");
            empleadoTemporal.getComisionesAnio().imprimir();
            SalidaPorDefecto.terminal("\n");
        }
    }

    public Double obtenerPromedioEmpleado(Empleado2 empleado){
        Object posicionEmpleado = empleados.buscar(empleado);
        if (posicionEmpleado ==null){
            return null;
        }else{
            return ((Empleado2) posicionEmpleado).obtenerPromedio();
        }
    }

}
