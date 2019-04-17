package trie;

import common.Logger;

public class Console {
    public static void main(String[] args){
        Trie trie = new Trie();
        trie.add("hello");
        trie.add("World");

        Logger.logln(trie.contains("World"));

        Logger.logln(trie.isPrefix("he"));
    }
}
