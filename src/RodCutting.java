import java.util.Scanner;

public class RodCutting {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int price[] = new int[n];
        for(int i=0;i<n;i++)
            price[i] = in.nextInt();
        int ans[][] = new int[n][n];
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = -1;
                if(j==0|| i==0) ans[i][j] = price[0]*(i+1);
            }
        }
        System.out.println(solve(ans,price,n,n-1));
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static int solve(int ans[][],int price[],int total,int pos){
        if(total<=0) return 0;
        if(total==1) return price[0];
        if(ans[total-1][pos]!=-1) return ans[total-1][pos];
        int value = 0;
        for(int i=0;i<=total/(pos+1);i++){
            value = Math.max(value,price[pos]*i+solve(ans,price,total-i*(pos+1),pos-1));
        }
        ans[total-1][pos] = value;
        return ans[total-1][pos];
    }
}
