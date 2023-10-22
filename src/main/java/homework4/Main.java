package homework4;

public class Main {
    public static void main(String[] args) {
        EmployeeList employeeList = new EmployeeList();
        System.out.println(employeeList);
        employeeList.printName(employeeList.findEmployeeForExperience(5));
        employeeList.printPhone(employeeList.findEmployeeForName("Andrey"));
        employeeList.printEmployee(employeeList.findEmployeeForEmployeeNumber(1000));
        employeeList.addEmployee("111", "Valera", 7);
        System.out.println(employeeList);
    }
}
