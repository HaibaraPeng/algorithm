//给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。 
//
// 你可以假设所有输入数组都可以得到满足题目要求的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,1,1,6,4]
//输出：[1,6,1,5,1,4]
//解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,3,2,2,3,1]
//输出：[2,3,1,3,1,2]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// 0 <= nums[i] <= 5000 
// 题目数据保证，对于给定的输入 nums ，总能产生满足题目要求的结果 
// 
//
// 
//
// 进阶：你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？ 
//
// Related Topics 贪心 数组 分治 快速选择 排序 👍 598 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

public class WiggleSortIi {
    public static void main(String[] args) {
        Solution solution = new WiggleSortIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void wiggleSort(int[] nums) {
            int[] bucket = new int[5001];
            for (int num : nums) bucket[num]++;
            int len = nums.length;
            int small, big;
            //穿插数字时的上界
            // 总长度为奇数时，“小 大 小 大 小”边界左右都为较小的数；
            // 总长度为偶数时，“小 大 小 大”边界左为较小的数，边界右为较大的数
            if ((len & 1) == 1) {
                small = len - 1;
                big = len - 2;
            } else {
                small = len - 2;
                big = len - 1;
            }
            int j = 5000;
            //从后往前，将桶中数字穿插到数组中，后界为j
            // 桶中大的数字在后面，小的数字在前面，所以先取出较大的数字，再取出较小的数字
            // 先将桶中的较大的数字穿插放在nums中
            for (int i = 1; i <= big; i += 2) {
                while (bucket[j] == 0)
                    j--;
                //找到不为0的桶
                nums[i] = j;
                bucket[j]--;
            }
            //再将桶中的较小的数字穿插放在nums中
            for (int i = 0; i <= small; i += 2) {
                while (bucket[j] == 0) j--;
                //找到不为0的桶
                nums[i] = j;
                bucket[j]--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}