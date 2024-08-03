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
    Node tail = null; // Declare the head variable

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

    // Function to insert a new Node at front of the list

    // Input: LinkedList = 2->3->4->5, NewNode = 1
    // Output: LinkedList = 1->2->3->4->5

    // Input: LinkedList = , NewNode = 1
    // Output: LinkedList = 1

    // Approach: The new node is always added before the head of the given Linked
    // List. And newly
    // added node will become the new head of the Linked List.
    // For example if the given Linked List is 10->15->20->25 and we add an item 5
    // at the front,
    // then the Linked List becomes 5->10->15->20->25. Let us call the function that
    // adds at the
    // front of the list is push(). The push() must receive a pointer to the head
    // pointer,
    // because push must change the head pointer to point to the new node

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
    }

    // Function to insert a new node at the end of the list

    // Input: LinkedList = 1->2->3->4->5, NewNode = 6
    // Output: LinkedList = 1->2->3->4->5->6

    // Approach: The new node is always added after the last node of the given
    // Linked List.
    // For example if the given Linked List is 5->10->15->20->25 and we add an item
    // 30 at the end,
    // then the Linked List becomes 5->10->15->20->25->30. Since a Linked List is
    // typically
    // represented by the head of it, we have to traverse the list till end and then
    // change the next of last node to new node.

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

    // Function to insert a new node after a given node

    // Input: LinkedList = 1->2->3->4, NewNode = 8, PrevNode = 3
    // Output: LinkedList = 1->2->3->8->4

    // Approach: The new node is always added after the given prev_node. For example
    // if the given
    // Linked List is 5->10->15->20->25 and we add an item 30 after 15, the Linked
    // List looks like 5->10->15->30->20->25.

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

    // Function to delete a node at the beginning of the list

    // Input: LinkedList = 1->2->3->4->5
    // Output: LinkedList = 2->3->4->5

    // Approach: The linked list can be traversed and the head can be changed to the
    // next node in the list.
    // The previous head node will be garbage collected by Java Garbage Collector.

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

    // Function to delete a node at the end of the list

    // Input: LinkedList = 1->2->3->4->5
    // Output: LinkedList = 1->2->3->4

    // Approach: The linked list can be traversed and the second last node can be
    // found.
    // The next of the second last node will be null and the last node will be
    // garbage collected by Java Garbage Collector.

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

    // Function to delete a node after a given node

    // Input: LinkedList = 1->2->3->4, Node = 3
    // Output: LinkedList = 1->2->3

    // Approach: The linked list can be traversed and the node after the given node
    // can be found.
    // The next of the given node will be changed to the next of the next node and
    // the next node will be garbage collected by Java Garbage Collector.

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

    // Function to get the data of a node at a given position

    // Input: LinkedList = 1->2->3->4->5, Position = 2
    // Output: 3

    // Approach: The linked list can be traversed and the data of the node at the
    // given position can be returned.
    // If the position is less than 0, an IllegalArgumentException is thrown.
    // If the position is greater than the size of the linked list, an
    // IndexOutOfBoundsException is thrown.

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

    // Function to get the data of a node at a given position using recursion

    // Input: LinkedList = 1->2->3->4->5, Position = 2
    // Output: 3

    // Approach: The linked list can be traversed recursively and the data of the
    // node at the given position can be returned.
    // If the position is less than 0, an IllegalArgumentException is thrown.
    // If the position is greater than the size of the linked list, an
    // IndexOutOfBoundsException is thrown.

    public int getRecursive(Node current, int index) {
        if (current == null) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            return current.data;
        }
        return getRecursive(current.next, index - 1);
    }

    // Function to traverse the list

    // Input: LinkedList = 1->2->3->4->5
    // Output: 1 -> 2 -> 3 -> 4 -> 5 -> null

    // Approach: The linked list can be traversed and the data of each node can be
    // printed.
    // The traversal can be done iteratively or recursively.

    public void traverse() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Function to traverse the list using recursion

    // Input: LinkedList = 1->2->3->4->5
    // Output: 1 -> 2 -> 3 -> 4 -> 5 -> null

    // Approach: The linked list can be traversed recursively and the data of each
    // node can be printed.
    // The traversal can be done iteratively or recursively.

    public void traverseRecursive(Node current) {
        if (current == null) {
            System.out.println("null");
            return;
        }
        System.out.print(current.data + " -> ");
        traverseRecursive(current.next);
    }

    // Additional functionalities:

    // Function to search for an element in the list

    // Input: LinkedList = 1->2->3->4->5, Element = 3
    // Output: Element found at index: 2

    // Input: LinkedList = 1->2->3->4->5, Element = 6
    // Output: Element not found

    // Approach: The linked list can be traversed and the element can be searched.
    // If the element is found, the index of the element can be returned.
    // If the element is not found, a message can be printed.

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

    // Function to reverse the list

    // Input: LinkedList = 1->2->3->4->5
    // Output: LinkedList = 5->4->3->2->1

    // Approach: The linked list can be reversed by changing the next of each node
    // to the previous node.
    // The head of the linked list will be the last node after reversing the linked
    // list.

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

    // Function to reverse the list using recursion

    // Input: LinkedList = 1->2->3->4->5
    // Output: LinkedList = 5->4->3->2->1

    // Approach: The linked list can be reversed recursively by changing the next of
    // each node to the previous node.
    // The head of the linked list will be the last node after reversing the linked
    // list.

    public Node reverseRecursive(Node current) {
        if (current == null || current.next == null) {
            return current;
        }
        Node newHead = reverseRecursive(current.next);
        current.next.next = current;
        current.next = null;
        return newHead;
    }

    // Function to clear the list

    // Input: LinkedList = 1->2->3->4->5
    // Output: LinkedList = null

    // Approach: The linked list can be traversed and the next of each node can be
    // set to null.
    // The head of the linked list will be null after clearing the linked list.

    public void clear() {
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = null; // for garbage collection
            current = next;
        }
        head = tail = null;
    }

    // Function to delete node as parameter

    // Input: LinkedList = 1->2->3->4->5, Node = 3
    // Output: LinkedList = 1->2->4->5

    // Approach: The linked list can be traversed and the node can be deleted by
    // changing the next of the previous node to the next of the current node.
    // The deleted node will be garbage collected by Java Garbage Collector.

    public void DeleteNodeItselfAsParameter(Node node) {

        node.data = node.next.data;
        node.next = node.next.next;
    }

    // Function to get Nth node from the end of the linked list

    // Input: LinkedList = 1->2->3->4->5, N = 2
    // Output: 4

    // Approach: The linked list can be traversed to find the size of the linked
    // list.
    // The Nth node from the end can be found by traversing the linked list again to
    // the Nth node from the start.

    public int getNthNode(Node node, int n) {
        int size = 0;
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        int index = size - n + 1;

        // now get the elements
        Node temp1 = head;
        for (int i = 0; i < index - 1; i++) {
            temp1 = temp1.next;
        }
        return temp1.data;
    }

    // Function for get Nth node from the end using one iteration

    // Input: LinkedList = 1->2->3->4->5, N = 2
    // Output: 4

    // Approach: The linked list can be traversed using two pointers.
    // The first pointer can be moved N nodes ahead.
    // Then both pointers can be moved one node at a time until the first pointer
    // reaches the end.
    // The second pointer will be at the Nth node from the end.

    public int getNthNodeSingle(Node node, int n) {

        Node slow = head;
        Node fast = head;

        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.data;
    }

    // Function to delete he Nth Node from end of the linked list

    // Input: LinkedList = 1->2->3->4->5, N = 2
    // Output: LinkedList = 1->2->3->5

    // Approach: The linked list can be traversed using two pointers.
    // The first pointer can be moved N nodes ahead.
    // Then both pointers can be moved one node at a time until the first pointer
    // reaches the end.
    // The second pointer will be at the Nth node from the end.
    // The next of the second pointer can be changed to the next of the next of the
    // second pointer.

    // Follow below steps to delete Nth node from end of linked list:
    // 1. Initialize two pointers slow and fast to head.
    // 2. Move the fast pointer to N nodes from head.
    // 3. Move the slow pointer and fast pointer simultaneously until the fast
    // pointer reaches the end.
    // 4. The slow pointer will be at the Nth node from the end.
    // 5. Change the next of the slow pointer to the next of the next of the slow
    // pointer.

    public Node deleteNthNode(Node node, int n) {
        Node slow = head;
        Node fast = head;

        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }

        // if Nth node from end is head
        if (fast == null) {
            head = head.next;
            return head;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    // Function to find inersection point of two linkedlist

    // Input: LinkedList1 = 1->2->3->4->5, LinkedList2 = 6->7->8->3->4->5
    // Output: 3

    // Approach: In this algorithm, we make the first list circular by connecting
    // the last node to the first node.
    // Then we take the size of the loop and move the first pointer in the second
    // linked list by that number of nodes.
    // Then take another pointer from the beginning of the second list and increment
    // first and second pointer
    // simultaneously to find the intersection point.

    // Steps to solve the problem:

    // Traverse the first linked list (count the elements) and make a circular
    // linked list.
    // (Remember the last node so that we can break the circle later on).
    // Now view the problem as finding the loop in the second linked list. So the
    // problem is solved.
    // Since we already know the length of the loop (size of the first linked list)
    // we can traverse
    // those many numbers of nodes in the second list, and then start another
    // pointer from the
    // beginning of the second list. we have to traverse until they are equal, and
    // that is the required intersection point.
    // Remove the circle from the linked list.
    // Please write comments if you find any bug in the above algorithm or a better
    // way to solve the same problem.

    public Node intersectionOfTwoLL(Node headA, Node headB) {
        Node tempA = headA;
        Node tempB = headB;
        int lengthA = 0, lengthB = 0;
        while (tempA != null) {
            lengthA++;
            tempA = tempA.next;
        }
        while (tempB != null) {
            lengthB++;
            tempB = tempB.next;
        }
        tempA = headA;
        tempB = headB;
        if (lengthA > lengthB) {
            int steps = lengthA - lengthB;
            for (int i = 1; i <= steps; i++) {
                tempA = tempA.next;
            }
        } else {
            int steps = lengthB - lengthA;

            for (int i = 1; i <= steps; i++) {

                tempB = tempB.next;
            }
        }
        while (tempA != tempB) {

            tempA = tempA.next;
            tempB = tempB.next;
        }
        return tempA;
    }

    // Function to get middle element

    // Input: LinkedList = 1->2->3->4->5
    // Output: 3

    // Approach: The linked list can be traversed using two pointers.
    // The slow pointer can be moved one node at a time and the fast pointer can be
    // moved two nodes at a time.
    // When the fast pointer reaches the end of the linked list, the slow pointer
    // will be at the middle of the linked list.

    public Node getMiddleNode(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Function to delete middle element of the linked list

    // Input: LinkedList = 1->2->3->4->5
    // Output: LinkedList = 1->2->4->5

    // Approach: The linked list can be traversed using two pointers.
    // The slow pointer can be moved one node at a time and the fast pointer can be
    // moved two nodes at a time.
    // When the fast pointer reaches the end of the linked list, the slow pointer
    // will be at the middle of the linked list.
    // The middle node can be deleted by changing the next of the previous node of
    // the middle node to the next of the middle node.

    public Node deleteMiddleNode2(Node head) {
        Node slow = head;
        Node fast = head;
        Node prev = null;

        if (fast.next == null) {
            return null;
        }

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = slow.next;
        return head;
    }

    // Function for delete a middle node from LL

    // Input: LinkedList = 1->2->3->4->5
    // Output: LinkedList = 1->2->4->5

    // Approach: The linked list can be traversed using two pointers.
    // The slow pointer can be moved one node at a time and the fast pointer can be
    // moved two nodes at a time.
    // When the fast pointer reaches the end of the linked list, the slow pointer
    // will be at the middle of the linked list.
    // The middle node can be deleted by changing the next of the previous node of
    // the middle node to the next of the middle node.

    public Node deleteMiddleNode(Node head) {
        Node slow = head;
        Node fast = head;

        if (fast.next == null) {
            return null;
        }

        while (fast.next.next != null && fast.next.next.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    // Function to detect cycle in linked list

    // Input: LinkedList = 1->2->3->4->5->3
    // Output: true

    // Approach: The linked list can be traversed using two pointers.
    // The slow pointer can be moved one node at a time and the fast pointer can be
    // moved two nodes at a time.
    // If there is a cycle in the linked list, the slow and fast pointers will meet
    // at some point.
    // If there is no cycle in the linked list, the fast pointer will reach the end
    // of the linked list.

    public boolean detectCycle(Node head) {
        Node slow = head;
        Node fast = head;
        if (head == null || head.next == null) {
            return false;
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    // Function to get node where cycle starts

    // Input: LinkedList = 1->2->3->4->5->3
    // Output: 3

    // Approach: The linked list can be traversed using two pointers.
    // The slow pointer can be moved one node at a time and the fast pointer can be
    // moved two nodes at a time.
    // If there is a cycle in the linked list, the slow and fast pointers will meet
    // at some point.
    // If there is no cycle in the linked list, the fast pointer will reach the end
    // of the linked list.
    // The slow pointer can be moved to the head of the linked list and both
    // pointers can be moved one node at a time.
    // The point where the slow and fast pointers meet is the node where the cycle
    // starts.

    public Node getNodewhereCycleStarts(Node head) {
        Node slow = head;
        Node fast = head;
        if (head == null || head.next == null) {
            return null;
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }

    // Function to merge two sorted linked list

    // Input: LinkedList1 = 1->2->4, LinkedList2 = 1->3->4
    // Output: LinkedList = 1->1->2->3->4->4

    // Approach: The two linked lists can be merged by comparing the data of the
    // nodes of the two linked lists.
    // The node with the smaller data can be added to the merged linked list.
    // The node with the smaller data can be moved to the next node.
    // The process can be repeated until all the nodes of the two linked lists are
    // added to the merged linked list.

    public Node mergeTwoList(Node headA, Node headB) { // T.C = O(n+m) and S.C = O(n+m)
        Node tempA = headA;
        Node tempB = headB;
        Node dummy = new Node(0);
        Node temp = dummy;
        while (tempA != null && tempB != null) {
            if (tempA.data < tempB.data) {
                temp.next = tempA;
                tempA = tempA.next;
            } else {
                temp.next = tempB;
                tempB = tempB.next;
            }
            temp = temp.next;
        }
        if (tempA != null) {
            temp.next = tempA;
        }
        if (tempB != null) {
            temp.next = tempB;
        }
        return dummy.next;
    }

    // Function to merge two list in optimized way

    // Approach: The two linked lists can be merged by comparing the data of the
    // nodes of the two linked lists.
    // The node with the smaller data can be added to the merged linked list.

    public Node mergeTwoListOptimized(Node headA, Node headB) { // T.C = O(n+m) and S.C = O(1)
        Node tempA = headA;
        Node tempB = headB;
        Node dummy = new Node(0);
        Node temp = dummy;
        while (tempA != null && tempB != null) {
            if (tempA.data < tempB.data) {
                temp.next = tempA;
                temp = tempA;
                tempA = tempA.next;
            } else {
                temp.next = tempB;
                temp = tempB;
                tempB = tempB.next;
            }

        }
        if (tempA == null) {
            temp.next = tempB;
        } else {
            temp.next = tempA;
        }
        return dummy.next;
    }

    // Function to delete duplicate node from ll

    // Input: LinkedList = 1->2->2->3->4->4->5
    // Output: LinkedList = 1->2->3->4->5

    // Approach: The linked list can be traversed and the duplicate nodes can be
    // deleted.
    // The next of the previous node of the duplicate node can be changed to the
    // next of the next of the duplicate node.
    // The duplicate node will be garbage collected by Java Garbage Collector.

    public Node deleteDuplicate(Node head) {
        Node temp = head;
        while (temp != null && temp.next != null) {
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    // second method to delete duplicate node from ll

    // Input: LinkedList = 1->2->2->3->4->4->5
    // Output: LinkedList = 1->3->5

    // Approach: The linked list can be traversed and the duplicate nodes can be
    // deleted.
    // The next of the previous node of the duplicate node can be changed to the
    // next of the next of the duplicate node.
    // The duplicate node will be garbage collected by Java Garbage Collector.

    public Node deleteDuplicate2(Node head) {
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

    // Function to check palindrome linked list

    // Input: LinkedList = 1->2->3->2->1
    // Output: true

    // Approach: The linked list can be traversed using two pointers.
    // The slow pointer can be moved one node at a time and the fast pointer can be
    // moved two nodes at a time.
    // When the fast pointer reaches the end of the linked list, the slow pointer
    // will be at the middle of the linked list.
    // The second half of the linked list can be reversed.
    // The first half of the linked list and the reversed second half of the linked
    // list can be compared.
    // If the data of the nodes of the first half and the reversed second half are
    // the same, the linked list is a palindrome.
    // If the data of the nodes of the first half and the reversed second half are
    // not the same, the linked list is not a palindrome.

    // Follow below steps to check if a linked list is palindrome:
    // 1. Traverse the linked list using two pointers slow and fast.
    // 2. Move the slow pointer one node at a time and the fast pointer two nodes at
    // a time.
    // 3. When the fast pointer reaches the end of the linked list, the slow pointer
    // will be at the middle of the linked list.
    // 4. Reverse the second half of the linked list.
    // 5. Compare the first half of the linked list and the reversed second half of
    // the linked list.
    // 6. If the data of the nodes of the first half and the reversed second half
    // are
    // the same, the linked list is a palindrome.
    // 7. If the data of the nodes of the first half and the reversed second half
    // are
    // not the same, the linked list is not a palindrome.

    public boolean isPalindrome(Node head) {
        Node slow = head;
        Node fast = head;
        if (head == null || head.next == null) {
            return true;
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node prev = null;
        Node next = null;
        Node curr = slow;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        slow = prev;
        fast = head;
        while (slow != null) {
            if (slow.data != fast.data) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    // Function to check palindrome linked list using deep copy

    // Input: LinkedList = 1->2->3->2->1
    // Output: true

    // Approach: The linked list can be traversed using two pointers.
    // The slow pointer can be moved one node at a time and the fast pointer can be
    // moved two nodes at a time.
    // When the fast pointer reaches the end of the linked list, the slow pointer
    // will be at the middle of the linked list.
    // The second half of the linked list can be reversed.
    // The first half of the linked list and the reversed second half of the linked
    // list can be compared.

    public boolean isPalindrome2(Node head) {
        Node temp = head;
        Node newHead = null;
        while (temp != null) {
            Node newNode = new Node(temp.data);
            newNode.next = newHead;
            newHead = newNode;
            temp = temp.next;
        }
        while (head != null) {
            if (head.data != newHead.data) {
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }

    // Function to odd even linked list

    // Input: LinkedList = 1->2->3->4->5
    // Output: LinkedList = 1->3->5->2->4

    // Approach: The linked list can be traversed using two pointers.
    // The odd nodes can be added to the odd linked list and the even nodes can be
    // added to the even linked list.

    // Follow below steps to solve the problem:
    // 1. Initialize two linked lists odd and even.
    // 2. Traverse the linked list and add the odd nodes to the odd linked list and
    // the even nodes to the even linked list.
    // 3. Connect the last node of the odd linked list to the head of the even
    // linked
    // list.
    // 4. Return the head of the odd linked list.

    public Node oddEvenList(Node head) {
        Node odd = new Node(0);
        Node even = new Node(0);
        Node tempodd = odd;
        Node tempeven = even;
        Node temp = head;

        while (temp != null) {
            tempodd.next = temp;
            tempodd = tempodd.next;
            temp = temp.next;
            if (temp != null) {
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

    // Input: LinkedList = 5->4->2->1
    // Output: 6
    // Explanation: The maximum sum of pairs is 6.

    // Approach: First we find the middle of the linked list. Then we reverse the
    // second half of the linked list.
    // Then we traverse the first half and the reversed second half of the linked
    // list and find the maximum sum of pairs.

    // Follow below steps to solve the problem:
    // 1. Find the middle of the linked list.
    // 2. Reverse the second half of the linked list.
    // 3. Traverse the first half and the reversed second half of the linked list
    // and find the maximum sum of pairs.
    // 4. Return the maximum sum of pairs.

    public int pairSum(Node head) {
        Node slow = head;
        Node fast = head;
        int Maxsum = 0;
        while (fast.next.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = reverse_TwinSum(slow.next);
        Node head1 = head;
        Node head2 = slow.next;

        while (head2 != null) {
            int sum = head1.data + head2.data;
            if (sum > Maxsum) {
                Maxsum = sum;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return Maxsum;

    }

    public Node reverse_TwinSum(Node head) {
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

    public Node reverseKNodes(Node head, int k) {
        Node prev = null;
        Node next = null;
        Node curr = head;
        int count = 0;
        if (head == null) {
            return null;
        }
        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if (next != null) {
            head.next = reverseKNodes(next, k);
        }
        return prev;
    }

    // function to reverse k nodes in linked bot of remain nodes

    // Input: LinkedList = 1->2->3->4->5, k = 2
    // Output: LinkedList = 2->1->4->3->5

    // Approach: First we reverse the first k nodes of the linked list. Then we move
    // to the k+1 node and recursively call the function for the remaining nodes. We
    // connect the head of the first k nodes to the head of the remaining nodes.
    // Follow below steps to solve the problem:
    // 1. Reverse the first k nodes of the linked list.
    // 2. Move to the k+1 node and recursively call the function for the remaining
    // nodes.
    // 3. Connect the head of the first k nodes to the head of the remaining nodes.
    // 4. Return the head of the linked list.

    public Node reverseK(Node head) {
        if (head == null || head.next == null)
            return head;
        Node rev = reverseK(head.next);
        head.next.next = head;
        head.next = null;
        return rev;
    }

    public Node reverseKGroup(Node head, int k) {
        Node temp = head;
        for (int i = 1; i < k; i++) {
            if (temp == null)
                return head;
            else
                temp = temp.next;
        }
        Node n = null;
        if (temp != null) {
            n = reverseKGroup(temp.next, k);
            temp.next = null;
            head = reverseK(head);
            temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = n;
        }
        return head;

    }

    // function to remove loop in ll

    // Function that detects loop in the list
    int detectAndRemoveLoop(Node node) {
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

    // Follow below steps to remove the loop in the linked list:
    // 1. Find the node where the slow and fast pointers meet.
    // 2. Move the slow pointer to the head of the linked list.
    // 3. Move the slow and fast pointers one node at a time until they meet.
    // 4. The point where the slow and fast pointers meet is the node where the loop
    // starts.
    // 5. Change the next of the previous node of the node where the loop starts to
    // null.

    void removeLoop(Node loop, Node head) {
        Node ptr1 = loop;
        Node ptr2 = loop;

        // Count the number of nodes in loop

        Node prevNode = ptr1;
        while (ptr1.next != ptr2) {
            // keeping track beforeing moving next
            prevNode = ptr1;
            ptr1 = ptr1.next;

        }
        prevNode.next = null;
    }

    // public Node copyRandomList(Node head){
    // if (head==null){
    // return null;
    // }
    // Node h=new Node(head.data);
    // Node prev=h;
    // Node p=head;
    // head=head.next;
    // Map<Node,Node> hm=new HashMap<>();
    // hm.put(p,h);
    // int i=1;
    // while(head!=null){
    // Node n=new Node(head.data);
    // prev.next=n;
    // prev=n;
    // hm.put(head,n);
    // i++;
    // head=head.next;
    // }
    // Node h1=h;
    // while(p!=null){
    // if (p.random!=null){
    // h1.random=hm.get(p.random);
    // }
    // h1=h1.next;
    // p=p.next;
    // }
    // return h;
    // }

    /*
     * Function to remove duplicates from a
     * unsorted linked list
     */

    // Input: LinkedList = 1->2->2->3->4->4->5
    // Output: LinkedList = 1->2->3->4->5

    // Approach: The linked list can be traversed using a hash set. The data of the
    // nodes can be added to the hash set.
    // If the data of the node is already present in the hash set, the node can be
    // deleted.
    // The next of the previous node of the duplicate node can be changed to the
    // next of the next of the duplicate node.
    // The duplicate node will be garbage collected by Java Garbage Collector.

    // Follow below steps to remove duplicates from a linked list:
    // 1. Initialize a hash set to store the data of the nodes.
    // 2. Traverse the linked list and add the data of the nodes to the hash set.
    // 3. If the data of the node is already present in the hash set, delete the
    // node.
    // 4. Change the next of the previous node of the duplicate node to the next of
    // the next of the duplicate node.
    // 5. The duplicate node will be garbage collected by Java Garbage Collector.

    static void removeDuplicate(Node head) {
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
            } else {
                hs.add(curval);
                prev = current;
            }
            current = current.next;
        }
    }

    // function to move last element to front of linked list
    // Input: LinkedList = 1->2->3->4->5
    // Output: LinkedList = 5->1->2->3->4

    // Approach: The linked list can be traversed to find the last node.
    // The next of the second last node can be set to null.
    // The next of the last node can be set to the head of the linked list.
    // The head of the linked list can be set to the last node.

    public Node moveLastToFront(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node secLast = null;
        Node last = head;

        while (last.next != null) {
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

    // function to add two numbers represented by linked list

    // Input: LinkedList1 = 1->2->3, LinkedList2 = 4->5->6
    // Output: LinkedList = 5->7->9

    // Approach: The two linked lists can be traversed and the data of the nodes can
    // be added.
    // The carry can be added to the sum of the data of the nodes.
    // The digit of the sum can be added to the new linked list.
    // The carry can be updated to the sum divided by 10.
    // The next of the previous node of the new node can be set to the new node.
    // The new node can be updated to the next node.

    // Follow below steps to add two numbers represented by linked lists:
    // 1. Initialize a dummy node to store the result.
    // 2. Initialize a tail node to store the last node of the result.
    // 3. Initialize the carry to 0.
    // 4. Traverse the linked lists and add the data of the nodes.
    // 5. Add the carry to the sum of the data of the nodes.
    // 6. Find the digit of the sum by taking the modulus of the sum by 10.
    // 7. Update the carry to the sum divided by 10.
    // 8. Create a new node with the digit of the sum.
    // 9. Set the next of the tail node to the new node.
    // 10. Update the tail node to the new node.
    // 11. Move to the next node of the linked lists.
    // 12. Return the next of the dummy node.

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

    // Input: LinkedList = 1->2->3->4->5
    // Output: LinkedList = 1->5->2->4->3

    // Approach: The linked list can be divided into two halves. The first half can
    // be the left half and the second half can be the right half. The second half
    // can be reversed.
    // The nodes of the second half can be added to the first half in a zig-zag
    // manner.

    // Follow below steps to zig-zag the linked list:
    // 1. Find the middle of the linked list.
    // 2. Reverse the second half of the linked list.
    // 3. Swap the nodes of the first half and the reversed second half of the
    // linked list.

    public Node ZigZag(Node head) {
        // find mid

        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        // reverse the second half
        Node prev = null;
        Node next = null;
        Node curr = mid.next;
        mid.next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // swap the nodes

        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        while (left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }

        return head;
    }

    // function to multiply two linked list

    public int multiplyTwoLL(Node l1, Node l2) {
        int num1 = 0, num2 = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                num1 = num1 * 10 + l1.data;
                l1 = l1.next;
            }
            if (l2 != null) {
                num2 = num2 * 10 + l2.data;
                l2 = l2.next;
            }
        }
        return num1 * num2;
    }

    // function to delete node with greater value on right side

    public Node deleteNodeGreaterInRightSide(Node head) {
        head = reverse(head);
        Node current = head;
        Node maxnode = head;
        Node temp;
        while (current != null && current.next != null) {
            if (current.next.data < maxnode.data) {
                temp = current.next;
                current.next = temp.next;
                temp = null;
            } else {
                current = current.next;
                maxnode = current;
            }
        }
        head = reverse(head);
        return head;
    }

    // Multiply contents of two linked lists
    static long multiplyTwoLists(Node first, Node second) {
        long N = 1000000007;
        long num1 = 0, num2 = 0;

        while (first != null || second != null) {

            if (first != null) {
                num1 = ((num1) * 10) % N + first.data;
                first = first.next;
            }

            if (second != null) {
                num2 = ((num2) * 10) % N + second.data;
                second = second.next;
            }

        }
        return ((num1 % N) * (num2 % N)) % N;
    }

    // Q-272. Segregate even and odd nodes in a Linked List

    // Given a Linked List of integers, write a function to modify the linked list
    // such that all even numbers appear before all the odd numbers in
    // the modified linked list. Also, keep the order of even and odd numbers the
    // same.

    // Examples:

    // Input: 17->15->8->12->10->5->4->1->7->6->NULL
    // Output: 8->12->10->4->6->17->15->5->1->7->NULL
    // Even nodes in the linked list are 8, 12, 10, 4 and 6
    // Odd Nodes in the linked list are 17, 15, 1 and 7
    // In the output list, we have all the even nodes first (in the same
    // order as input list, then all the odd nodes of the list (in the same
    // order as input list)

    // Input: 8->12->10->5->4->1->6->NULL
    // Output: 8->12->10->4->6->5->1->NULL

    // function to segragate even and odd nodes in linked list

    public Node segregateEvenOdd(Node head) {
        Node end = head;
        Node prev = null;
        Node curr = head;
        while (end.next != null) {
            end = end.next;
        }
        Node new_end = end;
        while (curr.data % 2 != 0 && curr != end) {
            new_end.next = curr;
            curr = curr.next;
            new_end.next.next = null;
            new_end = new_end.next;
        }
        if (curr.data % 2 == 0) {
            head = curr;
            while (curr != end) {
                if (curr.data % 2 == 0) {
                    prev = curr;
                    curr = curr.next;
                } else {
                    prev.next = curr.next;
                    curr.next = null;
                    new_end.next = curr;
                    new_end = curr;
                    curr = prev.next;
                }
            }
        } else {
            prev = curr;
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