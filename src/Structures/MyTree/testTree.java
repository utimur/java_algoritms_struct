package Structures.MyTree;

public class testTree {
    public static void main(String[] args) {
        BinnaryTree binnaryTree = new BinnaryTree();
        binnaryTree.add(5);
        binnaryTree.add(7);
        binnaryTree.add(1);
        binnaryTree.add(1);
        binnaryTree.add(4);
        binnaryTree.add(2);
        binnaryTree.add(7);
        binnaryTree.add(6);
        binnaryTree.print(binnaryTree.getRoot());
        System.out.println(binnaryTree.contain(66));
    }
}
