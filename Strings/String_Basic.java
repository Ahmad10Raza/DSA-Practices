import java.util.*;
public class String_Basic
{
  public static void String_Creating()
  {
    String s1="This string Testing_01";//value is same for s3 you know na memory fanda..
        String s2=new String("Using new Keyword");
        String s3="This string Testing_01";

    System.out.println(s1);
    System.out.println(s2);
    System.out.println(s3);

  }
  public static void String_Input()
  {
    Scanner sc=new Scanner(System.in);
    String name1,name2,name3;
System.out.print("Enter your First Name :");
    name1=sc.next();
    System.out.print("Enter your Surname Name :");
    name2=sc.next();
    System.out.println("Enter your Full Name :");
 name3=sc.next();
System.out.println(" your First Name is :"+name1);
System.out.println(" your Last Name is :"+name2);
System.out.println(" your Full Name is :"+name3);

    }
    public static void Palindrome_String()
    {
      String x, y = "";
             Scanner a = new Scanner(System.in);
            System.out.print("Enter  string you want to check:");
           x = a.nextLine();
              int l = x.length();
             for(int k = l - 1; k >= 0; k--)
           {
                y = y + x.charAt(k);
            }
            if(x.equalsIgnoreCase(y))
              {
                  System.out.println("The string is palindrome.");
              }
              else
              {
                  System. out.println("The string is not a palindrome.");
              }
          }

public  static void Substring()
{
  String substr="";
  Scanner IND=new Scanner(System.in);
  System.out.print("Enter the String:.. ");
  String str=IND.nextLine();
  System.out.print("Enter starting and Ending idex:...");
  int si=IND.nextInt();
  int ei=IND.nextInt();
  for (int i=si;i<ei ;i++ )
   {
    substr+=str.charAt(i);
  }
  System.out.print("The Substring are ..." +substr);
}
public static void String_Compare()
{
  Scanner IND=new Scanner(System.in);
  System.out.print("Enter the string_01:..");
  String s1=IND.nextLine();
  System.out.print("Enter the string_02:..");
  String s2=IND.nextLine();
  System.out.print("Enter the string_03:..");
  String s3=IND.nextLine();
if(s1==s2)
{
  System.out.print("String S1 and S2 are equal...");
}
System.out.print(s1.equals(s2));
System.out.print(s1.equals(s3));
System.out.print(s1.equalsIgnoreCase(s2));
System.out.print(s1.equalsIgnoreCase(s3));

}
  public static void main(String[] args)
  {
//String_Creating();
//String_Input();
//Palindrome_String();
//Substring();
String_Compare();
  }
}
