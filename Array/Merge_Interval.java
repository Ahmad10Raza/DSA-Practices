// import java.util.*;
// public class Merge_Interval {
//     private static int[][] merge(int[][] intervals) {
//         Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
//         LinkedList<int[]> merged = new LinkedList<>();
//         for (int[] interval : intervals) {
//             // if the list of merged intervals is empty or if the current
//             // interval does not overlap with the previous, simply append it.
//             if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
//                 merged.add(interval);
//             }
//             // otherwise, there is overlap, so we merge the current and previous
//             // intervals.
//             else {
//                 merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
//             }
//         }
//         return merged.toArray(new int[merged.size()][]);
//     }

//     public static void main(String[] args) {
//         int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
//         int[][] results = merge(intervals);
//         for (int[] interval : results) {
//             System.out.println(interval[0] + " " + interval[1]);
//         }
//     }
// }