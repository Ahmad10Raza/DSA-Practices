// Java implementation to count triplets in a sorted doubly linked list
// whose sum is equal to a given value 'x'

// 1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
// x = 17
// Output: Count = 2
// The triplets are 2 6 9 and 4 5 8

class TripletSumXDLL{

// structure of node of doubly linked list
static class Node {
	int data;
	Node next, prev;
};

// function to count pairs whose sum equal to given 'value'
static int countPairs(Node first, Node second, int value)
{
	int count = 0;

	// The loop terminates when either of two pointers
	// become null, or they cross each other (second.next
	// == first), or they become same (first == second)
	while (first != null && second != null && first != second && second.next != first) {

		// pair found
		if ((first.data + second.data) == value) {

			// increment count
			count++;

			// move first in forward direction
			first = first.next;

			// move second in backward direction
			second = second.prev;
		}

		// if sum is greater than 'value'
		// move second in backward direction
		else if ((first.data + second.data) > value)
			second = second.prev;

		// else move first in forward direction
		else
			first = first.next;
	}

	// required count of pairs
	return count;
}

// function to count triplets in a sorted doubly linked list
// whose sum is equal to a given value 'x'
static int countTriplets(Node head, int x)
{
	// if list is empty
	if (head == null)
		return 0;

	Node current, first, last;
	int count = 0;

	// get pointer to the last node of
	// the doubly linked list
	last = head;
	while (last.next != null)
		last = last.next;

	// traversing the doubly linked list
	for (current = head; current != null; current = current.next) {

		// for each current node
		first = current.next;

		// count pairs with sum(x - current.data) in the range
		// first to last and add it to the 'count' of triplets
		count += countPairs(first, last, x - current.data);
	}

	// required count of triplets
	return count;
}

// A utility function to insert a new node at the
// beginning of doubly linked list
static Node insert(Node head, int data)
{
	// allocate node
	Node temp = new Node();

	// put in the data
	temp.data = data;
	temp.next = temp.prev = null;

	if ((head) == null)
		(head) = temp;
	else {
		temp.next = head;
		(head).prev = temp;
		(head) = temp;
	}
	return head;
}

// Driver program to test above
public static void main(String[] args)
{
	// start with an empty doubly linked list
	Node head = null;

	// insert values in sorted order
	head = insert(head, 9);
	head = insert(head, 8);
	head = insert(head, 6);
	head = insert(head, 5);
	head = insert(head, 4);
	head = insert(head, 2);
	head = insert(head, 1);

	int x = 17;

	System.out.print("Count = "
		+ countTriplets(head, x));
}
}

