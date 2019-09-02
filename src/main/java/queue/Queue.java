package queue;

import linkedlist.DoubleLinkedList;

public class Queue<T>
{
    DoubleLinkedList<T> items = new DoubleLinkedList<T>();

    public void enqueue(T value)
    {
        items.addFirst(value);
    }

    public T dequeue() throws Exception
    {
        if (items.size() == 0)
        {
            throw new Exception("The queue is empty");
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
            throw new Exception("The queue is empty");
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
