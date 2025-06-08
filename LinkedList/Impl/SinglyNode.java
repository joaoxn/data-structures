public class SinglyNode<T> {
    T value;
    SinglyNode<T> next;

    public SinglyNode(T value, SinglyNode<T> next) {
        this.value = value;
        this.next = next;
    }

    public SinglyNode(T value) {
        this.value = value;
    }
}
