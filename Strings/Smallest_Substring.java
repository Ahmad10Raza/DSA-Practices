import java.util.Arrays;


// Algorithm : 

// Maintain an array (visited) of maximum possible characters (256 characters) and as soon as we find any in the string, mark that index in the array (this is to count all distinct characters in the string).
// Take two pointers start and end which will mark the start and end of window.
// Take a counter=0 which will be used to count distinct characters in the window.
// Now start reading the characters of the given string and if we come across a character which has not been visited yet increment the counter by 1.
// If the counter is equal to total number of distinct characters, Try to shrink the window.
// For shrinking the window -: 
// If the frequency of character at start pointer is greater than 1 increment the pointer as it is redundant.
// Now compare the length of present window with the minimum window length.

public class Smallest_Substring {
    static final int MAX_CHARS = 256; 
  
    // Function to find smallest window containing 
    // all distinct characters 
    static String findSubString(String str) 
    { 
        int n = str.length(); 
  
        // if string is empty or having one char 
        if (n <= 1) 
            return str; 
  
        // Count all distinct characters. 
        int dist_count = 0; 
  
        boolean[] visited = new boolean[MAX_CHARS]; 
        Arrays.fill(visited, false); 
        for (int i = 0; i < n; i++) { 
            if (visited[str.charAt(i)] == false) { 
                visited[str.charAt(i)] = true; 
                dist_count++; 
            } 
        } 
  
        // Now follow the algorithm discussed in below 
        // post. We basically maintain a window of 
        // characters that contains all characters of given 
        // string. 
        int start = 0, start_index = -1; 
        int min_len = Integer.MAX_VALUE; 
  
        int count = 0; 
        int[] curr_count = new int[MAX_CHARS]; 
        for (int j = 0; j < n; j++) { 
            // Count occurrence of characters of string 
            curr_count[str.charAt(j)]++; 
  
            // If any distinct character matched, 
            // then increment count 
            if (curr_count[str.charAt(j)] == 1) 
                count++; 
  
            // if all the characters are matched 
            if (count == dist_count) { 
                // Try to minimize the window i.e., check if 
                // any character is occurring more no. of 
                // times than its occurrence in pattern, if 
                // yes then remove it from starting and also 
                // remove the useless characters. 
                while (curr_count[str.charAt(start)] > 1) { 
                    if (curr_count[str.charAt(start)] > 1) 
                        curr_count[str.charAt(start)]--; 
                    start++; 
                } 
  
                // Update window size 
                int len_window = j - start + 1; 
                if (min_len > len_window) { 
                    min_len = len_window; 
                    start_index = start; 
                } 
            } 
        } 
        // Return substring starting from start_index 
        // and length min_len 
        return str.substring(start_index, start_index + min_len); 
    } 
  
    // Driver code 
    public static void main(String args[]) 
    { 
        String str = "aabcbcdbca"; 
        System.out.println( "Smallest window containing all distinct"+ " characters is: " + findSubString(str)); 
    } 
}