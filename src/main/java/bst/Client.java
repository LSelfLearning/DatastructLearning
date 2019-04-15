package bst;

import common.Logger;

public class Client {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);

//        Logger.logln(tree.inOrder());
//        Logger.logln(tree.removeMin());

        tree.remove(5);
        Logger.logln(tree.inOrder());

    }
}
