package Task15;

import java.util.*;

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
        //map.resize(200);

        System.out.println(map.keySet());

        Collection values = map.values();
        System.out.println(values);


        System.out.println(map.containsKey("gvhjh"));
        System.out.println(map.containsKey("glass"));
        System.out.println(map.containsValue("яблоко"));
        System.out.println(map.containsValue("дарова"));

        HashMapIml map2 = new HashMapIml();
        map.put("word1", "слово1");
        map.put("word1", "слово111");
        map.put("word2", 22);
        map.put("word3", 33);

        System.out.println("\nAfter putAll: ");
        map.putAll(map2);
        map.print();
    }
}
