
import com.qinyuan.BinarySearchTree;
import com.qinyuan.circle.CircleDeque;
import com.qinyuan.circle.CircleQueue;
import com.qinyuan.circle.CircleLinkedList;


public class Main {
    public static void main(String[] args) {
        int[]arr = {7,4,2,1,3,5,9,8,11,10,12};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for(int i=0;i<arr.length;i++) {
            bst.add(arr[i]);
        }
        System.out.println(bst);
        System.out.println(bst.height());

/*
        bst.preOrderTraversal(new BinarySearchTree.Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.print(element+" ");
                return element==1;
            }
        });
        System.out.println();
        bst.inOrderTraversal(new BinarySearchTree.Visitor<Integer>() {

            @Override
            public boolean visit(Integer element) {
                System.out.print(element+" ");
                return element==4;
            }
        });
        System.out.println();
        bst.postOrderTraversal(new BinarySearchTree.Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.print(element+" ");
                return element==5;
            }
        });
        System.out.println();
        bst.levelOrderTraversal(new BinarySearchTree.Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.print(element+" ");
                return element==2;
            }
        });

 */
    }
//约瑟夫环
//    public static void Josephus(){
//        CircleLinkedList<Integer> list = new CircleLinkedList();
//        for (int i = 1; i <=10 ; i++) {
//            list.add(i);
//        }
//        list.reset();
//        while(!list.isEmpty()){
//            list.next();
//            list.next();
//            list.next();
//            list.next();
//            System.out.println(list.remove());
//        }
//    }

    //斐波那契
//    public static int fib1(int n){
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