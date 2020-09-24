package com.example.helloworld.算法刷题.数组和Matrix;

/**
 * @author： chenglin
 * @date： 2020-09-14 18:42
 * @description
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 *
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution485 {
    public int findMaxConsecutiveOnes(int[] nums){
        //将0当作隔板，假设数组头尾都有一个0
        int pre=-1;
        int max=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0){
                max=Math.max(i-pre-1,max);
                pre=i;
            }
        }
        return Math.max(nums.length-pre-1,max);
    }

}
