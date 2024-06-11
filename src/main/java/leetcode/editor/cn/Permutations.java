//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 2896 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        solution.permute(new int[]{1, 2, 3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            List<Integer> arr = new ArrayList<>();
            for (int num : nums) {
                arr.add(num);
            }
            dfs(res, list, arr);
            return res;
        }

        private void dfs(List<List<Integer>> res, List<Integer> list, List<Integer> arr) {
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