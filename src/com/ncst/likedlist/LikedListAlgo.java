package com.ncst.likedlist;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author i
 * @create 2019/12/19 15:49
 * @Description 1) 单链表反转
 * 2) 检查是否有环
 */
public class LikedListAlgo {


    public ListNode reverseList(ListNode head) {
        ListNode prev = null;//设置一个null结点
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next; //记录ListNode节点
            cur.next = prev;//将cur.next 设置为null
            prev = cur; //当前节点赋值成prev
            cur = next; //当前节点设置成cur
        }

        return prev;
    }

    //检查是否链表中有环
    //思路:定义一个快指针 和 一个慢指针 慢指针一次走一步 快指针一次走两步
    //如果有环 一定会相遇。多次循环
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fastNode = head.next;
        ListNode slowNode = head;

        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;

            if (slowNode == fastNode)
                return true;
        }
        return false;
    }

    //检查是否有环 - hash
    public boolean hasCycle2(ListNode head) {
        Set nodeSet = new HashSet();
        while (head != null) {
            if (nodeSet.contains(head)) {
                return true;
            }
            nodeSet.add(head);
            head = head.next;
        }
        return false;
    }

    //合并两个有序的链表
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0)
            return null;
        ListNode rootNode = null;
        while (len > 1) {
            for (int i = 0; i < len / 2; i++) {
                lists[i] = merageKList(lists[i],lists[len-1-i]);
            }
            len = (len+1)/2;
        }
        return lists[0];
    }

    //合并两个有序的链表
    private ListNode merageKList(ListNode l1, ListNode l2) {
        if (l1 == null)
            return null;
        if (l2 == null)
            return null;

        ListNode listNode = new ListNode(-1);
        ListNode head = listNode;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }

        if (l1 != null){
            head.next = l1;
        }else{
            head.next = l2;
        }
        return listNode.next; //note 注意返回的不是head 返回head 会带有 -1这个结点的值 只需要后边的值 牛掰思想
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);

    }

    static class ListNode<T> {
        Integer data;
        ListNode next;

        public ListNode(Integer data) {
            this.data = data;
        }

        public ListNode(Integer data, ListNode next) {
            this.data = data;
            this.next = next;
        }

        public Integer getData() {
            return data;
        }

        public void setData(Integer data) {
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
