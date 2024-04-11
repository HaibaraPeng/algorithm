//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 分治 👍 7080 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[]{0, 0, 0, 0, 0}, new int[]{-1, 0, 0, 0, 0, 0, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len1 = nums1.length, len2 = nums2.length;
            if (len1 == 0 && len2 == 1) {
                return nums2[0];
            } else if (len2 == 0 && len1 == 1) {
                return nums1[0];
            }
            boolean odd = (len1 + len2) % 2 == 1;
            int i1 = 0, i2 = 0, index = 0, left = 0, right = 0;
            while (index < (len1 + len2) / 2) {
                if (i1 == nums1.length) {
                    left = nums2[i2];
                    right = nums2[++i2];
                } else if (i2 == nums2.length) {
                    left = nums1[i1];
                    right = nums1[++i1];
                } else if (nums1[i1] < nums2[i2]) {
                    left = nums1[i1++];
                    right = i1 == nums1.length ? nums2[i2] : Math.min(nums1[i1], nums2[i2]);
                } else {
                    left = nums2[i2++];
                    right = i2 == nums2.length ? nums1[i1] : Math.min(nums1[i1], nums2[i2]);
                }
                index++;
            }
            return odd ? right : (left + right) / 2.0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}