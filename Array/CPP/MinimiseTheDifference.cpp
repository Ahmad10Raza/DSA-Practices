// Q_09: Minimise the maximum difference between heights [V.IMP]
    // Given the heights of N towers and a value of K, Either increase or decrease
    // the
    // height of every tower by K (only once) where K > 0. After modifications,
    // the task is to minimize the difference between the heights of the longest
    // and the shortest tower and output its difference.

    // Examples:
    // Input: arr[] = {1, 15, 10}, k = 6
    // Output: Maximum difference is 5.
    // Explanation: Change 1 to 7, 15 to 9 and 10 to 4. Maximum difference is 5
    // (between 4 and 9). We can’t get a lower difference.
    // Input: arr[] = {1, 5, 15, 10}, k = 3
    // Output: Maximum difference is 8, arr[] = {4, 8, 12, 7}

    // Approach: Sorting
    // T.C = O(n log n), S.C = O(1)

    // Sort the array in ascending order.
    // Initialize two variables, smallest and largest, to store the smallest and
    // largest elements of the array.
    // Initialize a variable, result, to store the difference between the largest
    // and smallest elements.
    // Traverse the array from start to end.
    // Update the smallest element by adding K and the largest element by
    // subtracting K.
    // Update the result to the minimum of the current result and the difference
    // between the updated largest and smallest elements.
    // Print the result.

#include <bits/stdc++.h>
using namespace std;

int getMinDiff(int arr[], int n, int k)
{
    if (n == 1)
        return 0;

    sort(arr, arr + n);

    int ans = arr[n - 1] - arr[0];

    int small = arr[0] + k;
    int big = arr[n - 1] - k;

    if (small > big)
        swap(small, big);

    for (int i = 1; i < n - 1; i++)
    {
        int add = arr[i] + k;
        int sub = arr[i] - k;

        if (sub >= small || add <= big)
            continue;

        if (big - sub <= add - small)
            small = sub;
        else
            big = add;
    }

    return min(ans, big - small);
}