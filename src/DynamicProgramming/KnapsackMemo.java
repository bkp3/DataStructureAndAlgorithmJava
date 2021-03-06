package DynamicProgramming;

import java.util.Scanner;
/*

3
10 20 30
10 100 120
50
220

*/

public class KnapsackMemo {

    private static int dp[][];
    private static int N,C;

    KnapsackMemo(int n,int W){
        this.N=n;
        this.C=W;
        dp = new int[N+1][W+1];
        for(int i=0;i<=N;i++){
            for(int j=0;j<=W;j++){
                dp[i][j] = -1;
            }
        }
    }

    static int maxFun(int a,int b){
        return a>b?a:b;
    }

    static int knapSack(int wt[], int val[] ,int W,int n){
        if(n==0||W==0)
            return 0;
        if(dp[n][W]!=-1)
            return dp[n][W];
        if(wt[n-1]<=W)
            return dp[n][W]=maxFun(val[n-1]+knapSack(wt,val,W-wt[n-1],n-1),knapSack(wt,val,W,n-1));
        else
            return dp[n][W]=knapSack(wt,val,W,n-1);
    }

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int wt[]=new int[n];
        for(int i=0;i<n;i++){
            wt[i]=sc.nextInt();
        }
        int val[] = new int[n];
        for(int i=0;i<n;i++){
            val[i]=sc.nextInt();
        }
        int W=sc.nextInt();
        KnapsackMemo obj = new KnapsackMemo(n,W);
        int ans=knapSack(wt,val,W,n);
        System.out.println(ans);
    }
}
