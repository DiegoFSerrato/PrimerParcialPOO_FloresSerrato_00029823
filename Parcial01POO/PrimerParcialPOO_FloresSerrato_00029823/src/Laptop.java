// Clase Laptop
public class Laptop extends ArticuloElectronico {
    private String procesador;

    // Constructor
    public Laptop(String nombre, String modelo, String descripcion, double precio, String procesador) {
        super(nombre, modelo, descripcion, precio);
        this.procesador = procesador;
    }

    // Getter laptop
    public String getProcesador() {
        return procesador;
    }
}
