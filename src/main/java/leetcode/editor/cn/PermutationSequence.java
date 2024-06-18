//给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。 
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下： 
//
// 
// "123" 
// "132" 
// "213" 
// "231" 
// "312" 
// "321" 
// 
//
// 给定 n 和 k，返回第 k 个排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, k = 3
//输出："213"
// 
//
// 示例 2： 
//
// 
//输入：n = 4, k = 9
//输出："2314"
// 
//
// 示例 3： 
//
// 
//输入：n = 3, k = 1
//输出："123"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 1 <= k <= n! 
// 
//
// Related Topics 递归 数学 👍 845 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public static void main(String[] args) {
        Solution solution = new PermutationSequence().new Solution();
        System.out.println(solution.getPermutation(4, 9));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String getPermutation(int n, int k) {
            StringBuilder sb = new StringBuilder();
            List<Integer> nums = new ArrayList<>();
            k--;
            for (int i = 1; i <= n; i++) {
                nums.add(i);
            }
            for (int i = 0; i < n; i++) {
                int step = 1, temp = n - i - 1;
                while (temp > 1) {
                    step = step * temp;
                    temp--;
                }
                int index = k / step;
                sb.append(nums.remove(index));
                k = k % step;
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}