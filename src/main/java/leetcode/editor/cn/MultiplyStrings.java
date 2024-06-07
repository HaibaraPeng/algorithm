//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 
//输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 和 num2 只能由数字组成。 
// num1 和 num2 都不包含任何前导零，除了数字0本身。 
// 
//
// Related Topics 数学 字符串 模拟 👍 1341 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

public class MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new MultiplyStrings().new Solution();
        solution.multiply("2", "3");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            int m = num1.length(), n = num2.length();
            int[] res = new int[m + n];
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                    res[i + j + 1] += mul;
                }
            }
            for (int i = res.length - 1; i > 0; i--) {
                if (res[i] >= 10) {
                    res[i - 1] += res[i] / 10;
                    res[i] %= 10;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < res.length; i++) {
                if (sb.length() == 0 && res[i] == 0) {
                    continue;
                }
                sb.append(res[i]);
            }
            return sb.length() == 0 ? "0" : sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}