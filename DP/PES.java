import java.util.Scanner;

public class PES {
    private static boolean hasSubsetSum(int[] values, int targetSum, int n) {
        if (targetSum == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }

        if (values[n - 1] > targetSum) {
            return hasSubsetSum(values, targetSum, n - 1);
        }

        return hasSubsetSum(values, targetSum - values[n - 1], n - 1)
                || hasSubsetSum(values, targetSum, n - 1);
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter Array Element one by one :");
        int n = keyboard.nextInt();

        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = keyboard.nextInt();
        }

        keyboard.close();

        int sum = 0;
        for(int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        System.out.println("Has Equal Subset sum partition: " + hasSubsetSum(values, sum/2, n));
    }
}