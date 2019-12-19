package com.ncst.likedlist;

/**
 * @author i
 * @create 2019/12/19 9:34
 * @Description 基于单链表实现LRU算法
 */
public class LRUBaseLikedList2 <T>{

    private static final Integer DEFAULT_CAPACITY = 5;//初始化容量

    private Integer capacity;//容量

    private Integer length;//长度

    private Node headNode;//头结点

    //指定默认大小
    public LRUBaseLikedList2(int capacity){
        this.capacity = capacity;
        headNode = new Node(null);
        length = 0;
    }

    //初始化默认大小
    public LRUBaseLikedList2(){
        this.capacity = DEFAULT_CAPACITY;
        headNode = new Node(null);
        length = 0;
    }

    public void add(T data){
        //查看当前数据的前一个结点
        Node preNode = serarchPreNode(data);
        if (preNode!=null){
        //如果找到
            //删除当前结点
            deleteCurNode(data);
            //添加到首结点上
            addFirstNode(data);
        }else {
        //如果没有找到
            if (length == capacity){
            //如果没有找到当 length==capacity 删除尾结点
                deleteLastNode();
            }
            //直接插入到首结点
            addFirstNode(data);
        }
    }

    private void deleteCurNode(T data){
        Node node = headNode;
        while (node.next!=null){
            if (data.equals(node.next.data)){
                break;
            }
            node = node.next;
        }
        Node curNodeNext = node.next.next;
        node.setNext(curNodeNext);
        length--;
    }

    private void deleteCurNode(Node pre){
        Node node = pre.next;
        pre.setNext(node.next);
        node = null;
        length--;
    }

    private void deleteLastNode(){
        Node node = headNode;
        while (node.next.next!=null){
            node = node.next;
        }
        Node temp = node.next;
        node.setNext(null);
        temp = null;
        length--;
    }

    private void addFirstNode(T data){
        Node node = headNode;
        Node nextNode = null;
        if (node.next!=null){
            nextNode = node.next;
            headNode.setNext(new Node(data,nextNode));
        }else {
            headNode.setNext(new Node(data));
        }
        length++;
    }

    private Node serarchPreNode(T data){
        Node head = headNode;
        while (head.next!=null){
            if (data.equals(head.next.data)){
                return head;
            }
            head = head.next;
        }
        return null;
    }

    public void printfAll(){
        Node node = headNode;
        while (node!=null){
            System.out.print(node.data+",");
            node = node.next;
        }
    }

    class Node<T>{
        private T data;
        private Node next;

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

    public static void main(String[] args) {
        LRUBaseLikedList2 list2 = new LRUBaseLikedList2();
        list2.add(0);
        list2.add(1);
        list2.add(2);
        list2.add(3);
//        list2.add(2);//6,3,2,1,
       //list2.add(5);
        list2.printfAll();

    }

}
