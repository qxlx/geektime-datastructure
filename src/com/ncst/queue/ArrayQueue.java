package com.ncst.queue;

/**
 * @author i
 * @create 2019/12/20 15:14
 * @Description 利用数组实现队列
 *
 */
public class ArrayQueue {
    private String [] data;//存储数据
    private Integer size = 0;//大小
    private Integer head = 0;//队列头
    private Integer tail = 0;//队尾

    //初始化
    public ArrayQueue(Integer capacity){
        data = new String[capacity];
        size = capacity;
    }

    //入队
    public String requene(String value){
        //如果队列为满
        if (tail == size){
            throw new RuntimeException("quene is full!");
        }
        data[tail] = value;
        tail++;
        return value;
    }

    //出队
    public String dequene(){
        //如果队列为空
        checkQueneIsEmpty();
        String value = data[head];
        head++;
        return value;
    }

    //打印所有
    public void printfAll(){
        checkQueneIsEmpty();
        for (int i = 0; i < tail ; i++) {
            System.out.print(data[i]+"\t");
        }
        System.out.println();
    }

    private void checkQueneIsEmpty(){
        if (head == tail){
            throw  new RuntimeException("quene is empty!");
        }
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.requene("1");
        arrayQueue.requene("2");
        arrayQueue.requene("3");
        arrayQueue.requene("4");
        arrayQueue.requene("5");

        arrayQueue.printfAll();

        System.out.println(arrayQueue.dequene());
        System.out.println(arrayQueue.dequene());
        System.out.println(arrayQueue.dequene());

    }

}
