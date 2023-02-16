package registros.empresas;

import estructurasLineales.ListaEstatica;

public class Empleado {
    protected int numeroEmpleado;
    protected String nombre;
    protected int edad;
    protected ListaEstatica comisionesAnio;

    private final int LIMITE_COMISIONES=12;

    public Empleado(int numeroEmpleado, String nombre, int edad, ListaEstatica comisionesAnio) {
        this.numeroEmpleado = numeroEmpleado;
        this.nombre = nombre;
        this.edad = edad;
        this.comisionesAnio = comisionesAnio;
    }

    public Empleado(int numeroEmpleado, String nombre, int edad) {
        this.numeroEmpleado = numeroEmpleado;
        this.nombre = nombre;
        this.edad = edad;
        this.comisionesAnio = new ListaEstatica(this.LIMITE_COMISIONES);
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

    public ListaEstatica getComisionesAnio() {
        return comisionesAnio;
    }

    public void setComisionesAnio(ListaEstatica comisionesAnio) {
        this.comisionesAnio = comisionesAnio;
    }

    public double obtenerPromedio(){
        double promedio =0.0;
        if(comisionesAnio.cantidad()!=0){
            for (int numComision = 0; numComision < comisionesAnio.cantidad(); numComision++) {
                promedio+=(double) comisionesAnio.obtener(numComision);
            }
            promedio/=comisionesAnio.cantidad();
        }
        return promedio;
    }

    @Override
    public String toString() {
        return ""+numeroEmpleado;
    }
}
