import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {
    
    class Node{
        int val;
        Node next;
        Node random;
        
        public Node(int val){
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomLL(Node head) {
        if (head == null) {
            return null;
        }
        Node h = new Node(head.val);
        Node prev = h;
        Node p = head;
        head = head.next;
        Map<Node, Node> hm = new HashMap<>();
        hm.put(p, h);
        int i = 1;
        while (head != null) {
            Node n = new Node(head.val);
            prev.next = n;
            prev = n;
            hm.put(head, n);
            i++;
            head = head.next;
        }
        Node h1 = h;
        while (p != null) {
            if (p.random != null) {
                h1.random = hm.get(p.random);
            }
            h1 = h1.next;
            p = p.next;
        }
        return h;
    }

    public static void printList(Node head) {
            Node ptr = head;
            while (ptr != null) {
                Node random = ptr.random;
                int randomData = (random != null) ? random.val : -1;
                System.out.println("Data = " + ptr.val +", Random data = " + randomData);
                ptr = ptr.next;
            }
        }
        
        public static void main(String[] args) {
            CopyRandomList list = new CopyRandomList();
            Node head = list.new Node(1);
            head.next = list.new Node(2);
            head.next.next = list.new Node(3);
            head.next.next.next = list.new Node(4);
            head.next.next.next.next = list.new Node(5);
        
            head.random = head.next.next;
        
            head.next.random = head;
        
            head.next.next.random = head.next.next.next.next;
        
            head.next.next.next.random = head.next.next.next.next;
        
            head.next.next.next.next.random = head.next;
        
            System.out.println("Original list : ");
            printList(head);
        
            System.out.println("Cloned list : ");
            Node cloned_list = list.copyRandomLL(head);
            printList(cloned_list);
}

}