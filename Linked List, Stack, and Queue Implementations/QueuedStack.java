import java.util.LinkedList;
import java.util.Queue;
import java.util.EmptyStackException;

public class QueuedStack<T> {

    private Queue<T> queue;

    // Constructor
    public QueuedStack() {
        this.queue = new LinkedList<>();
    }

    // method for pushing an element onto the stack
    public T push(T element) {
        // add the element to the queue
        queue.add(element);

        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            queue.add(queue.remove()); // this mooves elements to the back
        }
        
        return element;
    }

    // Pop the top element 
    public T pop() {
        if (queue.isEmpty()) {
            throw new EmptyStackException();
        }
        return queue.remove(); 
    }

    
    // method to peek at the top element without removing it from stack
    public T peek() {
        if (queue.isEmpty()) {
            throw new EmptyStackException();
        }
        return queue.peek(); 
    }

    // method to check if stack is empty
    public boolean empty() {
        return queue.isEmpty();
    }
}
