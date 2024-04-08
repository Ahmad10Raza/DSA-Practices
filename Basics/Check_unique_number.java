//package PRACTICE_QUESTION;

import java.util.*;

public class Check_unique_number {

    public static void main(String[] args) {

        // Create list of numbers to check for unique
        List<Integer> nums = Arrays.asList(4, 1, 5, 3, 2, 4);

        // Use a hash set
        Set<Integer> uniqueNums = new HashSet<>(nums);

        System.out.println("Checking Elements For Uniqueness With the HashSet");
        handleDuplicates(uniqueNums);

        // And array sort
        Collections.sort(nums);

        System.out.println("\nChecking Elements For Uniqueness With Arrays.sort");
        int nextNum = 0;

        for(Integer x : nums) {
            if (x == nextNum){
                System.out.println(x + " is not unique!");
            } else {
                nextNum = x;
            }
        }
    }

    private static void handleDuplicates(Set<Integer> uniqueNums) {
        for (Integer x : uniqueNums) {
            if (uniqueNums.contains(x)){
                System.out.println(x + " is unique!");
            }
        }
    }
}
