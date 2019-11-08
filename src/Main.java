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

        for (Integer i:arr) {
            System.out.println(i);
        }
    }
}