package ru.aston.collections;

public interface List<T> {

    void add(T value);

    void add(T value, int index);

    T get(int index);

    void remove(T value);

    void clear();

    void sort();

    int size();
}
