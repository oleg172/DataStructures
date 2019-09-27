package data.structure.queue;

import data.structure.list.LinkedList;

public class Queue<T extends Comparable> {

    private LinkedList<T> items = new LinkedList<T>();

    /**
     * Добавляет элемент в очередь
     *
     * @param value - значение добавляемое в очередь
     */
    public void enqueue(T value) {
        items.addFirst(value);
    }

    /**
     * Удаляет первый элемент в очереди и возвращает его
     * Если очередь пуста, выбрасывается исключение IllegalStateException.
     *
     * @return первый элемент в очереди
     */
    public T dequeue() {
        if (items.size() == 0) {
            throw new IllegalStateException("The queue is empty");
        } else {
            T last = items.getTail().getValue();
            items.removeLast();
            return last;
        }
    }

    /**
     * Вовзращает первый элемент из очереди
     * Если очередь пуста, выбрасывается исключение IllegalStateException.
     *
     * @return первый элемент из очереди
     */
    public T peek() {
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
