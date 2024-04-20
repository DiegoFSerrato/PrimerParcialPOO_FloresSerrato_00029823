// Sistema Inventario
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaInventario {
    private List<ArticuloElectronico> inventario;

    public SistemaInventario() {
        this.inventario = new ArrayList<>();
    }

    public void agregarArticulo(ArticuloElectronico articulo) {
        inventario.add(articulo);
    }


    public void mostrarListaArticulos() {
        System.out.println("Lista de Artículos Electrónicos:");
        System.out.println("------------------------------------");
        for (int i = 0; i < inventario.size(); i++) {
            ArticuloElectronico articulo = inventario.get(i);
            System.out.println("Registro #" + (i + 1));
            System.out.println("Nombre: " + articulo.getNombre());
            System.out.println("Modelo: " + articulo.getModelo());
            System.out.println("Descripción: " + articulo.getDescripcion());
            System.out.println("Precio: $" + articulo.getPrecio());
            System.out.println("------------------------------------");
        }
    }

    public static void main(String[] args) {
        SistemaInventario sistema = new SistemaInventario();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n----- Menú Principal -----");
            System.out.println("1. Agregar Artículo");
            System.out.println("2. Mostrar Lista de Artículos");
            System.out.println("3. Modificar Modelo de articulo");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del artículo: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el modelo del artículo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Ingrese la descripción del artículo: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Ingrese el precio del artículo: ");
                    double precio = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline character

                    System.out.println("¿Es una laptop o un teléfono móvil? (laptop/movil): ");
                    String tipoArticulo = scanner.nextLine();

                    if (tipoArticulo.equalsIgnoreCase("laptop")) {
                        System.out.print("Ingrese el procesador de la laptop: ");
                        String procesador = scanner.nextLine();
                        Laptop laptop = new Laptop(nombre, modelo, descripcion, precio, procesador);
                        sistema.agregarArticulo(laptop);
                    } else if (tipoArticulo.equalsIgnoreCase("movil")) {
                        System.out.print("Ingrese el sistema operativo del teléfono móvil: ");
                        String sistemaOperativo = scanner.nextLine();
                        TelefonoMovil movil = new TelefonoMovil(nombre, modelo, descripcion, precio, sistemaOperativo);
                        sistema.agregarArticulo(movil);
                    } else {
                        System.out.println("Tipo de artículo no reconocido.");
                    }
                    break;

                case 2:
                    sistema.mostrarListaArticulos();
                    break;

                case 3:
                    System.out.println("Saliendo del sistema...");
                    System.exit(0);
                default:
                    System.out.println("opcion invalida. Intente de nuevo.");
                    break;
            }
        }
    }
}
