public class Subset_Sum {
    static boolean Subset_Sum_Rec(int [] arr,int n,int sum){
        //base case 
        if(sum==0){
            return true;
        }
        if(n==0){
            return false;
        }
        //if last element is greater than sum element then ingnore it
        if(arr[n-1]>sum){
            return Subset_Sum_Rec(arr, n-1, sum);
        }
        // now we take that element or not that means in including or excluding
        return Subset_Sum_Rec(arr, n-1, sum) || Subset_Sum_Rec(arr, n-1, sum-arr[n-1]);
    }


    static boolean Subset_Sum_Memoization(int [] arr,int n,int sum,Boolean [][] memo){
        //base case 
        if(sum==0){
            return true;
        }
        if(n==0){
            return false;
        }
        if(memo[n-1][sum]!=null){
            return memo[n][sum];
        }
        //if last element is greater than sum element then ingnore it
        if(arr[n-1]>sum){
            memo[n][sum]= Subset_Sum_Memoization(arr, n-1, sum,memo);
            return memo[n][sum];
        }
        // now we take that element or not that means in including or excluding
        memo[n][sum]= Subset_Sum_Memoization(arr, n-1, sum,memo) || Subset_Sum_Memoization(arr, n-1, sum-arr[n-1],memo);
        return memo[n][sum];
    }


    static boolean Subset_Sum_tabulation(int[] arr,int n,int sum){
        boolean[][] tab=new boolean[n+1][sum+1];
        //base case => column 0 will all true row 1 will false except first element
        for(int i=0;i<=n;i++){
            tab[i][0]=true;
        } 
        for(int j=1;j<=sum;j++){
            tab[0][j]=false;
        }
        //filling the table
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]>j) //last element if larget than sum the ignore
                {
                    tab[i][j]=tab[i-1][j];
                }
                else{
                    tab[i][j]=tab[i-1][j] || tab[i-1][j-arr[i-1]];
                }

            }
        }
        return tab[n][sum];

    }
    public static void main(String[] args) {
        int[] arr={10, 0, 5, 8, 6, 2, 4};
        int sum=15;
        int n=arr.length;

        // Subset sum Recursion
        if(Subset_Sum_Rec(arr, n, sum)==true){
            System.out.println("Found Subset Sum (Using Recursion) ):- ");
        }
        else{
            System.out.println("Not Found!");
        }

        //Subset Sum Memoization
        Boolean[][] memo=new Boolean[n+1][sum+1];
        if(Subset_Sum_Memoization(arr, n, sum,memo)==true){
            System.out.println("Found Subset Sum (Using Memoization) ):- ");
        }
        else{
            System.out.println("Not Found!");
        }

        // Tabulation code
        if(Subset_Sum_tabulation(arr, n, sum)==true){
            System.out.println("Found Subset Sum (Using Tabulation) ):- ");
        }
        else{
            System.out.println("Not Found!");
        }
    }
}