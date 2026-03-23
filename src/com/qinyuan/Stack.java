package com.qinyuan;

import com.qinyuan.arraylist;
import com.qinyuan.List;

public class Stack<E> {
    private List<E> list = new arraylist<>();
    public void push(E e) {
        list.add(e);
    }
    public E pop() {
        return list.remove(list.size()-1);
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }
    public int size() {
        return list.size();
    }
    public E top() {
        return list.get(list.size()-1);
    }
    public void clear() {
        list.clear();
    }
}
