
import com.qinyuan.Stack;
import com.qinyuan.circle.CircleLinkedList;
import com.qinyuan.circle.CircleSingleLinkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
//约瑟夫环
    public static void Josephus(){
        CircleLinkedList<Integer> list = new CircleLinkedList();
        for (int i = 1; i <=10 ; i++) {
            list.add(i);
        }
        list.reset();
        while(!list.isEmpty()){
            list.next();
            list.next();
            list.next();
            list.next();
            System.out.println(list.remove());
        }
    }
//        if (n < 2) {
//            return n;
//        }
//        return fib1(n-1) + fib1(n-2);
//    }
//    public static int fib2 (int n) {
//        int first = 0;
//        int second = 1;
//        for (int i = 0; i < n-1; i++) {
//            int temp = second;
//            second = first + second;
//            first = temp;
//        }
//        return second;
//    }


}