import java.util.ArrayList;

public class SinglyLinkedList {
    static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(int value) {
            this.value = value;
        }
    }


    private Node head;

    public int get(int index) {
        Node current = this.head;
        int i = 0;
        while (current != null && i <= index) {
            if (i == index) return current.value;
            i++;
            current = current.next;
        }
        return -1;
    }

    public void insertHead(int val) {
        this.head = new Node(val, this.head);
    }

    public void insertTail(int val) {
        Node node = new Node(val);
        Node current = this.head;
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
        Node current = this.head;
        Node prev = null;

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

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> array = new ArrayList<>();
        Node current = this.head;
        while(current != null) {
            array.add(current.value);
            current = current.next;
        }
        return array;
    }
}
