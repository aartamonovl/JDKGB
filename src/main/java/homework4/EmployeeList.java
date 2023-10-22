package homework4;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList {
    private final List<Employee> employees;

    public EmployeeList() {
        employees = new ArrayList<>();
        generateEmployee();
    }

    private void generateEmployee() {
        employees.add(new Employee("123", "Andrey", 2));
        employees.add(new Employee("123123", "Nata", 1));
        employees.add(new Employee("12", "Alex", 5));
        employees.add(new Employee("5488", "Collin", 5));
        employees.add(new Employee("999", "Katrine", 0));
        employees.add(new Employee("999", "Andrey", 0));
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void printName(List<Employee> employeeList) {
        if (!employeeList.isEmpty()) {
            for (Employee employee : employeeList) {
                System.out.println(employee.getName());
            }
        } else {
            System.out.println("List is Empty");
        }
        System.out.println();
    }

    public void printPhone(List<Employee> employeeList) {
        if (!employeeList.isEmpty()) {
            for (Employee employee : employeeList) {
                System.out.println(employee.getPhoneNumber());
            }
        } else {
            System.out.println("List is Empty");
        }
        System.out.println();
    }

    public void printEmployee(Employee employee) {
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Employee is Empty");
        }
        System.out.println();
    }

    public List<Employee> findEmployeeForExperience(int exp) {
        List<Employee> list = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getExperience() == exp)
                list.add(employee);
        }
        return list;
    }

    public List<Employee> findEmployeeForName(String name) {
        List<Employee> list = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getName().equalsIgnoreCase(name))
                list.add(employee);
        }
        return list;
    }

    public Employee findEmployeeForEmployeeNumber(int empNumber) {
        for (Employee employee : employees) {
            if (employee.getEmployeeNumber() == empNumber)
                return employee;
        }
        return null;
    }

    public void addEmployee(String phoneNumber, String name, int experience){
        employees.add(new Employee(phoneNumber, name, experience));
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Employee employee: employees){
            sb.append(employee).append("\n");
        }
        return sb.toString();
    }
}
