package Stack.Activity3;

/*
 * A stack application that converts an infix to prefix,
 * and infix to post fix.
 * */

import java.util.*;
import static java.lang.System.out;
import java.util.Stack;

public class Main_Stack {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws Exception{
        Functions_Stack s = new Functions_Stack();
        String exp;

        out.print("Enter an Infix Expression : ");
        exp = input.nextLine();

        //checks the parenthesis
        isBalanced(exp);

        //remove spaces from the string expression
        exp = exp.replaceAll("\\s", "");

        //push data to stack
        for(int x = 0; x < exp.length(); x++){
            s.push(exp.charAt(x));
        }

        out.println();
        out.print("Infix Expression : " + exp);

        out.println();
        out.print("\nPrefix Expression : " + prefixConversion(exp));
        out.print("\nPostfix Expression : " + postfixConversion(exp));
        out.println();

    }

    //Method that checks the parenthesis if pair
    public static boolean isPair(char c1, char c2){
        if (c1 == '(' && c2 == ')') {
            return true;
        }else if (c1 == '{' && c2 == '}') {
            return true;
        }else if (c1 == '[' && c2 == ']') {
            return true;
        }else {
            return false;
        }
    }

    //Method that checks if parenthesis is balanced
    public static boolean isBalanced(String exp) throws Exception{
        Stack s = new Stack();
        for (int x = 0; x < exp.length(); x++) {

            //if the current bracket is an open bracket, push to stack
            if (exp.charAt(x) == '{' || exp.charAt(x) == '(' || exp.charAt(x) == '[') {
                s.push(exp.charAt(x));
            }

            //if the current bracket is a matching closing bracket , pop from stack
            if (exp.charAt(x) == '}' || exp.charAt(x) == ')' || exp.charAt(x) == ']') {
                if (s.isEmpty()) {
                    return false;
                } else if (!isPair((Character) s.pop(), exp.charAt(x))) {
                    return false;
                }
            }
        }

        //if stack is empty, then parenthesis is balanced
        if (s.isEmpty())
            return true;
        else {
            return false;
        }
    }


    //Method that determines the precedence
    // level of the operators in an expression.
    public static int priority(char x){

        switch (x){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            case '^':
                return 3;
            default:
                return -1;

        }
    }

    //Method that converts infix expression to prefix expression
    public static String prefixConversion(String infix) throws Exception{
        String prefix = "";
        Stack<Character> s = new Stack<>();

        for (int i = infix.length() - 1; i >= 0; --i) {
            char c = infix.charAt(i);   //current character

            //checks the precedence level of the operators to evaluate first
            if (priority(c) > 0) {
                while (s.isEmpty() == false &&  priority(s.peek()) > priority(c)) {
                    prefix += s.pop();
                }
                s.push(c);
            } else if (c == '(') {

                char x = s.pop();
                while (x != ')') {
                    prefix += x;
                    x = s.pop();
                }

            } else if (c == ')') {
                s.push(c);
            } else {
                prefix += c;
            }

        }

        while (!s.isEmpty()) {
            prefix += s.pop();
        }

        //reverse the prefix expression
        String reversedPrefix = "";
        for (int i = prefix.length() - 1; i >= 0; i--) {
            reversedPrefix += prefix.charAt(i);
        }
        return reversedPrefix;
    }



    //Method that converts infix expression to postfix expression
    public static String postfixConversion(String infix) {
        String postfix = "";
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);   //current character

            //checks the precedence level of the operators to evaluate first
            if (priority(c) > 0) {

                //while stack is not empty and
                // the current character is compared to the priority operator
                while (s.isEmpty() == false &&  priority(s.peek()) >= priority(c)) {
                    postfix += s.pop();
                }
                s.push(c);
            } else if (c == ')') {

                char x = s.pop();
                while (x != '(') {
                    postfix += x;
                    x = s.pop();
                }

            } else if (c == '(') {
                s.push(c);
            } else {
                postfix += c;
            }
        }

        while (!s.isEmpty()) {
            postfix += s.pop();
        }
        return postfix;
    }
}
