// link : https://www.spoj.com/problems/DEFKIN/

// Theodore implements a new strategy game “Defense of a Kingdom”. 
// On each level a player defends the Kingdom that is represented 
// by a rectangular grid of cells. The player builds crossbow towers 
// in some cells of the grid. The tower defends all the cells in the
// same row and the same column. No two towers share a row or a column.

// The penalty of the position is the number of cells in the largest 
// undefended rectangle. For example, the position shown on the picture has penalty 12.

// Input
// The first line of the input file contains the number of test cases.

// Each test case consists of a line with three integer numbers: w — width of the grid, h — height of the grid and n — number of crossbow towers (1 ≤ w, h ≤ 40 000; 0 ≤ n ≤ min(w, h)).

// Each of the following n lines contains two integer numbers xi and yi — the coordinates of the cell occupied by a tower (1 ≤ xi ≤ w; 1 ≤ yi ≤ h).

// Output
// For each test case, output a single integer number — the number of cells in the largest rectangle that is not defended by the towers.

// Example
// Input:
// 1
// 15 8 3
// 3 8
// 11 2
// 8 6

// Output:
// 12


// Approach: The idea is to find the maximum gap between the towers in the x-axis and y-axis.
// The maximum gap in the x-axis will be the difference between the x-coordinates of the towers.
// The maximum gap in the y-axis will be the difference between the y-coordinates of the towers.
// The area of the largest rectangle that is not defended by the towers will be the product of 
// the maximum gaps in the x-axis and y-axis.
// The area of the grid will be the product of the width and height of the grid.
// The area of the largest rectangle that is not defended by the towers will be the difference 
// between the area of the grid and the area of the largest rectangle defended by the towers.
// Follow the steps below to solve the problem:

// Initialize the area of the largest rectangle defended by the towers to 0.
// Initialize the maximum gap in the x-axis to the x-coordinate of the first tower.
// Initialize the maximum gap in the y-axis to the y-coordinate of the first tower.
// Iterate through the towers and update the maximum gap in the x-axis and y-axis.
// Calculate the area of the largest rectangle defended by the towers.
// Calculate the area of the grid.
// Calculate the area of the largest rectangle that is not defended by the towers.
// Print the area of the largest rectangle that is not defended by the towers.

// Java code to find the largest rectangle that is not defended by the towers

import java.util.Scanner;

public class DefenseOfKingdom {

    // Function to find the area of the largest rectangle that is not defended by the towers
    static int largestRectangle(int w, int h, int n, int[][] towers) {
        // Check if there are no towers
        if (n == 0) {
            // The area of the largest rectangle that is not defended by the towers is the area of the grid
            return w * h;
        }

        // Initialize the area of the largest rectangle defended by the towers to 0
        int areaDefended = 0;

        // Initialize the maximum gap in the x-axis to the x-coordinate of the first tower
        int maxXGap = towers[0][0] - 1;

        // Initialize the maximum gap in the y-axis to the y-coordinate of the first tower
        int maxYGap = towers[0][1] - 1;

        // Iterate through the towers and update the maximum gap in the x-axis and y-axis
        for (int i = 1; i < n; i++) {
            maxXGap = Math.max(maxXGap, towers[i][0] - towers[i - 1][0] - 1);
            maxYGap = Math.max(maxYGap, towers[i][1] - towers[i - 1][1] - 1);
        }

        // Calculate the area of the largest rectangle defended by the towers
        areaDefended = (maxXGap + 1) * (maxYGap + 1);

        // Calculate the area of the grid
        int areaGrid = w * h;

        // Calculate the area of the largest rectangle that is not defended by the towers
        int areaNotDefended = areaGrid - areaDefended;

        // Return the area of the largest rectangle that is not defended by the towers
        return areaNotDefended;
    }

    


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // number of test cases

        while (t-- > 0) {
            int w = sc.nextInt(); // width of the grid
            int h = sc.nextInt(); // height of the grid
            int n = sc.nextInt(); // number of crossbow towers

            int[][] towers = new int[n][2]; // array to store the coordinates of the towers

            // Input the coordinates of the towers
            for (int i = 0; i < n; i++) {
                towers[i][0] = sc.nextInt();
                towers[i][1] = sc.nextInt();
            }

            // Find the area of the largest rectangle that is not defended by the towers
            int area = largestRectangle(w, h, n, towers);

            // Output the area of the largest rectangle that is not defended by the towers
            System.out.println(area);

        }
        sc.close();
    }
}