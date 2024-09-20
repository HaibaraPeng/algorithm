//累加数 是一个字符串，组成它的数字可以形成累加序列。 
//
// 一个有效的 累加序列 必须 至少 包含 3 个数。除了最开始的两个数以外，序列中的每个后续数字必须是它之前两个数字之和。 
//
// 给你一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是 累加数 。如果是，返回 true ；否则，返回 false 。 
//
// 说明：累加序列里的数，除数字 0 之外，不会 以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。 
//
// 
//
// 示例 1： 
//
// 
//输入："112358"
//输出：true 
//解释：累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
// 
//
// 示例 2： 
//
// 
//输入："199100199"
//输出：true 
//解释：累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199 
//
// 
//
// 提示： 
//
// 
// 1 <= num.length <= 35 
// num 仅由数字（0 - 9）组成 
// 
//
// 
//
// 进阶：你计划如何处理由过大的整数输入导致的溢出? 
//
// Related Topics 字符串 回溯 👍 450 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

public class AdditiveNumber {
    public static void main(String[] args) {
        Solution solution = new AdditiveNumber().new Solution();
        System.out.println(solution.isAdditiveNumber("999999999999999999999999"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAdditiveNumber(String num) {
            if (num.length() < 3) {
                return false;
            }
            for (int i = 0; i < num.length() - 2; i++) {
                long first = Long.parseLong(num.substring(0, i + 1));
                if (i > num.length() / 2) {
                    break;
                }
                for (int j = i + 1; j < num.length() - 1; j++) {
                    if (j - i > num.length() / 2) {
                        break;
                    }
                    long second = Long.parseLong(num.substring(i + 1, j + 1));
                    if (isAdditiveNumber(num, first, second, j + 1, j + 2)) {
                        return true;
                    }
                    if (second == 0) {
                        break;
                    }
                }
                if (first == 0) {
                    break;
                }
            }
            return false;
        }

        public boolean isAdditiveNumber(String num, long first, long second, int start, int end) {
            long sum = first + second;
            if (end == num.length()) {
                return sum == Long.parseLong(num.substring(start, end));
            }
            long value = Long.parseLong(num.substring(start, end));
            if (value > sum) {
                return false;
            } else if (value == sum) {
                return isAdditiveNumber(num, second, sum, end, end + 1);
            } else if (value == 0) {
                return false;
            } else {
                return isAdditiveNumber(num, first, second, start, end + 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}