package structure;

import linkedlist.LinkedList;
import org.junit.Assert;
import org.junit.Test;

public class TestLinkedList {

    @Test
    public void testAddElements() {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(5);

        Assert.assertEquals(3, linkedList.size());
        Assert.assertTrue(linkedList.contains(1));
        Assert.assertTrue(linkedList.contains(2));
        Assert.assertTrue(linkedList.contains(5));
    }

    @Test
    public void testRemoveFirstElement() {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(5);
        linkedList.add(7);

        linkedList.remove(1);

        Integer[] array = new Integer[3];
        linkedList.copyTo(array, 0);

        Integer[] expectedArray = new Integer[3];
        expectedArray[0] = 2;
        expectedArray[1] = 5;
        expectedArray[2] = 7;

        Assert.assertEquals(3, linkedList.size());
        Assert.assertArrayEquals(expectedArray, array);
    }

    @Test
    public void testRemoveMiddleElement() {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(5);
        linkedList.add(7);

        linkedList.remove(2);

        Integer[] array = new Integer[3];
        linkedList.copyTo(array, 0);

        Integer[] expectedArray = new Integer[3];
        expectedArray[0] = 1;
        expectedArray[1] = 5;
        expectedArray[2] = 7;

        Assert.assertEquals(3, linkedList.size());
        Assert.assertArrayEquals(expectedArray, array);
    }

    @Test
    public void testRemoveLastElement() {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(5);
        linkedList.add(7);

        linkedList.remove(7);

        Integer[] array = new Integer[3];
        linkedList.copyTo(array, 0);

        Integer[] expectedArray = new Integer[3];
        expectedArray[0] = 1;
        expectedArray[1] = 2;
        expectedArray[2] = 5;

        Assert.assertEquals(3, linkedList.size());
        Assert.assertArrayEquals(expectedArray, array);
    }

    @Test
    public void testRemoveNotExistingElement() {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(5);
        linkedList.add(7);

        linkedList.remove(9);

        Integer[] array = new Integer[4];
        linkedList.copyTo(array, 0);

        Integer[] expectedArray = new Integer[4];
        expectedArray[0] = 1;
        expectedArray[1] = 2;
        expectedArray[2] = 5;
        expectedArray[3] = 7;

        Assert.assertEquals(4, linkedList.size());
        Assert.assertArrayEquals(expectedArray, array);
    }

    @Test
    public void testContains() {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(5);

        Assert.assertEquals(true, linkedList.contains(2));
        Assert.assertEquals(false, linkedList.contains(7));
    }

    @Test
    public void testClear() {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(5);

        linkedList.clear();
        Assert.assertEquals(0, linkedList.size());
    }

    @Test
    public void testCopyToArray() {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(5);


        Integer[] array = new Integer[3];
        linkedList.copyTo(array, 0);

        Integer[] expectedArray = new Integer[3];
        expectedArray[0] = 1;
        expectedArray[1] = 2;
        expectedArray[2] = 5;

        Assert.assertEquals(3, linkedList.size());
        Assert.assertArrayEquals(expectedArray, array);
    }

    @Test
    public void testGetSize() {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(5);
        
        Assert.assertEquals(3, linkedList.size());
    }
}
