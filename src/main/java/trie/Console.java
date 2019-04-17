package trie;

import common.Logger;

public class Console {
    public static void main(String[] args){
        Trie trie = new Trie();
        trie.add("hello");
        trie.add("World");

        Logger.logln(trie.contains("hllo"));

        Logger.logln(trie.isPrefix("he"));

        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("test");
        wordDictionary.addWord("dd");

        Logger.logln(wordDictionary.search("tet"));
    }
}
