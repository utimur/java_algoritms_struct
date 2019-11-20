import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileInputOutput {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("input.txt"));
        FileWriter fileWriter = new FileWriter("output.txt");

        String nums;
        while (scanner.hasNextLine()) {
            nums = scanner.nextLine();
            String[] strNums = nums.split(" ");
            List<Integer> arr = Arrays.stream(strNums).map((x)-> Integer.parseInt(x)).collect(Collectors.toList());
            System.out.println(arr.get(0) + arr.get(1));
        }
    }
}
