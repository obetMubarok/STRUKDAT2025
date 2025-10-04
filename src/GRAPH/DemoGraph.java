package GRAPH;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Vertex{
    String label;
    boolean visited;
    
    public Vertex(String label) {
        this.label = label;
        visited = false;
        
    }
}
class MyGraph{
    Vertex listVertex[];
    int nVertex;
    int nMax;
    int matrix[][];
    Stack<Integer> stack;
    Queue<Integer> queue;
    public MyGraph(int nMax) {
        this.nMax = nMax;
        listVertex = new Vertex[nMax];
        nVertex = 0;
        matrix = new int[nMax][nMax];
        stack = new Stack();
        queue = new LinkedList<>();
    }
    public void addVertex(String label){
        listVertex[nVertex++] = new Vertex(label);
    }
    
    public void displayMatrix(){
        for(int i=0; i<nVertex; i++){
            System.out.print("\t"+listVertex[i].label);
        }
        System.out.println("");
        for(int i=0;i<nVertex;i++){
            System.out.print(listVertex[i].label+"\t");
            for(int j=0;j<nVertex;j++){
                System.out.print(matrix[i][j]+"\t");
                
            }
            System.out.println("");
        }
    }
    public void addEdge(int start, int end){
        matrix[start][end] = 1;
        matrix[end][start] = 1;
    }
    
    public int adjVertex(int v){
        for(int i=0;i<nVertex;i++){
            if(matrix[v][i] == 1 && listVertex[i].visited == false){
                return i;
            }
        }
        return -1;
    }
    public void dfs(){
        System.out.print("DFS : ");
        stack.push(0);
        System.out.print(listVertex[0].label);
        listVertex[0].visited = true;
        
        
        while(!stack.isEmpty()){
            int v = adjVertex(stack.peek());
            if(v == -1){
                stack.pop(); 
            }else{
                stack.push(v);
                System.out.print(listVertex[v].label);
                listVertex[v].visited = true;
            }
        }
        
        for(int i=0; i<nVertex; i++){
            listVertex[i].visited=false;
        }
    }
    public void bfs(){
        System.out.print("BFS : ");
        queue.add(0);
        System.out.print(listVertex[0].label+"");
        listVertex[0].visited = true;
        
        while(!queue.isEmpty()){
             int v1 = queue.remove();
             while(adjVertex(v1)!=-1){
                 
                 int v2 = adjVertex(v1);
                queue.add(v2);
                 System.out.print(listVertex[v2].label+"");
                 listVertex[v2].visited = true;
             }
        }
        
        for(int i=0; i<nVertex; i++){
            listVertex[i].visited=false;
        }
    }
    
}
public class DemoGraph {
    public static void main(String[] args) {
        MyGraph my = new MyGraph(10);
        my.addVertex("A");//0
        my.addVertex("B");//1
        my.addVertex("C");//2
        my.addVertex("D");//3
        my.addVertex("E");//4
        
        my.addEdge(0, 1);//connect A and B
        my.addEdge(0, 3);
        my.addEdge(1, 4);
        my.addEdge(2, 4);
        my.addEdge(3, 4);
        my.displayMatrix();
        
        my.dfs();
        System.out.println("");
        my.bfs();
        System.out.println("");
    }
}