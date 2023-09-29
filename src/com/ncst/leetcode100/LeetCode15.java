package com.ncst.leetcode100;


import java.util.*;

/**
 * 三数之和
 * @author jiabaobao
 * @date 2023/9/29 10:54 AM
 */
public class LeetCode15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.EMPTY_LIST;

        Set<List<Integer>> resultList = new LinkedHashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int head = i+1;
            int tail = nums.length -1;
            while (head < tail) {
                int sum = -(nums[head] + nums[tail]);
                if (sum == nums[i]) {
                    List<Integer> list = Arrays.asList(nums[i],nums[tail],nums[head]);
                    resultList.addAll(Collections.singleton(list));
                }
                if (sum > nums[i]) {
                    tail--;
                } else {
                    head++;
                }
            }
        }
        return new ArrayList<>(resultList);
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,-2,1};
        List<List<Integer>> lists = threeSum(nums);

    }

}
