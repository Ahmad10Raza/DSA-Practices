public class Print_N_Number {
    public static void print_nums(int n){
        if(n==1){
            System.out.println(1);
            return;
        }
        System.out.print( n+ "," );
        print_nums(n-1);
    }

    public static void main(String[] args) {
     int n=10;
        print_nums(n);
    }
}