package com.ncst.leetcode100;

import com.sun.jmx.snmp.SnmpNull;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author jiabaobao
 * @date 2023/10/15 11:32 AM
 */
public class LeetCode137 {

    public static int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        Map<Integer,Integer> resultMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (resultMap.containsKey(nums[i])) {
                int count = resultMap.get(nums[i]).intValue();
                count++;
                resultMap.put(nums[i],count);
            } else {
                resultMap.put(nums[i],1);
            }
        }

        for (Map.Entry<Integer, Integer> entry: resultMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ints = {2, 2, 3, 2};
        System.out.println(singleNumber(ints));
    }

}
