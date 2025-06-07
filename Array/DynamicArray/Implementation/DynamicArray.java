public class DynamicArray {
    private int[] array;
    private int length;

    public DynamicArray(int capacity) {
        this.array = new int[capacity];
        this.length = 0;
    }

    public int get(int i) {
        return this.array[i];
    }

    public void set(int i, int n) {
        this.array[i] = n;
    }

    public void pushback(int n) {
        if (this.getSize() >= this.array.length) this.resize();
        this.array[this.getSize()] = n;
        this.length++;
    }

    public int popback() {
        int i = this.getSize()-1;
        int element = this.array[i];
        this.array[i] = 0;
        this.length--;
        return element;
    }

    private void resize() {
        int[] newArray = new int[this.getSize()*2];
        for (int i = 0; i < this.array.length; i++) {
            newArray[i] = this.array[i];
        }
        this.array = newArray;
    }

    public int getSize() {
        return this.length;
    }

    public int getCapacity() {
        return this.array.length;
    }
}
