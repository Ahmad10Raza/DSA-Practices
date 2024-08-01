
// You are required to implement the following Function 

// def LargeSmallSum(arr)

// The function accepts an integers arr of size ’length’ as its arguments you are required to return the sum of second largest  element from the even positions and second smallest from the odd position of given ‘arr’

// Assumption:

// All array elements are unique
// Treat the 0th position as even
// NOTE

// Return 0 if array is empty
// Return 0, if array length is 3 or less than 3
// Example

// Input

// arr:3 2 1 7 5 4

// Output

// 7

// Explanation

// Second largest among even position elements(1 3 5) is 3
// Second smallest among odd position element is 4
// Thus output is 3+4 = 7
// Sample Input

// arr:1 8 0 2 3 5 6

// Sample Output

// 8

// Approach: We need to find the sum of the second largest element from the even positions and the second smallest element from the odd positions of the given array. We will iterate through the array and store the elements at even and odd positions in separate arrays. We will sort the arrays in ascending order. We will return the sum of the second largest element from the even positions and the second smallest element from the odd positions.

// Follow the below steps to solve the problem:
// 1. Check if the array is empty or the length of the array is less than or equal to 3. If yes, return 0.
// 2. Initialize two empty lists ‘even’ and ‘odd’ to store the elements at even and odd positions of the array.
// 3. Iterate through the array from 0 to length-1 and store the elements at even and odd positions in the lists ‘even’ and ‘odd’.
// 4. Sort the lists ‘even’ and ‘odd’ in ascending order.   
// 5. Return the sum of the second largest element from the ‘even’ list and the second smallest element from the ‘odd’ list.    

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargeSmallSum {

    public static int largeSmallSum(int[] arr) {
        if (arr.length == 0 || arr.length <= 3) {
            return 0;
        }
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                even.add(arr[i]);
            } else {
                odd.add(arr[i]);
            }
        }
        Collections.sort(even);
        Collections.sort(odd);
        return even.get(even.size() - 2) + odd.get(1);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 8, 0, 2, 3, 5, 6 };
        System.out.println(largeSmallSum(arr));
    }
}
