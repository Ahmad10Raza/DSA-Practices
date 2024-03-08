
/*
The Intuition is to iterate through two linked lists representing non-negative integers in reverse order, 
starting from the least significant digit. It performs digit-wise addition along with a carry value and 
constructs a new linked list to represent the sum. The process continues until both input lists and the 
carry value are exhausted. The resulting linked list represents the sum of the input numbers in the correct order.

Explanation:
1. Create a placeholder node called dummyHead with a value of 0. This node will hold the resulting linked list.
2. Initialize a pointer called tail and set it to dummyHead. This pointer will keep track of the last node in the result list.
3. Initialize a variable called carry to 0. This variable will store the carry value during addition.
4. Start a loop that continues until there are no more digits in both input lists (l1 and l2) and there is no remaining carry value.
5. Inside the loop:
    5.1 Check if there is a digit in the current node of l1. If it exists, assign its value to a variable called digit1. Otherwise, set digit1 to 0.
    5.2 Check if there is a digit in the current node of l2. If it exists, assign its value to a variable called digit2. Otherwise, set digit2 to 0.
    5.3 Add the current digits from l1 and l2, along with the carry value from the previous iteration, and store the sum in a variable called sum.
    5.4 Calculate the unit digit of sum by taking the modulus (%) of sum by 10. This digit will be placed in a new node for the result.
    5.5 Update the carry variable by dividing sum by 10 and taking the integer division (/) part. This gives us the carry value for the next iteration.
    5.6 Create a new node with the calculated digit as its value.
    5.7 Attach the new node to the tail node of the result list.
    5.8 Move the tail pointer to the newly added node.
    5.9 Move to the next nodes in both l1 and l2, if they exist. If either list is exhausted, set the corresponding pointer to nullptr.
6. After the loop, obtain the actual result list by skipping the dummyHead node.
7. Delete the dummyHead node.
8. Return the resulting list. */





    public class AddTwoList {
        public static void main(String[] args) {
            ListNode l1 = new ListNode(2);
            l1.next = new ListNode(4);
            l1.next.next = new ListNode(3);

            ListNode l2 = new ListNode(5);
            l2.next = new ListNode(6);
            l2.next.next = new ListNode(4);

            ListNode result = addTwoNumbers(l1, l2);
            while (result != null) {
                System.out.print(result.val + " ");
                result = result.next;
            }
        }

        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(0);
            ListNode tail = dummyHead;
            int carry = 0;

            while (l1 != null || l2 != null || carry != 0) {
                int digit1 = (l1 != null) ? l1.val : 0;
                int digit2 = (l2 != null) ? l2.val : 0;

                int sum = digit1 + digit2 + carry;
                int digit = sum % 10;
                carry = sum / 10;

                ListNode newNode = new ListNode(digit);
                tail.next = newNode;
                tail = tail.next;

                l1 = (l1 != null) ? l1.next : null;
                l2 = (l2 != null) ? l2.next : null;
            }

            ListNode result = dummyHead.next;
            dummyHead.next = null;
            return result;
        }

        static class ListNode {
            int val;
            ListNode next;

            ListNode(int x) {
                val = x;
            }
        }
    }
