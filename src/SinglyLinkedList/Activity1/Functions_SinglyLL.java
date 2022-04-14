package SinglyLinkedList.Activity1;

import java.text.DecimalFormat;

public class Functions_SinglyLL {
    //declaration of the class Node
    private class Node{

        int employeeID;
        String firstName;
        String lastName;
        double salary;
        Node next;

        //Overloaded Constructor
        public Node(int employeeID, String firstName, String lastName, double salary) {

            this.employeeID = employeeID;

            this.firstName = firstName;
            this.lastName = lastName;
            this.salary = salary;
            this.next = null;
        }
    }

    Node start = null;  //Head node/start node of the list
    Node end = null;    //Tail node/end node of the list

    //Overload Constructor -- Getting user's inputs
    private Node newEmployee(int employeeID, String firstName, String lastName, double salary) throws Exception{

        Node employee = new Node(employeeID, firstName, lastName, salary);

        if(employee == null)
            throw  new Exception("Memory not allocated");
        else {
            employee.employeeID = employeeID;
            employee.firstName = firstName;
            employee.lastName = lastName;
            employee.salary = salary;
            employee.next = null;
            return employee;
        }
    }

    //Method to Add Employees
    public void addEmployee(int employeeID, String firstName, String lastName, double salary) throws Exception{

        Node employee = new Node(employeeID, firstName, lastName, salary);

        //Checks if the list is empty
        if(start == null){
            start = employee;   //if list is empty, both of the start
            end = employee;     // and end will point to the new node named employee
        } else{
            //new employee node will be added after end and .next will point to new employee node
            end.next = employee;

            //new employee node will become new end of the list
            end = employee;
        }

    }


    //Method to search Employee (Based either in last name or first name)
    public void searchEmployee(Node start, String lastName) throws Exception{
        Node pointer = start;
        int i = 0;
        boolean flag = false;

        //Checks whether list is empty
        if(start == null) {
            throw new Exception("List is empty");
        }
        else {
            while(pointer != null) {

                //Compares employee node to be found with each employee node that is present on the list
                if(pointer.lastName == lastName) {
                    flag = true;
                    break;
                }
                i++;
                pointer = pointer.next;
            }
        }
        if(flag)
            //if true
            System.out.println("Employee is  on the list : " + i + "\n" + pointer.employeeID +
                    "\n" + pointer.firstName + " " + pointer.lastName +
                    "\n" + pointer.salary);
        else
            //if false
            System.out.println("Employee is not found.");
    }


    //Method that Gets The Total Number of Employees
    public int getTotalEmployees() throws Exception{

        int count = 0;      //initializing count
        Node pointer = start;   //pointer variable pointing to the start node

        //Traverse thru the linked list
        while (pointer != null){
            count++;    //adds the total nodes of employees
            pointer = pointer.next;     //goes to the next node
        }

        System.out.println();
        return count;       //returns the total number of employees
    }

    //Method that Gets the Total Average of Salary
    public void getSalaryAverage() throws Exception{

        DecimalFormat df = new DecimalFormat("#.00");

        int count = 0, sum = 0, avg = 0;

        Node pointer = start;

        while (pointer != null){
            sum = (int) (sum + pointer.salary);     //getting the sum of the salaries
            count++;        //sum up all salaries
            pointer = pointer.next;
        }

        avg = sum / count;  //getting the average of salary

        //prints total salary average in 2 decimal format
        System.out.println("Total Salary Average : " + df.format(avg));
    }

    //Method that deletes an Employee based on the ID
    public Node deleteEmployee(int deleteKeyID) throws Exception{

        //Checks if list is empty
        if(start == null){
            throw new Exception("List is empty");
        }

        //Compares the start node with a data of employeeID
        //and the deleteKeyID to be search with each employee node
        if(start.employeeID == deleteKeyID){

            //pointer points to start for traversing
            Node pointer = start;

            //start node points next node
            start = start.next;

            System.out.println("Employee " + pointer.employeeID + " has been deleted");
            return pointer;
        }

        Node prevPtr = null;        //prevPtr variable is currently null
        Node currentEmp = start;    //currentEmp variable points the start node

        //Traverse thru the list
        while(currentEmp != null) {

            //Compares the current node's data to a deleteKeyID to be deleted
            if (currentEmp.employeeID == deleteKeyID) {

                //prints the deleted employee
                System.out.println("Employee " + currentEmp.employeeID + " has been deleted");

                //prevPtr's address is now pointing to the currentEmployee node's address
                prevPtr.next = currentEmp.next;

                //returns current Employee that is deleted
                return currentEmp;
            } else {

                //Checks if current employee is null
                if (currentEmp.next == null) {

                    //not found
                    System.out.println("Employee " + deleteKeyID + " was not found");
                    return null;
                }
                //prevPtr points current Employee node
                prevPtr = currentEmp;

                //current Employee node points the next node
                currentEmp = currentEmp.next;
            }
        }
        return null;
    }

    //Method that displays and counts employee according to the salary range.
    public void salaryRange() throws Exception{

        Node pointer = start, index = null;
        int temp;   //a temporary variable that stores the compared salary

        //Checks if null is empty
        if(start == null){
            throw new Exception("List is empty");
        } else{

            //Traversing thru the list
            while(pointer != null){
                index = pointer.next;

                while (index != null){
                    if(pointer.salary < index.salary){

                        temp = (int) pointer.salary;
                        pointer.salary = index.salary;
                        index.salary = temp;

                    }
                    index = index.next;
                }
                pointer = pointer.next;
            }
        }
        displayEmployees();
    }

    //Method which traverse Linked List and display all data.
    public void displayEmployees() throws Exception{

        //Decimal format for salaries
        DecimalFormat df = new DecimalFormat("#.00");

        Node pointer = start;   //pointer variable points the start and used for traversing

        //Labels
        System.out.println("============= List of Employees =============");
        System.out.println("ID" + "\t\t\t" + "Name" + "\t\t\t\t" + "Salary");

        //Checks if the list is empty
        if(start == null){
            throw new Exception("List is empty");
        }

        //Traverse thru the linked list
        while (pointer != null){

            //prints the data of the pointed node
            System.out.println(pointer.employeeID + "\t\t" + pointer.firstName + " " +
                    pointer.lastName + " " + "\t\t" + df.format(pointer.salary));

            //goes to the next node
            pointer = pointer.next;
        }

    }
}
