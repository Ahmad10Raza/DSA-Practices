// Question: Write a program in C such that it takes a lower limit and upper limit as inputs and print all the intermediate palindrome numbers.

// Test Cases:

// TestCase 1:
// Input :
// 10 , 80
// Expected Result:
// 11 , 22 , 33 , 44 , 55 , 66 , 77.

// Test Case 2:
// Input:
// 100,200
// Expected Result:
// 101 , 111 , 121 , 131 , 141 , 151 , 161 , 171 , 181 , 191.

// Approach: We will iterate from the lower limit to the upper limit and check if the number is palindrome or not. If it is palindrome then we will print it.

// Follow the below steps to implement the solution:
// 1. Take the lower limit and upper limit as input.
// 2. Iterate from the lower limit to the upper limit.
// 3. Check if the number is palindrome or not.
// 4. If it is palindrome then print it.


#include <stdio.h>
#include <stdlib.h>

int isPalindrome(int num)
{
    int temp = num;
    int rev = 0;
    while (temp > 0)
    {
        rev = rev * 10 + temp % 10;
        temp = temp / 10;
    }
    if (rev == num)
    {
        return 1;
    }
    return 0;
}

int main()
{
    int lower, upper;
    printf("Enter the lower limit: ");
    scanf("%d", &lower);
    printf("Enter the upper limit: ");
    scanf("%d", &upper);
    for (int i = lower; i <= upper; i++)
    {
        if (isPalindrome(i))
        {
            printf("%d ", i);
        }
    }
    return 0;
}