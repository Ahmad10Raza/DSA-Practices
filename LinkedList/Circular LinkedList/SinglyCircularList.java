public class SinglyCircularList {

    private Node head;
    private Node tail;
  
    // Node class to store data and reference to next node
    private static class Node {
      int data;
      Node next;
  
      Node(int data) {
        this.data = data;
      }
    }
  
    // Check if list is empty
    public boolean isEmpty() {
      return head == null;
    }
  
    // Insert a new node at the beginning of the list
    public void insertAtBeginning(int data) {
      Node newNode = new Node(data);
      if (isEmpty()) {
        head = tail = newNode;
        newNode.next = head;
      } else {
        newNode.next = head;
        head = newNode;
        tail.next = head;
      }
    }
  
    // Insert a new node at the end of the list
    public void insertAtEnd(int data) {
      Node newNode = new Node(data);
      if (isEmpty()) {
        head = tail = newNode;
        newNode.next = head;
      } else {
        tail.next = newNode;
        tail = newNode;
        tail.next = head;
      }
    }

    public void insertAtIndex(int data, int index) {
        Node newNode = new Node(data);
        if (isEmpty()) {
          head = tail = newNode;
          newNode.next = head;
        } else {
          Node current = head;
          for (int i = 0; i < index - 1; i++) {
            current = current.next;
          }
          newNode.next = current.next;
          current.next = newNode;
        }
      }
  
    // Delete a node with the given data
    public void deleteNode(int data) {
      if (isEmpty()) {
        System.out.println("List is empty");
        return;
      }
      Node current = head;
      Node previous = null;
  
      while (current != null) {
        if (current.data == data) {
          if (previous == null) { // Delete head node
            if (head == tail) { // Single node list
              head = tail = null;
            } else {
              head = head.next;
              tail.next = head;
            }
          } else { // Delete node in the middle or at the end
            previous.next = current.next;
            if (current == tail) { // Update tail if deleting tail node
              tail = previous;
            }
          }
          return;
        }
        previous = current;
        current = current.next;
      }
      System.out.println("Node not found");
    }
  
    // Print the contents of the list
    public void printList() {
      if (isEmpty()) {
        System.out.println("List is empty");
        return;
      }
      Node current = head;
      do {
        System.out.print(current.data + " -> ");
        current = current.next;
      } while (current != head);
      System.out.println("HEAD");
    }

    public static void main(String[] args) {
      SinglyCircularList list = new SinglyCircularList();
      list.insertAtBeginning(1);
      list.insertAtBeginning(2);
      list.insertAtEnd(3);
      list.insertAtEnd(4);
      list.insertAtIndex(5, 2);
      list.printList();
      list.deleteNode(3);
      list.printList();
    }
  }
  