import Structures.MyList.MyArrayList;

import java.io.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = new ArrayList<>();
        List<String> arr2 = new ArrayList<>();
        Collections.addAll(arr,5,5,4,3,1,0,6,8,1,2,5,5,5,5);
        List<Integer> arrayList = arr.stream().filter((x)->x==5).collect(Collectors.toList());
        System.out.println(arrayList);

        MyArrayList myArrayList = new MyArrayList();
        myArrayList.push(5);
        myArrayList.push(2);
        myArrayList.push(2);
        myArrayList.push(22);
        myArrayList.push(25);
        myArrayList.push(22);
        myArrayList.clear();
        myArrayList.push(4);
        myArrayList.printAll();
    }
}