package data.structure;

import data.structure.queue.DequeByArray;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestDequeueByArray {

    DequeByArray<Integer> deque;

    @Before
    public void setUp() {
        deque = new DequeByArray<Integer>();
        deque.enqueueLast(0);
        deque.enqueueLast(1);
    }

    @Test
    public void testEnqueueFirst() {
        deque.enqueueFirst(2);
        Assert.assertEquals(3, deque.size());
        Assert.assertEquals(Integer.valueOf(2), deque.peekFirst());
    }

    @Test
    public void testEnqueueLast() {
        deque.enqueueLast(2);
        Assert.assertEquals(3, deque.size());
        Assert.assertEquals(Integer.valueOf(2), deque.peekLast());
    }

    @Test
    public void testDequeueFirst() {
        Assert.assertEquals(Integer.valueOf(0), deque.dequeueFirst());
        Assert.assertEquals(1, deque.size());
    }

    @Test(expected = IllegalStateException.class)
    public void testDequeueFirstEmptyQueue() {
        deque = new DequeByArray<Integer>();
        deque.dequeueFirst();
    }

    @Test
    public void testDequeueLast() {
        Assert.assertEquals(Integer.valueOf(1), deque.dequeueLast());
        Assert.assertEquals(1, deque.size());
    }

    @Test(expected = IllegalStateException.class)
    public void testDequeueLastEmptyQueue() {
        deque = new DequeByArray<Integer>();
        deque.dequeueLast();
    }

    @Test
    public void testPeekFirst() {
        Assert.assertEquals(Integer.valueOf(0), deque.peekFirst());
        Assert.assertEquals(2, deque.size());
    }

    @Test(expected = IllegalStateException.class)
    public void testPeekFirstEmptyQueue() {
        deque = new DequeByArray<Integer>();
        deque.peekFirst();
    }

    @Test
    public void testPeekLast() {
        Assert.assertEquals(Integer.valueOf(1), deque.peekLast());
        Assert.assertEquals(2, deque.size());
    }

    @Test(expected = IllegalStateException.class)
    public void testPeekLastEmptyQueue() {
        deque = new DequeByArray<Integer>();
        deque.peekLast();
    }

    @Test
    public void testSize() {
        Assert.assertEquals(2, deque.size());
    }

}
