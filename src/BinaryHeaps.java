public class BinaryHeaps {

    private int N;
    private int a[];
    private int capacity;

    public BinaryHeaps(int N){
        this.capacity = N;
        this.N = 0;
        a = new int[N+1];
    }

    private void swim(int k){
        while(k>1 && a[k]>a[k/2]){
            swap(a,k,k/2);
            k = k/2;
        }
    }

    public void insert(int x){
        a[++N] = x;
        swim(N);
    }

    public void delMax(){
        int max = a[1];
        swap(a,1,N--);
        sink(1);
        a[N+1] = Integer.parseInt(null);
    }

    private void sink(int k){
        while(2*k<=N){
            int j = 2*k;
            if(j<N&&a[j]<a[j+1])
                j++;
            if(!(a[k]>a[j])) break;
            swap(a,k,j);
            k = j;
        }
    }

    private void swap(int a[],int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
