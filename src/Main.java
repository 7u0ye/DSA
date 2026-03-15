public class Main {
    public static void main(String[] args) {
        arraylist list = new arraylist();
        list.add(1);
        list.add(2);
        list.set(1,3);
        list.add(3);
        list.add(4);
        list.add(5);
        list.remove(0);
        System.out.println(list);
        int a = list.get(0);
        System.out.println(a);
        System.out.println(list.isEmpty());
        System.out.println(list.contains(1));
        System.out.println(list);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
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