public class DoublyLinkedList {
    static class Node {
        int value;
        Node prev;
        Node next;

        public Node(int value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        public Node(int value) {
            this(value, null, null);
        }
    }


    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList() {
        this.length = 0;
    }

    public int get(int index) {
        Node node = getNode(index);
        if (node != null) return node.value;
        return -1;
    }

    private Node getNode(int index) {
        if (index < length/2) return getNodeFowarding(index);
        return getNodeBackwards(index);
    }

    private Node getNodeFowarding(int index) {
        Node current = this.head;
        int i = 0;
        while (current != null && i <= index) {
            if (i == index) return current;
            i++;
            current = current.next;
        }
        return null;
    }

    private Node getNodeBackwards(int index) {
        Node current = this.tail;
        int i = length-1;
        while (current != null && i >= index) {
            if (i == index) return current;
            i--;
            current = current.prev;
        }
        return null;
    }

    public void addAtHead(int val) {
        Node node = new Node(val, null, this.head);
        if (this.head != null) this.head.prev = node;

        this.head = node;
        if (this.tail == null) this.tail = node;
        this.length++;
    }

    public void addAtTail(int val) {
        Node node = new Node(val, this.tail, null);
        if (this.tail != null) this.tail.next = node;

        this.tail = node;
        if (this.head == null) this.head = node;
        this.length++;
    }

    public void addAtIndex(int index, int val) {
        if (index == length) {
            this.addAtTail(val);
            return;
        }
        if (index == 0) {
            this.addAtHead(val);
            return;
        }

        Node nextNode = this.getNode(index);
        if (nextNode == null) return;

        Node node = new Node(val, nextNode.prev, nextNode);
        if (nextNode.prev != null)
            nextNode.prev.next = node;
        nextNode.prev = node;
        this.length++;
    }

    public void deleteAtIndex(int index) {
        Node node = this.getNode(index);
        if (node == null) return;

        if (node.prev != null) node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;

        if (node == this.head) this.head = node.next;
        if (node == this.tail) this.tail = node.prev;

        this.length--;
    }
}
