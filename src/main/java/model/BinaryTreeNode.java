package model;

public class BinaryTreeNode<T extends Comparable>
{
    T value;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T value)
    {
        this.value = value;
    }

    public T getValue()
    {
        return value;
    }

    public BinaryTreeNode<T> getLeft()
    {
        return left;
    }

    public BinaryTreeNode<T> getRight()
    {
        return right;
    }

    public void setValue(T value)
    {
        this.value = value;
    }

    public void setLeft(BinaryTreeNode<T> left)
    {
        this.left = left;
    }

    public void setRight(BinaryTreeNode<T> right)
    {
        this.right = right;
    }

    public int compareTo(T other)
    {
        return value.compareTo(other);
    }
}
