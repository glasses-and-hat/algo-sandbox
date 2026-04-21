class DynamicArray {
    int[] array;
    int capacity;
    int length;
    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.array = new int[capacity];
    }

    public int get(int i) {
        if (i >= 0 && i < array.length) {
            return array[i];
        } else {
            return 0;
        }
    }

    public void set(int i, int n) {
        if (i >= 0 && i < array.length) {
            array[i] = n;
        }
    }

    public void pushback(int n) {
        if (length == capacity) {
            resize();
        }
        array[length] = n;
        length++;
    }

    public int popback() {
        if (length > 0) {
            length--;
        }
        return array[length];
    }

    private void resize() {
        capacity *= 2;
        int[] newArray = new int[capacity];
        for (int i = 0; i < length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public int getSize() {
        return length;
    }

    public int getCapacity() {
        return capacity;
    }
}
