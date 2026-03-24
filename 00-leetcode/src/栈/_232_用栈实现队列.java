package 栈;

import java.util.Stack;

//https://leetcode.cn/problems/implement-queue-using-stacks/
public class _232_用栈实现队列 {
    class MyQueue {
        private Stack<Integer> inStack;
        private Stack<Integer> outStack;
        public MyQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        public void push(int x) {
            inStack.push(x);
        }

        public int pop() {
            checkOutsStack();
            return outStack.pop();
        }

        public int peek() {
            checkOutsStack();
            return outStack.peek();
        }

        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }
        private void checkOutsStack(){
            if(outStack.isEmpty()){
                while(!inStack.isEmpty()){
                    outStack.push(inStack.pop());
                }
            }
        }
    }
}
