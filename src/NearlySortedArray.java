import java.util.PriorityQueue;

public class NearlySortedArray {

    public static void main(String args[]){

        int k = 3;
        int a[] = {2,6,3,12,56,8};
        int n = a.length;
        sort(a,n,k);
        for(int i=0;i<n;i++)
            System.out.println(a[i]);
    }

    private static void sort(int a[],int n,int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<=k;i++)
            queue.add(a[i]);
        for(int i=k+1,ti=0;ti<n;i++,ti++){
            if(i<n) {
                a[ti] = queue.poll();
                queue.add(a[i]);
            }
            else{
                a[ti] = queue.poll();
            }
        }
    }
}
