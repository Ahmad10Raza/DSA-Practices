// import java.util.*;
public class Climbing_Stairs_Probelm {
    public static int CSP_Rec(int n){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        return CSP_Rec(n-1)+CSP_Rec(n-2);
    }
    public static int CSP_Memoization(int n,int ways[]){
        if (n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(ways[n]!=-1){
          return   ways[n];
        }
        ways[n] = CSP_Memoization(n-1,ways) + CSP_Memoization(n-2, ways);
        return ways[n];

    }

    public static int CSP_Tabulation(int n){
        int dp[]=new int[n+1];
        dp[0]=1;
        int i;
        for( i=1;i<=n;i++){
            if(i==1){
                dp[i]=dp[i-1]+0;
            }
                else{
                    dp[i]=dp[i-1]+dp[i-2];
                }
        }
        return dp[n];
    }
    public static void main(String[] args) {
     int n=8;
     System.out.println("The Total Number of Ways By Recursion is :"+CSP_Rec(n));   
     int ways[]=new int[n+1];
     for(int i=0;i<n+1;i++){
        ways[i]=-1;
     }
     System.out.println("The Total Number of Ways By Memoization is :"+CSP_Memoization(n,ways));   
     System.out.println("The Total Number of Ways By Tabulation is :"+CSP_Tabulation(n));   

    }
}