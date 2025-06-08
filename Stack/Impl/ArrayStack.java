/*
* Stack can be thought as a simpler version of Array,
* Since only the top element is manipulated.
*
* * Inherits time and space complexity from DynamicArray.
* * Every method has time complexity O(1). (push has O(n) at worst case (stack was full)
*/

public class ArrayStack<T> {
    private final DynamicArray<T> array;

    ArrayStack(int capacity) {
        array = new DynamicArray<>(capacity);
    }

    ArrayStack() {
        array = new DynamicArray<>();
    }

    public void push(T obj) {
        array.add(obj);
    }

    public T pop() {
        return array.pop();
    }

    public T peek() {
        return array.at(-1);
    }

    public boolean isEmpty() {
        return array.size() <= 0;
    }
}
