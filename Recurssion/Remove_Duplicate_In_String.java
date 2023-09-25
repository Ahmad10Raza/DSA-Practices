public class Remove_Duplicate_In_String {
    public static void removeDuplicate(String str, int idx,StringBuilder newStr, boolean map[]){
        //base case
        if(idx==str.length()){
            System.out.println(newStr);
            return;
        }
        // extract current string
        char currChar=str.charAt(idx);
        //check map contain current string or not
        if(map[currChar-'a']==true){
            removeDuplicate(str,idx+1,newStr,map);
        }
        else{
        //if char not present in string then add to new string
        map[currChar-'a']=true;
        removeDuplicate(str,idx+1,newStr.append(currChar),map);
    }
}
    public static void main(String[] args){
        String str="apnacollege";
        boolean[] map=new boolean[26]; 
        removeDuplicate(str,0,new StringBuilder(""),map);

    }
}