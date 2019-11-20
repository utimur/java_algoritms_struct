package Algoritms;

import java.util.*;


public class Algs {
    static int n ;
    static int[] a;
    static boolean[] used;
    static int m ;

    public static void main(String[] args) {
        int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix2 = {{5,6,7},{7,8,9},{10,11,12}};
        matrixOutput(matrix1);
        matrixOutput(matrix2);
        System.out.println(solveSuperMarketQueue(new int[]{2, 2, 3, 3, 4, 4}, 2));
    }

    public static int solveSuperMarketQueue(int[] customers, int n) {
        if(customers.length == 0 || n==0) return 0;
        if(customers.length == 1) return customers[0];
        if (n > customers.length) {
            int max = 0;
            for (int i = 0; i < customers.length; i++) {
                if (customers[i] > max) {
                    max = customers[i];
                }
            }
            return max;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < customers.length; i++) {
            queue.add(customers[i]);
        }
        int[] cassa = new int[n];
        for (int i = 0; i < cassa.length; i++) {
            cassa[i] = queue.remove();
        }
        int time = 0;
        int index = 0;
        while (index != customers.length) {
            for (int i = 0; i < cassa.length; i++) {
                cassa[i] = cassa[i]-1;
                if (cassa[i] == 0) {
                    index++;
                    if (!queue.isEmpty()) {
                        cassa[i] = queue.remove();
                    }
                }
            }
            time++;
        }
        return time;
    }

    static String toCamelCase(String s){
        if(s.isEmpty()) return "";
        String str = String.valueOf(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '-' || s.charAt(i) == '_') {

            } else {
                if (s.charAt(i - 1) == '-' || s.charAt(i - 1) == '_') {
                    str += String.valueOf(s.charAt(i)).toUpperCase();
                } else {
                    str += s.charAt(i);
                }
            }
        }
        return str;
    }
    public static int febonachi(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n-1];
    }

    public static long nextBiggerNumber(long n)
    {
        List<Long> split = longSplit(n);
        for (int i = split.size() - 1; i > 0; i--) {
            if (split.get(i - 1) < split.get(i)) {
                Collections.swap(split,i-1,i);
                break;
            }
        }
        long res = 0;
        for (int i = 0; i < split.size(); i++) {
            res += split.get(i);
            res *=10;
        }
        res /= 10;
        System.out.println(res);
        return n;
    }

    public static List longSplit(long n) {
        ArrayList<Long> arr = new ArrayList<>();
        long i = n-1;
        while (n > 0) {
            arr.add(n % 10);
            n/=10;
        }
        Collections.reverse(arr);
        return arr;
    }

    public static int[][] multMatrix(int[][] matrix1, int[][] matrix2) {
        if(matrix1.length == 0 || matrix2.length == 0) return new int[0][0];
        if(matrix1[0].length != matrix2.length) return new int[0][0];
        int[][] result = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                for (int k = 0; k < matrix2[0].length; k++) {
                    result[i][k] += matrix1[i][j] * matrix2[j][k];
                }
            }
        }
        return result;
    }

    public static void matrixOutput(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("----------");
    }

    public static boolean bracketsEquals(char br, char br2) {
        if (br == '(' && br2 == ')') {
            return true;
        }
        if (br == '{' && br2 == '}') {
            return true;
        }
        if (br == '[' && br2 == ']') {
            return true;
        }
        return false;
    }
    public static boolean validBrackets(String brackets) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < brackets.length(); i++) {
            if (brackets.charAt(i) == '(' || brackets.charAt(i) == '[' || brackets.charAt(i) == '{') {
                stack.push(brackets.charAt(i));
            } else {
                if(!stack.isEmpty()) {
                    if (bracketsEquals(stack.peek(), brackets.charAt(i))) {
                        stack.pop();
                    } else return false;
                } else return false;
            }
        }
        return stack.isEmpty();
    }

    public static void rec(int index) {
        if (index == n) {
            out();
            return;
        }
        for (int i = 0; i < n; i++) {
            a[index] = i;
            rec(index+1);
        }
    }

    public static void perest(int index) {
        if (index == n) {
            out();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }
            a[index] = i;
            used[i] = true;
            perest(index + 1);
            used[i] = false;
        }
    }
    private static void out() {
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }
}
