package linkedlist;

public class Node {
    public int pre;
    public int next;
    private String data;

    public Node(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
