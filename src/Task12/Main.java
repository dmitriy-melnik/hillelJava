package Task12;

import sun.reflect.generics.tree.Tree;

import java.util.Comparator;
import java.util.TreeSet;

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
        /*bin.add(10);
        bin.add(7);
        bin.add(15);
        bin.add(5);
        bin.add(9);
        bin.add(11);
        bin.add(14);*/
        bin.add("hello");
        bin.add("world");
        bin.add("mile");
        bin.add("random");
        bin.add("by");

        bin.printPreorder();
        System.out.println();
        bin.printInorder();
        System.out.println();

        /*System.out.println("Contains 5: " + bin.contains(5));
        System.out.println("Contains 234: " + bin.contains(234));
        System.out.println("Contains (recursion) 11: " + bin.containsRecursion(11));
        System.out.println("Contains (recursion) 67: " + bin.containsRecursion(67));
        System.out.println("Contains hello: " + bin.contains("hello"));

        TestForCompare t1 = new TestForCompare(6);
        TestForCompare t2 = new TestForCompare(7);
        TestForCompare t3 = new TestForCompare(2);
        SetImpl bin2 = new SetImpl((o1, o2) -> {
            if (o1 instanceof TestForCompare && o2 instanceof TestForCompare) {
                return ((TestForCompare) o1).getX() - ((TestForCompare) o2).getX();
            }
            return 0;
        });
        bin2.add(t1);
        bin2.add(t2);
        bin2.add(t3);

        System.out.println("\n");
        bin2.printPreorder();
        System.out.println();
        bin2.printInorder();
        System.out.println();*/
    }
}
