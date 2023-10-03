package homework.employee;

import classwork.library.Book;
import classwork.library.BookStorage;

import java.util.Scanner;

public class EmployeeDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeStorage employeeStorage = new EmployeeStorage();
        boolean isRun = true;

        while (isRun) {
            System.err.println("Please input 0 for EXIT");
            System.err.println("Please input 1 for ADD EMPLOYEE");
            System.err.println("Please input 2 for PRINT ALL EMPLOYEE");
            System.err.println("Please input 3 for SEARCH EMPLOYEE BY EMPLOYEE ID");
            System.err.println("Please input 4 for SEARCH EMPLOYEE BY COMPANY NAME");
            String command = scanner.nextLine();
            switch (command) {
                case "0":
                    isRun = false;
                    break;
                case "1":
                    System.out.println("Please input employee name");
                    String name = scanner.nextLine();
                    System.out.println();
                    System.out.println("Please input surname");
                    String surname = scanner.nextLine();
                    System.out.println();
                    System.out.println("Please input employeeID");
                    String employeeID = scanner.nextLine();
                    System.out.println();
                    System.out.println("Please input salary");
                    double salary = Double.parseDouble(scanner.nextLine());
                    System.out.println();
                    System.out.println("Please input company name");
                    String company = scanner.nextLine();
                    System.out.println();
                    System.out.println("Please input position");
                    String position = scanner.nextLine();

                    Employee employee = new Employee(name, surname, employeeID, salary, company, position);
                    employeeStorage.add(employee);
                    System.out.println("Employee created!");
                    break;
                case "2":
                    System.out.println("**************");
                    employeeStorage.print();
                    System.out.println("**************");
                    break;
                case "3":
                case"4":
                    System.out.println("Please input keyword");
                    String keyword = scanner.nextLine();
                    employeeStorage.search(keyword);
                    break;



            }


        }

    }
}
