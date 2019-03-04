import common.Logger;
import linkedlist.LinkedList;
import stack.LinkedListStack;

public class Console {

    private static void linkedListTest(){
        LinkedList<String> list = new LinkedList<>();
        list.add(0,"h");
        list.add(1,"e");
        list.add(2,"l");
        list.addFirst("w");
        list.addLast("a");
        Logger.log(list);

        Logger.log(list.get(1));
//
//        list.set(0,"h");
//        Logger.log(list);
//
//        list.set(4,"i");
//        Logger.log(list);
//
//        Logger.log(list.contains("z"));

//        Logger.log(list);
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



        Logger.log(linkedListStack);

//        Logger.log(linkedListStack.pop());
//        Logger.log(linkedListStack.pop());
//        Logger.log(linkedListStack.pop());
//        Logger.log(linkedListStack.pop());
//
//        Logger.log(linkedListStack);
//        Logger.log(linkedListStack.peek());
//        Logger.log(linkedListStack.peek());
//        Logger.log(linkedListStack);
    }

    public static void main(String[] args) {
//            linkedListTest();
        stackTest();
    }
}
