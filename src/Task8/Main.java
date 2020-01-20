package Task8;

public class Main {
    public static void main(String[] args) {

        ArrayObject arr = new ArrayObject();
        arr.add(1);
        arr.add(2);
        arr.add(2);
        System.out.println(arr);
        arr.remove(2);
        System.out.println(arr);
        arr.remove(2);
        System.out.println(arr);
    }
}
