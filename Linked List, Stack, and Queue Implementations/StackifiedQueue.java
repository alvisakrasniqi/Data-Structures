import java.util.Stack;

public class StackifiedQueue<T> {

    private Stack<T> inStack;
    private Stack<T> outStack;

    // Constructor 
    public StackifiedQueue() {
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
    }

    // method to add an element to queue
    public boolean add(T element) {
        inStack.push(element);  
        return true;  
    }

    // method to poll the front element of the queue
    public T poll() {
        if (outStack.isEmpty()) {
            if (inStack.isEmpty()) {
                return null; 
            }
            // all elements are transfered from inStack to outStack
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        //  outStack has the elements in correct order, pop from outStack
        return outStack.pop();
    }

    // method to peek at the front element 
    public T peek() {
        if (outStack.isEmpty()) {
            if (inStack.isEmpty()) {
                return null; 
            }
           
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();  
    }

    //this method checks whether the queue is empty
    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();  // if both of the stacks are emplty, then the queue shall be empty
    }
}
