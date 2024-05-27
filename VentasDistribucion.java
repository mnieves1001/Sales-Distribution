import java.util.Arrays;
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

    void agregarProducto(String nombre, double precio, int cantidad) {
        Producto nuevoProducto = new Producto(nombre, precio, cantidad);
        Producto[] nuevoInventario = Arrays.copyOf(inventario, inventario.length + 1);
        nuevoInventario[inventario.length] = nuevoProducto;
        inventario = nuevoInventario;
        System.out.println("Producto agregado con éxito.");
    }

    void actualizarProducto(int indice, double nuevoPrecio, int nuevaCantidad) {
        if (indice >= 0 && indice < inventario.length) {
            inventario[indice].precio = nuevoPrecio;
            inventario[indice].cantidadDisponible = nuevaCantidad;
            System.out.println("Producto actualizado con éxito.");
        } else {
            System.out.println("Índice de producto no válido.");
        }
    }

    void eliminarProducto(int indice) {
        if (indice >= 0 && indice < inventario.length) {
            Producto[] nuevoInventario = new Producto[inventario.length - 1];
            for (int i = 0, j = 0; i < inventario.length; i++) {
                if (i != indice) {
                    nuevoInventario[j++] = inventario[i];
                }
            }
            inventario = nuevoInventario;
            System.out.println("Producto eliminado con éxito.");
        } else {
            System.out.println("Índice de producto no válido.");
        }
    }
}

public class VentasDistribucion {
    public static void main(String[] args) {
        Producto[] productos = {
            new Producto("Poker", 25.99, 20),
            new Producto("Club Colombia", 39.99, 15),
            new Producto("Costeña", 49.99, 10)
        };

        Tienda tienda = new Tienda(productos);
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("1. Mostrar inventario");
            System.out.println("2. Vender producto");
            System.out.println("3. Agregar nuevo producto");
            System.out.println("4. Actualizar producto");
            System.out.println("5. Eliminar producto");
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
                    System.out.print("Ingrese el nombre del nuevo producto: ");
                    String nuevoNombre = scanner.next();
                    System.out.print("Ingrese el precio del nuevo producto: ");
                    double nuevoPrecio = scanner.nextDouble();
                    System.out.print("Ingrese la cantidad disponible del nuevo producto: ");
                    int nuevaCantidad = scanner.nextInt();
                    tienda.agregarProducto(nuevoNombre, nuevoPrecio, nuevaCantidad);
                    break;
                case 4:
                    System.out.print("Ingrese el índice del producto que desea actualizar: ");
                    int indiceActualizar = scanner.nextInt();
                    System.out.print("Ingrese el nuevo precio del producto: ");
                    double nuevoPrecioProd = scanner.nextDouble();
                    System.out.print("Ingrese la nueva cantidad disponible del producto: ");
                    int nuevaCantidadProd = scanner.nextInt();
                    tienda.actualizarProducto(indiceActualizar, nuevoPrecioProd, nuevaCantidadProd);
                    break;
                case 5:
                    System.out.print("Ingrese el índice del producto que desea eliminar: ");
                    int indiceEliminar = scanner.nextInt();
                    tienda.eliminarProducto(indiceEliminar);
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