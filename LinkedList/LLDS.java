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

    public int sizeRecursive(Node current) {
        if (current == null) {
            return 0;
        }
        return 1 + sizeRecursive(current.next);
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

    public int getRecursive(Node current, int index) {
        if (current == null) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            return current.data;
        }
        return getRecursive(current.next, index - 1);
    }

    public void traverse() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void traverseRecursive(Node current) {
        if (current == null) {
            System.out.println("null");
            return;
        }
        System.out.print(current.data + " -> ");
        traverseRecursive(current.next);
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


    public void searchRecursive(Node current, int data, int index) {
        if (current == null) {
            System.out.println("Element not found");
            return;
        }
        if (current.data == data) {
            System.out.println("Element found at index: " + index);
            return;
        }
        searchRecursive(current.next, data, index + 1);
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

    public void reverseRecursive(Node current) {
        if (current == null) {
            return;
        }
        if (current.next == null) {
            head = current;
            return;
        }
        reverseRecursive(current.next);
        current.next.next = current;
        current.next = null;
        tail = current;
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


    public void Delete_Node_Itself_As_Parameter(Node node){


        node.data = node.next.data;
        node.next = node.next.next;
    }



    public int getNthNode(Node node, int n){
        int size=0;
        Node temp=head;
        while(temp!=null){
            size++;
            temp=temp.next;
        }

        int index = size-n+1;

        // now get the elements 
        Node temp1 = head;
        for(int i=0;i<index-1;i++){
            temp1 = temp1.next;
        }
        return temp1.data;
    }


    // function for get Nth node from the end using one iteration

    public  int getNthNodeSingle(Node node,int n){

        Node slow=head;
        Node fast=head;

        for(int i=1;i<=n;i++){
            fast=fast.next;
        }

        while(fast !=  null){
            slow = slow.next;
            fast = fast.next;
        } 

        return slow.data;
    }


    // delete he Nth Node from end of the linked list

    public Node deleteNthNode(Node node, int n){
        Node slow=head;
        Node fast=head;

        for(int i=1;i<=n;i++){
            fast=fast.next;
        }

        if(fast == null){
            head = head.next;
            return head;
        }

        while(fast.next !=  null){
            slow = slow.next;
            fast = fast.next;
        } 

        slow.next = slow.next.next;
        return head;
    }
    

    // function to find inersection of two linkedlist

    public Node intersectionOfTwoLL(Node headA,Node headB){
        Node tempA = headA;
        Node tempB = headB;
        int lengthA=0, lengthB=0;
        while(tempA!=null){
            lengthA++;
            tempA = tempA.next;   
        }
        while(tempB != null){
            lengthB++;
            tempB = tempB.next;
        }
        tempA=headA;
        tempB=headB;
        if(lengthA>lengthB){
            int steps=lengthA-lengthB;
            for(int i=1;i<=steps;i++){   
                tempA = tempA.next;
            }
        }
            else{
                int steps = lengthB-lengthA;
                
                for(int i=1;i<=steps;i++){
                    
                    tempB =tempB.next;
                }            
        }
        while(tempA != tempB){
            
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return tempA;
    }


    // function to get middle element

    public Node getMiddleNode(Node head){
        Node slow=head;
        Node fast=head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }   

        return slow;
    }


    // function to delete middle element of the linked list

    public Node deleteMiddleNode2(Node head){
        Node slow=head;
        Node fast=head;
        Node prev=null;

        if(fast.next ==null) {
            return null;
        }

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }   

        prev.next = slow.next;
        return head;
    }




    public Node deleteMiddleNode(Node head){
        Node slow=head;
        Node fast=head;
        
        if(fast.next ==null) {
            return null;
        }

        while(fast.next.next != null && fast.next.next.next != null){
            
            slow = slow.next;
            fast = fast.next.next;
        }   

        
        slow.next = slow.next.next;
        return head;
    }


    // function to detect cycle in linked list

    public boolean detectCycle(Node head){
        Node slow=head;
        Node fast=head;
        if(head == null || head.next == null){
            return false;
        }
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }   

        return false;
    }

    // function to get node where cycle starts

    public Node getNodewhereCycleStarts(Node head){
        Node slow=head;
        Node fast=head;
        if(head == null || head.next == null){
            return null;
        }
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }   

        return null;
    }

    // function to merge two sorted linked list

    public Node mergeTwoList(Node headA,Node headB){ // T.C = O(n+m) and S.C = O(n+m)
        Node tempA = headA;
        Node tempB = headB;
        Node dummy = new Node(0);
        Node temp = dummy;
        while(tempA != null && tempB != null){
            if(tempA.data < tempB.data){
                temp.next = tempA;
                tempA = tempA.next;
            }
            else{
                temp.next = tempB;
                tempB = tempB.next;
            }
            temp = temp.next;
        }
        if(tempA != null){
            temp.next = tempA;
        }
        if(tempB != null){
            temp.next = tempB;
        }
        return dummy.next;
    }


    public Node mergeTwoListOptimized(Node headA,Node headB){ // T.C = O(n+m) and S.C = O(1)
        Node tempA = headA;
        Node tempB = headB;
        Node dummy = new Node(0);
        Node temp = dummy;
        while(tempA != null && tempB != null){
            if(tempA.data < tempB.data){
                temp.next = tempA;
                temp = tempA;
                tempA = tempA.next;
            }
            else{
                temp.next = tempB;
                temp = tempB;
                tempB = tempB.next;
            }
           
        }
        if(tempA == null){
            temp.next = tempB;
        }
        else{
            temp.next = tempA;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        LLDS list = new LLDS();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);
        // list.traverse();
        // list.search(3);
        // list.reverse();
        // list.traverse();
        // list.clear();
        // list.traverse();
        // list.reverseRecursive(list.head);
        // list.traverse();
        // int b = list.getNthNode(list.head, 2);
        // int a =list.getNthNodeSingle(list.head, 2);
        // System.out.println(a);
        // System.out.println(b);
        // list.traverse();
        // list.deleteNthNode(list.head, 5);
        list.traverse();

        // list.getMiddleNode(list.head);
        System.out.println(list.getMiddleNode(list.head).data);


    }

}