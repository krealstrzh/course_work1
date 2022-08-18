public class Employee {
    private String lastName;
    private String firstName;
    private String middleName;
    private int id;
    private static int counter = 1;
    private int departmentNumber;
    private int salary;

    public Employee (String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.id = counter;
        counter++;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public int getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(int departmentNumber) {
        if (departmentNumber <= 5 || departmentNumber > 0) {
            this.departmentNumber = departmentNumber;
        } else if (departmentNumber > 5) {
            throw new IllegalArgumentException("There are only 5 departments!");
        } else if (departmentNumber < 0) {
            throw new IllegalArgumentException("Department number cannot be lower than 0!");
        }
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return this.lastName + " " + this.firstName + " " +this.middleName;
    }
}
