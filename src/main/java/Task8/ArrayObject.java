package Task8;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class ArrayObject implements Collection {

    private Object[] array = new Object[0];

    @Override
    public int size() {
        return array.length;
    }

    // fixed
    @Override
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        } else return false;
        /*boolean check = true;
        for (Object o : array) {
            if (o != null) {
                check = false;
            }
        }
        return check;*/
    }

    @Override
    public boolean contains(Object o) {
        for (Object object : array) {
            if (object == o) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return array;
    }

    // fixed
    @Override
    public boolean add(Object o) {
        if (o == null) {
            return false;
        } else {
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
            Object[] firstPart = new Object[i];
            for (int j = 0; j < firstPart.length; j++) {
                firstPart[j] = array[j];
            }

            Object[] secondPart = new Object[array.length - i - 1];
            for (int j = i + 1, m = 0; j < array.length; j++, m++) {
                secondPart[m] = array[j];
            }

            array = firstPart;
            for (Object object : secondPart) {
                add(object);
            }
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
    public void clear() {
        array = new Object[0];
    }

    @Override
    public boolean retainAll(Collection c) {
        boolean check;
        for (int i = 0; i < array.length; i++) {
            check = false;
            for (Object o : c) {
                if (array[i] == o) {
                    check = true;
                }
            }
            if (check == false) {
                array[i] = null;
            }
        }
        remove(null);
        return true;
    }

    @Override
    public boolean removeAll(Collection c) {
        boolean check;
        for (int i = 0; i < array.length; i++) {
            check = false;
            for (Object o : c) {
                if (array[i] == o) {
                    check = true;
                }
            }
            if (check == true) {
                array[i] = null;
            }
        }
        remove(null);
        return true;
    }

    @Override
    public boolean containsAll(Collection c) {
        boolean check = false;
        for (Object object : c) {
            boolean check1 = false;
            for (Object a : array) {
                if (object == a) {
                    check1 = true;
                }
            }
            if (check1) check = true;
            if (!check1) return false;
        }
        return check;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
