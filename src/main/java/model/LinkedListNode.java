package model;

public class LinkedListNode<T>
{
    private T value;
    private LinkedListNode<T> next;
    private LinkedListNode<T> previous;

    public LinkedListNode(T value)
    {
        this.value = value;
    }

    public T getValue()
    {
        return value;
    }

    public LinkedListNode<T> getNext()
    {
        return next;
    }

    public LinkedListNode<T> getPrevious()
    {
        return previous;
    }

    public void setValue(T value)
    {
        this.value = value;
    }

    public void setNext(LinkedListNode<T> next)
    {
        this.next = next;
    }

    public void setPrevious(LinkedListNode<T> previous)
    {
        this.previous = previous;
    }
}
