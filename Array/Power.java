public class Power {
    public double myPow(int x, int n) {
        if (n == 0) {
            return 1;
        }
        double temp = myPow(x, n / 2);
        temp *= temp;
        if (n % 2 == 0) {
            return temp;
        } else {
            return temp * x;
        }
    }
    public static void main(String[] args) {
        Power p = new Power();
        System.out.println(p.myPow(2, 10));
    }
}
