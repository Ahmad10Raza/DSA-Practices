public class Longest_Recurring_Subsequence {
    public static int LongestRecSubsequence(String s,int i,int j){
        if(i==0 || j==0 ){
            return 0;
        }

        //  check if the last character is same and not at the same index
        if(s.charAt(i-1)==s.charAt(j-1) && i!=j){
            
            return 1+LongestRecSubsequence(s,i-1,j-1); // 1+ for the last character and then check for the remaining string
        }
        else{
            // if the last character is not same then check for the remaining string
            return Math.max(LongestRecSubsequence(s,i-1,j),LongestRecSubsequence(s,i,j-1));
        }

    }
    public static void main(String[] args) {
        String s="AABEBCDD";
        System.out.println(LongestRecSubsequence(s,s.length(),s.length()));
    }
}