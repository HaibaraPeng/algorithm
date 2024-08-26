//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回 滑动窗口中的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
//
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 2856 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            int[] ans = new int[n - k + 1];
            Deque<Integer> deque = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {
                // 移除不在窗口范围内的元素
                if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                    deque.pollFirst();
                }

                // 移除小于当前元素的所有元素，因为它们不再可能是最大值
                while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                    deque.pollLast();
                }

                // 将当前元素的索引加入到队列
                deque.offerLast(i);

                // 窗口形成后，取最大值（即队列头部的元素）
                if (i >= k - 1) {
                    ans[i - k + 1] = nums[deque.peekFirst()];
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}