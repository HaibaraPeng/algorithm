//给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。 
//
// 返回所有可能的结果。答案可以按 任意顺序 返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()())()"
//输出：["(())()","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：s = "(a)())()"
//输出：["(a())()","(a)()()"]
// 
//
// 示例 3： 
//
// 
//输入：s = ")("
//输出：[""]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 25 
// s 由小写英文字母以及括号 '(' 和 ')' 组成 
// s 中至多含 20 个括号 
// 
//
// Related Topics 广度优先搜索 字符串 回溯 👍 936 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        Solution solution = new RemoveInvalidParentheses().new Solution();
        solution.removeInvalidParentheses("()())()");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int len = 0;

        public List<String> removeInvalidParentheses(String s) {
            char[] chars = s.toCharArray();
            int left = 0, right = 0;
            for (char aChar : chars) {
                if (aChar == '(') {
                    left++;
                } else if (aChar == ')') {
                    right++;
                }
            }
            Set<String> res = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            dfs(res, sb, chars, 0, 0, 0, Math.min(left, right));
            return new ArrayList<>(res);
        }

        private void dfs(Set<String> res, StringBuilder sb, char[] chars, int index, int curLeft, int curRight, int max) {
            if (index == chars.length) {
                if (curLeft == curRight) {
                    if (sb.length() > len) {
                        res.clear();
                        len = sb.length();
                        res.add(sb.toString());
                    } else if (sb.length() == len) {
                        res.add(sb.toString());
                    }
                }
                return;
            }
            if (Character.isLetter(chars[index])) {
                sb.append(chars[index]);
                dfs(res, sb, chars, index + 1, curLeft, curRight, max);
                sb.deleteCharAt(sb.length() - 1);
            } else if (chars[index] == '(') {
                if (curLeft < max) {
                    // 添加括号
                    sb.append(chars[index]);
                    dfs(res, sb, chars, index + 1, curLeft + 1, curRight, max);
                    sb.deleteCharAt(sb.length() - 1);
                }
                // 不添加括号
                dfs(res, sb, chars, index + 1, curLeft, curRight, max);
            } else {
                if (curRight < curLeft) {
                    // 添加括号
                    sb.append(chars[index]);
                    dfs(res, sb, chars, index + 1, curLeft, curRight + 1, max);
                    sb.deleteCharAt(sb.length() - 1);
                }
                // 不添加括号
                dfs(res, sb, chars, index + 1, curLeft, curRight, max);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}