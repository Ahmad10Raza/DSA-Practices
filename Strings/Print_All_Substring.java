public class Print_All_Substring {
    public static void printSubsequences(String input) {
        printSubsequencesRecursive(input, "");
    }

    private static void printSubsequencesRecursive(String remaining, String current) {
        if (remaining.isEmpty()) {
            System.out.println(current);
            return;
        }

        // Include the first character of the remaining string
        printSubsequencesRecursive(remaining.substring(1), current + remaining.charAt(0));

        // Exclude the first character of the remaining string
        printSubsequencesRecursive(remaining.substring(1), current);
    }


    public static void main(String[] args) {
        String input = "abc";
        System.out.println("Subsequences of \"" + input + "\":");
        printSubsequences(input);
    }
}
