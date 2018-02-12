public class BinaryIndexedTree {

    public int[] createTree(int a[]){
        int tree[] = new int[a.length+1];
        for(int i=1;i<tree.length;i++){
            updateTree(tree,a[i-1],i);
        }
        return tree;
    }

    public void updateTree(int tree[],int val,int index){
        while(index<tree.length){
            tree[index]+=val;
            index = getNext(index);
        }
    }

    public int getSum(int tree[],int index){
        index = index + 1;
        int sum = 0;
        while (index>0){
            sum+=tree[index];
            index = getParent(index);
        }
        return sum;
    }

    private int getNext(int i){
        return i + (i&-i);
    }

    private int getParent(int i){
        return i - (i&-i);
    }
}
