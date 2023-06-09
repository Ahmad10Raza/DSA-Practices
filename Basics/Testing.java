import java.util.Scanner;

public class Testing {
public static void main(String[] args) {
Scanner IND= new Scanner(System.in);
String str=IND.nextLine();
IND.close();
String newstr="";
for(int i=0;i<str.length()-1;i++){
    Integer count=1;
    while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
        count++;
        i++;
    }
    newstr+=str.charAt(i);
    if(count>1){
        newstr+=count.toString();
    }
}
System.out.println(newstr);
}
}
