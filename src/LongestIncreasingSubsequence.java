import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public int LIS(int a[]){
        int size = a.length;
        int tailTable[] = new int[size];
        int len;
        tailTable[0] = a[0];
        len = 1;
        for(int i=1;i<size;i++){
            if(a[i]<tailTable[0])
                tailTable[0] = a[i];
            else if(a[i]>tailTable[len-1])
                tailTable[len++] = a[i];
            else {
                int x = Arrays.binarySearch(a, 0, len, a[i]);
                if(x>=0) x++;
                else x = -(x+1);
            }
        }
        return len;
    }
}
