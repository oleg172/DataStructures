package data.structure.stack;


import data.structure.linkedlist.DoubleLinkedList;

public class Stack<T extends Comparable>
{
    private DoubleLinkedList<T> items = new DoubleLinkedList<T>();

    public void push(T value)
    {
        items.addLast(value);
    }

    public T Pop()
    {
        if (items.size() == 0)
        {
            System.out.println("The data.structure.stack is empty");
        }

        T result = items.getTail().getValue();
        items.removeLast();

        return result;
    }

    public T peek()
    {
        if (items.size() == 0)
        {
            System.out.println("The data.structure.stack is empty");
        }
        return items.getTail().getValue();
    }

    public int size()
    {
        return items.size();
    }
}
