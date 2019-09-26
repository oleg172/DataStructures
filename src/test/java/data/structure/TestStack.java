package data.structure;

import data.structure.stack.Stack;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestStack {

    private Stack<Integer> stack;

    @Before
    public void setUp() {
        stack = new Stack<Integer>();
        stack.push(0);
        stack.push(1);
    }

    @Test
    public void testPush() {
        stack.push(2);
        Assert.assertEquals(3, stack.size());
        Assert.assertEquals(Integer.valueOf(2), stack.pop());
        Assert.assertEquals(Integer.valueOf(1), stack.pop());
        Assert.assertEquals(Integer.valueOf(0), stack.pop());
    }

    @Test
    public void testPop() {
        Assert.assertEquals(2, stack.size());
        Assert.assertEquals(Integer.valueOf(1), stack.pop());
        Assert.assertEquals(Integer.valueOf(0), stack.pop());
    }

    @Test(expected = IllegalStateException.class)
    public void testPopEmptyStack() {
        stack = new Stack<Integer>();
        stack.pop();
    }

    @Test
    public void testPeek() {
        Assert.assertEquals(Integer.valueOf(1), stack.peek());
        Assert.assertEquals(2, stack.size());
    }

    @Test(expected = IllegalStateException.class)
    public void testPeekEmptyStack() {
        stack = new Stack<Integer>();
        stack.peek();
    }

    @Test
    public void testSize() {
        Assert.assertEquals(2, stack.size());
    }
}
