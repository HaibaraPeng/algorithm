//给定两个数组 nums1 和 nums2 ，返回 它们的 交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
//解释：[4,9] 也是可通过的
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 1000 
// 
//
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 941 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[]{};
            Set<Integer> set = new HashSet<>();
            for (int i : nums1) {
                set.add(i);
            }
            Set<Integer> intersectionSet = new HashSet<>();
            for (int i : nums2) {
                if (set.contains(i)) intersectionSet.add(i);
            }
            int[] res = new int[intersectionSet.size()];
            int index = 0;
            for (Integer integer : intersectionSet) {
                res[index++] = integer;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}