package CircularSinglyLinkedList.CircularSinglyLLPackage;

//Circular Singly Linked List Test Classes
//if you want cleaner code, import "java.lang.System.out" function
//try it!

import static java.lang.System.out;

public class TestMain_CircularSinglyLL {
    public static void main(String[] args) throws Exception{
        TestFunctions_CircularSinglyLL list = new TestFunctions_CircularSinglyLL();

        list.insertBeginning(2);
        list.insertBeginning(4);
        list.insertBeginning(6);
        list.insertBeginning(8);
        list.insertBeginning(10);
        out.println("List after INSERTING NODES AT THE BEGINNING of the list");
        list.display();
        out.println();

        list.insertEnd(3);
        list.insertEnd(6);
        list.insertEnd(9);
        out.println("\nList after INSERTING NODES AT THE END of the list");
        list.display();
        out.println();

        list.insertBefore(200, 6);
        out.println("\nList after INSERTING A NODE BEFORE A GIVEN NODE of the list");
        list.display();
        out.println();

        list.insertAfter(7, 200);
        out.println("\nList after INSERTING A NODE AFTER A GIVEN NODE of the list");
        list.display();
        out.println();

        out.println("\nAfter DELETING A NODE AT THE END of the list");
        list.deleteEnd();
        list.display();
        out.println();

        out.println("\nAfter DELETING A NODE AT THE BEGINNING of the list");
        list.deleteBeginning();
        list.display();
        out.println();


        out.println("\nAfter DELETING A GIVEN NODE of the list");
        list.deleteGiven(9);
        list.display();
    }
}
