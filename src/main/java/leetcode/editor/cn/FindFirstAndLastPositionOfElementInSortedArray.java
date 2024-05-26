//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 2703 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        solution.searchRange(new int[]{}, 6);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] res = new int[]{-1, -1};
            searchRange(nums, 0, nums.length - 1, target, res);
            return res;
        }

        public void searchRange(int[] nums, int left, int right, int target, int[] res) {
            int index = find(nums, left, right, target);
            if (index != -1) {
                if (res[0] == -1) {
                    res[0] = index;
                    res[1] = index;
                    searchRange(nums, left, index - 1, target, res);
                    searchRange(nums, index + 1, right, target, res);
                } else if (res[0] > index) {
                    res[0] = index;
                    searchRange(nums, left, index - 1, target, res);
                } else if (res[1] < index) {
                    res[1] = index;
                    searchRange(nums, index + 1, right, target, res);
                }
            }
        }

        public int find(int[] nums, int left, int right, int target) {
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}