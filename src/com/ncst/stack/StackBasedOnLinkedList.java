package com.ncst.stack;

/**
 * @author i
 * @create 2019/12/19 20:56
 * @Description 基于链表实现栈
 */
public class StackBasedOnLinkedList<T>{

    private Node top;//设置一个top 用来标记栈顶

    //出栈
    public void push(int value) {
        Node newNode = new Node(value, null);
        if (top == null) {
            top = newNode;
            return;
        }
        newNode.next = top;//将newNode的next设置为top
        top = newNode;//将newNode设置为栈顶结点
    }

    //入栈
    public T pop(){
        if (top == null){
            throw  new NullPointerException("statck is empty!");
        }
        T value = (T) top.data;
        top = top.next;
        return value;
    }

    //打印
    public void printfAll(){
        if (top == null){
            return;
        }

        Node cur = top;
        while (cur!=null){
            System.out.print(cur.data+",");
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        StackBasedOnLinkedList s = new StackBasedOnLinkedList();
        s.push(1);
        s.push(2);
        s.push(3);
        s.printfAll();
//        System.out.println(s.pop());
//        System.out.println(s.pop());
//        System.out.println(s.pop());

    }

    //创建节点
    private class Node<T> {
        private T data;
        private Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

    }

}
