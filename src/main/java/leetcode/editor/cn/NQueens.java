//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。 
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
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
// Related Topics 数组 回溯 👍 2083 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
        solution.solveNQueens(4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> res = new ArrayList<>();
            int[] arr = new int[n];
            Arrays.fill(arr, -1);
            dfs(res, new ArrayList<>(), arr, n, 0);
            return res;
        }

        private void dfs(List<List<String>> res, ArrayList<String> list, int[] arr, int n, int index) {
            if (index == n) {
                res.add(new ArrayList<>(list));
                return;
            }
            for (int i = 0; i < n; i++) {
                boolean flag = true;
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] < 0) {
                        break;
                    }
                    if (i == arr[j] || Math.abs(i - arr[j]) == (index - j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    arr[index] = i;
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < i; j++) {
                        sb.append(".");
                    }
                    sb.append("Q");
                    for (int j = i + 1; j < n; j++) {
                        sb.append(".");
                    }
                    list.add(sb.toString());
                    dfs(res, list, arr, n, index + 1);
                    arr[index] = -1;
                    list.remove(list.size() - 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}