public class DynamicArray<T> {
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

    public T get(int index) {
        if (index < 0 || index >= length) throw new IndexOutOfBoundsException();
        return this.array[index];
    }

    public T at(int index) {
        if (index >= -this.length && index < 0) return this.array[this.size() + index];
        return get(index);
    }

    public void set(int index, T obj) {
        if  (index < 0 || index > this.length) throw new IndexOutOfBoundsException();
        if (index == this.length) {
            add(obj);
            return;
        }

        this.array[index] = obj;
    }

    public void add(T obj) {
        if (this.size() >= this.array.length) this.resize();
        this.array[this.size()] = obj;
        this.length++;
    }

    public void add(int index, T obj) {
        if (index == this.size()) {
            add(obj);
            return;
        }
        if (index < 0 || index > this.size()) throw new IndexOutOfBoundsException();

        for (int i = this.size()-1; i >= index; i--) {
            this.set(i+1, this.get(i));
        }
        this.set(index, obj);
    }

    public T pop() {
        int i = this.size()-1;
        T element = this.array[i];
        this.array[i] = null;
        this.length--;
        return element;
    }
    
    public T remove(int index) {
        T obj = this.get(index);
        for (int i = index; i < this.size()-1; i++) {
            this.set(i, this.get(i+1));
        }
        this.pop();
        return obj;
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

    public int size() {
        return this.length;
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
