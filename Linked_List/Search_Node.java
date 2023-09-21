public class Search_Node {
    static class Node{
        int data;
        Node next;

        //creating constructor
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
Node head;
// #Creating Function to add Node
public void addNode(int data){
    Node newNode=new Node(data);
    if(head==null){
        head=newNode;
    }
    else{
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
    }
}
//Creating Function for printing linked list
public void displayList(){
    Node temp=head;
    while(temp!=null){
        System.out.println(temp.data +" ");
        temp=temp.next;
    }
    System.out.println();
}
 
public Search_Node.Node SearchNode(int x){
   Node current=head;
   while(current!=null){
    if(current.data==x){
        System.out.println("Data Found !");
        return current;
    }
    current=current.next;
   } 
   System.out.println("Element Not Foun!");
   return null;
}
public static void main(String[] args) {
    Search_Node list=new Search_Node();
    list.addNode(1);
    list.addNode(2);
    list.addNode(3);
    list.addNode(4);
    list.addNode(5);
    list.SearchNode(6);
    list.displayList();

}
}
