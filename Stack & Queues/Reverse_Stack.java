import java.util.*;
public class Reverse_Stack {
    public static void Push_at_Bottom(Stack <Integer> s,int data) 
    {
 if(s.isEmpty())
 {
 s.push(data);
 return;
 }
 int top=s.pop();
 Push_at_Bottom(s, data);
 s.push(top);

 }
    public static void Reverse(Stack <Integer> s)
    {
if(!s.isEmpty())            
{
    return;
}
    int top=s.pop();
Reverse(s);
Push_at_Bottom(s,top);
    }
   
 public static void print_Stack( Stack <Integer> s)
 {
    while(!s.isEmpty())
    {
        System.out.println(s.pop());
    }
 }
    public static void main(String[] args) {
        Stack <Integer> s=new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        Reverse(s);
        print_Stack(s);

    }
}
