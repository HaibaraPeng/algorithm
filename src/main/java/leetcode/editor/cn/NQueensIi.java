//n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//输入：n = 4
//输出：2
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
// 
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
//
// Related Topics 回溯 👍 517 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class NQueensIi {
    public static void main(String[] args) {
        Solution solution = new NQueensIi().new Solution();
        System.out.println(solution.totalNQueens(9));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        Integer res = 0;

        public int totalNQueens(int n) {
            int[] arr = new int[n];
            Arrays.fill(arr, -1);
            dfs(arr, n, 0);
            return res;
        }

        private void dfs(int[] arr, int n, int index) {
            if (index == n) {
                res++;
                return;
            }
            for (int i = 0; i < n; i++) {
                boolean flag = true;
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] < 0) {
                        break;
                    }
                    if (arr[j] == i || Math.abs(arr[j] - i) == Math.abs(j - index)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    arr[index] = i;
                    dfs(arr, n, index + 1);
                    arr[index] = -1;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}