// Problem: Write a program in C to display the table of a number and print the sum of all the multiples in it.

// Test Cases:

// Test Case 1:
// Input:
// 5
// Expected Result Value:
// 5, 10, 15, 20, 25, 30, 35, 40, 45, 50
// 275

// Test Case 2:
// Input:
// 12
// Expected Result Value:
// 12, 24, 36, 48, 60, 72, 84, 96, 108, 120
// 660

// Approach: We will take a number as input and display the table of that number. We will also calculate the sum of all the multiples of that number.

// Follow the below steps to implement the solution:
// 1. Take a number as input.
// 2. Display the table of that number.
// 3. Calculate the sum of all the multiples of that number.


#include <stdio.h>
#include <stdlib.h>

int main()
{
    int num;
    printf("Enter the number: ");
    scanf("%d", &num);
    int sum = 0;
    for (int i = 1; i <= 10; i++)
    {
        printf("%d ", num * i);
        sum += num * i;
    }
    printf("\n%d", sum);
    return 0;
}

// Time Complexity: O(1)
// Space Complexity: O(1)