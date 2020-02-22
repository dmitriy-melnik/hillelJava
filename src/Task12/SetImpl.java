package Task12;

import java.util.*;

public class SetImpl<E> implements Set<E> {

    private Node<E> head;
    private int size = 0;
    private Comparator<E> comparator;

    public SetImpl() {
    }

    public SetImpl(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    // added ClassCastException | NullPointerException
    @Override
    public boolean contains(Object o) {
        try {
            if (comparator != null) {
                Node current = head;
                while (true) {
                    if (comparator.compare((E) o, (E) current.getData()) == 0) {
                        return true;
                    }
                    if (comparator.compare((E) o, (E)current.getData()) > 0) {
                        if (current.getRight() == null) {
                            return false;
                        }
                        current = current.getRight();
                    }
                    if (comparator.compare((E) o, (E) current.getData()) < 0) {
                        if (current.getLeft() == null) {
                            return false;
                        }
                        current = current.getLeft();
                    }
                }
            } else if (o instanceof Comparable) {
                Node current = head;
                while (true) {
                    if (((Comparable) o).compareTo(current.getData()) == 0) {
                        return true;
                    }
                    if (((Comparable) o).compareTo(current.getData()) > 0) {
                        if (current.getRight() == null) {
                            return false;
                        }
                        current = current.getRight();
                    }
                    if (((Comparable) o).compareTo(current.getData()) < 0) {
                        if (current.getLeft() == null) {
                            return false;
                        }
                        current = current.getLeft();
                    }
                }
            }
        } catch (ClassCastException | NullPointerException containsException) {
            containsException.printStackTrace();
            return false;
        }
        return false;
    }

    /*// рекурсиваная реализация поиска
    public boolean containsRecursion(Object o) {
        return recursionSearch(o, head);
    }

    private boolean recursionSearch(Object o, Node node) {
        if (o == null || !(o instanceof Comparable) || node == null) {
            return false;
        }
        if (o.equals(node.getData())) {
            return true;
        }
        if (((Comparable) o).compareTo(node.getData()) < 0) {
            return recursionSearch(o, node.getLeft());
        } else {
            return recursionSearch(o, node.getRight());
        }
    }*/

    // added NullPointerException
    @Override
    public boolean add(E e) {
        try {
            Node node = new Node(e, null, null);
            Node current = head;
            if (comparator != null) {
                if (head == null) {
                    head = node;
                } else {
                    while (true) {
                        if (comparator.compare(e, (E) current.getData()) == 0) {
                            return false;
                        }
                        if (comparator.compare(e, (E) current.getData()) > 0) {
                            if (current.getRight() == null) {
                                current.setRight(node);
                                break;
                            }
                            current = current.getRight();
                        }
                        if (comparator.compare(e, (E) current.getData()) < 0) {
                            if (current.getLeft() == null) {
                                current.setLeft(node);
                                break;
                            }
                            current = current.getLeft();
                        }
                    }
                }
            } else if (e instanceof Comparable) {
                if (head == null) {
                    head = node;
                } else {
                    while (true) {
                        if (e.equals(current.getData())) {
                            return false;
                        }
                        if (((Comparable) e).compareTo(current.getData()) > 0) {
                            if (current.getRight() == null) {
                                current.setRight(node);
                                break;
                            }
                            current = current.getRight();
                        }
                        if (((Comparable) e).compareTo(current.getData()) < 0) {
                            if (current.getLeft() == null) {
                                current.setLeft(node);
                                break;
                            }
                            current = current.getLeft();
                        }
                    }
                }
            }
            size++;
            return true;
        } catch (NullPointerException addException) {
            addException.printStackTrace();
            return false;
        }
    }


    /*// рекурсивная реализация добавления элемента
    public boolean addRecursion(Object o) {
        if (!(o instanceof Comparable) || o == null) {
            return false;
        } else {
            head = recursionAdd(o, head);
            size++;
            return true;
        }
    }

    private Node recursionAdd(Object o, Node node) {
        if (node == null || !(o instanceof Comparable)) {
            return new Node(o, null, null);
        }
        if (((Comparable) o).compareTo(node.getData()) > 0) {
            node.setRight(recursionAdd(o, node.getRight()));
        } else if (((Comparable) o).compareTo(node.getData()) < 0) {
            node.setLeft(recursionAdd(o, node.getLeft()));
        } else {
            return node;
        }
        return node;
    }*/

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

    private class Node<T> {
        private T data;
        private Node left;
        private Node right;

        public Node(T data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
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

}
