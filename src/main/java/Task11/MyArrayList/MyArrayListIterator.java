package Task11.MyArrayList;

import javax.jws.Oneway;
import java.util.Iterator;

public class MyArrayListIterator<T> implements Iterator<T> {

    private int index = 0;
    private Object[] objects;

    public MyArrayListIterator(Object[] objects) {
        this.objects = objects;
    }

    @Override
    public boolean hasNext() {
        return index < objects.length;
    }

    @Override
    public T next() {
        Object result = objects[index];
        index++;
        return (T) result;
    }
}
