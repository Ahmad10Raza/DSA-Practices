
//You are given the head of a linked list, and an integer k.

// Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).

// Example 1:
// Input: head = [1,2,3,4,5], k = 2
// Output: [1,4,3,2,5]
// Explanation: The second node from the beginning is 2 and the second node from the end is 4.

// Approach: Traverse the linked list and find the length of the linked list. Then find the kth node from the beginning and kth node from the end. Swap the values of the kth node from the beginning and kth node from the end.

// Time complexity: O(n)
// Space complexity: O(1)

// Follow below steps to solve the problem:
// 1. Find the length of the linked list.
// 2. Traverse the linked list and find the kth node from the beginning and kth node from the end.
// 3. Swap the values of the kth node from the beginning and kth node from the end.

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class SwapNodes {

    public static ListNode swapNodes(ListNode head, int k) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        ListNode first = head;
        ListNode second = head;
        for (int i = 1; i < k; i++) {
            first = first.next;
        }

        for (int i = 1; i < length - k + 1; i++) {
            second = second.next;
        }

        int tempVal = first.val;
        first.val = second.val;
        second.val = tempVal;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        ListNode result = swapNodes(head, k);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
