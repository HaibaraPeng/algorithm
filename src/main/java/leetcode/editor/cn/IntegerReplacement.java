//给定一个正整数 n ，你可以做如下操作： 
//
// 
// 如果 n 是偶数，则用 n / 2替换 n 。 
// 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。 
// 
//
// 返回 n 变为 1 所需的 最小替换次数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 8
//输出：3
//解释：8 -> 4 -> 2 -> 1
// 
//
// 示例 2： 
//
// 
//输入：n = 7
//输出：4
//解释：7 -> 8 -> 4 -> 2 -> 1
//或 7 -> 6 -> 3 -> 2 -> 1
// 
//
// 示例 3： 
//
// 
//输入：n = 4
//输出：2
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
// Related Topics 贪心 位运算 记忆化搜索 动态规划 👍 314 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class IntegerReplacement {
    public static void main(String[] args) {
        Solution solution = new IntegerReplacement().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Integer, Integer> map = new HashMap<>();

        public int integerReplacement(int n) {
            if (n == 1) {
                map.put(1, 0);
                return 0;
            }
            if (map.containsKey(n)) return map.get(n);
            int res;
            if (n % 2 == 0) {
                res = 1 + integerReplacement(n / 2);
            } else {
                res = 2 + Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1));
            }
            map.put(n, res);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}