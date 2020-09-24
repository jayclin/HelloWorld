package com.example.helloworld.算法刷题.数组和Matrix;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author： chenglin
 * @date： 2020-09-22 19:39
 * @description
 * 给定一副牌，每张牌上都写着一个整数。
 *
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 *
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4,4,3,2,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 * 示例 2：
 *
 * 输入：[1,1,1,2,2,2,3,3]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 示例 3：
 *
 * 输入：[1]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 示例 4：
 *
 * 输入：[1,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]
 * 示例 5：
 *
 * 输入：[1,1,2,2,2,2]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[2,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution914 {
    boolean initFlag=false;
    List<Integer> primes=new ArrayList<>();
    public boolean hasGroupSizeX(int[] desk){
        if (initFlag==false){
            initFlag=true;
            boolean[] mark=new boolean[10000];
            for (int i=2;i<10000;i++){
                if (mark[i]){
                    continue;
                }
                primes.add(i);
                for (int j=i+i;j<10000;j+=i){
                    mark[j]=true;
                }
            }
        }

        List<Integer> cnt=new ArrayList<>();
//        int i=0;
        for (int v:desk){
            cnt.add(v);
        }
        int minIter=cnt.get(0);
        for (int i=0;i<cnt.size();i++){
            if (cnt.get(i)<minIter){
                minIter=cnt.get(i);
            }
        }

        if (minIter<=1)return false;

        for (int v:primes){
            if (desk.length%v!=0){
                continue;
            }
            if (v>minIter){
                break;
            }

            boolean flag=true;

            for (int i=0;i<cnt.size()&&flag;i++){
                if (cnt.get(i)%v!=0){
                    flag=false;
                }
            }
            if (flag){
                return true;
            }
        }
        return false;

    }
}
