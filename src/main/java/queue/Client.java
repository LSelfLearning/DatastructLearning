package queue;

import common.Logger;

public class Client {
    public static void main(String[] args){
        StackQueue<String> queue = new StackQueue<>();
        queue.enqueue("h");
        queue.enqueue("e");
        queue.enqueue("l");
        queue.enqueue("l");
        queue.enqueue("o");

        queue.dequeue();
        queue.dequeue();
        queue.enqueue("1");
        queue.enqueue("2");

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            sb.append(queue.dequeue());
        }
        Logger.logln(sb);
    }
}
