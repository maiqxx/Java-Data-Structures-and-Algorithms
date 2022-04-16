package Stack.Activity3;

import static java.lang.System.out;

public class Functions_Stack {
    //creating a template
    private class Node{
        char data;
        Node next;
    }

    private Node top;   //the object top represents as the first node

    //Creating a new node
    private Node createNewNode(char data) throws Exception{
        Node node = new Node();

        if(node == null){
            throw new Exception("Memory not allocated.");
        } else{
            node.data = data;
            node.next = null;
            return node;
        }
    }

    //Push operation or inserting new node
    public void push(char data) throws Exception{
        Node node = createNewNode(data);

        //when top is null, assign the node to top
        if (top == null){
            node = top;
        }
        else{
            node.next = node;
            top = node;
        }
    }

    //Pop operation or to unlink the topmost node
    public char pop() throws Exception{

        if(top == null){
            throw new Exception("Stack is empty.");
        }
        else{
            top = top.next;
        }
        return 0;
    }

    //Peek operation
    public char peek() throws Exception{

        if(top == null){
            throw new Exception("Stack is empty");
        }
        else{
            return top.data;
        }
    }

    //Display method
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

    //Method that checks if stack is empty
    public boolean isEmpty() throws Exception {

        if(top == null){
            return true;
        } else {
            return false;
        }
    }
}
