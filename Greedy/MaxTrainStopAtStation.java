import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


// We are given n-platform and two main running railway track for both direction. 
// Trains which needs to stop at your station must occupy one platform for their stoppage 
// and the trains which need not to stop at your station will run away through 
// either of main track without stopping. Now, each train has three value first arrival time, 
// second departure time and third required platform number. We are given m such 
// trains you have to tell maximum number of train for which you can provide stoppage at your station.

// Examples:

// Input : n = 3, m = 6 
// Train no.|  Arrival Time |Dept. Time | Platform No.
//     1    |   10:00       |  10:30    |    1
//     2    |   10:10       |  10:30    |    1
//     3    |   10:00       |  10:20    |    2
//     4    |   10:30       |  12:30    |    2
//     5    |   12:00       |  12:30    |    3
//     6    |   09:00       |  10:05    |    1
// Output : Maximum Stopped Trains = 5
// Explanation : If train no. 1 will left 
// to go without stoppage then 2 and 6 can 
// easily be accommodated on platform 1. 
// And 3 and 4 on platform 2 and 5 on platform 3.

// Input : n = 1, m = 3
// Train no.|Arrival Time|Dept. Time | Platform No.
//     1    | 10:00      |  10:30    |    1
//     2    | 11:10      |  11:30    |    1
//     3    | 12:00      |  12:20    |    1
           
// Output : Maximum Stopped Trains = 3
// Explanation : All three trains can be easily
// stopped at platform 1.

// Approach: The idea is to use Greedy approach to solve the problem.

// If we start with a single platform only then we have 1 platform and some trains with their arrival 
// time and departure time and we have to maximize the number of trains on that platform. This task is similar as
// Activity Selection Problem. So, for n platforms we will simply make n-vectors and put the respective trains in 
// those vectors according to platform number. After that by applying greedy approach we easily solve this problem.

// Note : We will take input in form of 4-digit integer for arrival and departure time as 1030 will represent 10:30 so that 
// we may handle the data type easily.
// Also, we will choose a 2-D array for input as arr[m][3] where arr[i][0] denotes arrival time, arr[i][1]
// denotes departure time and arr[i][2] denotes the platform for ith train.
// 1. Sort the trains according to their departure time.
// 2. Initialize the platforms with the first train departure time.
// 3. Traverse the trains and for each train, check if there is any platform available for the train to stop.
// 4. If available then decrement the platform count and continue to the next train.
// 5. If not available then check if the train can replace any train which is running on the track.
// 6. If yes then continue to the next train.
// 7. If not then continue to the next train.
// 8. Finally, the count of the trains which can be stopped at the station is the maximum number of trains that can be 
    //stopped at the station.


public class MaxTrainStopAtStation {
    public static void main(String[] args) {
        int n = 3, m = 6;
        int arr[][] = { { 1000, 1030, 1 }, { 1010, 1030, 1 }, { 1000, 1020, 2 }, { 1030, 1230, 2 }, { 1200, 1230, 3 },
                { 900, 1005, 1 } };
        System.out.println("Maximum Stopped Trains = " + maxStop2(arr, n, m));

        ArrayList<ArrayList<Integer>> trains = new ArrayList<>();
        trains.add(new ArrayList<>(Arrays.asList(1000, 1030, 1)));
        trains.add(new ArrayList<>(Arrays.asList(1010, 1030, 1)));
        trains.add(new ArrayList<>(Arrays.asList(1000, 1020, 2)));
        trains.add(new ArrayList<>(Arrays.asList(1030, 1230, 2)));
        trains.add(new ArrayList<>(Arrays.asList(1200, 1230, 3)));
        trains.add(new ArrayList<>(Arrays.asList(900, 1005, 1)));

        System.out.println("Maximum Stopped Trains = " + maxStop( n, m, trains));
    }

     static int  maxStop2(int arr[][], int n, int m) {
        int count = 0;
        int platform[] = new int[n];
        for (int i = 0; i < n; i++) {
            platform[i] = 0;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][2] == j + 1) {
                    if (platform[j] <= arr[i][0]) {
                        platform[j] = arr[i][1];
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }

   static int maxStop(int n, int m, ArrayList<ArrayList<Integer>> trains) {
        int[][] res = new int[m][4];
        for(int i =0;i<m;i++){
            res[i][0] = i;
            res[i][1] = trains.get(i).get(0);
            res[i][2] = trains.get(i).get(1);
            res[i][3] = trains.get(i).get(2);
        }
        Arrays.sort(res,Comparator.comparingDouble(o->o[2]));
        int count = 0;
        int[][] ans = new int[n][2];
        
        for(int i= 0;i<m;i++){
            int pn = res[i][3]-1; // platform number of train i 

            // if platform is empty then we can stop the train 
            if(ans[pn][1] <= res[i][1]){
                
                count++;
                // update the platform time to the departure time of the train
                ans[pn][0] = res[i][1];
                // update the platform time to the arrival time of the train
                ans[pn][1] = res[i][2];
            }
        }
        return count;
    }


    // Minimum Platforms 2

//     You are in geekworld railway station. You are given train schedule as follows

// arrival_time array contains arrival time of each train
// departure_time array contains departure time of each train
// days array contains the particular day when the trains runs. Also each train arrive and departs on the same day
// You are also given number_of_platforms you have.
// You have to tell  if it is possible to run all the trains with the given number of platforms such that no train has to wait.
// Note: If 2 trains arrive and depart on the same time on the same day on the same platform then depart the train first then second train arrives. Also time in geekland does not follow 24 hr(HHMM) format. So time can be 2368 or 2398, here 2398 > 2368.


// Input: n = 6 
// arr[] = {900, 940, 950, 1100, 1500, 1800}
// dep[] = {910, 1200, 1120, 1130, 1900, 2000}
// days[] = {1, 2, 2, 1, 3, 4}
// platforms = 2
// Output: True
// Explanation:
// Minimum 2 platforms are required to 
// safely arrive and depart all trains.
 
static boolean minimumPlatform2(ArrayList<Integer> arr, ArrayList<Integer> dep,ArrayList<Integer> day, int platforms ){

    int n = arr.size();
    int[][] res = new int[n][4];
    for(int i =0;i<n;i++){
        res[i][0] = i;
        res[i][1] = arr.get(i);
        res[i][2] = dep.get(i);
        res[i][3] = day.get(i);
    }
    Arrays.sort(res,Comparator.comparingDouble(o->o[2]));
    int count = 0;
    int[][] ans = new int[platforms][2];
    
    for(int i= 0;i<n;i++){
        int pn = res[i][3]-1; // platform number of train i 

        // if platform is empty then we can stop the train 
        if(ans[pn][1] <= res[i][1]){
            
            count++;
            // update the platform time to the departure time of the train
            ans[pn][0] = res[i][1];
            // update the platform time to the arrival time of the train
            ans[pn][1] = res[i][2];
        }
    }
    return count == n;
}

}

