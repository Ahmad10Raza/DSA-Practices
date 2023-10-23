// Java program to print all subarrays
// in the array which has sum 0
import java.util.*;

// User defined pair class
class Pair
{
int first, second;
Pair(int a, int b)
{
	first = a;
	second = b;
}
}

public class Subarray_With_Sum_Zero
{
static ArrayList<Pair> findSubArrays(int[] arr, int n)
{ 
	// Array to store all the start and end
	// indices of subarrays with 0 sum
	ArrayList<Pair> out = new ArrayList<>();

	for (int i = 0; i < n; i++)
	{
	int prefix = 0;
	for(int j = i; j < n; j++){
		prefix += arr[j];
		if(prefix == 0)
		out.add(new Pair(i, j));
	} 
	}
	return out;
}

// Function to print all subarrays with 0 sum
static void print(ArrayList<Pair> out)
{
	for (int i = 0; i < out.size(); i++)
	{
	Pair p = out.get(i);
	System.out.println("Subarray found from Index "
						+ p.first + " to " + p.second);
	}
}




// Function to find subarrays with the same sum
public static List<Map.Entry<Integer, Integer>> findSubArrays_Otimized(int[] arr, int n) {
    List<Map.Entry<Integer, Integer>> out = new ArrayList<>();
     
    // Map to store the starting index of all subarrays with the same sum
    Map<Integer, List<Integer>> sums = new HashMap<>(); 
    int sum = 0;
   
    // Add a dummy index -1 to represent the empty subarray
    sums.put(0, new ArrayList<>(Collections.singletonList(-1))); 
    for (int i = 0; i < n; i++) {
        sum += arr[i];
        if (sums.containsKey(sum)) {
            List<Integer> indices = sums.get(sum);
            for (Integer j : indices) {
                 // Add found subarray range to the output list
                out.add(new AbstractMap.SimpleEntry<>(j + 1, i));
            }
        }
          
        // Add current index to the sum's list of indices
        sums.computeIfAbsent(sum, k -> new ArrayList<>()).add(i); 
    }
    return out;
}

// Function to print subarray ranges
public static void print(List<Map.Entry<Integer, Integer>> out) {
    for (Map.Entry<Integer, Integer> entry : out) {
        System.out.println("Subarray found from Index " + 
                           entry.getKey() + " to " + entry.getValue());
    }
}





// Driver code
public static void main(String args[])
{

	// Given array
	int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
	int n = arr.length;

	// Function Call
	ArrayList<Pair> out = findSubArrays(arr, n);

	// if we didn’t find any subarray with 0 sum,
	// then subarray doesn’t exists
	if (out.size() == 0)
	System.out.println("No subarray exists");
	else
	print(out);
}
}

// This code is contributed by sandharbnkamble.
