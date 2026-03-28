package com.qinyuan.circle;
@SuppressWarnings("unchecked")
public class CircleQueue <E>{
    private int size;
    private E[] elements;
    private int front;
    private static final int DEFAULT_CAPACITY = 10;

    public  CircleQueue(){
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void enqueue(E element){
        ensureCapacity(size + 1);
        elements[index(size)] = element;
        size++;
    }

    public E dequeue(){
        E frontElement = elements[front];
        elements[front] = null;
        front = index(1);
        size--;
        return frontElement;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size:").append(size).append("\n");
        sb.append("Capacity:").append(elements.length).append("\n");
        sb.append("front:").append(front).append("\n");
        sb.append("[");
        for (int i = 0; i < elements.length; i++) {
            sb.append(elements[i]);
            if (i != (elements.length - 1)) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private void ensureCapacity(int Capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= Capacity) return;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[index(i)];
        }
        elements = newElements;
        front = 0;
    }

    private int index(int i){
        return (front + i)%elements.length;
    }


    public void clear(){
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        front = 0;
        size = 0;
    }
}
