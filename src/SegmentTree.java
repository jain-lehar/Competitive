public class SegmentTree {

    public int[] segmentTree(int input[]){

        int size = input.length;
        int segmentTree[] = new int[2*size-1];
        for(int i=0;i<segmentTree.length;i++){
            segmentTree[i] = Integer.MAX_VALUE;
        }
        constructSegmentTree(segmentTree,input,0,input.length,0);
        return segmentTree;
    }

    private void constructSegmentTree(int st[],int a[],int lo,int hi,int pos){
        if(lo==hi){
            st[pos] = a[lo];
            return;
        }
        int mid= (lo+hi)/2;
        constructSegmentTree(st,a,lo,mid,2*pos+1);
        constructSegmentTree(st,a,mid,hi,2*pos+2);
        st[pos] = Math.min(st[2*pos+1],st[2*pos+2]);
    }

    public void updateSegmentTreeRange(int input[],int st[],int delta,int start,int end){
        for(int i=start;i<end;i++)
            input[i]+=delta;
        updateSegmentTree(st,start,end,delta,0,input.length-1,0);
    }

    private void updateSegmentTree(int st[],int start,int end,int delta,int lo,int hi,int pos){
        if(lo>hi||start>hi||end<lo)
            return;
        if(lo==hi){
            st[pos] += delta;
            return;
        }
        int mid = (lo+hi)/2;
        updateSegmentTree(st,start,end,delta,lo,mid,pos);
        updateSegmentTree(st,start,end,delta,mid,hi,pos);
        st[pos] = Math.min(st[2*pos+1],st[2*pos+2]);
    }

    public int rangeMinQuery(int st[],int qlo,int qhi,int input[]){
        return rangeMinQuery(st,0,input.length-1,qlo,qhi,0);
    }

    private int rangeMinQuery(int st[],int lo,int hi,int qlo,int qhi,int pos){
        if(qlo<=lo&&qhi>=hi)
            return st[pos];
        if(qlo>hi||qhi<lo)
            return Integer.MAX_VALUE;

        int mid = (lo+hi)/2;
        return Math.min(rangeMinQuery(st,lo,mid,qlo,qhi,2*pos+1),rangeMinQuery(st,mid,hi,qlo,qhi,2*pos+2));
    }
}
