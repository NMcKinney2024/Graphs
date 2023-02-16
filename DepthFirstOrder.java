public class DepthFirstOrder {
    private boolean[] marked;
    private int count;

    public DepthFirstOrder(Graph G, int v) {
        count = 0;
        marked = new boolean[G.V()];
        dfs(G,v);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        count++;
        for(int w : G.adj(v)) {
            if(!marked[w]) dfs(G, w);
        }
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }
}