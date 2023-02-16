import java.util.Stack;

public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    int s;

    private void dfs(Graph G, int s) {
        marked[s] = true;
        for(int w : G.adj(s)) {
            if(!marked[w]) {
                edgeTo[w] = s;
                dfs(G, w);
            }
        }
    }

    public Iterable<Integer> pathTo(int v) {
        if(!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for(int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        return path;
    }

    public boolean hasPathTo(int i) {
        return marked[i];
    }
}
