package Task15;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class HashMapImlTest {

    @Test
    public void put() {
        HashMapIml map = new HashMapIml();
        map.put("hello", "привет");
        Assert.assertEquals("привет", map.get("hello"));
    }

    @Test
    public void get() {
        HashMapIml map = new HashMapIml();
        map.put("hello", "привет");
        Assert.assertEquals("привет", map.get("hello"));
    }

    @Test
    public void remove() {
        HashMapIml map = new HashMapIml();
        map.put("hello", "привет");
        map.put("car", "автомобиль");
        map.put("apple", "яблоко");
        map.remove("apple");
        Assert.assertEquals("автомобиль", map.get("car"));
        Assert.assertEquals(false, map.get("apple"));
    }

    @Test
    public void size() {
        HashMapIml map = new HashMapIml();
        map.put("hello", "привет");
        map.put("car", "автомобиль");
        map.put("apple", "яблоко");
        Assert.assertEquals(3, map.size());
    }

    @Test
    public void isEmpty() {
        HashMapIml map = new HashMapIml();
        Assert.assertEquals(true, map.isEmpty());
        map.put("hello", "привет");
        Assert.assertEquals(false, map.isEmpty());
    }

    @Test
    public void containsKey() {
        HashMapIml map = new HashMapIml();
        map.put("hello", "привет");
        map.put("car", "автомобиль");
        map.put("apple", "яблоко");
        Assert.assertEquals(true, map.containsKey("apple"));
        Assert.assertEquals(false, map.containsKey("sad"));
    }

    @Test
    public void containsValue() {
        HashMapIml map = new HashMapIml();
        map.put("hello", "привет");
        map.put("car", "автомобиль");
        Assert.assertEquals(true, map.containsValue("привет"));
        Assert.assertEquals(false, map.containsValue("не_привет"));
    }

    @Test
    public void putAll() {
        HashMapIml map = new HashMapIml();
        map.put("hello", "привет");
        map.put("car", "автомобиль");
        HashMapIml map1 = new HashMapIml();
        map.put("hello1", "привет1");
        map.put("car1", "автомобиль1");
        map.putAll(map1);
        Assert.assertEquals("привет1", map.get("hello1"));
        Assert.assertEquals("автомобиль1", map.get("car1"));
    }

    @Test
    public void clear() {
        HashMapIml map = new HashMapIml();
        map.put("hello", "привет");
        map.put("car", "автомобиль");
        map.clear();
        Assert.assertEquals(0, map.size());
    }

    @Test
    public void keySet() {
        Set keySet = new HashSet();
        HashMapIml map = new HashMapIml();
        map.put("hello", "привет");
        map.put("car", "автомобиль");
        map.put("apple", "яблоко");
        keySet = map.keySet();

        Set controlSet = new HashSet();
        controlSet.add("hello");
        controlSet.add("car");
        controlSet.add("apple");

        Assert.assertEquals(keySet, controlSet);

    }

    @Test
    public void values() {
        Collection values = new ArrayList();
        HashMapIml map = new HashMapIml();
        map.put("hello", "привет");
        map.put("car", "автомобиль");
        values = map.values();

        Collection controlList = new ArrayList();
        controlList.add("привет");
        controlList.add("автомобиль");

        Assert.assertEquals(values, controlList);
    }

    /*@Test
    public void resize() {
        HashMapIml map = new HashMapIml();
        map.put("hello", "привет");
        map.put("car", "автомобиль");
        map.resize(200);
        Assert.assertEquals(2, map.size());
    }*/
}
