//给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。 
//
// 如果不存在这样的子字符串，则返回 0。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aaabb", k = 3
//输出：3
//解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
// 
//
// 示例 2： 
//
// 
//输入：s = "ababbc", k = 2
//输出：5
//解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由小写英文字母组成 
// 1 <= k <= 10⁵ 
// 
//
// Related Topics 哈希表 字符串 分治 滑动窗口 👍 935 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithAtLeastKRepeatingCharacters().new Solution();
        solution.longestSubstring("aaabb", 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSubstring(String s, int k) {
            int n = s.length();
            return dfs(s, 0, n - 1, k);
        }

        public int dfs(String s, int l, int r, int k) {
            int[] cnt = new int[26];
            for (int i = l; i <= r; i++) {
                cnt[s.charAt(i) - 'a']++;
            }

            char split = 0;
            for (int i = 0; i < 26; i++) {
                if (cnt[i] > 0 && cnt[i] < k) {
                    split = (char) (i + 'a');
                    break;
                }
            }
            if (split == 0) {
                return r - l + 1;
            }

            int i = l;
            int ret = 0;
            while (i <= r) {
                while (i <= r && s.charAt(i) == split) {
                    i++;
                }
                if (i > r) {
                    break;
                }
                int start = i;
                while (i <= r && s.charAt(i) != split) {
                    i++;
                }

                int length = dfs(s, start, i - 1, k);
                ret = Math.max(ret, length);
            }
            return ret;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}