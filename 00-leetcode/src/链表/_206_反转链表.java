package 链表;
//https://leetcode.cn/problems/reverse-linked-list/
public class _206_反转链表 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    class Solution {
        public ListNode reverseList(ListNode head) {
            if(head == null || head.next == null) return head;
            ListNode newNode = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return newNode;
        }

        public ListNode reverseList2(ListNode head) {
            if(head == null || head.next == null) return head;
            ListNode newNode = null;
            while(head != null){
                ListNode temp = head.next;
                head.next = newNode;
                newNode = head;
                head = temp;
            }
            return newNode;
        }
    }
}
