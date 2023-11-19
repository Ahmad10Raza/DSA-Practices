import java.util.Arrays;
import java.util.List;

public class LambdaExpressionExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Example 1: Print all numbers in the list
        numbers.forEach(number -> System.out.print(number + " "));
        System.out.println();

        // Example 2: Print squares of all numbers in the list
        numbers.stream()
               .map(number -> number * number)
               .forEach(square -> System.out.print(square + " "));
        System.out.println();

        // Example 3: Print even numbers in the list
        numbers.stream()
               .filter(number -> number % 2 == 0)
               .forEach(evenNumber -> System.out.print(evenNumber + " "));
        System.out.println();

        // Example 4: Calculate the sum of all numbers in the list
        int sum = numbers.stream().reduce(0, (x, y) -> x + y);
        System.out.println("Sum: " + sum);
    }
}
