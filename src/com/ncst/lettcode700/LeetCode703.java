package com.ncst.lettcode700;

import java.util.PriorityQueue;

/**
 * @author jiabaobao
 * @date 2023/9/29 9:35 PM
 */
public class LeetCode703 {


}

class KthLargest {

    private final PriorityQueue<Integer> priorityQueue;
    private int K = 0;

    public KthLargest(int k, int[] nums) {
        this.K = k;
        priorityQueue = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.offer(nums[i]);
        }
    }

    public int add(int val) {
        if (priorityQueue.size() < K) {
            priorityQueue.offer(val);
        } else if (val > priorityQueue.peek()) {
            priorityQueue.poll();
            priorityQueue.offer(val);
        }
        return priorityQueue.peek();
    }
}
