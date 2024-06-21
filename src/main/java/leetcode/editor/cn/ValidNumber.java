//给定一个字符串 s ，返回 s 是否是一个 有效数字。 
//
// 例如，下面的都是有效数字："2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+
//7", "+6e-1", "53.5e93", "-123.456e789"，而接下来的不是："abc", "1a", "1e", "e3", "99e2.5
//", "--6", "-+3", "95a54e53"。 
//
// 一般的，一个 有效数字 可以用以下的规则之一定义： 
//
// 
// 一个 整数 后面跟着一个 可选指数。 
// 一个 十进制数 后面跟着一个 可选指数。 
// 
//
// 一个 整数 定义为一个 可选符号 '-' 或 '+' 后面跟着 数字。 
//
// 一个 十进制数 定义为一个 可选符号 '-' 或 '+' 后面跟着下述规则： 
//
// 
// 数字 后跟着一个 小数点 .。 
// 数字 后跟着一个 小数点 . 再跟着 数位。 
// 一个 小数点 . 后跟着 数位。 
// 
//
// 指数 定义为指数符号 'e' 或 'E'，后面跟着一个 整数。 
//
// 数字 定义为一个或多个数位。 
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "0" 
// 
//
// 输出：true 
//
// 示例 2： 
//
// 
// 输入：s = "e" 
// 
//
// 输出：false 
//
// 示例 3： 
//
// 
// 输入：s = "." 
// 
//
// 输出：false 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，或者点 '.' 。 
// 
//
// Related Topics 字符串 👍 380 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

public class ValidNumber {
    public static void main(String[] args) {
        Solution solution = new ValidNumber().new Solution();
        System.out.println(solution.isNumber("6.e6"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isNumber(String s) {
            if (s == null || s.isEmpty() || s.charAt(0) == 'e' || s.charAt(0) == 'E') {
                return false;
            }
            int eIndex = -1;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                    if (eIndex == -1) {
                        eIndex = i;
                    } else {
                        return false;
                    }
                }
            }
            if (eIndex > 0) {
                return isFloat(s.substring(0, eIndex)) && isInteger(s.substring(eIndex + 1));
            }
            return isFloat(s);
        }

        public boolean isFloat(String s) {
            if (s == null || s.isEmpty() || s.equals("+") || s.equals("-")) {
                return false;
            }
            if (s.charAt(0) == '+' || s.charAt(0) == '-') {
                s = s.substring(1);
            }
            if (s.equals(".")) {
                return false;
            }
            boolean flag = false;
            for (int index = 0; index < s.length(); index++) {
                if (Character.isDigit(s.charAt(index))) {
                } else if (s.charAt(index) == '.') {
                    if (flag) {
                        return false;
                    }
                    flag = true;
                } else {
                    return false;
                }
            }
            return true;
        }

        public boolean isInteger(String s) {
            if (s == null || s.isEmpty() || s.equals("+") || s.equals("-")) {
                return false;
            }
            if (s.charAt(0) == '+' || s.charAt(0) == '-') {
                s = s.substring(1);
            }
            for (int index = 0; index < s.length(); index++) {
                if (!Character.isDigit(s.charAt(index))) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}