 public class Sort012 {

    public static void sort(int[] array) {
        int low = 0;
        int mid = 0;
        int high = array.length - 1;

        while (mid <= high) {
            switch (array[mid]) {
                case 0:
                    swap(array, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(array, mid, high);
                    high--;
                    break;
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {0, 2, 1, 2, 0, 1, 0};
        sort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
 
