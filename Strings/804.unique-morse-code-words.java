/*
 * @lc app=leetcode id=804 lang=java
 *
 * [804] Unique Morse Code Words
 */

//  Unique Morse Code Words
//  Category	Difficulty	Likes	Dislikes
//  algorithms	Easy (82.82%)	2503	1532
//  Tags
//  Companies
//  International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows:
 
//  'a' maps to ".-",
//  'b' maps to "-...",
//  'c' maps to "-.-.", and so on.
//  For convenience, the full table for the 26 letters of the English alphabet is given below:
 
//  [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
//  Given an array of strings words where each word can be written as a concatenation of the Morse code of each letter.
 
//  For example, "cab" can be written as "-.-..--...", which is the concatenation of "-.-.", ".-", and "-...". We will call such a concatenation the transformation of a word.
//  Return the number of different transformations among all words we have.
 
  
 
//  Example 1:
 
//  Input: words = ["gin","zen","gig","msg"]
//  Output: 2
//  Explanation: The transformation of each word is:
//  "gin" -> "--...-."
//  "zen" -> "--...-."
//  "gig" -> "--...--."
//  "msg" -> "--...--."
//  There are 2 different transformations: "--...-." and "--...--.".
//  Example 2:
 
//  Input: words = ["a"]
//  Output: 1
  
 
//  Constraints:
 
//  1 <= words.length <= 100
//  1 <= words[i].length <= 12
//  words[i] consists of lowercase English letters.
//  Submissions | Solution

// Approach: Morse code is a simple encoding of the English alphabet. We can use a set to store the unique transformations of the words. We can then iterate over the words and add the transformation to the set. Finally, we can return the size of the set.




// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution804 {
    public int uniqueMorseRepresentations(String[] words) {
        
        // Morse code for each character
        String[] morseCodes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---",
                               "-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-",
                               "..-","...-",".--","-..-","-.--","--.."};
        
        // To store the unique transformations
        Set<String> transformations = new HashSet<>();
        
        // Traverse the words
        for (String word : words) {
            
            // To store the transformation of the word
            StringBuilder transformation = new StringBuilder();
            
            // Traverse the characters of the word
            for (char c : word.toCharArray()) {
                
                // Append the Morse code of the character
                transformation.append(morseCodes[c - 'a']);
            }
            
            // Add the transformation to the set
            transformations.add(transformation.toString());
        }
        
        // Return the number of unique transformations
        return transformations.size();

    }
}
// @lc code=end

