public class Max_Min_Elements{

    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50};

        int max = findMax(array);
        int min = findMin(array);

        System.out.println("Maximum element: " + max);
        System.out.println("Minimum element: " + min);
    }

    private static int findMax(int[] array) {
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }

    private static int findMin(int[] array) {
        int min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }
public static int max_min(int arr[]){
    int n=arr.length;
    int max=arr[0];
    int min=arr[0];
for(int i=1;i<n;i++){
max=Math.max(max,arr[i]);
min=Math.min(min,arr[i]);

}
return max-min;
}
}
