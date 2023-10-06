// Algo
// Initial Values : i= 0, j= n-1;

// CountPS(i,j)
// // Every single character of a string is a palindrome 
// // subsequence 
// if i == j
//    return 1 // palindrome of length 1

// // If first and last characters are same, then we 
// // consider it as palindrome subsequence and check
// // for the rest subsequence (i+1, j), (i, j-1)
// Else if (str[i] == str[j])
//    return   countPS(i+1, j) + countPS(i, j-1) + 1;

// else
//    // check for rest sub-sequence and  remove common
//    // palindromic subsequences as they are counted
//    // twice when we do countPS(i+1, j) + countPS(i,j-1)
//    return countPS(i+1, j) + countPS(i, j-1) - countPS(i+1, j-1)



public class Count_All_Palindrome {
    public static int countPS(String str, int i,int j){

        //base case
        if(i==j){
            return 1;
        }

            if(i>j){
                return 0;
            }

            // check first and last character are same then count will be 1+ countPS(i+1,j)+countPS(i,j-1) that one palindrome and rest of the string
            if(str.charAt(i)==str.charAt(j)){
                return countPS(str,i+1,j)+countPS(str,i,j-1)+1;
            }
            else{
                return countPS(str,i+1,j)+countPS(str,i,j-1)-countPS(str,i+1,j-1);
                // In above countPS(str,i+1,j)+countPS(str,i,j-1) we are counting the common palindromes twice 
                //so we subtract countPS(str,i+1,j-1)
            }
    }

    public static void main(String[] args) {
        String str="abcb";
        System.out.println(countPS(str,0,str.length()-1));
    }
}