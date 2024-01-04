import java.util.*;

class Stack {
    private List<Integer> stack;

    public Stack() {
        stack = new ArrayList<>();
    }

    public void push(int element) {
        stack.add(element);
        System.out.println("Pushed: " + element);
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        int popped = stack.remove(stack.size() - 1);
        System.out.println("Popped: " + popped);
        return popped;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        int topElement = stack.get(stack.size() - 1);
        System.out.println("Top element: " + topElement);
        return topElement;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

public class StackExample {
    public static void main(String[] args) {
        // Creating a stack
        Stack stack = new Stack();

        // Performing stack operations
        stack.push(5);
        stack.push(10);
        stack.push(15);

        stack.peek();

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop(); // Trying to pop from an empty stack
    }
}
