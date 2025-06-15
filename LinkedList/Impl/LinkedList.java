import java.util.List;

public abstract class LinkedList<T> {
    abstract T get(int index);
    abstract void set(int index, T value);
    abstract void addHead(T value);
    abstract void addTail(T value);
    abstract void add(int index, T value);
    abstract T remove(int index);
    abstract int size();

    void add(T value) {
        addTail(value);
    }

    T pop() {
        return remove(this.size()-1);
    }

    T popHead() {
        return remove(0);
    }

    T at(int index) {
        if (index >= -this.size() && index < 0) return this.get(this.size() + index);
        return get(index);
    }

    void clear() {
        while (this.size() > 0) this.popHead();
    }

    boolean isEmpty() {
        return this.size() == 0;
    }

    @SuppressWarnings("unchecked")
    T[] toArray() {
        T[] array = (T[]) new Object[this.size()];
        for (int i = 0; i < this.size(); i++)
            array[i] = this.get(i);
        return array;
    }

    List<T> toList() {
        return List.of(this.toArray());
    }
}
