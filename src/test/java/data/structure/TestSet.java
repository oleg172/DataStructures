package data.structure;

import data.structure.set.Set;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestSet {
    Set<Integer> set;

    @Before
    public void setUp() {
        set = new Set<>();
        set.add(0);
        set.add(1);
        set.add(2);
        set.add(3);
    }

    @Test
    public void testAdd() {
        set.add(4);
        Assert.assertEquals(5, set.size());
        Assert.assertTrue(set.contains(4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddExistenElement() {
        set.add(3);
    }

    @Test
    public void testRange() {
        set.addRange(Arrays.asList(4, 5));
        Assert.assertEquals(6, set.size());
        Assert.assertTrue(set.contains(4));
        Assert.assertTrue(set.contains(5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRangeExistenElement() {
        set.addRange(Arrays.asList(3, 5));
    }

    @Test
    public void testRemove() {
        Assert.assertTrue(set.remove(3));
        Assert.assertFalse(set.remove(3));
    }

    @Test
    public void testContains() {
        Assert.assertTrue(set.contains(3));
        Assert.assertFalse(set.contains(4));
    }

    @Test
    public void testSize() {
        Assert.assertEquals(4, set.size());
    }

    @Test
    public void testUnion() {
        Set<Integer> set2 = new Set<>(Arrays.asList(3, 4, 5));
        Set<Integer> unionSet = set.union(set2);
        Assert.assertEquals(6, unionSet.size());
        Assert.assertTrue(unionSet.contains(0));
        Assert.assertTrue(unionSet.contains(1));
        Assert.assertTrue(unionSet.contains(2));
        Assert.assertTrue(unionSet.contains(3));
        Assert.assertTrue(unionSet.contains(4));
        Assert.assertTrue(unionSet.contains(5));
    }

    @Test
    public void testIntersection() {
        Set<Integer> set2 = new Set<>(Arrays.asList(3, 4, 5));
        Set<Integer> intersectionSet = set.intersection(set2);
        Assert.assertEquals(1, intersectionSet.size());
        Assert.assertTrue(intersectionSet.contains(3));
    }

    @Test
    public void testDifference() {
        Set<Integer> set2 = new Set<>(Arrays.asList(3, 4, 5));
        Set<Integer> differenceSet = set.difference(set2);
        Assert.assertEquals(3, differenceSet.size());
        Assert.assertTrue(differenceSet.contains(0));
        Assert.assertTrue(differenceSet.contains(1));
        Assert.assertTrue(differenceSet.contains(2));
    }

    @Test
    public void testSymmetricDifference() {
        Set<Integer> set2 = new Set<>(Arrays.asList(3, 4, 5));
        Set<Integer> differenceSet = set.symmetricDifference(set2);
        Assert.assertEquals(5, differenceSet.size());
        Assert.assertTrue(differenceSet.contains(0));
        Assert.assertTrue(differenceSet.contains(1));
        Assert.assertTrue(differenceSet.contains(2));
        Assert.assertTrue(differenceSet.contains(4));
        Assert.assertTrue(differenceSet.contains(5));
    }

    @Test
    public void testSubset() {
        Set<Integer> set2 = new Set<>(Arrays.asList(0, 1, 2, 3, 4, 5));
        Assert.assertTrue(set.isSubset(set2));
    }

}
