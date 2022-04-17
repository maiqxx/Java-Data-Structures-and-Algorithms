package Queue.LinearQueue.LinearQueueTestPackage;

import static java.lang.System.out;

public class TestMain_LinearQueue {
    public static void main(String[] args) throws Exception{

        TestFunctions_LinearQueue lq = new TestFunctions_LinearQueue();

        lq.enQueue(2);
        lq.enQueue(4);
        lq.enQueue(6);
        lq.enQueue(8);
        lq.enQueue(10);
        out.println("Front value : " + lq.getFront());
        out.println("Rear value : " + lq.getRear());
        lq.display();
        out.println();

        lq.deQueue();
        lq.deQueue();
        out.println("Values after deQueue : ");
        lq.display();
        out.println();

        lq.enQueue(2);
        lq.enQueue(3);
        lq.enQueue(8);
        lq.enQueue(0);
        out.println("Values after enQueue : ");
        lq.display();
        out.println();
    }
}
