package lab4;

public class Heap<E extends Comparable> {

    public E[] heap;
    private int n = 0; // the size of the current heap
    //private int size = 15; // the max size of the heap

    public Heap(int size) {
        heap = (E[]) new Comparable[size + 1];

    }

    public void heapify(E[] array) {
        for (E element : array) {
            insert(element);

        }
    }

    public void insert(E element) {
        heap[++n] = element;
        swim(n);
    }

    private void swim(int i) {
        while (i > 1 && less(heap[i / 2], heap[i])) {
            exchange(heap, i / 2, i);
            i = i / 2;
        }

    }

    public E getMax() {
        E max = heap[1];
        exchange(heap, 1, n--);
        sink(1);
        heap[n + 1] = null;
        return max;
    }

    public void sink(int i) {
        while (2 * i <= n) {
            int j = 2 * i;
            if (j < n && less(heap[j], heap[j + 1])) {
                j++;
            }
            if (!less(heap[i], heap[j])) {
                break;
            }
            exchange(heap, i, j);
            i = j;
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);

    }

    private static void exchange(Comparable[] array, int i, int j) {
        Comparable t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public int returnSize() {
        return heap.length;
    }

    public E get(int i) {

        return heap[i];
    }

}
