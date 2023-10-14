import java.util.Vector;
public class Min_Swap_To_Brackets_Balance {
    // Function to calculate swaps required
    static int swapCount(String s) {
         
        //To store answer
        int ans = 0;
         
        //To store count of '['
        int count = 0;
         
        //Size of string
        int n = s.length();
         
        //Traverse over the string
        for (int i = 0; i < n; i++) {
            //When '[' encounters
            if (s.charAt(i) == '[')
                count++;
            //when ']' encounters
            else
                count--;
            //When count becomes less than 0
            if (count < 0) {
                //Start searching for '[' from (i+1)th index
                int j = i + 1;
                while (j < n) {
                    //When jth index contains '['
                    if (s.charAt(j) == '[')
                        break;
                    j++;
                }
                 
                //Increment answer
                ans += j - i;
                 
                //Set Count to 1 again
                count = 1;
                 
                //Bring character at jth position to ith position
                //and shift all character from i to j-1 
                //towards right 
                char ch = s.charAt(j);
                StringBuilder newString = new StringBuilder(s);
                for (int k = j; k > i; k--) {
                    newString.setCharAt(k, s.charAt(k - 1));
                }
                newString.setCharAt(i, ch);
                s = newString.toString();
            }
        }
 
        return ans;
    }
    
         
// Function to calculate swaps required
public static long swapCount_Optimized(String s)
{
     
    // Keep track of '['
    Vector<Integer> pos = new Vector<Integer>(); 
    for(int i = 0; i < s.length(); ++i)
        if (s.charAt(i) == '[')
            pos.add(i);
             
    // To count number of encountered '['
    int count = 0; 
     
    // To track position of next '[' in pos
    int p = 0;  
     
    // To store result
    long sum = 0; 
     
    char[] S = s.toCharArray(); 
     
    for(int i = 0; i < s.length(); ++i)
    {
         
        // Increment count and move p 
        // to next position
        if (S[i] == '[')
        {
            ++count;
            ++p;
        }
        else if (S[i] == ']')
            --count;
  
        // We have encountered an 
        // unbalanced part of string
        if (count < 0)
        {
             
            // Increment sum by number of 
            // swaps required i.e. position 
            // of next '[' - current position
            sum += pos.get(p) - i;
            char temp = S[i];
            S[i] = S[pos.get(p)];
            S[pos.get(p)] = temp;
            ++p;
  
            // Reset count to 1
            count = 1;
        }
    }
    return sum;
}



    // Driver code
    public static void main(String[] args) {
        String s = "[]][][";
        System.out.println(swapCount(s));
 
        s = "[[][]]";
        System.out.println(swapCount(s));
        System.out.println(swapCount_Optimized(s));
        
    }
}