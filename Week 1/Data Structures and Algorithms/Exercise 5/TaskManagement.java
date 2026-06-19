class TaskManagement {

    Node head = null;

    // Add Task
    void addTask(Task task) {

        Node newNode = new Node(task);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    // Search Task
    void searchTask(int id) {

        Node temp = head;

        while (temp != null) {

            if (temp.task.taskId == id) {
                System.out.println(temp.task.taskId + " "
                        + temp.task.taskName + " "
                        + temp.task.status);
                return;
            }

            temp = temp.next;
        }

        System.out.println("Task Not Found");
    }

    // Traverse Tasks
    void traverseTasks() {

        Node temp = head;

        while (temp != null) {
            System.out.println(temp.task.taskId + " "
                    + temp.task.taskName + " "
                    + temp.task.status);

            temp = temp.next;
        }
    }

    // Delete Task
    void deleteTask(int id) {

        if (head == null)
            return;

        if (head.task.taskId == id) {
            head = head.next;
            return;
        }

        Node temp = head;

        while (temp.next != null &&
                temp.next.task.taskId != id) {

            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }
}