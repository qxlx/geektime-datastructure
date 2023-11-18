package com.ncst.leetcode100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jiabaobao
 * @date 2023/10/23 9:17 PM
 */
public class Lc001 {

    public static void main(String[] args) {
        Lc001 lc001 = new Lc001();
        lc001.lengthOfLongestSubstring("abcabcbb");
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null) return -1;
        Map<Character,Integer> result = new HashMap<>();
        int max = 0;
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (result.containsKey(ch)) {
                left = Math.max(result.get(ch)+1,left);
            }
            result.put(ch,i); //记录当前位置
            max = Math.max(max,i - left + 1);
        }
        Set hash = new HashSet();
//        hash.contains()
        return max;
    }


    //int[][] 一维存储在第几个环上 二维存储有哪几种颜色
    //在遍历
    public int countPoints(String rings) {
        int [] array = new int [10];
        int color = 0;
        int n = rings.length();
        for (int i = 1; i < n; i+=2) {
            int index = rings.charAt(i) - '0';

            if (rings.charAt(i-1) == 'G') {
                array[index] |= 1;
            } else if (rings.charAt(i-1) == 'B') {
                array[index] |= 2;
            } else if (rings.charAt(i-1) == 'R') {
                array[index] |= 4;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 7) {
                color++;
            }
        }
        return color;
    }

}
