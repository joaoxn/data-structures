/*
* * Stack implemented with a Singly Linked List.
* * Run Time:
* * O(1) - For every method (since the head of the linked list is always known)
 */

@SuppressWarnings("unused")
public class LinkedStack<T> {
    SinglyLinkedList<T> list = new SinglyLinkedList<>();


    public void add(T obj) {
        list.addHead(obj);
    }

    public T element() {
        return list.get(0);
    }

    public T peek() {
        try {
            return element();
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public T remove() {
        return list.remove(0);
    }

    public T pop() {
        try {
            return remove();
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
