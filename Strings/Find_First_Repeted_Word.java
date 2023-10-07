import java.util.HashSet;
public class Find_First_Repeted_Word {
    // returns first repeated word
    static String findFirstRepeated(String s)
    {
        // break string into tokens
        String token[] = s.split(" ");
         
        // hashset for storing words 
        HashSet<String> set = new HashSet<String>();
         
        // store the words of string in hashset
        for(int i=0; i<token.length; i++){
             
            // if word exists return
            if(set.contains(token[i])){
                return token[i];
            }
             
            // insert new word to set
            set.add(token[i]);
        }
     
        return "NoRepetition";
    }
     
    // driver program
    public static void main(String args[])
    {
        String s = "Ravi had been saying that he had been there";
        String firstWord = findFirstRepeated(s);
        if (!firstWord.equals("NoRepetition"))
            System.out.println("First repeated word :: " + firstWord);
        else
            System.out.println("No Repetitionn");
    }
}