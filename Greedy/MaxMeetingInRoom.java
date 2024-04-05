// There is one meeting room in a firm. There are N meetings in the form of (S[i], F[i])
// where S[i] is the start time of meeting i and F[i] is the finish time of meeting i. 
// The task is to find the maximum number of meetings that can be accommodated in the meeting room. Print all meeting numbers

// Examples: 

// Input: s[] = {1, 3, 0, 5, 8, 5}, f[] = {2, 4, 6, 7, 9, 9} 
// Output: 1 2 4 5
// First meeting [1, 2] 
// Second meeting [3, 4] 
// Fourth meeting [5, 7] 
// Fifth meeting [8, 9]

// Input : s[] = {75250, 50074, 43659, 8931, 11273, 27545, 50879, 77924}, 
// f[] = {112960, 114515, 81825, 93424, 54316, 35533, 73383, 160252 } 
// Output : 6 7 1


// Approach: The idea is to solve the problem using the greedy approach which is the same as 
//             Activity Selection Problem i.e sort the meetings by their finish time and then
//             start selecting meetings, starting with the one with least end time and then 
//             select other meetings such that the start time of the current meeting is greater 
//             than the end time of last meeting selected

// Follow the given steps to solve the problem using the above approach:

// Sort all pairs(Meetings) in increasing order of each pair’s second number(Finish time).
// Select the first meeting of the sorted pair as the first Meeting in the room and push it into the result vector and set a variable time_limit(say) with the second value(Finishing time) of the first selected meeting.
// Iterate from the second pair to the last pair of the array and if the value of the first element(Starting time of meeting) of the current pair is greater than the previously selected pair’s finish time (time_limit) then select the current pair and update the result vector (push selected meeting number into result vector) and variable time_limit.
// Print the Order of meeting from the result vector.

import java.util.*;
import java.util.Comparator;

class Pair {
    int start;
    int end;
    int pos;

    Pair(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class PairComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair p1, Pair p2) {
        return p1.end - p2.end;
    }
}

public class MaxMeetingInRoom {
    public static void maxMeeting(int s[], int f[], int n) {
        Pair arr[] = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(s[i], f[i], i + 1);
        }

        Arrays.sort(arr, new PairComparator());

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr[0].pos);
        int time_limit = arr[0].end;

        for (int i = 1; i < n; i++) {
            if (arr[i].start > time_limit) {
                ans.add(arr[i].pos);
                time_limit = arr[i].end;
            }
        }

        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int s[] = { 1, 3, 0, 5, 8, 5 };
        int f[] = { 2, 4, 6, 7, 9, 9 };
        int n = s.length;

        maxMeeting(s, f, n);
    }
}