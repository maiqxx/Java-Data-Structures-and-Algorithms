package DoublyLinkedList.DoublyLLTestPackage;

import static java.lang.System.out;

public class TestMain_DoublyLL {
    public static void main(String[] args)throws Exception{
        TestFunctions_DoublyLL list = new TestFunctions_DoublyLL();

        list.insertBeginning(-2);
        list.insertBeginning(4);
        list.insertBeginning(6);
        list.insertBeginning(8);
        list.insertBeginning(10);
        list.insertBeginning(12);
        out.println("\nAfter inserting number(s) at the beginning of the list");
        list.display();

        out.println("\nTotal number of nodes : " + list.countNodes());
        //out.println("\nTotal number of even and odd numbers " + );

        list.insertEnd(3);
        list.insertEnd(7);
        out.println("\nAfter inserting number(s) at the end of the list");
        list.display();
        list.countOddEven();
        out.println();

        out.println("\nInserting a node after the given node");
        list.insertAfter(14, 3);
        out.println("\nTotal number of nodes : " + list.countNodes());
        list.display();

        out.println("\nInserting a node before the given node");
        list.insertBefore(500, 7);
        out.println("\nTotal number of nodes : " + list.countNodes());
        list.display();

        out.println("\nAfter deleting a given node");
        list.deleteGivenNode(6);
        out.println("\nTotal number of nodes : " + list.countNodes());
        list.display();

        out.println("\nAfter deleting the first node");
        list.deleteBeginning();
        out.println("\nTotal number of nodes : " + list.countNodes());
        list.display();

        out.println("\nAfter deleting the last node");
        list.deleteEnd();
        out.println("\nTotal number of nodes : " + list.countNodes());
        list.display();

        out.println("\nAfter deleting the node before the given node");
        list.deleteBeforeGivenNode(4);
        list.display();

        out.println("\nNodes in reverse order" );
        list.displayReverse();

        out.println();
        list.countPosNeg();

    }
}
