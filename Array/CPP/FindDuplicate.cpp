// Q_11: Find duplicate in an array of N+1 Integers
    // Given a constant array of n elements which contains elements from 1 to n-1,
    // with any of these numbers appearing any number of times. Find any one of
    // these
    // repeating numbers in O(n) and using only constant memory space.

    // Examples:
    // Input : arr[] = {1, 2, 3, 4, 5, 6, 3}
    // Output : 3

    // Approach: Floyd’s Cycle Detection Algorithm
    // T.C = O(n), S.C = O(1)

    // Initialize two variables, slow and fast, to store the current index.
    // Traverse the array from the first element.
    // Update the slow variable to the element at the current index.
    // Update the fast variable to the element at the element at the element at the
    // current index.
    // If the slow and fast variables are equal, break the loop.
    // Initialize the slow variable to the first element.
    // Traverse the array from the first element.
    // Update the slow variable to the element at the current index.
    // Update the fast variable to the element at the current index.
    // If the slow and fast variables are equal, return the slow variable.

#include <iostream>
using namespace std;

int findDuplicate(int arr[], int n)
{
    int slow = arr[0];
    int fast = arr[0];

    do
    {
        slow = arr[slow];
        fast = arr[arr[fast]];
    } while (slow != fast);

    slow = arr[0];
    while (slow != fast)
    {
        slow = arr[slow];
        fast = arr[fast];
    }

    return slow;
}

int main()
{
    int arr[] = {1, 2, 3, 4, 5, 6, 3};
    int n = sizeof(arr) / sizeof(arr[0]);

    cout << findDuplicate(arr, n) << endl;

    return 0;
}