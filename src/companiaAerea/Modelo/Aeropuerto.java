package companiaAerea.Modelo;

public class Aeropuerto {

    private String nombre;
    private String ciudad;
    private String pais;

    public Aeropuerto(String ciudad, String pais, String nombre) {
        this.ciudad = ciudad;
        this.pais = pais;
        this.nombre= nombre;
    }

    public Aeropuerto() {
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
