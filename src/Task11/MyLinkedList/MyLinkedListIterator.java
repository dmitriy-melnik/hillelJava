package Task11.MyLinkedList;

import java.util.Iterator;

public class MyLinkedListIterator implements Iterator {

    private Node head;
    //private Node current = head;

    public MyLinkedListIterator(Node head) {
        this.head = head;
    }

    @Override
    public boolean hasNext() {
        return head != null;
    }

    @Override
    public Object next() {
        Node node = head;
        head = head.getNext();
        return node;
    }
}
