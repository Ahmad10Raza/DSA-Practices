
// Write a Program to Convert Digits to Words.

// Example
// Input: 123
// Output: One Hundred Twenty Three

// Approach: We can convert digits to words by following the below steps:
// 1. Create an array of strings to store the words for digits from 0 to 19.
// 2. Create an array of strings to store the words for tens multiples from 20 to 90.
// 3. Create a function to convert a two-digit number to words.
// 4. Create a function to convert a three-digit number to words.
// 5. In the main function, check if the number is less than 1000.
// 6. If the number is less than 1000, call the function to convert a three-digit number to words.
// 7. If the number is greater than or equal to 1000, print "Number out of range".

public class DigitTwoWord {

    public static String[] ones = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
            "Nineteen" };

    public static String[] tens = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
            "Ninety" };

    public static String ConvertTwoDigitNumberToWords(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return ones[num];
        } else {
            return tens[num / 10] + " " + ones[num % 10];
        }
    }

    public static String ConvertThreeDigitNumberToWords(int num) {
        if (num == 0) {
            return "";
        } else if (num < 100) {
            return ConvertTwoDigitNumberToWords(num);
        } else {
            return ones[num / 100] + " Hundred " + ConvertTwoDigitNumberToWords(num % 100);
        }
    }

    public static String ConvertNumberFourDigitToWords(int num) {
        if (num == 0) {
            return "";
        } else if (num < 1000) {
            return ConvertThreeDigitNumberToWords(num);
        } else {
            return "Number out of range";
        }
    }

    public static void main(String[] args) {
        int num = 123;
        if (num < 1000) {
            System.out.println(ConvertThreeDigitNumberToWords(num));
        } else {
            System.out.println("Number out of range");
        }
    }

}
