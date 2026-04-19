package clase08.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Esta clase es la solución al ejercicio propuesto para la clase 8.
 * 
 * @author Cesar Díaz
 */
public class InventoryCalculator {

    public static void main(String[] args) {
        start();
    }

    /**
     * Inicia la ejecución de la aplicación.
     */
    public static void start() {
        var products = new ArrayList<Map<String, Object>>();

        var scanner = new Scanner(System.in);
        var exit = false;

        while (!exit) {
            System.out.println("""
                    ####################################################
                    # Menu Principal:
                    ####################################################
                    1. Ingresar producto
                    2. Mostrar productos
                    3. Buscar producto
                    4. Actualizar producto
                    5. Calcular valor total del inventario
                    6. Mostrar producto más caro y más barato
                    0. Salir
                    """);

            System.out.print("Seleccione una opción: ");
            var option = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (option) {
                case 0 -> exit = true;
                case 1 -> addProduct(products, scanner);
                case 2 -> showProducts(products);
                case 3 -> consultProduct(products, scanner);
                case 4 -> updateProduct(products, scanner);
                case 5 -> getTotalValue(products);
                case 6 -> showMoreExpensiveAndCheaperProduct(products);
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        System.out.println("Hasta luego!");

        scanner.close();
    }

    private static void addProduct(List<Map<String, Object>> products, Scanner scanner) {
        var product = new HashMap<String, Object>();
        System.out.print("Ingrese el nombre del producto: ");
        product.put("name", scanner.nextLine());

        System.out.print("Ingrese la cantidad del producto: ");
        product.put("quantity", scanner.nextInt());

        System.out.print("Ingrese el precio del producto: ");
        product.put("price", scanner.nextDouble());

        products.add(product);
    }

    private static String getProductInfo(Map<String, Object> product) {
        return String.format("Nombre: %c , Cantidad: %d, Precio: %f",
                product.get("name"),
                (int) product.get("quantity"),
                (double) product.get("price"));
    }

    private static void showProducts(List<Map<String, Object>> products) {
        System.out.println("Productos en inventario:");
        for (var product : products) {
            System.out.println(getProductInfo(product));
        }
    }

    private static void consultProduct(List<Map<String, Object>> products, Scanner scanner) {
        System.out.print("Ingrese el nombre del producto a buscar: ");
        var searchName = scanner.nextLine();

        /*
        var found = false;
        for (var product : products) {
            if (product.get("name").toString().equalsIgnoreCase(searchName)) {
                System.out.println(getProductInfo(product));
                found = true;
                break;
            }
        }
        if (!found) {
            System.err.println("Producto no encontrado.");
        }
        */

        products.stream()
                .filter(p -> p.get("name").toString().equalsIgnoreCase(searchName))
                .findFirst()
                .map(InventoryCalculator::getProductInfo)
                .ifPresentOrElse(System.out::println,
                        () -> System.err.println("Producto no encontrado."));
    }

    private static void updateProduct(List<Map<String, Object>> products, Scanner scanner) {
        System.out.print("Ingrese el nombre del producto a actualizar: ");
        var updateName = scanner.nextLine();

        /*
        Map<String, Object> productToUpdate = null;
        for (var product : products) {
            if (product.get("name").toString().equalsIgnoreCase(updateName)) {
                productToUpdate = product;
                found = true;
                break;
            }
        }
        if (productToUpdate != null) {
            System.out.print("Ingrese la nueva cantidad: ");
            productToUpdate.put("quantity", scanner.nextInt());

            System.out.print("Ingrese el nuevo precio: ");
            productToUpdate.put("price", scanner.nextDouble());

            System.out.println("Producto actualizado.");
        } else {
            System.err.println("Producto no encontrado.");
        }
        */

        products.stream()
                .filter(p -> p.get("name").toString().equalsIgnoreCase(updateName))
                .findFirst()
                .ifPresentOrElse(p -> {
                    System.out.print("Ingrese la nueva cantidad: ");
                    p.put("quantity", scanner.nextInt());

                    System.out.print("Ingrese el nuevo precio: ");
                    p.put("price", scanner.nextDouble());

                    System.out.println("Producto actualizado.");
                }, () -> System.err.println("Producto no encontrado."));
    }

    private static void getTotalValue(List<Map<String, Object>> products) {
        var totalValue = products.stream()
                .mapToDouble(p -> (int) p.get("quantity") * (double) p.get("price"))
                .sum();
        System.out.println("Valor total del inventario: " + totalValue);
    }

    private static void showMoreExpensiveAndCheaperProduct(List<Map<String, Object>> products) {
        if (!products.isEmpty()) {
            var maxProduct = products.stream()
                    .max(Comparator.comparing(p -> (double) p.get("price")))
                    .orElseThrow();
            System.out.printf("Producto más caro: Nombre: %s, Precio: %d%n",
                    maxProduct.get("name"),
                    (double) maxProduct.get("price"));

            var minProduct = products.stream()
                    .min(Comparator.comparing(p -> (double) p.get("price")))
                    .orElseThrow();
            System.out.printf("Producto más barato: Nombre: %s, Precio: %d%n",
                    minProduct.get("name"),
                    (double) minProduct.get("price"));
        } else {
            System.out.println("No hay productos en el inventario.");
        }
    }

}
