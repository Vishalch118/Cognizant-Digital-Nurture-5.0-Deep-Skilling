public class MVCPatternExample {

    public static void main(String[] args) {

        // Create Model
        Student student = new Student("Vishal", 101, "A");

        // Create View
        StudentView view = new StudentView();

        // Create Controller
        StudentController controller =
                new StudentController(student, view);

        // Display initial details
        System.out.println("Initial Student Details:");
        controller.updateView();

        // Update student details through controller
        controller.setStudentName("Rahul");
        controller.setStudentGrade("A+");

        System.out.println("\nUpdated Student Details:");
        controller.updateView();
    }
}