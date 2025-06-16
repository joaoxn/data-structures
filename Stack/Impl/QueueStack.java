public class QueueStack<T> implements Stack<T> {
    Queue<T> queue = new LinkedQueue<>();

    @Override
    public void push(T value) {
        int oldSize = queue.size();
        queue.add(value);
        for (int i = 0; i < oldSize; i++) {
            queue.add(queue.pop());
        }
    }

    @Override
    public T pop() {
        return queue.pop();
    }

    @Override
    public T peek() {
        return queue.peek();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void clear() {
        queue.clear();
    }

    @Override
    public T[] toArray() {
        return queue.toArray();
    }
}
