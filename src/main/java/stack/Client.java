package stack;


import common.Logger;

public class Client {
    public static void main(String[] args){
        QueueStack<String> stack = new QueueStack<>();

        stack.push("o");
        stack.push("l");
        stack.push("l");
        stack.push("e");
        stack.push("h");

        stack.pop();
        stack.pop();

        stack.push("1");

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        Logger.logln(sb);

    }
}
