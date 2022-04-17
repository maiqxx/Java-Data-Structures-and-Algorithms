package Queue.DoubleEndedQueue.DoubleEndedQueueTestPackage;

public class TestFunctions_DoubleEndedQueue {
    private class Node {
        int data;
        Node next;
    }

    private Node front; //head, begin
    private Node rear;  //tail, end

    private Node createNewNode(int data) throws Exception {
        Node node = new Node();

        if (node == null) {
            throw new Exception("Memory not allocated");
        } else {
            node.data = data;
            node.next = null;
            return node;
        }
    }

    public void enQueueFront(int data) throws Exception {
        Node  node = createNewNode(data);

        if (front == null) {
            front = rear = node;
        }
        else {
            node.next = front;
            front = node;
        }
    }

    public void enQueueRear(int data) throws Exception {
        Node node = createNewNode(data);

        if (front == null) {
            front = rear = node;
        }
        else {
            rear.next = node;
            rear = node;
        }
    }

    public void deQueueFront() throws Exception {

        if (front == null) {
            throw new Exception("Queue is empty");
        }
        else  {
            front = front.next;
        }
    }

    public void deQueueEnd() throws Exception {

        if (front == null) {
            throw new Exception("Queue is empty");
        } else {
            Node ptr = front;

            while (ptr.next != rear) {
                ptr = ptr.next;
            }

            rear = ptr;
            rear.next = null;
        }
    }

    public int getFront() throws Exception {

        if (front == null) {
            throw new Exception("Queue is empty");
        }
        else {
            return front.data;
        }
    }

    public int getRear() throws Exception {

        if (front == null) {
            throw new Exception("Queue is empty");
        }
        else {
            return rear.data;
        }
    }

    public void display() throws Exception {

        if (front == null) {
            throw new Exception("Queue is empty");
        }
        else {
            Node ptr = front;

            while(ptr != null) {
                System.out.print(ptr.data + " ");
                ptr = ptr.next;
            }
        }
    }
}
