// Queue class (using Linked List for Queue operations)
class Queue {
    private StudentLinkedList queueList;

    public Queue() {

        queueList = new StudentLinkedList();
    }

    // Enqueue student to the queue
    public void enqueue(Student student) {

        queueList.addStudent(student);
    }

    // Dequeue student from the queue
    public Student dequeue() {
        if (queueList.isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        Student student = queueList.head.student;
        queueList.deleteStudent(student.rollNumber);
        return student;
    }

    // Peek at the front of the queue
    public Student peek() {
        if (queueList.isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        return queueList.head.student;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return queueList.isEmpty();
    }

    // Method to display all students in the waiting list
    public void displayWaitingList() {
        if (queueList.isEmpty()) {
            System.out.println("Waiting list is empty.");
            return;
        }

        Node temp = queueList.head;
        while (temp != null) {
            System.out.println("\nRoll Number: " + temp.student.rollNumber);
            System.out.println("Name: " + temp.student.name);
            System.out.println("Age: " + temp.student.age);
            System.out.println("Marks: " + temp.student.marks);
            temp = temp.next;
        }
    }
}
