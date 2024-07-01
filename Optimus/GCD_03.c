
// We have to find the greatest common divisor of two numbers. We will use the Euclidean algorithm to solve this problem.

// Example:
// Input: 10 15
// Output: 5

// Explanation:
// The greatest common divisor of 10 and 15 is 5.

// Approach: We will use the Euclidean algorithm to solve this problem. The algorithm is based on the below formula:
// gcd(a, b) = gcd(b, a%b)
// We will keep on calculating the remainder of the two numbers until the remainder becomes 0. 
// The divisor at this point will be the greatest common divisor of the two numbers.

#include <stdio.h>

int gcd(int a, int b) {
    if(b == 0) {
        return a;
    }
    return gcd(b, a%b);
}

int main() {
    int a, b;
    scanf("%d %d", &a, &b);
    printf("%d\n", gcd(a, b));
    return 0;
}