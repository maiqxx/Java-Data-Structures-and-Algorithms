package Stack.StackTestPackage.TestStackLinkedList;

import java.util.Scanner;

public class TestMain_StackLinkedList {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        TestFunctions_StackLinkedList s = new TestFunctions_StackLinkedList();
        boolean flag = true;
        try {
            while (flag) {
                System.out.println("\n***MENU***");
                System.out.println("1. Push");
                System.out.println("2. Pop");
                System.out.println("3. Display");
                System.out.println("4. Exit");
                System.out.println("Enter your choice: ");
                int choice = scn.nextInt();
                int item = 0;
                switch (choice) {
                    case 1:
                        System.out.println("Enter value of node: ");
                        item = scn.nextInt();
                        s.push(item);
                        System.out.println(item + " inserted successfully");
                        break;
                    case 2:
                        System.out.println(s.pop() + " deleted successfully");
                        break;
                    case 3:
                        s.display();
                        break;
                    case 4:
                        flag = false;
                        System.out.println("Terminated.....");
                        break;
                    default:
                        System.out.println("Wrong choice");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
