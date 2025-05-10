package HASH;

import java.util.LinkedList;

class MyHash2{
    int maxSize;
    LinkedList<Integer> array[];

    public MyHash2(int maxSize) {
        this.maxSize = maxSize;
        array = new LinkedList[maxSize];
        for(int i=0;i<maxSize;i++){
            array[i] = new LinkedList<>();
        }
    }
    public int hashFunction(int key){
        return key%maxSize;
    }
    public void insert(int key){
        int index = hashFunction(key);
        array[index].add(key);
    }
    public void remove(int key){
        int index = hashFunction(key);
        array[index].removeFirstOccurrence(key);
    }
    public boolean find(int key){
        int index = hashFunction(key);
        return array[index].contains(key);
    }
    public void find2(int key){
        int index = hashFunction(key);
        if(array[index].contains(key)){
            System.out.println(key+" berada di index "+index);
        }else{
            System.out.println(key+" tidak ada");
        }
    }
    public void display(){
        for(int i=0;i<maxSize;i++)
            System.out.print(i+" : "+array[i]+"\n");
    }
    
}
public class Chaining {
    public static void main(String[] args) {
        MyHash2 my = new MyHash2(10);
        my.insert(2);
        my.insert(12);
        my.insert(22);
        my.insert(100);
        my.remove(12);
        
        my.find2(222);
    }
}
