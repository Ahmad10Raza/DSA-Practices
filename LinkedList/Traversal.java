import java.util.Iterator;
import java.util.LinkedList;

public class Traversal{

    public class Node{
        int data;
        Node next;
        
        public Node(int data){
            this.data=data;
            this.next=null;
        }

    }

    public static void printList(Node node){
        while(node != null)
        {
            System.out.println(node.data);
            node=node.next;
        }
    }

    public static void printListRec(Node node){
        if(node==null){
            return;
        }
        System.out.println(node.data);
        printListRec(node.next);
    }

    public static void printListRecRev(Node node){
        if(node==null){
            return;
        }
        printListRecRev(node.next);
        System.out.println(node.data);
    }

    

    public static void printListJavaLinkedList(LinkedList<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }

    
    public static void main(String args[]){
        Traversal traversal = new Traversal();
        Node a = traversal.new Node(1);
        Node b = traversal.new Node(2);
        Node c = traversal.new Node(3);

        a.next=b;
        b.next=c;

        printList(a);
        printListRec(a);
        printListRecRev(a);
        printListJavaLinkedList(new LinkedList<Integer>() {{
            add(1);
            add(2);
            add(3);
        }});
       
    }

}