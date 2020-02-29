import Task11.MyLinkedList.MyLinkedList;
import Task5.Student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class MyLinkedListTest {

    MyLinkedList<String> linkedList;

    @Before
    public void before() {
        linkedList = new MyLinkedList<>();
    }

    @Test
    public void add() {
        linkedList.add("hello");
        linkedList.add("world");
        Assert.assertEquals(2, linkedList.size());
    }

    @Test
    public void remove() {
        linkedList.add("hello");
        linkedList.add("world");
        //Assert.assertEquals(false, linkedList.remove(new Student("Df")));
    }

    @Test
    public void indexOf() {
        linkedList.add("hello");
        linkedList.add("world");
        Assert.assertEquals(1, linkedList.indexOf("world"));
        //Assert.assertEquals(-1, linkedList.indexOf(new Student("Df")));
    }

}
