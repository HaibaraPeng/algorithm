//给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。 
//
// 整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2 。 
//
// 返回被除数 dividend 除以除数 divisor 得到的 商 。 
//
// 注意：假设我们的环境只能存储 32 位 有符号整数，其数值范围是 [−2³¹, 231 − 1] 。本题中，如果商 严格大于 231 − 1 ，则返回 2
//31 − 1 ；如果商 严格小于 -2³¹ ，则返回 -2³¹ 。 
//
// 
//
// 示例 1: 
//
// 
//输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = 3.33333.. ，向零截断后得到 3 。 
//
// 示例 2: 
//
// 
//输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = -2.33333.. ，向零截断后得到 -2 。 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= dividend, divisor <= 2³¹ - 1 
// divisor != 0 
// 
//
// Related Topics 位运算 数学 👍 1226 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

public class DivideTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new DivideTwoIntegers().new Solution();
        System.out.println(solution.divide(-2147483648, -1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int INF = Integer.MAX_VALUE;

        public int divide(int dividend, int divisor) {
            long a = dividend, b = divisor;
            boolean flag = false;
            if ((a < 0 && b > 0) || (a > 0 && b < 0)) flag = true;
            if (a < 0) a = -a;
            if (b < 0) b = -b;
            long l = 0, r = a;
            while (l < r) {
                long mid = l + r + 1 >> 1;
                if (mul(mid, b) <= a) l = mid;
                else r = mid - 1;
            }
            r = flag ? -r : r;
            if (r > INF || r < -INF - 1) return INF;
            return (int) r;
        }

        public Long mul(long a, long b) {
            long res = 0;
            while (b != 0) {
                if ((b & 1) == 1) res += a;
                b >>= 1;
                a <<= 1;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}