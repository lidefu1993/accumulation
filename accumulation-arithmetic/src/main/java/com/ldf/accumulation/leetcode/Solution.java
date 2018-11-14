package com.ldf.accumulation.leetcode;

import com.ldf.accumulation.domain.ListNode;
import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 两数相加
 * Created by ldf on 2018/11/5.
 */
public class Solution {

    /**
     *
     * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     示例：
       输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
       输出：7 -> 0 -> 8
       原因：342 + 465 = 807
     */


    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = solution.listNode("342");
        ListNode l2 = solution.listNode("465");
        ListNode listNode = solution.addTwoNumbers2(l1, l2);
        System.out.println(1);
    }


    /**
     * 思路1(失败-》存在很大的数，且BigInteger编译不过)：
     *  将l1,l2 转换为对应的数字 -》求和sum -》将数字sum转换为listNode
     * @param l1
     * @param l2
     * @return
     */
    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = null;
        long i1 = Long.valueOf(getValByListNode(l1));
        long i2 = Long.valueOf(getValByListNode(l2));
        long sum = i1 + i2;
        listNode = listNode(String.valueOf(sum));
        return listNode;
    }

    /**
     * 将listNode转换为所代表的的数字
     * 遍历取next next为空时 停止遍历
     * @param listNode
     * @return
     */
    private String getValByListNode(ListNode listNode){
        ListNode next = listNode.next;
        List<Integer> integerList = new ArrayList<Integer>();
        integerList.add(listNode.val);
        while (next != null) {
            integerList.add(next.val);
            next = next.next;
        }
        Collections.reverse(integerList);
        StringBuilder sb = new StringBuilder();
        integerList.stream().forEach(integer -> {
            sb.append(integer);
        });
        return sb.toString();
    }


    /**
     * 根据数字构建ListNode结构
     * 将数字字符串拆分为单个数字的集合，遍历集合 当前数字对应的ListNode的next为上一个数字对应的ListNode
     * @param numStr
     * @return
     */
    private ListNode listNode(String numStr){
        ListNode listNode = null;
        String[] split = numStr.split("");
        for (int i = 0; i < split.length; i++){
            if(i == 0 ){
                listNode = new ListNode(Integer.valueOf(split[i]));
            }else {
                ListNode currentListNode = new ListNode(Integer.valueOf(split[i]));
                currentListNode.next = listNode;
                listNode = currentListNode;
            }
        }
        return listNode;
    }

    /**
     * 思路2：模拟两数相加
     * 得到l1、l2对应的数字 然后将其转为两个数组 新建一个数组存储他们的和的各个位数的值
     * @param l1
     * @param l2
     * @return
     */
    private ListNode addTwoNumbers2(ListNode l1, ListNode l2){
        ListNode listNode = null;
        List<Integer> intL1 = getIntegerList(l1);
        List<Integer> intL2 = getIntegerList(l2);
        List<Integer> sumList = getIntegerListSum(intL1, intL2);
        StringBuilder sb = new StringBuilder();
        sumList.stream().forEach(sum -> {
            sb.append(sum);
        });
        listNode = listNode(sb.toString());
        return listNode;
    }

    /**
     * 两个数字 对应的数组求和
     * @param intL1
     * @param intL2
     * @return
     */
    private List<Integer> getIntegerListSum(List<Integer> intL1, List<Integer> intL2){
        List<Integer> result = new ArrayList<>();
        int extra = 0;
        int size = intL1.size() >= intL2.size() ? intL1.size() : intL2.size();
        for(int i = 0; i < size; i++){
            int l1Val = 0, l2Val = 0;
            if(i >= intL1.size()) l1Val = 0 ; else l1Val = intL1.get(i);
            if(i  >=  intL2.size()) l2Val = 0; else l2Val = intL2.get(i);
            int i1 = l1Val + l2Val + extra;
            if(i1 > 9) {
                extra = 1;
                i1 -= 10;
            }else extra = 0;
            result.add(i1);
        }
        if(extra == 1) result.add(1);
        Collections.reverse(result);
        return result;
    }

    /**
     * 从listNode中获取其对应数字的各个位数的值组成的集合 个位---》
     * @param listNode
     * @return
     */
    private List<Integer> getIntegerList(ListNode listNode){
        ListNode next = listNode.next;
        List<Integer> integerList = new ArrayList<>();
        integerList.add(listNode.val);
        while (next != null) {
            integerList.add(next.val);
            next = next.next;
        }
        return integerList;
    }




}
