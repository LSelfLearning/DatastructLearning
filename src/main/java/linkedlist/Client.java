package linkedlist;

import common.Logger;

public class Client {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList();
        Logger.logTag("add(int index, E e) Test");
        list.add(0, "0");
        list.add(0, "l");
        list.add(0, "3");
        list.add(0, "e");
        list.add(0, "2");
        Logger.logln(list);

        list.set(0,"h");
        list.set(2,"l");
        list.addFirst("f");
        Logger.logln(list);

        list.remove(0);
        Logger.logln(list);

        list.addLast("f");
        Logger.logln(list);

        list.removeLast();
        Logger.logln(list);

        list.removeElement("l");
        Logger.logln(list);
//
//        list.removeFirst();
//        list.removeFirst();
//        list.removeFirst();
//        list.removeFirst();
////        list.removeFirst();
//        Logger.logln(list);
//        list.addFirst("2");
//        Logger.logln(list);
//        list.addLast("3");
//        Logger.logln(list);
//
//        list.removeFirst();
//        Logger.logln(list);
//
//        list.removeLast();
//        Logger.logln(list);
//        list.remove(0);
//        Logger.logln("list.remove(0)",list);
//        list.remove(3);
//        Logger.logln("list.remove(3)",list);
    }
}
