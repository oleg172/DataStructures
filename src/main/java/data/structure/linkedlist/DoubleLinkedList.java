package data.structure.linkedlist;

import data.model.DoubleLinkedNode;

public class DoubleLinkedList<T extends Comparable> {
    private DoubleLinkedNode<T> head;
    private DoubleLinkedNode<T> tail;
    private int count;

    public void addFirst(T value) {
        DoubleLinkedNode node = new DoubleLinkedNode(value);
        DoubleLinkedNode temp = head;
        head = node;
        head.setNext(temp);

        if (count == 0) {
            tail = head;
        } else {
            temp.setPrevious(head);
        }
        count++;
    }

    public void addLast(T value) {
        DoubleLinkedNode node = new DoubleLinkedNode(value);

        if (count == 0) {
            head = node;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
        }

        tail = node;
        count++;
    }

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

    public boolean remove(T item) {
        DoubleLinkedNode previous = null;
        DoubleLinkedNode current = head;

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

    public boolean contains(T value) {
        DoubleLinkedNode<T> current = head;
        while (current != null) {
            if (current.getValue().equals(value)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }

    public void copyTo(T[] array, int arrayIndex) {
        DoubleLinkedNode<T> current = head;
        while (current != null) {
            array[arrayIndex++] = current.getValue();
            current = current.getNext();
        }
    }

    public void copyToReverse(T[] array, int arrayIndex) {
        DoubleLinkedNode<T> current = tail;
        while (current != null) {
            array[arrayIndex++] = current.getValue();
            current = current.getPrevious();
        }
    }

    public int size() {
        return count;
    }

    public DoubleLinkedNode<T> getTail() {
        return tail;
    }

    public DoubleLinkedNode<T> getHead() {
        return head;
    }
}
