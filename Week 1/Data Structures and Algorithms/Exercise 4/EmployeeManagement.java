class EmployeeManagement {

    Employee[] employees = new Employee[10];
    int count = 0;

    // Add Employee
    void addEmployee(Employee e) {
        if (count < employees.length) {
            employees[count] = e;
            count++;
        }
    }

    // Search Employee
    Employee searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse Employees
    void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            employees[i].display();
        }
    }

    // Delete Employee
    void deleteEmployee(int id) {
        for (int i = 0; i < count; i++) {

            if (employees[i].employeeId == id) {

                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }

                employees[count - 1] = null;
                count--;
                break;
            }
        }
    }
}