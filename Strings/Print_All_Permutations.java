public class Print_All_Permutations {
    public static void permute(String str,int index){
        if(index==str.length()){
            System.out.println(str);
            return;
        }
        // iterate over the string
        for(int i=index;i<str.length();i++){ 
            str = swap(str,index,i); // swap the characters at index and i
            permute(str,index+1); // call the function recursively
            str = swap(str,index,i); // backtrack to the original string
        }

    }
    public static String swap(String str,int i,int j){
        char[] arr = str.toCharArray(); // convert the string to char array
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return String.valueOf(arr); // convert the char array to string
    }
    public static void main(String[] args) {
        String str = "ABC";
        permute(str,0);
    }
}