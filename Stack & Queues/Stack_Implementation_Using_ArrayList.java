import java.util.ArrayList;

public class Stack_Implementation_Using_ArrayList {
    private ArrayList<Integer> stackList;

    public Stack() {
        stackList = new ArrayList<Integer>();
    }

    public void push(int value) {
        stackList.add(value);
    }

    public int pop() {
        if (!isEmpty()) {
            return stackList.remove(stackList.size() - 1);
        } else {
            System.out.println("The stack is empty");
            return -1;
        }
    }

    public boolean isEmpty() {
        return stackList.isEmpty();
    }

    public int size() {
        return stackList.size();
    }

    public int peek() {
        if (!isEmpty()) {
            return stackList.get(stackList.size() - 1);
        } else {
            System.out.println("The stack is empty");
            return -1;
        }
    }



    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Size of stack: " + stack.size());

        System.out.println("Top element: " + stack.peek());

        System.out.println("Pop element: " + stack.pop());

        System.out.println("Size of stack after pop: " + stack.size());
    
}
}