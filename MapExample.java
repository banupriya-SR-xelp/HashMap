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
        Random rand = new Random();
        int rand_int = rand.nextInt(1000);
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            rand_int = rand.nextInt(1000);
            int key = rand_int % 3;
            put(map, key, rand_int);

        }
        List<Integer> a = map.get(1); // print value based on key

        // iterate to the list of value stored in key
        System.out.println("-----map[1] elements-----");
        for (int i = 0; i < a.size(); i++) {
            System.out.print((a.get(i)) + "-");
        }
        System.out.println("\n ");
        System.out.println("-----all elements in map -----");
        // iterating entire map
        map.forEach((s, strings) -> {
            System.out.print(s + ": ");
            System.out.println(strings);
        });
    }
}
