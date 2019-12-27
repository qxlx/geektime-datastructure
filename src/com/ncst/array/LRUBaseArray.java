package com.ncst.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author i
 * @create 2019/12/21 15:31
 * @Description LRU基于数组实现
 *   1.使用缓存实现。定义一个Hash
 *   2.添加的时候 先看缓存中 有没有这个值 如果有 直接更新，左边的数据右移。
 *      如果没有的话，2.2 数组已满，直接删除最后一个元素。数组整体右移。将新的值当道0 index处
 *                  2.3 如果数组没满，直接数组整体右移 将新的值赋值到0 index处
 */
public class LRUBaseArray <T>{

    private static final Integer DEFAULT_CAPACITY = 10;//默认大小
    private Integer capacity = 0;
    private T [] data;
    private Map<T,Integer> dataMap;
    private Integer count = 0;

    public LRUBaseArray(int capacity){
        data =(T[]) (new Object[capacity]);
        this.capacity = capacity;
        count = 0;
        dataMap = new HashMap<T,Integer>(capacity);
    }

    public LRUBaseArray(){
        this(DEFAULT_CAPACITY);
    }

    public void add(T obj){
        if (obj == null){
            throw new IllegalArgumentException("IllegalArgumentException! obj == null");
        }
        //查找缓存中是否有值
        Integer index = dataMap.get(obj);
        //如果为空
        if (index == null){
            //如果满 直接删除最后一个元素 将需要添加的元素 添加到首部位置
            if (isFull()){
                deleteTail(obj);//删除最后元素
            }else {
                //直接添加
                cache(obj,count);
            }
        }else {
            //如果存在进行 更新处理
            updateCache(obj,index);
        }
    }

    private void cache(T object,int end){
        rightRemove(end);
        data[0] = object;
        dataMap.put(object,0);
        count++;
    }

    private void deleteTail(T obj){
        T value = data[--count];
        dataMap.remove(value);//缓存中删除
        cache(obj,count);
    }

    //更新值
    private void updateCache(T obj,int index){
        rightRemove(index);
        dataMap.put(obj,0);//更新
        data[0] = obj;
    }

    private void rightRemove(Integer index){
        for (int i = index-1; i >=0 ; i--) {
            data[i+1] = data[i];
            dataMap.put(data[i],i+1);
        }
    }

    public boolean containsKey(T obj){
        return dataMap.containsKey(obj);
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return count == capacity;
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append(data[i]+"\t");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LRUBaseArray array = new LRUBaseArray();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);

        System.out.println(array.toString());

    }

}
