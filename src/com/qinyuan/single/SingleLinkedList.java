package com.qinyuan.single;

import com.qinyuan.AbstractList;

public class SingleLinkedList<E> extends AbstractList<E> {
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
        if(index == 0){
            first = new Node<>(element,first);
        }else {

            Node<E> prev = node(index - 1);
            prev.next = new Node<>(element, prev.next);
        }
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = first;
        if(index==0){
            first =  first.next;
        }
        else{
            Node<E> prev = node(index - 1);
            node = prev.next;
            prev.next = node.next;
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
    }

    private Node <E> first;


    private static class Node<E> {
        E element;
        Node <E> next;
        public Node(E element, Node <E> next) {
            this.element = element;
            this.next = next;
        }
    }

    private Node <E> node(int index) {
        rangeCheck(index);
        Node <E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
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
