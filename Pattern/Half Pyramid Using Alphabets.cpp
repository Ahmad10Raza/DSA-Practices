#include<bits/stdc++.h>
using namespace std;

int main(){

    int rows;
    // Getting the number of rows.
    cout << "Enter the Number of rows - ";
    cin >> rows;

    cout << "Triangle of " << rows << " using characters -\n";

    // Main logic to print triangle. 
    for( int i = 0; i < rows; i++ ) {
        for( int j = 0; j <= i; j++ ){
            cout << (char)('A' + j) << " ";
        }
        cout<<endl;
    }

    return 0;
}


// Enter the Number of rows - 6
// Triangle of 6 using * -
// A 
// A B 
// A B C 
// A B C D 
// A B C D E 
// A B C D E F 
