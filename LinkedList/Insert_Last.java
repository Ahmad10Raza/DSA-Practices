// import java.util.LinkedList;
// import java.util.*;

public class Insert_Last {
    //  Creating Structure
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
public void addLast(int data){
    Node newNode=new Node(data);
    newNode.data=data;
    newNode.next=null;
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
//Now creating main function
public static void main(String[] args) {
    Insert_Last list=new Insert_Last();
    list.addLast(1);
    list.addLast(2);
    list.addLast(3);
    list.addLast(4);
    list.addLast(5);
    list.addLast(6);
    list.addLast(7);
    list.addLast(8);
    list.addLast(9);
    list.displayList();
}

}