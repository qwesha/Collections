package ru.aston.collections;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ListTest {
    @Test
    void testArrayListBasicOperations() {
        List<Integer> list = new MyArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));

        list.add(10, 1);
        assertEquals(4, list.size());
        assertEquals(10, list.get(1));
        assertEquals(2, list.get(2));

        list.remove(10);
        assertEquals(3, list.size());
        assertEquals(2, list.get(1));

        list.clear();
        assertEquals(0, list.size());
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    void testLinkedListBasicOperations() {
        List<String> list = new MyLinkedList<>();

        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals(3, list.size());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));

        list.add("X", 1);
        assertEquals(4, list.size());
        assertEquals("X", list.get(1));
        assertEquals("B", list.get(2));

        list.remove("X");
        assertEquals(3, list.size());
        assertEquals("B", list.get(1));

        list.clear();
        assertEquals(0, list.size());
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    void testSort() {
        List<Integer> arrayList = new MyArrayList<>();
        arrayList.add(3);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.sort();
        assertEquals(1, arrayList.get(0));
        assertEquals(2, arrayList.get(1));
        assertEquals(3, arrayList.get(2));

        List<String> linkedList = new MyLinkedList<>();
        linkedList.add("Banana");
        linkedList.add("Apple");
        linkedList.add("Cherry");
        linkedList.sort();
        assertEquals("Apple", linkedList.get(0));
        assertEquals("Banana", linkedList.get(1));
        assertEquals("Cherry", linkedList.get(2));
    }

    @Test
    void testIndexOutOfBounds() {
        List<Integer> arrayList = new MyArrayList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.add(1, 1));

        arrayList.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(1));

        List<String> linkedList = new MyLinkedList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.add("A", 1));
    }

    @Test
    void testEdgeCases() {
        List<Integer> list = new MyArrayList<>();
        assertDoesNotThrow(list::clear);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));

        list.add(42);
        assertEquals(42, list.get(0));
        list.remove(42);
        assertEquals(0, list.size());
    }
}