//给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。 
//
// 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 13
//输出：[1,10,11,12,13,2,3,4,5,6,7,8,9]
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 5 * 10⁴ 
// 
//
// Related Topics 深度优先搜索 字典树 👍 508 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    public static void main(String[] args) {
        Solution solution = new LexicographicalNumbers().new Solution();
        solution.lexicalOrder(1000);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<Integer> lexicalOrder(int n) {
            String str = String.valueOf(n);
            int length = str.length();
            List<Integer> res = new ArrayList<>();
            lexicalOrder(res, 0, length, n, 0, 1);
            return res;
        }

        /**
         * @param res
         * @param integer
         * @param length
         * @param i       位数
         * @param j
         */
        private void lexicalOrder(List<Integer> res, int integer, int length, int n, int i, int j) {
            if (j > 9) return;
            int newInteger = integer * 10 + j;
            if (i == length - 1 && newInteger > n) return;
            res.add(newInteger);
            if (i < length - 1) {
                lexicalOrder(res, newInteger, length, n, i + 1, 0);
            }
            lexicalOrder(res, integer, length, n, i, j + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}