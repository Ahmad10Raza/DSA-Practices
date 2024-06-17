/*
 * @lc app=leetcode id=929 lang=java
 *
 * [929] Unique Email Addresses
 */

//  Unique Email Addresses
//  Category	Difficulty	Likes	Dislikes
//  algorithms	Easy (67.13%)	2680	338
//  Tags
//  Companies
//  Every valid email consists of a local name and a domain name, separated by the '@' sign. Besides lowercase letters, the email may contain one or more '.' or '+'.
 
//  For example, in "alice@leetcode.com", "alice" is the local name, and "leetcode.com" is the domain name.
//  If you add periods '.' between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name. Note that this rule does not apply to domain names.
 
//  For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
//  If you add a plus '+' in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered. Note that this rule does not apply to domain names.
 
//  For example, "m.y+name@email.com" will be forwarded to "my@email.com".
//  It is possible to use both of these rules at the same time.
 
//  Given an array of strings emails where we send one email to each emails[i], return the number of different addresses that actually receive mails.
 
  
 
//  Example 1:
 
//  Input: emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
//  Output: 2
//  Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails.
//  Example 2:
 
//  Input: emails = ["a@leetcode.com","b@leetcode.com","c@leetcode.com"]
//  Output: 3
  
 
//  Constraints:
 
//  1 <= emails.length <= 100
//  1 <= emails[i].length <= 100
//  emails[i] consist of lowercase English letters, '+', '.' and '@'.
//  Each emails[i] contains exactly one '@' character.
//  All local and domain names are non-empty.
//  Local names do not start with a '+' character.
//  Domain names end with the ".com" suffix.
//  Submissions | Solution


// Approach 1: Canonical Form
// Time Complexity: O(C), where C is the total content of emails
// Space Complexity: O(C)

// The implementation in Python uses a set to store unique email addresses that are normalized according to the problem's rules.

// Set Data Structure: A set is chosen because it only stores unique values, which automatically helps us to keep track of unique emails without any duplicates.

// String Manipulation: The algorithm uses basic string operations such as split, replace, and slicing to manipulate the local names as per the rules provided.

// Processing Emails:

// Splitting: Each email is split into a local and domain part using email.split('@'). This separates the local name from the domain name.

// Removing Periods: All periods are removed from the local part with local.replace('.', ''), since periods do not change the destination of the email.

// Handling Plus Sign: If a plus sign is present in the local part, it finds the index of the first plus sign using local.find('+'). The local part is then truncated up to that index (not including the plus and everything after it) with local[:i], where i is the index of the plus sign.

// Reassembly: The cleaned local part is concatenated with the domain part using '@' to form the normalized email.

// Adding to Set: The resulting email address is added to the set. Python takes care of checking for uniqueness.

// Return Unique Count: The length of the set, len(s), reflects the number of unique normalized emails, which is the desired output.

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution929 {
    public int numUniqueEmails(String[] emails) {
         // Create a hash set to store unique emails
         Set<String> uniqueEmails = new HashSet<>();
      
         // Iterate over each email in the provided array
         for (String email : emails) {
             // Split the email into local and domain parts
             String[] parts = email.split("@");
             String localPart = parts[0];
             String domainPart = parts[1];
           
             // Remove all periods from the local part
             localPart = localPart.replace(".", "");
           
             // Check for a '+' character and cut off any substring after it in the local part
             int plusIndex = localPart.indexOf('+');
             if (plusIndex != -1) {
                 localPart = localPart.substring(0, plusIndex);
             }
           
             // Combine the processed local part with the domain part
             String cleanEmail = localPart + "@" + domainPart;
           
             // Add the clean email to the set (duplicates are ignored)
             uniqueEmails.add(cleanEmail);
         }
       
         // Return the number of unique emails found, which is the size of the set
         return uniqueEmails.size();
    }
}
// @lc code=end

