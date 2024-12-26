//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 2213 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new PartitionEqualSubsetSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {
            if (nums.length < 2) {
                return false;
            }
            int sum = 0, max = 0;
            for (int num : nums) {
                sum += num;
                max = Math.max(max, num);
            }
            if (sum % 2 != 0) {
                return false;
            }
            int target = sum / 2;
            if (max > target) {
                return false;
            }
            // 前面的元素和是否能凑出target
            boolean[][] dp = new boolean[nums.length][target + 1];
            dp[0][nums[0]] = true;
            for (int i = 0; i < nums.length; i++) {
                dp[i][0] = true;
            }
            for (int i = 1; i < nums.length; i++) {
                for (int j = 1; j <= target; j++) {
                    if (nums[i] > j) {
                        dp[i][j] = dp[i - 1][j];
                    } else if (nums[i] == j) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                    }
                }
            }
            return dp[nums.length - 1][target];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}