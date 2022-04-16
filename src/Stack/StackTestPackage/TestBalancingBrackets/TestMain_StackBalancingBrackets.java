package Stack.StackTestPackage.TestBalancingBrackets;

// Java google StackOverflow for checking
// balanced brackets
// pre package in use

import java.util.*;

public class TestMain_StackBalancingBrackets {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception
    {
        //String expr = "([{}])";
        String expr;

        System.out.println("Input expression : ");
        expr = input.nextLine();

        // Function call
        if (areBracketsBalanced(expr)) {
            System.out.println("Balanced ");
        }
        else {
            System.out.println("Not Balanced ");
        }
    }


    // function to check if brackets are balanced
    static boolean areBracketsBalanced(String expr) throws Exception
    {
        // Using ArrayDeque is faster than using Stack class
        Stack<Character> stack = new Stack();

        //Stacks stack = new Stacks();

        // Traversing the Expression
        for (int i = 0; i < expr.length(); i++)
        {
            //System.out.println("[" + i + "]" + expr.charAt(i));
            // System.out.println();


            char x = expr.charAt(i);

            if (x == '(' || x == '[' || x == '{')
            {
                // Push the element in the stack
                stack.push(x);
                continue;
            }

            // If current character is not opening
            // bracket, then it must be closing. So stack
            // cannot be empty at this point.
            if (stack.isEmpty()) {
                return false;
            }
            char check;
            switch (x) {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[') {
                        return false;
                    }
                    break;

                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[') {
                        return false;
                    }
                    break;

                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{') {
                        return false;
                    }
                    break;
            }
        }

        // Check Empty Stack
        return (stack.isEmpty());
    }
}
