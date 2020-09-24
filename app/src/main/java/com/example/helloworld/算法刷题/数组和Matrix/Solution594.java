package com.example.helloworld.算法刷题.数组和Matrix;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.HashMap;

/**
 * @author： chenglin
 * @date： 2020-09-17 18:34
 * @description
 *
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
 *
 * 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
 *
 * 示例 1:
 *
 * 输入: [1,3,2,2,5,2,3,7]
 * 输出: 5
 * 原因: 最长的和谐数组是：[3,2,2,2,3].
 * 说明: 输入的数组长度最大不超过20,000.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-harmonious-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution594 {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public int findLHS(int[] nums){
        HashMap<Integer,Integer> map=new HashMap<>();
        int res=0;
        for (int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
            if (map.containsKey(num+1)){
                res=Math.max(res,map.get(num)+map.get(num+1));
            }
            if (map.containsKey(num-1)){
                res=Math.max(res,map.get(num)+map.get(num-1));
            }
        }
        return res;
    }
}
