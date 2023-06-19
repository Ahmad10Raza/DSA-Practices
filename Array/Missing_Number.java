public class Missing_Number {
    public static int findMissingNumber(int[] a) {
        int n = a.length; // size of the array
        // Find Sn:
        int SN = (n * (n + 1)) / 2;
        // Calculate S:
        int S = 0;
        for (int i = 0; i < n; i++) {
            S += a[i];
        }
        // S-Sn = X-Y:
        int val1 = S - SN;
        return val1;
    }
    public static void main(String[] args) {
        int[] a = { 3, 1, 2, 5, 4, 6, 7 };
        int ans = findMissingNumber(a);
        System.out.println("The missing number is: " + ans);
    }
}
