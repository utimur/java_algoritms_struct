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
        myList.delete(5);
        myList.delete(3);
        myList.delete(0);
        System.out.println("-------------");
        myList.printAll();
        myList.delete(myList.getHead());
        System.out.println("-------------");
        myList.printAll();
        System.out.println("-------------");
        myList.printAll();
        System.out.println("-------------");
        myList.printAll();
    }
}
