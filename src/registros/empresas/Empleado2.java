package registros.empresas;

import estructurasLineales.ListaDinamica;
import estructurasLineales.ListaEstatica;

public class Empleado2 {
    protected int numeroEmpleado;
    protected String nombre;
    protected int edad;
    protected ListaDinamica comisionesAnio;

    private final int LIMITE_COMISIONES=12;

    public Empleado2(int numeroEmpleado, String nombre, int edad, ListaDinamica comisionesAnio) {
        this.numeroEmpleado = numeroEmpleado;
        this.nombre = nombre;
        this.edad = edad;
        this.comisionesAnio = comisionesAnio;
    }

    public Empleado2(int numeroEmpleado, String nombre, int edad) {
        this.numeroEmpleado = numeroEmpleado;
        this.nombre = nombre;
        this.edad = edad;
        this.comisionesAnio = new ListaDinamica();
    }

    public boolean agregarComision(double valorComision){
        int retorno = comisionesAnio.agregar(valorComision);
        if (retorno>=0){
            return true;
        }else{
            return false;
        }
    }

    public int getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(int numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ListaDinamica getComisionesAnio() {
        return comisionesAnio;
    }

    public void setComisionesAnio(ListaDinamica comisionesAnio) {
        this.comisionesAnio = comisionesAnio;
    }

    public double obtenerPromedio(){
        double promedio =0.0;
        if(!comisionesAnio.vacia()){
            comisionesAnio.inicializarIterador();
            int contadorComisiones=0;
            while(comisionesAnio.hayNodo()){
                promedio+= (double) comisionesAnio.obtenerNodo();
                contadorComisiones++;
            }
            promedio=promedio/contadorComisiones;
        }
        return promedio;
    }

    @Override
    public String toString() {
        return ""+numeroEmpleado;
    }
}