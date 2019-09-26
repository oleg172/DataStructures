package data.structure;

import data.structure.list.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestList {

    private List<Integer> list;

    @Before
    public void setUp() {

        list = new List<Integer>();
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(7);
    }

    @Test
    public void testAddElements() {

        list.add(8);

        Assert.assertEquals(5, list.size());
        Assert.assertTrue(list.contains(1));
        Assert.assertTrue(list.contains(2));
        Assert.assertTrue(list.contains(5));
        Assert.assertTrue(list.contains(7));
        Assert.assertTrue(list.contains(8));
    }

    @Test
    public void testRemoveFirstElement() {

        list.remove(1);

        Integer[] array = new Integer[3];
        list.copyTo(array, 0);

        Integer[] expectedArray = new Integer[3];
        expectedArray[0] = 2;
        expectedArray[1] = 5;
        expectedArray[2] = 7;

        Assert.assertEquals(3, list.size());
        Assert.assertArrayEquals(expectedArray, array);
    }

    @Test
    public void testRemoveMiddleElement() {

        list.remove(2);

        Integer[] array = new Integer[3];
        list.copyTo(array, 0);

        Integer[] expectedArray = new Integer[3];
        expectedArray[0] = 1;
        expectedArray[1] = 5;
        expectedArray[2] = 7;

        Assert.assertEquals(3, list.size());
        Assert.assertArrayEquals(expectedArray, array);
    }

    @Test
    public void testRemoveLastElement() {

        list.remove(7);

        Integer[] array = new Integer[3];
        list.copyTo(array, 0);

        Integer[] expectedArray = new Integer[3];
        expectedArray[0] = 1;
        expectedArray[1] = 2;
        expectedArray[2] = 5;

        Assert.assertEquals(3, list.size());
        Assert.assertArrayEquals(expectedArray, array);
    }

    @Test
    public void testRemoveNotExistingElement() {

        list.remove(9);

        Integer[] array = new Integer[4];
        list.copyTo(array, 0);

        Integer[] expectedArray = new Integer[4];
        expectedArray[0] = 1;
        expectedArray[1] = 2;
        expectedArray[2] = 5;
        expectedArray[3] = 7;

        Assert.assertEquals(4, list.size());
        Assert.assertArrayEquals(expectedArray, array);
    }

    @Test
    public void testContains() {

        Assert.assertTrue(list.contains(2));
        Assert.assertFalse(list.contains(8));
    }

    @Test
    public void testCopyToArray() {

        Integer[] array = new Integer[4];
        list.copyTo(array, 0);

        Integer[] expectedArray = new Integer[4];
        expectedArray[0] = 1;
        expectedArray[1] = 2;
        expectedArray[2] = 5;
        expectedArray[3] = 7;

        Assert.assertEquals(4, list.size());
        Assert.assertArrayEquals(expectedArray, array);
    }

    @Test
    public void testGetSize() {
        Assert.assertEquals(4, list.size());
    }

    @Test
    public void testClear() {

        list.clear();
        Assert.assertEquals(0, list.size());
    }
}
