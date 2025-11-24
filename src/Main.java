import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        MinHeap<Integer> minHeap = new MinHeap<>();
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1 -> insertar(minHeap);
                case 2 -> eliminar(minHeap);
                case 3 -> peek(minHeap);
                case 4 -> heapify(minHeap);
                case 5 -> mostrar(minHeap);
                case 6 -> limpiar(minHeap);
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }

            System.out.println();

        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("====== MENÚ MIN-HEAP ======");
        System.out.println("1. Insertar");
        System.out.println("2. Eliminar mínimo");
        System.out.println("3. Ver mínimo ");
        System.out.println("4. Construir con lista ");
        System.out.println("5. Mostrar heap");
        System.out.println("6. Vaciar heap");
        System.out.println("0. Salir");
        System.out.println("===========================");
    }

    private static void insertar(MinHeap<Integer> heap) {
        int v = leerEntero("Valor a insertar: ");
        heap.insertar(v);
        System.out.println("Insertado correctamente.");
    }

    private static void eliminar(MinHeap<Integer> heap) {
        if (heap.estaVacio()) {
            System.out.println("Heap vacío.");
            return;
        }
        System.out.println("Eliminado mínimo: " + heap.eliminarMin());
    }

    private static void peek(MinHeap<Integer> heap) {
        if (heap.estaVacio()) {
            System.out.println("Heap vacío.");
        } else {
            System.out.println("Mínimo actual: " + heap.peek());
        }
    }

    private static void heapify(MinHeap<Integer> heap) {
        int cant = leerEntero("Cantidad de elementos: ");

        List<Integer> lista = new ArrayList<>();
        for (int i = 0; i < cant; i++) {
            lista.add(leerEntero("Elemento " + (i + 1) + ": "));
        }

        heap.heapify(lista);
        System.out.println("Heap construido con éxito.");
    }

    private static void mostrar(MinHeap<Integer> heap) {
        System.out.println("Heap -> " + heap.obtenerElementos());
    }

    private static void limpiar(MinHeap<Integer> heap) {
        heap.limpiar();
        System.out.println("Heap vaciado.");
    }

    // Lee un entero controlando errores
    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                int n = scanner.nextInt();
                scanner.nextLine();
                return n;
            } catch (InputMismatchException e) {
                System.out.println("Debe digitar un número entero.");
                scanner.nextLine();
            }
        }
    }
}
