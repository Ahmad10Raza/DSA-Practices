
// Q_01: Reverse the array

    // Array reverse or reverse a array means changing the position of each
    // number of the given array to its opposite position from end,
    // i.e. if a number is at position 1 then its new position will be Array.length,
    // similarly if a number is at position 2 then its new position will be
    // Array.length – 1, and so on.

    // Examples:
    // Input: [1, 2, 3, 4, 5]
    // Output: [5, 4, 3, 2, 1]

    // Approach: Two Pointers
    // 1. Take two pointers, one at the start and the other at the end of the array.
    // 2. Swap the elements at the start and end index.
    // 3. Increment the start pointer and decrement the end pointer.
    // 4. Repeat the above steps until the start pointer is less than the end pointer.


    function reverseArray(arr) {
        let start = 0;
        let end = arr.length - 1;
        while (start < end) {
            [arr[start], arr[end]] = [arr[end], arr[start]];
            start++;
            end--;
        }
    }

    let arr = [1, 2, 3, 4, 5];
    console.log(arr); // [1, 2, 3, 4, 5]
    reverseArray(arr);
    console.log(arr); // [5, 4, 3, 2, 1]    