package data.model;

public class LinkedNode<T> {
    private T value;
    private LinkedNode<T> next;
    private LinkedNode<T> previous;

    public LinkedNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public LinkedNode<T> getNext() {
        return next;
    }

    public LinkedNode<T> getPrevious() {
        return previous;
    }

    public void setNext(LinkedNode<T> next) {
        this.next = next;
    }

    public void setPrevious(LinkedNode<T> previous) {
        this.previous = previous;
    }
}
