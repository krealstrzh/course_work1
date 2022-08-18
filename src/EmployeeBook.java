public class EmployeeBook {
    private final Employee[] employeeBook;

    public EmployeeBook (Employee [] employeeBook) {
        this.employeeBook = employeeBook;
    }

    public void putEmployee(Employee employeeToPut) {
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] == null) {
                employeeBook[i] = employeeToPut;
                break;
            }
        }
    }

    public void printEmployeeList() {
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] != null) {
                System.out.println("Employee: " + employeeBook[i].toString() + " Salary: " + employeeBook[i].getSalary() + " rub" + " Department: " + employeeBook[i].getDepartmentNumber() + " ID: " + employeeBook[i].getId());
            } else {
                System.out.println("Пустой лот!");
                continue;
            }
        }
    }

    public int getExpensesTotal() {
        int sumSalary = 0;
        for (int i = 0; i < employeeBook.length && employeeBook[i] != null; i++) {
            sumSalary = employeeBook[i].getSalary() + sumSalary;
        }
        return sumSalary;
    }

    public void findMinSalary() {
        int minSalary = employeeBook[0].getSalary();
        int employeeMinNum = 0;
        for (int i = 0; i < employeeBook.length && employeeBook[i] != null; i++) {
            final int currentMinimum = employeeBook[i].getSalary();
            if (currentMinimum < minSalary) {
                minSalary = currentMinimum;
                employeeMinNum = i;
            }
        }
        System.out.println("Employee " + employeeBook[employeeMinNum].toString() + " has the lowest salary: " + employeeBook[employeeMinNum].getSalary() + " rub" + " ID: " + employeeBook[employeeMinNum].getId());
    }

    public void findMaxSalary() {
        int maxSalary = employeeBook[0].getSalary();
        int employeeMaxNum = 0;
        for (int i = 0; i < employeeBook.length && employeeBook[i] != null; i++) {
            final int currentMaximum = employeeBook[i].getSalary();
            if (currentMaximum > maxSalary) {
                maxSalary = currentMaximum;
                employeeMaxNum = i;
            }
        }
        System.out.println("Employee " + employeeBook[employeeMaxNum].toString() + " has the highest salary: " + employeeBook[employeeMaxNum].getSalary() + " rub" + " ID: " + employeeBook[employeeMaxNum].getId());
    }

    public double getMediumSalary() {
        double mediumSalary = 1.0 * (this.getExpensesTotal() / employeeBook.length);
        return mediumSalary;
    }

    public void getAllNames() {
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] != null) {
                System.out.println(employeeBook[i].toString());
            }
        }
    }

    public void indexAllSalaries(double percentIndex) {
        for (int i = 0; i < employeeBook.length && employeeBook[i] != null; i++) {
            int salaryAfterIndexation = (int) Math.round(employeeBook[i].getSalary() + (employeeBook[i].getSalary() * percentIndex / 100));
            employeeBook[i].setSalary(salaryAfterIndexation);
        }
    }

    public void findMinSalaryDepartment(int departmentNumber) {
        int minSalary = 0;
        for (int i = 0; i < employeeBook.length && employeeBook[i] != null; i++) {
            if (employeeBook[i].getDepartmentNumber() == departmentNumber) {
                minSalary = employeeBook[i].getSalary();
                break;
            } else if (departmentNumber > 5 && departmentNumber < 0) {
                throw new IllegalArgumentException("Wrong department number!");
            }
        }
        for (int i = 0; i < employeeBook.length && employeeBook[i] != null; i++) {
            int employeeMinNum = 0;
            if (departmentNumber == employeeBook[i].getDepartmentNumber() && employeeBook[i].getSalary() <= minSalary) {
                minSalary = employeeBook[i].getSalary();
                employeeMinNum = i;
                System.out.println("Employee " + employeeBook[employeeMinNum].toString() + " has the lowest salary in selected department: " + employeeBook[employeeMinNum].getSalary() + " rub" + " ID: " + employeeBook[employeeMinNum].getId());
            } else if (minSalary == 0) {
                System.out.println("Selected department is empty!");
            }
        }
    }

    public void findMaxSalaryDepartment(int departmentNumber) {
        int maxSalary = 0;
        for (int i = 0; i < employeeBook.length && employeeBook[i] != null; i++) {
            if (employeeBook[i].getDepartmentNumber() == departmentNumber) {
                maxSalary = employeeBook[i].getSalary();
            } else if (departmentNumber > 5 && departmentNumber < 0) {
                throw new IllegalArgumentException("Wrong department number!");
            }
        }
        for (int i = 0; i < employeeBook.length && employeeBook[i] != null; i++) {
            int employeeMaxNum = 0;
            if (departmentNumber == employeeBook[i].getDepartmentNumber() && employeeBook[i].getSalary() >= maxSalary) {
                maxSalary = employeeBook[i].getSalary();
                employeeMaxNum = i;
                System.out.println("Employee " + employeeBook[employeeMaxNum].toString() + " has the highest salary in selected department: " + employeeBook[employeeMaxNum].getSalary() + " rub" + " ID: " + employeeBook[employeeMaxNum].getId());
            } else if (maxSalary == 0) {
                System.out.println("Selected department is empty!");
            }
        }
    }

    public int getTotalSalaryDepartment (int departmentNumber) {
        int sumSalary = 0;
        for (int i = 0; i < employeeBook.length && employeeBook[i] != null; i++) {
            if (departmentNumber == employeeBook[i].getDepartmentNumber()) {
                sumSalary = sumSalary + employeeBook[i].getSalary();
            } else if (departmentNumber > 5 || departmentNumber < 0) {
                throw new IllegalArgumentException("Неверно указан отдел!");
            }
        }
        return sumSalary;
    }

    public double getMediumSalaryDepartment(int departmentNumber) {
        int sumSalary = 0;
        int counter = 0;
        for (int i = 0; i < employeeBook.length && employeeBook[i] != null; i++) {
            if (departmentNumber == employeeBook[i].getDepartmentNumber()) {
                sumSalary = sumSalary + employeeBook[i].getSalary();
                counter++;
            } else if (departmentNumber > 5 || departmentNumber < 0) {
                throw new IllegalArgumentException("Неверно указан отдел!");
            }
        }
        double mediumSalary = 1.0 * (sumSalary / counter);
        return mediumSalary;
    }

    public void indexSalariesInDepartment(int departmentNumber, double percentIndex) {
        for (int i = 0; i < employeeBook.length && employeeBook[i] != null; i++) {
            if (departmentNumber == employeeBook[i].getDepartmentNumber()) {
                int salaryAfterIndexation = (int) Math.round(employeeBook[i].getSalary() + (employeeBook[i].getSalary() * percentIndex / 100));
                employeeBook[i].setSalary(salaryAfterIndexation);
            } else if (departmentNumber > 5 || departmentNumber < 0) {
                throw new IllegalArgumentException("Неверно указан отдел!");
            }
        }
    }

    public void printDepartment(int departmentNumber) {
        for (int i = 0; i < employeeBook.length && employeeBook[i] != null; i++) {
            if (departmentNumber == employeeBook[i].getDepartmentNumber()) {
                System.out.println("Employee: " + employeeBook[i].toString() + " Salary: " + employeeBook[i].getSalary() + " rub" + " ID: " + employeeBook[i].getId());
            } else if (departmentNumber > 5 || departmentNumber < 0) {
                throw new IllegalArgumentException("Неверно указан отдел!");
            }
        }
    }
    public void findSalaryHigherThan (int salary) {
        int notFound = 0;
        for (int i = 0; i < employeeBook.length && employeeBook[i] != null; i++) {
            if (salary < employeeBook[i].getSalary()) {
                System.out.println("Employee " + employeeBook[i].toString() + " Salary: " + employeeBook[i].getSalary() + " rub ID: " + employeeBook[i].getId());
                notFound++;
            }
        }
        if (notFound == 0) {
            System.out.println("There are no employees with salary higher than " + salary + " rub");
        }
    }

    public void findSalaryLowerThan (int salary) {
        int notFound = 0;
        for (int i = 0; i < employeeBook.length && employeeBook[i] != null; i++) {
            if (salary > employeeBook[i].getSalary()) {
                System.out.println("Employee " + employeeBook[i].toString() + " Salary: " + employeeBook[i].getSalary() + " rub ID: " + employeeBook[i].getId());
                notFound++;
            }
        }
        if (notFound == 0) {
            System.out.println("There are no employees with salary lower than " + salary + " rub");
        }
    }

    public void createEmployee(String lastName, String firstName, String middleName, int salary, int departmentNumber) {
        Employee newEmployee = new Employee(lastName, firstName, middleName);
        newEmployee.setSalary(salary);
        newEmployee.setDepartmentNumber(departmentNumber);
        putEmployee(newEmployee);
    }

    public void deleteEmployeeByName(String lastName, String firstName, String middleName) {
        String fullName = lastName + " " + firstName + " " + lastName;
        for (int i = 0; i < employeeBook.length && employeeBook[i] != null; i++) {
            if (fullName.equalsIgnoreCase(employeeBook[i].toString())) {
                employeeBook[i] = null;
            }
        }
    }

    public void deleteEmployeeByID (int id) {
        for (int i = 0; i < employeeBook.length && employeeBook[i] != null; i++) {
            if (id == employeeBook[i].getId()) {
                employeeBook[i] = null;
            }
        }
    }

    public void changeEmployeeSalary(String lastName, String firstName, String middleName, int newSalary) {
        String fullName = lastName + " " + firstName + " " + lastName;
        for (int i = 0; i < employeeBook.length && employeeBook[i] != null; i++) {
            if (fullName.equalsIgnoreCase(employeeBook[i].toString())) {
                employeeBook[i].setSalary(newSalary);
            }
        }
    }

    public void changeEmployeeDepartment(String lastName, String firstName, String middleName, int newDepartment) {
        String fullName = lastName + " " + firstName + " " + lastName;
        for (int i = 0; i < employeeBook.length && employeeBook[i] != null; i++) {
            if (fullName.equalsIgnoreCase(employeeBook[i].toString())) {
                employeeBook[i].setDepartmentNumber(newDepartment);
            }
        }
    }

    public void printEmployeeNamesByDepartments() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Department " + i);
            for (int j = 0; j < employeeBook.length && employeeBook[j] != null; j++) {
                if (employeeBook[j].getDepartmentNumber() == i) {
                    System.out.println(employeeBook[j].toString());
                }
            }
        }
    }
}

