// Below are the steps to implement the above idea:

// Run a for loop and for i = 0 to n-1
// Take first = -1 and last = -1 
// When we find an element first time then we update first = i 
// We always update last=i whenever we find the element.
// We print first and last.



public class First_Last_Element_Sorted_Array {
    public static void findFirstAndLast(int arr[], int x)
    {
        int n = arr.length;
        int first = -1, last = -1;
        for (int i = 0; i < n; i++) {
            if (x != arr[i])
                continue;
            if (first == -1)
                first = i;
            last = i;
        }
        if (first != -1) {
            System.out.println("First Occurrence = "+ first);
            System.out.println("Last Occurrence = " + last);
        }
        else
            System.out.println("Not Found");
    }

    public static void main(String[] args) {
        int arr[] = {0,0,0,0,0,0,0,0,1,1,1,1,1};
        int x=1;
        findFirstAndLast(arr, x);
    }
}