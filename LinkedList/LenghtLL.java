import java.util.LinkedList;
public class LenghtLL {
    public class Node{
        int data;
        Node next;
        
        public Node(int data){
            this.data=data;
            this.next=null;
        }

    }
    
    public static int getLength(Node node){
        int count=0;
        while(node != null)
        {
            count++;
            node=node.next;
        }
        return count;
    }

    public static int getLengthRecursive(Node node){
        if(node==null){
            return 0;
        }
        return 1+getLengthRecursive(node.next);
    }

    public static void getLengthJavaLinkedList(LinkedList<Integer> list) {
        System.out.println(list.size());
    }
    
    public static void main(String args[]){
        LenghtLL lenghtLL = new LenghtLL();
        Node a = lenghtLL.new Node(1);
        Node b = lenghtLL.new Node(2);
        Node c = lenghtLL.new Node(3);

        a.next=b;
        b.next=c;
        System.out.println(getLength(a));
        System.out.println(getLengthRecursive(a));
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        getLengthJavaLinkedList(list);
    }
}