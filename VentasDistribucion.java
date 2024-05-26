import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Producto {
    String nombre;
    double precio;
    int cantidadDisponible;

    Producto(String nombre, double precio, int cantidadDisponible) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
    }

    void mostrarDetalles() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Cantidad disponible: " + cantidadDisponible);
    }

    boolean vender(int cantidad) {
        if (cantidad <= cantidadDisponible) {
            cantidadDisponible -= cantidad;
            return true;
        } else {
            System.out.println("No hay suficiente stock disponible.");
            return false;
        }
    }
}

class Cliente {
    String nombre;
    String direccion;
    String telefono;

    Cliente(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    void mostrarDetalles() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Dirección: " + direccion);
        System.out.println("Teléfono: " + telefono);
    }

    void actualizarInformacion(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }
}

class Tienda {
    Producto[] inventario;
    List<Cliente> clientes;

    Tienda(Producto[] inventario) {
        this.inventario = inventario;
        this.clientes = new ArrayList<>();
    }

    void mostrarInventario() {
        System.out.println("Inventario:");
        for (Producto producto : inventario) {
            producto.mostrarDetalles();
            System.out.println("-------------------------");
        }
    }

    void venderProducto(Producto producto, int cantidad) {
        if (producto.vender(cantidad)) {
            System.out.println("Venta realizada con éxito.");
        } else {
            System.out.println("No se pudo completar la venta.");
        }
    }

    // Gestión de clientes
    void mostrarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            System.out.println("Lista de clientes:");
            for (int i = 0; i < clientes.size(); i++) {
                System.out.println("Cliente #" + (i + 1));
                clientes.get(i).mostrarDetalles();
                System.out.println("-------------------------");
            }
        }
    }

    void mostrarDetalleCliente(int indice) {
        if (indice >= 0 && indice < clientes.size()) {
            clientes.get(indice).mostrarDetalles();
        } else {
            System.out.println("Índice de cliente no válido.");
        }
    }

    void registrarCliente(String nombre, String direccion, String telefono) {
        Cliente nuevoCliente = new Cliente(nombre, direccion, telefono);
        clientes.add(nuevoCliente);
        System.out.println("Cliente registrado con éxito.");
    }

    void actualizarCliente(int indice, String nombre, String direccion, String telefono) {
        if (indice >= 0 && indice < clientes.size()) {
            Cliente cliente = clientes.get(indice);
            cliente.actualizarInformacion(nombre, direccion, telefono);
            System.out.println("Información del cliente actualizada con éxito.");
        } else {
            System.out.println("Índice de cliente no válido.");
        }
    }

    void eliminarCliente(int indice) {
        if (indice >= 0 && indice < clientes.size()) {
            clientes.remove(indice);
            System.out.println("Cliente eliminado con éxito.");
        } else {
            System.out.println("Índice de cliente no válido.");
        }
    }
}

public class VentasDistribucion {
    public static void main(String[] args) {
        Producto[] productos = {
            new Producto("Poker", 25.99, 20),      ///cervezas
            new Producto("Club Colombia", 39.99, 15),    ///cervezas
            new Producto("Costeña", 49.99, 10)      ///cervezas
        };

        Tienda tienda = new Tienda(productos);
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("1. Mostrar inventario");
            System.out.println("2. Vender producto");
            System.out.println("3. Mostrar clientes");
            System.out.println("4. Mostrar detalle de un cliente");
            System.out.println("5. Registrar cliente");
            System.out.println("6. Actualizar cliente");
            System.out.println("7. Eliminar cliente");
            System.out.println("8. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    tienda.mostrarInventario();
                    break;
                case 2:
                    System.out.print("Ingrese el índice del producto que desea vender: ");
                    int indiceProducto = scanner.nextInt();
                    System.out.print("Ingrese la cantidad que desea vender: ");
                    int cantidadVenta = scanner.nextInt();
                    if (indiceProducto >= 0 && indiceProducto < productos.length) {
                        tienda.venderProducto(productos[indiceProducto], cantidadVenta);
                    } else {
                        System.out.println("Índice de producto no válido.");
                    }
                    break;
                case 3:
                    tienda.mostrarClientes();
                    break;
                case 4:
                    System.out.print("Ingrese el índice del cliente que desea ver: ");
                    int indiceCliente = scanner.nextInt();
                    tienda.mostrarDetalleCliente(indiceCliente);
                    break;
                case 5:
                    System.out.print("Ingrese el nombre del cliente: ");
                    scanner.nextLine(); // Consumir la nueva línea
                    String nombreCliente = scanner.nextLine();
                    System.out.print("Ingrese la dirección del cliente: ");
                    String direccionCliente = scanner.nextLine();
                    System.out.print("Ingrese el teléfono del cliente: ");
                    String telefonoCliente = scanner.nextLine();
                    tienda.registrarCliente(nombreCliente, direccionCliente, telefonoCliente);
                    break;
                case 6:
                    System.out.print("Ingrese el índice del cliente que desea actualizar: ");
                    indiceCliente = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea
                    System.out.print("Ingrese el nuevo nombre del cliente: ");
                    nombreCliente = scanner.nextLine();
                    System.out.print("Ingrese la nueva dirección del cliente: ");
                    direccionCliente = scanner.nextLine();
                    System.out.print("Ingrese el nuevo teléfono del cliente: ");
                    telefonoCliente = scanner.nextLine();
                    tienda.actualizarCliente(indiceCliente, nombreCliente, direccionCliente, telefonoCliente);
                    break;
                case 7:
                    System.out.print("Ingrese el índice del cliente que desea eliminar: ");
                    indiceCliente = scanner.nextInt();
                    tienda.eliminarCliente(indiceCliente);
                    break;
                case 8:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 8);

        scanner.close();
    }
}
