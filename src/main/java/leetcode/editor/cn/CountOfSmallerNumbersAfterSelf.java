//给你一个整数数组 nums ，按要求返回一个新数组 counts 。数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于 
//nums[i] 的元素的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,6,1]
//输出：[2,1,1,0] 
//解释：
//5 的右侧有 2 个更小的元素 (2 和 1)
//2 的右侧仅有 1 个更小的元素 (1)
//6 的右侧有 1 个更小的元素 (1)
//1 的右侧有 0 个更小的元素
// 
//
// 示例 2： 
//
// 
//输入：nums = [-1]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：nums = [-1,-1]
//输出：[0,0]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 1097 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        Solution solution = new CountOfSmallerNumbersAfterSelf().new Solution();
        solution.countSmaller(new int[]{5, 2, 6, 1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 用于存储结果
        private int[] result;
        // 用于存储当前元素的索引
        private int[] indices;

        public List<Integer> countSmaller(int[] nums) {
            int n = nums.length;
            result = new int[n];
            indices = new int[n];

            // 初始化索引数组
            for (int i = 0; i < n; i++) {
                indices[i] = i;
            }

            // 进行归并排序并计算结果
            mergeSort(nums, 0, n - 1);

            // 将结果转换为列表并返回
            List<Integer> counts = new ArrayList<>();
            for (int count : result) {
                counts.add(count);
            }
            return counts;
        }

        // 归并排序
        private void mergeSort(int[] nums, int left, int right) {
            if (left >= right) return;

            int mid = left + (right - left) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }

        // 归并过程并统计右侧较小元素的数量
        private void merge(int[] nums, int left, int mid, int right) {
            int[] temp = new int[right - left + 1];
            int[] tempIndices = new int[right - left + 1];
            int i = left, j = mid + 1, k = 0;

            while (i <= mid && j <= right) {
                if (nums[indices[i]] <= nums[indices[j]]) {
                    tempIndices[k] = indices[j];
                    temp[k++] = nums[indices[j++]];
                } else {
                    // 当前左边的元素比右边的大，说明右边的所有当前元素都是小于的
                    result[indices[i]] += right - j + 1;
                    tempIndices[k] = indices[i];
                    temp[k++] = nums[indices[i++]];
                }
            }

            while (i <= mid) {
                tempIndices[k] = indices[i];
                temp[k++] = nums[indices[i++]];
            }

            while (j <= right) {
                tempIndices[k] = indices[j];
                temp[k++] = nums[indices[j++]];
            }

            for (i = 0; i < temp.length; i++) {
                indices[left + i] = tempIndices[i];
                nums[left + i] = temp[i];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}