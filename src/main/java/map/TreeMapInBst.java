package map;


public class TreeMapInBst<K extends Comparable<K>, V> implements Map<K, V> {
    private Node root;
    private int size;

    public TreeMapInBst() {
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    private Node maximum(Node node) {
        if (node.right == null)
            return node;
        return maximum(node.right);
    }

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

    @Override
    public V remove(K key) {
        if (contains(key)) {
            V value = getNode(root, key).value;
            root = remove(root, key);
            return value;
        } else {
            return null;
        }
    }

    private Node remove(Node node, K key) {
        if (node == null)
            return null;

        if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
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

            Node precursor = maximum(node.left);
            precursor.left = removeMax(node.left);
            precursor.right = node.right;
            node.left = node.right = null;
            return precursor;
        }
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    /**
     * 返回Bst中以Node为根的Bst中key为给定值的节点
     */
    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) > 0) {
            return getNode(node.right, key);
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else {
            return node;
        }
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        if (node != null)
            return node.value;
        else
            return null;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(root, key);
        if (node == null)
            add(key, value);
        else
            node.value = value;

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateStr(root, res);
        return res.toString();
    }

    private void generateStr(Node node, StringBuilder res) {
        if (node == null) {
            return;
        }
        res.append("[key:" + node.key + ",value:" + node.value + "]");
        res.append("\n");
        generateStr(node.left, res);
        generateStr(node.right, res);
    }

    private class Node {
        public K key;
        public V value;
        public Node left;
        public Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
