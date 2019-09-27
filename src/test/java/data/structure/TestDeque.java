package data.structure;

import data.structure.queue.Deque;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestDeque {

    private Deque<Integer> deque;

    @Before
    public void setUp() {
        deque = new Deque<Integer>();
        deque.enqueueLast(0);
        deque.enqueueLast(1);
    }

    @Test
    public void testEnqueueFirst() {
        deque.enqueueFirst(2);
        Assert.assertEquals(3, deque.size());
        Assert.assertEquals(Integer.valueOf(2), deque.dequeueFirst());
        Assert.assertEquals(Integer.valueOf(0), deque.dequeueFirst());
        Assert.assertEquals(Integer.valueOf(1), deque.dequeueFirst());
    }

    @Test
    public void testEnqueueLast() {
        deque.enqueueLast(2);
        Assert.assertEquals(3, deque.size());
        Assert.assertEquals(Integer.valueOf(2), deque.dequeueLast());
        Assert.assertEquals(Integer.valueOf(1), deque.dequeueLast());
        Assert.assertEquals(Integer.valueOf(0), deque.dequeueLast());
    }

    @Test
    public void testDequeueFirst() {
        deque.dequeueFirst();
        Assert.assertEquals(1, deque.size());
        Assert.assertEquals(Integer.valueOf(1), deque.dequeueFirst());
    }

    @Test(expected = IllegalStateException.class)
    public void testDequeueFirstEmptyQueue() {
        deque = new Deque<Integer>();
        deque.dequeueFirst();
    }

    @Test
    public void testDequeueLast() {
        deque.dequeueLast();
        Assert.assertEquals(1, deque.size());
        Assert.assertEquals(Integer.valueOf(0), deque.dequeueLast());
    }

    @Test(expected = IllegalStateException.class)
    public void testDequeueLastEmptyQueue() {
        deque = new Deque<Integer>();
        deque.dequeueLast();
    }

    @Test
    public void testPeekFirst() {
        Assert.assertEquals(Integer.valueOf(0), deque.peekFirst());
        Assert.assertEquals(2, deque.size());
    }

    @Test(expected = IllegalStateException.class)
    public void testPeekFirstEmptyQueue() {
        deque = new Deque<Integer>();
        deque.peekFirst();
    }

    @Test
    public void testPeekLast() {
        Assert.assertEquals(Integer.valueOf(1), deque.peekLast());
        Assert.assertEquals(2, deque.size());
    }

    @Test(expected = IllegalStateException.class)
    public void testPeekLastEmptyQueue() {
        deque = new Deque<Integer>();
        deque.peekLast();
    }

    @Test
    public void testSize(){
        Assert.assertEquals(2, deque.size());
    }
}
