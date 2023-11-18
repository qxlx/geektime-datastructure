package com.ncst.leetcode100;

/**
 * @author jiabaobao
 * @date 2023/11/17 11:17 PM
 */
public class Lc434 {

    public static void main(String[] args) {
        int i = countSegments("Hello, my name is John");
        System.out.println(i);
    }

    public static int countSegments(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            while (i < s.length() && s.charAt(i) != ' ') {
                i++;
            }
            count++;
        }
        return count;
    }

}
