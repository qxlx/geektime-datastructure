package com.ncst.leetcode100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jiabaobao
 * @date 2023/11/5 9:48 AM
 */
public class Lc187 {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 10) return result;

        Map<String,Integer>  mapResult = new HashMap<>();
        for (int i = 0; i + 10 < s.length() ; i++) {
            String substring = s.substring(i, i + 10);
            Integer num = mapResult.getOrDefault(substring, 0);
            if (num == 1) result.add(substring);
            mapResult.put(substring,num++);
        }
        return result;
    }

    public static void main(String[] args) {
        Lc187 lc187 = new Lc187();
    }

    public int findChampion(int[][] grid) {
        int n = grid.length;
        int max = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length ; j++) {
                if (grid[i][j] == 1) {
                    max = i;
                }
            }
        }
        return max;
    }
}
