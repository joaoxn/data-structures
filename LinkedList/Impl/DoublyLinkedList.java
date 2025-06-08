/*
* * Time complexity:

* * get(index): O(n) - Best: O(1); Worst: O(n/2) - Traverse the list. The worst case is the index in the middle of the list.
* * addAtHead(val): O(1) - Directly insert at beginning.
* * addAtTail(val): O(1) - Directly insert at the end.
* * addAtIndex(index, val): O(n) - Best: O(1); Worst: O(n/2) - Traverse using getNode method.
* * deleteAtIndex(index): O(n) - Best: O(1); Worst: O(n/2) - Traverse using getNode method.

* * Space complexity:
* * O(n): Only Node objects scaling linearly, thus having n Node instances.
 */

import java.util.ArrayList;

@SuppressWarnings({"unused", "Duplicates"})
public class DoublyLinkedList<T> {
    private DoublyNode<T> head;
    private DoublyNode<T> tail;
    private int length;

    public DoublyLinkedList() {
        this.length = 0;
    }

    public T get(int index) {
        return getNode(index).value;
    }

    private DoublyNode<T> getNode(int index) {
        if (index < length/2) return getNodeForwarding(index);
        return getNodeBackwards(index);
    }

    private DoublyNode<T> getNodeForwarding(int index) {
        DoublyNode<T> current = this.head;
        int i;
        for (i = 0; i <= index && current != null; i++) {
            if (i == index) return current;
            current = current.next;
        }
        throw new IndexOutOfBoundsException("Index %d out of bounds for length %d".formatted(index, i));
    }

    private DoublyNode<T> getNodeBackwards(int index) {
        DoublyNode<T> current = this.tail;
        int i;
        for (i = size()-1; i >= index && current != null; i--) {
            if (i == index) return current;
            current = current.prev;
        }
        throw new IndexOutOfBoundsException("Index %d out of bounds for length %d".formatted(index, i));
    }

    public void addHead(T val) {
        DoublyNode<T> node = new DoublyNode<>(val, null, this.head);
        if (this.head != null) this.head.prev = node;

        this.head = node;
        if (this.tail == null) this.tail = node;
        this.length++;
    }

    public void addTail(T val) {
        DoublyNode<T> node = new DoublyNode<>(val, this.tail, null);
        if (this.tail != null) this.tail.next = node;

        this.tail = node;
        if (this.head == null) this.head = node;
        this.length++;
    }

    public void add(int index, T val) {
        if (index == length) {
            this.addTail(val);
            return;
        }
        if (index == 0) {
            this.addHead(val);
            return;
        }

        DoublyNode<T> nextNode = this.getNode(index);

        DoublyNode<T> node = new DoublyNode<>(val, nextNode.prev, nextNode);
        if (nextNode.prev != null)
            nextNode.prev.next = node;
        nextNode.prev = node;
        this.length++;
    }

    public void remove(int index) {
        DoublyNode<T> node = this.getNode(index);

        if (node.prev != null) node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;

        if (node == this.head) this.head = node.next;
        if (node == this.tail) this.tail = node.prev;

        this.length--;
    }

    public int size() {
        return this.length;
    }

    public ArrayList<T> getValues() {
        ArrayList<T> array = new ArrayList<>();
        DoublyNode<T> current = this.head;
        while(current != null) {
            array.add(current.value);
            current = current.next;
        }
        return array;
    }
}
