package com.ncst.likedlist;

/**
 * @author i
 * @create 2019/12/18 21:11
 * @Description  基于单链表LRU算法
 *
 * 我们维护一个有序单链表，越靠近链表尾部的节点是越早之前访问的，当有一个新的数据被访问时，我们从链表头开始顺序遍历链表。
 *
 * 1.如果此数据之前在缓存在链表中了，我们遍历得到这个数据对应的节点，并将其从原来的位置删除，然后在插入到链表的头部。
 *
 * 2.如果此数据中没有缓存链表中，可以分为两个情况
 *
 * - 如果此时缓存没满，则将此节点直接插入到链表的头部。
 * - 如果此时缓存已满，则链表尾节点删除，则将新的数据节点插入链表的头部
 *
 */
public class LRUBasedLikedList <T>{

    private final static Integer DEFAULT_CAPACITY = 3;//默认10个大小

    private Node head;//头结点

    private Integer size;//大小

    private Integer capacity;//容量


    public LRUBasedLikedList(){
        this.capacity = DEFAULT_CAPACITY;
        this.head = new Node<>();
        this.size = 0;
    }

    public LRUBasedLikedList(int capacity){
        this.capacity = capacity;
        this.head = new Node<>();
        this.size = 0;
    }

    public void add(T data){
        //找到插入数据之前的节点
        Node preNode = findPreNode(data);

        if (preNode != null){
            deleteElementOption(preNode);
            insertElementAtBegin(data);
        }else {
            if (size>=this.capacity){
                deleteElementAtEnd();
            }
            insertElementAtBegin(data);
        }
    }

    private void deleteElementOption(Node node){
        Node temp =node.getNext();
        node.setNext(temp.getNext());
        temp = null;
        size--;
    }

    //链表头部插入节点
    private void insertElementAtBegin(T data){
        Node next = head.getNext();
        head.setNext(new Node(data, next));
        size++;
    }

    //获取查找到元素的前一个结点
    private Node findPreNode(T data){
        Node node = head;
        while (node.next!=null){
            if (data.equals(node.getNext().data)){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    //删除尾节点
    public void deleteElementAtEnd(){
        Node ptr= head;
        //空链表直接返回
        if (ptr.getNext() == null){
            return;
        }

        //倒数第二个节点
        while (ptr.getNext().getNext()!=null){
            ptr = ptr.getNext();
        }

        Node tmp = ptr.getNext();
        ptr.setNext(null);
        tmp = null;
        size--;
    }

    //打印所有
    private void printAll(){
        Node node = head;
        while(node!=null){
            System.out.println(node.getData()+",");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        LRUBasedLikedList lruBasedLikedList = new LRUBasedLikedList();
        for (int i = 0; i < 3; i++) {
            lruBasedLikedList.insertElementAtBegin(i);
        }
        //lruBasedLikedList.insertElementAtBegin(4);
        lruBasedLikedList.printAll();

    }

    class Node <T>{

        private T data;//数据域
        private Node next;//结点的next

        public Node(){
            this.next = null;
        }

        public Node(T data){
            this.data = data;
        }

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
    }

}
