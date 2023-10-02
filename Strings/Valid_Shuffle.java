public class Valid_Shuffle {
    public static boolean isSuffle(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        int i = 0, j = 0, k = 0;
        while (k < s3.length()) {
            if (i < s1.length() && s1.charAt(i) == s3.charAt(k))
                i++;
            else if (j < s2.length() && s2.charAt(j) == s3.charAt(k))
                j++;
            else
                return false;
            k++;
        }
        return true;
    }
    public static void main(String[] args) {
        String s1 = "XY";
        String s2 = "12";
        String s3 = "X1Y2";
        String s4 = "Y12XZ";
        System.out.println(isSuffle(s1, s2, s3));
        System.out.println(isSuffle(s1, s2, s4));
    }
}