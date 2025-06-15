public abstract class Deque<T> implements Queue<T> {
    abstract void addFirst(T value);
    abstract void addLast(T value);
    abstract T removeFirst();
    abstract T removeLast();
    abstract T getFirst();
    abstract T getLast();

    @Override
    public void add(T value) {
        this.addLast(value);
    }

    public T pop() {
        return this.removeFirst();
    }

    public T peek() {
        return this.getFirst();
    }
}
