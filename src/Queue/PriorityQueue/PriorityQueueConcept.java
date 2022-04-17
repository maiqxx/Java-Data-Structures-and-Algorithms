package Queue.PriorityQueue;

 /*
Write a menu-based program that performs the following operations.

Insert
Delete
Front value
Rear value
Display
Empty Queue

USE OUR CODING FORMAT.
*/

import java.util.*;

public class PriorityQueueConcept {
    static Scanner input = new Scanner(System.in);
    private static class Node{
        int data;
        int priority;
        Node next;
    }
    private Node front;
    private Node rear;

    private Node createNewNode(int data, int priorityValue) throws Exception {
        Node node = new Node();

        if (node == null) {
            throw new Exception("Memory not allocated");
        }
        else  {
            node.data = data;
            node.priority = priorityValue;
            node.next = null;
            return node;
        }
    }

    //Insert
    public void enQueue(int data, int priorityValue)  throws Exception {
        Node node = createNewNode(data, priorityValue);

        if (front == null || priorityValue <= front.priority) {
            //front = rear = node;
            node.next = front;
            front = node;
        }
        else {
            Node ptr = front;

            while((ptr.next != null) && (ptr.next.priority <= priorityValue)){
                ptr = ptr.next;
            }
            //rear.next = node;
            //rear = node;

            //node.next = ptr.next;
            ptr.next = node;
            rear = node;
        }
    }

    //Delete
    public int deQueue() throws Exception{

        if (front == null){
            throw new Exception("Queue is empty.");
        }

        int ptr = front.data;
        front = front.next;
        return ptr;
    }

    //Front Value
    public void getFront() throws Exception {

        if (front == null) {
            throw new Exception("Queue is empty.");
        }
        else {
            System.out.println("Front Value :" + front.data);
        }
    }

    //Rear Value
    public void getRear() throws Exception {

        if (front == null) {
            throw new Exception("Queue is empty.");
        }
        else {
            System.out.println("Rear Value :" + rear.data);
        }
    }

    //Display
    public void display() throws Exception {

        if (front == null) {
            System.out.println("Queue is empty.");
        }
        else {
            Node ptr = front;

            while(ptr != null) {
                System.out.print("[" + ptr.priority + ", " + ptr.data + "]" +" -> ");
                ptr = ptr.next;
            }
            System.out.print("NULL\n");
        }
    }

    //Empty Queue1
    public void emptyQueue() throws Exception{

        if (front == null){
            throw new Exception("Queue is empty.");
        }
        else{
            Node ptr = front;
            while(ptr != null){
                deQueue();
                ptr = ptr.next;
            }
            System.out.println("Queue is empty.");
        }

    }

    //Test Class
    public static void main(String[] args) throws Exception{

        PriorityQueueConcept pq = new PriorityQueueConcept();
        boolean choice = true;

        while(choice){
            System.out.println();

            //List of operations
            System.out.println("[1] - Insert");
            System.out.println("[2] - Delete");
            System.out.println("[3] - Front Value");
            System.out.println("[4] - Rear Value");
            System.out.println("[5] - Display");
            System.out.println("[6] - Empty Queue");
            System.out.println("[0] - Exit");

            System.out.println("Input a number : ");
            int option = input.nextInt();
            int data = 0, priorityValue = 0;

            switch (option){
                case 1:
                    System.out.print("Enter data of the node : ");
                    data = input.nextInt();

                    System.out.print("Enter priority value of the node : ");
                    priorityValue = input.nextInt();

                    pq.enQueue(data, priorityValue);
                    break;

                case 2:
                    System.out.println(pq.deQueue() + " deleted successfully.");
                    break;

                case 3:
                    pq.getFront();
                    break;

                case 4:
                    pq.getRear();
                    break;

                case 5:
                    pq.display();
                    break;

                case 6:
                    pq.emptyQueue();
                    break;

                case 0:
                    choice = false;
                    System.out.println("Program terminated.");
                    break;

                default:
                    System.out.println("Invalid input: " + option);
            }
        }

    }
}
