// What is Counting Sort?
// Counting Sort is a non-comparison-based sorting algorithm that works well 
// when there is limited range of input values. It is particularly efficient 
// when the range of input values is small compared to the number of elements to be sorted. 
// The basic idea behind Counting Sort is to count the frequency of each distinct 
// element in the input array and use that information to place the elements in their correct sorted positions.


// Counting Sort Algorithm:
// Declare an auxiliary array countArray[] of size max(inputArray[])+1 and initialize it with 0.
// Traverse array inputArray[] and map each element of inputArray[] as an index of countArray[] array, i.e., execute countArray[inputArray[i]]++ for 0 <= i < N.
// Calculate the prefix sum at every index of array inputArray[].
// Create an array outputArray[] of size N.
// Traverse array inputArray[] from end and update outputArray[ countArray[ inputArray[i] ] – 1] = inputArray[i]. Also, update countArray[ inputArray[i] ] = countArray[ inputArray[i] ]- – .


// import java.util.Arrays;

public class CountingSort {
	public static int[] countSort(int[] inputArray) {
		int N = inputArray.length;
		int M = 0;

		for (int i = 0; i < N; i++) {
			M = Math.max(M, inputArray[i]);
		}

		int[] countArray = new int[M + 1];

		for (int i = 0; i < N; i++) {
			countArray[inputArray[i]]++;
		}

		for (int i = 1; i <= M; i++) {
			countArray[i] += countArray[i - 1];
		}

		int[] outputArray = new int[N];

		for (int i = N - 1; i >= 0; i--) {
			outputArray[countArray[inputArray[i]] - 1] = inputArray[i];
			countArray[inputArray[i]]--;
		}

		return outputArray;
	}

	public static void main(String[] args) {
		int[] inputArray = {4, 3, 12, 1, 5, 5, 3, 9};
		int[] outputArray = countSort(inputArray);

		for (int i = 0; i < inputArray.length; i++) {
			System.out.print(outputArray[i] + " ");
		}
	}
}
