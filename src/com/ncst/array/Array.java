package com.ncst.array;

/**
 * @author i
 * @create 2019/11/2 18:21
 * @Description
 */
public class Array {

    int[] data;//数据
    int size;//容器大小
    int count;//已存储的元素

    public Array(int size) {
        data = new int[size];
        this.size = size;
        count = 0;
    }

    //遍历
    public void printf() {
        for (int i = 0; i < count; i++) {
            System.out.print(data[i] + "\t");
        }
    }

    //删除
    public void delete(int index) {
        int m = index;
        if (m < 0 || m > count)
            return;
        System.out.println("count:" + count);
        for (int i = m; i < count - 1; i++) {
            data[i] = data[i + 1];
        }
    }

    //添加
    public void add(int value) {
        if (count == size) {
            return;
        }
        data[count++] = value;
    }


    //修改
    public boolean update() {
        return false;
    }

    //根据下标查找
    public int get(int index) {
        return data[index];
    }

    public static void main(String[] args) {
        Array array = new Array(10);
        for (int i = 0; i < 10; i++) {
            array.add(i + 1);
        }

        array.printf();

        array.delete(1);

        array.printf();

    }

}
