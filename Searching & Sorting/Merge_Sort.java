public class Merge_Sort {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        mergeSort(arr, 0, arr.length - 1);
        for (int i : arr)
            System.out.print(i + " ");
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (high + low) / 2;

            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);

            merge(arr, low, mid, high);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

        int i = low, j = mid + 1, k = 0;

        // Merge the two parts into temp[] array in sorted order
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }

        // Insert all the remaining values from i to mid into temp[]
        while (i <= mid)
            temp[k++] = arr[i++];

            // Insert all the remaining values from j to high into temp[]
        while (j <= high)
            temp[k++] = arr[j++];

            // Assign sorted data stored in temp[] to a[] array
        for (i = low; i <= high; i++)
            arr[i] = temp[i - low];
    }
}