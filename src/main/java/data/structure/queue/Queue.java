package data.structure.queue;


import data.structure.linkedlist.DoubleLinkedList;

public class Queue<T>
{
    private DoubleLinkedList<T> items = new DoubleLinkedList<T>();

    public void enqueue(T value)
    {
        items.addFirst(value);
    }

    public T dequeue() throws Exception
    {
        if (items.size() == 0)
        {
            throw new Exception("The data.structure.queue is empty");
        } else
        {
            T last = items.getTail().getValue();
            items.removeLast();
            return last;
        }
    }

    public T peek() throws Exception
    {
        if (items.size() == 0)
        {
            throw new Exception("The data.structure.queue is empty");
        } else
        {
            return items.getTail().getValue();
        }
    }

    public int size()
    {
        return items.size();
    }
}
