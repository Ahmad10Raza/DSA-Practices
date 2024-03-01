// import java.util.LinkedList;
// import java.util.*;

public class LinkedList_Creation_01 {
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
//Now creating main function
public static void main(String[] args) {
    LinkedList_Creation_01 list=new LinkedList_Creation_01();
    list.addNode(2);
    list.addNode(1);
    list.addNode(3);
    list.addNode(4);
    list.addNode(5);
    list.addNode(6);
    list.addNode(7);
    list.addNode(8);
    list.addNode(9);
    list.displayList();
}

}