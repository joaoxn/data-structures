@SuppressWarnings("unused")
public class DoublyLinkedList<T> {
    private DoublyNode<T> head;
    private DoublyNode<T> tail;
    private int length;

    public DoublyLinkedList() {
        this.length = 0;
    }

    public T get(int index) {
        DoublyNode<T> node = getNode(index);
        if (node != null) return node.value;
        return null;
    }

    private DoublyNode<T> getNode(int index) {
        if (index < length/2) return getNodeForwarding(index);
        return getNodeBackwards(index);
    }

    private DoublyNode<T> getNodeForwarding(int index) {
        DoublyNode<T> current = this.head;
        int i = 0;
        while (current != null && i <= index) {
            if (i == index) return current;
            i++;
            current = current.next;
        }
        return null;
    }

    private DoublyNode<T> getNodeBackwards(int index) {
        DoublyNode<T> current = this.tail;
        int i = length-1;
        while (current != null && i >= index) {
            if (i == index) return current;
            i--;
            current = current.prev;
        }
        return null;
    }

    public void addAtHead(T val) {
        DoublyNode<T> node = new DoublyNode<>(val, null, this.head);
        if (this.head != null) this.head.prev = node;

        this.head = node;
        if (this.tail == null) this.tail = node;
        this.length++;
    }

    public void addAtTail(T val) {
        DoublyNode<T> node = new DoublyNode<>(val, this.tail, null);
        if (this.tail != null) this.tail.next = node;

        this.tail = node;
        if (this.head == null) this.head = node;
        this.length++;
    }

    public void addAtIndex(int index, T val) {
        if (index == length) {
            this.addAtTail(val);
            return;
        }
        if (index == 0) {
            this.addAtHead(val);
            return;
        }

        DoublyNode<T> nextNode = this.getNode(index);
        if (nextNode == null) return;

        DoublyNode<T> node = new DoublyNode<>(val, nextNode.prev, nextNode);
        if (nextNode.prev != null)
            nextNode.prev.next = node;
        nextNode.prev = node;
        this.length++;
    }

    public void deleteAtIndex(int index) {
        DoublyNode<T> node = this.getNode(index);
        if (node == null) return;

        if (node.prev != null) node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;

        if (node == this.head) this.head = node.next;
        if (node == this.tail) this.tail = node.prev;

        this.length--;
    }

    public int size() {
        return this.length;
    }
}
