package com.example.helloworld.算法刷题.数组和Matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * @author： chenglin
 * @date： 2020-09-10 19:18
 * @description
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution217 {
    public boolean containsDuplicate(int[] nums){
        Set<Integer> set=new HashSet<>();
        for (int i=0;i<nums.length;i++){
            if (set.contains(nums[i]))return true;
            set.add(nums[i]);
        }
        return false;
    }
}
