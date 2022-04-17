package Queue.Activity4;

/*
* When a share of common stock of some company is sold, the capital gain (or, sometimes, loss)
* is the difference between the share’s selling price and the price originally paid to buy it.
* This rule is easy to understand for a single share, but if we sell multiple shares of stock
* bought over a long period of time, then we must identify the shares actually being sold.
* A standard accounting principle for identifying which shares of a stock were sold in such a
* case is to use a FIFO protocol—the shares sold are the ones that have been held the longest
* (indeed, this is the default method built into several personal finance software packages).

For example, suppose we buy 100 shares at $20 each on day 1, 20 shares at $24 on day 2,
* 200 shares at $36 on day 3, and then sell 150 shares on day 4 at $30 each.
* Then applying the FIFO protocol means that of the 150 shares sold, 100 were bought on day 1,
* 20 were bought on day 2, and 30 were bought on day 3. The capital gain, in this case,
* would therefore be 100 · 10+20 · 6+30 · (−6), or $940. Write a program that takes as input
* a sequence of transactions of the form “buy x share(s) at y each” or “sell x share(s) at y each,”
* assuming that the transactions occur on consecutive days and the values x and y are integers.
* Given this input sequence, the output should be the total capital gain (or loss)
* for the entire sequence, using the FIFO protocol to identify shares.
* */

import java.text.DecimalFormat;
import java.util.*;
import static java.lang.System.out;

public class Main_Queue {
    //Declaring global objects & variables
    static Scanner input = new Scanner(System.in);
    static DecimalFormat df = new DecimalFormat("#.00");
    static Functions_Queue stock = new Functions_Queue();

    static int stockQuantity;
    static double stockPrice;
    static int sellQuantity;
    static double sellPrice;
    static double gain;

    public static void main(String[] args) throws Exception {

        int menu;
        boolean choice = true;

        while (choice) {
            out.println();

            //List of operations
            out.println("[1] - Buy Shares");
            out.println("[2] - Sell Shares");
            out.println("[3] - Display Stocks");
            out.println("[0] - Exit");

            out.print("Input a number : ");
            menu = input.nextInt();
            out.println();

            switch (menu) {
                case 1:
                    //Buying Shares

                    out.println("***** Buy Shares *****");

                    //Asks user input for the number of days of transaction in buying shares
                    out.println("Input the Number of Days of Transaction in Buying Stocks : ");
                    int n = input.nextInt();

                    for (int i = 0; i < n; i++) {

                        out.println("[Day " + (i + 1) + "]");

                        out.print("Quantity of the Shares to Buy : ");
                        stockQuantity = input.nextInt();
                        input.nextLine();

                        out.print("Price of the Shares to Buy : ");
                        stockPrice = input.nextDouble();

                        stock.enQueue(stockQuantity, stockPrice);
                        out.println();
                    }
                    break;

                case 2:
                    //Selling the shares

                    out.println("***** Sell Shares *****");

                    out.print("Quantity of the Shares to Sell : ");
                    sellQuantity = input.nextInt();
                    input.nextLine();

                    out.print("Price of the Shares to Sell : ");
                    sellPrice = input.nextDouble();

                    //calling the method calculateStockSelling() to perform the calculation
                    calculateStockSelling(sellQuantity, sellPrice);

                    //calls the method capitalGainLoss() to perform
                    //and displays the stocks
                    capitalGainLoss();
                    stock.display();
                    System.out.println();
                    break;

                case 3:
                    //Displays all the stock of shares.
                    stock.display();
                    break;

                case 0:
                    //When 0 is entered, the program will be terminated.
                    choice = false;
                    break;

                default:
                    //Prints out when entered an invalid input.
                    out.println("Invalid input.");
            }
        }
    }

    //Method that calculates the selling of shares of stock
    public static void calculateStockSelling (int sellQuantity, double sellPrice) throws Exception {

        int totalQuantity = stock.calculateStockQuantity(); //totalQuantity as a variable for the total number of shares

        //Checks if either the sellQuantity is more than the totalQuantity
        //or sellQuantity is less than 0,
        //then there are no stocks available.
        if (sellQuantity > totalQuantity) {
            throw new Exception("You do not have " + sellQuantity + " amount of stock to sell.");
        }
        else if (sellQuantity < 0) {
            throw new Exception("You do not have " + sellQuantity + " amount of stock to sell.");
        }
        else if (stock.getSharesX() == sellQuantity) {
            double price = stock.getPriceY();
            stock.deQueue();
            gain = gain + sellQuantity * (sellPrice - price);
        }
        else if (stock.getSharesX() < sellQuantity) {

            int quantity = stock.getSharesX();
            double price = stock.getPriceY();
            stock.deQueue();
            gain = gain + quantity * (sellPrice - price);
            sellQuantity -= quantity;
            calculateStockSelling(sellQuantity, sellPrice);

        }
        else if (stock.getSharesX() > sellQuantity) {

            int quantity = stock.getSharesX();
            double price = stock.getPriceY();
            int sellableStock = quantity - sellQuantity;
            stock.deQueue();
            gain = gain + sellQuantity * (sellPrice - price);
            stock.enQueue(sellableStock, price);
        }

    }

    //Method that determines a capital if it is a gain or loss
    public static void capitalGainLoss() throws Exception{
        if (gain < 0) {
            System.out.println("\nTotal capital loss is $" + df.format(gain));

        } else {
            System.out.println("\nTotal capital gain is $" + df.format(gain));

        }
    }
}
