public class Print_SubString {
    public static String subtring(String str,int si,int ei){
        String ans = "";
        for(int i=si; i<=ei; i++){
            ans += str.charAt(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        String str = "Hello World";
        System.out.println(str.substring(2, 5));
        System.out.println(subtring(str, 2, 5));
    }
}