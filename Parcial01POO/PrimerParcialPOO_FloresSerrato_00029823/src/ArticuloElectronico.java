// Clase abstracta ArticuloElectronico
public abstract class ArticuloElectronico implements ProductoElectronico {
    private String nombre;
    private String modelo;
    private String descripcion;
    private double precio;

    // Constructor
    public ArticuloElectronico(String nombre, String modelo, String descripcion, double precio) {
        this.nombre = nombre;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }
}
