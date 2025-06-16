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

    @Override
    public String toString() {
        String str = queue.toString();
        str = str.substring(1, str.length()-1);
        String[] split = str.split(", ");

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = split.length-1; i >= 0; i--) {
            sb.append(split[i]);
            if (i > 0) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
