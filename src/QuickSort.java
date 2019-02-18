public class QuickSort {

    private int partition(int a[],int lo,int hi){
        int i=lo;
        int j = hi+1;
        while(true){
            while(a[++i]<a[lo]){
                if(i==hi) break;
            }
            while(a[--j]>a[lo]){
                if(j==lo) break;
            }
            if(i>=j) break;
            swap(a,i,j);
        }
        swap(a,lo,j);
        return j;
    }

    private void swap(int a[],int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void sort(int a[]){
        sort(a,0,a.length-1);
    }

    private void sort(int a[],int lo,int hi){
        if(hi<=lo) return;
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    public static void main(String[] args) {
        int a[] = {5,32,643,54,324,689,7,523,34,765,3,5,5,7,4657,858,46,46,8769,80};
        new QuickSort().sort(a);
        for (int i:a) System.out.println(i);
    }
}