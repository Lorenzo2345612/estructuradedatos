package registros.competenciasatleticas;

public class Corredor {
    protected int numeroCorredor;
    protected String nombreCorredor;
    protected int edadCorredor;
    protected String nacionalidad;

    public Corredor(int numeroCorredor, String nombreCorredor, int edadCorredor, String nacionalidad) {
        this.numeroCorredor = numeroCorredor;
        this.nombreCorredor = nombreCorredor;
        this.edadCorredor = edadCorredor;
        this.nacionalidad = nacionalidad;
    }


    public int getNumeroCorredor() {
        return numeroCorredor;
    }

    public void setNumeroCorredor(int numeroCorredor) {
        this.numeroCorredor = numeroCorredor;
    }

    public String getNombreCorredor() {
        return nombreCorredor;
    }

    public void setNombreCorredor(String nombreCorredor) {
        this.nombreCorredor = nombreCorredor;
    }

    public int getEdadCorredor() {
        return edadCorredor;
    }

    public void setEdadCorredor(int edadCorredor) {
        this.edadCorredor = edadCorredor;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString(){
        return ""+numeroCorredor;
    }
}
