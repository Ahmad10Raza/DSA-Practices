// Given a number of friends who have to give or take some amount of money from one another. 
// Design an algorithm by which the total cash flow among all the friends is minimized. 

// Example: 
// Input:
// Number of friends: 3
// 0 1000 2000
// 0 0 5000
// 0 0 0
// Output:
// Person 1 pays 2000 to Person 0
// Person 2 pays 3000 to Person 0

// The idea is to use Greedy algorithm where at every step, settle all amounts of one person and recur for remaining n-1 persons. 
// How to pick the first person? To pick the first person, calculate the net amount for every person where net amount is obtained by subtracting all debts (amounts to pay) from all credits (amounts to be paid). Once net amount for every person is evaluated, find two persons with maximum and minimum net amounts. These two persons are the most creditors and debtors. The person with minimum of two is our first person to be settled and removed from list. Let the minimum of two amounts be x. We pay ‘x’ amount from the maximum debtor to maximum creditor and settle one person. If x is equal to the maximum debit, then maximum debtor is settled, else maximum creditor is settled.
// The following is detailed algorithm.

// Do following for every person Pi where i is from 0 to n-1.  

// Compute the net amount for every person. The net amount for person ‘i’ can be computed by subtracting sum of all debts from sum of all credits.
// Find the two persons that are maximum creditor and maximum debtor. Let the maximum amount to be credited maximum creditor be maxCredit and maximum amount to be debited from maximum debtor be maxDebit. Let the maximum debtor be Pd and maximum creditor be Pc.
// Find the minimum of maxDebit and maxCredit. Let minimum of two be x. Debit ‘x’ from Pd and credit this amount to Pc
// If x is equal to maxCredit, then remove Pc from set of persons and recur for remaining (n-1) persons.
// If x is equal to maxDebit, then remove Pd from set of persons and recur for remaining (n-1) persons.


public class MinimizeCashFlow {
    
    static final int N = 3;
    
    // A utility function that returns index of minimum value in arr[]
    static int getMin(int arr[]) {
        int minInd = 0;
        for (int i = 1; i < N; i++) {
            if (arr[i] < arr[minInd]) {
                minInd = i;
            }
        }
        return minInd;
    }
    
    // A utility function that returns index of maximum value in arr[]
    static int getMax(int arr[]) {
        int maxInd = 0;
        for (int i = 1; i < N; i++) {
            if (arr[i] > arr[maxInd]) {
                maxInd = i;
            }
        }
        return maxInd;
    }
    
    // A utility function to return minimum of 2 values
    static int minOf2(int x, int y) {
        return (x < y) ? x : y;
    }
    
    // amount[p] indicates the net amount to be credited/debited to/from person 'p'
    // If amount[p] is positive, then person 'p' will amount to be credited, else debited
    static void minCashFlowRec(int amount[]) {
        int mxCredit = getMax(amount), mxDebit = getMin(amount);
        
        // If both amounts are 0, then all amounts are settled
        if (amount[mxCredit] == 0 && amount[mxDebit] == 0) {
            return;
        }
        
        // Find the minimum of two amounts
        int min = minOf2(-amount[mxDebit], amount[mxCredit]);
        amount[mxCredit] -= min;
        amount[mxDebit] += min;
        
        // If minimum is the maximum amount to be credited, then credit the maximum amount first
        if (min == amount[mxCredit]) {
            System.out.println("Person " + mxDebit + " pays " + min + " to Person " + mxCredit);
        } else {
            System.out.println("Person " + mxDebit + " pays " + min + " to Person " + mxCredit);
        }
        
        // Recur for the amount array
        minCashFlowRec(amount);
    }
    
    // Given a set of persons as graph[] where graph[i][j] indicates the amount
}                                                                           