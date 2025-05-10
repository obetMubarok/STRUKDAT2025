package QUEUE;
class MyQueue{
    int maxSize; //panjang array
    int nItem; //jumlah data queue
    int front; // index paling depan
    int rear; // index paling belakang
    int[] array; //semua data queue

    public MyQueue(int maxSize) {
        this.maxSize = maxSize;
        rear = -1;
        front = 0;
        nItem = 0;
        array = new int[maxSize];
    }
    public void insert(int data){
        if(!isFull()){
            if(rear == maxSize-1)
                rear = -1;
            array[++rear] = data;
            nItem++;
        }
    }
    public int delete(){
        if(!isEmpty()){
            nItem--;
            return array[front++];
        }
        return -1;
    }
    public boolean isEmpty(){
        return nItem==0;
    }
    public boolean isFull(){
        return nItem == maxSize;
    }
    public void display(){
        if(nItem>0){
            if(front<=rear){
                for(int i=front; i<=rear; i++)
                    System.out.print(array[i]+" ");
            }else{//circular
                for(int i=front; i<maxSize; i++){
                    System.out.print(array[i]+" ");
                }
                for(int i=0; i<=rear; i++){
                    System.out.print(array[i]+" ");
                }
            }
        }
    }
}
public class DemoQueue {
    public static void main(String[] args) {
        
        MyQueue my = new MyQueue(3);
                
        my.insert(5);//0
        my.insert(10);//1
        my.insert(20);//2
        
        my.delete();//0
        my.delete();//1
        my.insert(100);
        
        my.display();
    }
}
