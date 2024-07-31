
// Problem Description :
// The function accepts two positive integers ‘r’ and ‘unit’ and a positive integer array ‘arr’ of size ‘n’ as its argument ‘r’ represents the number of rats present in an area, ‘unit’ is the amount of food each rat consumes and each ith element of array ‘arr’ represents the amount of food present in ‘i+1’ house number, where 0 <= i

// Note:

// Return -1 if the array is null
// Return 0 if the total amount of food from all houses is not sufficient for all the rats.
// Computed values lie within the integer range.
// Example:

// Input:

// r: 7
// unit: 2
// n: 8
// arr: 2 8 3 5 7 4 1 2
// Output:

// 4

// Explanation:
// Total amount of food required for all rats = r * unit

// = 7 * 2 = 14.

// The amount of food in 1st houses = 2+8+3+5 = 18. Since, amount of food in 1st 4 houses is sufficient for all the rats. Thus, output is 4.

// Approach: We need to find the number of houses whose food is sufficient for all the rats. We will iterate through the array and keep adding the food in each house. If the total food is greater than or equal to the required food, we will return the number of houses. If the total food is less than the required food, we will return 0.

// Follow the below steps to solve the problem:
// 1. Check if the array is null. If yes, return -1.
// 2. Initialize a variable ‘totalFood’ to 0 to store the total food in the houses.
// 3. Iterate through the array from 0 to n-1 and add the food in each house to ‘totalFood’.
// 4. Check if the total food is greater than or equal to the required food. If yes, return the number of houses.
// 5. If the total food is less than the required food, return 0.

public class RatCountHouse {

    public static int ratCountHouse(int r, int unit, int n, int[] arr) {
        if (arr == null) {
            return -1;
        }
        int totalFood = 0;
        for (int i = 0; i < n; i++) {
            totalFood += arr[i];
            if (totalFood >= r * unit) {
                return i + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int r = 7;
        int unit = 2;
        int n = 8;
        int[] arr = { 2, 8, 3, 5, 7, 4, 1, 2 };
        System.out.println(ratCountHouse(r, unit, n, arr));
    }
}
