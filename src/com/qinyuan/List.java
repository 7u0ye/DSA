package com.qinyuan;

public interface List<E> {
     static final int ELEMENT_NOT_FOUND = -1;

     boolean isEmpty();

     E get(int index);

     E set(int index, E element);

     void add(int index, E element);

     E remove(int index);

     int indexOf(E element);

     boolean contains( E element);

     void clear();

     void add( E element);

     int size();

}
