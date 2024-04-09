//* Node Class
class Node {
	public int data;
	public Node prev;

	public Node(int n) {
		data = n;
		prev = null;
	}
}

//* Function to perform desired operation
class Main {
	public static void Multiply(Node head, int i) {
		Node temp = head;
		Node prevPtr = head; // Temp variable for keeping head
		int carry = 0;

		//* Perform operation until temp becomes null
		while (temp != null) {
			int prod = temp.data * i + carry;
			temp.data = prod % 10; //* Stores the last digit
			carry = prod / 10;
			prevPtr = temp; //* Change Links
			temp = temp.prev; //* Moving temp to next node
		}

		//* If carry is greater than 0 then we create new nodes
		//* to store remaining digits.
		while (carry != 0) {
			prevPtr.prev = new Node((int) (carry % 10));
			carry /= 10;
			prevPtr = prevPtr.prev;
		}
	}

	//* Using head recursion to print the linked list's data in reverse
	public static void print(Node head) {
		if (head == null)
			return;
		print(head.prev);
		System.out.print(head.data); // Print linked list in reverse order
	}

	// Driver code
	public static void main(String[] args) {
		int n = 100;
		Node head = new Node(1); // Create a node and initialize it by 1

		for (int i = 2; i <= n; i++)
			Multiply(head, i); // Run a loop from 2 to n and multiply with head's i

		System.out.println("Factorial of " + n + " is : ");
		print(head); // Print the linked list
		System.out.println();
	}
}
