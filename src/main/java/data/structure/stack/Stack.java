package data.structure.stack;

import data.structure.list.LinkedList;

public class Stack<T extends Comparable> {

    private LinkedList<T> items = new LinkedList<T>();

    /**
     * Добавляет значение на вершину стека
     *
     * @param value - значение, добавляемое в стек
     */
    public void push(T value) {
        items.addLast(value);
    }


    /**
     * Удаляет элемент с вершины стека и возвращает его.
     * Если стек пустой, выбрасывается исключение IllegalStateException
     *
     * @return элемент на вершине стека
     */
    public T pop() {
        if (items.size() == 0) {
            throw new IllegalStateException("The stack is empty.");
        }

        T result = items.getTail().getValue();
        items.removeLast();

        return result;
    }

    /**
     * Возвращает элемент с вершины стека.
     * Если стек пустой, выбрасывается исключение IllegalStateException
     *
     * @return элемент на вершине стека
     */
    public T peek() {
        if (items.size() == 0) {
            throw new IllegalStateException("The stack is empty.");
        }
        return items.getTail().getValue();
    }

    /**
     * Возвращает размер стека
     *
     * @return размер стека
     */
    public int size() {
        return items.size();
    }
}
