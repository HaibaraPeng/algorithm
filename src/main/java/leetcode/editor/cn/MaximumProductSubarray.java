//给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 测试用例的答案是一个 32-位 整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 
//输入: nums = [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -10 <= nums[i] <= 10 
// nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数 
// 
//
// Related Topics 数组 动态规划 👍 2276 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumProductSubarray().new Solution();
        solution.maxProduct(new int[]{0, 10, 10, 10, 10, 10, 10, 10, 10, 10, -10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 0});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            int len = nums.length;
            java.math.BigInteger[] dpMax = new java.math.BigInteger[len];
            java.math.BigInteger[] dpMin = new java.math.BigInteger[len];
            dpMax[0] = java.math.BigInteger.valueOf(nums[0]);
            dpMin[0] = java.math.BigInteger.valueOf(nums[0]);
            for (int i = 1; i < len; i++) {
                dpMax[i] = java.math.BigInteger.valueOf(nums[i]).max(dpMax[i - 1].multiply(java.math.BigInteger.valueOf(nums[i])).max(dpMin[i - 1].multiply(java.math.BigInteger.valueOf(nums[i]))));
                dpMin[i] = java.math.BigInteger.valueOf(nums[i]).min(dpMax[i - 1].multiply(java.math.BigInteger.valueOf(nums[i])).min(dpMin[i - 1].multiply(java.math.BigInteger.valueOf(nums[i]))));
            }
            java.math.BigInteger res = dpMax[0];
            for (int i = 1; i < len; i++) {
                res = res.max(dpMax[i]);
            }
            return res.intValue();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}