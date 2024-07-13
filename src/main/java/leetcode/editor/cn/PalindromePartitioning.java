//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 1808 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioning().new Solution();
        solution.partition("abbab");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                dfs(s, 0, i, new ArrayList<>(), res);
            }
            return res;
        }

        private void dfs(String s, int left, int right, ArrayList<String> list, List<List<String>> res) {
            if (right == s.length()) {
                return;
            }
            if (isPalindrome(s, left, right)) {
                list.add(s.substring(left, right + 1));
                if (right == s.length() - 1) {
                    res.add(new ArrayList<>(list));
                    return;
                }
                for (int i = right + 1; i < s.length(); i++) {
                    int preSize = list.size();
                    dfs(s, right + 1, i, list, res);
                    if (list.size() > preSize) {
                        list.remove(list.size() - 1);
                    }
                }
            }
        }

        private boolean isPalindrome(String s, int left, int right) {
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}