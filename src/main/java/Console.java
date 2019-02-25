import common.Logger;
import queue.LoopQueue;

public class Console {
    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>(5);
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            Logger.log(queue);
        }
    }
}
