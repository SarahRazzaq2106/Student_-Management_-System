// Stack class (using Linked List for Stack operations)
class Stack {
    private StudentLinkedList stackList;

    public Stack() {
        stackList = new StudentLinkedList();
    }

    // Push student to the stack
    public void push(Student student) {
        stackList.addStudent(student);
    }

    // Pop student from the stack
    public Student pop() {
        if (stackList.isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        Node temp = stackList.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Student student = temp.student;
        stackList.deleteStudent(student.rollNumber); // Remove student from list (stack)
        return student;
    }

    // Peek at the top student
    public Student peek() {
        if (stackList.isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        Node temp = stackList.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp.student;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return stackList.isEmpty();
    }
}

