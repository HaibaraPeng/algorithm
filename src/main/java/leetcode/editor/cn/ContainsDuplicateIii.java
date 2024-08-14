//给你一个整数数组 nums 和两个整数 indexDiff 和 valueDiff 。 
//
// 找出满足下述条件的下标对 (i, j)： 
//
// 
// i != j, 
// abs(i - j) <= indexDiff 
// abs(nums[i] - nums[j]) <= valueDiff 
// 
//
// 如果存在，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1], indexDiff = 3, valueDiff = 0
//输出：true
//解释：可以找出 (i, j) = (0, 3) 。
//满足下述 3 个条件：
//i != j --> 0 != 3
//abs(i - j) <= indexDiff --> abs(0 - 3) <= 3
//abs(nums[i] - nums[j]) <= valueDiff --> abs(1 - 1) <= 0
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,5,9,1,5,9], indexDiff = 2, valueDiff = 3
//输出：false
//解释：尝试所有可能的下标对 (i, j) ，均无法满足这 3 个条件，因此返回 false 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 1 <= indexDiff <= nums.length 
// 0 <= valueDiff <= 10⁹ 
// 
//
// Related Topics 数组 桶排序 有序集合 排序 滑动窗口 👍 736 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.TreeSet;

public class ContainsDuplicateIii {
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIii().new Solution();
        solution.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
            int n = nums.length;
            TreeSet<Long> set = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                Long ceiling = set.ceiling((long) nums[i] - (long) valueDiff);
                if (ceiling != null && ceiling <= (long) nums[i] + (long) valueDiff) {
                    return true;
                }
                set.add((long) nums[i]);
                if (i >= indexDiff) {
                    set.remove((long) nums[i - indexDiff]);
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}