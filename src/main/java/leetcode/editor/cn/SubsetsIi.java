//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的 子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 位运算 数组 回溯 👍 1215 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.*;

public class SubsetsIi {
    public static void main(String[] args) {
        Solution solution = new SubsetsIi().new Solution();
        solution.subsetsWithDup(new int[]{1, 2, 2});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Set<List<Integer>> res = new HashSet<>();
            Arrays.sort(nums);
            int n = nums.length;
            dfs(nums, 0, n, new ArrayList<>(), res);
            return new ArrayList<>(res);
        }

        private void dfs(int[] nums, int index, int n, ArrayList<Integer> list, Set<List<Integer>> res) {
            res.add(new ArrayList<>(list));
            for (int i = index; i < n; i++) {
                list.add(nums[i]);
                dfs(nums, i + 1, n, list, res);
                list.remove(list.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}