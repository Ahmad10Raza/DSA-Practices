// The game is simple. You initially have ‘H’ amount of health and ‘A’ amount of armor. 
// At any instant you can live in any of the three places - fire, water and air. 
// After every unit time, you have to change your place of living. 
// For example if you are currently living at fire, you can either step into water or air.

// If you step into air, your health increases by 3 and your armor increases by 2
// If you step into water, your health decreases by 5 and your armor decreases by 10
// If you step into fire, your health decreases by 20 and your armor increases by 5
// If your health or armor becomes <=0, you will die instantly

// Find the maximum time you can survive.
// Input:
// The first line consists of an integer t, the number of test cases. 
// For each test case there will be two positive integers representing the initial health H and initial armor A.
// Output:
// For each test case find the maximum time you can survive.
// Note: You can choose any of the 3 places during your first move.
// Input Constraints:
// 1 <= t <= 10
// 1 <= H, A <= 1000

// Example:
// Sample Input:

// 3
// 2 10
// 4 4
// 20 8
// Sample Output:

// 1
// 1
// 5

// Approach: We have given two parameter health and armor. We have to find the maximum time we can survive.
// We can choose any of the 3 places during our first move.
// We can solve this problem using greedy approach.
// We can choose the place which will increase our health and armor.
// We can choose air because it will increase our health and armor.
// By Uisng Recursive approach we can traverse all the possible places and find the maximum time we can survive.
// After traversing all the possible places we can find the maximum time we can survive using Dynamic Programming.
// We can store the result of each place in a 2D array and use it when we need it.


import java.util.Scanner;

public class DieHardProblems {

    // Resursive Approach
    
    public int maxTimeToSurvive(int h, int a, int place) {
        if(h <= 0 || a <= 0) {
            return 0;
        }
        if(place == 0) {
            return 1 + maxTimeToSurvive(h+3, a+2, 1);
        } else if(place == 1) {
            return 1 + maxTimeToSurvive(h-5, a-10, 2);
        } else {
            return 1 + maxTimeToSurvive(h-20, a+5, 0);
        }
    }

    // Dynamic Programming Approach

    public int maxTimeToSurviveDP(int h, int a, int place) {
        int[][] dp = new int[h+1][a+1];
        for(int i = 0; i <= h; i++) {
            for(int j = 0; j <= a; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    int air = 0, water = 0, fire = 0;
                    if(i > 1 && j > 1) {
                        air = 1 + dp[i-2][j-1];
                    }
                    if(i > 5 && j > 10) {
                        water = 1 + dp[i-5][j-10];
                    }
                    if(i > 20) {
                        fire = 1 + dp[i-20][j+5];
                    }
                    dp[i][j] = Math.max(air, Math.max(water, fire));
                }
            }
        }
        return dp[h][a];
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int h = sc.nextInt();
            int a = sc.nextInt();
            int[][] dp = new int[h+1][a+1];
            for(int i = 0; i <= h; i++) {
                for(int j = 0; j <= a; j++) {
                    if(i == 0 || j == 0) {
                        dp[i][j] = 0;
                    } else {
                        int air = 0, water = 0, fire = 0;
                        if(i > 1 && j > 1) {
                            air = 1 + dp[i-2][j-1];
                        }
                        if(i > 5 && j > 10) {
                            water = 1 + dp[i-5][j-10];
                        }
                        if(i > 20) {
                            fire = 1 + dp[i-20][j+5];
                        }
                        dp[i][j] = Math.max(air, Math.max(water, fire));
                    }
                }
            }
            System.out.println("The Maximum Servive Time is : " + dp[h][a]);
        }
        sc.close();



        // Recursive Approach

        DieHardProblems dieHardProblems = new DieHardProblems();
        int h = 20;
        int a = 8;
        int place = 0;
        int maxTime = dieHardProblems.maxTimeToSurvive(h, a, place);
        System.out.println("The Maximum Time to Survive is : " + maxTime);

    }
}
