package data.structure;

import data.structure.arrayList.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestArrayList {

    private ArrayList<Integer> list;

    @Before
    public void setUp() {
        list = new ArrayList<Integer>(4);
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(2);
    }

    @Test
    public void testDefaultInitialization() {
        list = new ArrayList<Integer>();
        Assert.assertEquals(0, list.getSize());
        Assert.assertEquals(0, list.toArray().length);
    }

    @Test
    public void testInitialization() {
        list = new ArrayList<Integer>(10);
        Assert.assertEquals(0, list.getSize());
        Assert.assertEquals(10, list.toArray().length);
    }

    @Test
    public void testInsertInPosition() {
        list = new ArrayList<Integer>(2);
        list.insert(0, 1);
        list.insert(1, 2);
        Assert.assertEquals(2, list.getSize());
        Assert.assertEquals(Integer.valueOf(1), list.getElement(0));
        Assert.assertEquals(Integer.valueOf(2), list.getElement(1));
    }

    @Test
    public void testInsertInPositionShift() {
        list = new ArrayList<Integer>(2);
        list.insert(0, 1);
        list.insert(1, 2);
        list.insert(0, 3);
        Assert.assertEquals(3, list.getSize());
        Assert.assertEquals(Integer.valueOf(3), list.getElement(0));
        Assert.assertEquals(Integer.valueOf(1), list.getElement(1));
        Assert.assertEquals(Integer.valueOf(2), list.getElement(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsertThrowException() {
        list.insert(5, 1);
    }

    @Test
    public void testAdd() {
        list = new ArrayList<Integer>(2);
        list.add(0);
        list.add(1);
        Assert.assertEquals(2, list.getSize());
        Assert.assertEquals(Integer.valueOf(0), list.getElement(0));
        Assert.assertEquals(Integer.valueOf(1), list.getElement(1));
    }

    @Test
    public void testRemoveAt() {
        list.removeAt(1);
        Assert.assertEquals(3, list.getSize());
        Assert.assertEquals(Integer.valueOf(0), list.getElement(0));
        Assert.assertEquals(Integer.valueOf(0), list.getElement(1));
        Assert.assertEquals(Integer.valueOf(2), list.getElement(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveAtException() {
        list.removeAt(4);
    }

    @Test
    public void testRemoveFirstEqualsObject() {
        boolean isRemove = list.remove(0);
        Assert.assertTrue(isRemove);
        Assert.assertEquals(3, list.getSize());
        Assert.assertEquals(Integer.valueOf(1), list.getElement(0));
        Assert.assertEquals(Integer.valueOf(0), list.getElement(1));
        Assert.assertEquals(Integer.valueOf(2), list.getElement(2));
    }

    @Test
    public void testRemoveNonExistenObject() {
        boolean isRemove = list.remove(5);
        Assert.assertFalse(isRemove);
        Assert.assertEquals(4, list.getSize());
    }

    @Test
    public void testGetIndexOfValue() {
        Assert.assertEquals(0, list.indexOf(0));
    }

    @Test
    public void testGetNonExistenObject() {
        Assert.assertEquals(-1, list.indexOf(3));
    }

    @Test
    public void testGetElement() {
        Assert.assertEquals(Integer.valueOf(1), list.getElement(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetNonExistenElement() {
        list.getElement(4);
    }

    @Test
    public void testContains() {
        Assert.assertTrue(list.contains(0));
        Assert.assertFalse(list.contains(5));
    }

    @Test
    public void testClear() {
        list.clear();
        Assert.assertEquals(0, list.getSize());
        Assert.assertEquals(0, list.toArray().length);
    }

    @Test
    public void testCopyTo() {
        Integer[] array = new Integer[4];
        list.copyTo(array, 0);
        Assert.assertEquals(Integer.valueOf(0), array[0]);
        Assert.assertEquals(Integer.valueOf(1), array[1]);
        Assert.assertEquals(Integer.valueOf(0), array[2]);
        Assert.assertEquals(Integer.valueOf(2), array[3]);
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(4, list.getSize());
    }

    @Test
    public void testToArray() {
        Object[] array = list.toArray();
        Assert.assertEquals(4, array.length);
        Assert.assertEquals(0, array[0]);
        Assert.assertEquals(1, array[1]);
        Assert.assertEquals(0, array[2]);
        Assert.assertEquals(2, array[3]);

    }
}
