//给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 13
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 10⁹ 
// 
//
// Related Topics 递归 数学 动态规划 👍 587 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

public class NumberOfDigitOne {
    public static void main(String[] args) {
        Solution solution = new NumberOfDigitOne().new Solution();
        System.out.println(solution.countDigitOne(13));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countDigitOne(int n) {
            if (n < 1) {
                return 0;
            }
            int num = n;
            int count = 0;
            while (num > 0) {
                if (num % 10 == 1) {
                    count++;
                }
                num /= 10;
            }
            return count + countDigitOne(n - 1);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}