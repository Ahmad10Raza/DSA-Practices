// Given the weights and profits of N items, in the form of {profit, weight} put these items in a 
// knapsack of capacity W to get the maximum total profit in the knapsack. In Fractional Knapsack,
//  we can break items for maximizing the total value of the knapsack.

// Input: arr[] = {{60, 10}, {100, 20}, {120, 30}}, W = 50
// Output: 240 
// Explanation: By taking items of weight 10 and 20 kg and 2/3 fraction of 30 kg. 
// Hence total price will be 60+100+(2/3)(120) = 240

// Input:  arr[] = {{500, 30}}, W = 10
// Output: 166.667


// Approach:
// 1. Create a 2D array to store the profit and weight of the items.
// 2. Store the profit and weight of the items in the 2D array.
// 3. Sort the items based on their profit per unit weight peofit/weight.
// 4. Initialize the total profit to 0.
// 5. Initialize the remaining weight to the maximum weight of the knapsack.
// 6. Traverse through the items and do the following:
//    a. If the weight of the current item is less than or equal to the remaining weight,
        // then add the profit of the current item to the total profit.
//    b. Otherwise, add the profit of the current item based on the fraction of the weight that 
        // can be taken.
// 7. Return the total profit.


import java.util.Arrays;

class Item {
    int value, weight;

    public Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class FractionalKnapSack {

    public double fractionalKnapsack(int[][] items, int W) {
        // Sort the items based on their profit per unit weight
        Arrays.sort(items, (a, b) -> Double.compare((double) b[0] / b[1], (double) a[0] / a[1]));
        
        // Initialize the total profit to 0
        double totalProfit = 0;
        
        // Initialize the remaining weight to the maximum weight of the knapsack
        int remainingWeight = W;
        
        // Traverse through the items
        for (int i = 0; i < items.length; i++) {
            // If the weight of the current item is less than or equal to the remaining weight
            if (items[i][1] <= remainingWeight) {
                // Add the profit of the current item to the total profit
                totalProfit += items[i][0];
                remainingWeight -= items[i][1];
            } else {
                // Add the profit of the current item based on the fraction of the weight that can be taken
                totalProfit += (double) items[i][0] / items[i][1] * remainingWeight;
                break;
            }
        }
        
        // Return the total profit
        return totalProfit;
    }


    public double fractionalKnapsack2(int W, Item arr[], int n) {
        Arrays.sort(arr, (a, b) -> b.value * a.weight - a.value * b.weight);
        double totalValue = 0;
        for (Item i : arr) {
            if (i.weight <= W) {
                totalValue += i.value;
                W -= i.weight;
            } else {
                totalValue += i.value * ((double) W / i.weight);
                break;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        FractionalKnapSack fk = new FractionalKnapSack();
        int[][] items = {{60, 10}, {100, 20}, {120, 30}};
        int W = 50;
        System.out.println(fk.fractionalKnapsack(items, W)); // Output: 240.0
    }
}
