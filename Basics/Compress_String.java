import java.util.*;
public class Compress_String
{
  public static void main(String[] args)
   {
    Scanner IND=new Scanner(System.in);
    System.out.print("Enter the string for Compression: ");
    String str=IND.nextLine();
    IND.close();
    String newstr="";
    for(int i=0;i<str.length();i++)
    {
      Integer count=1;
      while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1))
      {
        count++;
        i++;
      }
      newstr+=str.charAt(i);
      if(count>1)
      {
      newstr+=count.toString();
        }
  }
  System.out.print(newstr);
}
}
