public class Diagonal_Sum {
     public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int ans = 0;
 
        for (int i = 0; i < n; i++) {
            // Add elements from primary diagonal.
            ans += mat[i][i];
            // Add elements from secondary diagonal.
            ans += mat[n - 1 - i][i];
        }
 
        // If n is odd, subtract the middle element as it's added twice.
        if (n % 2 != 0) {
            ans -= mat[n / 2][n / 2];
        }
 
        return ans;
    }
    public static void main(String[] args) {
        Diagonal_Sum ds = new Diagonal_Sum();
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.print(ds.diagonalSum(mat));
    }
}
