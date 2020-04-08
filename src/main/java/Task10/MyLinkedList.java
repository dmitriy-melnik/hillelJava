package Task10;

import java.util.Collection;
import java.util.Iterator;

public class MyLinkedList implements Collection {
    private Node head;
    private Node tail;
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
        Node current = head;
        if (head == null) {
            return false;
        }
        while (true) {
            if (current.getData().equals(o)) {
                return true;
            }
            if (current.getNext() == null) break;
            current = current.getNext();
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        if (o == null) {
            return false;
        } else {
            if (head == null) {
                Node node = new Node(o, null, null);
                head = node;
                tail = node;
            } else {
                Node node = new Node(o, tail, null);
                tail.setNext(node);
                tail = node;
            }
            size++;
            return true;
        }
    }

    public boolean addFirst(Object o) {
        if (o == null) {
            return false;
        } else {
            if (head == null) {
                Node node = new Node(o, null, null);
                head = node;
                tail = node;
            } else {
                Node node = new Node(o, null, head);
                head.setPrevious(node);
                head = node;
            }
            size++;
            return true;
        }
    }

    @Override
    public boolean remove(Object o) {
        if (head == null) {
            return false;
        } else {
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
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        for (Object o : c) {
            add(o);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {
        size = 0;
        head = null;
        tail = null;
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
