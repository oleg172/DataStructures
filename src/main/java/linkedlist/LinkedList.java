package linkedlist;

import model.Node;

/**
 * Односвязный список
 */
public class LinkedList<T extends Comparable> {
    private Node<T> head;
    private Node<T> tail;
    private int count;

    /**
     * Добавляет значение в конец списка
     *
     * @param value - добавляемое значение
     */
    public void add(T value) {
        Node<T> node = new Node<T>(value);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        count++;
    }

    /**
     * случаи:
     * 1: Пустой список: ничего не делать.
     * 2: Один элемент: установить Previous = null.
     * 3: Несколько элементов:
     * a: Удаляемый элемент первый.
     * b: Удаляемый элемент в середине или конце.
     *
     * @param item - элемент, который необходимо удалить из списка
     * @return true если элемент был удален, иначе false
     */
    public boolean remove(T item) {
        Node previous = null;
        Node current = head;

        while (current != null) {
            if (current.getValue().equals(item)) {
                if (previous != null) {
                    // Случай 3b.
                    previous.setNext(current.getNext());

                    if (current.getNext() == null) {
                        tail = previous;
                    }
                } else {
                    // Случай 2 или 3a.

                    head = head.getNext();

                    if (head == null) {
                        tail = null;
                    }
                }
                count--;
                return true;
            }
            previous = current;
            current = current.getNext();
        }

        return false;
    }

    /**
     * @param item - элемент, который хотим найти в списке
     * @return true если элемент найден, иначе false
     */
    public boolean contains(T item) {
        Node<T> current = head;
        while (current != null) {
            if (current.getValue().equals(item)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /**
     * удаляет все элементы из списка
     */
    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }

    /**
     * копирует список в заданный массив, с заданного индекса в массиве
     *
     * @param array      - массив, в который будет копироваться спислк
     * @param arrayIndex - индекс, с которого будет заполняться массив
     */
    public void copyTo(T[] array, int arrayIndex) {
        Node<T> current = head;
        while (current != null) {
            array[arrayIndex++] = current.getValue();
            current = current.getNext();
        }
    }

    /**
     * @return размер списка
     */
    public int size() {
        return count;
    }

    /**
     * Печатает элементы списка в формате: "Узел №" number = value
     */
    public void print() {
        Node<T> current = head;
        int count = 0;
        while (current != null) {
            System.out.println("Узел №" + count + " = " + current.getValue());
            count++;
        }
    }
}
