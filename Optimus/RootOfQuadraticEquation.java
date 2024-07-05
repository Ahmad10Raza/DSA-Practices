
// Write a Program to Find the Roots of a Quadratic Equation

// A quadratic equation is a polynomial equation of the form ax^2 + bx + c = 0, where a, b, and c are real numbers and a is not equal to 0. The roots of a quadratic equation can be found using the formula:

// root1 = (-b + sqrt(b^2 - 4ac)) / 2a
// root2 = (-b - sqrt(b^2 - 4ac)) / 2a

// where sqrt() is the square root function.

// Example
// Input: a = 1, b = -3, c = 2
// Output: root1 = 2, root2 = 1

// Approach: We can find the roots of a quadratic equation by following the below steps:
// 1. Calculate the discriminant (D) using the formula D = b^2 - 4ac.
// 2. If D is greater than 0, the roots are real and different.
// 3. If D is equal to 0, the roots are real and equal.
// 4. If D is less than 0, the roots are complex and different.
// 5. Calculate the roots using the formula mentioned above.

public class RootOfQuadraticEquation {

    public static void FindRootsOfQuadraticEquation(int a, int b, int c) {
        double D = b * b - 4 * a * c;
        if (D > 0) {
            double root1 = (-b + Math.sqrt(D)) / (2 * a);
            double root2 = (-b - Math.sqrt(D)) / (2 * a);
            System.out.println("Root1: " + root1 + ", Root2: " + root2);
        } else if (D == 0) {
            double root = -b / (2 * a);
            System.out.println("Root: " + root);
        } else {
            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(-D) / (2 * a);
            System.out.println("Root1: " + realPart + " + " + imaginaryPart + "i, Root2: " + realPart + " - "
                    + imaginaryPart + "i");
        }
    }

    public static void main(String[] args) {
        FindRootsOfQuadraticEquation(1, -3, 2);
    }
}
