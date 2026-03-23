package com.qinyuan.circle;

import com.qinyuan.AbstractList;

public class CircleLinkedList<E> extends AbstractList<E> {

    private Node <E> first;
    private Node <E> last;

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
            E oldValue = node.element;
            node.element = element;
        return oldValue;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckAdd(index);
        if(index == size){
            Node<E> oldLast = last;
            last = new Node<>(oldLast,element,first);
            if(oldLast == null){
                first = last;
                first.next = first;
                first.prev =  first;
            }else{
                oldLast.next = last;
                first.prev = last;
            }
        }else{
            Node<E> next =  node(index);
            Node<E> prev = next.prev;
            Node<E> node = new Node<>(prev,element,next);
            next.prev = node;
            prev.next = node;
            if(index == 0){
                first = node;
            }
        }
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = node(index);
        if(size == 1){
            first = null;
            last = null;
        }
        else {
            node = node(index);
            Node<E> prev = node.prev;
            Node<E> next = node.next;
            prev.next = next;
            next.prev = prev;
            if (index == 0) {
                first = next;
            }
            if (index == size - 1) {
                last = prev;
            }
        }
        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = first;
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (node.element == null) return i;
                node = node.next;
            }
        }
        else {
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) return i;
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }


    private static class Node<E> {
        E element;
        Node <E> next;
        Node <E> prev;
        public Node( Node <E> prev,E element, Node <E> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node <E> node(int index) {
        rangeCheck(index);
       if(index < (size>>1)){
           Node<E> node = first;
           for (int i = 0; i < index; i++) {
               node = node.next;
           }
           return node;
       }else{
           Node<E> node = last;
           for (int i = size-1; i > index; i--) {
               node = node.prev;
           }
           return node;
       }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> node = first;
        System.out.println("size: " + size);
        for (int i = 0; i < size; i++) {
            sb.append(node.element);
            node = node.next;
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

}
