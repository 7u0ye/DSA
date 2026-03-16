public class arraylist<E> {
    private  int size;
    private E[] elements;

    private static final int DEFAULT_CAPACITY = 10;
    public static  final int ELEMENT_NOT_FOUND = -1;


    public arraylist(int capacity) {
        capacity = (capacity < DEFAULT_CAPACITY)? DEFAULT_CAPACITY : capacity;
        elements = (E[]) new Object[capacity];
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


    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }


    public E set(int index, E element) {
        rangeCheck(index);
            E oldValue = elements[index];
        elements[index] = element;
        return oldValue;
    }


    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return i;
            }
        }
        else {
            for (int i = 0; i < size; i++) {
                if (elements[i].equals(element)) return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }


    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }


    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
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


    public E remove(int index) {
        rangeCheck(index);
        E oldValue = elements[index];
        for (int i = index+1; i <= size - 1; i++) {
            elements[i-1] = elements[i];
        }
        elements[--size] = null;
        return oldValue;
    }

    public E remove(E element) {
        return remove(indexOf(element));
    }


    public void add(int index, E element) {
        rangeCheckAdd(index);
        ensureCapacity(index+1);

        for (int i = size; i > index; i--) {
            elements[i] = elements[i-1];
        }
        elements[index] = element;
        size++;
    }

    public void add(E element) {
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

    private void ensureCapacity(int Capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= Capacity) return;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println("Capacity: " + newCapacity);
    }

}
