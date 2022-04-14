package SinglyLinkedList.SinglyLLTestPackage;

//Singly Test Classes
//Play with the codes

import java.util.Random;
import java.util.concurrent.ExecutionException;
import static java.lang.System.out;

public class TestMain_SinglyLL {
    public static void main(String[] args) throws Exception{
        TestFunctions_SinglyLL list = new TestFunctions_SinglyLL();
        Random random = new Random();

        for(int x = 1; x <= 10; x++){
            list.insertAtTheBeginning(1 + random.nextInt(100));
        }
        list.display();
        out.println("Insert at the beginning");
        list.insertAtTheBeginning(100);
        list.display();
    }
}
