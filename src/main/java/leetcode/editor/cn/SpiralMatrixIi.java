//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1292 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

public class SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
        solution.generateMatrix(3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] res = new int[n][n];
            dfs(res, 0, 0, n - 1, n - 1, 1, n * n);
            return res;
        }

        private void dfs(int[][] arr, int minx, int miny, int maxx, int maxy, int index, int end) {
            if (index > end) {
                return;
            }
            if (minx == maxx) {
                for (int i = miny; i <= maxy; i++) {
                    arr[minx][i] = index++;
                }
                return;
            }
            if (miny == maxy) {
                for (int i = minx; i <= maxx; i++) {
                    arr[i][miny] = index++;
                }
                return;
            }
            for (int i = miny; i < maxy; i++) {
                arr[minx][i] = index++;
            }
            for (int i = minx; i < maxx; i++) {
                arr[i][maxy] = index++;
            }
            for (int i = maxy; i > miny; i--) {
                arr[maxx][i] = index++;
            }
            for (int i = maxx; i > minx; i--) {
                arr[i][miny] = index++;
            }
            dfs(arr, minx + 1, miny + 1, maxx - 1, maxy - 1, index, end);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}