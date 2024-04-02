import java.util.*;

// Given a value of V Rs and an infinite supply of each of the denominations {1, 2, 5, 10, 20, 50, 100, 500, 1000}
// valued coins/notes, The task is to find the minimum number of coins and/or notes needed to make the change?

// Examples:  

// Input: V = 70
// Output: 2
// Explanation: We need a 50 Rs note and a 20 Rs note.

// Input: V = 121
// Output: 3
// Explanation: We need a 100 Rs note, a 20 Rs note, and a 1 Rs coin.

public class FindMinimumCoins {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        int V = 121;
        System.out.println(minCoins(coins, V));

        List<Integer> res = minCoins2(V);
        for (int i : res) {
            System.out.print(i + " ");
        }

    }

    // Approach 1 O(V): Follow the steps below to implement the idea: 

            // Sort the array of coins in decreasing order.
            // Initialize ans vector as empty.
            // Find the largest denomination that is smaller than remaining amount and while it is smaller than the remaining amount:
            // Add found denomination to ans. Subtract value of found denomination from amount.
            // If amount becomes 0, then print ans.


    public static int minCoins(int[] coins, int V) {
        int n = coins.length;
        Arrays.sort(coins);
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            res += V / coins[i];
            V = V % coins[i];
        }
        return res;
    }


    // Approach 2 O(N), O(1) If-else: Follow the steps below to implement the idea: 

                // Declare a vector that store the coins.
                // while n is greater than 0 iterate through greater to smaller coins:
                // if n is greater than equal to 2000 than push 2000 into the vector and decrement its value from n.
                // else if n is greater than equal to 500 than push 500 into the vector and decrement its value from n.
                // And so on till the last coin using ladder if else.
                // return the vector/array

    public static List<Integer> minCoins2(int N) {

        List<Integer> res = new ArrayList<>();
        while (N > 0) {
            if (N >= 2000) {
                res.add(2000);
                N -= 2000;
            } else if (N >= 500) {
                res.add(500);
            N -= 500;
            } else if (N>= 200) {
                res.add(200);
                N -= 200;
            } else if (N >= 100) {
                res.add(100);
                N -= 100;
            } else if (N >= 50) {
                res.add(50);
                N -= 50;
            } else if (N >= 20) {
                res.add(20);
                N -= 20;
            } else if (N >= 10) {
                res.add(10);
                N -= 10;
            } else if (N >= 5) {
                res.add(5);
                N -= 5;
            } else if (N >= 2) {
                res.add(2);
                N -= 2;
            } else {
                res.add(1);
                N -= 1;
            }
        }
        return res;
    }



}