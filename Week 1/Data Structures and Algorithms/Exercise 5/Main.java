public class Main {

    public static void main(String[] args) {

        TaskManagement tm = new TaskManagement();

        tm.addTask(new Task(1, "Design UI", "Pending"));
        tm.addTask(new Task(2, "Develop Backend", "In Progress"));
        tm.addTask(new Task(3, "Testing", "Pending"));

        System.out.println("Tasks:");
        tm.traverseTasks();

        System.out.println("\nSearch Task:");
        tm.searchTask(2);

        tm.deleteTask(2);

        System.out.println("\nAfter Deletion:");
        tm.traverseTasks();
    }
}