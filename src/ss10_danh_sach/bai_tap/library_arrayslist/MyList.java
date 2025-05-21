package ss10_danh_sach.bai_tap.library_arrayslist;

import java.util.Arrays;

public class MyList<T> {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private T[] elements;

    public MyList(int capacity) {
        elements = (T[]) new Object[capacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    public void add(int index, T element) {
        if (index < 0 || index > size) {
            System.out.println("vi tri can them vuot qua gioi han cho phep");
        } else {
            ensureCapaCity(DEFAULT_CAPACITY);
            for (int i = size; i > index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index] = element;
            size++;
        }
    }

    public void ensureCapaCity(int minCapacity) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length + minCapacity);
        }
    }

    public T[] clone() {
        T[] newElements = Arrays.copyOf(elements, elements.length);
        return newElements;
    }

    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public boolean add(T element) {
        ensureCapaCity(DEFAULT_CAPACITY);
        elements[size++] = element;
        return true;
    }

    public T get(int index) {
        if (index < 0 || index > size) {
            System.out.println("vi tri can lay khong ton tai");
            return null;
        }
        return elements[index];
    }

    public void clear() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public T remove(int index) {
        // kiểm tra hợp lệ
        if (index < 0 || index > size) {
            System.out.println("vi tri can xoa khong ton tai");
            return null;
        }
        T removed = elements[index];

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
        return removed;
    }
}