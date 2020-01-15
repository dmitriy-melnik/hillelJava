package Task10;

public class Main {
    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList();

        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("LinkedList: [ " + list + " ]");
        System.out.println("Size: " + list.size());
        System.out.println("Contains 2: " + list.contains(2));
        list.remove(2);
        System.out.println("LinkedList after delete 2: [ " + list + " ]; size = " + list.size());
        list.remove(3);
        System.out.println("LinkedList after delete 3: [ " + list + " ]; size = " + list.size());
        list.remove(1);
        System.out.println("LinkedList after delete 1: [ " + list + " ]; size = " + list.size());
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        System.out.println(list);

    }
}
