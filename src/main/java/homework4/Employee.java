package homework4;

public class Employee {
    private String phoneNumber;
    private static int EMPLOYEE_NUMBER = 1000;
    private final int employeeNumber;
    private String name;
    private int experience;

    public Employee(String phoneNumber, String name, int experience) {
        this.phoneNumber = phoneNumber;
        this.employeeNumber = EMPLOYEE_NUMBER++;
        this.name = name;
        this.experience = experience;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", employeeNumber=" + employeeNumber +
                ", name='" + name + '\'' +
                ", experience=" + experience +
                '}';
    }
}
