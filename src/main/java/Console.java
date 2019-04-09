import bst.BST;
import common.Logger;
import linkedlist.LinkedList;
import stack.LinkedListStack;

public class Console {

    private static void linkedListTest() {
        LinkedList<String> list = new LinkedList<>();
        list.add(0, "h");
        list.add(1, "e");
        list.add(2, "l");
        list.addFirst("w");
        list.addLast("a");
        Logger.logln(list);

        list.removeElement("e");

        Logger.logln(list);
//        Logger.logln(list.get(1));
//
//        list.set(0,"h");
//        Logger.logln(list);
//
//        list.set(4,"i");
//        Logger.logln(list);
//
//        Logger.logln(list.contains("z"));

//        Logger.logln(list);
    }

    private static void stackTest() {
        LinkedListStack<String> linkedListStack = new LinkedListStack<>();
        linkedListStack.push("o");
        linkedListStack.push("l");
        linkedListStack.push("l");
        linkedListStack.push("e");
        linkedListStack.push("h");
        linkedListStack.push("k");
        linkedListStack.push("c");
        linkedListStack.push("u");
        linkedListStack.push("f");


        Logger.logln(linkedListStack);

//        Logger.logln(linkedListStack.pop());
//        Logger.logln(linkedListStack.pop());
//        Logger.logln(linkedListStack.pop());
//        Logger.logln(linkedListStack.pop());
//
//        Logger.logln(linkedListStack);
//        Logger.logln(linkedListStack.peek());
//        Logger.logln(linkedListStack.peek());
//        Logger.logln(linkedListStack);
    }

    private static void BstTest() {
        BST<Integer> bst = new BST<Integer>();
        int[] arr = {17, 19, 3, 5, 34, 2, 1, 89};
        for (int ele : arr) {
            bst.add(ele);
        }
//        bst.preOrder();
        bst.inOrder();

//        bst.removeMinimum();
//        bst.removeMaximum();
//        bst.remove(1);
//        bst.remove(89);
        bst.remove(5);
        bst.inOrder();
//        Logger.logln(bst.contains(7));
//        Logger.logln(bst);
    }

    public static void linklistTest(){
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(10);
        Logger.logln(list);
    }

    public static void main(String[] args) {

//            linkedListTest();
//        stackTest();
//        BstTest();
    }
}
