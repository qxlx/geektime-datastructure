package com.ncst.likedlist;

import java.util.LinkedList;
import java.util.List;

/**
 * @author i
 * @create 2019/12/19 15:49
 * @Description
 *  1) 单链表反转
 */
public class LikedListAlgo {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;//设置一个null结点
        ListNode cur = head;
        while (cur!=null){
            ListNode next = cur.next; //记录ListNode节点
            cur.next = prev;//将cur.next 设置为null
            prev = cur; //当前节点赋值成prev
            cur = next; //当前节点设置成cur
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);

    }

    static class ListNode<T>{
        T data;
        ListNode next;

        public ListNode(T data) {
            this.data = data;
        }

        public ListNode(T data, ListNode next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }


}
