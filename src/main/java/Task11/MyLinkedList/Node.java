package Task11.MyLinkedList;

public class Node<T> {
    private T data;
    private Node previous;
    private Node next;

    public Node(T data, Node previous, Node next) {
        this.data = data;
        this.previous = previous;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
