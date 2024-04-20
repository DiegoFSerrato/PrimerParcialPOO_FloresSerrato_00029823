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

            if (articulo instanceof Laptop) {
                // Es una laptop, mostrar el procesador
                Laptop laptop = (Laptop) articulo;
                System.out.println("Procesador: " + laptop.getProcesador());
            } else if (articulo instanceof TelefonoMovil) {
                // Es un teléfono móvil, mostrar el sistema operativo
                TelefonoMovil movil = (TelefonoMovil) articulo;
                System.out.println("Sistema Operativo: " + movil.getSistemaOperativo());
            }

            System.out.println("------------------------------------");
        }
    }

    public static void main(String[] args) {
        SistemaInventario sistema = new SistemaInventario();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n====| Inventario ElectroMart |====");
            System.out.println("----- Menú Principal -----");
            System.out.println("1. Agregar Artículo");
            System.out.println("2. Mostrar Lista de Artículos");
            System.out.println("3. Modificar Precio de articulo");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

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
                    scanner.nextLine();

                    System.out.println("Seleccione el tipo de artículo:");
                    System.out.println("1. Laptop");
                    System.out.println("2. Teléfono móvil");
                    System.out.print("Ingrese la opción (1 o 2): ");
                    int opcionTipo = scanner.nextInt();
                    scanner.nextLine();

                    if (opcionTipo == 1) {
                        System.out.print("Ingrese el procesador de la laptop: ");
                        String procesador = scanner.nextLine();
                        Laptop laptop = new Laptop(nombre, modelo, descripcion, precio, procesador);
                        sistema.agregarArticulo(laptop);
                    } else if (opcionTipo == 2) {
                        System.out.print("Ingrese el sistema operativo del teléfono móvil: ");
                        String sistemaOperativo = scanner.nextLine();
                        TelefonoMovil movil = new TelefonoMovil(nombre, modelo, descripcion, precio, sistemaOperativo);
                        sistema.agregarArticulo(movil);
                    } else {
                        System.out.println("Opción inválida. Intente de nuevo.");
                    }
                    break;

                case 2:
                    sistema.mostrarListaArticulos();
                    break;
                case 3:
                    System.out.println("Modificar Precio de Artículo");

                    System.out.print("Ingrese el número de registro del artículo que desea modificar: ");
                    int indice = scanner.nextInt();
                    scanner.nextLine();

                    if (indice >= 1 && indice <= sistema.inventario.size()) {
                        System.out.print("Ingrese el nuevo precio: ");
                        double nuevoPrecio = scanner.nextDouble();
                        scanner.nextLine();

                        // Actualizar el precio del artículo seleccionado
                        ArticuloElectronico articuloModificar = sistema.inventario.get(indice - 1);
                        articuloModificar.setPrecio(nuevoPrecio);

                        System.out.println("Precio modificado correctamente.");
                    } else {
                        System.out.println("Número de registro inválido. Intente de nuevo.");
                    }
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    System.exit(0);
                default:
                    System.out.println("opcion invalida. Intente de nuevo.");
                    break;
            }
        }
    }
} 
