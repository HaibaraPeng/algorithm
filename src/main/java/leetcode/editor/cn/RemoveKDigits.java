//给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。 
//
// 示例 1 ： 
//
// 
//输入：num = "1432219", k = 3
//输出："1219"
//解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
// 
//
// 示例 2 ： 
//
// 
//输入：num = "10200", k = 1
//输出："200"
//解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
// 
//
// 示例 3 ： 
//
// 
//输入：num = "10", k = 2
//输出："0"
//解释：从原数字移除所有的数字，剩余为空就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= num.length <= 10⁵ 
// num 仅由若干位数字（0 - 9）组成 
// 除了 0 本身之外，num 不含任何前导零 
// 
//
// Related Topics 栈 贪心 字符串 单调栈 👍 1089 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveKDigits {
    public static void main(String[] args) {
        Solution solution = new RemoveKDigits().new Solution();
        solution.removeKdigits("10200", 1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeKdigits(String num, int k) {
            int len = num.length();
            if (k >= len) {
                return "0";
            }
            int n = len - k;
            Deque<Character> stack = new ArrayDeque<>();
            for (int i = 0; i < len; i++) {
                char c = num.charAt(i);
                while (!stack.isEmpty() && stack.getLast() > c && k > 0) {
                    stack.removeLast();
                    k--;
                }
                stack.addLast(c);
            }

            // 结果拼接：从栈中取前 n 个字符，并且跳过前导 0
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                Character first = stack.removeFirst();
                if (sb.length() == 0 && first == '0') continue; // 跳过前导 0
                sb.append(first);
            }

            // 如果结果为空，则返回 "0"
            return sb.length() == 0 ? "0" : sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}