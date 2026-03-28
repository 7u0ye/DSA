package com.qinyuan;
import sun.reflect.generics.visitor.Visitor;

import java.lang.Comparable;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unchecked")
public class BinarySearchTree<E> {
    private int size;
    private Node<E> root;
    private Comparator<E> comparator;
    public static abstract class Visitor<E>{
        boolean stop;
        public abstract boolean visit(E element);
    }

    public void remove(E element){
        remove(node(element));
    }

    private void remove(Node<E> node){
        if(node == null) return;
        size--;
        if(node.hasTwoChildren()){
            Node<E> s = successor(node);
            node.element = s.element;
            node = s;
        }
        Node<E> replacement = node.left!=null?node.left:node.right;
        if(replacement != null){
            replacement.parent = node.parent;
            if(node.parent == null){
                root = replacement;
            }else if(node.parent.left == node){
                node.parent.left = replacement;
            }else{
                node.parent.right = replacement;
            }
        }else if(node.parent == null){
            root = null;
        }else{
            if(node.parent.left == node){
                node.parent.left = null;
            }else if(node.parent.right == node){
                node.parent.right = null;
            }
        }

    }

    private Node<E> node(E element){
        if(root == null) return null;
        Node<E> node = root;
        while(node!=null){
            int cmp = compare(element,node.element);
            if(cmp==0){
                return node;
            }else if(cmp<0){
                node = node.left;
            }else{
                node = node.right;
            }
        }
        return null;
    }


    public Node<E> predecessor(Node<E> node){
        if(node == null) return null;
        Node<E> p = node.left;
        if(p != null){
            while(p.right != null){
                p = p.right;
            }
            return p;
        }
        while(node.parent != null && node.parent.left == node){
            node = node.parent;
        }
        return node.parent;
    }

    public Node<E> successor(Node<E> node){
        if(node == null) return null;
        Node<E> p = node.right;
        if(p != null){
            while(p.left != null){
                p = p.left;
            }
            return p;
        }
        while(node.parent != null && node.parent.right == node){
            node = node.parent;
        }
        return node.parent;
    }


    public boolean isComplete(){
        if(root==null) return false;
        Queue<Node<E>> queue = new LinkedList<Node<E>>();
        queue.offer(root);
        boolean leaf = false;
        while(!queue.isEmpty()){
            Node<E> node = queue.poll();
            if(!node.isLeaf() && leaf) return false;

            if(node.left!=null){
                queue.offer(node.left);
            }else if(node.right==null){
                return false;
            }
            if(node.right!=null){
                queue.offer(node.right);
            }else{
                leaf = true;
            }
        }
        return true;
    }


//        public boolean isComplete(){
//            if(root == null) return false;
//            Queue<Node<E>> queue = new LinkedList<Node<E>>();
//            queue.offer(root);
//            boolean leaf = false;
//            while(!queue.isEmpty()){
//                Node<E> node = queue.poll();
//                if(leaf && !node.isLeaf()) return false;
//
//                if(node.hasTwoChildren()){
//                    queue.offer(node.left);
//                    queue.offer(node.right);
//                }
//                else if(node.left==null && node.right!=null) return false;
//                else{
//                    leaf = true;
//                    if(node.left!=null) queue.offer(node.left);
//                }
//            }
//            return true;
//        }

    public int height(){
        if(root==null) return 0;
        int height=0;
        //每一层元素个数
        int levelSize=1;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node<E> node = queue.poll();
            levelSize--;
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
            if(levelSize==0){
                height++;
                levelSize=queue.size();
            }
        }
        return height;
    }

    //层序遍历
    public void levelOrderTraversal(Visitor<E> visitor){
        if(root == null || visitor==null) return;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node<E> node = queue.poll();
            if(visitor.visit(node.element)) return;
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
    }


    //前序遍历
    public void preOrderTraversal(Visitor<E> visitor){
        if(visitor==null) return;
        preOrderTraversal(root,visitor);
    }
    private void preOrderTraversal(Node<E> node,Visitor<E> visitor){
        if(node == null || visitor.stop) return;
        visitor.stop =visitor.visit(node.element);
        preOrderTraversal(node.left,visitor);
        preOrderTraversal(node.right,visitor);
    }


    //中序遍历
    public void inOrderTraversal(Visitor<E> visitor){
        if(visitor==null) return;
        inOrderTraversal(root,visitor);
    }
    private void inOrderTraversal(Node<E> node,Visitor<E> visitor){
        if(node == null || visitor.stop) return;
        inOrderTraversal(node.left,visitor);
        if(visitor.stop) return;
        visitor.stop =visitor.visit(node.element);
        inOrderTraversal(node.right,visitor);
    }


    //后序遍历
    public void postOrderTraversal(Visitor<E> visitor){
        if(visitor==null) return;
        postOrderTraversal(root,visitor);
    }
    private void postOrderTraversal(Node<E> node,Visitor<E> visitor){
        if(node == null || visitor.stop) return;
        postOrderTraversal(node.left,visitor);
        postOrderTraversal(node.right,visitor);
        if(visitor.stop) return;
        visitor.stop =visitor.visit(node.element);
    }


    public BinarySearchTree(Comparator<E> comparator){
        this.comparator = comparator;
    }

    public BinarySearchTree(){
        this(null);
    }


    private static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;
        public Node(E element,Node<E>parent){
            this.element = element;
            this.parent = parent;
        }
        public boolean isLeaf(){
           return left == null && right == null;
        }

        public boolean hasTwoChildren(){
           return left != null && right != null;
        }
    }


    public int size(){
        return size;
    }


    public boolean isEmpty(){
        return size == 0;
    }


    public void add (E element){
        elementNotNullCheck(element);
        if(root == null){
            root = new Node<>(element,null);
            size++;
            return;
        }
        Node<E> parent = root;
        Node<E> node = root;
        int cmp = 0;
        while(node != null){
            cmp = compare(element,node.element);
            parent = node;
            if(cmp < 0){
                node = node.left;
            }
            else if(cmp > 0){
                node = node.right;
            }
            else{
                node.element = element;
                return;
            }
        }
        Node<E> newNode = new Node<>(element,parent);

        if(cmp > 0){
            parent.right = newNode;
        }else if(cmp < 0){
            parent.left = newNode;
        }
        size++;

    }
    private int compare(E element1, E element2){
        if(comparator!=null){
            return comparator.compare(element1,element2);
        }
        return ((Comparable<E>)element1).compareTo(element2);
    }


    public boolean contains(E element){
        return false;
    }


    public void clear(){}

    public void elementNotNullCheck(E element){
        if(element == null){
            throw new IllegalArgumentException("element must not be null");
        }
    }
    /*
//前序遍历
    public void preOrderTraversal(){
        preOrderTraversal(root);
    }
    private void preOrderTraversal(Node<E> node){
        if(node == null) return;
        System.out.println(node.element+"");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    //中序遍历
    public void inOrderTraversal(){
        inOrderTraversal(root);
    }
    private void inOrderTraversal(Node<E> node){
        if(node == null) return;
        inOrderTraversal(node.left);
        System.out.println(node.element+"");
        inOrderTraversal(node.right);
    }

    //后序遍历
    public void postOrderTraversal(){
        postOrderTraversal(root);
    }
    private void postOrderTraversal(Node<E> node){
        if(node == null) return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.println(node.element+"");
    }

    //层序遍历
    public void levelOrderTraversal(){
        if(root == null) return;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node<E> node = queue.poll();
            System.out.println(node.element+"");
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
    }
    */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(root,sb,"");
        return sb.toString();
    }
    private void toString(Node<E> node,StringBuilder sb,String prefix){
        if(node == null) return;
        toString(node.left,sb,prefix+"L---");
        sb.append(prefix).append(node.element).append("\n");
        toString(node.right,sb,prefix+"R---");
    }
}
