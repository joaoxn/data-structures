@SuppressWarnings("unused")
public class DoublyNode<T> {
    T value;
    DoublyNode<T> prev;
    DoublyNode<T> next;

    public DoublyNode(T value, DoublyNode<T> prev, DoublyNode<T> next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

    public DoublyNode(T value) {
        this(value, null, null);
    }
}
