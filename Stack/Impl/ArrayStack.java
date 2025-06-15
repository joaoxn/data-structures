/*
* Stack can be thought as a simpler version of Array,
* Since only the top element is manipulated.
*
* * Inherits time and space complexity from DynamicArray.
* * Every method has time complexity O(1). (push has O(n) at worst case (stack was full)
*/

@SuppressWarnings("unused")
public class ArrayStack<T> implements Stack<T> {
    private final DynamicArray<T> array;

    ArrayStack(int capacity) {
        array = new DynamicArray<>(capacity);
    }

    ArrayStack() {
        array = new DynamicArray<>();
    }

    @Override
    public void push(T value) {
        array.add(value);
    }

    @Override
    public T pop() {
        return array.pop();
    }

    @Override
    public T peek() {
        return array.at(-1);
    }

    @Override
    public boolean isEmpty() {
        return array.size() <= 0;
    }

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public void clear() {
        throw new Error("Not yet implemented");
    }

    @Override
    public T[] toArray() {
        throw new Error("Not yet implemented");
    }
}
