package data.structure.queue;


import data.structure.linkedlist.DoubleLinkedList;

public class Deque<T>
{
    private DoubleLinkedList<T> items = new DoubleLinkedList<T>();

    public void enqueueFirst(T value)
    {
        items.addFirst(value);
    }

    public void enqueueLast(T value)
    {
        items.addLast(value);
    }

    public T dequeueFirst() throws Exception
    {
        if (items.size() == 0)
        {
            throw new Exception("The data.structure.queue is empty");
        } else
        {
            T first = items.getHead().getValue();
            items.removeFirst();
            return first;
        }
    }

    public T dequeueLast() throws Exception
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

    public T peekFirst() throws Exception
    {
        if (items.size() == 0)
        {
            throw new Exception("The data.structure.queue is empty");
        } else
        {
            return items.getHead().getValue();
        }
    }

    public T peekLast() throws Exception
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
