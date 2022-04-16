package Stack.StackTestPackage.TestBalancingBrackets;

//template

import static java.lang.System.out;

public class TestFunctions_StackBalancingBrackets {
    private class Node{
        int data;
        Node next;
    }

    private Node top;

    //create a new node
    private Node createNewNode(int data) throws Exception{
        Node node = new Node();

        if(node == null){
            throw new Exception("Memory not allocated");
        }
        else{
            node.data = data;
            node.next = null;
            return node;
        }
    }

    //Push operation
    public void push(int data) throws Exception{
        Node node = createNewNode(data);

        if (top == null){
            node = top;
        }
        else{
            node.next = node;
            top = node;
        }
    }

    //Pop operation
    public void pop() throws Exception{

        if(top == null){
            throw new Exception("Stack is empty");
        }
        else{
            top = top.next;
        }
    }

    //Peek operation
    public int peek() throws Exception{

        if(top == null){
            throw new Exception("\nStack is empty");
        }
        else{
            return top.data;
        }
    }

    //Display
    public void display() throws Exception{
        Node ptr = top;

        if(ptr == null){
            throw new Exception("Stack is empty.");
        }
        else{
            out.println();

            while(ptr != null){
                out.println(ptr.data + " ");
                ptr = ptr.next;
            }
        }
    }
    //getting the size of the stack
    public int getSize() throws Exception{
        int size = 0;
        Node ptr = top;

        while (ptr != null){
            size++;
            ptr = ptr.next;
        }
        return size;
    }

    public boolean isEmpty() throws Exception
    {

        if(top == null){
            return true;
        }
        return false;
    }
}
