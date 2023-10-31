#include<bits/stdc++.h>


// Enter the Number of rows - 6
// Triangle of 6 using * -
// *
// *  *
// *  *  *
// *  *  *  *
// *  *  *  *  *
// *  *  *  *  *  *


using namespace std;

int main(){
    int rows;

    cout<<"Enter the Number of rows: ";
    cin>>rows;

    cout << "Triangle of" << rows <<"using * -\n";

    for(int i=0;i<rows;i++){
        for(int j=0;j<=i;j++){
            cout << "* ";
        }
        cout <<endl;
    }
    return 0;
}