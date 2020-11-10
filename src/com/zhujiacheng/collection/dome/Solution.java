package com.zhujiacheng.collection.dome;

/**
 * @Author Mr zhu
 * @Date 2020/9/1 18:48
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class Solution {

    public ListNode  ReverseList(ListNode head) {

        if(head==null||head.next==null) {
            return head;
        }
        ListNode cur=head;
        ListNode pre=null;
        ListNode next=null;
        while(cur!=null){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;


    }

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}