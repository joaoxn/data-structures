import java.util.List;

public interface Array<T> {
    T get(int index);
    T at(int index);
    void set(int index, T value);
    void add(T value);
    void add(int index, T value);
    T pop();
    T remove(int index);
    void clear();

    int size();
    boolean isEmpty();
    T[] toArray();
    List<T> toList();
}
