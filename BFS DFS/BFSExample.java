import java.util.LinkedList;
import java.util.Queue;

class BFS{
    int V;
    LinkedList<Integer> adj[];
    public BFS(int n){
        V = n;
        adj = new LinkedList[n];
        for(int i = 0; i < n; i++){
            adj[i] = new LinkedList();
        }
    }
    void addEdge(int u, int v){
        adj[u].add(v);
        adj[v].add(u);
    }
    void BFSAlgo(int s){
        boolean visited[] = new boolean[V];
        Queue<Integer> Q = new LinkedList();
        visited[s] = true;
        Q.add(s);
        while(!Q.isEmpty()){
            s = Q.poll();
            System.out.print(s + "->");
            for(int n:adj[s]){
                if(!visited[n]){
                    visited[n] = true;
                    Q.add(n);
                }
            }
            
        }
        System.out.println("null");
    }

    
}

public class BFSExample{
    public static void main(String[] args){
        BFS g = new BFS(8);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,4);
        g.addEdge(2,3);
        g.addEdge(2,5);
        g.addEdge(3,5);
        g.addEdge(3,6);
        g.addEdge(3,7);
        g.addEdge(5,4);
        g.addEdge(6,7);
        System.out.println("BFS starting from veretex 1: ");
        g.BFSAlgo(1);
        

    }


}