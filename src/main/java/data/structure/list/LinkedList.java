package data.structure.list;

import data.model.LinkedNode;

import java.util.logging.Logger;

/**
 * Двусвязный список
 */
public class LinkedList<T extends Comparable> {

    private Logger log = Logger.getLogger(LinkedList.class.getName());

    private LinkedNode<T> head;
    private LinkedNode<T> tail;
    private int count;

    /**
     * Добавляет значение в начало списка
     *
     * @param value - добавляемое значение
     */
    public void addFirst(T value) {
        LinkedNode<T> node = new LinkedNode<T>(value);
        LinkedNode<T> temp = head;
        head = node;
        head.setNext(temp);

        if (count == 0) {
            tail = head;
        } else {
            temp.setPrevious(head);
        }
        count++;
    }

    /**
     * Добавляет значение в конец списка
     *
     * @param value - добавляемое значение
     */
    public void addLast(T value) {
        LinkedNode<T> node = new LinkedNode<T>(value);

        if (count == 0) {
            head = node;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
        }

        tail = node;
        count++;
    }

    /**
     * Удаляет первый элемент из списка
     */
    public void removeFirst() {
        if (count != 0) {
            head = head.getNext();

            count--;

            if (count == 0) {
                tail = null;
            } else {
                head.setPrevious(null);
            }
        }
    }

    /**
     * Удаляет последний элемент из списка
     */
    public void removeLast() {
        if (count != 0) {
            if (count == 1) {
                head = null;
                tail = null;
            } else {
                tail.getPrevious().setNext(null);
                tail = tail.getPrevious();
            }
            count--;
        }
    }

    /**
     * Удаляет элемент из списка
     * Случаи:
     * 1: Пустой список: ничего не делать.
     * 2: Один элемент: установить Previous = null.
     * 3: Несколько элементов:
     * a: Удаляемый элемент первый.
     * b: Удаляемый элемент в середине или конце.
     *
     * @param item - удаляемыый элемент
     * @return true если элемент был удален, иначе false
     */
    public boolean remove(T item) {
        LinkedNode<T> previous = null;
        LinkedNode<T> current = head;

        while (current != null) {
            if (current.getValue().equals(item)) {
                if (previous != null) {
                    previous.setNext(current.getNext());

                    if (current.getNext() == null) {
                        tail = previous;
                    } else {
                        current.getNext().setPrevious(previous);
                    }
                    count--;
                } else {
                    removeFirst();
                }

                return true;
            }

            previous = current;
            current = current.getNext();
        }

        return false;
    }

    /**
     * Ищет элемент в списке
     *
     * @param item - элемент который необходимо найти
     * @return true если элемент содержится в списке, иначе false
     */
    public boolean contains(T item) {
        LinkedNode<T> current = head;
        while (current != null) {
            if (current.getValue().equals(item)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /**
     * Очищает список
     */
    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }

    /**
     * Копирует список в заданный массив, с заданного индекса в массиве
     *
     * @param array      - массив в который копируется список
     * @param arrayIndex - индекс, с которого будет заполняться массив
     */
    public void copyTo(T[] array, int arrayIndex) {
        LinkedNode<T> current = head;
        while (current != null) {
            array[arrayIndex++] = current.getValue();
            current = current.getNext();
        }
    }

    /**
     * Копирует список в заданный массив, с заданного индекса в массиве в обратном порядке
     *
     * @param array      - массив в котоырй копируется список
     * @param arrayIndex - индекс, с которого будет заполняться массив
     */
    public void copyToReverse(T[] array, int arrayIndex) {
        LinkedNode<T> current = tail;
        while (current != null) {
            array[arrayIndex++] = current.getValue();
            current = current.getPrevious();
        }
    }

    /**
     * Возвращает размер списка
     *
     * @return размер списка
     */
    public int size() {
        return count;
    }

    /**
     * Возвращает конец списка
     *
     * @return конец списка
     */
    public LinkedNode<T> getTail() {
        return tail;
    }

    /**
     * Возвращает начало списка
     *
     * @return начало списка
     */
    public LinkedNode<T> getHead() {
        return head;
    }

    /**
     * Печатает элементы списка в формате: "Узел №" number = value
     */
    public void print() {
        LinkedNode<T> current = head;
        int count = 0;
        while (current != null) {
            log.info("Узел №" + count + " = " + current.getValue());
            current = current.getNext();
            count++;
        }
    }
}
