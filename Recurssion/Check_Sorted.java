public class Check_Sorted {
    public static boolean checkSorted(int[] arr, int si) {
        if (si == arr.length - 1) {
            return true;
        }
        if (arr[si] > arr[si + 1]) {
            return false;
        }
        boolean smallAns = checkSorted(arr, si + 1);
        return smallAns;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 6, 5 };
        // int l=arr.length;
        System.out.println(checkSorted(arr, 0));
        // System.out.println(isSorted(arr, l-1));
    }
    // public static int isSorted(int[] arr, int si) {
        // if (si == 0 || si == 1) {
            // return 1;
        // }
        // if (arr[si] > arr[si + 1]) {
            // return 0;
        // }
        // int smallAns = isSorted(arr, si - 1);
        // return smallAns;
    // }
}