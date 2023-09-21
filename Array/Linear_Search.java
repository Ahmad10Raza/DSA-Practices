public class Linear_Search {

    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int key = 30;

        int index = linearSearch(arr, key);

        if (index != -1) {
            System.out.println("The element " + key + " is found at index " + index);
        } else {
            System.out.println("The element " + key + " is not found in the array");
        }
    }
}
