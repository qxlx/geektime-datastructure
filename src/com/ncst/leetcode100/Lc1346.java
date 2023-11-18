package com.ncst.leetcode100;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jiabaobao
 * @date 2023/11/15 8:31 AM
 */
public class Lc1346 {

    public static void main(String[] args) {

    }

    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(num * 2) || set.contains(num / 4)) {
                return true;
            }
            set.add(num * 2);
        }
        return false;
    }




}
