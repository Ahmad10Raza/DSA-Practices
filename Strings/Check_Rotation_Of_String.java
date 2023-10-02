public class Check_Rotation_Of_String {
    public static boolean  checkRoation(String s1 , String goal){
        if(s1.length()!= goal.length()){
            return false;
        }
        String temp=s1+s1;
        if(temp.indexOf(goal)==-1){
            return false;
        }
        else{
            return true;
        }
    }
    public static void main(String[] args) {
        String s1="ABCD";
        String s2="CDAB";
        String s3="ACBD";
        System.out.println(checkRoation(s1,s3));
        System.out.println(checkRoation(s1,s2));
    }
}