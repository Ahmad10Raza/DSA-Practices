import java.util.Arrays;

public class Rotate_Image {
    public void Roate(int[][] matrix){
        int n = matrix.length;
        // Transpose the matrix
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                // Swap the elements
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        // Reverse each row
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n / 2; j++){
                // Swap the elements
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n-1-j] = temp;
            }
        }
    }
    public static void main(String[] args) {
        Rotate_Image ri = new Rotate_Image();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        ri.Roate(matrix);
        for(int i = 0; i < matrix.length; i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
