package structure.set;

import java.util.ArrayList;
import java.util.List;

public class Set<T extends Comparable>
{
    List<T> items = new ArrayList<T>();

    public Set()
    {

    }

    public Set(Iterable<T> items)
    {
        addRange(items);
    }

    public void add(T item) throws Exception
    {
        if (contains(item))
        {
            throw new Exception("Item already exists in Set");
        } else
        {
            items.add(item);
        }
    }

    public void addRange(Iterable<T> items)
    {
        for (T item : items)
        {
            try
            {
                add(item);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public boolean remove(T item)
    {
        return items.remove(item);
    }


    public boolean contains(T item)
    {
        return items.contains(item);
    }

    public int size()
    {
        return items.size();
    }

    public Set<T> union(Set<T> other)
    {
        Set<T> result = new Set<T>();
        for (T item : other.items)
        {
            if (!contains(item))
            {
                try
                {
                    result.add(item);
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public Set<T> intersection(Set<T> other)
    {
        Set<T> result = new Set<T>();
        for (T item : items)
        {
            if (other.items.contains(item))
            {
                try
                {
                    result.add(item);
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public Set<T> difference(Set<T> other)
    {
        Set<T> result = new Set<T>(items);
        for (T item : other.items)
        {
            result.remove(item);
        }
        return result;
    }

    public Set<T> symmetricDifference(Set<T> other)
    {
        Set union = union(other);
        Set intersection = intersection(other);

        return union.difference(intersection);
    }
}
