import java.util.Stack;
public class Push_at_Bottom 
{
   public static void Push_at_Bottomm(Stack<Integer> s, int data) 
   {
    if(s.isEmpty())
    {
        s.push(data);
        return;
    }
    int top = s.pop();
    Push_at_Bottomm(s, data);
    s.push(top);
   }
   
   public static void main(String[] args) {
   Stack<Integer> s = new Stack<>();
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    Push_at_Bottomm(s, 5); 
    while(!s.isEmpty())
    {
        System.out.println(s.pop());
    }
       
   }
}
