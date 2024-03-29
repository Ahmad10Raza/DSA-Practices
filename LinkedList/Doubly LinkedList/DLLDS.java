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



    public void insertAtIndex(int data, int index) {
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



    // function to delete node at any index

    public void deleteAtIndex(int index) {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            temp.next.prev = temp;
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

    public Node reverseDLL(Node head){
        Node temp = null;
        Node current = head;

        while(current != null){
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if(temp != null){
            head = temp.prev;
        }
        return head;
    }

    // function to Rotate DoublyLinked list by N nodes.

    public Node rotateDLLByN(Node head, int N){
        if(N == 0){
            return head;
        }
        Node current = head;
        int count = 1;
        while(count < N && current != null){
            current = current.next;
            count++;
        }
        if(current == null){
            return head;
        }
        Node NthNode = current;
        while(current.next != null){
            current = current.next;
        }
        current.next = head;
        head.prev = current;
        head = NthNode.next;
        head.prev = null;
        NthNode.next = null;
        return head;
    }

    // function Rotate a Doubly Linked list in group of Given Size.[Very IMP]

    public Node rotateDllInGroupSize(Node head, int k){
        
        Node prev = null;
        Node current = head;
        Node next = null; // Initialize next to null
        int count = 0;
        while(current != null && count < k){
            next = current.next;
            current.next = prev;
            current.prev = next;
            prev = current;
            current = next;
            count++;
        }

        if(next != null){
            head.next = rotateDllInGroupSize(next, k);
            
        }
        return prev;
    }

    public static void main(String[] args) {
        DLLDS dll = new DLLDS();
        dll.insertAtFront(30);
        dll.insertAtFront(20);
        dll.insertAtFront(10);
        dll.insertAtEnd(40);
        dll.insertAtEnd(50);
        dll.insertAtIndex(25, 2);
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


