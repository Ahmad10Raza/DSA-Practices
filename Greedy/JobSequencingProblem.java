import java.util.*;

// Given an array of jobs where every job has a deadline and associated profit if 
// the job is finished before the deadline. It is also given that every job takes a
// single unit of time, so the minimum possible deadline for any job is 1. 
// Maximize the total profit if only one job can be scheduled at a time.

// Examples: 

// Input: Four Jobs with following deadlines and profits

// JobID  Deadline  Profit

//   a           4          20   
//   b           1          10
//   c           1          40  
//   d           1          30

// Output: Following is maximum profit sequence of jobs: c, a  


public class JobSequencingProblem {
    class Job {
        char id;
        int deadline;
        int profit;

        Job(char id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    // Approach 1 O(n^2): Follow the given steps to solve the problem:

                // Sort all jobs in decreasing order of profit. 
                // Iterate on jobs in decreasing order of profit.For each job , do the following : 
                // Find a time slot i (in array you created eg slot array ), such that slot is empty and i < deadline and i is greatest.Put the job in 
                // this slot and mark this slot filled. 
                // If no such i exists, then ignore the job. 


    public void jobSequencing(Job[] jobs) {
        // Sort all jobs in decreasing order of profit
        int n = jobs.length;
        int profit = 0;
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
        int maxDeadline = 0;
        // Find the maximum deadline among all jobs to create a slot array
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, jobs[i].deadline);
        }
        boolean[] slot = new boolean[maxDeadline];
        char[] result = new char[maxDeadline];
        for (int i = 0; i < n; i++) {
            for (int j = Math.min(maxDeadline - 1, jobs[i].deadline - 1); j >= 0; j--) {
                if (!slot[j]) {
                    slot[j] = true;
                    result[j] = jobs[i].id;
                    profit += jobs[i].profit;
                    break;
                }
            }
        }
        for (int i = 0; i < maxDeadline; i++) {
            if (slot[i]) {
                System.out.print(result[i] + " ");
            }
        }
        System.out.println("\nTotal profit: " + profit);
    }

    int[] JobScheduling(Job arr[], int n)
    {
       Arrays.sort(arr, (a, b) -> b.profit - a.profit);
        boolean[] slot = new boolean[n];
        int profit = 0;
        int day =0;
        for (int i = 0; i < n; i++) {
            for (int j = Math.min(n, arr[i].deadline - 1); j >= 0; j--) {
                if (!slot[j]) {
                    slot[j] = true;
                    day += 1;
                    profit += arr[i].profit;
                    break;
                }
            }
        }
        return new int[]{day, profit};
    }


    // Approach 2 O(nlogn): Follow the given steps to solve the problem:
                            
                        //1).  Sort the jobs based on their deadlines.
                        // 2). Iterate from the end and calculate the available slots between every two consecutive deadlines. 
                        //     Insert the profit, deadline, and job ID of ith job in the max heap.
                        // 3). While the slots are available and there are jobs left in the max heap, 
                        //     include the job ID with maximum profit and deadline in the result.
                        // 4). Sort the result array based on their deadlines.
    

public void jobSequencingOptimized2(Job[] jobs) {

    int n = jobs.length;
    int profit = 0;
    int maxDeadline = 0;
    // Find the maximum deadline among all jobs to create a slot array
    for (int i = 0; i < n; i++) {
        maxDeadline = Math.max(maxDeadline, jobs[i].deadline);
    }
    // Sort all jobs in increasing order of deadline
    Arrays.sort(jobs, (a, b) -> a.deadline - b.deadline);
    // Create a max heap to store the jobs based on profit in decreasing order
    PriorityQueue<Job> maxHeap = new PriorityQueue<>((a, b) -> b.profit - a.profit);
    // starting from end of the array
    for (int i = n - 1; i > -1; i--) {
        int slot_avialable;
        // calculate the available slots between every two consecutive deadlines
        if (i == 0) {
            slot_avialable = jobs[i].deadline;
        } else {
            slot_avialable = jobs[i].deadline - jobs[i - 1].deadline;
        }
        // Include profit of job as priority , deadline, job_id in max heap
        maxHeap.add(jobs[i]);
        // While the slots are available and there are jobs left in the max heap,
        while (slot_avialable > 0 && !maxHeap.isEmpty()) {
            Job job = maxHeap.poll();
            profit += job.profit;
            slot_avialable--;
        }
    }
}

int[] JobSchedulingOptimized(Job arr[], int n){
    Arrays.sort(arr, (a, b) -> a.deadline - b.deadline);
    int profit = 0;
    int day = 0;
    PriorityQueue<Job> maxHeap = new PriorityQueue<>((a, b) -> b.profit - a.profit);
    for (int i = n - 1; i > -1; i--) {
        int slot_avialable;
        if (i == 0) {
            slot_avialable = arr[i].deadline;
        } else {
            slot_avialable = arr[i].deadline - arr[i - 1].deadline;
        }
        maxHeap.add(arr[i]);
        while (slot_avialable > 0 && !maxHeap.isEmpty()) {
            Job job = maxHeap.poll();
            profit += job.profit;
            slot_avialable--;
            day += 1;
        }
    }
    return new int[]{day, profit};
}

    // public void jobSequencingOptimized(Job[] jobs) {
    //     // Sort all jobs in increasing order of deadline
    //     int n = jobs.length;
    //     int profit = 0;
    //     // Sort all jobs in increasing order of deadline 
    //     Arrays.sort(jobs, (a, b) -> a.deadline - b.deadline);
    //     // Create a max heap to store the jobs based on profit in decreasing order
    //     PriorityQueue<Job> maxHeap = new PriorityQueue<>((a, b) -> b.profit - a.profit);
        
    //     // starting from end of the array
    //     for(int i=n-1;i>-1;i++){
    //         int slot_avialable;

    //         // calculate the available slots between every two consecutive deadlines
    //         if(i == 0){
    //             slot_avialable = jobs[i].deadline;
    //         }
    //         else{
    //             slot_avialable = jobs[i].deadline - jobs[i-1].deadline;
    //         }

    //         // Include profit of job as priority , deadline, job_id in max heap

    //         maxHeap.add(jobs[i]);

    //         // While the slots are available and there are jobs left in the max heap,
    //         while(slot_avialable > 0 && !maxHeap.isEmpty()){
    //             Job job = maxHeap.poll();
    //             profit += job.profit;
    //             slot_avialable--;
    //         }

    //         // Sort the result array based on their deadlines
    //         Arrays.sort(jobs, (a, b) -> a.deadline - b.deadline);
    //         for (int j = 0; j < n; j++) {
    //             System.out.print(jobs[j].id + " ");
    //         }
    //     }
    // }


    


    public static void main(String[] args) {
        JobSequencingProblem jobSequencingProblem = new JobSequencingProblem();
        Job[] jobs = new Job[5];
        jobs[0] = jobSequencingProblem.new Job('a', 2, 100);
        jobs[1] = jobSequencingProblem.new Job('b', 1, 19);
        jobs[2] = jobSequencingProblem.new Job('c', 2, 27);
        jobs[3] = jobSequencingProblem.new Job('d', 1, 25);
        jobs[4] = jobSequencingProblem.new Job('e', 3, 15);
        jobSequencingProblem.jobSequencing(jobs);

       
       
    }
}