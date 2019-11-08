package Structures.MyTree;

public class BinnaryTree implements Tree {

    private Node root;
    private int size;


    public BinnaryTree(int value) {
        this.size = 0;
        this.root = new Node(value);
        this.size++;
    }

    public BinnaryTree() {
        this.size = 0;
    }

    @Override
    public void add(int value) {
        if (size == 0) {
            this.root = new Node(value);
            this.size++;
            return;
        }
        Node iter = root;
        while (iter != null) {
            if (value >= iter.value) {
                if (iter.right == null) {
                    iter.right = new Node(value);
                    return;
                }
                iter = iter.right;
            }
            if (value < iter.value) {
                if (iter.left == null) {
                    iter.left = new Node(value);
                    return;
                }
                iter = iter.left;
            }
        }

    }

    @Override
    public void remove(int value) {

    }

    @Override
    public boolean contain(int value) {
        if(root == null) return false;
        Node node = root;
        while (node != null) {
            if(node.value == value) return true;
            if(value > node.value) node = node.right;
            if(value < node.value) node = node.left;
        }
        return false;
    }

    @Override
    public void print(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value);
        print(node.left);
        print(node.right);
    }


    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int size() {
        return size;
    }



}
class Node {
    Node left;
    Node right;
    int value;

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public Node(int value) {
        this.value = value;
    }
}