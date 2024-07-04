
// Java program to multiply two matrix

// Approach: To multiply two matrices, we need to iterate over each element of the resulting matrix and calculate the sum of the product of the corresponding elements of the two matrices. The product of the elements will be stored in a new matrix.

// If order of matrix A is (m x n) and order of matrix B is (n x p), then the order of the resulting matrix C will be (m x p).
// Multiplication of two matrices is only possible if the number of columns in the first matrix is equal to the number of rows in the second matrix.

// follow the below steps to multiply two matrices:
// 1. Initialize the resulting matrix C with dimensions (m x p) where m is the number of rows in matrix A and p is the number of columns in matrix B.
// 2. Iterate over each element of the resulting matrix C.
// 3. For each element C[i][j], calculate the sum of the product of the corresponding elements of row i of matrix A and column j of matrix B.
// 4. Store the sum in the resulting matrix C.
// 5. Return the resulting matrix C. 

public class MultiplicationOfTwoMatrix {

    public static int[][] multiplyMatrices(int[][] mat1, int[][] mat2) {
        int rows1 = mat1.length;
        int cols1 = mat1[0].length;
        int cols2 = mat2[0].length;

        int[][] result = new int[rows1][cols2];

        // check if multiplication is possible
        if (cols1 != mat2.length) {
            System.out.println("Multiplication is not possible");
            return null;
        }

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += mat1[i][k] * mat2[k][j];
                }
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

        int[][] result = multiplyMatrices(mat1, mat2);
        printMatrix(result);
    }

}
