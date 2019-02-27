package leetcode.linkedlist;

import common.Logger;

import java.util.Random;

public class Solution {

    public static ListNode generateLinkedList() {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        Random random = new Random();
        for (int i = 1; i < 10; i++) {
            cur.next = new ListNode(random.nextInt(3));
            cur = cur.next;

        }
        return head;
    }

    public static ListNode removeElements(ListNode head, int val) {
        //1.删除头结点情况
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }
        if (head == null)
            return head;
        //2.删除普通节点
        ListNode pre = head;
        while (pre.next != null) {
            if (pre.next.val == val) {
                ListNode delNode = pre.next;
                pre.next = delNode.next;
                delNode.next = null;
            } else {
                pre = pre.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = generateLinkedList();
        Logger.log(listNode);
        Logger.log(removeElements(listNode, 1));
    }
}
