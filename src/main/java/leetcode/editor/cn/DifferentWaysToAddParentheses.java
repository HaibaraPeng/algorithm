//给你一个由数字和运算符组成的字符串 expression ，按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。你可以 按任意顺序 返回答案。 
//
// 生成的测试用例满足其对应输出值符合 32 位整数范围，不同结果的数量不超过 10⁴ 。 
//
// 
//
// 示例 1： 
//
// 
//输入：expression = "2-1-1"
//输出：[0,2]
//解释：
//((2-1)-1) = 0 
//(2-(1-1)) = 2
// 
//
// 示例 2： 
//
// 
//输入：expression = "2*3-4*5"
//输出：[-34,-14,-10,-10,10]
//解释：
//(2*(3-(4*5))) = -34 
//((2*3)-(4*5)) = -14 
//((2*(3-4))*5) = -10 
//(2*((3-4)*5)) = -10 
//(((2*3)-4)*5) = 10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= expression.length <= 20 
// expression 由数字和算符 '+'、'-' 和 '*' 组成。 
// 输入表达式中的所有整数值在范围 [0, 99] 
// 
//
// Related Topics 递归 记忆化搜索 数学 字符串 动态规划 👍 891 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {
    public static void main(String[] args) {
        Solution solution = new DifferentWaysToAddParentheses().new Solution();
        solution.diffWaysToCompute("2-1-1");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<Integer> diffWaysToCompute(String expression) {
            return dfs(expression, 0, expression.length() - 1);
        }

        private List<Integer> dfs(String expression, int left, int right) {
            List<Integer> res = new ArrayList<>();
            for (int i = left; i <= right; i++) {
                if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
                    List<Integer> leftList = dfs(expression, left, i - 1);
                    List<Integer> rightList = dfs(expression, i + 1, right);
                    for (int leftNum : leftList) {
                        for (int rightNum : rightList) {
                            if (expression.charAt(i) == '+') {
                                res.add(leftNum + rightNum);
                            } else if (expression.charAt(i) == '-') {
                                res.add(leftNum - rightNum);
                            } else {
                                res.add(leftNum * rightNum);
                            }
                        }
                    }
                }
            }
            if (res.isEmpty()) {
                res.add(Integer.parseInt(expression.substring(left, right + 1)));
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}