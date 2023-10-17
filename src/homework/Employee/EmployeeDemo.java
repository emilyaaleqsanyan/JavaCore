package homework.Employee;

import java.util.Scanner;

public class EmployeeDemo {
   static Scanner scanner = new Scanner(System.in);
   static EmployeeStorage employeeStorage = new EmployeeStorage();

    public static void main(String[] args) {
        boolean isRun = true;


        while (isRun) {
            printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case "0":
                    isRun = false;
                    break;
                case "1":
                    addEmployee();
                    break;
                case "2":
                    printAllEmployee();
                    break;
                case "3":
                   searchBYID();
                    break;

                case "4":
                    searchByCompany();
                    break;
                case"5":
                    deleteBYID();
                    break;
                case"6":
                    changeEmployeeBYId();
                    break;
                default:
                    System.out.println("Invalid command. Try again!");
            }


        }

    }

    private static void changeEmployeeBYId() {
        System.out.println("Please input employee id");
        String employeeId = scanner.nextLine();
        Employee employeeFromStorage = employeeStorage.getById(employeeId);
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

        employeeFromStorage.setName(name);
        employeeFromStorage.setSurname(surname);
        employeeFromStorage.setEmployeeID(employeeID);
        employeeFromStorage.setSalary(salary);
        employeeFromStorage.setCompany(company);
        employeeFromStorage.setPosition(position);

        System.out.println("Employee updated!");

    }


    private static void deleteBYID() {
        System.out.println("Please input id");
        String id = scanner.nextLine();
        employeeStorage.deleteBYID(id);
    }

    public static void searchByCompany(){
        System.out.println("Please input keyword1");
        String keyword1 = scanner.nextLine();
        employeeStorage.searchByCompany(keyword1);


    }
    public static void searchBYID(){
        System.out.println("Please input keyword");
        String keyword = scanner.nextLine();
        employeeStorage.searchById(keyword);
    }
    public static void printAllEmployee(){
        System.out.println("**************");
        employeeStorage.print();
        System.out.println("**************");

    }
    public static void addEmployee(){
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
    }
    public static void printCommands(){
        System.err.println("Please input 0 for EXIT");
        System.err.println("Please input 1 for ADD EMPLOYEE");
        System.err.println("Please input 2 for PRINT ALL EMPLOYEE");
        System.err.println("Please input 3 for SEARCH EMPLOYEE BY EMPLOYEE ID");
        System.err.println("Please input 4 for SEARCH EMPLOYEE BY COMPANY NAME");
        System.err.println("Please input 5 for DELETE BY ID");
        System.err.println("Please input 6 for CHANGE EMPLOYEE BY ID");

    }
}

