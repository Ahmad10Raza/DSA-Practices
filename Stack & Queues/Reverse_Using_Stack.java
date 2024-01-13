import java.util.*;
public class Reverse_Using_Stack {
    public static String Reverse(String str)
    {
        Stack <Character> s=new Stack<>();
int idx=0;
while(idx<str.length())
{
    s.push(str.charAt(idx));
    idx++;
}
StringBuilder result=new StringBuilder("");
while(!s.isEmpty())
{
    char curr=s.pop();
    result.append(curr);
}
return str=result.toString();

    }
    public static void main(String[] args) {
        Scanner IND=new Scanner(System.in);
        System.out.print("Enter the String: ");
        String str=IND.nextLine();
        String r=Reverse(str);
        System.out.println("Revserse is : "+r);
        IND.close();
    }
}
