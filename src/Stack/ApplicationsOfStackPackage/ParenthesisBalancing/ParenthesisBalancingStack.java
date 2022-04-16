package Stack.ApplicationsOfStackPackage.ParenthesisBalancing;

// Write a program to implement parenthesis balancing.

import static java.lang.System.out;
import java.util.Scanner;

public class ParenthesisBalancingStack {
    static class Stack {
        int top = -1;

        char arr[] = new char[30];
        public void push(char x) {
            if (top == arr.length - 1)
                out.println("Stack full");
            else
                arr[++top] = x;
        }
        public char pop() {
            if (top == -1)
                out.println("Underflow error");
            else
                return arr[top--];
            return 0;
        }
        boolean isEmpty() {
            if (top == -1)
                return true;
            else
                return false;
        }
    }
    static boolean isPair(char c1, char c2) {
        if (c1 == '(' && c2 == ')')
            return true;
        else if (c1 == '{' && c2 == '}')
            return true;
        else if (c1 == '[' && c2 == ']')
            return true;
        else
            return false;
    }

    static boolean isBalanced(char exp[]) {
        Stack s = new Stack();
        for (int i = 0; i < exp.length; i++) {
            if (exp[i] == '{' || exp[i] == '(' || exp[i] == '[')
                s.push(exp[i]);
            if (exp[i] == '}' || exp[i] == ')' || exp[i] == ']') {
                if (s.isEmpty()) {
                    return false;
                } else if (!isPair(s.pop(), exp[i])) {
                    return false;
                }
            }
        }
        if (s.isEmpty())
            return true;
        else {
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        out.println("Enter the expression:");
        String input = scn.next();
        char[] exp = new char[input.length()];

        for (int i = 0; i < exp.length; i++) {
            exp[i]=input.charAt(i);
        }
        if (isBalanced(exp))
            out.println("Balanced ");
        else
            out.println("Not Balanced ");
    }
}
