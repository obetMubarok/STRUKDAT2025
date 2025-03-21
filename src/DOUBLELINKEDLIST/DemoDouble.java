package DOUBLELINKEDLIST;
class MyDouble{
    Node first;//menunjuk node paling depan
    Node last;//menunjuk node paling belakang
    int size = 0;// menyimpan jumlah node yang tersimpan
    
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(first == null){//if Empty
            first = newNode;
            last = newNode;
        }else{//not empty
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }
        size++;
    }
    public void addLast(int data){
        Node newNode = new Node(data);
        if(first == null){//if empty
            first = last = newNode;
        }else{//not empty
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
        size++;
    }
    public void printAll(){
        Node current = first;
        while(current!=null){
            System.out.print(current.data+" ");
            current = current.next;
        }
    }
    public void removeFirst(){
        first = first.next;
        first.prev = null;
        size --;
    }
    public void removeLast(){
        last = last.prev;
        last.next = null;
        size--;
    }
    public boolean isEmpty(){
        return first==null;
    }
    public int getSize(){
        return size;
    }
    public void remove(int key){
        if(key == first.data){//if key in first
            removeFirst();
        }else if(key == last.data){//if key in last
            removeLast();
        }else{
            Node current = first.next;
            while(current != null ){
                if(key == current.data){
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    size--;
                    break;
                }
            current = current.next;
            }
        }
    }
    public void removeAll(){
        first = null;
        last = null;
    }
    public boolean search(int key){
        Node current = first;
        while(current != null){
            if(current.data == key){
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public int indexOf(int index){
        Node current = first;
        for(int i=0; i<index; i++){
            current = current.next;
        }
        return current.data;
    }
    public int get(int key){
        int result=0;
        Node current = first;
        while(current != null){
            if(current.data == key){
                return result;
            }
            current = current.next;
            result++;
        }
        return -1;
    }
}


public class DemoDouble {
    public static void main(String[] args) {
        MyDouble my = new MyDouble();
        my.addFirst(40);
        my.addFirst(30);
        my.addFirst(20);
        my.addFirst(10);
        my.addLast(50);
        
        my.printAll();
        
    }
}
