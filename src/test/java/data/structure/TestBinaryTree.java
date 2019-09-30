package data.structure;

import data.structure.binaryTree.BinaryTree;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestBinaryTree {

    BinaryTree<Integer> tree = new BinaryTree<>();

    @Before
    public void setUp() {
        tree = new BinaryTree<>();
        tree.add(5);
        tree.add(2);
        tree.add(8);
        tree.add(7);
        tree.add(10);
        /*
         *       5
         *    2     8
         *        7   10
         * */
    }

    @Test
    public void testAdd() {
        tree.add(2);
        Assert.assertEquals(6, tree.size());
        Assert.assertTrue(tree.contains(2));
    }

    @Test
    public void testRemove() {
        Assert.assertTrue(tree.remove(5));
        Assert.assertEquals(4, tree.size());
        Assert.assertFalse(tree.contains(5));
    }

    @Test
    public void testRemoveNotPresentElement() {
        Assert.assertFalse(tree.remove(15));
        Assert.assertEquals(5, tree.size());
    }


    @Test
    public void testContains() {
        Assert.assertTrue(tree.contains(5));
        Assert.assertFalse(tree.contains(15));
    }

    @Test
    public void testSize() {
        Assert.assertEquals(5, tree.size());
    }

    @Test
    public void testClear(){
        tree.clear();
        Assert.assertEquals(0, tree.size());
        Assert.assertFalse(tree.contains(5));
    }
}
