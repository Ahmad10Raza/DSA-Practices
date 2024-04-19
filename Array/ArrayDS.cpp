#include <iostream>
#include <string>

class Array {
private:
    int* arr;
    int size;
public:
    Array(int size) {
        this->size = size;
        arr = new int[size];
    }

    ~Array() {
        delete[] arr;
    }

    int getSize() {
        return size;
    }

    int getElement(int index) {
        if (index >= 0 && index < size) {
            return arr[index];
        } else {
            std::cout << "Invalid index!" << std::endl;
            return -1;
        }
    }

    void setElement(int index, int value) {
        if (index >= 0 && index < size) {
            arr[index] = value;
        } else {
            std::cout << "Invalid index!" << std::endl;
        }
    }


    void print() {
        for (int i = 0; i < size; i++) {
            std::cout << arr[i] << " ";
        }
        std::cout << std::endl;
    }

    void insert(int index, int value) {
        if (index >= 0 && index < size) {
            for (int i = size - 1; i > index; i--) {
                arr[i] = arr[i - 1];
            }
            arr[index] = value;
            size++;
        } else {
            std::cout << "Invalid index!" << std::endl;
        }
    }

    void remove(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                arr[i] = arr[i + 1];
            }
            size--;
        } else {
            std::cout << "Invalid index!" << std::endl;
        }
    }

    void reverse() {
        for (int i = 0; i < size / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[size - i - 1];
            arr[size - i - 1] = temp;
        }
    }

    // Function for Minimum swaps required bring elements less equal K together
    int minSwap(int arr[], int n, int k){
        int count = 0;
        // Find count of elements which are less than
        // equals to k
        for(int i=0; i<n; i++){
            if(arr[i] <= k){
                count++;
            }
        }

        // Find unwanted elements in current window of
        // size 'count'
        int bad = 0;
        for(int i=0; i<count; i++){
            if(arr[i] > k){
                bad++;
            }
        }

        // Initialize answer with 'bad' value of current
        // window
        int ans = bad;
        for(int i=0, j=count; j<n; i++, j++){
            // Decrement count of previous window
            if(arr[i] > k){
                bad--;
            }

            // Increment count of current window
            if(arr[j] > k){
                bad++;
            }

            // Update ans if count of 'bad' is less in
            // current window
            ans = std::min(ans, bad);
        }
        return ans;
    }


    // Function to Minimum no. of operations required to make an array palindrome

    int minOps(int arr[], int n){
        int ans = 0; // Initialize result

        // Start from leftmost and rightmost corners of
        // arr[]
        int i = 0;
        int j = n - 1;

        // Keep moving while the left and right pointers
        // haven't met
        while(i < j){
            // If both elements are same, then no need
            // to do anything
            if(arr[i] == arr[j]){
                i++;
                j--;
            }

            // If left element is greater, then we merge right
            // two elements
            else if(arr[i] > arr[j]){
                // need to merge from tail.
                j--;
                arr[j] += arr[j + 1];
                ans++;
            }

            // Else we merge left two elements
            else{
                i++;
                arr[i] += arr[i - 1];
                ans++;
            }
        }

        return ans;
    }

    // Using Converting into string
    int palinArray(int a[], int n){
        int ans=1;
        for( int i = 0; i<n;i++){
            
            String s = String.valueOf(a[i]);
            if(ans==0){
                break;
            }
            for(int j=0; j<s.length(); j++){
                if(s.charAt(j)!=s.charAt(s.length()-1-j)){
                    ans=1;
                    break;
                }
            }
        }
        return ans;
    }
};

int main() {
    Array arr(5);
    arr.setElement(0, 10);
    arr.setElement(1, 20);
    arr.setElement(2, 30);
    arr.setElement(3, 40);
    arr.setElement(4, 50);
    arr.print();
    arr.insert(2, 25);
    arr.print();
    arr.remove(3);
    arr.print();
    arr.reverse();
    arr.print();
    return 0;
}