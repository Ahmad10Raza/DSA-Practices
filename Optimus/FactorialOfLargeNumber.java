
// Given an integer, the task is to find factorial of the large number.

// Examples:
// Input : num = 50
// Output : 30414093201713378043612608166064768844377641568960512000000000000

// Approach: To find the factorial of a large number, we can use BigInteger class which is available in java. BigInteger is an immutable class for arbitrary-precision integers. It provides all the methods same as the Integer class. We can use the multiply() method of BigInteger class to find the factorial of a large number.

public class FactorialOfLargeNumber {

    public static String factorial(int n) {
        java.math.BigInteger fact = new java.math.BigInteger("1");
        for (int i = 2; i <= n; i++) {
            // multiply() method multiplies the value of this BigInteger with the value of
            // BigInteger passed as argument.
            fact = fact.multiply(java.math.BigInteger.valueOf(i));
        }
        return fact.toString();
    }

    public static void main(String[] args) {
        int n = 50;
        System.out.println(factorial(n));
    }
}
