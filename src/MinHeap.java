import java.util.ArrayList;
import java.util.List;

public class MinHeap<T extends Comparable<T>> {

    private final List<T> heap; // Estructura base del montículo

    public MinHeap() {
        this.heap = new ArrayList<>();
    }

    // Inserta un elemento y ordena hacia arriba
    public void insertar(T valor) {
        heap.add(valor);
        upHeapify(heap.size() - 1);
    }

    // Elimina y retorna el elemento mínimo (raíz)
    public T eliminarMin() {
        if (estaVacio()) {
            throw new IllegalStateException("El montículo está vacío.");
        }

        T min = heap.get(0);
        T ultimo = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, ultimo);
            downHeapify(0); // Restaura la propiedad del min-heap
        }

        return min;
    }

    // Retorna la raíz sin eliminarla
    public T peek() {
        return estaVacio() ? null : heap.get(0);
    }

    // Construye un heap válido desde una lista desordenada
    public void heapify(List<T> elementos) {
        heap.clear();
        heap.addAll(elementos);

        int inicio = (heap.size() / 2) - 1; // Último nodo no-hoja

        for (int i = inicio; i >= 0; i--) {
            downHeapify(i);
        }
    }

    public boolean estaVacio() {
        return heap.isEmpty();
    }

    public int tamano() {
        return heap.size();
    }

    public void limpiar() {
        heap.clear();
    }

    public List<T> obtenerElementos() {
        return new ArrayList<>(heap);
    }

    // Sube un nodo comparándolo con su padre
    private void upHeapify(int i) {
        while (i > 0) {
            int padre = (i - 1) / 2;

            if (heap.get(i).compareTo(heap.get(padre)) < 0) {
                intercambiar(i, padre);
                i = padre;
            } else {
                break;
            }
        }
    }

    // Baja un nodo comparándolo con el hijo más pequeño
    private void downHeapify(int i) {
        int size = heap.size();

        while (true) {
            int izq = 2 * i + 1;
            int der = 2 * i + 2;
            int menor = i;

            if (izq < size && heap.get(izq).compareTo(heap.get(menor)) < 0) {
                menor = izq;
            }

            if (der < size && heap.get(der).compareTo(heap.get(menor)) < 0) {
                menor = der;
            }

            if (menor != i) {
                intercambiar(i, menor);
                i = menor;
            } else {
                break;
            }
        }
    }

    // Intercambia dos posiciones del heap
    private void intercambiar(int a, int b) {
        T temp = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, temp);
    }

    @Override
    public String toString() {
        return heap.toString();
    }
}
