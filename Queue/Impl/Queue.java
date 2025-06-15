public interface Queue<T> {
    void add(T value);
    T pop();
    T peek();
    int size();
    boolean isEmpty();
}
