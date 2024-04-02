import java.util.ArrayList;
import java.util.Arrays;
// In a candy store, there are N different types of candies available and the prices of 
// all the N different types of candies are provided. There is also an attractive offer by
//  the candy store. We can buy a single candy from the store and get at 
//  most K other candies (all are different types) for free.

// Find the minimum amount of money we have to spend to buy all the N different candies.
// Find the maximum amount of money we have to spend to buy all the N different candies.
// In both cases, we must utilize the offer and get the maximum possible candies back. 
// If k or more candies are available, we must take k candies for every candy purchase. 
// If less than k candies are available, we must take all candies for a candy purchase.

// Examples: 

// Input :  
// price[] = {3, 2, 1, 4}
// k = 2
// Output :  
// Min = 3, Max = 7
// Explanation :
// Since k is 2, if we buy one candy we can take atmost two more for free.
// So in the first case we buy the candy which 
// costs 1 and take candies worth 3 and 4 for 
// free, also you buy candy worth 2 as well.
// So min cost = 1 + 2 = 3.
// In the second case we buy the candy which 
// costs 4 and take candies worth 1 and 2 for 
// free, also We buy candy worth 3 as well. So max cost = 3 + 4 = 7.


// Approach: First Sort the price array.

        // For finding minimum amount :
        // Start purchasing candies from starting 
        // and reduce k free candies from last with
        // every single purchase.

        // For finding maximum amount : 
        // Start purchasing candies from the end 
        // and reduce k free candies from starting 
        // in every single purchase.


public class ShopInCandyStoreProblem {

    
        int[] findMinMax(int[] price, int n, int k) {
            int min = 0;
            int max = 0;
            for (int i = 0; i < n; i++) {
                if (i % (k + 1) == 0) { // i % (k+1) == 0 means we are buying a candy
                    min += price[i];
                }
            }
            for (int i = n - 1; i >= 0; i--) {
                if (i % (k + 1) == 0) {
                    max += price[i];
                }
            }

            return new int[]{min, max};
        }

        static ArrayList<Integer> candyStore(int candies[],int N,int k){
            // code here
            ArrayList<Integer> ans = new ArrayList<>();
            Arrays.sort(candies);
            int max=0,min=0,free=0;
            for(int i=0;i<N-free;i++){
                min+=candies[i];
                free+=k;
            }
            free=0;
            for(int i=N-1;i>=free;i--){
                max+=candies[i];
                free+=k;
            }
            ans.add(min);
            ans.add(max);
            return ans;
        }
    
    public static void main(String[] args) {
        int[] price = {3, 2, 1, 4};
        int n = price.length;
        int k = 2;
        int min = 0;
        int max = 0;
        for(int i = 0; i < n; i++){
            if(i % (k+1) == 0){ // i % (k+1) == 0 means we are buying a candy
                min += price[i];
            }
        }
        for(int i = n-1; i >= 0; i--){
            if(i % (k+1) == 0){
                max += price[i];
            }
        }
        System.out.println("Min = " + min + ", Max = " + max);
    }
}