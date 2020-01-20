package Task11.MyLinkedList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList implements List {
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
        if (indexOf(o) != -1) {
            return true;
        }
        else return false;
    }

    @Override
    public Iterator iterator() {
        return new MyLinkedListIterator(head);
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
    public boolean addAll(Collection c) {
        for (Object o : c) {
            add(o);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        if (index >= 0 && index < size) {
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
        size = 0;
        head = null;
        tail = null;
    }

    @Override
    public Object get(int index) {
        if (index >= 0 && index < size) {
            int i = 0;
            Node current = head;
            while (true) {
                if (i == index) {
                    return current;
                }
                i++;
                if (current.getNext() == null) break;
                current = current.getNext();
            }
        }
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        if (element != null) {
            Object o = get(index);
            if (o != null) {
                Node node = (Node) o;
                node.setData(element);
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(int index, Object element) {
        if (index >= 0 && index < size && element != null) {
            int i = 0;
            Node current = head;
            while (true) {
                if (i == index) {
                    if (head == current) {
                        Node node = new Node(element, null, current);
                        current.setPrevious(node);
                        head = node;
                    } else {
                        Node node = new Node(element, current.getPrevious(), current);
                        current.getPrevious().setNext(node);
                        current.setPrevious(node);
                    }
                    size++;
                }
                i++;
                if (current.getNext() == null) break;
                current = current.getNext();
            }
        }
    }

    @Override
    public Object remove(int index) {
        Object o = get(index);
        Node node = (Node) o;
        if (node != null) {
            remove(node.getData());
            size--;
            return true;
        }
        return false;
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

    @Override
    public List subList(int fromIndex, int toIndex) {
        if (fromIndex <= toIndex && fromIndex > 0 && toIndex < size) {
            MyLinkedList sublist = new MyLinkedList();
            Node current = head;
            int i = 0;
            while (true) {
                if (i >= fromIndex && i < toIndex) {
                    sublist.add(current);
                }
                if (current.getNext() == null || i == toIndex) break;
                i++;
                current = current.getNext();
            }
            return sublist;
        }
        return null;
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
