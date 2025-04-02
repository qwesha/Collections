import ru.aston.collections.List;
import ru.aston.collections.MyArrayList;
import ru.aston.collections.MyLinkedList;

public class ListDemo {
    public static void main(String[] args) {
        System.out.println("=== MyArrayList Demo ===");
        demoArrayList();

        System.out.println("\n=== MyLinkedList Demo ===");
        demoLinkedList();
    }

    private static void demoArrayList() {
        List<Integer> list = new MyArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("After add(10), add(20), add(30): " + list);

        list.add(15, 1);
        System.out.println("After add(15, 1): " + list);

        System.out.println("Element at index 2: " + list.get(2));

        list.remove(20);
        System.out.println("After remove(20): " + list);

        list.add(5);
        list.add(25);
        System.out.println("Before sort: " + list);
        list.sort();
        System.out.println("After sort: " + list);

        list.clear();
        System.out.println("After clear: " + list);
    }

    private static void demoLinkedList() {
        List<String> list = new MyLinkedList<>();

        list.add("Apple");
        list.add("Cherry");
        list.add("Banana");
        System.out.println("After add(\"Apple\"), add(\"Cherry\"), add(\"Banana\"): " + list);

        list.add("Grape", 1);
        System.out.println("After add(\"Grape\", 1): " + list);

        System.out.println("Element at index 2: " + list.get(2));

        list.remove("Cherry");
        System.out.println("After remove(\"Cherry\"): " + list);

        System.out.println("Before sort: " + list);
        list.sort();
        System.out.println("After sort: " + list);

        list.clear();
        System.out.println("After clear: " + list);
    }
}