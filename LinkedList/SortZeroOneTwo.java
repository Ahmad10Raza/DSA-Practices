// Java code to implement the above approach

public class SortZeroOneTwo {
	// Define a class for a node in a linked list
	static class Node {
		int data;
		Node next;

		// Constructor to initialize the node with data
		Node(int data)
		{
			this.data = data;
			this.next = null;
		}
	}

	// Function to insert a new node at the end of the
	// linked list
	static Node push(Node head, int data)
	{
		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			return head;
		}

		Node last = head;
		while (last.next != null) {
			last = last.next;
		}

		last.next = newNode;
		return head;
	}

	// Function to print the linked list
	static void printList(Node head)
	{
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	// Function to sort the linked list containing 0's, 1's,
	// and 2's
	static void sortList(Node head)
	{
		int[] count = { 0, 0, 0 };

		// Count the number of 0's, 1's, and 2's in the
		// linked list
		Node current = head;
		while (current != null) {
			count[current.data]++;
			current = current.next;
		}

		// Overwrite the linked list with the sorted
		// elements
		current = head;
		int i = 0;
		while (current != null) {
			if (count[i] == 0) {
				i++;
			}
			else {
				current.data = i;
				count[i]--;
				current = current.next;
			}
		}
	}

	public static void main(String[] args)
	{
		Node head = null;

		// Insert some elements into the linked list
		head = push(head, 0);
		head = push(head, 1);
		head = push(head, 0);
		head = push(head, 2);
		head = push(head, 1);
		head = push(head, 1);
		head = push(head, 2);
		head = push(head, 1);
		head = push(head, 2);

		System.out.println("Linked List before Sorting: ");
		printList(head);

		sortList(head);

		System.out.println("Linked List after Sorting: ");
		printList(head);
	}
}
