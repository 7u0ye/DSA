package com.qinyuan;

public class Queue<E> {
    List<E> list = new LinkedList<>();
    public void enqueue(E e) {
        list.add(e);
    }
    public E dequeue() {
        return list.remove(0);
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }
    public int size() {
        return list.size();
    }
    public E front() {
        return list.get(0);
    }
    public void clear(){
        list.clear();
    }
}
