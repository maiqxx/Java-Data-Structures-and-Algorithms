package Queue.CircularQueue.CircularQueueTestPackage;

public class TestFunctions_CircularQueue {
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
            return node;
        }
    }

    public void enQueue(int data) throws Exception {
        Node node = createNewNode(data);

        if (front == null) {
            front = node;
        }
        else  {
            rear.next = node;
        }
        rear = node;
        rear.next = front;
    }

    public void deQueue() throws Exception {

        if (front == null) {
            throw new Exception("Queue is empty");
        }
        else  {
            front = front.next;
            rear.next = front;
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

            while(ptr.next != front) {
                System.out.print(ptr.data + " ");
                ptr = ptr.next;
            }

            System.out.print(ptr.data + " ");
        }
    }
}
