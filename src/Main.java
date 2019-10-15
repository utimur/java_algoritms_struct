import Structures.MyList.Node;
import Structures.MyList.SingleLinkedList;

public class Main {

    public static void main(String[] args) {
        SingleLinkedList myList = new SingleLinkedList();
        myList.push(5);
        myList.push(2);
        myList.push(1);
        myList.push(4);
        myList.push(8);
        myList.push(7);
        myList.push(9);
        myList.push(0);
        myList.printAll();
        System.out.println("----");
        myList.addToStart(7);
        myList.addToStart(7);
        myList.printAll();
    }
}
