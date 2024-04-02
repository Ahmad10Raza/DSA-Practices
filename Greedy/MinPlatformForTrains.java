import java.util.*;

// Given the arrival and departure times of all trains that reach a railway station, 
// the task is to find the minimum number of platforms required for the railway station 
// so that no train waits. We are given two arrays that represent the arrival and departure times of trains that stop.

// Examples: 

// Input: arr[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00}, dep[] = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00} 
// Output: 3 
// Explanation: There are at-most three trains at a time (time between 9:40 to 12:00)

// Input: arr[] = {9:00, 9:40}, dep[] = {9:10, 12:00} 
// Output: 1 
// Explanation: Only one platform is needed. 


// Approach: Minimum Number of Platforms Required for a Railway/Bus Station using Heap:
// Store the arrival time and departure time and sort them based on arrival time then check if 
// the arrival time of the next train is smaller than the departure time of the previous train 
// if it is smaller then increment the number of the platforms needed otherwise not.

// Illustration:

// Follow the steps mentioned below:

// Store the arrival time and departure time in array arr and sort this array based on arrival time
// Declare a priority queue(min-heap) and store the departure time of the first train and also 
// declare a counter cnt and initialize it with 1.
// Iterate over arr from 1 to n-1 
//     check if the arrival time of the current train is less than or equal to the departure time 
//     of the previous train which is kept on top of the priority queue
//         If true, then push the new departure time and increment the counter cnt
//         otherwise, we pop() the departure time
//         push new departure time in the priority queue
// Finally, return the cnt.


public class MinPlatformForTrains {
    public static void main(String[] args) {
        int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
        int n = arr.length;
        System.out.println("Minimum platforms needed: " + findPlatform(arr, dep, n));
    }

    public static int findPlatform(int arr[], int dep[], int n) {
        // Sort arrival and departure arrays
        Arrays.sort(arr);
        Arrays.sort(dep);

        // Declare a priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(dep[0]);
        int cnt = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] <= pq.peek()) {
                cnt++;
                pq.add(dep[i]);
            } else {
                pq.poll();
                pq.add(dep[i]);
            }
        }
        return cnt;
    }
}