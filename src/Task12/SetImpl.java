package Task12;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class SetImpl implements Set {

    private class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    private Node head;
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
        if (o == null || !(o instanceof Integer)) {
            return false;
        } else {
            Node current = head;
            while (true) {
                if (o.equals(current.getData())) {
                    return true;
                } else if ((int) o > current.getData()) {
                    if (current.getRight() == null) {
                        return false;
                    }
                    current = current.getRight();
                } else if ((int) o < current.getData()) {
                    if (current.getLeft() == null) {
                        return false;
                    }
                    current = current.getLeft();
                }
            }
        }
    }

    // рекурсиваная реализация поиска
    public boolean containsRecursion(Object o) {
        return recursionSearch(o, head);
    }

    private boolean recursionSearch(Object o, Node node) {
        if (o == null || !(o instanceof Integer) || node == null) {
            return false;
        }
        if (o.equals(node.getData())) {
            return true;
        }
        if ((int) o < node.getData()) {
            return recursionSearch(o, node.getLeft());
        } else {
            return recursionSearch(o, node.getRight());
        }
    }

    @Override
    public boolean add(Object o) {
        if (o == null || !(o instanceof Integer)) {
            return false;
        } else {
            Node node = new Node((int) o, null, null);
            Node current = head;
            if (head == null) {
                head = node;
            } else {
                while (true) {
                    if (o.equals(current.getData())) {
                        return false;
                    }
                    if ((int) o > current.getData()) {
                        if (current.getRight() == null) {
                            current.setRight(node);
                            break;
                        }
                        current = current.getRight();
                    } else if ((int) o < current.getData()) {
                        if (current.getLeft() == null) {
                            current.setLeft(node);
                            break;
                        }
                        current = current.getLeft();
                    }
                }
            }
            size++;
            return true;
        }
    }

    // рекурсивная реализация добавления элемента
    public boolean addRecursion(Object o) {
        head = recursionAdd(o, head);
        size++;
        return true;
    }

    private Node recursionAdd(Object o, Node node) {
        if (o == null || !(o instanceof Integer) || node == null) {
            return new Node((int) o, null, null);
        }
        if ((int) o > node.getData()) {
            node.setRight(recursionAdd(o, node.getRight()));
        } else if ((int) o < node.getData()) {
            node.setLeft(recursionAdd(o, node.getLeft()));
        }
        else {
            return node;
        }
        return node;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    // вместо toString, реализован прямой обход дерева
    public void printPreorder() {
        nlr(head);
    }

    private void nlr(Node node) {
        if (node != null) {
            System.out.println(node.getData());
            nlr(node.getLeft());
            nlr(node.getRight());
        }
    }

    // центрированный обход
    public void printInorder() {
        lnr(head);
    }

    private void lnr(Node node) {
        if (node != null) {
            lnr(node.getLeft());
            System.out.println(node.getData());
            lnr(node.getRight());
        }
    }

    //---

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            return false;
        } else {
            //size--;
            return true;
        }
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    //---

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

}
