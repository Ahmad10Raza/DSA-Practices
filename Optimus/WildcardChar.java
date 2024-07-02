
// Write code to check if two strings match where one string contains wildcard characters
// '?' which can be replaced by any character.
// 'a?c' can be replaced by 'abc', 'adc', 'axc', 'ayc', etc.
// '*' which can be replaced by any number of characters.
// 'a*c' Matches with 0 or more instances of any character or set of characters.

// Input: a?c, abc
// Output: Yes
// Explanation: '?' can be replaced by 'b'.

// Input: a*c, abc
// Output: Yes
// Explanation: '*' can be replaced by ''.

// Approach: An efficient approach is to use the two-pointer technique. We will use two pointers,
// one at the start and one at the end of the string. We will compare the characters at both pointers.
// If they are equal, we will move the pointers towards each other. If they are not equal, we will return false.
// If the pointers meet, we will return true.

// Time Complexity: O(n)
// Space Complexity: O(1)




public class WildcardChar {
    
    public static boolean isMatch(String str1, String str2) {
        int i = 0;
        int j = 0;
        int iIndex = -1;
        int jIndex = -1;
        while (i < str1.length()) {
            if (j < str2.length() && (str1.charAt(i) == str2.charAt(j) || str1.charAt(i) == '?')) {
                i++;
                j++;
            } else if (j < str2.length() && str1.charAt(i) == '*') {
                iIndex = i;
                jIndex = j;
                i++;
            } else if (iIndex != -1) {
                i = iIndex + 1;
                j = jIndex + 1;
                jIndex++;
            } else {
                return false;
            }
        }
        while (j < str2.length() && str2.charAt(j) == '*') {
            j++;
        }
        return j == str2.length();
    }

   public static boolean match(String first, String second)  
{ 
  
    // If we reach at the end of both strings,  
    // we are done 
    if (first.length() == 0 && second.length() == 0) 
        return true; 
    
  // Make sure to eliminate consecutive '*' 
    if (first.length() > 1 && first.charAt(0) == '*') { 
      int i=0; 
        while (i+1<first.length() && first.charAt(i+1) == '*') 
          i++; 
      first=first.substring(i); 
    } 
  
    // Make sure that the characters after '*'  
    // are present in second string.  
    // This function assumes that the first 
    // string will not contain two consecutive '*' 
    if (first.length() > 1 && first.charAt(0) == '*' &&  
                              second.length() == 0) 
        return false; 
  
    // If the first string contains '?',  
    // or current characters of both strings match 
    if ((first.length() > 1 && first.charAt(0) == '?') ||  
        (first.length() != 0 && second.length() != 0 &&  
         first.charAt(0) == second.charAt(0))) 
        return match(first.substring(1),  
                     second.substring(1)); 
  
    // If there is *, then there are two possibilities 
    // a) We consider current character of second string 
    // b) We ignore current character of second string. 
    if (first.length() > 0 && first.charAt(0) == '*') 
        return match(first.substring(1), second) ||  
               match(first, second.substring(1)); 
    return false; 
} 

    public static void main(String[] args) {
        String str1 = "a*c";
        String str2 = "abc";
        System.out.println(isMatch(str1, str2) ? "Yes" : "No");
    }
}
