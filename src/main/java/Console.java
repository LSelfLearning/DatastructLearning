import common.Logger;
import stack.LinkedListStack;

public class Console {

    private static void stackTest() {
        LinkedListStack<String> linkedListStack = new LinkedListStack<>();
        linkedListStack.push("o");
        linkedListStack.push("l");
        linkedListStack.push("l");
        linkedListStack.push("e");
        linkedListStack.push("h");
        linkedListStack.push("k");
        linkedListStack.push("u");
        linkedListStack.push("c");
        linkedListStack.push("f");



        Logger.log(linkedListStack);

        Logger.log(linkedListStack.pop());
        Logger.log(linkedListStack.pop());
        Logger.log(linkedListStack.pop());
        Logger.log(linkedListStack.pop());

        Logger.log(linkedListStack);
        Logger.log(linkedListStack.peek());
        Logger.log(linkedListStack.peek());
        Logger.log(linkedListStack);
    }

    public static void main(String[] args) {
//        LoopQueue<Integer> queue = new LoopQueue<>(5);
//        for (int i = 0; i < 10; i++) {
//            queue.enqueue(i);
//            Logger.log(queue);
//        }

//        LinkedList2<String> list = new LinkedList2<>();
////        list.add(0,"h");
////        list.add(1,"e");
////        list.add(2,"l");
////        list.addFirst("w");
////        list.addLast("a");
////        Logger.log(list);


//        LinkedList<String> list = new LinkedList<>();
//        list.addLast("h");
//        list.addLast("e");
//        list.addLast("l");
//        list.addLast("l");
//        list.add(0, "1");
//        list.add(2, "2");
//        Logger.log(list);
//
//        Logger.log(list.removeFirst());
//
//        Logger.log(list);
//
//        Logger.log(list.removeLast());
//
//        Logger.log(list);
//
//        Logger.log(list.remove(2));
//
//        Logger.log(list);
//        Logger.log(list.get(6));

            stackTest();
    }
}
