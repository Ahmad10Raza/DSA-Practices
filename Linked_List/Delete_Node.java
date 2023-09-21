public class Delete_Node {
  class Node{
int data;
Node next;
Node(int data){
    this.data=data;
    this.next=null;
}
  } 
  Node head; 
  public void DeleteNode(int position){
    if(head==null){
        return ;
    }
Node temp=head;
    if(position==0){
        head=temp.next;
        return ;
    }
     //finding preveous node to be deleted
     for(int i=0;temp !=null && i<position-1;i++){
        temp=temp.next;
     }
     if(temp==null || temp.next==null){
        return ;
     }
     Node next=temp.next.next;
     temp.next=next;


  }

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

public static void main(String[] args) {
    Delete_Node list=new Delete_Node();
    System.out.println("The LinkedList is >>>>>");
    list.addNode(1);
    list.addNode(2);
    list.addNode(3);
    list.addNode(4);
    list.addNode(5);
    list.addNode(6);
    list.addNode(7);
    list.displayList();
    list.DeleteNode(2);
    list.DeleteNode(4);
    list.DeleteNode(6);
    System.out.println("After Deleting position=2,4,6 :>>>");
    list.displayList();

}
}
