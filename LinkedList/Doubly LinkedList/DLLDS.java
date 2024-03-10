public class DLLDS {
    public static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;

    public DLLDS() {
        this.head = null;
    }

    public void insertAtFront(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }



    public void insertAtAnyIndex(int data, int index) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next.prev = newNode;
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    

    public void deleteAtFront() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
        } else {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        }
    }

    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
        } else if (head.next == null) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.prev.next = null;
        }
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <==> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void displayReverse(Node head) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        while (temp != null) {
            System.out.print(temp.data + " <==> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    public void displayReverseFromTail(Node tail){
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " <==> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    public void displayReverseRecursive(Node node) {
        if (node == null) {
            return;
        }
        displayReverseRecursive(node.next);
        System.out.print(node.data + " <==> ");
    }


    public void displayWithRandom(Node random){
        Node temp = random;
        while(temp != null){
            temp = temp.prev;
        }

        while(temp != null){
            System.out.print(temp.data + " <==> ");
            temp = temp.next;
        }
        System.out.println();

    }

    public static void main(String[] args) {
        DLLDS dll = new DLLDS();
        dll.insertAtFront(30);
        dll.insertAtFront(20);
        dll.insertAtFront(10);
        dll.insertAtEnd(40);
        dll.insertAtEnd(50);
        dll.printList();

        //dll.deleteAtFront();
        //dll.deleteAtEnd();
       // dll.printList();
        // dll.displayReverse(dll.head);
        // dll.displayReverseRecursive(dll.head);
        // dll.displayReverseFromTail(dll.head.next.next.next.next.next);

        dll.displayWithRandom(dll.head.next.next);   // 50 40 30 20 10
    }
}


