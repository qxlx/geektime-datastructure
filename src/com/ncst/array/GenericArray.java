package com.ncst.array;

/**
 * @author i
 * @create 2019/11/2 21:42
 * @Description ArrayList实现
 */
public class GenericArray<T> {
    private T[] data;
    private int size;

    //默认10个大小
    public GenericArray() {
        this(10);
    }

    public GenericArray(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }

    //获取容量
    public int getCapacity() {
        return size;
    }

    //设置
    public void set(int index, T t) {
        checkIndex(index);
        for (int i = index; i <= size; i++) {
            data[i + 1] = data[i];
        }
        data[index] = t;
    }

    //获取index
    public T get(int index) {
        return data[index];
    }

    //是否包含
    public boolean contains(T t) {
        for (int i = 0; i < size; i++) {
            if (data[i] == t) {
                return true;
            }
        }
        return false;
    }

    //查找元素下标
    public int find(T t) {
        for (int i = 0; i < size; i++) {
            if (data[i] == t) {
                return i;
            }
        }
        return -1;
    }

    //添加
    public void add(T t) {
        data[size++] = t;
    }

    public void addFirst(T t) {
        data[0] = t;
    }

    public void addLast(T t) {
        data[size] = t;
    }

    // 删除 index 位置的元素，并返回
    public T remove(int index) {
        checkIndexForRemove(index);

        T ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size --;
        data[size] = null;

        // 缩容
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return ret;
    }

    //实现动态扩容
    public void resize(int capacity) {
        if (size == data.length) {
            T[] newData = (T[]) new Object[capacity * 2];
            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(data[i]);
            if (i != size - 1)
                stringBuilder.append("\t");
        }
        return stringBuilder.toString();
    }

    //判断索引是否越界
    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is IllegalArgumentException index> 0 or index < size");
        }
    }

    //删除索引是否越界
    private void checkIndexForRemove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is Remove is index>0 or index < size");
        }
    }

    public static void main(String[] args) {
        GenericArray genericArray = new GenericArray();
        for (int i = 0; i < 10; i++) {
            genericArray.add(i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(genericArray.get(i));
        }
    }

}
