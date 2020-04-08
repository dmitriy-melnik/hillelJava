package Task11.MyArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        MyArrayList list = new MyArrayList<String>();
        list.add(1);

        MyArrayList arr = new MyArrayList();
        arr.add(1);
        arr.add(2);
        arr.add(false);
        System.out.println(arr.indexOf(false));
        System.out.println(arr.contains(false));
        //arr.remove(false);
        arr.add(2, true);
        arr.set(0,101);
        System.out.println(arr);

        ArrayList arrayList = new ArrayList();
        arrayList.add(9);
        arrayList.add(99);
        arrayList.add(999);
        arr.addAll(3, arrayList);
        System.out.println(arr);

        arr.add(true);
        System.out.println(arr.lastIndexOf(true));

        List sublist = arr.subList(3,6);
        System.out.println(sublist);

        Iterator arrIter = arr.iterator();
        while (arrIter.hasNext()) {
            Object temp = arrIter.next();
            System.out.println(temp);
        }

        for(Object o : arr) {
            System.out.print(o + " ");
        }

    }
}
