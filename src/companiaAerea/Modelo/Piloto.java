package companiaAerea.Modelo;

public class Piloto {
    private String nombre;
    private String tipoLicencia;

    public Piloto(String nombre, String tipoLicencia) {
        this.nombre = nombre;
        this.tipoLicencia = tipoLicencia;
    }

    public Piloto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoLicencia() {
        return tipoLicencia;
    }

    public void setTipoLicencia(String tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

    @Override
    public String toString() {
        return "Piloto: "+nombre+" Tipo de licencia: "+tipoLicencia;
    }
}
