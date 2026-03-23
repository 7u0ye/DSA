package com.qinyuan.single;

import com.qinyuan.AbstractList;


public class SingleLinkedList2<E> extends AbstractList<E> {
    //增设虚拟头节点
    public SingleLinkedList2() {
        first = new Node<>(null,null);
    }

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

        Node<E> prev = index == 0 ? first : node(index - 1);
        prev.next = new Node<>(element, prev.next);

        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
            Node<E> prev = index == 0 ? first : node(index - 1);
            Node<E> node = prev.next;
            prev.next = node.next;
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
        Node <E> node = first.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    };

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> node = first.next;
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
