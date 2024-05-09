//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 3573 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        solution.generateParenthesis(2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            dfs(0, n * 2, n, 0, "", res);
            return res;
        }

        private void dfs(int i, int n, int max, int score, String str, List<String> res) {
            if (i == n) {
                if (score == 0) {
                    res.add(str);
                }
            } else {
                if (score + 1 <= max) {
                    dfs(i + 1, n, max, score + 1, str + "(", res);
                }
                if (score - 1 >= 0) {
                    dfs(i + 1, n, max, score - 1, str + ")", res);
                }
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}