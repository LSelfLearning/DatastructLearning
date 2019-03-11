package bst;


import common.Logger;

public class BST<T extends Comparable<T>> {
    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T val) {
        root = add(root, val);
    }

    /**
     * 返回添加元素后的根节点
     */
    private Node add(Node node, T val) {
        if (node == null) {
            size++;
            return new Node(val);
        }
        if (val.compareTo(node.val) > 0)
            node.right = add(node.right, val);
        else if (val.compareTo(node.val) < 0)
            node.left = add(node.left, val);
        return node;
    }

    public boolean contains(T val) {
        return contains(root, val);
    }

    private boolean contains(Node node, T val) {
        if (node == null)
            return false;
        if (val.compareTo(node.val) == 0)
            return true;
        else if (val.compareTo(node.val) > 0)
            return contains(node.right, val);
        else
            return contains(node.left, val);
    }

    /**
     * 获取最大值
     *
     * @return
     */
    public T maxMum() {
        if (isEmpty())
            throw new RuntimeException("Empty BST");
        Node maxNode = maxMum(root);
        return maxNode.val;
    }

    private Node maxMum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maxMum(node.right);
    }

    /**
     * 获取最小值
     *
     * @return
     */
    public T minMum() {
        if (isEmpty())
            throw new RuntimeException("Empty BST");
        Node minNode = minMum(root);
        return minNode.val;
    }

    private Node minMum(Node node) {
        if (node.left == null)
            return node;
        return minMum(node.left);
    }

    /**
     * 删除最小值
     *
     * @return
     */
    public T removeMinimum() {
        T val = minMum();
        root = removeMinimum(root);
        return val;
    }

    private Node removeMinimum(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMinimum(node.left);
        return node;

    }

    /**
     * 删除最大值
     *
     * @return
     */
    public T removeMaximum() {
        T val = maxMum();
        root = removeMaxmum(root);
        return val;
    }

    private Node removeMaxmum(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMaxmum(node.right);
        return node;
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        StringBuilder res = new StringBuilder();
        res.append("BST preOrder:   ");
        preOrder(root, res);
        Logger.logln(res.toString());
    }

    private void preOrder(Node node, StringBuilder res) {
        if (node == null)
            return;
        res.append(node.val + "   ");
        preOrder(node.left, res);
        preOrder(node.right, res);
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        StringBuilder res = new StringBuilder();
        res.append("BST inOrder:   ");
        inOrder(root, res);
        Logger.logln(res.toString());
    }

    private void inOrder(Node node, StringBuilder res) {
        if (node == null)
            return;
        inOrder(node.left, res);
        res.append(node.val + "   ");
        inOrder(node.right, res);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBstStr(root, 0, res);
        return res.toString();
    }


    private void generateBstStr(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthPrefix(depth) + "NULL" + '\n');
        } else {
            res.append(generateDepthPrefix(depth) + node.val + '\n');
            depth++;
            generateBstStr(node.left, depth, res);
            generateBstStr(node.right, depth, res);
        }
    }

    private String generateDepthPrefix(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++)
            res.append("--");
        return res.toString();
    }

    private class Node {
        public T val;
        public Node left, right;

        public Node(T val) {
            this.val = val;
            left = null;
            right = null;
        }

    }
}
