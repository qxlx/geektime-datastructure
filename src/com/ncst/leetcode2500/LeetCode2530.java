package com.ncst.leetcode2500;

import java.util.PriorityQueue;

/**
 * @author jiabaobao
 * @date 2023/10/18 7:41 AM
 */
public class LeetCode2530 {

    public long maxKelements(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            priorityQueue.offer(num);
        }
        long result = 0;
        while (k-- >0) {
            Integer maxValue = priorityQueue.poll();
            result += maxValue;
            priorityQueue.offer((maxValue + 2) / 3);
        }
        return result;
    }
}
