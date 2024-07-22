
// Q_13: Merge Overlapping Intervals
    // Given a set of time intervals in any order, our task is to merge all
    // overlapping
    // intervals into one and output the result which should have only mutually
    // exclusive intervals.

    // Example:
    // Input: Intervals = {{1,3},{2,4},{6,8},{9,10}}
    // Output: {{1, 4}, {6, 8}, {9, 10}}
    // Explanation: Given intervals: [1,3],[2,4],[6,8],[9,10], we have only two
    // overlapping
    // intervals here,[1,3] and [2,4]. Therefore we will merge these two and return
    // [1,4],[6,8], [9,10].
    // Input: Intervals = {{6,8},{1,9},{2,4},{4,7}}
    // Output: {{1, 9}}

    // Approach: Sorting
    // T.C = O(n log n), S.C = O(n)

    // To solve this problem optimally we have to first sort the intervals according
    // to
    // the starting time. Once we have the sorted intervals, we can combine all
    // intervals
    // in a linear traversal. The idea is, in sorted array of intervals, if
    // interval[i]
    // doesn’t overlap with interval[i-1], then interval[i+1] cannot overlap with
    // interval[i-1]
    // because starting time of interval[i+1] must be greater than or equal to
    // interval[i].

    // Follow the steps mentioned below to implement the approach:

    // Sort the intervals based on the increasing order of starting time.
    // Push the first interval into a stack.
    // For each interval do the following:
    // If the current interval does not overlap with the top of the stack then, push
    // the current interval into the stack.
    // If the current interval overlap with the top of the stack then, update the
    // stack top with the ending time of the current interval.
    // The end stack contains the merged intervals.


#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// Data structure to store an interval
struct Interval
{
    int start, end;
};

// Function to merge overlapping intervals
void mergeIntervals(vector<Interval> &intervals)
{
    // sort the intervals based on increasing order of start time
    sort(intervals.begin(), intervals.end(),
         [](Interval &x, Interval &y) { return x.start < y.start; });

    // create an empty stack
    vector<Interval> stack;

    // do for each interval
    for (const Interval &curr : intervals)
    {
        // if the stack is empty or top interval in stack do not overlap
        // with the current interval, push it to the stack
        if (stack.empty() || curr.start > stack.back().end)
        {
            stack.push_back(curr);
        }

        // if the current interval overlaps with the top of the stack,
        // update the end of the top interval to the maximum end of current
        // and top interval
        else
        {
            stack.back().end = max(stack.back().end, curr.end);
        }
    }

    // print the merged intervals
    for (const Interval &interval : stack)
    {
        cout << "{" << interval.start << ", " << interval.end << "}, ";
    }
}

int main()
{
    vector<Interval> intervals = {{1, 3}, {2, 4}, {6, 8}, {9, 10}};
    mergeIntervals(intervals);

    return 0;
}