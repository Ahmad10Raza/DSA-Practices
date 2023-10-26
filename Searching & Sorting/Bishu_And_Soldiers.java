import java.util.Arrays;
import java.util.Scanner;

public class Bishu_And_Soldiers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] power = new int[n];

        for (int i = 0; i < n; i++) {
            power[i] = scanner.nextInt();
        }

        Arrays.sort(power); // Sort the array to perform binary search

        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int x = scanner.nextInt();
            int totalSoldiers = 0;
            int totalPower = 0;

            // Use binary search to find the number of soldiers whose power is less than or equal to x
            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (power[mid] <= x) {
                    totalSoldiers = mid + 1;
                    totalPower = power[mid];
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            System.out.println(totalSoldiers + " " + totalPower);
        }

        scanner.close();
    }
}
