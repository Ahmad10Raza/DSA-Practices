import java.util.Arrays;

public class Rod_Cutting_Problem 
{
    public static int RCP(int[] price,int index,int n)
    {
        if(index==0){
            return n*price[0];
        }
         //so we have two option first cut the rod and 2nd one not cut the rod
         int notCut=RCP(price,index-1,n);
         int maxProfit=Integer.MIN_VALUE;     //that is minus infanite
            int rod_length=index+1;
            if(rod_length<=n)
                maxProfit=price[index]+RCP(price, index-1, n-rod_length);
                return Math.max(maxProfit,notCut);
            
    }


    public static int RCP_Meomization(int[] price,int index,int n,int dp[][])
    {
        if(index==0){
            return n*price[0];
        }
        if(dp[index][n]!=-1){
            return dp[index][n];
        }
         int notCut=RCP_Meomization(price,index-1,n,dp);
         int maxProfit=Integer.MIN_VALUE;     //that is minus infanite
            int rod_length=index+1;
            if(rod_length<=n){
                maxProfit=price[index]+RCP_Meomization(price, index-1, n-rod_length,dp);
            }
                return dp[index][n]= Math.max(maxProfit,notCut);
            
    }


    public static int RCP_Tbaulation(int price[],int n){
        int val[]=new int[n+1];
        val[0]=0;
        for(int i=1;i<=n;i++){
            int maxProfit=Integer.MIN_VALUE;
            for(int j=0;j<i;j++){
                maxProfit=Math.max(maxProfit, price[j]+val[i-j-1]);
                val[i]=maxProfit;
            }
        }
        return val[n];
    }
    public static void main(String[] args) 
    {
        int price[]={1,5,8,9,10,17,17,20};
        int size=price.length;
        System.out.println("The maximum obtained Value By Recursion: "+RCP(price, size-1,size));

        //for dp memoization
      int dp[][]=new int[size][size+1];
      for(int i=0;i<size;i++){
        Arrays.fill(dp[i], -1);
    }
    System.out.println("The maximum obtained Value By Memoization: "+RCP_Meomization(price, size-1,size,dp));
    System.out.println("The maximum obtained Value By Tabulation: "+RCP_Tbaulation(price, size));

    }
}
