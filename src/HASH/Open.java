package HASH;
class Hash{
    int array[];
    int maxSize;

    public Hash(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
    }
    public int hashFunction(int key){
        return key%maxSize;
    }
    public void insert(int key){
        int index = hashFunction(key);
        array[index] = key;
    }
    public void insertOpen(int key){
        int index = hashFunction(key);
        if(array[index]==0){//jika masih kosong
            array[index] = key;
        }else{
            while(array[index]!=0){//selama tidak 0
                index++;
            }
            array[index] = key;
        }
    }
    public void display(){
        for(int i=0;i<maxSize;i++)
            System.out.print(i+" : "+array[i]+"\n");
    }
    public void remove(int key){
        array[hashFunction(key)] = 0;
    }
    public void removeOpen(int key){
        int index = hashFunction(key);
        if(array[index] == key){//jika sesuai index awal
            remove(key);
        }else{
            while(array[index] != key)//selama tidak sama dengan key
                index++;
            array[index] = 0;
        }
    }
    public boolean find(int key){
        return array[hashFunction(key)] == key;//false
    }
    public boolean findOpen(int key){
        int index = hashFunction(key);
        while(array[index]!=key){
            index ++;
        }
        if(array[index]==key)
            return true;
        return false;
        
    }
    
}
public class Open {
    public static void main(String[] args) {
        Hash myHash = new Hash(10);
        myHash.insert(8);//8
        myHash.insert(13);//3
        myHash.insertOpen(23);//3>4
        
       // System.out.println(myHash.findOpen());
    }
}
