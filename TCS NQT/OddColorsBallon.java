
// Question 2:
// At a fun fair, a street vendor is selling different colours of balloons. He sells N number of
// different colours of balloons (B[]). The task is to find the colour (odd) of the balloon which is
// present odd number of times in the bunch of balloons.
// Note:
// If there is more than one colour which is odd in number, then the first colour in the array which is
// present odd number of times is displayed. The colours of the balloons can all be either upper
// case or lower case in the array. If all the inputs are even in number, display the message “All are
// even”.
// Example 1:
// 7 -> Value of N
// [r,g,b,b,g,y,y] -> B[] Elements B[0] to B[N-1], where input each element is sepārated by ṉew
// line.
// Output :
// r -> [r,g,b,b,g,y,y] -> “r” colour balloon is present odd number of times in the bunch.
// Explanation:
// From the input array above:
// r: 1 balloon
// g: 2 balloons
// 223
// TCS NQT Solved Paper - 13th Sept 2021 [Slot 1]
// b: 2 balloons
// y : 2 balloons
// Hence , r is only the balloon which is odd in number.
// Example 2:
// Input:
// 10 -> Value of N
// [a,b,b,b,c,c,c,a,f,c] -> B[], elements B[0] to B[N-1] where input each element is separated by
// new line.
// Output :
// b-> ‘b’ colour balloon is present odd number of times in the bunch.
// Explanation:
// From the input array above:
// a: 2 balloons
// b: 3 balloons
// c: 4 balloons
// f: 1 balloons
// Here, both ‘b’ and ‘f’ have odd number of balloons. But ‘b’ colour balloon occurs first.
// Hence , b is the output.
// The input format for testing
// The candidate has to write the code to accept: 3 input
// First input: Accept value for number of N(Positive integer number).
// Second Input : Accept N number of character values (B[]), where each value is separated by a
// new line.
// The output format for testing
// The output should be a single literal (Check the output in example 1 and example 2)
// Constraints:
// 3<=N<=50
// B[i]={{a-z} or {A-Z}}

// Approach: The idea is to create a map to store the frequency of each colour in the array.
// Then, we will iterate through the map and find the first colour which has an odd frequency.
// If no colour has an odd frequency, we will return “All are even”.

// Time Complexity: O(n)
// Space Complexity: O(n)
import java.util.HashMap;
import java.util.Map;

public class OddColorsBallon {

    public static String oddColorsBallon(int n, char[] arr) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            if (map.get(arr[i]) % 2 != 0) {
                return String.valueOf(arr[i]);
            }
        }
        return "All are even";
    }

    public static void main(String[] args) {
        int n = 7;
        char[] arr = { 'r', 'g', 'b', 'b', 'g', 'y', 'y' };
        System.out.println(oddColorsBallon(n, arr));
    }
}
