package leetcode.linkedlist;


import common.Logger;

import java.util.Random;

public class Solution2 {

    public static ListNode generateLinkedList() {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        Random random = new Random();
        for (int i = 1; i < 10; i++) {
            cur.next = new ListNode(random.nextInt(3));
            cur = cur.next;
        }
        return head;
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode pre = dummyHead;

        while (pre.next != null) {
            if (pre.next.val == val) {
                ListNode delNode = pre.next;
                pre.next = delNode.next;
                delNode.next = null;
            } else {
                pre = pre.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode = generateLinkedList();
        Logger.log(listNode);
        Logger.log(removeElements(listNode, 1));
    }
}
