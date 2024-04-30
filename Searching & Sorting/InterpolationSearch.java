

// Interpolation search is an improved variant of binary search. This search algorithm works on the probing position of the required value. For this algorithm to work properly, the data collection should be in a sorted form and equally distributed.    
// The idea of formula is to return higher value of pos when element to be searched is closer to arr[hi]. And smaller value when closer to arr[lo]
// pos = lo + [ (x-arr[lo])*(hi-lo) / (arr[hi]-arr[Lo]) ]
// arr[] ==> Array where elements need to be searched
// x     ==> Element to be searched
// lo    ==> Starting index in arr[]
// hi    ==> Ending index in arr[]
// The formula for pos can be derived as follows:
// Let's assume that the elements of the array are linearly distributed.
// General equation of line : y = m*x + c.
// y is the value in the array and x is its index.
// Now putting value of lo,hi and x in the equation.
// arr[hi] = m*hi + c ---(1)
// arr[lo] = m*lo + c ---(2)
// x = m*pos + c     ---(3)
// m = (arr[hi] - arr[lo] ) / ( hi - lo )
// Subtracting eqxn 2 from 1
// arr[hi] - arr[lo] = m * (hi-lo)
// m = (arr[hi] - arr[lo] ) / ( hi - lo )
// Putting value of m in eqn 3
// x = ((arr[hi] - arr[lo]) / (hi - lo))* pos + c
// c = x - (arr[hi] - arr[lo]) / (hi - lo) * pos
// c = x - arr[lo] * pos + lo * arr[hi] - hi * arr[lo] / (hi - lo)


// Time Complexity: O(log log n) for the average case, O(n) for the worst case, and O(1) for the best case.
// Space Complexity: O(1)

import java.util.Arrays;



public class InterpolationSearch {

    public static void main(String[] args) {
        int[] arr = { 10, 12, 13, 16, 18, 19, 20, 21, 22, 23, 24, 33, 35, 42, 47 };
        int x = 18;
        int index = interpolationSearch(arr, x);
        if (index != -1) {
            System.out.println("Element found at index " + index);
        } else {
            System.out.println("Element not found in the array");
        }
    }

    public static int interpolationSearch(int[] arr, int x) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi && x >= arr[lo] && x <= arr[hi]) {
            if (lo == hi) {
                if (arr[lo] == x) {
                    return lo;
                }
                return -1;
            }
            int pos = lo + (((hi - lo) / (arr[hi] - arr[lo])) * (x - arr[lo]));
            if (arr[pos] == x) {
                return pos;
            }
            if (arr[pos] < x) {
                lo = pos + 1;
            } else {
                hi = pos - 1;
            }
        }
        return -1;
    }
    
}

