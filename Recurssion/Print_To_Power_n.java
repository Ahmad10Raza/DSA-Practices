public class Print_To_Power_n {
    public static void main(String[] args) {
        // printToPowerN(2, 5);
        System.out.println(Optimized_Pow(2,5));

    }

    public static void printToPowerN(int base, int n) {
        // Time Complexity: O(n)
        if (n == 0) {
            System.out.println(1);
            return;
        }
        printToPowerN(base, n - 1);
        System.out.println((int) Math.pow(base, n));
    }
    public static int pow(int x,int n){
        //Time Complexity: 2^n
        if(n==0){
            return 1;
        }
        return x*pow(x,n-1);
    }
    public static int Optimized_Pow(int a,int n){
        //Time Complexity: O(logn)
        //base case
        if(n==0){
            return 1;
        }
        //if n is even then return a^(n/2)*a^(n/2)
        int halfpow=Optimized_Pow(a,n/2);
        int half=halfpow*halfpow;
        
        //if n is odd then return a^(n/2)*a^(n/2)*a
        if(n%2!=0){
            return a*half;
        }
        
        return half;
    }
}