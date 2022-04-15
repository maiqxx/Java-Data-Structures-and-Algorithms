package DoublyLinkedList.Activity2.Activity2Revised;

import java.util.*;
import static java.lang.System.out;

public class Functions_DoublyLLRevised {
    static Scanner input = new Scanner(System.in);


    //creating template
    private static class Node{
        Node prev;
        int studentID;
        String lastName;
        String firstName;
        String course;
        int yearLevel;
        String section;
        String status;
        Node next;
    }

    //address of the first node
    private Node start;

    //creating a new student record
    private Node createNewRecord(int studentID,
                                 String lastName,
                                 String firstName,
                                 String course,
                                 int yearLevel,
                                 String section,
                                 String status) throws Exception{

        Node student = new Node();

        if(student == null){
            throw new Exception("List Overflow");
        } else{
            student.prev = null;
            student.studentID = studentID;
            student.lastName = lastName;
            student.firstName = firstName;
            student.course = course;
            student.yearLevel = yearLevel;
            student.section = section;
            student.status = status;
            student.next = null;
            return student;
        }
    }

    //Inserting or adding new student(s)
    public void insertStudent(int studentID,
                              String lastName,
                              String firstName,
                              String course,
                              int yearLevel,
                              String section,
                              String status) throws Exception{

        Node student = createNewRecord(studentID, lastName, firstName,
                course, yearLevel, section, status);

        if(start == null){
            start = student;
        } else{
            student.next = start;
            start.prev = student;
            start = student;
        }
    }

    //Displays student record
    public void display() throws Exception{

        Node ptr;
        if(start == null){
            throw new Exception("List Underflow");
        } else{

            ptr = start;

            out.println("========================== Student Record ==========================");
            out.println("ID" + "\t\t\t" + "Name" + " " + "\t\t\t" + "Course" +
                    "\t\t\t" + "Section" + "\t\t\t" + "Year Level" + "\t\t" + "Status");

            out.println();

            while(ptr != null){
                out.println(ptr.studentID + "\t\t" + ptr.lastName + " " + ptr.firstName + " " +
                        "\t\t" + ptr.course + " " + "\t\t\t" + ptr.section + " " + "\t\t\t" +
                        ptr.yearLevel + " " + "\t\t" + ptr.status);

                ptr = ptr.next;
            }
        }
        out.println();
    }

    //2. Method that Search student records by ID
    public void searchID(int searchID){

        //ptr points to the start
        Node ptr = start;

        //2 variables:
        //found - to track the location of the searchID if found
        // i - to track the current index
        int found = 0;
        int i = 0;

        //if ptr is not null, go to the while loop
        //to check the node value with searchID
        //if found, update variables and break the loop,
        //else continue searching until ptr is null
        if(ptr != null){
            while (ptr != null){
                i++;
                if(ptr.studentID == searchID) {
                    found++;
                    break;
                }
                ptr = ptr.next;
            }
            if(found == 1){
                out.print(searchID + " is on the list number " + i + ".");
            } else{
                out.print(searchID + " is not found.");
            }
        } else{
            //if ptr points to start that is null,
            //this statement will display
            out.println("List is empty.");
        }
        out.println();
    }

    //3. Method that Search student records by name
    public void searchByName(String searchName){

        //ptr points to the start
        Node ptr = start;

        //2 variables:
        //found - to track the location of the searchID if found
        // i - to track the current index
        int found = 0;
        int i = 0;

        //if ptr is not null, go to the while loop
        //to check the node value with searchID
        //if found, update variables and break the loop,
        //else continue searching until ptr is null
        if(ptr != null){
            while (ptr != null){
                i++;
                if((ptr.firstName.equalsIgnoreCase(searchName))
                        || (ptr.lastName.equalsIgnoreCase(searchName))){

                    found++;
                    break;
                }
                ptr = ptr.next;
            }
            if(found == 1){
                out.print(searchName + " is on the list number " + i + ".");
                out.println();
                out.println("ID No.: " + ptr.studentID +"\n" +
                        "Name: " + ptr.firstName + " " + ptr.lastName + "\n" +
                        "Course: " + ptr.course + "\n" +
                        "Section: " + ptr.section + "\n" +
                        "Status: " + ptr.status);
            } else{
                out.print(searchName + " is not found.");
            }
        } else{
            //if ptr points to start that is null,
            //this statement will display
            out.println("List is empty.");
        }
        out.println();
    }

    //4. Method that Search student records by course
    public void searchByCourse(String searchCourse){

        //ptr points to the start
        Node ptr = start;

        //2 variables:
        //found - to track the location of the student course if found
        // i - to track the current index
        int found = 0;
        int i = 0;

        //if ptr is not null, go to the while loop
        //to check the node value with searchCourse
        //if found, update variables and break the loop,
        //else continue searching until ptr is null
        if(ptr != null){
            while (ptr != null){
                i++;
                if(ptr.course.equalsIgnoreCase(searchCourse)) {
                    found++;
                    break;
                }
                ptr = ptr.next;
            }
            if(found == 1){
                out.print(searchCourse + " course is on the list.");
                out.println();
            } else{
                out.print(searchCourse + " course is not found on the list.");
            }
        } else{
            //if ptr points to start that is null,
            //this statement will display
            out.println("List is empty.");
        }
        out.println();
    }

    //5. Display student based on year level
    public void displayStudentYL(String searchName) throws Exception{
        Node ptr;

        if(start == null){
            throw new Exception("List Underflow");
        } else{
            ptr = start;

            while(ptr.firstName.equalsIgnoreCase(searchName) || ptr.lastName.equalsIgnoreCase(searchName)){
                out.print(searchName + " is a " + ptr.yearLevel + "-year college student.\n");
                ptr = ptr.next;
            }
        }
        out.println();
    }

    //6. Method that displays all students in ascending order based on year level
    public void displayAscendYL() throws Exception{

        Node ptr = start, index = null;
        int temp;   //a temporary variable that stores the compared year level

        //Checks if null is empty
        if(start == null){
            throw new Exception("List is empty");
        } else{

            //Traversing thru the list
            while(ptr != null){
                index = ptr.next;

                while (index != null){
                    if(ptr.yearLevel > index.yearLevel){

                        temp = ptr.yearLevel;
                        ptr.yearLevel = index.yearLevel;
                        index.yearLevel = temp;

                    }
                    index = index.next;
                }
                ptr = ptr.next;
            }
        }
        display();
    }

    //7. Method that displays all students in ascending order based on student ID
    public void displayByID() throws Exception{

        Node ptr = start, index = null;
        int temp;   //a temporary variable that stores the compared year level

        //Checks if null is empty
        if(start == null){
            throw new Exception("List is empty");
        } else{

            //Traversing thru the list
            while(ptr != null){
                index = ptr.next;

                while (index != null){
                    if(ptr.studentID > index.studentID){

                        temp = ptr.studentID;
                        ptr.studentID = index.studentID;
                        index.studentID = temp;

                    }
                    index = index.next;
                }
                ptr = ptr.next;
            }
        }
        display();
    }

    //8. Method that displays all the courses in ascending order
    public void displayAscendCourse() throws Exception{

        Node ptr = start, index = null;
        int temp;   //a temporary variable that stores the compared year level

        //Checks if null is empty
        if(start == null){
            throw new Exception("List is empty");
        } else{

            //Traversing thru the list
            while(ptr != null){
                index = ptr.next;

                while (index != null){
                    if(ptr.yearLevel > index.yearLevel){

                        temp = ptr.yearLevel;
                        ptr.yearLevel = index.yearLevel;
                        index.yearLevel = temp;

                    }
                    index = index.next;
                }
                ptr = ptr.next;
            }
        }
        display();
    }

    //9. Method that Display how many students are currently enrolled in a particular course
    public void getCurrentEnrolled() throws Exception{

        int BSIT = 0;
        int BSCS = 0;
        int BSIS = 0;
        int BSTM = 0;

        Node ptr = start;   //pointer variable pointing to the start node

        //Traverse thru the linked list
        while (ptr != null){
            if(ptr.course == "BSIT") {
                BSIT++;
            } else if(ptr.course == "BSCS"){
                BSCS++;
            } else if(ptr.course == "BSIS"){
                BSIS++;
            } else if(ptr.course == "BSTM"){
                BSTM++;
            }
            ptr = ptr.next;     //goes to the next node
        }
        out.println("BSIT = " + BSIT + " student(s)");
        out.println("BSCS = " + BSCS + " student(s)");
        out.println("BSIS = " + BSIS + " student(s)");
        out.println("BSTM = " + BSTM + " student(s)");
        out.println();
    }

    //10. & 11. Method that Displays how many students are currently active & inactive
    public void getTotalStatus() throws Exception{

        int active = 0;
        int inactive = 0;

        Node ptr = start;   //pointer variable pointing to the start node

        //Traverse thru the linked list
        while (ptr != null){
            if(ptr.status == "ACTIVE"){

                active++;
                ptr = ptr.next;     //goes to the next node
            }

            else if(ptr.status == "NOT ACTIVE"){
                inactive++;
                ptr = ptr.next;
            }

        }
        out.print("Number of active student(s) : " + active);
        out.print("\nNumber of inactive student(s) : " + inactive);
        out.println();
    }

    //12. Method that deletes a student based on the ID
    public Node deleteStudent(int deleteKeyID) throws Exception{

        //Checks if list is empty
        if(start == null){
            throw new Exception("List is empty");
        }

        //Compares the start node with a data of studentID
        //and the deleteKeyID to be search with each student node
        if(start.studentID == deleteKeyID){

            //pointer points to start for traversing
            Node ptr = start;

            //start node points next node
            start = start.next;

            System.out.println("Student " + ptr.studentID + " has been deleted");
            return ptr;
        }

        Node preptr = null;        //preptr variable is currently null
        Node current = start;    //current variable points the start node

        //Traverse thru the list
        while(current != null) {

            //Compares the current node's data to a deleteKeyID to be deleted
            if (current.studentID == deleteKeyID) {

                //prints the deleted student
                out.println("Student " + current.studentID + " has been deleted");
                out.println();

                //preptr's address is now pointing to the current student node's address
                preptr.next = current.next;

                //returns current student that is deleted
                return current;
            } else {

                //Checks if current employee is null
                if (current.next == null) {

                    //not found
                    out.println("Student " + deleteKeyID + " was not found");
                    return null;
                }
                //preptr points current student node
                preptr = current;

                //current student node points the next node
                current = current.next;
            }
        }
        return null;
    }

    //Methods that reads users input for int and String for cleaner code
    public static int userInput(){
        int data;

        data = input.nextInt();
        return data;
    }

    public static String userData(){
        String data;

        data = input.next();
        return data;

    }
}
