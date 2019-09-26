package data.structure;

import data.structure.list.LinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestLinkedList {

    private LinkedList<Integer> list;

    @Before
    public void setUp() {
        list = new LinkedList<Integer>();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
    }

    @Test
    public void testAddFirstElement() {
        list.addFirst(5);

        Assert.assertEquals(5, list.size());
        Assert.assertEquals(Integer.valueOf(5), list.getHead().getValue());
    }

    @Test
    public void testRemoveFirstElement() {
        list.removeFirst();

        Assert.assertEquals(3, list.size());
        Assert.assertEquals(Integer.valueOf(2), list.getHead().getValue());
    }

    @Test
    public void testRemoveLastElement() {
        list.removeLast();

        Assert.assertEquals(3, list.size());
        Assert.assertEquals(Integer.valueOf(3), list.getTail().getValue());
    }

    @Test
    public void testRemoveMiddleElement() {
        list.remove(2);

        Assert.assertEquals(3, list.size());
        Assert.assertFalse(list.contains(2));
    }

    @Test
    public void testRemoveNotExistingElement() {
        list.remove(10);

        Assert.assertEquals(4, list.size());
    }

    @Test
    public void testContains() {
        Assert.assertTrue(list.contains(1));
        Assert.assertFalse(list.contains(10));
    }

    @Test
    public void testGetSize() {
        Assert.assertEquals(4, list.size());
    }

    @Test
    public void testClear() {
        list.clear();

        Assert.assertEquals(0, list.size());
        Assert.assertNull(list.getHead());
        Assert.assertNull(list.getTail());
    }

    @Test
    public void testCopyToArray() {

        Integer[] array = new Integer[4];
        list.copyTo(array, 0);

        Integer[] expectedArray = new Integer[4];
        expectedArray[0] = 1;
        expectedArray[1] = 2;
        expectedArray[2] = 3;
        expectedArray[3] = 4;

        Assert.assertArrayEquals(expectedArray, array);
    }

    @Test
    public void testCopyToReverseArray() {

        Integer[] array = new Integer[4];
        list.copyToReverse(array, 0);

        Integer[] expectedArray = new Integer[4];
        expectedArray[0] = 4;
        expectedArray[1] = 3;
        expectedArray[2] = 2;
        expectedArray[3] = 1;

        Assert.assertArrayEquals(expectedArray, array);
    }
}
