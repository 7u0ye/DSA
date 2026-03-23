package com.qinyuan;

import com.qinyuan.List;

public abstract class AbstractList<E> implements List<E> {

    protected int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(E element) {
        return indexOf(element) != List.ELEMENT_NOT_FOUND;
    }

    public void add(E element) {
        add(size, element);
    }

    protected void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBoundsIndex(index);
        }
    }

    protected void outOfBoundsIndex(int index) {
        throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }


    protected void rangeCheckAdd(int index) {
        if (index < 0 || index > size) {
            outOfBoundsIndex(index);
        }
    }
}
