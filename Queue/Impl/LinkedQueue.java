public class LinkedQueue<T> implements Queue<T> {
    SinglyLinkedList<T> list = new SinglyLinkedList<>();

    @Override
    public void add(T value) {
        list.add(value);
    }

    @Override
    public T pop() {
        return list.popHead();
    }

    @Override
    public T peek() {
        return list.get(0);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void clear() {
        list.clear();
    }

    public T[] toArray() {
        return list.toArray();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
