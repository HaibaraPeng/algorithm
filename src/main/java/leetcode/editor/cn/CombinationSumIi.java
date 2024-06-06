//Given a collection of candidate numbers (candidates) and a target number (
//target), find all unique combinations in candidates where the candidate numbers sum 
//to target. 
//
// Each number in candidates may only be used once in the combination. 
//
// Note: The solution set must not contain duplicate combinations. 
//
// 
// Example 1: 
//
// 
//Input: candidates = [10,1,2,7,6,1,5], target = 8
//Output: 
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,5,2,1,2], target = 5
//Output: 
//[
//[1,2,2],
//[5]
//]
// 
//
// 
// Constraints: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
//
// Related Topics 数组 回溯 👍 1549 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.*;

public class CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();
        solution.combinationSum2(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 30);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Set<List<Integer>> res = new HashSet<>();
            List<Integer> array = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();
            for (int candidate : candidates) {
                map.put(candidate, map.getOrDefault(candidate, 0) + 1);
            }
            List<Integer> list = new ArrayList<>(map.keySet());
            Collections.sort(list);
            dfs(map, list, target, list.size() - 1, array, res);
            return new ArrayList<>(res);
        }

        private void dfs(Map<Integer, Integer> map, List<Integer> list, int target, int i, List<Integer> array, Set<List<Integer>> res) {
            if (target < 0) {
                return;
            }
            if (target == 0) {
                res.add(new ArrayList<>(array));
                return;
            }
            for (; i >= 0; i--) {
                Integer value = list.get(i);
                if (list.get(i) <= target && map.get(value) > 0) {
                    array.add(value);
                    map.put(value, map.get(value) - 1);
                    dfs(map, list, target - value, i, array, res);
                    array.remove(array.size() - 1);
                    map.put(value, map.get(value) + 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}