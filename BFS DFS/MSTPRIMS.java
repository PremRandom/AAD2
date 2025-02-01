import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;
class Edge{
    int vertex;
    int weight;
    public Edge(int vertex, int weight){
        this.vertex = vertex;
        this.weight = weight;

    }
}
class Graph{
    int V;
    LinkedList<Edge> adj[];
    public Graph(int n){
        V = n;
        adj = new LinkedList[n];
        for(int i = 0; i < n; i++){
            adj[i] = new LinkedList<Edge>();
        }
    }
    void addEdge(int u, int v, int weight){
        Edge uv = new Edge(v, weight);
        Edge vu = new Edge(u, weight);
        adj[u].add(uv);
        adj[v].add(vu);
    }

    int MstPrims(int root) {
        int[] key = new int[V];
        int[] pi = new int[V];
        boolean[] visited = new boolean[V];
        PriorityQueue<Edge> Q = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        int cost = 0;

        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            visited[i] = false;
            pi[i] = -1;
        }

        key[root] = 0;
        Q.add(new Edge(root, 0));

        while (!Q.isEmpty()) {
            int u = Q.poll().vertex;
            visited[u] = true;

            for (Edge edge : adj[u]) {
                int v = edge.vertex;
                int weight = edge.weight;

                if (!visited[v] && weight < key[v]) {
                    key[v] = weight;
                    pi[v] = u;
                    cost += weight;
                    System.out.println(weight);
                    Q.add(new Edge(v, key[v]));
                }
            }
        }

        return cost;
    }
}


public class MSTPRIMS {
    public static void main(String[] args) {
        Graph G = new Graph(8);
        G.addEdge(1,2,8);
        G.addEdge(1,3,5);
        G.addEdge(2,3,10);
        G.addEdge(2,4,2);
        G.addEdge(2,5,20);
        G.addEdge(3,4,3);
        G.addEdge(3,6,15);
        G.addEdge(4,5,12);
        G.addEdge(4,6,35);
        G.addEdge(4,7,18);
        G.addEdge(5,7,4);
        G.addEdge(6,7,30);

        System.out.println(G.MstPrims(1));



    }
}

