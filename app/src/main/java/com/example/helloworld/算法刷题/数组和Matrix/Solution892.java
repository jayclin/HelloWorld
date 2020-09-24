package com.example.helloworld.算法刷题.数组和Matrix;

/**
 * @author： chenglin
 * @date： 2020-09-22 18:57
 * @description
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 *
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 *
 * 请你返回最终形体的表面积。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[[2]]
 * 输出：10
 * 示例 2：
 *
 * 输入：[[1,2],[3,4]]
 * 输出：34
 * 示例 3：
 *
 * 输入：[[1,0],[0,2]]
 * 输出：16
 * 示例 4：
 *
 * 输入：[[1,1,1],[1,0,1],[1,1,1]]
 * 输出：32
 * 示例 5：
 *
 * 输入：[[2,2,2],[2,1,2],[2,2,2]]
 * 输出：46
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surface-area-of-3d-shapes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution892 {
    public int surfaceArea(int[][] grid){
        int n=grid.length,area=0;
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                int level=grid[i][j];
                if (level>0){
                    area+=(level<<2)+2;
                    area-=i>0?Math.min(level,grid[i-1][j])<<1:0;
                    area-=j>0?Math.min(level,grid[i][j-1])<<1:0;
                }
            }
        }
        return area;
    }
}
