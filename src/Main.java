
import com.qinyuan.circle.CircleSingleLinkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        CircleSingleLinkedList list = new CircleSingleLinkedList();
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);
        list.remove(2);
        list.add(0,119);
        System.out.println(list);
    }

    //斐波那契
//    public static int fib1 (int n) {
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