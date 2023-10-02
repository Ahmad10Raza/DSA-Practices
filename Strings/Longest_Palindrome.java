public class Longest_Palindrome {
    public static String palindrome(String s){
    int start=0,end=0;
    for(int i=1;i<s.length();i++){
        int low=i-1,high=i;
 //even length
        while(low>=0 && high<s.length() && s.charAt(low)==s.charAt(high)){ //check if the characters are equal or not 
            if(high-low+1>end){ //if the length of the substring is greater than the previous substring then update the start and end
                start=low; //update the start
                end=high-low+1; //update the end
            }
            low--; //decrement the low
            high++; //increment the high
        }

        // odd length
        low=i-1;
        high=i+1;
        while(low>=0 && high<s.length() && s.charAt(low)==s.charAt(high)){ //check if the characters are equal or not 
            if(high-low+1>end){ //if the length of the substring is greater than the previous substring then update the start and end
                start=low;
                end=high-low+1;
            }
            low--;
            high++;
        }
    }
    return s.substring(start,start+end); //substring(start,end) end is exclusive so we add 1 to end 

    }
    public static void main(String[] args) {
        String s="babad";
        System.out.println(palindrome(s));
    }
}