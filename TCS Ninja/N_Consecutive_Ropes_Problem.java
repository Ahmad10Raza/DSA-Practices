// Q2. Given N gold wires, each wire has a length associated with it. At a time,
// only two adjacent small wres
// assembled at the end of a large wire and the cost of forming is the sum of
// their length. Find the minimum
// cost when all wires are assembled to form a single wire.
// For Example:
// Suppose, Arr[] = {7, 6, 8, 6, 1, 1}
// {7, 6, 8, 6, 1, 1} - {7, 6, 8, 6, 2}, cost = 2
// {7, 6, 8, 6, 2} - {7, 6, 8, 8}, cost = 8
// {7, 6, 8, 8} - {13, 8, 8}, cost =13
// {13, 8, 8} - {13, 16}, cost = 16
// {13, 16} - {29}, cost = 29
// 2 + 8 + 13 + 16 + 29 = 68
// Hence, the minimum cost to assemble all gold wires is : 68
// Constraints:
// 1 <= N <= 30
// 1<= Arr[] <= 100
// Example 1:
// Input:
// 6
// -> Value of N, represents size of Arr
// 7
// -> Value of Arr[0], represents length of 1st wire
// 6
// -> Value of Arr[1], represents length of 2nd wire
// 8
// -> Value of Arr[2], represents length of 3rd wire
// 6
// -> Value of Arr[3], represents length of 4th wire
// -1
// -> Value of Arr[4], represents length of 5th wire
// 1
// -> Value of Arr[5], represents length of 6th wire
// Output:
// 68
// Example 2:
// Input:
// 4
// 12
// 2
// 2
// 5
// -> Value of N, represents size of Arr
// -> Value of Arr[0], represents length of 1st wire
// -> Value of Arr[1], represents length of 2nd wire
// -> Value of Arr[2], represents length of 3rd wire
// -> Value of Arr[3], represents length of 4th wire

// Output:
// 34

// Approach: To solve this problem, we can use a priority queue to store the lengths of the gold wires. We can then repeatedly remove the two smallest lengths from the priority queue, add them together, and insert the sum back into the priority queue. We can continue this process until there is only one element left in the priority queue, which will be the minimum cost to assemble all the gold wires. The time complexity of this approach is O(n log n), where n is the number of gold wires. The space complexity is O(n) to store the lengths of the gold wires in the priority queue.
// Time Complexity: O(n log n)
// Space Complexity: O(n)

import java.util.PriorityQueue;

public class N_Consecutive_Ropes_Problem {

    public static int minCost(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }

        int cost = 0;
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            cost += a + b;
            pq.add(a + b);
        }

        return cost;
    }

    public static long minCost2(long arr[], int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(arr[i]);
        }

        long cost = 0;
        while (pq.size() > 1) {
            long a = pq.poll();
            long b = pq.poll();
            cost += a + b;
            pq.add(a + b);
        }

        return cost;
    }

    public static void main(String[] args) {
        int[] arr = { 7, 6, 8, 6, 1, 1 };
        System.out.println(minCost(arr));

        int[] arr2 = { 4, 12, 2, 2, 5 };
        System.out.println(minCost(arr2));
    }
}
