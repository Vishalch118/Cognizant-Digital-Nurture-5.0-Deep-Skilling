public class Main {

    public static void main(String[] args) {

        EmployeeManagement em = new EmployeeManagement();

        em.addEmployee(new Employee(101, "Vishal", "Manager", 50000));
        em.addEmployee(new Employee(102, "Rahul", "Developer", 40000));
        em.addEmployee(new Employee(103, "Amit", "Tester", 35000));

        System.out.println("Employees:");
        em.traverseEmployees();

        System.out.println("\nSearch Employee 102:");
        Employee e = em.searchEmployee(102);

        if (e != null)
            e.display();

        em.deleteEmployee(102);

        System.out.println("\nAfter Deletion:");
        em.traverseEmployees();
    }
}