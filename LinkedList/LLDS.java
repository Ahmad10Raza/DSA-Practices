import java.util.HashSet;
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

    public Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;

    }

    public Node reverseRecursive(Node current) {
        if (current == null || current.next == null) {
            return current;
        }
        Node newHead = reverseRecursive(current.next);
        current.next.next = current;
        current.next = null;
        return newHead;
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


    public void DeleteNodeItselfAsParameter(Node node){


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


    // function to delete duplicate node from ll
    
    public Node deleteDuplicate(Node head){
        Node temp=head;
        while(temp != null && temp.next != null){
            if(temp.data == temp.next.data){
                temp.next = temp.next.next;
            }
            else{
                temp = temp.next;
            }
        }
        return head;
    }

    // second method to delete duplicate node from ll

    public Node deleteDuplicate2(Node head){
        if (head == null || head.next == null) {
            return head;
        }
        Node prevPrev = null;
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            prevPrev = prev;
            prev = curr;
            int value = curr.data;
            int flag = 0;
            while (curr.next != null && curr.next.data == value) {
                curr = curr.next;
                flag = 1;
            }
            if (flag == 1) {
                if (prevPrev == null) {
                    head = curr.next;
                    prev = null;
                    prevPrev = null;
                } else {
                    prev = prevPrev;
                    prevPrev.next = curr.next;
                }
            }
            curr = curr.next;
        }

        return head;
        
    }



    // function to check palindrome linked list

    public boolean isPalindrome(Node head){
        Node slow=head;
        Node fast=head;
        if(head == null || head.next == null){
            return true;
        }
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }   

        Node prev=null;
        Node next=null;
        Node curr=slow;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        slow = prev;
        fast = head;
        while(slow != null){
            if(slow.data != fast.data){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    // function to check palindrome linked list using deep copy

    public boolean isPalindrome2(Node head){
        Node temp=head;
        Node newHead=null;
        while(temp != null){
            Node newNode = new Node(temp.data);
            newNode.next = newHead;
            newHead = newNode;
            temp = temp.next;
        }
        while(head != null){
            if(head.data != newHead.data){
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }


    // function to odd even linked list

    public Node oddEvenList(Node head){
        Node odd = new Node(0);
        Node even = new Node(0);
        Node tempodd = odd;
        Node tempeven = even;
        Node temp=head;

        while(temp != null){
            tempodd.next = temp;
            tempodd = tempodd.next;
            temp = temp.next;
            if(temp != null){
                tempeven.next = temp;
                tempeven = tempeven.next;
                temp = temp.next;
            }
        }
        tempodd.next = even.next;
        tempeven.next = null;
        return odd.next;

    }



    // function to twin sum or pair sum in linked list

    public int pairSum(Node head){
        Node slow=head;
        Node fast=head;
        int Maxsum=0;
        while(fast.next.next != null){
            
            slow = slow.next;
            fast = fast.next.next;
        }   

        slow.next = reverse_TwinSum(slow.next);
        Node head1 = head;
        Node head2 = slow.next;

        while(head2 != null){
            int sum = head1.data + head2.data;
            if(sum > Maxsum){
                Maxsum = sum;
            }
            head1 = head1.next;
            head2 = head2.next; 
        }
        return Maxsum;

    }

    public Node reverse_TwinSum(Node head){
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;

    }



    // function to reverse k nodes in linked list
    
    public Node reverseKNodes(Node head, int k){
        Node prev=null;
        Node next=null;
        Node curr=head;
        int count=0;
        if(head == null){
            return null;
        }
        while(curr != null && count < k){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        
        if(next != null ){
            head.next = reverseKNodes(next, k);
        }
        return prev;
    }


// function to reverse k nodes in linked bot of remain nodes
    public Node reverseK(Node head){
        if(head==null||head.next==null)return head;
        Node rev=reverseK(head.next);
        head.next.next=head;
        head.next=null;
        return rev;
    }
    public Node reverseKGroup(Node head, int k) {
        Node temp=head;
        for(int i=1;i<k;i++){
            if(temp==null)return head;
            else temp=temp.next;
        }
        Node n=null;
        if(temp!=null)
       { 
        n=reverseKGroup(temp.next,k);
        temp.next=null;
        head=reverseK(head);
        temp=head;
        while(temp.next!=null)temp=temp.next;
        temp.next=n;
    }
        return head;
        
    }



    // function to remove loop in ll

    // Function that detects loop in the list
    int detectAndRemoveLoop(Node node)
    {
        Node slow = node, fast = node;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
 
            // If slow and fast meet at same point then loop
            // is present
            if (slow == fast) {
                removeLoop(slow, node);
                return 1;
            }
        }
        return 0;
    }


    // Function to remove loop
    void removeLoop(Node loop, Node head)
    {
        Node ptr1 = loop;
        Node ptr2 = loop;
 
        // Count the number of nodes in loop
        int k = 1, i;
        Node prevNode = ptr1;
        while (ptr1.next != ptr2) {
            // keeping track beforeing moving next
            prevNode = ptr1;
            ptr1 = ptr1.next;
            k++;
        }
        prevNode.next = null;
    }

    // public Node copyRandomList(Node head){
    //     if (head==null){
    //         return null;
    //     }
    //     Node h=new Node(head.data);
    //     Node prev=h;
    //     Node p=head;
    //     head=head.next;
    //     Map<Node,Node> hm=new HashMap<>();
    //     hm.put(p,h);
    //     int i=1;
    //     while(head!=null){
    //         Node n=new Node(head.data);
    //         prev.next=n;
    //         prev=n;
    //         hm.put(head,n);
    //         i++;
    //         head=head.next;
    //     }
    //     Node h1=h;
    //     while(p!=null){
    //         if (p.random!=null){
    //             h1.random=hm.get(p.random);
    //         }
    //         h1=h1.next;
    //         p=p.next;
    //     }
    //     return h;
    // }




    /* Function to remove duplicates from a
	unsorted linked list */
	static void removeDuplicate(Node head)
	{
		// Hash to store seen values
		HashSet<Integer> hs = new HashSet<>();

		/* Pick elements one by one */
		Node current = head;
		Node prev = null;
		while (current != null) {
			int curval = current.data;

			// If current value is seen before
			if (hs.contains(curval)) {
				prev.next = current.next;
			}
			else {
				hs.add(curval);
				prev = current;
			}
			current = current.next;
		}
	}



    //  function to move last element to front of linked list

    public Node moveLastToFront(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node secLast = null;
        Node last = head;

        while(last.next != null){
            secLast = last;
            last = last.next;
        }

        // set the next of second last as null
        secLast.next = null;


        // change head to last node
        last.next = head;
        head = last;
        
        return head;
    }



    public Node addTwoNumbers(Node l1, Node l2) {
        Node dummyHead = new Node(0);
        Node tail = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int digit1 = (l1 != null) ? l1.data : 0;
            int digit2 = (l2 != null) ? l2.data : 0;

            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            Node newNode = new Node(digit);
            tail.next = newNode;
            tail = tail.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        Node result = dummyHead.next;
        dummyHead.next = null;
        return result;
    }


    // function to zig-zag linked list

    public Node ZigZag(Node head){
        // find mid

        Node slow=head;
        Node fast=head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        // reverse the second half
        Node prev=null;
        Node next=null;
        Node curr=mid.next;
        mid.next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }


        // swap the nodes

        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        while(left != null && right != null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;
            
            

            left = nextL;
            right = nextR;
        }

        return head;
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
        // list.traverse();

        // list.getMiddleNode(list.head);
        // list.moveLastToFront(list.head);
        list.traverse();

        list.ZigZag(list.head);
        list.traverse();


    }


}