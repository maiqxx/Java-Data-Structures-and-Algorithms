package Stack.StackTestPackage.TestStackLinkedList;

public class TestFunctions_StackLinkedList {
    private class Node {
        int data;
        Node next;
    }
    Node top;
    int size;
    private Node create_new_node(int item) throws Exception {
        Node node = new Node();
        if (node == null) {
            throw new Exception("Memory not allocated");
        } else {
            node.data = item;
            node.next = null;
            return node;
        }
    }
    public void push(int item) throws Exception {
        Node nn = create_new_node(item);
        if (size == 0) {
            top = nn;
        } else {
            nn.next = top;
            top = nn;
        }
        size++;
    }

    public int pop() throws Exception {
        if (size == 0) {
            throw new Exception("Stack is Empty");
        }
        int val = peek();
        top = top.next;
        return val;
    }

    public int peek() throws Exception {
        if (size == 0) {
            throw new Exception("Stack is Empty");
        }
        return top.data;
    }

    public void display() throws Exception {
        if (size == 0) {
            throw new Exception("Stack is Empty");
        }
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}
