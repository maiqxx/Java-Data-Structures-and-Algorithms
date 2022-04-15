package DoublyLinkedList.DoublyLLTestPackage;

import static java.lang.System.out;

public class TestFunctions_DoublyLL {
    //Creating a Template
    public class Node{
        Node prev;
        int data;
        Node next;
    }

    private  Node start;    //represent as the first node

    //Creating a New Node
    private Node createNewNode(int data) throws Exception {
        Node node = new Node();

        if (node == null)
            throw new Exception("List Overflow");
        else {
            node.prev = null;
            node.data = data;
            node.next = null;
            return node;
        }
    }

    //Inserting the new node at the beginning of the list
    public void insertBeginning(int data) throws Exception {
        Node node = createNewNode(data);

        if (start == null) {
            start = node;
        }
        else  {
            node.next = start;
            start.prev = node;
            start = node;
        }
    }

    //Inserting the new node at the end of the list
    public void insertEnd(int data) throws Exception {
        Node node = createNewNode(data);
        Node ptr;

        if (start == null) {
            start = node;
        }
        else  {
            ptr = start;

            while (ptr.next != null) {
                ptr = ptr.next;
            }

            ptr.next = node;
            node.prev = ptr;
        }
    }

    //Inserting the new node at the after a given node of the list
    public void insertAfter(int data, int keyValue) throws Exception {
        Node node = createNewNode(data);
        Node ptr;

        if (start == null) {
            throw new Exception("List is empty");
        }
        else {
            ptr = start;

            while (ptr.data != keyValue) {
                ptr = ptr.next;
            }

            node.next = ptr.next;
            node.prev = ptr;
            ptr.next = node;
            ptr.next.prev = node;
        }
    }

    //Inserting the new node before a given node of the list
    public void insertBefore(int data, int keyValue) throws Exception {
        Node node = createNewNode(data);
        Node ptr;

        if (start == null) {
            throw new Exception("List is empty");
        }
        else  {
            ptr = start;

            while (ptr.data != keyValue) {
                ptr = ptr.next;
            }

            node.next = ptr;
            node.prev = ptr.prev;
            ptr.prev.next = node;
            ptr.prev = node;
        }
    }

    //Deleting a node at the beginning of the list
    public void deleteBeginning() throws  Exception {

        if (start == null) {
            throw new Exception("List is NULL");
        }
        else {
            out.println("Node deleted : " + start.data);
            start = start.next;
            start.prev =  null;
        }
    }

    //Deleting a node at the end of the list
    public void deleteEnd() throws Exception {
        Node ptr;

        if (start == null) {
            throw new Exception("List is NULL");
        }
        else  {
            ptr = start;

            while (ptr.next != null) {
                ptr =  ptr.next;
            }

            out.println("Node deleted : " + ptr.data);
            ptr.prev.next = null;
        }
    }

    //Deleting a given node on the list
    public void deleteGivenNode(int keyValue) throws Exception {
        Node ptr = start;

        if (start == null) {
            throw new Exception("List is NULL");
        }
        else  {
            ptr = start;

            while (ptr.data != keyValue) {
                ptr = ptr.next;
            }

            ptr.prev.next = ptr.next;
            ptr.next.prev = ptr.prev;
            out.println("Node deleted : " + ptr.data);
        }
    }

    //Deleting a node before a given node on the list
    public void deleteBeforeGivenNode(int keyValue) throws Exception {
        Node ptr, preptr;

        if (start == null) {
            throw new Exception("List is NULL");
        }
        else  {
            ptr = start;

            while (ptr.data != keyValue) {
                ptr = ptr.next;
            }
            ptr.prev.next = ptr.next.prev;
            // ptr.prev.next = ptr.prev.next;

            out.println("Node deleted : " + ptr.data);
        }
    }

    //Counts the number of nodes on the list
    public int countNodes(){
        int count = 0;

        Node ptr = start;   //ptr points to start

        //traversing thru the list
        while(ptr != null){
            count++;    //increment the count by 1 for each node
            ptr = ptr.next;
        }
        return count;   //returns the number of nodes
    }

    //Counts positive and negative numbers
    public void countPosNeg(){
        int pos = 0;
        int neg = 0;

        Node ptr = start;

        while(ptr != null){
            if(ptr.data > 0){
                pos++;
            } else{
                neg++;
            }
            ptr = ptr.next;
        }
        out.print("Positive numbers : " + pos);
        out.print("\nNegative numbers : " + neg);
    }

    //Counts the number of odd and even numbers
    public void countOddEven(){
        int odd = 0;
        int even = 0;

        Node ptr = start;

        while(ptr != null){
            if(ptr.data % 2 == 0){
                even++;
            } else{
                odd++;
            }
            ptr = ptr.next;
        }
        out.print("Even numbers: " + even);
        out.print("\nOdd numbers: " + odd);
    }

    //Displaying the data/nodes
    public void display() throws Exception {
        Node ptr;

        if (start == null) {
            throw new Exception("List Underflow");
        }
        else  {
            ptr = start;

            while(ptr != null) {
                out.print(ptr.data + "   ");
                ptr = ptr.next;
            }
        }
        out.println();
    }

    //Displaying the data/nodes in reverse
    public void displayReverse() throws Exception {
        Node ptr;

        if (start == null)
            throw new Exception("List Underflow");
        else {
            ptr = start;

            while (ptr.next != null) {
                ptr = ptr.next;
            }

            while (ptr != null) {
                out.print(ptr.data + "  ");
                ptr = ptr.prev;
            }
        }
        out.println();
    }
}
