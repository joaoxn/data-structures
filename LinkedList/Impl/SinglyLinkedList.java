import java.util.ArrayList;

@SuppressWarnings({"unused", "Duplicates"})
public class SinglyLinkedList<T> extends LinkedList<T> {
    private SinglyNode<T> head;
    private SinglyNode<T> tail;
    private int length = 0;

    public T get(int index) {
        return getNode(index).value;
    }

    protected SinglyNode<T> getNode(int index) {
        SinglyNode<T> current = this.head;
        int i;
        for (i = 0; i <= index && current != null; i++) {
            if (i == index) return current;
            current = current.next;
        }
        throw new IndexOutOfBoundsException("Index %d out of bounds for length %d".formatted(index, i));
    }

    public void set(int index, T value) {
        getNode(index).value = value;
    }

    public void addHead(T value) {
        this.head = new SinglyNode<>(value, this.head);
        if (this.tail == null) this.tail = this.head;
        this.length++;
    }

    public void addTail(T value) {
        SinglyNode<T> node = new SinglyNode<>(value);
        SinglyNode<T> tail = this.tail;
        if (tail != null) tail.next = node;
        if (this.head == null) this.head = node;
        this.tail = node;
        this.length++;
    }

    public void add(int index, T value) {
        if (index == 0) {
            addHead(value);
            return;
        }
        SinglyNode<T> prev = getNode(index-1);
        prev.next = new SinglyNode<>(value, prev.next);
        this.length++;
    }

    public T remove(int index) {
        T value;
        if (index == 0) {
            value = this.head.value;
            this.head = this.head.next;
            this.length--;
            return value;
        }
        SinglyNode<T> prev = getNode(index-1);
        value = prev.next.value;
        prev.next = prev.next.next;
        this.length--;
        return value;
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public int size() {
        return this.length;
    }

    public ArrayList<T> getValues() {
        ArrayList<T> array = new ArrayList<>();
        SinglyNode<T> current = this.head;
        while(current != null) {
            array.add(current.value);
            current = current.next;
        }
        return array;
    }

    public void sublist(int start, int end) {
        if (end <= start) {
            this.head = null;
            this.tail = null;
            return;
        }

        SinglyNode<T> lastNode = getNode(end-1);
        lastNode.next = null;
        this.tail = lastNode;
        this.head = getNode(start);
    }
}
