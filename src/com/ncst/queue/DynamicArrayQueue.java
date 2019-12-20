package com.ncst.queue;

/**
 * @author i
 * @create 2019/12/20 17:07
 * @Description 动态的队列
 */
public class DynamicArrayQueue {
    private String[] data;//存储数据
    private Integer head;//头结点
    private Integer tail;//尾结点
    private Integer size;//队列大小

    //初始化
    public DynamicArrayQueue(int capacity){
        data = new String[capacity];
        head = 0;
        tail = 0;
        size = capacity;
    }

    //入队
    public void requeue(String value){
        //判断是否队列已满 满 进行动态移动
        if (tail == size){
            //扩容
            for (int i = head; i < tail; i++) {
                data[i-head] = data[i];
            }
            //数据动态移动后 恢复 head tail
            tail-=head;
            head = 0;
            data[tail] = value;
            tail++;
        }else {
            data[tail] = value;
            tail++;
        }
    }

    //出队
    public String dequeue(){
        checkQueueIsNull();
        String value = data[head];
        head++;
        return value;
    }

    //打印全部数据
    public void printfAll(){
        checkQueueIsNull();

        for (int i = head; i < tail; i++) {
            System.out.print(data[i]+"\t");
        }
        System.out.println();
    }

    //检查队列是否为空
    public void checkQueueIsNull(){
        if (head == tail){
            throw  new NullPointerException("queue is empty!");
        }
    }

    public static void main(String[] args) {
        DynamicArrayQueue queue = new DynamicArrayQueue(5);
        queue.requeue("1");
        queue.requeue("2");
        queue.requeue("3");
        queue.requeue("4");
        queue.requeue("5");

        queue.printfAll();

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        queue.requeue("6");
        queue.requeue("7");

        queue.printfAll();
    }

}
