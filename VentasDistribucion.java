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

class Tienda {
    Producto[] inventario;

    Tienda(Producto[] inventario) {
        this.inventario = inventario;
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
            System.out.println("3. Salir");
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
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);

        scanner.close();
    }
}
