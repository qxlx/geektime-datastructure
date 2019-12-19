package com.ncst.likedlist;

import java.awt.*;

/**
 * @author i
 * @create 2019/12/19 14:31
 * @Description
 *     单链表实现
 *     单链表的插入、删除、查找操作；
 *     链表中存储的是int类型的数据；
 */
public class SingleLikedList<T>{

    private Node head;//头结点

    //根据data查找结点
    public Node findByValue(T data){
        Node node = head;
        while (node.next!=null&& node.data != data){
            node = node.next;
        }
        return node;
    }

    //根据索引值查找结点
    public Node findByIndex(Integer index){
        Node node = head;
        int count = 0;
        while (node.next!=null&&count!=index){
            node = node.next;
            count++;
        }
        return node;
    }

    //插入到头结点
    public void insertToHead(int value){
        Node node = new Node(value,null);
        insertToHead(node);
    }

    private void insertToHead(Node node){
        //如果头结点为null直接插入
        if (head == null){
            head = node;
            return;
        }else {
            //如果头结点不为null 将头结点的next赋值给node.next
            //在将头结点的.next 修改成node
            node.next = head.next;
            head.next = node;
        }
    }

    //插入到头结点
    public void insertToTail(int value){
        Node newNode = new Node(value,null);
        if (head == null){
            head = newNode;
        }else {
            Node p = head;
            while(p.next!=null){
                p = p.next;
            }
            p.next = newNode;
        }
    }

    //添加到执行的节点前面
    public void insertAfter(Node node,int value){
        Node newNode = new Node(value,null);
        insertAfter(node,newNode);
    }

    private void insertAfter(Node node,Node newNode){
        if (node==null){
            return;
        }

        if (head == node){
            insertToHead(newNode);
            return;
        }

        Node p = head;
        while (p.next!=null&&p.next!=node){
            p = p.next;
        }

        if (p==null){
            return;
        }

        newNode.next = node;
        p.next = newNode;
    }

    //根据指定的node结点删除
    public void deleteByNode(Node delNode){
        if (head==null && delNode == null){
            return;
        }

        if (delNode == head){
            head = null;
            return;
        }

        Node p = head;
        while (p.next!=null && p!= delNode){
            p = p.next;
        }

        if (p!=null){
            p.next = p.next.next;
        }
    }

    //根据value值删除
    public void deleteByValue(T value){
        if (head == null){
            return;
        }

        Node p = head;
        Node q = null;
        while (p!=null && value!=p.data){
            q = p;
            p = p.next;
        }

        if (p==null){
            return;
        }
        if (q == null){
            head = head.next;
        }else {
            q.next = q.next.next;
        }

    }

    //打印所有结点
    public void printfAll(){
        Node node = head;
        while (node!=null){
            System.out.print(node.data+",");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        SingleLikedList list = new SingleLikedList();
        list.insertToHead(1);
        list.insertToHead(2);
        list.insertToHead(3);
        list.insertToHead(4);
        list.insertToHead(5);
        list.insertToTail(7);
        list.insertToTail(8);
        list.deleteByValue(7);
        //list.insertAfter(new Node(7,null),99);
        list.printfAll();
//        System.out.println(list.findByIndex(1));
//        System.out.println(list.findByValue(1));
    }

    static class Node<T>{
        private T data;
        private Node next;

        public Node(T data,Node next){
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

}
