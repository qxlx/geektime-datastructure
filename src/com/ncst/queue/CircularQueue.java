package com.ncst.queue;

/**
 * @author i
 * @create 2019/12/20 15:29
 * @Description 环形队列
 */
public class CircularQueue {
    private String[] data;//存储数据
    private Integer size = 0;//大小
    private Integer head = 0;//头结点
    private Integer tail = 0;//尾节点

    public CircularQueue(int capacity) {
        data = new String[capacity];
        size = capacity;
    }

    //入队
    public void requene(String value) {
        if ((tail + 1) % size == head) {//注意环形队列 为满的情况下 条件判断
            throw new RuntimeException("quene is full!");
        }
        data[tail] = value;
        tail = (tail + 1) % size;
    }

    //出队
    public String dequene() {
        checkQueneIsEmpty();

        String value = data[head];
        head = (head + 1) % size;
        return value;
    }

    //打印所有数据
    public void printfAll() {
        checkQueneIsEmpty();
        for (int i = head; i % size != tail; i = (i + 1) % size) { //i % size != tail  注意判断条件
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }

    private void checkQueneIsEmpty() {
        if (head == tail) {
            throw new RuntimeException("quene is empty!");
        }
    }

    public static void main(String[] args) {
        CircularQueue CircularQueue = new CircularQueue(5);
        CircularQueue.requene("1");
        CircularQueue.requene("2");
        CircularQueue.requene("3");
        CircularQueue.requene("4");

        CircularQueue.printfAll();

        System.out.println(CircularQueue.dequene());
        System.out.println(CircularQueue.dequene());

        CircularQueue.printfAll();

        CircularQueue.requene("6");

        CircularQueue.printfAll();
    }

}
