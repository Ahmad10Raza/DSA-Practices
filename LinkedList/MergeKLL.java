class Solution {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        
        return partition(lists, 0, lists.length - 1);
        
    }
 
    // this function will partition linked list
    public ListNode partition(ListNode[] lists, int start, int end) {
        if (start == end) 
            return lists[start];
        
        if (start < end) {
            
            int mid = start + (end - start) / 2;
            
            ListNode l1 = partition(lists, start, mid);
            ListNode l2 = partition(lists, mid + 1, end);
            
            return merge(l1, l2);
        } 
        else
            return null;
    }
 
    //This function is from Merge Two Sorted Lists.
    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        
        if (l2 == null)
            return l1;
        
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } 
        else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l1 = s.new ListNode(1);
        l1.next = s.new ListNode(4);
        l1.next.next = s.new ListNode(5);
        ListNode l2 = s.new ListNode(1);
        l2.next = s.new ListNode(3);
        l2.next.next = s.new ListNode(4);
        ListNode l3 = s.new ListNode(2);
        l3.next = s.new ListNode(6);
        ListNode[] lists = {l1, l2, l3};
        ListNode result = s.mergeKLists(lists);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }


    // same approcah but in different way

    public Node mergeN(Node a, Node b){
        Node result = null;
        if(a == null)
            return b;
        if(b == null)
            return a;
        if(a.data <= b.data){
            result = a;
            result.next = mergeN(a.next, b);
        }
        else{
            result = b;
            result.next = mergeN(a, b.next);
        }
        return result;
    }

    public Node mergeK(Node arr[], int last){
        while(last != 0){
            int i = 0, j = last;
            while(i < j){
                arr[i] = mergeN(arr[i], arr[j]);
                i++;
                j--;
                if(i >= j)
                    last = j;
            }
        }
        return arr[0];
    }
}