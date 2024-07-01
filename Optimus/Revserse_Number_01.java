
// We have to reverse the given number

// Input: 123
// Output: 321

// Approach 1: Using a while loop
// Time Complexity: O(log(x)), where x is the input number
// Space Complexity: O(1)

// Follow this step to solve the problem:
// 1. Initialize a variable rev to store the reversed number.
// 2. Iterate while the input number x is not equal to 0.
// 3. Multiply the rev variable by 10 and add the last digit of x to it.
// 4. Update the input number x by removing the last digit.
// 5. Return the reversed number rev.


 class Revserse_Number {
    
    public static int reverse(int x) {
        int rev = 0;
        
        while (x != 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        
        return rev;
    }

    public static void main(String[] args) {
        int x = 123;
        System.out.println(reverse(x));
    }



}


// import java.util.Scanner;
// public class reverse_of_number
// {
//   public static void main(String[] args)
//   {
//     //scanner class declaration
//     Scanner sc = new Scanner(System.in);

//     //input from user
//     System.out.print("Enter a number : ");
//     int number = sc.nextInt();
//     System.out.print("Reverse of " + number + " is ");

//     int reverse = 0;
//     String s = "";
//     while (number != 0)
//     {
//      int pick_last = number % 10;

//       //use function to convert pick_last from integer to string
//       s = s + Integer.toString(pick_last);
//       number = number / 10;
//     }

//     //display the reversed number
//     System.out.print(s);

//     //closing scanner class(not compulsory, but good practice)

//     sc.close();
//   }

// }