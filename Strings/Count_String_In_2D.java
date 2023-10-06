// public class Count_String_In_2D {
//     // Utility function to search
// // complete string from any
// // given index of 2d char array
// static int internalSearch(String needle, int row,
// int col, String hay[],
// int row_max, int col_max, 
// int xx)
// {
// int found = 0;

// if (row >= 0 && row <= row_max && col >= 0 &&
// col <= col_max && xx < needle.length() &&
// needle.charAt(xx) == hay[row].charAt(col))
// {
// char match = needle.charAt(xx);
// xx += 1;

// hay[row] = hay[row].substring(0, col) + "0" +
// hay[row].substring(col + 1);

// if (xx == needle.length())
// {
// found = 1;
// }
// else
// {

// // Through Backtrack searching
// // in every directions
// found += internalSearch(needle, row,
//           col + 1, hay,
//           row_max, col_max,xx);
// found += internalSearch(needle, row, col - 1,
//           hay, row_max, col_max,xx);
// found += internalSearch(needle, row + 1, col,
//           hay, row_max, col_max,xx);
// found += internalSearch(needle, row - 1, col,
//           hay, row_max, col_max,xx);
// }

// hay[row] = hay[row].substring(0, col) + 
// match + hay[row].substring(col + 1);
// }
// return found;
// }

// // Function to search the string in 2d array
// static int searchString(String needle, int row, int col,
// String str[], int row_count,
//             int col_count)
// {
// int found = 0;
// int r, c;

// for(r = 0; r < row_count; ++r)
// {
// for(c = 0; c < col_count; ++c)
// {
// found += internalSearch(needle, r, c, str,
//           row_count - 1,
//           col_count - 1, 0);
// }
// }
// return found;
// }

// // Driver code
// public static void main(String args[])
// {
// String needle = "MAGIC";
// String input[] = { "BBABBM", "CBMBBA",
// "IBABBG", "GOZBBI",
// "ABBBBC", "MCIGAM" };
// String str[] = new String[input.length];
// int i;
// for(i = 0; i < input.length; ++i)
// {
// str[i] = input[i];
// }

// System.out.println("count: " + 
// searchString(needle, 0, 0, str,
//  str.length,
//  str[0].length()));
// }
// }







public class Count_String_In_2D {
    // Function to find the count of a given string in a 2D character array
    public static int countStringIn2DArray(char[][] matrix, String target) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        int targetLength = target.length();
        int count = 0;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (matrix[i][j] == target.charAt(0)) {
                    count += countString(matrix, i, j, target, 0);
                }
            }
        }

        return count;
    }

    // Recursive function to count occurrences of target string
    private static int countString(char[][] matrix, int row, int col, String target, int index) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        if (index == target.length() - 1) {
            return 1;
        }

        // Mark the current cell as visited to avoid revisiting
        char originalChar = matrix[row][col];
        matrix[row][col] = '#';

        // Explore all possible directions (up, down, left, right)
        int count = 0;
        if (row > 0 && matrix[row - 1][col] == target.charAt(index + 1)) {
            count += countString(matrix, row - 1, col, target, index + 1);
        }
        if (row < rowCount - 1 && matrix[row + 1][col] == target.charAt(index + 1)) {
            count += countString(matrix, row + 1, col, target, index + 1);
        }
        if (col > 0 && matrix[row][col - 1] == target.charAt(index + 1)) {
            count += countString(matrix, row, col - 1, target, index + 1);
        }
        if (col < colCount - 1 && matrix[row][col + 1] == target.charAt(index + 1)) {
            count += countString(matrix, row, col + 1, target, index + 1);
        }

        // Restore the original character
        matrix[row][col] = originalChar;

        return count;
    }

    public static void main(String[] args) {
        char[][] matrix = {
            {'a', 'b', 'c', 'd'},
            {'e', 'f', 'g', 'h'},
            {'i', 'j', 'k', 'l'},
            {'m', 'n', 'o', 'p'}
        };
        String target = "ab";
        int result = countStringIn2DArray(matrix, target);
        System.out.println("Count of '" + target + "' in the 2D array: " + result);
    }
}
