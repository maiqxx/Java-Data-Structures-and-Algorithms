package DoublyLinkedList.Activity2.Activity2AttemptedSolution;

//Write a menu based program for a XYZ Academy(you can name your own) that implement the following functionalities in a doubly-linked list:
//
//
//        1 – Input Student Record
//        2 - Search student records by ID
//        3 - Search students by name
//        4 - Search students by course
//        5 - Displays student based on year level
//        6 - Displays all students in ascending order based on year level
//        7 - Displays all students in ascending order based on studentID
//        8 - Displays all the courses in ascending order
//        9 - Display how many students are currently enrolled in a particular course
//        10 - Displays how many students are currently active
//        11 - Displays how many students are currently inactive
//        12 - Delete a student by a studentID
//        0 – Exit
//
//
//        Your program should have the following constraints:
//        - The studentID should be unique, e.g., your program should not accept any record with an existing student ID number.
//        - Searching for the name should be case insensitive include the last name and first name, e.g., if you search for the name “Arroyo”, it should appear either in the last name or first name, or both.
//        - Searching for the course should be case insensitive and you have to use acronyms only, e.g., BSIT, BSIS, BSCS
//        - Year level ranges only from 1 to 4 only, any other year should consider an error.
//        - The status should only be “active” or “not active”.
//        - When displaying, the record should be converted all to uppercase
//        - For sorting, DON'T use any predefined prepackage
//
//        Variables are: studentID, lastName, firstName, course, section, yearLevel, and status

import static java.lang.System.out;
import java.util.*;

public class Main_DoublyLL {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws Exception{

        Functions_DoublyLL studentList = new Functions_DoublyLL();

        int list[] = new int[2];
        int menu;   //declaring variable to input/choose operations to perform
        boolean choice = true;

        while(choice){
            out.println();

            //Displays the list of operations
            out.println("[1] - Input Student Record");
            out.println("[2] - Search student records by ID");
            out.println("[3] - Search students by name");
            out.println("[4] - Search students by course");
            out.println("[5] - Displays student based on year level");
            out.println("[6] - Displays all students in ascending order based on year level");
            out.println("[7] - Displays all students in ascending order based on studentID");
            out.println("[8] - Displays all the courses in ascending order");
            out.println("[9] - Display how many students are currently enrolled in a particular course");
            out.println("[10] - Displays how many students are currently active");
            out.println("[11] - Displays how many students are currently inactive");
            out.println("[12] - Delete a student by a studentID");
            out.println("[0] - Exit");
            out.println();

            out.print("Input a number : ");
            menu = input.nextInt();
            out.println();

            switch(menu){
                case 1:
                    for(int i = 0; i < list.length; i++){

                        out.println("[Student " + (i + 1) + "]");

                        //User's input for student's ID
                        int studentID = 0;
                        boolean duplicate;

                        //checks the user's input for student's ID if it is duplicate
                        do{
                            duplicate = true;
                            out.print("Student's ID : ");
                            studentID = input.nextInt();
                            for(int j = 0; j < i; j++){
                                if(list[j] == studentID){
                                    out.println("Student ID already exists.");
                                    duplicate = false;
                                    break;
                                }
                            }
                            list[i] = studentID;
                        } while (!duplicate);
                        input.nextLine();

                        //User's input for student's name
                        out.print("First Name : ");
                        String firstName = input.nextLine();
                        out.print("Last Name : ");
                        String lastName = input.nextLine();

                        //User's input for student's course
                        out.print("Course : ");
                        String course = input.nextLine();

                        //User's input for student's year level
                        int yearLevel = 0;
                        boolean valid = true;

                        //checks the user's input for year level if it is valid
                        while (valid){
                            out.print("Year Level : ");
                            yearLevel = input.nextInt();
                            if(yearLevel <= 4){
                                valid = false;
                            } else {
                                out.println();
                                out.println("Invalid input");
                                out.println("[Year level must ranges from 1 to 4.]");
                            }
                        }
                        input.nextLine();

                        //User's input for student's section
                        out.print("Section : ");
                        String section = input.nextLine();


                        //User's input for student's status
                        boolean stat = true;
                        String status = "";

                        while (stat) {
                            out.print("Status : ");
                            status = input.nextLine();

                            switch (status) {
                                case "ACTIVE":
                                case "NOT ACTIVE":
                                    stat = false;
                                    break;
                                default:
                                    out.print("You must only input either ACTIVE or NOT ACTIVE  for status.\n");
                            }
                        }
                        input.nextLine();

                        studentList.insertStudent(studentID, firstName, lastName, course, yearLevel, section, status);
                        out.println();
                    }
                    studentList.display();
                    out.println();
                    break;

                case 2:
                    out.print("Enter student ID to search : ");
                    int studentId = input.nextInt();
                    studentList.searchID(studentId);
                    break;

                case 3:
                    String name = "";
                    out.print("Enter student's name to search : ");
                    name = input.next();
                    studentList.searchByName(name);
                    input.nextLine();
                    break;

                case 4:
                    String course = "";
                    out.print("Enter student's course (in acronym) to search : ");
                    course = input.next();
                    studentList.searchByCourse(course);
                    break;

                case 5:
                    out.print("Enter student's name : ");
                    name = input.next();
                    studentList.displayStudentYL(name);
                    break;

                case 6:
                    out.print("Students in ascending order based on their year level\n");
                    studentList.displayAscendYL();
                    break;

                case 7:
                    out.print("Displays all students in ascending order based on their ID\n");
                    studentList.displayAscendID();
                    break;

                case 8:
                    out.print("Displays all the courses in ascending order");
                    studentList.displayAscendCourse();
                    break;

                case 9:
                    out.print("Display how many students are currently enrolled in a particular course\n");

                    break;

                case 10:
                    out.print("Displays how many students are currently active\n");
                    studentList.getTotalStatus();
                    break;

                case 11:
                    out.print("Displays how many students are currently inactive\n");
                    studentList.getTotalStatus();
                    break;

                case 12:
                    out.print("Enter the student's ID to delete : ");
                    int studentID = input.nextInt();
                    studentList.deleteStudent(studentID);
                    break;

                case 0:    //when 0 is entered, the program will stop
                    choice = false;
                    break;

                default:
                    //when the entered number of choice is not on the list of operations
                    System.out.println("Invalid input.");
                    System.out.println();
            }
        }
    }
}
