
// We have given a year we need to check whether it is a leap year or not. If it is a leap year return 1 else return 0.

// Input: 2000
// Output: Yes
// Explanation: 2000 is a leap year as it is divisible by 400.

// Input: 2002
// Output: No

// Approach: A year is a leap year if it is divisible by 4. If the year is divisible by 100, 
// then it is a leap year only if it is divisible by 400. So, we will check if the year is 
// divisible by 400 or divisible by 4 but not divisible by 100.

public class LeapYear {
    
    public static int isLeapYear(int year) {
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int year = 2000;
        System.out.println(isLeapYear(year));
    }
}
