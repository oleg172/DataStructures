package linkedlist;

import model.LinkedListNode;

public class DoubleLinkedList<T>
{
    private LinkedListNode<T> head;
    private LinkedListNode<T> tail;
    private int count;

    public void addFirst(T value)
    {
        LinkedListNode node = new LinkedListNode(value);
        LinkedListNode temp = head;
        head = node;
        head.setNext(temp);

        if (count == 0)
        {
            tail = head;
        } else
        {
            temp.setPrevious(head);
        }
        count++;
    }

    public void addLast(T value)
    {
        LinkedListNode node = new LinkedListNode(value);

        if (count == 0)
        {
            head = node;
        } else
        {
            tail.setNext(node);
            node.setPrevious(tail);
        }

        tail = node;
        count++;
    }

    public void removeFirst()
    {
        if (count != 0)
        {
            head = head.getNext();

            count--;

            if (count == 0)
            {
                tail = null;
            } else
            {
                head.setPrevious(null);
            }
        }
    }

    public void removeLast()
    {
        if (count != 0)
        {
            if (count == 1)
            {
                head = null;
                tail = null;
            } else
            {
                tail.getPrevious().setNext(null);
                tail = tail.getPrevious();
            }
            count--;
        }
    }

    public boolean remove(T item)
    {
        LinkedListNode previous = null;
        LinkedListNode current = head;

        while (current != null)
        {
            if (current.getValue().equals(item))
            {
                if (previous != null)
                {
                    previous.setNext(current.getNext());

                    if (current.getNext() == null)
                    {
                        tail = previous;
                    } else
                    {
                        current.getNext().setPrevious(previous);
                    }
                    count--;
                } else
                {
                    removeFirst();
                }

                return true;
            }

            previous = current;
            current = current.getNext();
        }

        return false;
    }

    public int size()
    {
        return count;
    }

    public LinkedListNode<T> getTail()
    {
        return tail;
    }

    public LinkedListNode<T> getHead()
    {
        return head;
    }
}
