//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 2518 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            quickSort(nums, 0, nums.length - 1);
            return nums[nums.length - k];
        }

        private void quickSort(int[] nums, int left, int right) {
            if (left >= right) return;
            int pivot = partition(nums, left, right);
            quickSort(nums, left, pivot - 1);
            quickSort(nums, pivot + 1, right);
        }

        private int partition(int[] nums, int left, int right) {
            int pivot = left + (int) (Math.random() * (right - left + 1));
            swap(nums, pivot, right);
            pivot = left - 1;
            for (int i = left; i < right + 1; i++) {
                if (nums[i] <= nums[right]) {
                    pivot++;
                    if (pivot < i) {
                        swap(nums, pivot, i);
                    }
                }
            }
            return pivot;
        }

        private void swap(int[] nums, int index1, int index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}