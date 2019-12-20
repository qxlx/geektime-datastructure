package com.ncst.queue;

/**
 * @author i
 * @create 2019/12/20 16:10
 * @Description 基于链表实现队列
 */
public class QueueBaseOnLikedList {
    private Node head;//头结点
    private Node tail;//尾结点

    //入队
    public void requeue(String value){
        //如果head节点为空 说明 没有数据
        if (head == null){
            head = new Node(value,null);
            tail = head;
            return;
        }
        //新结点指向tail节点的next节点  然后在将tail移动(赋值)到最后一个新结点上
        tail.next = new Node(value,null);
        tail = tail.next;
    }

    //出队
    public String dequeue(){
        //如果队列为空
        if (head == null){
            return null;
        }

        String value = head.data;
        head = head.next;
        return value;
    }

    //打印所有数据
    public void printfAll(){
        if (head == null){
            throw new NullPointerException("queue is empty!");
        }
        Node cur = head;
        while (cur!=null){
            System.out.print(cur.data+"\t");
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        QueueBaseOnLikedList queue = new QueueBaseOnLikedList();
        queue.requeue("1");
        queue.requeue("2");
        queue.requeue("3");
        queue.requeue("4");
        queue.requeue("5");

        queue.printfAll();
        //queue.printfAll();
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }


    private static class Node{
        private String data;//存储数据
        private Node next;//下一个结点

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node getNext() {
            return next;
        }
    }

}
