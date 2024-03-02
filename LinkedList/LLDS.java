public class LLDS {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }             

    Node head;
    Node tail=null; // Declare the head variable

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void insertAtPosition(int data, int position) {
        if (position < 0) {
            throw new IllegalArgumentException("Invalid position");
        }
        if (position == 0) {
            insertAtBeginning(data);
            return;
        }
        Node current = head;
        Node prev = null;
        int count = 0;
        while (current != null && count < position) {
            prev = current;
            current = current.next;
            count++;
        }
        if (current == null && position > count) {
            throw new IndexOutOfBoundsException("Position out of bounds");
        }
        Node newNode = new Node(data);
        if (prev != null) {
            prev.next = newNode;
        }
        newNode.next = current;
        if (current == null) {
            tail = newNode;
        }
    }

    public void deleteAtBeginning() {
        if (isEmpty()) {
            return;
        }
        Node deletedNode = head;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        deletedNode.next = null; // for garbage collection
    }

    public void deleteAtEnd() {
        if (isEmpty()) {
            return;
        }
        if (head == tail) {
            head = tail = null;
            return;
        }
        Node current = head;
        Node prev = null;
        while (current.next != null) {
            prev = current;
            current = current.next;
        }
        prev.next = null;
        tail = prev;
    }

    public void deleteAtPosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("Invalid position");
        }
        if (position == 0) {
            deleteAtBeginning();
            return;
        }
        Node current = head;
        Node prev = null;
        int count = 0;
        while (current != null && count < position) {
            prev = current;
            current = current.next;
            count++;
        }
        if (current == null && position > count) {
            throw new IndexOutOfBoundsException("Position out of bounds");
        }
        if (prev != null) {
            prev.next = current.next;
        }
        if (current == tail) {
            tail = prev;
        }
        current.next = null; // for garbage collection
    }

    public int get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Invalid index");
        }
        Node current = head;
        int count = 0;
        while (current != null && count < index) {
            current = current.next;
            count++;
        }
        if (current == null) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return current.data;
    }

    public void traverse() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Additional functionalities:

    public void search(int data) {
        Node current = head;
        int index = 0;
        while (current != null) {

            if (current.data == data) {
                System.out.println("Element found at index: " + index);
                return;
            }
            current = current.next;
            index++;
        }
        System.out.println("Element not found");
    }

    public void reverse() {
        Node current = head;
        Node prev = null;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        tail = head;
        head = prev;
    }

    public void clear() {
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = null; // for garbage collection
            current = next;
        }
        head = tail = null;
    }

    public static void main(String[] args) {
        LLDS list = new LLDS();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);
        list.traverse();
        list.search(3);
        list.reverse();
        list.traverse();
        list.clear();
        list.traverse();
    }

}