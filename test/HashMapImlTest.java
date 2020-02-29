import Task15.HashMapIml;
import Task5.Student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HashMapImlTest {

    HashMapIml<String, String> hashMap;

    @Before
    public void before() {
        hashMap = new HashMapIml();
    }

    @Test
    public void put() {
        hashMap.put("hello", "privet");
        hashMap.put("cucumber", "ogurets");
        Assert.assertEquals(2, hashMap.size());
    }

    @Test
    public void get() {
        hashMap.put("hello", "privet");
        hashMap.put("cucumber", "ogurets");
        Assert.assertEquals("privet", hashMap.get("hello"));
        //Assert.assertEquals(null, hashMap.get(new Student("Dima")));
    }

    @Test
    public void remove() {
        hashMap.put("hello", "privet");
        hashMap.put("cucumber", "ogurets");
        Assert.assertEquals("privet", hashMap.remove("hello"));
        //Assert.assertEquals(null, hashMap.remove(new Student("Dima")));
    }

    @Test
    public void containsKey() {
        hashMap.put("hello", "privet");
        hashMap.put("cucumber", "ogurets");
        Assert.assertEquals(true, hashMap.containsKey("hello"));
        //Assert.assertEquals(false, hashMap.containsKey(new Student("Dima")));
    }

    @Test
    public void containsValue() {
        hashMap.put("hello", "privet");
        hashMap.put("cucumber", "ogurets");
        Assert.assertEquals(true, hashMap.containsValue("privet"));
        //Assert.assertEquals(false, hashMap.containsValue(new Student("Dima")));
    }

}
