import java.util.HashMap;
import java.util.Map;

public class Find_Duplicate_Character {
    public static void main(String[] args) {
        String input = "programming";

        // Method 1: Using a HashMap to count character occurrences
        findDuplicatesUsingHashMap(input);

        // Method 2: Using an array to count character occurrences
        findDuplicatesUsingArray(input);
    }

    // Method 1: Using a HashMap to count character occurrences
    public static void findDuplicatesUsingHashMap(String input) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        
        for (char c : input.toCharArray()) {
            // Increment count in the map for each character
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        System.out.println("Method 1: Using HashMap");
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("'" + entry.getKey() + "' is repeated " + entry.getValue() + " times.");
            }
        }
    }

    // Method 2: Using an array to count character occurrences
    public static void findDuplicatesUsingArray(String input) {
        int[] charCount = new int[256]; // Assuming ASCII characters
        
        for (char c : input.toCharArray()) {
            // Increment count in the array for each character
            charCount[c]++;
        }

        System.out.println("\nMethod 2: Using Array");
        for (int i = 0; i < 256; i++) {
            if (charCount[i] > 1) {
                System.out.println("'" + (char) i + "' is repeated " + charCount[i] + " times.");
            }
        }
    }
}
