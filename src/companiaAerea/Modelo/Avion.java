package companiaAerea.Modelo;

public class Avion {
    private String tipo;
    private String matricula;
    private String fabricante;
    private String modelo;
    private int capacidad;
    private int autonomia;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }

    public Avion() {
    }

    public Avion(String tipo,
                 String matricula,
                 String fabricante,
                 String modelo,
                 int capacidad,
                 int autonomia) {
        this.tipo = tipo;
        this.matricula = matricula;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.autonomia = autonomia;
    }

    @Override
    public String toString() {
        return "Avion modelo: "+modelo+" tipo: "+tipo+" matricula: "+matricula;
    }
}
