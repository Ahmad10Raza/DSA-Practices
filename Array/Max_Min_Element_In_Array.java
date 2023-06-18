public class Max_Min_Element_In_Array {
    public static int Max_Min(int arr[]){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
            if(arr[i]<min){
                min=arr[i];
            }
        }
        System.out.println("Max: "+max);
        System.out.println("Min: "+min);
        return 0;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        Max_Min(arr);
    }
}






// /** 
// // Java program of above implementation
// public class GFG {
// /* Class Pair is used to return two values from getMinMax() */
// static class Pair {
// }
// int min;
// int max;
// static Pair getMinMax(int arr[],int n) {
// Pair minmax = new Pair();
// int i;
// /* If array has even number of elements then
// initialize the first two elements as minimum and
// maximum */
// if (n % 2 == 0) {
// if (arr[0] > arr[1]) {
// minmax.max = arr[0];
// minmax.min = arr[1];
// } else {
// minmax.min = arr[0];
// minmax.max = arr[1];
// }
// i = 2;
// /* set the starting index for loop */
// } /* If array has odd number of elements then
// initialize the first element as minimum and
// maximum */ else {
// minmax.min = arr[0];
// minmax.max = arr[0];
// i = 1;
// /* set the starting index for loop */
// }
// /* In the while loop,pick elements in pair and
// compare the pair with max and min so far */
// while (i < n - 1) { // for(; i<n-1;i+=2)
// if (arr[i] > arr[i + 1]) {
// if (arr[i] > minmax.max) {
// minmax.max = arr[i];
// }
// if (arr[i + 1] < minmax.min) {
// minmax.min = arr[i + 1];
// }
// } else {
// if (arr[i + 1] > minmax.max) {
// minmax.max = arr[i + 1];
// }
// if (arr[i] < minmax.min) {
// minmax.min = arr[i];
// }
// }
// i += 2;
// /* Increment the index by 2 as two
// elements are processed in loop */
// }
// }
// return minmax;
// /* Driver program to test above function */
// public static void main(String args[]) {
// int arr[] = {1000,11,445,1,330};
// int arr _size = 5;
// Pair minmax = getMinMax(arr,arr _size);
// System.out.printf("Minimum element is %d",minmax.min);
// System.out.printf("\nMaximum element is %d",minmax.max);
// // O(N/2)
// }
// } 