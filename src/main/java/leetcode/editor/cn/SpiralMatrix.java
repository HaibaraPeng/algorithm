//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1698 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
        solution.spiralOrder(new int[][]{{1, 2, 3, 4}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList<>();
            dfs(res, matrix, 0, 0, matrix.length - 1, matrix[0].length - 1);
            return res;
        }

        private void dfs(List<Integer> res, int[][] matrix, int x, int y, int mMax, int nMax) {
            if (x > mMax || y > nMax) {
                return;
            }
            if (x == mMax) {
                for (int i = y; i <= nMax; i++) {
                    res.add(matrix[x][i]);
                }
                return;
            }
            if (y == nMax) {
                for (int i = x; i <= mMax; i++) {
                    res.add(matrix[i][y]);
                }
                return;
            }
            for (int i = y; i < nMax; i++) {
                res.add(matrix[x][i]);
            }
            for (int i = x; i < mMax; i++) {
                res.add(matrix[i][nMax]);
            }
            for (int i = nMax; i > y; i--) {
                res.add(matrix[mMax][i]);
            }
            for (int i = mMax; i > x; i--) {
                res.add(matrix[i][y]);
            }
            dfs(res, matrix, x + 1, y + 1, mMax - 1, nMax - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}