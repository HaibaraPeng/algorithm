//给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。 
//
// 答案字符串中的所有字母都应该是小写字符，并且除了 0 本身之外，答案中不应该有任何前置零。 
//
// 注意: 不允许使用任何由库提供的将数字直接转换或格式化为十六进制的方法来解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 26
//输出："1a"
// 
//
// 示例 2： 
//
// 
//输入：num = -1
//输出："ffffffff"
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= num <= 2³¹ - 1 
// 
//
// Related Topics 位运算 数学 👍 311 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

public class ConvertANumberToHexadecimal {
    public static void main(String[] args) {
        Solution solution = new ConvertANumberToHexadecimal().new Solution();
        solution.toHex(26);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String toHex(int num) {
            if (num == 0) {
                return "0";
            }
            long temp = num;
            if (temp < 0) {
                temp = (long) Math.pow(2, 32) + temp;
            }
            StringBuilder res = new StringBuilder();
            while (temp > 0) {
                long value = temp % 16;
                temp = temp / 16;
                if (value < 10) {
                    res.append(value);
                } else {
                    res.append((char) (value - 10 + 'a'));
                }
            }
            return res.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}