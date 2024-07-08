// Airport security officials have confiscated several items of the passenger at the security checkpoint. All
// the items have been dumped into a huge box(array). Each item possessed a certain amount of risk(0,1,2).
// Here is the risk severity of the item representing an array[] of N number of integer values. The risk here is to
// sort the item based on their level of risk values range from 0 to 2.
// Example 1:
// Input:
// 7 ------------- Value of N
// [1,0,2,0,1,0,2] -> Element of arr[0] to arr[N-1], while input each element is separated by new line
// Output:
// 0 0 0 1 1 2 2 -> Element after sorting based on the risk severity.
// Example 2:
// Input:
// 10 ------------ Value of N
// [2,1,0,2,1,0,0,1,2,0] -> Element of arr[0] to arr[N-1], while input each element is separated by new line
// Output:
// 0 0 0 0 0 1 1 1 2 2 2 -> Element after sorting based on the risk severity.
// Constraints
// 0<N<=100
// 0<=arr[i]<=2

// Approach: To solve this problem, we can use the counting sort algorithm. Counting sort is a sorting algorithm that sorts the elements of an array by counting the number of occurrences of each unique element in the array. The algorithm then uses this information to create a new sorted array. The counting sort algorithm works by counting the number of occurrences of each element in the input array and then using this information to place each element in the correct position in the output array. The algorithm has a time complexity of O(n + k), where n is the number of elements in the input array and k is the range of the input elements. In this case, the range of the input elements is 0 to 2, so the time complexity of the counting sort algorithm will be O(n + 3) = O(n). The algorithm works as follows:
// 1. Create an array count[] of size 3 to store the count of occurrences of each element in the input array.
// 2. Iterate over the input array and count the number of occurrences of each element.
// 3. Create an output array result[] of the same size as the input array to store the sorted elements.
// 4. Iterate over the count[] array and fill the output array with the correct number of occurrences of each element.
// 5. Return the output array as the sorted array.

// Time Complexity: O(n)
// Space Complexity: O(n)

public class Risk_Severity {

    public static int[] sortRiskSeverity(int[] arr) {
        int[] count = new int[3];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        int[] result = new int[arr.length];
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                result[index++] = i;
            }
        }

        return result;
    }

    // Approach 2: Using Dutch National Flag Algorithm
    // Time Complexity: O(n)
    // Space Complexity: O(1)

    // The Dutch National Flag algorithm is used to sort an array of 0s, 1s, and 2s
    // in linear time and constant space. The algorithm works by maintaining three
    // pointers: low, mid, and high. The low pointer points to the start of the
    // array, the mid pointer points to the current element being processed, and the
    // high pointer points to the end of the array. The algorithm works as follows:
    // 1. Initialize the low pointer to 0, the mid pointer to 0, and the high
    // pointer to n-1, where n is the length of the array.
    // 2. While the mid pointer is less than or equal to the high pointer, do the
    // following:
    // a. If the element at the mid pointer is 0, swap it with the element at the
    // low pointer, increment the low and mid pointers.
    // b. If the element at the mid pointer is 1, increment the mid pointer.
    // c. If the element at the mid pointer is 2, swap it with the element at the
    // high pointer, decrement the high pointer.
    // 3. Repeat step 2 until the mid pointer is greater than the high pointer.
    // 4. The array will be sorted in place with all 0s before all 1s and all 1s
    // before all 2s.

    public static int[] sortRiskSeverityDutch(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    swap(arr, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(arr, mid, high);
                    high--;
                    break;
            }
        }

        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 0, 2, 0, 1, 0, 2 };
        int[] result = sortRiskSeverity(arr);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}