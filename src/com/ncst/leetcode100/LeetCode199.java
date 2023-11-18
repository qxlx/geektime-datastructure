package com.ncst.leetcode100;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * @author jiabaobao
 * @date 2023/10/18 8:01 AM
 */
public class LeetCode199 {

//    public List<Integer> rightSideView(TreeNode root) {
//        List<Integer> result = new ArrayList();
//        if (root == null) return result;
//
//        Queue<TreeNode> queue = new LinkedList<>();
//    }

    public static void main(String[] args) {
        LeetCode199 leetCode199 = new LeetCode199();
        int sum = leetCode199.maxSatisfaction(new int[]{4,3,2});
        System.out.println(sum);
    }

    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int sum = 0;
        int f =0;
        for (int i = satisfaction.length-1 ; i >= 0; i--) {
            sum+=satisfaction[i];
            if (sum <= 0) break;
            f += sum;
        }
        return f;
    }

}
