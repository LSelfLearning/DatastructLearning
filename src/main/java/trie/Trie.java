package trie;

import java.util.HashMap;

public class Trie {
    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    public int size() {
        return size;
    }

    private class Node {
        public boolean isWord;
        public HashMap<Character, Node> next = new HashMap<>();

        public Node(boolean isWord) {
            this.isWord = isWord;
        }

        public Node() {
            this(false);
        }
    }

    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    public boolean contains(String word) {
        return contains(root, word, 0);
    }

    private boolean contains(Node node, String word, int index) {
        if (node == null) {
            return false;
        } else if (index == word.length()) {
            return node.isWord;
        }
        char c = word.charAt(index);
        return contains(node.next.get(c), word, ++index);
    }

    public boolean isPrefix(String prefix) {
        return isPrefix(root, prefix, 0);
    }

    private boolean isPrefix(Node node, String prefix, int index) {
        if (node == null) {
            return false;
        } else if (index == prefix.length()) {
            return true;
        }
        char c = prefix.charAt(index);
        return isPrefix(node.next.get(c), prefix, ++index);
    }
}
