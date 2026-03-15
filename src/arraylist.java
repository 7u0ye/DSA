public class arraylist {
    private  int size;
    private int[] elements;

    private static final int DEFAULT_CAPACITY = 10;
    public static  final int ELEMENT_NOT_FOUND = -1;


    public arraylist(int capacity) {
        capacity = (capacity < DEFAULT_CAPACITY)? DEFAULT_CAPACITY : capacity;
        elements = new int[capacity];
    }


    public arraylist() {
        this(DEFAULT_CAPACITY);
    }


    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public int get(int index) {
        rangeCheck(index);
        return elements[index];
    }


    public int set(int index, int element) {
        rangeCheck(index);
        int oldValue = elements[index];
        elements[index] = element;
        return oldValue;
    }


    public int indexOf(int element) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == element) {
                return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }


    public boolean contains(int element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }


    public void clear() {
        size = 0;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        System.out.println("size: " + size);
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }


    public int remove(int index) {
        rangeCheck(index);
        int oldValue = elements[index];
        for (int i = index+1; i <= size - 1; i++) {
            elements[i-1] = elements[i];
        }
        size--;
        return oldValue;
    }


    public void add(int index, int element) {
        rangeCheckAdd(index);
        for (int i = size-1; i >= index; i--) {
            elements[i+1] = elements[i];
        }
        elements[index] = element;
        size++;
    }

    public void add(int element) {
        add(size, element);
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBoundsIndex(index);
        }
    }

    private void outOfBoundsIndex(int index) {
        throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }


    private void rangeCheckAdd(int index) {
        if (index < 0 || index > size) {
            outOfBoundsIndex(index);
        }
    }
}
