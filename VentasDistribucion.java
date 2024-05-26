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

class Venta {
    Producto producto;
    int cantidad;
    double total;

    Venta(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.total = producto.precio * cantidad;
    }

    void mostrarDetalles() {
        System.out.println("Producto: " + producto.nombre);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Total: $" + total);
    }
}

class Tienda {
    Producto[] inventario;
    List<Venta> ventas;

    Tienda(Producto[] inventario) {
        this.inventario = inventario;
        this.ventas = new ArrayList<>();
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
            Venta venta = new Venta(producto, cantidad);
            ventas.add(venta);
            System.out.println("Venta realizada con éxito.");
        } else {
            System.out.println("No se pudo completar la venta.");
        }
    }

    void mostrarVentas() {
        if (ventas.isEmpty()) {
            System.out.println("No se han realizado ventas. ");
        } else {
            System.out.println("Ventas realizadas:");
            for (int i = 0; i < ventas.size(); i++) {
                System.out.println("Venta #" + (i + 1));
                ventas.get(i).mostrarDetalles();
                System.out.println("-------------------------");
            }
        }
    }

    void mostrarDetalleVenta(int indice) {
        if (indice >= 0 && indice < ventas.size()) {
            ventas.get(indice).mostrarDetalles();
        } else {
            System.out.println("Índice de venta no válido.");
        }
    }

    void cancelarVenta(int indice) {
        if (indice >= 0 && indice < ventas.size()) {
            Venta venta = ventas.get(indice);
            venta.producto.cantidadDisponible += venta.cantidad;
            ventas.remove(indice);
            System.out.println("Venta cancelada con éxito.");
        } else {
            System.out.println("Índice de venta no válido.");
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
            System.out.println("3. Mostrar ventas realizadas");
            System.out.println("4. Mostrar detalle de una venta");
            System.out.println("5. Cancelar una venta");
            System.out.println("6. Salir");
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
                    tienda.mostrarVentas();
                    break;
                case 4:
                    System.out.print("Ingrese el índice de la venta que desea ver: ");
                    int indiceVenta = scanner.nextInt();
                    tienda.mostrarDetalleVenta(indiceVenta);
                    break;
                case 5:
                    System.out.print("Ingrese el índice de la venta que desea cancelar: ");
                    indiceVenta = scanner.nextInt();
                    tienda.cancelarVenta(indiceVenta);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);

        scanner.close();
    }
}
