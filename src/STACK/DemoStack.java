package STACK;

class MyStack{
    int top; //menunjuk index paling atas
    int maxSize; //panjang array
    int array[];

    public MyStack(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
        top = -1; // stack masih kosong
    }
    
    public void push(int data){
        if(!isFull()){//jika belum penuh
            array[++top] = data;
        }
    }
    
    public int pop(){
        int result = -1;
        if(!isEmpty()){
            result = array[top];
            top--;
        }
        return result;
    }
    public int peek(){
        return array[top];
    }
    public void display(){
        for(int i=0; i<=top; i++)
            System.out.print(array[i]+" ");
    }
    public void reset(){
        top = -1;//top kembali ke nilai awal saat stack kosong
    }
    public boolean isFull(){
        return top == maxSize-1;
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public int getBottom(){
        //asumsikan stack tidak kosong
        return  array[0];
    }
    public int getTop(){
        //asusmsi stack tidak kosong
        return array[top];
    }
    
}
public class DemoStack {
    public static void main(String[] args) {
        MyStack my = new MyStack(10);
        
        my.push(10);//index 0
        my.push(20);//index 1
        
        
        my.pop();//hapus data pada index 1
        
        
        
        
        
        
    }
}
