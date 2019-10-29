package Algoritms;

import java.util.ArrayList;
import java.util.Stack;

public class Algs {
    static int n ;
    static int[] a;
    static boolean[] used;
    static int m ;

    public static void main(String[] args) {
        n = 4;
        m = 3;
        a = new int[n];
        used = new boolean[n+1];

        System.out.println(validBrackets("([)]"));
        perest(0);
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
