public class Print_Increasing_Order {
    public static void print_nums(int n){
        if(n==1){
            System.out.print(1);
            return;
        }
        print_nums(n-1);
        System.out.print( ","  + n);
    }

    public static void main(String[] args) {
     int n=10;
        print_nums(n);
    }
}