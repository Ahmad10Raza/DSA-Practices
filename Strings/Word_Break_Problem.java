import java.util.HashSet;
import java.util.Set;
public class Word_Break_Problem {
    public static boolean WordBreakProblem(String str){
        int size=str.length();

        //base case
        if(size==0){
            return true;
        }

        for(int i=1;i<=size;i++){

            // Now we will first divide the word into two parts ,
            // the prefix will have a length of i and check if it is 
            // present in dictionary ,if yes then we will check for 
            // suffix of length size-i recursively. if both prefix and 
            // suffix are present the word is found in dictionary.
            if(dictionary.contains(str.substring(0,i)) && WordBreakProblem(str.substring(i,size))){ 
                return true;
            }
        }
        return false;

    }
private static Set<String> dictionary = new HashSet<>();

    public static void main(String[] args) {
        dictionary.add("I");
        dictionary.add("like");
        dictionary.add("had");
        dictionary.add("play");
        dictionary.add("to");
        dictionary.add("a");

        String str="Ihadliketoplay";
        System.out.println(WordBreakProblem(str));
    }
}