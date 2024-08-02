
// Reverse a linked list from position m to n. Do it in one-pass.
// Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

// Example 1:
// Input: head = [1,2,3,4,5], left = 2, right = 4
// Output: [1,4,3,2,5]

// Approach: We can reverse the linked list from m to n by following the below steps:
// 1. Traverse the linked list till m-1th node.
// 2. Store the m-1th node in a variable.
// 3. Traverse the linked list from mth node to nth node and reverse the linked list.
// 4. Connect the m-1th node to the nth node.
// 5. Connect the mth node to the n+1th node.

// Complexity Analysis:
// Time Complexity: O(n), where n is the number of nodes in the linked list.
// Space Complexity: O(1).

// Note: 1 ≤ m ≤ n ≤ length of list.

public class ReverseLL2 {

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 0; i < m - 1; i++) {
            prev = prev.next;
        }

        ListNode start = prev.next;
        ListNode then = start.next;

        for (int i = 0; i < n - m; i++) {
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int m = 2, n = 4;

        ListNode result = reverseBetween(head, m, n);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
