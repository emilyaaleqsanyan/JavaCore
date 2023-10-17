package homework.employeemanagment;

import homework.employeemanagment.model.Company;
import homework.employeemanagment.model.Employee;
import homework.employeemanagment.storage.CompanyStorage;
import homework.employeemanagment.storage.EmployeeStorage;
import homework.employeemanagment.util.DateUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class EmployeeManagementMain {
   private final static Scanner scanner = new Scanner(System.in);
    private final static EmployeeStorage employeeStorage = new EmployeeStorage();
    private final static CompanyStorage companyStorage = new CompanyStorage();

    public static void main(String[] args) throws ParseException {
        boolean isRun = true;

        while (isRun) {
            printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case "0":
                    isRun = false;
                    break;
                case "1":
                    addCompany();
                    break;
                case "2":
                    addEmployee();
                    break;
                case "3":
                    companyStorage.print();
                    break;
                case "4":
                    employeeStorage.print();
                    break;
                case "5":
                    searchEmployeeByID();
                    break;
                case "6":
                    searchEmployeeBYCompany();
                    break;
                case "7":
                    deleteCompany();
                    break;
                case "8":
                    deleteEmployee();
                    break;
                case "9":
                    changeCompany();
                    break;
                case "10":
                    changeEmployee();
                    break;
                default:
                    System.out.println("invalid command. Try again!");
            }


        }

    }

    private static void changeEmployee() {
        System.out.println("Please choose company id");
        companyStorage.print();
        String companyId = scanner.nextLine();
        Company companyFromStorage = companyStorage.getById(companyId);
        if (companyFromStorage == null) {
            System.out.println("Company with " + companyId + "does not exists!!!");
            return;
        }
        employeeStorage.searchEmployeesByCompany(companyFromStorage);
        System.out.println("please input employee id");
        String employeeId = scanner.nextLine();
        Employee employeeFromStorage = employeeStorage.getById(employeeId);
        if (employeeFromStorage == null) {
            System.out.println("employee with " + employeeId + "id does not exists");
            return;
        }
        System.out.println("please input employee name");
        String employeeName = scanner.nextLine();
        System.out.println("please input employee surname");
        String employeeSurname = scanner.nextLine();
        System.out.println("please input employee phone");
        String employeePhone = scanner.nextLine();
        System.out.println("please input employee position");
        String employeePosition = scanner.nextLine();
        System.out.println("please input employee salary AMD");
        double employeeSalary = Double.parseDouble(scanner.nextLine());
        employeeFromStorage.setName(employeeName);
        employeeFromStorage.setSurname(employeeSurname);
        employeeFromStorage.setPosition(employeePosition);
        employeeFromStorage.setSalary(employeeSalary);
        employeeFromStorage.setPhone(employeePhone);

        System.out.println("Employee updated!");
    }




    private static void changeCompany() {
        System.out.println("Please input company id");
        String companyId = scanner.nextLine();
        Company companyFromStorage = companyStorage.getById(companyId);
        if (companyFromStorage == null) {
            System.out.println("Company with " + companyId + "does not exists!!!");
            return;
        }
        System.out.println("please input new company name");
        String companyName = scanner.nextLine();
        System.out.println("please input new company address");
        String companyAddress = scanner.nextLine();
        companyFromStorage.setName(companyName);
        companyFromStorage.setAddress(companyAddress);
        System.out.println("company updated");
    }



    private static void deleteEmployee() {
        System.out.println("Please choose company id");
        companyStorage.print();
        String companyId = scanner.nextLine();
        Company companyFromStorage = companyStorage.getById(companyId);
        if (companyFromStorage == null) {
            System.out.println("Company with " + companyId + "does not exists!!!");
            return;
        }
        employeeStorage.searchEmployeesByCompany(companyFromStorage);

        System.out.println("please input employee id");
        String employeeId = scanner.nextLine();
        Employee employeeFromStorage = employeeStorage.getById(employeeId);
        if (employeeFromStorage == null) {
            System.out.println("employee does not  exists!");
            return;
        }
        if(!employeeFromStorage.getCompany().equals(companyFromStorage)){
            System.out.println("Wrong employee Id.");
            return;
        }
        employeeStorage.deleteById(employeeId);
    }

    private static void deleteCompany() {
        System.out.println("Please choose company id");
        companyStorage.print();
        String companyId = scanner.nextLine();
        Company companyFromStorage = companyStorage.getById(companyId);
        if (companyFromStorage == null) {
            System.out.println("Company with " + companyId + "does not exists!!!");
            return;
        }
        companyStorage.deleteById(companyId);
    }

    private static void searchEmployeeBYCompany() {
        System.out.println("Please choose company id");
        companyStorage.print();
        String companyId = scanner.nextLine();
        Company companyFromStorage = companyStorage.getById(companyId);
        if (companyFromStorage == null) {
            System.out.println("Company with " + companyId + "does not exists!!!");
            return;
        }
        employeeStorage.searchEmployeesByCompany(companyFromStorage);

    }

    private static void searchEmployeeByID() {
        System.out.println("please input employee id");
        String employeeID = scanner.nextLine();
        Employee byID = employeeStorage.getById(employeeID);
        if(byID == null){
            System.out.println("employee dose not exists");
        }else{
            System.out.println(byID);
        }

    }


    private static void addEmployee() throws ParseException {
        System.out.println("Please choose company id");
        companyStorage.print();
        String companyId = scanner.nextLine();
        Company companyFromStorage = companyStorage.getById(companyId);
        if (companyFromStorage == null) {
            System.out.println("Company with " + companyId + "does not exists!!!");
            return;
        }
        System.out.println("please input employee id");
        String employeeId = scanner.nextLine();
        Employee employeeFromStorage = employeeStorage.getById(employeeId);
        if (employeeFromStorage != null) {
            System.out.println("employee with " + employeeId + "is already exists");
            return;
        }
        System.out.println("please input employee name");
        String employeeName = scanner.nextLine();
        System.out.println("please input employee surname");
        String employeeSurname = scanner.nextLine();
        System.out.println("please input employee phone");
        String employeePhone = scanner.nextLine();
        System.out.println("please input employee position");
        String employeePosition = scanner.nextLine();
        System.out.println("please input employee salary AMD");
        double employeeSalary = Double.parseDouble(scanner.nextLine());
        System.out.println("please input employee date of birthday (dd-MM-yyyy)");
        String dateOfBirthdayStr = scanner.nextLine();
         Date dateOfBirthday = DateUtil.stringToDate(dateOfBirthdayStr);
         Date registerDate = new Date();
        Employee employee = new Employee(employeeId, employeeName, employeeSurname, employeePhone, employeeSalary, employeePosition, companyFromStorage, dateOfBirthday, registerDate);
        employeeStorage.add(employee);
        System.out.println("Employee registered!");
    }


    private static void addCompany() {
        System.out.println("Please input company id");
        String companyId = scanner.nextLine();
        Company companyFromStorage = companyStorage.getById(companyId);
        if (companyFromStorage != null) {
            System.out.println("Company with " + companyId + "already exists!!!");
            return;
        }
        System.out.println("please input company name");
        String companyName = scanner.nextLine();
        System.out.println("please input company address");
        String companyAddress = scanner.nextLine();
        Company company = new Company(companyId, companyName, companyAddress);
        companyStorage.add(company);
        System.out.println("company registered.");
    }


    private static void printCommands() {
        System.out.println("Please input 0 for EXIT");
        System.out.println("Please input 1 for ADD_COMPANY");
        System.out.println("Please input 2 for ADD_EMPLOYEE");
        System.out.println("Please input 3 for PRINT _ALL_COMPANIES");
        System.out.println("Please input 4 for PRINT_ALL_EMPLOYEES");
        System.out.println("Please input 5 for SEARCH_EMPLOYEES_BY_ID");
        System.out.println("Please input 6 for SEARCH_EMPLOYEES_BY_COMPANY");
        System.out.println("Please input 7 for DELETE_COMPANY");
        System.out.println("Please input 8 for DELETE_EMPLOYEE");
        System.out.println("Please input 9 for CHANGE_COMPANY");
        System.out.println("Please input 10 for CHANGE_EMPLOYEE");
    }
}





