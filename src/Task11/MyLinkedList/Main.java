package Task11.MyLinkedList;

import sun.security.krb5.internal.crypto.Aes128;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        System.out.println(list);
        System.out.println(list.indexOf(6));
        System.out.println(list.lastIndexOf(2));
        System.out.println(list.contains(2));
        System.out.println(list.get(2));
        list.set(1, "two");
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        //list.add(0, true);
        //System.out.println(list);

        ArrayList l = new ArrayList();
        l.add(1);
        l.add("two");
        list.addAll(1, l);
        System.out.println(list);

        List sublist = list.subList(1, 4);
        System.out.println(sublist);
/*
        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            Object object = itr.next();
            System.out.println(object);
        }
        for (Object o : list) {
            System.out.println(o);
        }*/
    }
}
