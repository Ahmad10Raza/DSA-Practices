public class Binary_String_Problem {
    public static void PrintBinString(int n,int lastplace,String ans){
        //base case
        if(n==lastplace){
            System.out.println(ans);
            return;
        }
        // choice 1 zero always allowed to sit
        PrintBinString(n,lastplace+1,ans+"0");
        // choice 2 but one can sit only if previous is zero
        if(ans.charAt(ans.length()-1)=='0'){
            PrintBinString(n,lastplace+1,ans+"1");
        }
    }
    public static void main(String[] args) {
        int n=3;
        PrintBinString(n,0,"");
    }
}