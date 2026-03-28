package com.qinyuan;

public class Deque<E> {
    List<E> list = new LinkedList<>();
    public int size(){
        return list.size();
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
    public void enQueueFront(E e){
        list.add(0,e);
    }
    public E deQueueFront(){
        return list.remove(0);
    }
    public void enQueueRear(E e){
        list.add(e);

    }
    public E deQueueRear(){
        return list.remove(size()-1);
    }
    public E Front(){
        return list.get(0);
    }
    public E Rear(){
        return list.get(list.size()-1);
    }
    public void clear(){
        list.clear();
    }
}
