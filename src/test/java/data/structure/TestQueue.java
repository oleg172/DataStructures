package data.structure;

import data.structure.queue.Queue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestQueue {

    private Queue<Integer> queue;

    @Before
    public void setUp() {
        queue = new Queue<Integer>();
        queue.enqueue(0);
        queue.enqueue(1);
    }

    @Test
    public void testEnqueue() {
        queue.enqueue(2);
        Assert.assertEquals(3, queue.size());
        Assert.assertEquals(Integer.valueOf(0), queue.dequeue());
        Assert.assertEquals(Integer.valueOf(1), queue.dequeue());
        Assert.assertEquals(Integer.valueOf(2), queue.dequeue());
    }

    @Test
    public void testDequeue() {
        Assert.assertEquals(Integer.valueOf(0), queue.dequeue());
        Assert.assertEquals(Integer.valueOf(1), queue.dequeue());
        Assert.assertEquals(0, queue.size());
    }

    @Test(expected = IllegalStateException.class)
    public void testDequeueEmptyQueue() {
        queue = new Queue<Integer>();
        queue.dequeue();
    }

    @Test
    public void testPeek() {
        Assert.assertEquals(Integer.valueOf(0), queue.peek());
        Assert.assertEquals(2, queue.size());
    }

    @Test(expected = IllegalStateException.class)
    public void testPeekEmptyQueue() {
        queue = new Queue<Integer>();
        queue.peek();
    }

    @Test
    public void testSize() {
        Assert.assertEquals(2, queue.size());
    }
}
