public class SimpleLL {
    public class Node{
        int data;
        Node next;
        
        public Node(int data){
            this.data=data;
            this.next=null;
        }

    }
    
    public static void main(String args[]){
        SimpleLL simpleLL = new SimpleLL();
        Node a = simpleLL.new Node(1);
        Node b = simpleLL.new Node(2);
        Node c = simpleLL.new Node(3);

        a.next=b;
        b.next=c;
        // System.out.println(a.data);
        // System.out.println(a.next.data);
        // System.out.println(a.next.next.data);

        Node temp= a;
        // for(int i=0;i<3;i++){
        //     System.out.println(temp.data);
        //     temp=temp.next;
        // }

            while(temp != null)
        {
            System.out.println(temp.data);
            temp=temp.next;
        }
    }


}