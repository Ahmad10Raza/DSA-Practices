// Shell sort is mainly a variation of Insertion Sort. In insertion sort, 
// we move elements only one position ahead. When an element has to be moved far ahead, 
// many movements are involved. The idea of ShellSort is to allow the exchange of far items. 
// In Shell sort, we make the array h-sorted for a large value of h. 
// We keep reducing the value of h until it becomes 1. An array is said to be h-sorted if all sublists of every h’th element are sorted.

// Algorithm:

// Step 1 − Start
// Step 2 − Initialize the value of gap size, say h.
// Step 3 − Divide the list into smaller sub-part. Each must have equal intervals to h.
// Step 4 − Sort these sub-lists using insertion sort.
// Step 5 – Repeat this step 2 until the list is sorted.
// Step 6 – Print a sorted list.
// Step 7 – Stop.

// Following is the implementation of ShellSort.


// Java implementation of ShellSort
class ShellSort
{
	/* An utility function to print array of size n*/
	static void printArray(int arr[])
	{
		int n = arr.length;
		for (int i=0; i<n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	/* function to sort arr using shellSort */
	int sort(int arr[])
	{
		int n = arr.length;

		// Start with a big gap, then reduce the gap
		for (int gap = n/2; gap > 0; gap /= 2)
		{
			// Do a gapped insertion sort for this gap size.
			// The first gap elements a[0..gap-1] are already
			// in gapped order keep adding one more element
			// until the entire array is gap sorted
			for (int i = gap; i < n; i += 1)
			{
				// add a[i] to the elements that have been gap
				// sorted save a[i] in temp and make a hole at
				// position i
				int temp = arr[i];

				// shift earlier gap-sorted elements up until
				// the correct location for a[i] is found
				int j;
				for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
					arr[j] = arr[j - gap];

				// put temp (the original a[i]) in its correct
				// location
				arr[j] = temp;
			}
		}
		return 0;
	}

	// Driver method
	public static void main(String args[])
	{
		int arr[] = {12, 34, 54, 2, 3};
		System.out.println("Array before sorting");
		printArray(arr);

		ShellSort ob = new ShellSort();
		ob.sort(arr);

		System.out.println("Array after sorting");
		printArray(arr);
	}
} 