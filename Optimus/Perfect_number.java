
// We have given a number n, we have to check whether the given number is a perfect number or not.

// A perfect number is a positive integer that is equal to the sum of its proper divisors excluding itself.

// For example, 6 is a perfect number because the sum of its proper divisors is 1 + 2 + 3 = 6.

// Input: 6
// Output: true

// Input: 28
// Output: true

// Approach 1: Using a while loop
// Time Complexity: O(sqrt(n)), where n is the input number
// Space Complexity: O(1)

// Follow this step to solve the problem:
// 1. Initialize a variable sum to 0.
// 2. Iterate from 1 to the square root of the input number n.
// 3. If n is divisible by i, add i and n/i to the sum.
// 4. If the sum is equal to n, return true.
// 5. Otherwise, return false.


public class Perfect_number {
    
    public static boolean isPerfect(int n) {
        if (n <= 0) {
            return false;
        }
        
        int sum = 0;
        
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                
                if (i * i != n) {
                    sum += n / i;
                }
            }
        }
        
        return sum - n == n;
    }

    public static boolean isPerfect2(int n){
        int i = 1;
        int total = 0;
        while(i < n){
            if(n % i == 0){
                total += i;
            }
            i++;
        }
        return total == n;
    }

    public static void main(String[] args) {
        int n = 28;
        System.out.println(isPerfect(n));
        System.out.println(isPerfect2(n));
    }
    
}