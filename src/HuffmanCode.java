import java.util.PriorityQueue;
import java.util.Scanner;

public class HuffmanCode {

    class HuffmanNode implements Comparable<HuffmanNode>{
        int data;
        char c;
        HuffmanNode left;
        HuffmanNode right;

        @Override
        public int compareTo(HuffmanNode node) {
            return this.data - node.data;
        }
    }

    HuffmanNode root;
    int N;
    PriorityQueue<HuffmanNode> pq;
    HuffmanCode(int N){
        root = null;
        this.N = N;
        pq = new PriorityQueue<>(N);
        init();
        makeCode();
    }

    public void init(){
        Scanner in = new Scanner(System.in);
        for(int i=0;i<N;i++){
            HuffmanNode node = new HuffmanNode();
            node.c = in.next().charAt(0);
            node.data = in.nextInt();
            pq.add(node);
        }
    }

    public void makeCode(){
        while(pq.size()>1){
            HuffmanNode x = pq.poll();
            HuffmanNode y = pq.poll();
            HuffmanNode node = new HuffmanNode();
            node.data = x.data+y.data;
            node.c='-';
            node.left = x;
            node.right = y;
            root = node;
            pq.add(node);
        }
    }
}
