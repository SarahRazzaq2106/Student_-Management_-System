// Linked List class to manage students
class StudentLinkedList {
    Node head;

    public StudentLinkedList() {
        this.head = null;
    }

    // Method to add student to the linked list
    public void addStudent(Student student) {
        Node newNode = new Node(student);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Method to display all students
    public void displayStudents() {
        if (head == null) {
            System.out.println("No students to display.");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.println("\nRoll Number: " + temp.student.rollNumber);
            System.out.println("Name: " + temp.student.name);
            System.out.println("Age: " + temp.student.age);
            System.out.println("Marks: " + temp.student.marks);
            temp = temp.next;
        }
    }

    // Method to update student details by roll number
    public boolean updateStudent(int rollNumber, String name, int age, float marks) {
        Node temp = head;
        while (temp != null) {
            if (temp.student.rollNumber == rollNumber) {
                temp.student.name = name;
                temp.student.age = age;
                temp.student.marks = marks;
                return true;
            }
            temp = temp.next;
        }
        return false;  // Student not found
    }

    // Method to delete student by roll number
    public boolean deleteStudent(int rollNumber) {
        if (head == null) {
            return false;  // Empty list
        }

        if (head.student.rollNumber == rollNumber) {
            head = head.next;
            return true;
        }

        Node temp = head;
        while (temp.next != null && temp.next.student.rollNumber != rollNumber) {
            temp = temp.next;
        }

        if (temp.next == null) {
            return false;  // Student not found
        }

        temp.next = temp.next.next;  // Remove student node
        return true;
    }

    // Method to sort students by marks (Bubble Sort)
    public void sortStudentsByMarks() {
        if (head == null) return;

        Node current = head;
        Node index = null;
        Student tempStudent;

        while (current != null) {
            index = current.next;
            while (index != null) {
                if (current.student.marks > index.student.marks) {
                    tempStudent = current.student;
                    current.student = index.student;
                    index.student = tempStudent;
                }
                index = index.next;
            }
            current = current.next;
        }
    }

    // Method to check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }
}

