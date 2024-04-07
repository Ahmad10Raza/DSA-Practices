public class ArrayDS {
    private int[] array;
    private int size;

    public ArrayDS(int capacity) {
        array = new int[capacity];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return array.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int element) {
        if (size == array.length) {
            resizeArray();
        }
        array[size] = element;
        size++;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        return array[index];
    }

    public void set(int index, int element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        array[index] = element;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    private void resizeArray() {
        int[] newArray = new int[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    // Q_01: Reverse the array

    //Array reverse or reverse a array means changing the position of each 
    // number of the given array to its opposite position from end, 
    // i.e. if a number is at position 1 then its new position will be Array.length, 
    // similarly if a number is at position 2 then its new position will be Array.length – 1, and so on.

// Approach 1: Using a temporary array
// T.C = O(n), S.C = O(n)

// Create a temporary array of the same size as the given array.
// Traverse the given array from start to end and copy each element to the temporary array from end to start.
// Copy the elements of the temporary array back to the given array.
// Print the reversed array.

    public void reverse2() {
        int[] tempArray = new int[size];
        for (int i = 0; i < size; i++) {
            tempArray[i] = array[size - i - 1];
        }
        System.arraycopy(tempArray, 0, array, 0, size);
    }

    // Approach 2: Using Two Pointers
    // T.C = O(n), S.C = O(1)

    // Initialize two pointers, first and last, pointing to the first and last element of the array respectively.
    // Swap the elements at the first and last pointers.
    // Increment the first pointer and decrement the last pointer.
    // Repeat the above steps until the first pointer is less than the last pointer.

    public void reverse() {
        int first = 0;
        int last = size - 1;
        while (first < last) {
            int temp = array[last];
            array[last] = array[first];
            array[first] = temp;
            first++;
            last--;
        }
    }

    // Approach 3: Using Recursion

    // T.C = O(n), S.C = O(n)

    // Base Case: If the start index is greater than or equal to the end index, return.
    // Swap the elements at the start and end index.
    // Recur for the remaining elements by incrementing the start index and decrementing the end index.

    public void reverse(int start, int end) {
        if (start >= end) {
            return;
        }
        int temp = array[end];
        array[end] = array[start];
        array[start] = temp;
        reverse(start + 1, end - 1);
    }


    // Q_02: Find the maximum and minimum element in an array
    // Input: [2, 4, 1, 6, 8, 5]
    // Output: Maximum: 8, Minimum: 1

    // Approach: Linear Search
    // T.C = O(n), S.C = O(1)

    // Initialize two variables, max and min, to store the maximum and minimum elements of the array.
    // Traverse the array from start to end.
    // If the current element is greater than the max element, update the max element.
    // If the current element is less than the min element, update the min element.
    // Print the maximum and minimum elements.

    public void findMaxMin() {
        if (size == 0) {
            System.out.println("Array is empty");
            return;
        }
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.println("Maximum: " + max + ", Minimum: " + min);
    }















    public static void main(String[] args) {
        ArrayDS array = new ArrayDS(5);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        // System.out.println("Size: " + array.getSize());
        // System.out.println("Capacity: " + array.getCapacity());
        // System.out.println("Is empty: " + array.isEmpty());
        // System.out.println("Element at index 2: " + array.get(2));
        // array.set(2, 10);
        // System.out.println("Element at index 2: " + array.get(2));
        // array.remove(2);
        // System.out.println("Size: " + array.getSize());
        // System.out.println("Element at index 2: " + array.get(2));

        // array.reverse();
        // array.reverse(0, array.getSize() - 1);
        // array.reverse2();
        // for (int i = 0; i < array.getSize(); i++) {
        //     System.out.print(array.get(i) + " ");
        // }


        array.findMaxMin();
        
    }
}