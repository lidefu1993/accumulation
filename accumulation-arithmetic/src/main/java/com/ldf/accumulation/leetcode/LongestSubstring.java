package com.ldf.accumulation.leetcode;

import java.util.*;

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
        System.out.println(substring.lengthOfLongestSubstring2("tmmzuxt"));
    }

    /**
     * 思路1：(失败---》例如："dvdf" 发现重复之后，从当前位置计算式不正确的，应该是与当前节点重复的节点的位置开始算起)
     * 循环字符串的字符，使用set集合存储不重复的连续字符，
     * 当出现重复后，记录当前set集合的size,初始化set集合，
     * 直至循环完成。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        if(s == null || s.isEmpty()) {
            return 0;
        }
        //不重复子串的最大长度
        int max = 0;
        int preSize;
        //储存不重复子串
        Set<String> set = new HashSet<>();
        String[] strings = s.split("");
        for (String string : strings) {
            preSize = set.size();
            set.add(string);
            if (preSize == set.size()) {
                max = (max > set.size()) ? max : set.size();
                set = new HashSet<>();
                set.add(string);
            }
        }
        max = (max > set.size()) ? max : set.size();
        return max;
    }

    /**
     * 思路2（失败 -》 超出内存限制）
     * 基于思路1进行了修改 发现重复后 重新 赋值源字符串（截取与当前字符重复的前一个字符的位置之后的部分）
     * 然后重新循环
     * @return
     */
    public int lengthOfLongestSubstring2(String s){
        if(s == null || s.isEmpty()) {
            return 0;
        }
        //不重复子串的最大长度
        int max = 0;
        List<String> strings = Arrays.asList(s.split(""));
        HashSet set = new HashSet();
        int preSize;
        int oldSize;
        while (strings.size() > 0){
            set = new HashSet();
            oldSize = strings.size();
            for (int i = 0; i < strings.size(); i++) {
                preSize = set.size();
                String current = strings.get(i);
                set.add(current);
                if (preSize == set.size()) {
                    max = (max > set.size()) ? max : set.size();
                    strings = sonList(strings, current);
                    break;
                }
                if(i == oldSize-1) {
                    strings = new ArrayList<>();
                }
            }
        }
        max = (max > set.size()) ? max : set.size();
        return max;
    }

    private List<String> sonList(List<String> oldList, String item){
        int i = oldList.indexOf(item);
        String[] oldArray = (String[]) oldList.toArray();
        int size = oldList.size() - i - 1;
        String[] newArray = new String[size];
        System.arraycopy(oldArray, i+1, newArray, 0, size);
        return Arrays.asList(newArray);
    }



}
