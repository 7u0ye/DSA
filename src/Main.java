
import com.qinyuan.Deque;
import com.qinyuan.Queue;
import com.qinyuan.Stack;
import com.qinyuan.circle.CircleLinkedList;
import com.qinyuan.circle.CircleSingleLinkedList;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        deque.enQueueFront(11);
        deque.enQueueFront(12);
        deque.enQueueRear(13);
        deque.enQueueRear(14);
        while(!deque.isEmpty()){
            System.out.println(deque.deQueueFront());
        }
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