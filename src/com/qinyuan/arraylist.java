package com.qinyuan;

public class arraylist<E> extends AbstractList<E> {
    private E[] elements;

    private static final int DEFAULT_CAPACITY = 10;


    public arraylist(int capacity) {
        capacity = capacity < DEFAULT_CAPACITY? DEFAULT_CAPACITY:capacity;
        elements = (E[]) new Object[capacity];
    }


    public arraylist() {
        this(DEFAULT_CAPACITY);
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



    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
        elements = (E[]) new Object[DEFAULT_CAPACITY];
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
        trim();
        return oldValue;
    }

    private void trim() {
        int oldCapacity = elements.length;
        int newCapacity = oldCapacity >> 1;
        if(size >= newCapacity || oldCapacity<=DEFAULT_CAPACITY) return;
        E[] newElements = (E[]) new Object[newCapacity];
        for(int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println("Trimming " + oldCapacity + " to " + newCapacity);
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
