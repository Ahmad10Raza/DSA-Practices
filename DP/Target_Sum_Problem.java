
// import java.io.*;
class Target_Sum_Problem {

	// Returns true if there is a subset
	// of set[] with sum equal to given sum
	static boolean isSubsetSum_Rec(int set[], int n, int sum)
	{
		// Base Cases
		if (sum == 0)
			return true;
		if (n == 0)
			return false;

		// If last element is greater than then ignore it
		if (set[n - 1] > sum)
			return isSubsetSum_Rec(set, n - 1, sum);

		/* else, check if sum can be obtained
		by any of the following
			(a) including the last element
			(b) excluding the last element */
		return isSubsetSum_Rec(set, n - 1, sum)|| isSubsetSum_Rec(set, n - 1, sum - set[n - 1]);
	}

	static boolean isSubsetSum_Tabulation(int set[], int n, int sum)
    {
        // The value of subset[i][j] will be
        // true if there is a subset of
        // set[0..j-1] with sum equal to i
        boolean subset[][] = new boolean[sum + 1][n + 1];
 
        // If sum is 0, then answer is true
        for (int i = 0; i <= n; i++)
            subset[0][i] = true;
 
        // If sum is not 0 and set is empty,
        // then answer is false
        for (int i = 1; i <= sum; i++)
            subset[i][0] = false;
 
        // Fill the subset table in bottom
        // up manner
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                subset[i][j] = subset[i][j - 1];
                if (i >= set[j - 1])
                    subset[i][j]= subset[i][j]|| subset[i - set[j - 1]][j - 1];
            }
        }
 
        /*// uncomment this code to print table
        for (int i = 0; i <= sum; i++)
        {
        for (int j = 0; j <= n; j++)
            System.out.println (subset[i][j]);
        } */
 
        return subset[sum][n];
    }
	public static void main(String args[])
	{
		int set[] = { 3, 34, 4, 12, 5, 2 };
		int sum = 9;
		int n = set.length;
		if (isSubsetSum_Rec(set, n, sum) == true)
			System.out.println("Found a subset"+ " with given sum");
		else
			System.out.println("No subset with"+ " given sum");
	}
}

