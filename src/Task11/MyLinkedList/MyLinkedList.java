package Task11.MyLinkedList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList<E> implements List<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(Object o) {
        if (indexOf(o) != -1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Iterator iterator() {
        return new MyLinkedListIterator(head);
    }

    @Override
    public boolean add(E e) {
        if (e == null) {
            return false;
        } else {
            if (head == null) {
                Node node = new Node(e, null, null);
                head = node;
                tail = node;
            } else {
                Node node = new Node(e, tail, null);
                tail.setNext(node);
                tail = node;
            }
            size++;
            return true;
        }
    }

    // added NullPointerException
    @Override
    public boolean remove(Object o) {
        try {
            Node current = head;
            while (true) {
                if (current.getData().equals(o)) {
                    if (head == current && tail == current) {
                        head = null;
                        tail = null;
                    } else if (head == current) {
                        current.getNext().setPrevious(null);
                        head = current.getNext();
                    } else if (tail == current) {
                        current.getPrevious().setNext(null);
                        tail = current.getPrevious();
                    } else {
                        current.getPrevious().setNext(current.getNext());
                        current.getNext().setPrevious(current.getPrevious());
                    }
                    size--;
                    return true;
                }
                if (current.getNext() == null) break;
                current = current.getNext();
            }
        } catch (NullPointerException removeException) {
            removeException.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E e : c) {
            add(e);
        }
        return true;
    }

    // added IndexOutOfBoundsException
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        try {
            int i = index;
            for (E e : c) {
                add(i, e);
                i++;
            }
            return true;
        } catch (IndexOutOfBoundsException addAllException) {
            addAllException.printStackTrace();
            return false;
        }
    }

    @Override
    public void clear() {
        size = 0;
        head = null;
        tail = null;
    }

    // added IndexOutOfBoundsException
    @Override
    public E get(int index) {
        if (index >= 0 && index < size) {
            int i = 0;
            Node current = head;
            while (true) {
                if (i == index) {
                    return (E) current.getData();
                }
                i++;
                if (current.getNext() == null) break;
                current = current.getNext();
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
        return null;
    }

    // added IndexOutOfBoundsException
    @Override
    public E set(int index, E e) {
        if (e != null) {
            if (index >= 0 && index < size) {
                Node current = head;
                int tempSize = 0;
                while (true) {
                    if (tempSize == index) {
                        current.setData(e);
                        break;
                    }
                    if (current.getNext() == null) break;
                    tempSize++;
                    current = current.getNext();
                    return e;
                }
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
        return null;
    }

    // added IndexOutOfBoundsException
    @Override
    public void add(int index, E e) {
        if (e != null) {
            if (index >= 0 && index < size) {
                int i = 0;
                Node current = head;
                while (true) {
                    if (i == index) {
                        if (head == current) {
                            Node node = new Node(e, null, current);
                            current.setPrevious(node);
                            head = node;
                        } else {
                            Node node = new Node(e, current.getPrevious(), current);
                            current.getPrevious().setNext(node);
                            current.setPrevious(node);
                        }
                        size++;
                    }
                    i++;
                    if (current.getNext() == null) break;
                    current = current.getNext();
                }
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    // added IndexOutOfBoundsException
    @Override
    public E remove(int index) {
        if (index >= 0 && index < size) {
            Node current = head;
            int tempSize = 0;
            while (true) {
                if (tempSize == index) {
                    if (current != null) {
                        remove(current.getData());
                        size--;
                        return (E) current.getData();
                    }
                }
                if (current.getNext() == null) break;
                tempSize++;
                current = current.getNext();
            }
            return (E) current.getData();
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        Node current = head;
        while (true) {
            if (current.getData().equals(o)) {
                return index;
            }
            index++;
            if (current.getNext() == null) break;
            current = current.getNext();
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = 0;
        int lastIndex = -1;
        Node current = head;
        while (true) {
            if (current.getData().equals(o)) {
                lastIndex = index;
            }
            index++;
            if (current.getNext() == null) break;
            current = current.getNext();
        }
        return lastIndex;
    }

    // added IndexOutOfBoundsException
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        if (fromIndex <= toIndex && fromIndex > 0 && toIndex <= size) {
            MyLinkedList<E> sublist = new MyLinkedList<E>();
            Node current = head;
            int i = 0;
            while (true) {
                if (i >= fromIndex && i < toIndex) {
                    sublist.add((E) current.getData());
                }
                if (current.getNext() == null || i == toIndex) break;
                i++;
                current = current.getNext();
            }
            return sublist;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    //--

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
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
        StringBuilder result = new StringBuilder();
        Node current = head;
        while (current != null) {
            if (current.getNext() == null) {
                result.append(current);
            } else {
                result.append(current).append(", ");
            }
            current = current.getNext();
        }
        return result.toString();
    }
}
