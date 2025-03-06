package SINGLELINKEDLIST;
class SingleLL{
    Node first;
    Node last;
    
    public void addFirst(int newData){
        Node newNode = new Node(newData);//buat node baru bernama newNode
        if(first == null){//jika linkedList masih kosong
            first = newNode;
            last = newNode;
        }else{//jika linkedlist tidak kosong
            newNode.next = first;
            first = newNode;
        }
    }
    public void addLast(int newData){
        Node newNode = new Node(newData);//
        if(first == null){//jika linked list masih kosong
            first = newNode;
            last = newNode;
        }else{//jika linked list tidak kosong
            last.next = newNode;
            last = newNode;
        }
    }
    public void show(){
        Node current = first;
        while(current != null){//lakukan perulangan selama current tidak null
            System.out.print(current.data+" ");//show data of current
            current = current.next;//current pindah ke node setelahnya
        }
    }
    public void removeFirst(){
        first = first.next;// first berpindah ke node setelahnya
    }
    public boolean find(int key){
        Node current = first;// node current menunjuk ke first
        while(current != null){
            if(current.data == key){//jika ditemukan
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public void remove(int key){
        Node current = first;
        if(key == first.data){// jika data yg dihapus adalah first
            removeFirst();
        }else{//jika data yang dihapus bukan first
            while(current.next != null){
                if(current.next.data == key){
                    current.next = current.next.next;
                    break;
                }
                current = current.next;
            }
        }
    }
}
public class DemoSingleLL {
    public static void main(String[] args) {
        SingleLL my = new SingleLL();
        
        my.addFirst(50);
        my.addFirst(40);
        my.addFirst(10);
        my.addLast(15);
        my.addLast(12);
        my.addLast(20);
        my.addLast(35);
        
        my.show();
        my.remove(100);
        System.out.println("");
        my.show();
    }
}
