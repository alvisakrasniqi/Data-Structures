import org.junit.Test;
import static org.junit.Assert.*;
import java.util.EmptyStackException;

public class QueuedStackTest {

    @Test
    public void testPushAndPop() {
        QueuedStack<Integer> stack = new QueuedStack<>();
        
        // push elements
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // see if they are popped in LIFO order
        assertEquals((Integer) 30, stack.pop());
        assertEquals((Integer) 20, stack.pop());
        assertEquals((Integer) 10, stack.pop());
    }

    @Test(expected = EmptyStackException.class)
    public void testPopEmptyStack() {
        QueuedStack<String> stack = new QueuedStack<>();
        stack.pop(); //  throws EmptyStackException
    }

    @Test
    public void testPeek() {
        QueuedStack<String> stack = new QueuedStack<>();
        stack.push("X");
        stack.push("Y");
        
        //check the peek of element at the top
        assertEquals("Y", stack.peek());
        
        // check the top element was not removed
        assertEquals("Y", stack.pop());
    }

    @Test(expected = EmptyStackException.class)
    public void testPeekEmptyStack() {
        QueuedStack<Double> stack = new QueuedStack<>();
        stack.peek(); // expect to throw EmptyStackException
    }

    @Test
    public void testEmpty() {
        QueuedStack<Boolean> stack = new QueuedStack<>();
        assertTrue(stack.empty());
        
        stack.push(true);
        assertFalse(stack.empty());
        
        stack.pop();
        assertTrue(stack.empty());
    }

    @Test
    public void testMultipleDataTypes() {
        QueuedStack<Object> stack = new QueuedStack<>();
        stack.push("Alvisa");
        stack.push(9);
        stack.push(3.99);
        
        assertEquals(3.99, stack.pop());
        assertEquals(9, stack.pop());
        assertEquals("Alvisa", stack.pop());
    }
}
