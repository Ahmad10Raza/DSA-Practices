public class Delete_Node_Itself_Parameter {
    public static void main(String[] args) {
        LLDS list = new LLDS();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.display();
        list.delete(list.head);
        list.display();
    }

    static class LLDS {
        Node head;

        class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        void insert(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        void delete(Node node) {
            Node temp = node.next;
            node.data = temp.data;
            node.next = temp.next;
        }

        void display() {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public void Delete_Node_Itself_As_Parameter(){
     
    }
}