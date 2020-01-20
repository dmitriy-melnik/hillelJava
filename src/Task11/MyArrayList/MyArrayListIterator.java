package Task11.MyArrayList;

import java.util.Iterator;

public class MyArrayListIterator implements Iterator {

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
    public Object next() {
        Object result = objects[index];
        index++;
        return result;
    }
}
