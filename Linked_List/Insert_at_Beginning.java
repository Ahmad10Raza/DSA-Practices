public class Insert_at_Beginning {
    // Creating Structure
    static class Node{
        int data;
        Node next;
        //  Creating constructor
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    Node head;
    public void addfirst(int data){
        Node newNode=new Node(data);
        //if no node is present in list make new node head
        if(head==null){
            head=newNode;
        }
        else{
            newNode.data=data; //assign value to insert at beginning
            newNode.next=head; // here head==null so we assign newNode.next==null 
            //now head have address of next node
            head=newNode; // now head==address of next node 
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
    Insert_at_Beginning list=new Insert_at_Beginning();
    list.addfirst(8);
    list.addfirst(7);
    list.addfirst(6);
    list.addfirst(5);
    list.addfirst(4);
    list.addfirst(3);
    list.addfirst(2);
    list.addfirst(1);
    list.displayList();

}
}
