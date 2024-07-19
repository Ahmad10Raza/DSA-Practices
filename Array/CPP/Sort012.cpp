

// Q_04: Given an array which consists of only 0, 1 and 2. Sort the array
    // without using any sorting algorithm.
    // Given an array A[] consisting of only 0s, 1s, and 2s. The task is to write a
    // function
    // that sorts the given array. The functions should put all 0s first, then all
    // 1s and all 2s in last.

    // Examples:
    // Input: {0, 1, 2, 0, 1, 2}
    // Output: {0, 0, 1, 1, 2, 2}

    // Input: {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}
    // Output: {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}

    // Approach: Dutch National Flag Algorithm
    // T.C = O(n), S.C = O(1)

    // Initialize three variables low, mid, and high to 0, 0, and n-1 respectively.
    // Traverse the array from start to end.
    // If the current element is 0, swap the element at index low with the element
    // at index mid and increment low and mid by 1.
    // If the current element is 1, increment mid by 1.
    // If the current element is 2, swap the element at index mid with the element
    // at index high and decrement high by 1.
    // Repeat the above steps until mid is less than or equal to high.


#include <bits/stdc++.h>
using namespace std;

void sort012(int a[], int n)
{
    int low = 0, mid = 0, high = n - 1;

    while (mid <= high)
    {
        switch (a[mid])
        {
        case 0:
            swap(a[low++], a[mid++]);
            break;
        case 1:
            mid++;
            break;
        case 2:
            swap(a[mid], a[high--]);
            break;
        }
    }
}

int main()
{
    int a[] = {0, 1, 2, 0, 1, 2};
    int n = sizeof(a) / sizeof(a[0]);

    sort012(a, n);

    cout << "Array after sorting: ";
    for (int i = 0; i < n; i++)
        cout << a[i] << " ";

    return 0;
}