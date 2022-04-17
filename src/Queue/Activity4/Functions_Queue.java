package Queue.Activity4;

import java.text.DecimalFormat;
import static java.lang.System.out;

public class Functions_Queue {
    static DecimalFormat df = new DecimalFormat("#.00");

    private class Node {
        int x;  //number of shares of stock
        double y;   //price of shares of stock
        Node next;
    }

    private Node front; //head, begin
    private Node rear;  //tail, end

    private Node createNewNode(int x, double y) throws Exception {
        Node node = new Node();

        if (node == null) {
            throw new Exception("Memory not allocated.");
        }
        else  {
            node.x = x;
            node.y = y;
            node.next = null;
            return node;
        }
    }

    //Method that inserts the first stock of shares in queue
    public void enQueue(int x, double y)  throws Exception {
        Node node = createNewNode(x, y);

        if (front == null) {
            front = rear = node;
        }
        else {
            rear.next = node;
            rear = node;
        }
    }

    //Method that deletes the first stock of shares in queue
    public void deQueue() throws Exception {

        if (front == null) {
            throw new Exception("Queue is empty.");
        }
        else {
            front = front.next;
        }
    }

    //Method that calculates the total of stocks
    public int calculateStockQuantity() throws Exception{
        int totalStockQuantity = 0;

        if (front == null) {
            throw new Exception("You do not have any stocks.");
        }
        else {
            Node ptr = front;
            while (ptr != null) {
                totalStockQuantity += ptr.x;
                ptr = ptr.next;
            }
            //out.println("Total Number of Stocks : " + totalStockQuantity);
            return totalStockQuantity;
        }
    }

    //Method that calculates the total of stocks' price
    public double calculateStockPrice() throws Exception{
        double totalStockPrice = 0;

        if (front == null) {
            throw new Exception("You do not have any stocks.");
        }
        else {
            Node ptr = front;
            while (ptr != null) {
                totalStockPrice += ptr.y;
                ptr = ptr.next;
            }
            //out.println("Total Price of Stocks : " + totalStockPrice);
            return totalStockPrice;
        }
    }


    //Method that gets the number of the shares of stock
    public int getSharesX() throws Exception {


        if (front == null) {
            throw new Exception("Queue is empty.");
        }
        else {
            return front.x;
        }
    }

    //Method that gets the price of the shares of stock
    public double getPriceY() throws Exception {

        if (front == null) {
            throw new Exception("Queue is empty.");
        }
        else {
            return front.y;
        }
    }

    //Method that displays the remaining stocks and the profit
    public void display() throws Exception {

        if (front == null) {
            throw new Exception("You do not have any stocks.");
        }
        else {
            Node ptr = front;

            while(ptr != null) {
                out.print("Stock Quantity Remaining : " + ptr.x + ", bought at Stock Price : " + df.format(ptr.y) + "\n");
                ptr = ptr.next;
            }
        }
    }

    //Method that checks if queue is empty
    public boolean isEmpty() throws Exception {

        if(front == null){
            return true;
        } else {
            return false;
        }
    }
}
