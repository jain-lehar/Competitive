public class IntervalTree{

    class Interval{
        int low;
        int high;
    }

    class IntervalNode{
        Interval i;
        int max;
        IntervalNode right;
        IntervalNode left;

        public IntervalNode (Interval i){
            this.i = i;
            this.max = i.high;
        }
    }

    private IntervalNode root;

    public void insert(Interval i){
        root = insert(root,i);
    }

    private IntervalNode insert(IntervalNode node,Interval i){

        if(node==null)
            return new IntervalNode(i);
        int l = node.i.low;
        if(i.low<l)
            node.left = insert(node.left,i);
        else
            node.right = insert(node.right,i);

        node.max = Math.max(node.max,i.high);
        return node;
    }

    private Interval overlapSearch(IntervalNode node,Interval i){

        if(node==null) return null;
        if(node.i.low<=i.high&&i.low<=root.i.high)
            return node.i;

        if(node.left!=null && node.left.max>=i.low)
            return overlapSearch(node.left,i);

        return overlapSearch(node.right,i);
    }
}