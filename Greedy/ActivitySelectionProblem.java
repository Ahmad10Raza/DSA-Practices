// Function to activity selection problem

        // Problem:
        // You are given n activities with their start and finish times. Select the maximum number of 
        // activities that can be performed by a single person, assuming that a person can only work on 
        // a single activity at a time. 

        // Input: start[]  =  {10, 12, 20}, finish[] =  {20, 25, 30}
        // Output: 0
        // Explanation: A person can perform at most one activities.

        // Input: start[]  =  {1, 3, 0, 5, 8, 5}, finish[] =  {2, 4, 6, 7, 9, 9};
        // Output: 0 1 3 4
        // Explanation: A person can perform at most four activities. The 
        //             maximum set of activities that can be executed 
        //             is {0, 1, 3, 4} [ These are indexes in start[] and finish[] 

        // Approach:
        // 1. Create a 2D array to store the start and finish times of the activities.
        // 2. Store the start and finish times in the 2D array.
        // 3. Sort the activities based on their finish times.  
        // 4. Select the first activity.
        // 5. Select the remaining activities based on the condition that the start time of the current activity
        //    is greater than or equal to the finish time of the previous activity.

import java.util.Arrays;

public class ActivitySelectionProblem {

    public void activitySelection(int[] start, int[] finish) {
        // Create a 2D array to store the start and finish times
        int[][] activities = new int[start.length][2];
        
        // Store the start and finish times in the 2D array
        for (int i = 0; i < start.length; i++) {
            activities[i][0] = start[i];
            activities[i][1] = finish[i];
        }
        
        // Sort the activities based on their finish times
        Arrays.sort(activities, (a, b) -> Integer.compare(a[1], b[1]));
        
        // Select the first activity
        int i = 0;
        System.out.print("A" + i + " ");
        
        // Select the remaining activities
        for (int j = 1; j < activities.length; j++) {
            if (activities[j][0] >= activities[i][1]) {
                System.out.print("A" + j + " ");
                i = j;
            }
        }
    }

    public static int activitySelectionCount(int start[], int end[], int n)
    {
        int mat[][] = new int [n][2];
        
        for(int i = 0; i<n; i++){
            mat[i][0] = start[i];
            mat[i][1] = end[i];
        }
        
        Arrays.sort(mat , ((a,b) ->  (a[1] - b[1])));
        
        int ans=1;
        int lastEnd = mat[0][1];
        for(int i = 1; i< n ; i++){
            if(mat[i][0] > lastEnd){
                ans++;
                lastEnd = mat[i][1];
            }
        }
        return ans;
    }

    public void ActivitySelectionInSortedArray(int[] start, int[] finish) {
        // Select the first activity
        int i = 0;
        System.out.print("A" + i + " ");
        
        // Select the remaining activities
        for (int j = 1; j < start.length; j++) {
            if (start[j] >= finish[i]) {
                System.out.print("A" + j + " ");
                i = j;
            }
        }
    }
    

    public static void main(String[] args) {
        // Create an instance of ActivitySelectionProblem and test its methods
        ActivitySelectionProblem activitySelectionProblem = new ActivitySelectionProblem();
        
        // Test the activitySelection method
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] finish = {2, 4, 6, 7, 9, 9};
        activitySelectionProblem.activitySelection(start, finish);

    }
}