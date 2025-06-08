import java.util.ArrayList;

@SuppressWarnings("unused")
public class SinglyLinkedList<T> {
    private SinglyNode<T> head;

    public T get(int index) {
        SinglyNode<T> current = this.head;
        int i = 0;
        while (current != null && i <= index) {
            if (i == index) return current.value;
            i++;
            current = current.next;
        }
        return null;
    }

    public void insertHead(T val) {
        this.head = new SinglyNode<>(val, this.head);
    }

    public void insertTail(T val) {
        SinglyNode<T> node = new SinglyNode<>(val);
        SinglyNode<T> current = this.head;
        if (current == null) {
            this.head = node;
            return;
        }

        while(current.next != null) {
            current = current.next;
        }

        current.next = node;
    }

    public boolean remove(int index) {
        SinglyNode<T> current = this.head;
        SinglyNode<T> prev = null;

        int i = 0;
        while(current != null && i <= index) {
            if (i != index) {
                prev = current;
                current = current.next;
                i++;
                continue;
            }

            if (i == 0) {
                this.head = current.next;
                return true;
            }

            prev.next = current.next;
            return true;
        }

        return false;
    }

    public ArrayList<T> getValues() {
        ArrayList<T> array = new ArrayList<>();
        SinglyNode<T> current = this.head;
        while(current != null) {
            array.add(current.value);
            current = current.next;
        }
        return array;
    }
}
