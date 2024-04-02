import java.util.Arrays;
import java.util.PriorityQueue;
// In a stock market, there is a product with its infinite stocks. The stock prices are given for N days,
// where arr[i] denotes the price of the stock on the ith day. There is a rule that a customer can buy 
// at most i stock on the ith day. If the customer has k amount of money initially, find out the maximum 
// number of stocks a customer can buy. 

// For example, for 3 days the price of a stock is given as 7, 10, 4. You can buy 1 stock worth 7 rs on day 1,
//  2 stocks worth 10 rs each on day 2 and 3 stock worth 4 rs each on day 3.

// Examples: 

// Input : price[] = { 10, 7, 19 }, 
//               k = 45.
// Output : 4
// A customer purchases 1 stock on day 1 for 10 rs, 
// 2 stocks on day 2 for 7 rs each and 1 stock on day 3 for 19 rs.Therefore total of
// 10, 7 * 2 = 14 and 19 respectively. Hence, 
// total amount is 10 + 14 + 19 = 43 and number  of stocks purchased is 4.


// Approach: The idea is to use greedy approach, where we should start buying product from the day when the stock price is 
            // least and so on. So, we will sort the pair of two values i.e { stock price, day(ith ->index) } according to the stock price, 
            // and if stock prices are same, then we sort according to the day. 
            // Now, we will traverse along the sorted list of pairs, and start buying as follows: 
            // Let say, we have R rs remaining till now, and the cost of product on this day be C, and we can buy atmost
            // L products on this day then,  total purchase on this day (P) = min(L, R/C) 
            // Now, add this value to the answer 
            // total_purchase = total_purchase + P, where P =min(L, R/C) 
            // Now, subtract the cost of buying P items from remaining money, R = R – P*C. 
            // Total number of products that we can buy is equal to total_purchase.

// Java program to find maximum number of stocks that can be bought with given constraints.




public class BuyStocksProblem {
    public static void main(String[] args) {
        int price[] = { 10, 7, 19 };
        int n = price.length;
        int k = 45;
        System.out.println(buyMaximumProducts( n, k, price));
    }

    public static int buyMaximumProducts(int n, int k, int[] price) {
        // Create an array of pairs to store price and index
        int[][] pairs = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            pairs[i][0] = price[i];
            pairs[i][1] = i + 1;
        }
        
        // Sort the array based on prices
        Arrays.sort(pairs, (p1, p2) -> Integer.compare(p1[0], p2[0]));
        
        int count = 0;
        int remainingMoney = k;
        
        for (int i = 0; i < n; i++) {
            int stockValue = pairs[i][0] * pairs[i][1];
            
            if (remainingMoney >= stockValue) {
                count += pairs[i][1];
                remainingMoney -= stockValue;

            }
            // If we can't buy all the stocks on the current day then buy as many as we can buy with the remaining money 
            else if (remainingMoney >= pairs[i][0]) { // If we can buy atleast one stock on the current day 
                // Find the number of stocks we can buy on the current day
                int val = pairs[i][0];
                int it = 1; // Number of stocks we can buy on the current day
                
                while (remainingMoney >= val) {
                    count += 1;
                    remainingMoney -= val;
                    it++;
                }
            }
        }
        
        return count;
    }

// Approach 2 Optimized Approach : O(nlogn)
    public static int buyMaximumProducts2(int n, int k, int[] price) {
      
       // creating a vector 
       int[][] v = new int[n][2];

         // creating a vector to store the price and day
        for (int i = 0; i < n; i++) {
            v[i][0] = price[i];
            v[i][1] = i + 1;
    }

    // sorting the vector
    Arrays.sort(v, (a, b) -> a[0] - b[0]);

    int ans = 0;
    for (int i = 0; i < n; i++) {
        int stockPrice = v[i][0];
        int day = v[i][1];

        // calculating the number of stocks that can be bought on the current day
        int canBuy = Math.min(day, k / stockPrice);

        // updating the answer
        ans += canBuy;

        // updating the remaining money
        k -= stockPrice * canBuy;
    }

    // returning the answer
    return ans;
}


public static int buyMaximumProductsOptimized(int n, int k, int[] price) {
    // code here
    PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->a.val-b.val);
    // creating a priority queue to store the price and day of the stock
    for(int i =0; i<n;i++){
        pq.add(new Pair(price[i],i+1));
    }
    int amount=0,ans=0;
    boolean check=false; // to check if the amount is greater than k
    // traversing the priority queue to find the maximum number of stocks that can be bought
    while(pq.size()>0){
        // getting the top element of the priority queue
        Pair p=pq.poll();
        // calculating the amount
        for(int i=p.ind;i>=1;i--){ // traversing the days from the current day to the first day
            amount+=(p.val*i); // calculating the amount
            // if the amount is less than or equal to k, then increment the answer
            if(amount<=k){
                // incrementing the answer
                ans+=i;
                break;
            }
            // if the amount is greater than k, then update the amount by subtracting the price of the stock on the current day
            else{
                // updating the amount by subtracting the price of the stock on the current day
                check=true;
                amount-=(p.val*i);
            }
        }
        if(check==true){
            break;
        }
    }
    
    return ans;
}

static class Pair{
    int val;
    int ind;
    
    Pair(int val,int ind){
        this.val=val;
        this.ind=ind;
    }
}

}