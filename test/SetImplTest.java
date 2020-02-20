import Task12.SetImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SetImplTest {

    SetImpl<String> set;

    @Before
    public void before() {
        set = new SetImpl<>();
    }

    @Test
    public void add() {
        set.add("hello");
        set.add("world");
        Assert.assertEquals(2, set.size());
    }


    @Test
    public void contains() {
        set.add("hello");
        Assert.assertEquals(false, set.contains(545));
    }
}
