public class SubstringsWithSameFirstLastChar {
    public static int countSubstring(String str, int start, int end , int n){
        if(n==1){
            return 1;
        }
        if(n<=0){
            return 0;
        }

        int res=countSubstring(str,start+1,end,n-1)+countSubstring(str,start,end-1,n-1)-countSubstring(str,start+1,end-1,n-2);

        if(str.charAt(start)==str.charAt(end)){
            res+=1;
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "abcab";
        int result = countSubstring(s, 0, s.length() - 1, s.length());
        System.out.println("Number of substrings with the same first and last characters: " + result);
    }
}
