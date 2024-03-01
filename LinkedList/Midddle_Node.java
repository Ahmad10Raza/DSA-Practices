public class Midddle_Node {
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
public Node getMidNode(){
    Node temp=head;
    if(temp!=null){
        int n=length.temp;
        for(int i=0;i<n/2;i++){
            temp=temp.next;
        }
        return temp.data;
    }
return -1;
    
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
    Midddle_Node list=new Midddle_Node();
    list.addNode(1);
    list.addNode(2);
    list.addNode(3);
    list.addNode(4);
    list.addNode(5);
    list.getMidNode();
    list.displayList();

}
}
