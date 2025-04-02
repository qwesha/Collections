package ru.aston.collections;
import java.util.Arrays;

public class MyLinkedList<T> implements List<T> {
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void add(T value) {
        addLast(value);
    }

    @Override
    public void add(T value, int index) {
        checkIndexForAdd(index);

        if (index == size) {
            addLast(value);
        } else if (index == 0) {
            addFirst(value);
        } else {
            Node<T> succ = getNode(index);
            Node<T> pred = succ.prev;
            Node<T> newNode = new Node<>(value, pred, succ);
            pred.next = newNode;
            succ.prev = newNode;
            size++;
        }
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return getNode(index).data;
    }

    @Override
    public void remove(T value) {
        Node<T> current = head;
        while (current != null) {
            if (value.equals(current.data)) {
                unlink(current);
                return;
            }
            current = current.next;
        }
    }

    @Override
    public void clear() {
        Node<T> current = head;
        while (current != null) {
            Node<T> next = current.next;
            current.data = null;
            current.next = null;
            current.prev = null;
            current = next;
        }
        head = tail = null;
        size = 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void sort() {
        if (size <= 1) return;

        // Преобразуем в массив для сортировки
        Object[] array = new Object[size];
        int i = 0;
        for (Node<T> x = head; x != null; x = x.next) {
            array[i++] = x.data;
        }

        Arrays.sort((T[]) array);

        // Заполняем список отсортированными значениями
        i = 0;
        for (Node<T> x = head; x != null; x = x.next) {
            x.data = (T) array[i++];
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T value) {
        final Node<T> f = head;
        final Node<T> newNode = new Node<>(value, null, f);
        head = newNode;
        if (f == null) {
            tail = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
    }

    public void addLast(T value) {
        final Node<T> l = tail;
        final Node<T> newNode = new Node<>(value, l, null);
        tail = newNode;
        if (l == null) {
            head = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    private void unlink(Node<T> node) {
        final Node<T> next = node.next;
        final Node<T> prev = node.prev;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

        node.data = null;
        size--;
    }

    private Node<T> getNode(int index) {
        // Оптимизация: поиск с начала или с конца
        if (index < (size >> 1)) {
            Node<T> x = head;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            Node<T> x = tail;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
