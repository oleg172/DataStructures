package data.structure.queue;


public class DequeArray
{
    private int[] items = new int[0];

    private int size = 0;

    private int head = 0;

    private int tail = -1;

    private void allocateNewArray(int startingIndex)
    {
        int newLength = (size == 0) ? 4 : size * 2;

        int[] newArray = new int[newLength];

        if (size > 0)
        {
            int targetIndex = startingIndex;

            // Копируем содержимое...
            // Если массив не закольцован, просто копируем элементы.
            // В противном случае, копирует от head до конца, а затем от начала массива до tail.

            // Если tail меньше, чем head, переходим в начало.
            if (tail < head)
            {
                // Копируем _items[head].._items[end] в newArray[0]..newArray[N].
                for (int index = head; index < items.length; index++)
                {
                    newArray[targetIndex] = items[index];
                    targetIndex++;
                }

                // Копируем _items[0].._items[tail] в newArray[N+1]..
                for (int index = 0; index <= tail; index++)
                {
                    newArray[targetIndex] = items[index];
                    targetIndex++;
                }
            } else
            {
                // Копируем _items[head].._items[tail] в newArray[0]..newArray[N]
                for (int index = head; index <= tail; index++)
                {
                    newArray[targetIndex] = items[index];
                    targetIndex++;
                }
            }


            head = startingIndex;
            tail = targetIndex - 1;
        } else
        {
            // Массив пуст.
            head = 0;
            tail = -1;
        }

        items = newArray;
    }

    public void enqueueFirst(int item)
    {
        // Проверим, необходимо ли увеличение массива:
        if (items.length == size)
        {
            allocateNewArray(1);
        }

        // Так как массив не заполнен и head больше 0,
        // мы знаем, что есть место в начале массива.
        if (head > 0)
        {
            head--;
        } else
        {
            // В противном случае мы должны закольцеваться.
            head = items.length - 1;
        }

        items[head] = item;

        size++;
    }

    public void EnqueueLast(int item)
    {
        // Проверим, необходимо ли увеличение массива:
        if (items.length == size)
        {
            allocateNewArray(0);
        }

        // Теперь, когда у нас есть подходящий массив,
        // если _tail в конце массива, нам надо перейти в начало.
        if (tail == items.length - 1)
        {
            tail = 0;
        } else
        {
            tail++;
        }

        items[tail] = item;
        size++;
    }

    //Удаляет элемент с начала очереди и возвращает его
    public int dequeueFirst() throws Exception
    {
        if (size == 0)
        {
            throw new Exception("The deque is empty");
        }

        int value = items[head];

        if (head == items.length - 1)
        {
            // Если head установлен на последнем индексе, переходим к началу массива.
            head = 0;
        } else
        {
            // Переходим к следующему элементу.
            head++;
        }

        size--;

        return value;
    }

    public int dequeueLast() throws Exception
    {
        if (size == 0)
        {
            throw new Exception("The deque is empty");
        }

        int value = items[tail];

        if (tail == 0)
        {
            // Если tail установлен на начало массива, переходим к концу.
            tail = items.length - 1;
        } else
        {
            // Переходим к предыдущему элементу.
            tail--;
        }

        size--;

        return value;
    }

    public int peekFirst() throws Exception
    {
        if (size == 0)
        {
            throw new Exception("The deque is empty");
        }

        return items[head];
    }

    public int peekLast() throws Exception
    {
        if (size == 0)
        {
            throw new Exception("The deque is empty");
        }

        return items[tail];
    }

    public int size()
    {
        return size;
    }
}
