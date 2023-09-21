import java.util.HashMap;

public class Majority_Element {
    public static int Moore_Voting(int nums[]) {
        int major = nums[0];
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == major) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                major = num;
                count = 1;
            }
        }
        return major;
    }

    public static void findMajority_Hashmap(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                int count = map.get(arr[i]) + 1;
                if (count > arr.length / 2) {
                    System.out.println("Majority found :- " + arr[i]);
                    return;
                } else
                    map.put(arr[i], count);

            } else
                map.put(arr[i], 1);
        }
        System.out.println(" No Majority element");
    }

//     public static int printMajority(int arr[]) {
//         int majElement = arr[0], majCount = 1;
//         for (int i = 1; i < arr.length; i++) {
//         }
//         if (arr[i] == majElement) {
//             majCount++;
//         } else {
//             majCount--;
//             if (majCount == 0) {
//                 majElement = arr[i];
//                 majCount = 1;
//             }
//         }
//     return majElement;

// }

    public static void main(String[] args) {
        int[] a = { 3, 1, 2, 2, 2, 5, 4, 6, 2, 2 };
        int ans = Moore_Voting(a);
        System.out.println("The majority element is: " + ans);
        findMajority_Hashmap(a);

    }
}
