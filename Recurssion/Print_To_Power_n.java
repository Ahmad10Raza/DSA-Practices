public class Print_To_Power_n {
    public static void main(String[] args) {
        // printToPowerN(2, 5);
        System.out.println(pow(2,5));

    }

    public static void printToPowerN(int base, int n) {
        if (n == 0) {
            System.out.println(1);
            return;
        }
        printToPowerN(base, n - 1);
        System.out.println((int) Math.pow(base, n));
    }
    public static int pow(int x,int n){
        if(n==0){
            return 1;
        }
        return x*pow(x,n-1);
    }
}