import java.util.LinkedList;
import java.util.Stack;

class DFS{
    int V;
    LinkedList<Integer> adj[];
    public DFS(int n){
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
    void DFSAlgo(int s){
        boolean visited[] = new boolean[V];
        Stack<Integer> S = new Stack();
        visited[s] = true;
        S.push(s);

        while(!S.isEmpty()){
            int u = S.pop();
            System.out.print(u + " ");
            for(int i = 0; i < adj[u].size(); i++){
                int v = adj[u].get(i);
                if(!visited[v]){
                    visited[v] = true;
                    S.push(v);
                }
            }
        }

        
    }

    
}









public class DfsExample {
    public static void main(String[] args){
        DFS g = new DFS(8);
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
        System.out.println("DFS starting from veretex 1: ");
        g.DFSAlgo(1);
        

    }

}
