package Task12;

public class Main {
    public static void main(String[] args) {

        /* протестировано на дереве:
                      __ 10 __
                    /         \
                   7          15
                /     \     /
               5       9   11
                              \
                               14
         */
        SetImpl bin = new SetImpl();
        bin.add(10);
        bin.add(7);
        bin.add(15);
        bin.add(5);
        bin.add(9);
        bin.add(11);
        bin.add(14);

        bin.printPreorder();
        System.out.println();
        bin.printInorder();
        System.out.println();

        System.out.println("Contains 5: " + bin.contains(5));
        System.out.println("Contains 234: " + bin.contains(234));
        System.out.println("Contains (recursion) 11: " + bin.containsRecursion(11));
        System.out.println("Contains (recursion) 67: " + bin.containsRecursion(67));

        SetImpl bin2 = new SetImpl();
        bin2.addRecursion(10);
        bin2.addRecursion(7);
        bin2.addRecursion(15);
        bin2.addRecursion(5);
        bin2.addRecursion(9);
        bin2.addRecursion(11);
        bin2.addRecursion(14);

        System.out.println("\nAfter add recursively: ");
        bin2.printPreorder();
        System.out.println();
        bin2.printInorder();
        System.out.println();
    }
}
