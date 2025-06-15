@SuppressWarnings("unused")
public class ArrayDeque<T> extends Deque<T> {
    private final DynamicArray<T> array;


    public ArrayDeque(int capacity) {
        array = new DynamicArray<>(capacity);
    }

    public ArrayDeque() {
        array = new DynamicArray<>();
    }

    public void addFirst(T value) {
        array.add(0, value);
    }

    public void addLast(T value) {
        array.add(value);
    }

    public T removeFirst() {
        return array.remove(0);
    }

    public T removeLast() {
        return array.pop();
    }

    public T getFirst() {
        return array.get(0);
    }

    public T getLast() {
        return array.at(-1);
    }

    public int size() {
        return array.size();
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }
}
