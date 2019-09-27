package data.structure.queue;

import data.structure.list.LinkedList;

/**
 * Двусторонняя очередь
 */
public class Deque<T extends Comparable> {

    private LinkedList<T> items = new LinkedList<T>();

    /**
     * Элемент добавляется в начало очереди
     *
     * @param value - значение, добавляемое в очередь
     */
    public void enqueueFirst(T value) {
        items.addFirst(value);
    }

    /**
     * Элемент добавляется в конец очереди
     *
     * @param value - значение, добавляемое в очередь
     */
    public void enqueueLast(T value) {
        items.addLast(value);
    }

    /**
     * Возвращает первый элемент из очереди, удаляя его из очереди
     * Если очередь пуста, выбрасывается исключение IllegalStateException
     *
     * @return первый элемент из очереди
     */
    public T dequeueFirst() {
        if (items.size() == 0) {
            throw new IllegalStateException("The queue is empty");
        } else {
            T first = items.getHead().getValue();
            items.removeFirst();
            return first;
        }
    }

    /**
     * Возвращает последний элемент из очереди, удаляя его из очереди
     * Если очередь пуста, выбрасывается исключение IllegalStateException
     *
     * @return последний элемент из очереди
     */
    public T dequeueLast() {
        if (items.size() == 0) {
            throw new IllegalStateException("The queue is empty");
        } else {
            T last = items.getTail().getValue();
            items.removeLast();
            return last;
        }
    }

    /**
     * Возвращает первый элемент из очереди
     * Если очередь пуста, выбрасывается исключение IllegalStateException
     *
     * @return первый элемент в очереди
     */
    public T peekFirst() {
        if (items.size() == 0) {
            throw new IllegalStateException("The queue is empty");
        } else {
            return items.getHead().getValue();
        }
    }

    /**
     * Возвращает последний элемент из очереди
     * Если очередь пуста, выбрасывается исключение IllegalStateException
     *
     * @return последний элемент из очереди
     */
    public T peekLast() {
        if (items.size() == 0) {
            throw new IllegalStateException("The queue is empty");
        } else {
            return items.getTail().getValue();
        }
    }

    /**
     * @return возвращает количество элементов в очереди
     */
    public int size() {
        return items.size();
    }
}
