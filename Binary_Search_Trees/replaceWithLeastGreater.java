import java.util.*;

public class replaceWithLeastGreater {
	public static void main(String[] args)
	{
		int[] arr = { 8, 58, 71, 18, 31, 32, 63, 92,
					43, 3, 91, 93, 25, 80, 28 };
		printArray(arr);
		solve(arr);
		printArray(arr);
	}
	public static void solve(int[] arr)
	{
		TreeSet<Integer> s = new TreeSet<>();
		for (int i = arr.length - 1; i >= 0;
			i--) { // traversing the array backwards
			s.add(arr[i]); // inserting the element into set
			Integer it
				= s.higher(arr[i]); // finding upper bound
									// (higher in java)
			if (it == null)
				arr[i] = -1; // if upper_bound does not
							// exist then -1
			else
				arr[i] = it; // if upper_bound exists, lets
							// take it
		}
	}
	public static void printArray(int[] arr)
	{
		for (int i : arr)
			System.out.print(i + " ");
		System.out.println();
	}
}

