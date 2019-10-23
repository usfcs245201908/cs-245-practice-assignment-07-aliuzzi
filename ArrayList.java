import java.lang.reflect.Type;
import java.util.Arrays;


public class ArrayList<T> implements List {
    private T[] arr;
    private int size;

    public ArrayList() {
        arr = (T[]) new Object[10];
        size = 0;
    }

    public void add(Object item) {
        if (size == arr.length) {
            grow();
        }
        arr[size++] = (T) item;
    }

    public void add(int pos, Object item) throws IndexOutOfBoundsException {
        if (pos > size || pos < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
        if (size == arr.length) {
            grow();
        }
        for (int i = size; i > pos; i--) {
            arr[i] = arr[i - 1];
        }
        arr[pos] = (T) item;
        size++;
    }

    public T get(int pos) throws IndexOutOfBoundsException {
        if (pos > size || pos == size) {
            throw new IndexOutOfBoundsException();
        }
        return arr[pos];
    }

    public T remove(int pos) throws IndexOutOfBoundsException {
        if (pos > size || pos == size || pos < 0) {
            throw new IndexOutOfBoundsException();
        }
        T temp = arr[pos];
        for (int i = pos; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        return temp;
    }

    public int size() {
        return this.size;
    }

    private void grow() {
        T[] arr2 = (T[]) new Object[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
        }
        arr = arr2;
    }
}
