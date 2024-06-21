//给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。 
//
// 
//
// 示例 1： 
//
// 
//输入:a = "11", b = "1"
//输出："100" 
//
// 示例 2： 
//
// 
//输入：a = "1010", b = "1011"
//输出："10101" 
//
// 
//
// 提示： 
//
// 
// 1 <= a.length, b.length <= 10⁴ 
// a 和 b 仅由字符 '0' 或 '1' 组成 
// 字符串如果不是 "0" ，就不含前导零 
// 
//
// Related Topics 位运算 数学 字符串 模拟 👍 1205 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

public class AddBinary {
    public static void main(String[] args) {
        Solution solution = new AddBinary().new Solution();
        System.out.println(solution.addBinary("1010", "1011"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            StringBuilder sb = new StringBuilder();
            int m = a.length(), n = b.length(), carry = 0;
            for (int i = 0; i < Math.max(m, n); i++) {
                int value;
                if (i >= m) {
                    value = b.charAt(n - i - 1) - '0' + carry;
                } else if (i >= n) {
                    value = a.charAt(m - i - 1) - '0' + carry;
                } else {
                    value = a.charAt(m - i - 1) - '0' + b.charAt(n - i - 1) - '0' + carry;
                }
                sb.append(value % 2);
                carry = value / 2;
            }
            if (carry == 1) {
                sb.append(carry);
            }
            return sb.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}