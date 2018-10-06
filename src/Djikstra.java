import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Djikstra {

    private class Node implements Comparable<Node>{
        int dist;
        Node parent;
        ArrayList<Edge> adj;

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

    private class Edge{
        Node to;
        int dist;
        public Edge(Node to,int dist){
            this.to = to;
            this.dist = dist;
        }
    }
    private int N;
    private Scanner in;
    PriorityQueue<Node> pq;

    public Djikstra(int N,int source){
        this.N = N;
        in = new Scanner(System.in);
        pq = new PriorityQueue<>();
        init(source);
    }

    public void init(int s){
        Node[] nodes = new Node[N];
        for(int i=0;i<N;i++){
            nodes[i] = new Node();
            nodes[i].dist = Integer.MAX_VALUE;
            nodes[i].adj = new ArrayList<>();
        }
        int m = in.nextInt();
        for(int i=0;i<m;i++){
            int a = in.nextInt();

            int b = in.nextInt();
            int dist = in.nextInt();
            nodes[a].adj.add(new Edge(nodes[b],dist));
        }
        nodes[s].dist = 0;
        pq.add(nodes[s]);
        while(!pq.isEmpty()){
            Node n = pq.poll();
            for(Edge e:n.adj){
                if(n.dist+e.dist<e.to.dist){
                    e.to.dist = n.dist+e.dist;
                    e.to.parent = n;
                    pq.add(e.to);
                }
            }
        }
    }
}
