package Task11.MyArrayList;

import java.util.*;

public class MyArrayList implements List {

    private Object[] array = new Object[0];

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        else return false;
    }

    @Override
    public boolean contains(Object o) {
        if (indexOf(o) != -1) {
            return true;
        }
        else return false;
    }

    @Override
    public Iterator iterator() {

        return new MyArrayListIterator(array);
    }

    @Override
    public boolean add(Object o) {
        if (o == null) {
            return false;
        }
        else {
            array = Arrays.copyOf(array, array.length + 1);
            array[array.length - 1] = o;
            return true;
        }
    }

    @Override
    public boolean remove(Object o) {
        int i = -1;
        for (int j = 0; j < array.length; j++) {
            if (array[j] == o) {
                i = j;
                break;
            }
        }
        if (i != -1) {
            remove(i);
            return true;
        }
        else return false;
    }

    @Override
    public boolean addAll(Collection c) {
        for (Object o : c) {
            add(o);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        if (index >= 0 && index < array.length) {
            int i = index;
            for (Object o : c) {
                add(i, o);
                i++;
            }
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        array = new Object[0];
    }

    @Override
    public Object get(int index) {
        if (index >= 0 && index < array.length) {
            return array[index];
        }
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        if (index >= 0 && index < array.length && element != null) {
            array[index] = element;
            return true;
        }
        return false;
    }

    @Override
    public void add(int index, Object element) {
        if (index >= 0 && index < array.length && element != null) {
            add(0);
            for (int i = array.length - 1; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = element;
        }
    }

    @Override
    public Object remove(int index) {
        if (index < 0 || index >= size()) {
            return false;
        }
        else {
            Object[] firstPart = new Object[index];
            for (int j = 0; j < firstPart.length; j++) {
                firstPart[j] = array[j];
            }

            Object[] secondPart = new Object[array.length - index - 1];
            for (int j = index + 1, m = 0; j < array.length; j++, m++) {
                secondPart[m] = array[j];
            }

            array = firstPart;
            for (Object object : secondPart) {
                add(object);
            }
            return true;
        }
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == o) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == o) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        if (fromIndex <= toIndex && fromIndex > 0 && toIndex < array.length) {
            MyArrayList sublist = new MyArrayList();

            for (int i = fromIndex; i < toIndex; i++) {
                sublist.add(array[i]);
            }
            return sublist;
        }
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
