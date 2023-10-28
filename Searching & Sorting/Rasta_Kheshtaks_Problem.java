import java.util.Scanner;


// The problem you described, known as the Biggest Common Subsquare (BCS) problem, involves two rectangular grids of integers, which you've referred to as "Kheshtaks." Let's break down the problem:

// **Input:**
// 1. You are given two Kheshtaks, A and B.
// 2. The first Kheshtak, A, is a grid with dimensions n × m (n rows and m columns). Each cell in this grid contains an integer in the range [1, 1000].
// 3. The second Kheshtak, B, is also a grid with dimensions x × y (x rows and y columns). Each cell in this grid also contains an integer in the range [1, 1000].

// **Output:**
// The goal is to find the size of the Biggest Common Subsquare (BCS) between Kheshtak A and Kheshtak B. A BCS is a square grid, which means it has an equal number of rows and columns, and it is a subset of both Kheshtak A and Kheshtak B. In other words, you can obtain the BCS by deleting some rows and columns from both Kheshtak A and Kheshtak B.

// **Example:**
// Let's take your provided example:

// **Input:**
// - Kheshtak A: 
//   ```
//   3 3
//   1 2 0
//   1 2 1
//   1 2 3
//   ```
// - Kheshtak B:
//   ```
//   3 3
//   0 1 2
//   1 1 2
//   3 1 2
//   ```

// **Output:**
// The largest common subsquare in this case has a size of 2. It's essentially a 2x2 square, and you can obtain it by deleting the last row and the last column from both Kheshtak A and Kheshtak B.

// The provided Java program reads the input grids, uses dynamic programming to find the size of the BCS, and then prints the size of the BCS as output.

// In essence, it's a problem of finding a square subgrid with the same values in both Kheshtak A and Kheshtak B while minimizing the number of rows and columns to delete.






public class Rasta_Kheshtaks_Problem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Read the dimensions of Kheshtak A
        int n = input.nextInt();
        int m = input.nextInt();
        
        int[][] A = new int[n][m];
        
        // Read Kheshtak A
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                A[i][j] = input.nextInt();
            }
        }
        
        // Read the dimensions of Kheshtak B
        int x = input.nextInt();
        int y = input.nextInt();
        
        int[][] B = new int[x][y];
        
        // Read Kheshtak B
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                B[i][j] = input.nextInt();
            }
        }
        
        // Initialize a 2D array for dynamic programming
        int[][] dp = new int[n + 1][m + 1];
        int maxSubsquareSize = 0;
        
        // Calculate the size of the BCS
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A[i - 1][j - 1] == B[0][0]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxSubsquareSize = Math.max(maxSubsquareSize, dp[i][j]);
                }
            }
        }
        
        // Print the size of the BCS
        System.out.println(maxSubsquareSize);
    }
}
