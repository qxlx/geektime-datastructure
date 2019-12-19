package com.ncst.stack;

import com.ncst.array.Array;

/**
 * @author i
 * @create 2019/12/19 19:47
 * @Description
 */
public class ArrayStack{

    private Integer [] data;//存储数据

    private Integer length;//长度

    private Integer capacity;//容量

    public ArrayStack(Integer capacity){
        data = new Integer[capacity];
        length = capacity;
        this.capacity = 0;
    }

    public void push(Integer value){
        if (capacity == length){
            throw new RuntimeException("statkc id is full!");
        }
        data[capacity] = value;
        capacity++;
    }

    public Integer pop(){
        if (capacity == 0){
            throw  new RuntimeException("stack id empty!");
        }
        Integer value = data[capacity-1];
        capacity--;
        return value;
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);

        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
    }

}
