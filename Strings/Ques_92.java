// Follow the steps below to solve the problem:

    // Initialize low and high as 1 and string length respectively denoting the minimum and maximum possible answer.
    // For any value mid check if there is any substring of length mid in the string that contains all the characters of the pattern.
    // If any such substring of length exists then store the starting index of that substring and update high to mid-1 and, check for substrings having lengths smaller than mid.
    // Otherwise, if any such substring does not exist then update low to mid+1 and, check for substrings having lengths larger than mid.


public class Ques_92 {
    // Function to check if any substring of length mid contains
    // all characters of the pattern
    static boolean isValid(String str, String pattern, int mid, int[] start) {
        // Count the frequency of each character in the pattern
        int[] count = new int[256];
 
        // Stores number of distinct characters in pattern
        int distinct = 0;
 
        boolean found = false;
 
        // Count the frequency of each character in the pattern
        for (char c : pattern.toCharArray()) {
            count++;
            if (count == 1)
                distinct++;
        }
 
        // Stores the number of characters in a substring of size
        // mid in str whose frequency is the same as the frequency in
        // pattern
        int currCount = 0;
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]--;
            if (count[str.charAt(i)] == 0) {
                currCount++;
            }
            if (i >= mid) {
                count[str.charAt(i - mid)]++;
                if (count[str.charAt(i - mid)] == 1) {
                    currCount--;
                }
            }
            if (i >= mid - 1) {
 
                // Substring of length mid found which contains
                // all the characters of the pattern
                if (currCount == distinct) {
 
                    found = true;
 
                    // Stores the starting index of that substring
                    start[0] = (i - mid) + 1;
                    break;
                }
            }
        }
 
        return found;
    }
 
    // Function to find the smallest substring containing all
    // characters of the pattern
    static String findSmallestSubstring(String str, String pattern) {
        int lenStr = str.length();
        int lenPattern = pattern.length();
        String smallestSubstring = "";
 
        int minLength = Integer.MAX_VALUE;
 
        // Lower bound and Upper Bound for Binary Search
        int lowBound = 1, highBound = lenStr;
 
        // Stores starting index of min length substring
        int[] idx = new int[1];
 
        // Applying Binary Search on answer
        while (lowBound <= highBound) {
            int mid = (lowBound + highBound) / 2;
            int[] start = new int[1];
 
            // If a substring of length mid is found which
            // contains all the characters of the pattern then
            // update minLength and highBound, otherwise update
            // lowBound
            if (isValid(str, pattern, mid, start)) {
                if (mid < minLength) {
                    minLength = mid;
                    idx[0] = start[0];
                }
                highBound = mid - 1;
            } else {
                lowBound = mid + 1;
            }
        }
 
        return smallestSubstring = str.substring(idx[0], idx[0] + minLength);
    }
}
