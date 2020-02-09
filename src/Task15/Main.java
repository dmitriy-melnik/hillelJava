package Task15;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMapIml map = new HashMapIml();
        map.put("hello", "привет");
        map.put("car", "автомобиль");
        map.put("apple", "яблоко");
        map.put("science", "наука");
        map.put("glass", "стекло");
        map.put("hello", "дарова");
        map.print();
        System.out.println(map.containsKey("gvhjh"));
        System.out.println(map.containsKey("glass"));
        System.out.println(map.containsValue("яблоко"));
        System.out.println(map.containsValue("дарова"));

        HashMapIml map2 = new HashMapIml();
        map.put("word1", "слово1");
        map.put("word2", 22);
        map.put("word3", 33);

        System.out.println("\nAfter putAll: ");
        map.putAll(map2);
        map.print();
    }
}
