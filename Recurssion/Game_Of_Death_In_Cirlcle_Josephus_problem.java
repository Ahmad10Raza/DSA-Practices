public class Game_Of_Death_In_Cirlcle_Josephus_problem {
    public static void main(String[] args) {
        int n = 40;
        int k = 7;
        System.out.println(josephus(n, k));
        System.out.println(josephus_problem(n, k));
    }
    public static int josephus(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return (josephus(n - 1, k) + k) % n;
    }



    // Base Case: If there is only one person (n == 1), they are the survivor, and their position is 1. This serves as the base case for the recursion.

    // Recursive Case: If there are more than one person (n > 1), the function proceeds to the recursive case:
    
    // It recursively calls josephus with a smaller circle (n - 1 people) to find the position of the survivor in the smaller group.
    // It then adds k - 1 to the result of the recursive call to account for the counting interval.
    // Finally, it takes the result modulo n (to handle the wrap-around in the circle) and adds 1 to the result to ensure that positions are numbered from 1 to n.
    
    // The result of this calculation is the position of the survivor in the original circle of n people.
    public static int josephus_problem(int n, int k) {
        // Base case: If there is only one person, they are the survivor.
        if (n == 1) {
            return 1;
        } else {
            // Recursively find the position of the survivor in a smaller circle.
            return (josephus(n - 1, k) + k - 1) % n + 1;
        }
    }

}