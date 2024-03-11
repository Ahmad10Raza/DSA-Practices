public class DoublyCircularLinkedList {

  private Node head;
  private Node tail;

  // Node class to store data and references to previous and next nodes
  private static class Node {
    int data;
    Node prev;
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
      head = newNode;
      newNode.prev = newNode;
      newNode.next = newNode;
    } else {
      newNode.prev = tail;
      newNode.next = head;
      head.prev = newNode;
      tail.next = newNode;
      head = newNode;
    }
  }

  // Insert a new node at the end of the list
  public void insertAtEnd(int data) {
    Node newNode = new Node(data);
    if (isEmpty()) {
      head = newNode;
      newNode.prev = newNode;
      newNode.next = newNode;
    } else {
      newNode.prev = tail;
      newNode.next = head;
      tail.next = newNode;
      head.prev = newNode;
      tail = newNode;
    }
  }

  // Delete a node with the given data
  public void deleteNode(int data) {
    if (isEmpty()) {
      System.out.println("List is empty");
      return;
    }
    Node current = head;

    while (current != null) {
      if (current.data == data) {
        if (current == head) {
          head = head.next;
        }
        if (current == tail) {
          tail = tail.prev;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        return;
      }
      current = current.next;
    }
    System.out.println("Node not found");
  }

  // Print the contents of the list in forward direction
  public void printListForward() {
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

  // Print the contents of the list in backward direction (optional)
  public void printListBackward() {
    if (isEmpty()) {
      System.out.println("List is empty");
      return;
    }
    Node current = tail;
    do {
      System.out.print(current.data + " -> ");
      current = current.prev;
    } while (current != tail);
    System.out.println("TAIL");
  }


  public static void main(String[] args) {
    DoublyCircularLinkedList list = new DoublyCircularLinkedList();
    list.insertAtBeginning(10);
    list.insertAtBeginning(20);
    list.insertAtEnd(30);
    list.insertAtEnd(40);
    list.insertAtBeginning(5);
    list.insertAtEnd(50);
    list.printListForward();
    list.printListBackward();
    list.deleteNode(20);
    list.deleteNode(50);
    list.deleteNode(5);
    list.printListForward();
    list.printListBackward();
  }
}
