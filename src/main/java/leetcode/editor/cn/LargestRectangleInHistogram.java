//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
//
// Related Topics 栈 数组 单调栈 👍 2741 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
        System.out.println(solution.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        我们用从栈底往栈顶递增的单调栈来维护每根木条向右延伸的位置。当我们遇到一根新的木条时，会弹出栈中所有比它长的值。对于这些值来说，这根新的木条就是它的右边界。
//        比如[5,6,2]，一开始读到5，入栈。接着读到6，由于6大于栈顶的5，所以6入栈。最后读到2，由于2比6小，所以6出栈，对于6来说，2的位置就是它的右侧边界。
//        正是由于2比它小，所以它才需要出栈，也说明了2的左侧的元素都比6来的大，否则6在之前就应该出栈了。同理，2也是5的右侧边界。

        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            int[] left = new int[n], right = new int[n];
            Arrays.fill(right, n - 1);
            Deque<Integer> stack = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && heights[i] < heights[stack.getLast()]) {
                    Integer last = stack.removeLast();
                    right[last] = i - 1;
                }
                stack.addLast(i);
            }
            stack.clear();
            for (int i = n - 1; i >= 0; i--) {
                while (!stack.isEmpty() && heights[i] < heights[stack.getLast()]) {
                    Integer last = stack.removeLast();
                    left[last] = i + 1;
                }
                stack.addLast(i);
            }
            int max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, (right[i] - left[i] + 1) * heights[i]);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}