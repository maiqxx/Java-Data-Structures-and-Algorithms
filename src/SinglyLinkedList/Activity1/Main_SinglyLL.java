package SinglyLinkedList.Activity1;

//Write a menu-driven program that implements the linked list of employees which has variables: id, last name, first name, address, salary.
//
//[1] - Add Employee
//[2] - Search Employee (Based either in last name or first name)
//[3] - Display All Employee
//[4] - Get The Total Number of Employees
//[5] - Get the Total Average of Salary
//[6] - Delete an Employee based on the ID
//[7] - Display and count employee according to the salary range.
//[0] - Exit
//
//Your program should never accept any negative value in the salary. The ID should be unique.

import java.util.Scanner;

public class Main_SinglyLL {
    static Scanner input = new Scanner(System.in);
    public static void main(String [] args) throws Exception{

        Functions_SinglyLL employeeList = new Functions_SinglyLL();
        int menu;   //declaring variable to input/choose operations to perform
        boolean choice = true;

        while(choice){
            System.out.println();
            System.out.println();

            //Displays the list of operations
            System.out.println("============= List of Operations =============");
            System.out.println("[1] - Add Employee");
            System.out.println("[2] - Search Employee (Based either in last name or first name)");
            System.out.println("[3] - Display All Employee");
            System.out.println("[4] - Get The Total Number of Employees");
            System.out.println("[5] - Get the Total Average of Salary");
            System.out.println("[6] - Delete an Employee based on the ID");
            System.out.println("[7] - Display and count employee according to the salary range.");
            System.out.println("[0] - Exit");
            System.out.println();

            System.out.print("Input a number : ");
            menu = input.nextInt();
            System.out.println();

            switch(menu){
                case 1:
                    for(int i = 1; i < 5; i++){

                        //User's input for employee's ID
                        System.out.println("[Employee " + i + "]");
                        System.out.print("Employee's ID : ");
                        int employeeID = input.nextInt();
                        input.nextLine();

                        //User's input for employee's name
                        System.out.print("First Name : ");
                        String firstName = input.nextLine();
                        System.out.print("Last Name : ");
                        String lastName = input.nextLine();

                        //checks the user's input
                        boolean valid = true;
                        double salary = 0.0;

                        while (valid){
                            System.out.print("Salary : ");
                            salary = input.nextDouble();
                            if(salary > 0){
                                valid = false; //when salary input is negative or not valid
                            } else {
                                System.out.println("Invalid input");
                                System.out.println("[Enter positive numeric data for salary.]");
                            }
                        }
                        System.out.println();
                        employeeList.addEmployee(employeeID, firstName, lastName, salary);
                    }
                    employeeList.displayEmployees(); //calling method to display the list of employees from SinglyLinkedList_Op class
                    System.out.println();
                    break;

                case 2:
                    System.out.print("Input the employee's last name to search : ");
                    String lastName = input.nextLine();     //input for employee's lastname to search
                    employeeList.searchEmployee(employeeList.start, lastName);  //calling method to search an employee from SinglyLinkedList_Op class
                    System.out.println();
                    break;

                case 3:
                    employeeList.displayEmployees();    //calling method to display the list of employees from SinglyLinkedList_Op class
                    break;

                case 4:
                    //calling method to get the total number of employees from SinglyLinkedList_Op class
                    System.out.println("Total Number of Employees: "+ employeeList.getTotalEmployees());
                    break;

                case 5:
                    employeeList.getSalaryAverage();    //calling method to get the average salary of employees from SinglyLinkedList_Op class
                    break;

                case 6:
                    System.out.print("Enter an employee's ID number to delete: ");
                    int id = input.nextInt();
                    employeeList.deleteEmployee(id);    //calling method to delete a specific employee from SinglyLinkedList_Op class
                    break;

                case 7:
                    System.out.println("List of Employees According to Their Salary Range : ");
                    employeeList.salaryRange();         //calling method to display the list of employees base on their salary range from SinglyLinkedList_Op class
                    break;

                case 0:     //when 0 is entered, the program will stop
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
