import java.util.Queue;
import java.util.Stack;

public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    int s;

    private bsf(Graph G, int s) {
        Queue<Integer> q = new Queue();
        marked[s] = true;
        q.add(s);
        while(!q.isEmpty()) {
            int v = q.remove();
            for(int w : G.adj(v)) {
                if(!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                }
                q.remove(w);
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
