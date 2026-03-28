package com.qinyuan.circle;
@SuppressWarnings("unchecked")
public class CircleDeque<E> {
    private int size;
    private E[] elements;
    private int front;
    private static final int DEFAULT_CAPACITY = 10;

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public  CircleDeque(){
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public  void enCircleDequeFront(E element){
        ensureCapacity(size + 1);
        front = index(-1);
        elements[front] = element;
        size++;
    }

    public  void enCircleDequeRear(E element){
        ensureCapacity(size + 1);
        elements[index(size)] = element;
        size++;
    }

    public  E deCircleDequeFront(E element){
        E frontElement = elements[front];
        elements[front] = null;
        front = index(1);
        size--;
        return frontElement;
    }

    public  E deCircleDequeRear(E element){
        int rearIndex = index(size-1);
        E rearElement = elements[rearIndex];
        elements[rearIndex] = null;
        size--;
        return rearElement;
    }

    private int index(int index){
        index += front;
        if(index<0){
             index+=elements.length;
        }
        return index % elements.length;
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

    public E Front(){
        return elements[front];
    }
    public E Rear(){
        return elements[index(size-1)];
    }

    public void clear(){
        for (int i = 0; i < size; i++) {
            elements[index(i)] = null;
        }
        size = 0;
        front = 0;

    }
}
