package DoublyLinkedList.Activity2.Activity2Revised;

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

//Note: Names used in the program are only used for reference and examples

//do some cleaner code by creating a method in Functions_DoublyLLRevised,
//and import it in main class
import static java.lang.System.out;
import static DoublyLinkedList.Activity2.Activity2Revised.Functions_DoublyLLRevised.userData;
import static DoublyLinkedList.Activity2.Activity2Revised.Functions_DoublyLLRevised.userInput;

public class Main_DoublyLLRevised {
    public static void main(String[] args)throws Exception{

        Functions_DoublyLLRevised studentList = new Functions_DoublyLLRevised();

        //1. Input Student Record
        studentList.insertStudent(110001, "Drilon", "Frank", "BSIT", 4, "BSIT-IV-A", "ACTIVE");
        studentList.insertStudent(110002, "Gatchalian", "Win", "BSIT", 4, "BSIT-IV-A", "ACTIVE");
        studentList.insertStudent(110003, "Gordon", "Richard", "BSIS", 4, "BSIS-IV-A", "ACTIVE");
        studentList.insertStudent(110004, "Legarda", "Loren", "BSTM", 4, "BSTM-IV-A", "NOT ACTIVE");
        studentList.insertStudent(110005, "Madrigal", "Jamby", "BSIS", 4, "BSIS-IV-A", "NOT ACTIVE");
        studentList.insertStudent(110006, "Sotto", "Tito", "BSIT", 3, "BSIT-III-A", "ACTIVE");
        studentList.insertStudent(110007, "Lacson", "Ping","BSCS", 3, "BSCS-III-A", "ACTIVE");
        studentList.insertStudent(110008, "Angara", "Sonny", "BSIT", 3, "BSIT-III-B", "ACTIVE");
        studentList.insertStudent(110009, "Go", "Bong", "BSIT",3, "BSIT-III-B", "ACTIVE");
        studentList.insertStudent(110010, "Poe", "Grace", "BSIT", 3, "BSIT-III-B", "ACTIVE");
        studentList.insertStudent(110011, "Marcos", "Imee", "BSIT", 2, "BSIT-II-B","ACTIVE");
        studentList.insertStudent(110012, "Villar", "Cynthia", "BSIT", 3, "BSIT-III-A", "ACTIVE");
        studentList.insertStudent(110013, "Tolentino", "Francis", "BSCS", 3, "BSCS-III-A","ACTIVE");
        studentList.insertStudent(110014, "Cayetano", "Pia", "BSTM", 3, "BSTM-III-A", "ACTIVE");
        studentList.insertStudent(110015, "Binay", "Nancy", "BSTM",3, "BSTM-III-A", "ACTIVE");
        studentList.display();

        //2. Search student records by ID
        out.print("Enter student ID to search : ");
        studentList.searchID(userInput());
        out.println();

        //3. Search students by name
        out.print("Enter student's name to search : ");
        studentList.searchByName(userData());
        out.println();

        //4. Search students by course
        out.print("Enter course (in acronym) to search : ");
        studentList.searchByCourse(userData());
        out.println();

        //5. Displays student based on year level
        out.print("Enter student's name to display his/her year level : ");
        studentList.displayStudentYL(userData());
        //input.nextLine();
        out.println();

        //6. Displays all students in ascending order based on year level
        out.println("Students in ascending order based on their year level : ");
        studentList.displayAscendYL();
        out.println();

        //7. Displays all students in ascending order based on studentID
        out.println("Students in ascending order based on their ID : ");
        studentList.displayByID();
        out.println();

        //8. Displays all the courses in ascending order
        out.println("Courses in ascending order : ");
        studentList.displayAscendCourse();
        out.println();

        //9. Display how many students are currently enrolled in a particular course
        out.print("Number of students who are currently enrolled in a particular course : \n");
        studentList.getCurrentEnrolled();
        out.println();

        //10. & 11 Displays how many students are currently active and inactive
        out.print("Number of students who are currently ACTIVE & INACTIVE : \n");
        studentList.getTotalStatus();
        out.println();

        //12. Delete a student by a studentID
        out.println();
        out.print("Enter the student's ID to delete : ");
        studentList.deleteStudent(userInput());
        studentList.display();
    }
}
