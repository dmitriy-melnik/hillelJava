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
        while (current != tail) {
            if (current.getData().equals(o)) {
                return true;
            }
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

    // add to the end
    @Override
    public boolean add(Object o) {
        if(o == null) {
            return false;
        }
        else {
            Node node = new Node(o, null);
            if (head == null) {
                head = node;
            }
            else {
                Node current = head;
                while (current.getNext() != tail) {
                    current = current.getNext();
                }
                current.setNext(node);
            }
            node.setNext(tail);
            size++;
            return true;
        }
    }

    // add as a first element
    public boolean addFirst(Object o) {
        if (o == null) {
            return false;
        }
        else {
            if (head == null) {
                add(o);
                return true;
            }
            else {
                Node node = new Node(o, head);
                head = node;
                size++;
                return true;
            }
        }
    }

    // removes the first occurrence of an element
    @Override
    public boolean remove(Object o) {
        if (head == null) {
            return false;
        }
        else {
            Node previous = null;
            Node current = head;
            if (head.getData().equals(o)) {
                head = head.getNext();
            }
            else {
                while (current.getNext() != tail) {
                    previous = current;
                    current = current.getNext();
                    if (current.getData().equals(o)) {
                        previous.setNext(current.getNext());
                    }
                }
            }
            size--;
            return true;
        }
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
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node current = head;
        while (current != tail) {
            if (current.getNext() == tail) {
                result.append(current.getData());
            }
            else {
                result.append(current.getData()).append(", ");
            }
            current = current.getNext();
        }
        return result.toString();
    }

}
