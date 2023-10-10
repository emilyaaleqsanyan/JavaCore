package homework.Employee;

import homework.Employee.Employee;

public class EmployeeStorage {
    private Employee[] employees = new Employee[10];
    private int size;

    public void add(Employee employee) {
        if (size == employees.length) {
            extend();
        }
        employees[size++] = employee;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);

        }
    }


    public void searchById(String keyword) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeID().contains(keyword)) {
                System.out.println(employees[i].getName() + " " + employees[i].getSurname() + " " + employees[i].getEmployeeID() + " " + employees[i].getSalary() + " " + employees[i].getCompany());
                ;

            }
        }
    }
        private int getIndexById(String employeeId) {
            for (int i = 0; i < size; i++) {
                if (employees[i].getEmployeeID().equals(employeeId)) {
                    return i;
                }
            }
            return -1;


        }


    public  Employee getById(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeID().equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    public void deleteBYID(String id) {
        int indexById = getIndexById(id);
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeID().equals(id)) {
                employees[i - 1] = employees[i];
            }
            size--;
        }
    }


    public void searchByCompany(String keyword1) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getCompany().contains(keyword1)) {
                System.out.println(employees[i].getName() + " " + employees[i].getSurname() + " " + employees[i].getEmployeeID() + " " + employees[i].getSalary() + " " + employees[i].getCompany());
            }
        }
    }

    private void extend() {
        Employee[] tmp = new Employee[employees.length + 10];
        System.arraycopy(employees, 0, tmp, 0, employees.length);
        employees = tmp;
    }


}


