import java.util.HashSet;

public class Permutation_of_String {
    public static void permutation(String str,int start,int end)
    {
        //checking starting index and ending index are same
        if(start==end-1)
        
            // //check permutation is uinqe or not
            // if(isUnique_Permutation(str)){
            //     System.out.println(str);
            
            // }
        System.out.println(str);
        
        //code to find permutation
        else{
            //loop for travese string to cerate permutation
            for(int i=start;i<end;i++){
                //call recursivly swap function to create permutation
                str=Swap(str,start,i);
                //now call recursivly permuation function to make perumation of next 
                permutation(str, start+1, end);
                //swap word of next permutation
                str=Swap(str,start,i);
            }
        }
      }
    
    
    //Creating swap function to swap the word
    public static String Swap(String str,int i,int j){
        char temp;
        char[]  charArray=str.toCharArray();
        temp=charArray[i];
        charArray[i]=charArray[j];
        charArray[j]=temp;
        //return this wap character as string 
        return String.valueOf(charArray);
    }

//     //Now let's create isUnique_Permutation function to check permutation is uniqe or not
//     public static  boolean isUnique_Permutation(String str){
//         //Creating Hashset to store all the permutation
//         HashSet<String> set=new HashSet<>(); 
//         //add those permutation to unique set above we crteated
//         set.add(str);
//         //let check set have permuation word or not
//         if(set.contains(str))
//         {
//             return false;
//         }
// //set not conatine perm_word mean is unique
//         return true;
//     }
    //creating main method
    public static void main(String[] args) {
        String str="ABC";
        int n=str.length();
        //creating string object
        permutation(str, 0, n);
    }
}
