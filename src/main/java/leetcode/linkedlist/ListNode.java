package leetcode.linkedlist;


public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        ListNode cur = this;
        StringBuilder sb = new StringBuilder();
        sb.append("ListNode    ");
        while (cur != null) {
            sb.append(cur.val+"->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}
