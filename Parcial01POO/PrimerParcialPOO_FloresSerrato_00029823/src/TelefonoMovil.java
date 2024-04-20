// Clase TelefonoMovil
public class TelefonoMovil extends ArticuloElectronico {
    private String sistemaOperativo;

    // Constructor
    public TelefonoMovil(String nombre, String modelo, String descripcion, double precio, String sistemaOperativo) {
        super(nombre, modelo, descripcion, precio);
        this.sistemaOperativo = sistemaOperativo;
    }

    // Getter Telefono
    public String getSistemaOperativo() {
        return sistemaOperativo;
    }
}
