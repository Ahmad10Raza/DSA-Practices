// Java program to sort an 
// array according to count 
// of set bits using std::sort()
import java.util.*;
class GFG{

// a utility function that 
// returns total set bits
// count in an integer
static int countBits(int a)
{
int count = 0;
while (a > 0)
{
	if ((a & 1) > 0 )
	count += 1;
	a = a >> 1;
}
return count;
}

// Function to sort according to 
// bit count. This function assumes 
// that there are 32 bits in an integer.
static void sortBySetBitCount(int arr[],
							int n)
{
Vector<Integer> []count = new Vector[32];

for (int i = 0; 
		i < count.length; i++)
	count[i] = new Vector<Integer>();

int setbitcount = 0;

for (int i = 0; i < n; i++)
{
	setbitcount = countBits(arr[i]);
	count[setbitcount].add(arr[i]);
}

// Used as an index in 
// final sorted array
int j = 0; 

// Traverse through all bit 
// counts (Note that we sort 
// array in decreasing order)
for (int i = 31; i >= 0; i--)
{
	Vector<Integer> v1 = count[i];
	
	for (int p = 0; p < v1.size(); p++)
	arr[j++] = v1.get(p);
}
}

// Utility function to print 
// an array
static void printArr(int arr[], int n)
{
for (int i = 0; i < n; i++)
	System.out.print(arr[i] + " ");
}

// Driver Code
public static void main(String[] args)
{
int arr[] = {1, 2, 3, 4, 5, 6};
int n = arr.length;
sortBySetBitCount(arr, n);
printArr(arr, n);
}
}
