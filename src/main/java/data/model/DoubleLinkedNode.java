package data.model;

public class DoubleLinkedNode<T> {
    private T value;
    private DoubleLinkedNode<T> next;
    private DoubleLinkedNode<T> previous;

    public DoubleLinkedNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public DoubleLinkedNode<T> getNext() {
        return next;
    }

    public DoubleLinkedNode<T> getPrevious() {
        return previous;
    }

    public void setNext(DoubleLinkedNode<T> next) {
        this.next = next;
    }

    public void setPrevious(DoubleLinkedNode<T> previous) {
        this.previous = previous;
    }
}
