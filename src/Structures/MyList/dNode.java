package Structures.MyList;

public class dNode<T> extends Node {

    private Node prev;

    public dNode(T value) {
        super(value);
        this.prev = null;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
