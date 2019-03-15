import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;

class Book {
    int id;
    String name, author, publisher;
    int quantity;

    public Book(int id, String name, String author, String publisher, int quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }
}

public class MapExample {

    private static <KEY, VALUE> void put(Map<KEY, List<VALUE>> map, KEY key, VALUE value) {
        map.compute(key, (s, strings) -> strings == null ? new ArrayList<>() : strings).add(value);
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 11, 22, 33, 21, 43, 56, 78, 90 };
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length - 1; i++) {
            int key = arr[i] % 3;
            put(map, key, arr[i]);
        }
        List<Integer> a = map.get(1); // print value based on key

        // iterate to the list of value stored in key
        for (int i = 0; i < a.size(); i++) {
            System.out.print((a.get(i)) + " ");
        }

        // iterating entire map
        map.forEach((s, strings) -> {
            System.out.print(s + ": ");
            System.out.println(strings);
        });
    }
}
