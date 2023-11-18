import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the numerator: ");
            int numerator = scanner.nextInt();

            System.out.print("Enter the denominator: ");
            int denominator = scanner.nextInt();

            int result = divide(numerator, denominator);
            System.out.println("Result of division: " + result);
        } catch (InputMismatchException e) {
            // Handle the case where the user enters a non-integer value
            System.err.println("Error: Please enter a valid integer.");
        } catch (ArithmeticException e) {
            // Handle division by zero
            System.err.println("Error: Division by zero is not allowed.");
        } finally {
            // Close the scanner to release resources
            scanner.close();
        }
    }

    private static int divide(int numerator, int denominator) {
        if (denominator == 0) {
            // Throw an ArithmeticException if the denominator is zero
            throw new ArithmeticException("Division by zero");
        }
        return numerator / denominator;
    }
}
