//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 数组 回溯 👍 1573 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
        solution.permuteUnique(new int[]{1, 1, 2});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            Set<List<Integer>> res = new HashSet<>();
            List<Integer> list = new ArrayList<>();
            List<Integer> arr = new ArrayList<>();
            for (int num : nums) {
                arr.add(num);
            }
            dfs(res, list, arr);
            return new ArrayList<>(res);
        }

        private void dfs(Set<List<Integer>> res, List<Integer> list, List<Integer> arr) {
            if (arr.isEmpty()) {
                res.add(new ArrayList<>(list));
            }
            for (int i = 0; i < arr.size(); i++) {
                Integer value = arr.get(i);
                list.add(value);
                arr.remove(i);
                dfs(res, list, arr);
                list.remove(list.size() - 1);
                arr.add(i, value);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}