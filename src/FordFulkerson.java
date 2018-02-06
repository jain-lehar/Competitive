import java.util.LinkedList;
import java.util.Queue;

public class FordFulkerson {

    private boolean marked[];
    private FlowEdge[] edgeTo;
    private int value;
    public FordFulkerson(FlowNetwork G,int s,int t){
        value = 0;
        while(hasAugmentingPath(G,s,t)){
            int bottleneck = Integer.MAX_VALUE;
            for(int v=t;v!=s;v=edgeTo[v].other(v)){
                bottleneck = Math.min(bottleneck,edgeTo[v].residualCapacityTo(v));
            }
            for(int v=t;v!=s;v=edgeTo[v].other(v)){
                edgeTo[v].addResidualFlowTo(v,bottleneck);
            }
            value+=bottleneck;
        }
    }

    public int getValue(){
        return value;
    }
    private boolean hasAugmentingPath(FlowNetwork G,int s,int t){
        edgeTo = new FlowEdge[G.V()];
        marked = new boolean[G.V()];
        Queue<Integer> q= new LinkedList<>();
        q.add(s);
        marked[s]=true;
        while (!q.isEmpty()){
            int v = q.poll();
            for(FlowEdge e:G.adj(v)){
                int w = e.other(v);
                if(e.residualCapacityTo(w)>0&&!marked[w]){
                    edgeTo[w] = e;
                    marked[w] = true;
                    q.add(w);
                }
            }
        }
        return marked[t];
    }
}
