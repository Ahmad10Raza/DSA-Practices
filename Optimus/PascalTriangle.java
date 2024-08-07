
// Pascal's Triangle is a mathematical concept that is used to represent the triangle of binomial coefficients.
// The triangle is constructed such that the first and last element of each row is 1 and the other elements are the sum of the two elements above it.
// The triangle is named after the French mathematician Blaise Pascal.
// The triangle is used in various fields such as combinatorics, probability theory, and algebra.
// The triangle is represented as follows:
//           1
//         1   1
//       1   2   1
//     1   3   3   1
//   1   4   6   4   1
// 1   5  10  10   5   1

// Given an integer n, return the first n rows of Pascal's Triangle.
// Example
// Input: n = 5
// Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

// Approach: Use a 2D array to store the elements of Pascal's Triangle. Initialize the first row with 1. For each row, calculate the elements based on the previous row.
// Complexity Analysis
// Time Complexity: O(N^2), where N is the number of rows in Pascal's Triangle.
// Space Complexity: O(N^2), where N is the number of rows in Pascal's Triangle.

// Follow below steps to implement the code:
// 1. Create a 2D array to store the elements of Pascal's Triangle.
// 2. Initialize the first row with 1.
// 3. For each row, calculate the elements based on the previous row.
// 4. Return the 2D array containing the first n rows of Pascal's Triangle.

public class PascalTriangle {

    public static int[][] generate(int n) {
        int[][] triangle = new int[n][];
        for (int i = 0; i < n; i++) {
            triangle[i] = new int[i + 1];
            triangle[i][0] = 1;
            triangle[i][i] = 1;
            for (int j = 1; j < i; j++) {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
        }
        return triangle;
    }

    public static int[] palcalTraingle(int n) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = 1;
            for (int j = i - 1; j > 0; j--) {
                result[j] += result[j - 1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] result = generate(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
