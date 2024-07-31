//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。 
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 贪心 数组 字符串 排序 👍 1277 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class LargestNumber {
    public static void main(String[] args) {
        Solution solution = new LargestNumber().new Solution();
        solution.largestNumber(new int[]{3, 30, 34, 5, 9, 94});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestNumber(int[] nums) {
            int n = nums.length;
            String[] strArr = new String[n];
            for (int i = 0; i < n; i++) {
                strArr[i] = String.valueOf(nums[i]);
            }
            Arrays.sort(strArr, (a, b) -> (b + a).compareTo(a + b));
            StringBuilder sb = new StringBuilder();
            for (String s : strArr) {
                sb.append(s);
            }
            int i = 0;
            while (i < sb.length() - 1 && sb.charAt(i) == '0') {
                i++;
            }
            return sb.substring(i);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}