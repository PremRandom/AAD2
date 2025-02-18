import java.util.LinkedList;
import java.util.PriorityQueue;

class Edge {
    int vertex, weight;
    public Edge(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

class Graph {
    int V;
    LinkedList<Edge>[] adj;

    @SuppressWarnings("unchecked")
    public Graph(int n) {
        V = n;
        adj = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int u, int v, int weight) {
        adj[u].add(new Edge(v, weight));
        adj[v].add(new Edge(u, weight));
    }

    int mstPrims(int root) {
        int[] key = new int[V];
        boolean[] inMST = new boolean[V];
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        int totalCost = 0;

        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
        }

        key[root] = 0;
        pq.add(new Edge(root, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int u = current.vertex;

            if (inMST[u]) continue; // Skip if already in MST

            inMST[u] = true;
            totalCost += current.weight;

            for (Edge edge : adj[u]) {
                int v = edge.vertex;
                int weight = edge.weight;

                if (!inMST[v] && weight < key[v]) {
                    key[v] = weight;
                    pq.add(new Edge(v, weight));
                }
            }
        }

        return totalCost;
    }
}

public class MSTPRIMS {
    public static void main(String[] args) {
        Graph G = new Graph(8);
        G.addEdge(1, 2, 8);
        G.addEdge(1, 3, 5);
        G.addEdge(2, 3, 10);
        G.addEdge(2, 4, 2);
        G.addEdge(2, 5, 20);
        G.addEdge(3, 4, 3);
        G.addEdge(3, 6, 15);
        G.addEdge(4, 5, 12);
        G.addEdge(4, 6, 35);
        G.addEdge(4, 7, 18);
        G.addEdge(5, 7, 4);
        G.addEdge(6, 7, 30);

        System.out.println("Total MST Cost: " + G.mstPrims(1));
    }
}
