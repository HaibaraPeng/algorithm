//给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位上的数字。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：n = 11
//输出：0
//解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
//
// Related Topics 数学 二分查找 👍 418 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

public class NthDigit {
    public static void main(String[] args) {
        Solution solution = new NthDigit().new Solution();
        System.out.println(solution.findNthDigit(10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findNthDigit(int n) {
            int d = 1, count = 9;
            while (n > (long) d * count) {
                n -= d * count;
                d++;
                count *= 10;
            }
            int index = n - 1;
            int start = (int) Math.pow(10, d - 1);
            int num = start + index / d;
            int numIndex = index % d;
            return (num / (int) (Math.pow(10, d - numIndex - 1))) % 10;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}