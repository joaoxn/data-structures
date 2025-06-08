public class ArrayDeque<T> {
    private final DynamicArray<T> array;


    public ArrayDeque(int capacity) {
        array = new DynamicArray<>(capacity);
    }

    public ArrayDeque() {
        array = new DynamicArray<>();
    }

    public void addFirst(T o) {
        array.add(0, o);
    }

    public void addLast(T o) {
        array.add(o);
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
}
