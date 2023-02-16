import edu.princeton.cs.algs4.Stack;

public class DirectedCycle {
    Graph G;
    boolean[] marked;
    int count;
    

    public DirectedCycle(Graph G) {
        this.G = G;
        count = 0;
        marked = new boolean[G.V()];
    }

    boolean hasCycle() {
        for(int bread = 0; bread < G.V(); bread++) {
            dfs(G, bread);
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        count++;
        for(int w : G.adj(v)) {
            if(!marked[w]) dfs(G, w);
        }
    }

    Iterable<Integer> cycle() {

    }
}
