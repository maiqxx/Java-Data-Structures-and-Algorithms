package Stack.ApplicationsOfStackPackage.InfixToPrefixConversion;

// Write a program to convert an infix expression to a prefix expression.

import java.util.Scanner;

public class InfixToPrefixConversionStack {
    static int COUNT;
    public static String convert(String inp) {

        String str = reverse(inp);
        str = reverseBrackets(str);
        String ans = "";
        char[] stack = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (priority(c) > 0) {
                while (!isEmpty(stack) &&
                        priority(peek(stack)) >= priority(c)) {
                    ans += pop(stack);
                }
                push(stack, c);
            } else if (c == ')' && COUNT > 0) {
                char x = pop(stack);
                while (x != '(') {
                    ans += x;
                    x = pop(stack);
                }
            } else if (c == '(') {
                push(stack, c);
            } else {
                ans += c;
            }
        }

        for (int i = 0; i <= size(stack); i++) {
            ans += pop(stack);
        }
        String result = reverse(ans);
        return result;
    }

    public static int size(char[] stack) {
        return COUNT;
    }

    public static void push(char[] stack, char c) {
        COUNT++;
        stack[COUNT - 1] = c;
    }

    public static char pop(char[] stack) {
        char ch = stack[COUNT - 1];
        COUNT--;
        return (ch);
    }

    public static char peek(char[] stack) {
        if (size(stack) == 0)
            return 0;
        else
            return stack[size(stack) - 1];
    }

    public static boolean isEmpty(char[] stack) {
        if (COUNT == 0)
            return true;
        else
            return false;
    }

    public static int priority(char c) {
        switch (c) {
            case '+':
                return 1;
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 2;
            case '%':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    public static String reverse(String inp) {
        String result = "";
        for (int i = inp.length() - 1; i >= 0; i--) {
            result += inp.charAt(i);
        }
        return result;
    }

    public static String reverseBrackets(String str) {
        String rev = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(')
                rev += ")";
            else if (c == ')')
                rev += "(";
            else
                rev += c;
        }
        return rev;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter your Infix Expression");
        String exp = scn.next();
        System.out.println("Infix Expression: " + exp);
        System.out.println("Prefix Expression: " + convert(exp));
    }
}
