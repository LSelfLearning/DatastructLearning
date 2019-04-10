package linkedlist;


import java.util.Stack;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Leetcode {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        Stack<ListNode> stack = new Stack();
        ListNode cur = head;
        ListNode newListNode = null;
        while (cur != null) {
            stack.add(cur);
            cur = cur.next;
        }
        newListNode = stack.peek();
        while (!stack.isEmpty()) {
            ListNode pop = stack.pop();
            if (!stack.isEmpty())
                pop.next = stack.peek();
            else
                pop.next = null;
        }
        return newListNode;
    }
}
