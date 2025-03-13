package DOUBLELINKEDLIST;
class Node{
    int data;//menyimpan data
    Node next;// menunjuk ke node selanjutnya
    Node prev;//menunjuk node sebelumnya

    public Node(int data) {
        this.data = data;
    }
    
}
public class DasarDoubleLinkedList {
    public static void main(String[] args) {
        //create new node (node1, node2, node3)
        Node node1 = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(30);
        
        //connecting
        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;
        
        //current
        Node current = node1;//current menunjuk node1
        current = current.next;//current menunjuk node2
        current.data = 100; //update data pada node2
        
        System.out.println(node2.data);// print data of node2 after updated
    }
}
