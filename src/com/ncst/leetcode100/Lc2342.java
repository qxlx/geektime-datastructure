package com.ncst.leetcode100;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jiabaobao
 * @date 2023/11/18 9:42 AM
 */
public class Lc2342 {

    public static void main(String[] args) {
        Integer sum = getSum(18);
        System.out.println(sum);

    }

    //hashmap 保存key 以及对应的数之和
    //key保存数位和 value保存最大值相同数位的最大值
    public static int maximumSum(int[] nums) {
        Map<Integer, Integer> result = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int digitSum = getSum(nums[i]);
            if (result.containsKey(digitSum)) {
                //保存最大值
                max = Math.max(max, nums[i] + result.get(digitSum));
            }
            result.put(digitSum, Math.max(nums[i],result.getOrDefault(digitSum,0)));
        }
        return max;
    }

    private static Integer getSum(int num) {
        if (num <= 0) return -1;
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }


}
