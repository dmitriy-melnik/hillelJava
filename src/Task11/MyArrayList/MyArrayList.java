package Task11.MyArrayList;

import java.util.*;

public class MyArrayList<E> implements List<E> {

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
    public Iterator<E> iterator() {
        return new MyArrayListIterator<E>(array);
    }

    @Override
    public boolean add(E e) {
        if (e == null) {
            return false;
        }
        else {
            array = Arrays.copyOf(array, array.length + 1);
            array[array.length - 1] = e;
            return true;
        }
    }

    @Override
    public boolean remove(Object o) {
        int i = -1;
        for (int j = 0; j < array.length; j++) {
            if (array[j].equals(o)) {
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
    public boolean addAll(Collection<? extends E> c) {
        for (E e : c) {
            add(e);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if (index >= 0 && index < array.length) {
            int i = index;
            for (E e : c) {
                add(i, e);
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
    public E get(int index) {
        if (index >= 0 && index < array.length) {
            return (E) array[index];
        }
        return null;
    }

    @Override
    public E set(int index, E e) {
        E value;
        if (index >= 0 && index < array.length && e != null) {
            value = (E) array[index];
            array[index] = e;
            return value;
        }
        return null;
    }

    @Override
    public void add(int index, E e) {
        if (index >= 0 && index < array.length && e != null) {
            add(e);
            for (int i = array.length - 1; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = e;
        }
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size()) {
            return null;
        }
        else {
            E value = (E) array[index];
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
                add((E) object);
            }
            return value;
        }
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(o)) {
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
    public List<E> subList(int fromIndex, int toIndex) {
        if (fromIndex <= toIndex && fromIndex > 0 && toIndex < array.length) {
            MyArrayList<E> sublist = new MyArrayList<E>();

            for (int i = fromIndex; i < toIndex; i++) {
                sublist.add((E) array[i]);
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
