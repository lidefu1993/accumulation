package com.ldf.accumulation.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 * Created by ldf on 2018/11/15.
 */
public class LongestSubstring {

    /**
     * 给定一个字符串，找出不含有重复字符的最长子串的长度。
     示例 1:
     输入: "abcabcbb"
     输出: 3
     解释: 无重复字符的最长子串是 "abc"，其长度为 3。
     示例 2:
     输入: "bbbbb"
     输出: 1
     解释: 无重复字符的最长子串是 "b"，其长度为 1。
     示例 3:
     输入: "pwwkew"
     输出: 3
     解释: 无重复字符的最长子串是 "wke"，其长度为 3。
     请注意，答案必须是一个子串，"pwke" 是一个子序列 而不是子串。
     * @param args
     */

    public static void main(String[] args) {
        LongestSubstring substring = new LongestSubstring();
        System.out.println(substring.lengthOfLongestSubstring("dvdf"));
    }

    /**
     * 思路1：(失败---》例如："dvdf" 发现重复之后，从当前位置计算式不正确的，应该是与当前节点重复的节点的位置开始算起)
     * 循环字符串的字符，使用set集合存储不重复的连续字符，
     * 当出现重复后，记录当前set集合的size,初始化set集合，
     * 直至循环完成。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty()) return 0;
        int max = 0; //不重复子串的最大长度
        int preSize = 0;
        Set<String> set = new HashSet<>(); //储存不重复子串
        String[] strings = s.split("");
        for (int i = 0; i < strings.length; i++){
            preSize = set.size();
            String current = strings[i];
            set.add(current);
            if(preSize == set.size()){
                max = (max > set.size()) ? max : set.size();
                set = new HashSet<>();
                set.add(current);
            }
        }
        max = (max > set.size()) ? max : set.size();
        return max;
    }

}
