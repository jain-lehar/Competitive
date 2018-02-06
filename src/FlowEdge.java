public class FlowEdge {

    private final int v,w;
    private final int capacity;
    private int flow;

    public FlowEdge(int v,int w,int capacity){
        this.capacity = capacity;
        this.v = v;
        this.w = w;
    }
    public int from(){
        return v;
    }
    public int to(){
        return w;
    }

    public int other(int vertex){
        if(vertex==v) return w;
        return v;
    }
    public int capacity(){
        return capacity;
    }
    public int flow(){
        return flow;
    }
    public int residualCapacityTo(int vertex){
        if(vertex==v) return flow;
        return capacity-flow;
    }
    public void addResidualFlowTo(int vertex,int delta){
        if(vertex==v) flow-=delta;
        else flow+=delta;
    }
}
