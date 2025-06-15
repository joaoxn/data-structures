import java.util.List;

@SuppressWarnings("unused")
public class DynamicArray<T> implements Array<T> {
    private T[] array;
    private int length;

    @SuppressWarnings("unchecked")
    public DynamicArray(int capacity) {
        this.array = (T[]) new Object[capacity];
        this.length = 0;
    }

    public DynamicArray() {
        this(10);
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= this.length)
            throw new IndexOutOfBoundsException("Index %d out of bounds for length %d".formatted(index, this.length));
        return this.array[index];
    }

    @Override
    public T at(int index) {
        if (index >= -this.length && index < 0) return this.array[this.size() + index];
        return get(index);
    }

    @Override
    public void set(int index, T value) {
        if  (index < 0 || index > this.length)
            throw new IndexOutOfBoundsException("Index %d out of bounds for length %d".formatted(index, this.length));
        if (index == this.length) {
            add(value);
            return;
        }

        this.array[index] = value;
    }

    @Override
    public void add(T value) {
        if (this.size() >= this.array.length) this.resize();
        this.array[this.size()] = value;
        this.length++;
    }

    @Override
    public void add(int index, T value) {
        if (index == this.size()) {
            add(value);
            return;
        }
        if (index < 0 || index > this.size())
            throw new IndexOutOfBoundsException("Index %d out of bounds for length %d".formatted(index, this.size()));

        for (int i = this.size()-1; i >= index; i--) {
            this.set(i+1, this.get(i));
        }
        this.set(index, value);
    }

    @Override
    public T pop() {
        int i = this.size()-1;
        T element = this.array[i];
        this.array[i] = null;
        this.length--;
        return element;
    }

    @Override
    public T remove(int index) {
        T value = this.get(index);
        for (int i = index; i < this.size()-1; i++) {
            this.set(i, this.get(i+1));
        }
        this.pop();
        return value;
    }

    @Override
    public void clear() {
        while (this.size() > 0) this.pop();
    }

    @Override
    public int size() {
        return this.length;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T[] toArray() {
        T[] array = (T[]) new Object[this.size()];
        System.arraycopy(this.array, 0, array, 0, this.size());
        return array;
    }

    @Override
    public List<T> toList() {
        return List.of(this.toArray());
    }

    @SuppressWarnings("unchecked")
    public void resize(int newCapacity) {
        T[] newArray = (T[]) new Object[newCapacity];
        System.arraycopy(this.array, 0, newArray, 0, this.array.length);
        this.array = newArray;
    }

    public void resize() {
        resize(this.size()*2);
    }

    public void fillCapacity(T value) {
        int length = this.length;
        this.length = this.array.length;

        if (value == null) return;

        for (int i = length; i < this.array.length; i++) {
            this.array[i] = value;
        }
    }

    public int capacity() {
        return this.array.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.size()-1; i++)
            sb.append(this.get(i)).append(", ");
        sb.append(this.at(-1));
        sb.append("]");
        return sb.toString();
    }
}
