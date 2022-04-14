package CircularSinglyLinkedList.CircularSinglyLLPackage;

import static java.lang.System.out;

public class TestFunctions_CircularSinglyLL {
    //Creating a Template
    private class Node {
        int data;
        Node next;
    }

    private Node start;     //contains the address of the first node

    //Creating a new node
    private Node createNewNode(int data) throws Exception {
        Node node = new Node();

        node.data = data;
        return node;
    }

    //Inserting a node at the beginning of the list
    public void insertBeginning(int data) throws Exception {
        Node node = createNewNode(data);    //new node
        Node ptr;   //ptr object that will point thru the nodes

        //checks if start is null
        if (start == null) {
            node.next = node;   //if null, point node to itself
            start = node;   //assign node to start
        }
        else {
            ptr = start;    //ptr points start

            //traverse thru the list
            while(ptr.next != start) {
                ptr = ptr.next; //position the object ptr
            }

            node.next = start;  //link the node to start
            ptr.next = node;    //link ptr to the node
            start = node;   //transfer node to start as the new first node
        }
    }

    //Inserting a node at the end of the list
    public void insertEnd(int data) throws Exception {
        Node node = createNewNode(data);    //new node
        Node ptr;   //ptr object that will point thru the nodes

        //checks if start is null
        if (start == null) {
            node.next = node;   //if null, point node to itself
            start = node;   //assign node to start
        }
        else  {
            ptr = start;    //ptr points start

            //traverse thru the list
            while (ptr.next != start) {
                ptr = ptr.next; //position the object ptr
            }

            ptr.next = node;    //link ptr to the node
            node.next  = start; //link the node to start
        }
    }

    //Inserting a node before the given node
    public void insertBefore(int data, int keyValue) throws Exception {
        Node node = createNewNode(data);
        Node ptr, preptr = new Node();

        if(start == null){
            start = node;
        } else{
            ptr = start;

            //traverse thru the list
            while (ptr.data != keyValue) {
                preptr = ptr;
                ptr = ptr.next; //position the ptr
            }

            preptr.next = node;
            node.next = ptr;
        }
        //out.println("Node inserted : " + ptr.data);
    }

    //Inserting a node after the given node
    public void insertAfter(int data, int keyValue) throws Exception {
        Node node = createNewNode(data);
        Node ptr;

        if(start == null){
            throw new Exception("List is empty");
        } else{
            ptr = start;

            //traverse thru the list
            while (ptr.data != keyValue) {
                ptr = ptr.next; //position the ptr
            }
            node.next = ptr.next;
            ptr.next = node;
        }
        //out.println("Node inserted : " + ptr.data);
    }

    //Deleting a node at the beginning of the list
    public void deleteBeginning() throws Exception {
        Node ptr;   //ptr object that will point thru the nodes

        //checks if start is null
        if (start == null) {
            //if null, this will display
            throw new Exception("List is empty");
        }
        else {
            ptr = start;     //ptr points start

            //traverse thru the list
            while (ptr.next != start) {
                ptr = ptr.next; //position the object ptr
            }
            out.println("Node deleted : " + start.data);    //displays the deleted node
            ptr.next = start.next;  //ptr points to the second node
            start = ptr.next;   //assign ptr to start as the new first node
        }

    }

    //Deleting a node at the end of the list
    public void deleteEnd() throws  Exception {
        Node ptr, preptr;   //two objects intended for traversing and as temporary variables
        preptr = null;  //assign previous pointer to null

        //checks if start is null
        if (start == null) {
            //if null, this will display
            throw new Exception("List is empty");
        }
        else {
            ptr = start;    //ptr points to start

            //traverse thru the list
            while (ptr.next != start) {
                preptr = ptr;   //assign ptr to preptr so that preptr will follow
                ptr = ptr.next; //ptr will be position at the end
            }
            out.println("Node deleted : " + ptr.data);  //prints the deleted node
            preptr.next = start;    //previous node is now able to link the first
        }
    }

    //Deleting a given node on the list
    public void deleteGiven(int keyValue)throws Exception {
        Node ptr, preptr;   //two objects intended for traversing and as temporary variables
        preptr = null;  //assign previous pointer to null

        //checks if start is null
        if (start == null) {
            //if null, this will display
            throw new Exception("List is empty");
        }
        else {
            ptr = start;    //ptr points to start

            //traverse thru the list
            while (ptr.next != start) {
                if(ptr.data == keyValue) {
                    preptr = ptr;   //assign ptr to preptr so that preptr will follow
                    ptr = ptr.next; //ptr will be position at the end
                }
            }
            out.println("Node deleted : " + ptr.data);  //prints the deleted node
            preptr.next = ptr.next;    //previous node is now able to link the first
        }
    }


    //Displays the nodes
    public void display() throws Exception {
        Node ptr = start;

        if (start == null) {
            throw new Exception("List is empty");
        }

        //
        while(ptr.next != start) {
            out.print(ptr.data + "  "); //prints the data of the node
            ptr = ptr.next;
        }

        out.print(ptr.data);
    }
}
