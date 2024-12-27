import java.util.Scanner;

class StudentManagementSystem {
    private StudentLinkedList studentList;
    private Stack deletedStudentsStack;
    private Queue waitingList;

    public StudentManagementSystem() {
        studentList = new StudentLinkedList();
        deletedStudentsStack = new Stack();
        waitingList = new Queue();
    }

    public void addStudent(Scanner scanner) {
        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();  // Consume newline character
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        System.out.print("Enter student marks: ");
        float marks = scanner.nextFloat();

        Student student = new Student(rollNumber, name, age, marks);
        studentList.addStudent(student);
        System.out.println("Student added successfully!");
    }

    public void displayStudents() {
        studentList.displayStudents();
    }

    public void updateStudent(Scanner scanner) {
        System.out.print("Enter roll number of student to update: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();  // Consume newline character
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new age: ");
        int age = scanner.nextInt();
        System.out.print("Enter new marks: ");
        float marks = scanner.nextFloat();

        if (studentList.updateStudent(rollNumber, name, age, marks)) {
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    public void deleteStudent(Scanner scanner) {
        System.out.print("Enter roll number of student to delete: ");
        int rollNumber = scanner.nextInt();

        // Store deleted student in the stack for undo functionality
        Node temp = studentList.head;
        while (temp != null) {
            if (temp.student.rollNumber == rollNumber) {
                deletedStudentsStack.push(temp.student);
                break;
            }
            temp = temp.next;
        }

        if (studentList.deleteStudent(rollNumber)) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    public void restoreDeletedStudent() {
        if (deletedStudentsStack.isEmpty()) {
            System.out.println("No student to restore.");
            return;
        }

        Student student = deletedStudentsStack.pop();
        studentList.addStudent(student);
        System.out.println("Deleted student restored successfully!");
    }

    public void enqueueStudent(Scanner scanner) {
        System.out.print("Enter roll number of student to add to waiting list: ");
        int rollNumber = scanner.nextInt();
        Node temp = studentList.head;
        while (temp != null) {
            if (temp.student.rollNumber == rollNumber) {
                waitingList.enqueue(temp.student);
                System.out.println("Student added to waiting list.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found!");
    }

    public void dequeueStudent() {
        Student student = waitingList.dequeue();
        if (student != null) {
            System.out.println("Student dequeued: " + student.name);
        }
    }

    public void sortStudentsByMarks() {
        studentList.sortStudentsByMarks();
        System.out.println("Students sorted by marks.");
    }

    public void displayWaitingList() {
        waitingList.displayWaitingList();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem system = new StudentManagementSystem();

        int choice;
        do {
            System.out.println("\n----- Student Management System -----");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Restore Last Deleted Student");
            System.out.println("6. Add Student to Waiting List");
            System.out.println("7. Remove Student from Waiting List");
            System.out.println("8. Sort Students by Marks");
            System.out.println("9. Display Waiting List");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    system.addStudent(scanner);
                    break;
                case 2:
                    system.displayStudents();
                    break;
                case 3:
                    system.updateStudent(scanner);
                    break;
                case 4:
                    system.deleteStudent(scanner);
                    break;
                case 5:
                    system.restoreDeletedStudent();
                    break;
                case 6:
                    system.enqueueStudent(scanner);
                    break;
                case 7:
                    system.dequeueStudent();
                    break;
                case 8:
                    system.sortStudentsByMarks();
                    break;
                case 9:
                    system.displayWaitingList();
                    break;
                case 10:
                    System.out.println("Exiting the system...\nThankyou" + "");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 10);

        scanner.close();
    }
}



