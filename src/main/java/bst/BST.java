package bst;


import java.util.ArrayList;
import java.util.List;

public class BST<E extends Comparable<E>> {

    private Node root;
    private int size = 0;

    private class Node {
        public E val;
        public Node left, right;

        public Node(E val) {
            this.val = val;
            left = null;
            right = null;
        }

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.val) > 0) {
            node.right = add(node.right, e);
        } else if (e.compareTo(node.val) < 0) {
            node.left = add(node.left, e);
        }
        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.val) > 0) {
            return contains(node.right, e);
        } else if (e.compareTo(node.val) < 0) {
            return contains(node.left, e);
        } else {
            return true;
        }

    }

    public List<E> preOrder() {
        List<E> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }

    private void preOrder(Node node, List<E> list) {
        if (node == null)
            return;
        list.add(node.val);
        preOrder(node.left, list);
        preOrder(node.right, list);
    }

    public List<E> inOrder() {
        List<E> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }

    private void inOrder(Node node, List<E> list) {
        if (node == null)
            return;
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }

    public List<E> postOrder() {
        List<E> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }

    private void postOrder(Node node, List<E> list) {
        if (node == null)
            return;
        postOrder(node.left, list);
        postOrder(node.right, list);
        list.add(node.val);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateStr(root, 0, res);
        return res.toString();
    }

    private void generateStr(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthSymbol(depth) + "Null" + "\n");
            return;
        }
        res.append(generateDepthSymbol(depth));
        res.append(node.val);
        res.append("\n");
        depth++;
        generateStr(node.left, depth, res);
        generateStr(node.right, depth, res);
    }

    private String generateDepthSymbol(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= depth; i++)
            sb.append("--");
        return sb.append(">").toString();
    }

    public E maximum() {
        if (root == null)
            return null;
        return maximum(root).val;
    }

    private Node maximum(Node node) {
        if (node.right == null)
            return node;
        return maximum(node.right);
    }

    public E minimum() {
        if (root == null)
            return null;
        return minimum(root).val;
    }

    private Node minimum(Node node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }


    public E removeMax() {
        if (root == null)
            return null;
        E maximum = maximum();
        root = removeMax(root);
        return maximum;
    }

    /**
     * 删除以node为根节点的bst中的最大值，返回删除元素后bst的root
     */
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public E removeMin() {
        if (root == null)
            return null;
        E minimum = minimum();
        root = removeMin(root);
        return minimum;
    }

    /**
     * 删除以node为节点的bst中的最小值，返回删除元素后bst的root
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    /**
     * 删除以node为根节点的bst中的val，返回删除后bst的root
     */
    private Node remove(Node node, E e) {
        if (node == null)
            return null;

        if (e.compareTo(node.val) > 0) {
            node.right = remove(node.right, e);
        } else if (e.compareTo(node.val) < 0) {
            node.left = remove(node.left, e);
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            Node successorNode = minimum(node.right);
            successorNode.right = removeMin(node.right);
            successorNode.left = node.left;
            node.left = node.right = null;
            return successorNode;

        }
        return node;
    }

}
