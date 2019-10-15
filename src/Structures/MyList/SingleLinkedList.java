package Structures.MyList;

public class SingleLinkedList implements mList {

    Node head;
    Node tail;
    int length;

    // Constructor create and init 1 node
    public SingleLinkedList(Object value) {
        this.head = new Node(value);
        this.length = 1;
    }
    // Default constructor
    public SingleLinkedList() {
        this.length = 0;
    }


    @Override
    public void delete(int index) {
        Node x = head;
        if (x.getIndex() == index) {
            head = x.next;
            indexDecrement(x.getIndex());
            return;
        }
        while (x != null) {
            try {
                if (x.next.getIndex() == index) {
                    x.next = x.next.next;
                    indexDecrement(x.next.getIndex());
                    return;
                }
                if (x.next.getIndex() == tail.getIndex() && x.next.getIndex() == index) {
                    x.next = tail;
                    return;
                }
            } catch (NullPointerException e) {
                ;
            }

            x = x.next;
        }
    }

    @Override
    public void delete(Object object) {
        Node x = head;
        if (x.equals(object)) {
            head = x.next;
            indexDecrement(x.getIndex());
            return;
        }
        while (x != null) {
            try {
                if (x.next.equals(object)) {
                    x.next = x.next.next;
                    indexDecrement(x.next.getIndex());
                    return;
                }
                if (x.next.getIndex() == tail.getIndex() && x.next.equals(object)) {
                    x.next = tail;
                    return;
                }
            } catch (NullPointerException e) {
                ;
            }
            x = x.next;
        }
    }

    @Override
    public void push(Object obj) {
        if (length == 0) {
            head = new Node(obj);
            head.setIndex(0);
            length++;
            return;
        }
        if (length == 1) {
            tail = new Node(obj);
            tail.setIndex(1);
            head.next = tail;
            length++;
            return;
        }
        Node node = new Node(obj);
        node.setIndex(tail.getIndex());
        tail.next = node;
        tail = node;
        tail.setIndex(tail.getIndex()+1);
        length++;
    }

    @Override
    public void insert(Object obj, int index) {

    }

    @Override
    public Object pop() {
        Node x = head;
        while (!x.next.equals(tail)) {
            x = x.next;
        }
        Node tmp = tail;
        tail = x;
        tail.next = null;
        return tmp.getValue();
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public int index(Object obj) {
        Node x = head;
        while (x != null) {

            if (x.equals(obj)) {
                return x.getIndex();
            }
            x = x.next;
        }
        return -1;
    }

    @Override
    public Object find(int index) {
        Node x = head;
        while (x != null) {

            if (x.getIndex() == index) {
                return x;
            }
            x = x.next;
        }
        return false;
    }

    @Override
    public Object getHead() {
        return head;
    }

    @Override
    public Object getTail() {
        return tail;
    }

    @Override
    public void printAll() {
        if (length != 0) {
            Node x = head;
            while (x != null) {
                System.out.println(x.getValue() + " index:" + x.getIndex() );
                x = x.next;
            }
        } else System.out.println("List is empty");
    }

    private void indexDecrement(int start) {
        Node x = head;
        while (x != null) {
            if (x.getIndex() >= start) {
                x.setIndex(x.getIndex()-1);
            }
            x = x.next;
        }
    }
}
