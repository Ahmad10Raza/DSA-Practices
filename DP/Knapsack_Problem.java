public class Knapsack_Problem {
    public static int Knapsack(int val[],int wt[],int W,int n){
//base case
if(W==0 || n==0){
    return 0;
}
if(wt[n-1]<=W){
    int ans1=val[n-1]+Knapsack(val, wt, W-wt[n-1], n-1);  //include case if above condition is tue
    int ans2=Knapsack(val, wt, W, n-1);//exclude case if above condition is ture
    return Math.max(ans1, ans2);
}
else{
    return Knapsack(val, wt, W, n-1);
}
    }
    public static int Knapsack_Memoization(int val[],int wt[],int W,int n,int dp[][]){
        //base case
        if(W==0 || n==0){
            return 0;
        }
        if(dp[n][W]!=-1){
            return dp[n][W];
        }
        if(wt[n-1]<=W){
            int ans1=val[n-1]+Knapsack_Memoization(val, wt, W-wt[n-1], n-1,dp);  //include case if above condition is tue
            int ans2=Knapsack_Memoization(val, wt, W, n-1,dp);//exclude case if above condition is ture
            dp[n][W]= Math.max(ans1, ans2);
        return dp[n][W];
        }
        else{
            dp[n][W]= Knapsack(val, wt, W, n-1);
            return dp[n][W];
        }
            }
            public static int Knapsack_Tabulation(int val[],int wt[],int W,int n){
                int[] dp=new int[W+1];
                for(int i=1;i<n+1;i++){
                    for(int w=W;w>=0;w--){
                        if(wt[i-1]<=w){
                        dp[w]=Math.max(dp[w],dp[w-wt[i-1]]+val[i-1]);
                    }
                }
            }
                return dp[W];

            }
public static void main(String[] args) {
    int val[]={15,14,10,45,30};
    int wt[]={2,5,1,3,4};
    int W=7;
    int dp[][]=new int[val.length+1][W+1];
    for(int i=0;i<dp.length;i++){
        for(int j=0;j<dp[0].length;j++){
            dp[i][j]=-1;
        }
    }
    System.out.println("Answer By Recursion is : "+Knapsack(val, wt, W, val.length));
    System.out.println("Answer By Memoization is : "+Knapsack_Memoization(val, wt, W, val.length,dp));
    System.out.println("Answer By Tabulation is : "+Knapsack_Tabulation(val, wt, W, val.length));

}
}
