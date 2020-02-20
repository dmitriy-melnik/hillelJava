import Task11.MyArrayList.MyArrayList;
import Task5.Student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyArrayListTest {

    MyArrayList<String> arrayList;

    @Before
    public void before() {
        arrayList = new MyArrayList<>();
    }

    @Test
    public void add() {
        arrayList.add("hello");
        arrayList.add("word");
        Assert.assertEquals(2, arrayList.size());
    }

    @Test
    public void size() {
        Assert.assertEquals(0, arrayList.size());
    }

    @Test
    public void remove() {
        arrayList.add("hello");
        arrayList.add("world");
        Assert.assertEquals(false, arrayList.remove(new Student("Df")));
    }

    @Test
    public void indexOf() {
        arrayList.add("hello");
        arrayList.add("world");
        Assert.assertEquals(-1, arrayList.indexOf(new String("Df")));
    }


}
