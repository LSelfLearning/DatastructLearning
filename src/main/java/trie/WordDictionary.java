package trie;

/// Leetcode 211. Add and Search Word - Data structure design
/// https://leetcode.com/problems/add-and-search-word-data-structure-design/description/

import java.util.HashMap;

public class WordDictionary {
    private Node root;
    private int size;

    public WordDictionary() {
        root = new Node();
    }

    private static class Node {
        public boolean isWord;
        public HashMap<Character, Node> next = new HashMap<>();

        public Node(boolean isWord) {
            this.isWord = isWord;
        }

        public Node() {
            this(false);
        }
    }

    public void addWord(String word) {
        addWord(root, word, 0);
    }

    private void addWord(Node node, String word, int index) {
        if (index == word.length()) {
            if (!node.isWord) {
                node.isWord = true;
                size++;
            }
            return;
        }
        char c = word.charAt(index);
        if (node.next.get(c) == null) {
            node.next.put(c, new Node());
        }
        addWord(node.next.get(c), word, ++index);
    }

    public boolean search(String word) {
        return search(root, word, 0);
    }

    private boolean search(Node node, String word, int index) {
        if (index == word.length())
            return node.isWord;
        char c = word.charAt(index);
        if (c != '.') {
            if (node.next.get(c) == null)
                return false;
            return search(node.next.get(c), word, ++index);
        } else {
            for (char c1 : node.next.keySet()) {
                if (search(node.next.get(c1), word, ++index))
                    return true;
            }
            return false;
        }
    }
}
