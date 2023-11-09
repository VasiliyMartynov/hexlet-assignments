package exercise;


import java.util.Arrays;

public class SafetyList {
    // BEGIN
    int DEFAULT_CAPACITY = 10;

    private int size = 0;

    int[] elementData = new int[DEFAULT_CAPACITY];


    public synchronized void add(int i) {
        if (size == elementData.length) {
            elementData = Arrays.copyOf(elementData, size * 2);
        }
        elementData[size] = i;
        size = size + 1;
    }

    public int get(int index) {
        return elementData[index];
    }

    public int getSize() {
        return size;
    }

    // END
}
