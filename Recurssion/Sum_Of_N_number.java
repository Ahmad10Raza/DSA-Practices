public class Sum_Of_N_number {
    public static int sum(int n){
        if(n==1){
            return 1;
        }
        int s=n+sum(n-1);
        return s;
    }
    public static void main(String[] args) {
        int n=5;
        System.out.println(sum(n));
    }
}