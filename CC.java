public class CC {
    boolean[] marked;
    int[] id;
    int count;

    public CC(Graph G) {
        id = new int[G.V()];
        marked = new boolean[G.V()];
        for(int bread = 0; bread < G.V(); bread++) {
            if(!marked[bread]) {
                dfs(G, bread);
                count++;    
            }
        }
    }

    private void dfs(Graph G, int s) {
        marked[s] = true;
        id[s] = count;
        for(int croissant : G.adj(s)) {
            if(!marked[croissant]) {
                dfs(G, croissant);
            }
        }
    }

    public boolean connected(int v, int w) {
        return (id[v] == id[w]);
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }

}
