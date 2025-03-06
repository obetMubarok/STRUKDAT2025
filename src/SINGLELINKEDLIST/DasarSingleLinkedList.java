package SINGLELINKEDLIST;
class Node{
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
    
}


public class DasarSingleLinkedList {
    public static void main(String[] args) {
        Node node1 = new Node(30);//buat node baru bernama node1
        Node node2 = new Node(10);// buat node baru bernama node2
        Node node3 = new Node(20);// buat node baru bernama node3
               
        node1.next = node2; // node1 terhubung dengan node2
        node2.next = node3;//node2 terhubung dengan node3
        
        Node current = node1;//current = node1
        current = current.next;//current = node2
        current.data = 70;//node2 = 70
        
        System.out.println(node2.data);
    }
}
