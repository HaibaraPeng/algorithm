//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [['1','0','1','0','0'],['1','0','1','1','1'],['1','1','1','1','1']
//,['1','0','0','1','0']]
//输出：6
//解释：最大矩形如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：matrix = [['0']]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：matrix = [['1']]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// rows == matrix.length 
// cols == matrix[0].length 
// 1 <= row, cols <= 200 
// matrix[i][j] 为 '0' 或 '1' 
// 
//
// Related Topics 栈 数组 动态规划 矩阵 单调栈 👍 1645 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaximalRectangle {
    public static void main(String[] args) {
        Solution solution = new MaximalRectangle().new Solution();
        System.out.println(solution.maximalRectangle(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            int[][] arr = new int[m][n];
            for (int i = 0; i < n; i++) {
                arr[0][i] = matrix[0][i] - '0';
            }
            for (int i = 1; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '1') {
                        arr[i][j] = arr[i - 1][j] + 1;
                    }
                }
            }
            int max = 0;
            for (int i = 0; i < m; i++) {
                max = Math.max(max, largestRectangleArea(arr[i]));
            }
            return max;
        }

        public int largestRectangleArea(int[] arr) {
            int n = arr.length;
            int[] left = new int[n], right = new int[n];
            Arrays.fill(right, n - 1);
            Deque<Integer> stack = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && arr[stack.getLast()] > arr[i]) {
                    Integer last = stack.removeLast();
                    right[last] = i - 1;
                }
                stack.addLast(i);
            }
            stack.clear();
            for (int i = n - 1; i >= 0; i--) {
                while (!stack.isEmpty() && arr[stack.getLast()] > arr[i]) {
                    Integer last = stack.removeLast();
                    left[last] = i + 1;
                }
                stack.addLast(i);
            }
            int max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, (right[i] - left[i] + 1) * arr[i]);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}