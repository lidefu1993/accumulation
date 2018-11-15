package com.ldf.accumulation.leetcode;

import java.util.HashMap;
import java.util.*;
/**
 * 两数之和
 * Created by ldf on 2018/10/31.
 */
public class SumOfTwoNumbers {
    /**
     * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
     * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用
     * 示例：
     *  给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15, 12};
        int target = 22;
//        int[] ints = twoSum(nums, target);
        int[] ints = twoSum2(nums, target);
        System.out.println(ints[0] + " " + ints[1]);
    }

    /**
     * 基础解
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSum(int[] nums, int target){
        for(int i = 0; i < nums.length-1; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] + nums[j] == target) return new int[]{i,j};
            }
        }
        return null;
    }

    /**
     * 最优解
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSum2(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            int c = target - nums[i];
            if(map.containsKey(c) && map.get(c) != i) return new int[]{i, map.get(c)};
        }
        return null;
    }
}
