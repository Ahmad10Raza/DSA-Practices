public class Number_To_English {
    static String [] arr = {"zero","one","two","three","four","five","six","seven","eight","nine"};

    public static void printNumber(int n){
        if(n == 0){
            return;
        }
        printNumber(n/10);
        System.out.print(arr[n%10] + " ");
    }
    public static void main(String[] args) {
        printNumber(2048);
    }
}