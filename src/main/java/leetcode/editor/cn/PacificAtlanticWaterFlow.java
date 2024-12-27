//有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。 “太平洋” 处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。 
//
// 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上
//单元格 高于海平面的高度 。 
//
// 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。 
//
// 返回网格坐标 result 的 2D 列表 ，其中 result[i] = [ri, ci] 表示雨水从单元格 (ri, ci) 流动 既可流向太平洋也可
//流向大西洋 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
//输出: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
// 
//
// 示例 2： 
//
// 
//输入: heights = [[2,1],[1,2]]
//输出: [[0,0],[0,1],[1,0],[1,1]]
// 
//
// 
//
// 提示： 
//
// 
// m == heights.length 
// n == heights[r].length 
// 1 <= m, n <= 200 
// 0 <= heights[r][c] <= 10⁵ 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 723 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        Solution solution = new PacificAtlanticWaterFlow().new Solution();
        solution.pacificAtlantic(new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            int m = heights.length, n = heights[0].length;
            // 是否能到达太平洋
            boolean[][] reach1 = new boolean[m][n];
            // 是否能到达大西洋
            boolean[][] reach2 = new boolean[m][n];
            // 是否访问达太平洋
            boolean[][] visited1 = new boolean[m][n];
            // 是否访问达大西洋
            boolean[][] visited2 = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                reach1[i][0] = true;
                reach2[i][n - 1] = true;
                dfs(i, 0, heights, reach1, visited1, m, n);
                dfs(i, n - 1, heights, reach2, visited2, m, n);
            }
            for (int j = 0; j < n; j++) {
                reach1[0][j] = true;
                reach2[m - 1][j] = true;
                dfs(0, j, heights, reach1, visited1, m, n);
                dfs(m - 1, j, heights, reach2, visited2, m, n);
            }
            List<List<Integer>> lists = new ArrayList<>(); // 存放结果
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (reach1[i][j] && reach2[i][j]) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(j);
                        lists.add(list);
                    }
                }
            }
            return lists;
        }

        public void dfs(int i, int j, int[][] heights, boolean[][] reach, boolean[][] visited, int m, int n) {
            if (visited[i][j]) {
                return;
            }
            visited[i][j] = true;
            if (i - 1 >= 0 && heights[i][j] <= heights[i - 1][j]) {
                reach[i - 1][j] = true;
                dfs(i - 1, j, heights, reach, visited, m, n);
            }
            if (i + 1 < m && heights[i][j] <= heights[i + 1][j]) {
                reach[i + 1][j] = true;
                dfs(i + 1, j, heights, reach, visited, m, n);
            }
            if (j - 1 >= 0 && heights[i][j] <= heights[i][j - 1]) {
                reach[i][j - 1] = true;
                dfs(i, j - 1, heights, reach, visited, m, n);
            }
            if (j + 1 < n && heights[i][j] <= heights[i][j + 1]) {
                reach[i][j + 1] = true;
                dfs(i, j + 1, heights, reach, visited, m, n);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}