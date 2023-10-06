public class Word_Search_In_2D_Grid {
    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        
        // Iterate through each cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If the starting character matches, start the search
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private static boolean dfs(char[][] board, int row, int col, String word, int index) {
        // If the entire word is found, return true
        if (index == word.length()) {
            return true;
        }
        
        int rows = board.length;
        int cols = board[0].length;
        
        // Check if the current cell is out of bounds or doesn't match the current character in the word
        if (row < 0 || col < 0 || row >= rows || col >= cols || board[row][col] != word.charAt(index)) {
            return false;
        }
        
        // Mark the current cell as visited by changing its character temporarily
        char temp = board[row][col];
        board[row][col] = '#';
        
        // Recursively search in all four directions (up, down, left, right)
        boolean found = dfs(board, row - 1, col, word, index + 1) ||
                        dfs(board, row + 1, col, word, index + 1) ||
                        dfs(board, row, col - 1, word, index + 1) ||
                        dfs(board, row, col + 1, word, index + 1);
        
        // Restore the original character
        board[row][col] = temp;
        
        return found;
    }
    
    public static void main(String[] args) {
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word1 = "ABCCED";
        String word2 = "SEE";
        String word3 = "ABCB";
        
        System.out.println("Search for " + word1 + ": " + exist(board, word1)); // true
        System.out.println("Search for " + word2 + ": " + exist(board, word2)); // true
        System.out.println("Search for " + word3 + ": " + exist(board, word3)); // false
    }
}
