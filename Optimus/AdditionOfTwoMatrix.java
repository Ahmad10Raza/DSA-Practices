
// Write a program to add Two Matrices using Multi-dimensional Array.

// Input :
// 1 2 3
// 4 5 6
// 7 8 9

// 9 8 7
// 6 5 4
// 3 2 1

// Output :
// 10 10 10
// 10 10 10
// 10 10 10

// Approach: To add two matrices, we need to iterate over each element of the matrices and add the corresponding elements. The sum of the elements will be stored in a new matrix.

public class AdditionOfTwoMatrix {

    public static int[][] addMatrices(int[][] mat1, int[][] mat2) {
        int rows = mat1.length;
        int cols = mat1[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = mat1[i][j] + mat2[i][j];
            }
        }

        return result;
    }

    public static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] mat1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] mat2 = { { 9, 8, 7 }, { 6, 5, 4 }, { 3, 2, 1 } };

        int[][] result = addMatrices(mat1, mat2);
        printMatrix(result);
    }

}
