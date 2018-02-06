import java.util.ArrayList;

public class FlowNetwork {

    private final int V;
    private ArrayList<FlowEdge> adj[];

    public FlowNetwork(int V){
        this.V = V;
        this.adj = new ArrayList[V];
        for(int i=0;i<V;i++){
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(FlowEdge e){
        int v = e.to();
        int w = e.from();
        adj[v].add(e);
        adj[w].add(e);
    }

    public Iterable<FlowEdge> adj(int v){
        return adj[v];
    }

    public int V(){
        return V;
    }
}
