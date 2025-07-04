import org.junit.Test;
import static org.junit.Assert.*;

public class StackifiedQueueTest {

    @Test
    public void testAddAndPoll() {
        StackifiedQueue<Integer> queue = new StackifiedQueue<>();
        
        // adding elements to the queue
        queue.add(4);
        queue.add(6);
        queue.add(11);

        // Check whether the elements are polled in FIFO order
        assertEquals((Integer) 4, queue.poll());
        assertEquals((Integer) 6, queue.poll());
        assertEquals((Integer) 11, queue.poll());
    }

    @Test
    public void testPollEmptyQueue() {
        StackifiedQueue<String> queue = new StackifiedQueue<>();
        assertNull(queue.poll()); // should return null when the queue is empty
    }

    @Test
    public void testPeek() {
        StackifiedQueue<String> queue = new StackifiedQueue<>();
        queue.add("23");
        queue.add("99");
        
        // Check peek at the front element
        assertEquals("23", queue.peek());  // expect "23"
        
        assertEquals("23", queue.poll());  // This should also check "23"
    }

    @Test
    public void testPeekEmptyQueue() {
        StackifiedQueue<Double> queue = new StackifiedQueue<>();
        assertNull(queue.peek()); 
    }

    @Test
    public void testIsEmpty() {
        StackifiedQueue<Boolean> queue = new StackifiedQueue<>();
        assertTrue(queue.isEmpty());
        
        queue.add(true);
        assertFalse(queue.isEmpty());
        
        queue.poll();
        assertTrue(queue.isEmpty());
    }
}
