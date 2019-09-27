package data.structure.queue;

/**
 * Двусторонняя очередь, реализованнася с помощью массива
 */
public class DequeByArray<T extends Comparable> {

    private Object[] items = new Object[0];
    private int size = 0;
    private int head = 0;
    private int tail = -1;

    /**
     * Увеличивает размер массива, путем создания новго и копирование его элементов в новый массив
     *
     * @param startingIndex - индекс с которого будут копироваться элементы в новый массив
     */
    private void allocateNewArray(int startingIndex) {

        int newLength = (size == 0) ? 4 : size * 2;
        Object[] newArray = new Object[newLength];
        if (size > 0) {
            int targetIndex = startingIndex;
            // Копируем содержимое...
            // Если массив не закольцован, просто копируем элементы.
            // В противном случае, копирует от head до конца, а затем от начала массива до tail.
            // Если tail меньше, чем head, переходим в начало.
            if (tail < head) {
                // Копируем _items[head].._items[end] в newArray[0]..newArray[N].
                for (int i = head; i < items.length; i++) {
                    newArray[targetIndex] = items[i];
                    targetIndex++;
                }
                // Копируем _items[0].._items[tail] в newArray[N+1]..
                for (int i = 0; i <= tail; i++) {
                    newArray[targetIndex] = items[i];
                    targetIndex++;
                }
            } else {
                // Копируем _items[head].._items[tail] в newArray[0]..newArray[N]
                for (int i = head; i <= tail; i++) {
                    newArray[targetIndex] = items[i];
                    targetIndex++;
                }
            }
            head = startingIndex;
            tail = targetIndex - 1;
        } else {
            // Массив пуст.
            head = 0;
            tail = -1;
        }
        items = newArray;
    }

    /**
     * В начало очереди добавляется элемент
     *
     * @param item - значение, добавляемое в очередь
     */
    public void enqueueFirst(int item) {

        if (items.length == size) {
            allocateNewArray(1);
        }
        if (head > 0) {
            head--;
        } else {
            // В противном случае мы должны закольцеваться.
            head = items.length - 1;
        }
        items[head] = item;
        size++;
    }

    /**
     * В конец очереди добавляется элемент
     *
     * @param item - значение, добавляемое в очередь
     */
    public void enqueueLast(int item) {

        if (items.length == size) {
            allocateNewArray(0);
        }
        if (tail == items.length - 1) {
            tail = 0;
        } else {
            tail++;
        }
        items[tail] = item;
        size++;
    }

    /**
     * Возвращает превый элемент очереди, удаляя его из нее
     * Если очередь пустая, выбрасывается исключение IllegalStateException
     *
     * @return первый элемент в очереди
     */
    public T dequeueFirst() {

        if (size == 0) {
            throw new IllegalStateException("The queue is empty");
        }
        T value = (T) items[head];
        if (head == items.length - 1) {
            // Если head установлен на последнем индексе, переходим к началу массива.
            head = 0;
        } else {
            // Переходим к следующему элементу.
            head++;
        }
        size--;
        return value;
    }

    /**
     * Возвращает последний элемент очереди, удаляя его из нее
     * Если очередь пустая, выбрасывается исключение IllegalStateException
     *
     * @return последний элемент очереди
     */
    public T dequeueLast() {

        if (size == 0) {
            throw new IllegalStateException("The queue is empty");
        }
        T value = (T) items[tail];
        if (tail == 0) {
            // Если tail установлен на начало массива, переходим к концу.
            tail = items.length - 1;
        } else {
            // Переходим к предыдущему элементу.
            tail--;
        }
        size--;
        return value;
    }

    /**
     * Возвращает первый элемент очереди
     * Если очередь пустая, выбрасывается исключение IllegalStateException
     *
     * @return первый элемент в очереди
     */
    public T peekFirst() {

        if (size == 0) {
            throw new IllegalStateException("The queue is empty");
        }
        return (T) items[head];
    }

    /**
     * Возвращает последний элемент очереди
     * Если очередь пустая, выбрасывается исключение IllegalStateException
     *
     * @return последний элемент очереди
     */
    public T peekLast() {

        if (size == 0) {
            throw new IllegalStateException("The queue is empty");
        }
        return (T) items[tail];
    }

    /**
     * @return количество элементов в очереди
     */
    public int size() {

        return size;
    }
}
